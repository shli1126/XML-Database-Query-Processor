package main;

import java.io.File;
import java.io.IOException;

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

import main.antlr.XQueryLexer;
import main.antlr.XQueryParser;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting the program...");

        if (args.length < 3) {
            System.err.println("Invalid number of arguments");
            return;
        }

        String inputXmlFile = args[0];
        String inputQueryFile = args[1];
        String outputXmlFile = args[2];

        String xqueryQuery = readQueryFromFile(inputQueryFile).trim();

        ParseTree parseTree = parseXQuery(xqueryQuery);

        // System.out.println("Parse Tree: " + parseTree.toStringTree());
        Document document = loadXmlDocument(inputXmlFile);
        if (document == null) {
            System.err.println("Failed to load XML document: " + inputXmlFile);
            return;
        }
        XQueryEvaluator evaluator = new XQueryEvaluator(document); // Changed from XPathEvaluator
        List<Node> result = evaluator.visit(parseTree);

        // Convert DOM nodes back to XML
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

    private static Document loadXmlDocument(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new File(filePath));
        } catch (Exception e) {
            System.err.println("Error loading XML document: " + filePath);
            e.printStackTrace();
            return null;
        }
    }

    private static ParseTree parseXQuery(String xqueryQuery) {
        CharStream inputStream = CharStreams.fromString(xqueryQuery);
        XQueryLexer lexer = new XQueryLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);
        return parser.xq();     // xquery root rule
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