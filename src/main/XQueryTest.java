package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import main.antlr.XPathLexer;
import main.antlr.XPathParser;
import main.XPathEvaluator;

public class XQueryTest {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Usage: java -cp \"classes;lib/*\" main.XQueryTest <XML_FILE> <QUERY_FILE> <RESULT_XML>");
            return;
        }

        // Read command-line arguments
        String xmlFilePath = args[0];         // XML input file
        String queryFilePath = args[1];       // XQuery input file
        String resultXmlPath = args[2];       // Path to save output XML

        System.out.println("\n=== Running Test for " + queryFilePath + " ===");

        // Read query from file
        String xquery = readQueryFromFile(queryFilePath);
        if (xquery.isEmpty()) {
            System.err.println("Error: Query file is empty or missing.");
            return;
        }

        // Load XML document
        Document document = loadXmlDocument(xmlFilePath);
        if (document == null) {
            System.err.println("Error: Failed to load XML document.");
            return;
        }

        // Parse XQuery
        ParseTree parseTree = parseXPath(xquery);
        if (parseTree == null) {
            System.err.println("Error: Failed to parse XQuery.");
            return;
        }

        // Evaluate the query
        XPathEvaluator evaluator = new XPathEvaluator(document, xmlFilePath);
        List<Node> results = evaluator.visit(parseTree);

        // Save results to XML
        saveToXml(results, resultXmlPath);
    }

    // Read query from file
    private static String readQueryFromFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath))).trim();
        } catch (IOException e) {
            System.err.println("Error reading query file: " + filePath);
            e.printStackTrace();
            return "";
        }
    }

    // Load XML document
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

    // Parse XQuery
    private static ParseTree parseXPath(String xquery) {
        try {
            CharStream inputStream = CharStreams.fromString(xquery);
            XPathLexer lexer = new XPathLexer(inputStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            XPathParser parser = new XPathParser(tokens);
            return parser.xq();
        } catch (Exception e) {
            System.err.println("Error parsing XQuery.");
            e.printStackTrace();
            return null;
        }
    }

    // Save results to XML
    private static void saveToXml(List<Node> results, String outputFilename) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document outputDoc = builder.newDocument();

            for (Node node : results) {
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

            System.out.println("[INFO] Saved result to: " + outputFilename);
        } catch (Exception e) {
            System.err.println("Error saving output XML.");
            e.printStackTrace();
        }
    }
}
