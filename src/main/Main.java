package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
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
import org.w3c.dom.Node;

import main.antlr.XPathLexer;
import main.antlr.XPathParser;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting program...");

        if (args.length < 3) {
            System.err.println("Invalid number of arguments");
            return;
        }

        String inputXmlFile = Paths.get(args[0]).toAbsolutePath().toString();
        String inputQueryFile = Paths.get(args[1]).toAbsolutePath().toString();
        String outputXmlFile = Paths.get(args[2]).toAbsolutePath().toString();

        String xpathQuery = readQueryFromFile(inputQueryFile).trim();

        ParseTree parseTree = parseXPath(xpathQuery);

        XPathEvaluator evaluator = new XPathEvaluator(inputXmlFile);
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

    private static ParseTree parseXPath(String xpathQuery) {
        CharStream inputStream = CharStreams.fromString(xpathQuery);
        XPathLexer lexer = new XPathLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XPathParser parser = new XPathParser(tokens);
        return parser.ap();     // xpath root rule
    }

    private static void saveToXml(List<Node> result, String outputFilename) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document outputDoc = builder.newDocument();

            Node root = outputDoc.createElement("Results");
            outputDoc.appendChild(root);

            for (Node node : result) {
                Node importedNode = outputDoc.importNode(node, true);
                root.appendChild(importedNode);
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(outputDoc);
            StreamResult fileResult = new StreamResult(new File(outputFilename));
            transformer.transform(source, fileResult);

            System.out.println("Saved result to: " + outputFilename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}