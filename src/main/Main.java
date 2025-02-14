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

import main.antlr.XPathLexer;
import main.antlr.XPathParser;

public class Main {

    public static void main(String[] args) {
        // Find all persons in the play:
        // String xpathQuery = "doc(\"j_caesar.xml\")//PERSONA";

        // Find the scenes in which CAESAR speaks
        // String xpathQuery = "doc(\"j_caesar.xml\")//SCENE[SPEECH/SPEAKER/text() = \"CAESAR\"]";

        //Find the acts containing some scene in which both CAESAR and BRUTUS speak
        // String xpathQuery = "doc(\"j_caesar.xml\")//ACT[SCENE [SPEECH/SPEAKER/text() = \"CAESAR\" and SPEECH/SPEAKER/text() = \"BRUTUS\"]]";
        // String xpathQuery = "doc(\"j_caesar.xml\")//ACT[SCENE [SPEECH/SPEAKER/text() = \"CAESAR\"][SPEECH/SPEAKER/text() = \"BRUTUS\"]]";

        //Find the acts in which CAESAR no longer appears
        // String xpathQuery = "doc(\"j_caesar.xml\")//ACT[not .//SPEAKER/text() = \"CAESAR\"]";

        System.out.println("Starting program...");

        if (args.length < 3) {
            System.err.println("Invalid number of arguments");
            return;
        }

        String inputXmlFile = args[0];
        String inputQueryFile = args[1];
        String outputXmlFile = args[2];

        String xpathQuery = readQueryFromFile(inputQueryFile).trim();

        ParseTree parseTree = parseXPath(xpathQuery);

        // System.out.println("Parse Tree: " + parseTree.toStringTree());

        XPathEvaluator evaluator = new XPathEvaluator();
        List<Node> result = evaluator.visit(parseTree);

        // convert dom nodes back to xml
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