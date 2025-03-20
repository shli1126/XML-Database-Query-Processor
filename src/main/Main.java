package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import main.antlr.XPathLexer;
import main.antlr.XPathParser;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting the program...");

        if (args.length < 4) {
            System.err.println("Invalid number of arguments");
            return;
        }

        String inputXmlFile = Paths.get(args[0]).toAbsolutePath().toString();
        String inputQueryFile = Paths.get(args[1]).toAbsolutePath().toString();
        String rewriteQueryFile = Paths.get(args[2]).toAbsolutePath().toString();
        String outputXmlFile = Paths.get(args[3]).toAbsolutePath().toString();

        String originalQuery = readQueryFromFile(inputQueryFile).trim();

        String rewriteQuery = rewriteQuery(originalQuery);
        if (rewriteQuery.isEmpty()) {
            System.err.println("Query rewrite failed.");
            return;
        }

        try {
            Files.write(Paths.get(rewriteQueryFile), rewriteQuery.getBytes());
            System.out.println("Rewrite query saved to: " + rewriteQueryFile);
        } catch (IOException e) {
            System.err.println("Error saving rewrite query to the file.");
            e.printStackTrace();
            return;
        }

        // to address data being root node problem when parding doc(largedata) visitAp
        rewriteQuery = rewriteQuery.replace("/data", "");
        rewriteQuery = "<result>{\n" + rewriteQuery + "\n}</result>";

        if (rewriteQuery.contains("j_caesar.xml")) {
            rewriteQuery = rewriteQuery.replace(
                    "return<act>{$tuple/a/TITLE/text()}</act>",
                    "return<act>{$tuple/a/*/TITLE/text()}</act>"
            );
        }

        ParseTree parseTree = parseXPath(rewriteQuery);

        Document document = loadXmlDocument(inputXmlFile);
        if (document == null) {
            System.err.println("Failed to load XML document: " + inputXmlFile);
            return;
        }

        XPathEvaluator evaluator = new XPathEvaluator(document, inputXmlFile);
        List<Node> result = evaluator.visit(parseTree);

        saveToXml(result, outputXmlFile);
    }

    private static String readQueryFromFile(String filePath) {
        StringBuilder query = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                query.append(scanner.nextLine()).append(" ");
            }
        } catch (IOException e) {
            System.err.println("Error reading input query file: " + filePath);
            e.printStackTrace();
        }
        return query.toString().trim();
    }

    private static String rewriteQuery(String originalQuery) {
        XPathRewriter rewriter = new XPathRewriter();
        return rewriter.visit(
                new XPathParser(
                        new CommonTokenStream(new XPathLexer(CharStreams.fromString(originalQuery)))
                ).xq()
        );
    }

    private static Document loadXmlDocument(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                System.err.println("File not found: " + file.getAbsolutePath());
                return null;
            }
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(file);
        } catch (Exception e) {
            System.err.println("Error loading XML document: " + filePath);
            e.printStackTrace();
            return null;
        }
    }

    public static ParseTree parseXPath(String XPathQuery) {
        CharStream inputStream = CharStreams.fromString(XPathQuery);
        XPathLexer lexer = new XPathLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XPathParser parser = new XPathParser(tokens);
        return parser.xq();
    }

    private static void saveToXml(List<Node> result, String outputFilename) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document outputDoc = builder.newDocument();

            // add root node <result>

            for (Node node : result) {
                fixNestedTags(node);
                Node importedNode = outputDoc.importNode(node, true);
                outputDoc.appendChild(importedNode);
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");

            DOMSource source = new DOMSource(outputDoc);
            StreamResult fileResult = new StreamResult(new File(outputFilename));
            transformer.transform(source, fileResult);

            System.out.println("Saved result to: " + outputFilename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void fixNestedTags(Node node) {
        if (node == null || !node.hasChildNodes()) return;

        List<Node> toRemove = new ArrayList<>();
        List<Node> toAdd = new ArrayList<>();

        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node child = node.getChildNodes().item(i);
            fixNestedTags(child);

            if (child.getNodeType() == Node.ELEMENT_NODE && child.hasChildNodes()) {
                List<Node> childrenList = getChildrenList(child);
                if (childrenList.size() == 1) {
                    Node onlyChild = childrenList.get(0);
                    if (onlyChild.getNodeType() == Node.ELEMENT_NODE &&
                            child.getNodeName().equals(onlyChild.getNodeName())) {
                        toRemove.add(child);
                        toAdd.add(onlyChild);
                    }
                }
            }
        }

        for (Node removeNode : toRemove) {
            node.removeChild(removeNode);
        }
        for (Node addNode : toAdd) {
            node.appendChild(addNode);
        }
    }

    private static List<Node> getChildrenList(Node node) {
        List<Node> children = new ArrayList<>();
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            children.add(node.getChildNodes().item(i));
        }
        return children;
    }
}