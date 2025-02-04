package impl.XPath;

import java.io.File;
import java.util.List;

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

import antlr.XPath.XPathLexer;
import antlr.XPath.XPathParser;


public class XPathMain {
    public static void main(String[] args) {
        String xpathQuery = "doc(\"j_caesar.xml\")//SCENE[SPEECH/SPEAKER/text() = \"CAESAR\"]";
        String outputFilename = "result.xml";

        ParseTree parseTree = parseXPath(xpathQuery);

        // !!!debug
        System.out.println("Parse Tree: " + parseTree.toStringTree());

        XPathEvaluator evaluator = new XPathEvaluator();
        List<Node> result = evaluator.visit(parseTree);

        // convert dom nodes back to xml
        saveToXml(result, outputFilename);
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
