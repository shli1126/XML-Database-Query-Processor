
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

public class XPathMainTest {

    private static final String INPUT_FILE = "src/main/java/resources/j_caesar.xml";
    private static final String OUTPUT_FILE = "output/result.xml";

    @Test
    public void testLoadAndSaveXml() {
        Document xmlDocument = loadXmlDocument(INPUT_FILE);
        assertNotNull(xmlDocument, "Failed to load XML file!");

        saveToXml(xmlDocument, OUTPUT_FILE);

        File resultFile = new File(OUTPUT_FILE);
        assertTrue(resultFile.exists(), "Result XML file was not created!");

        System.out.println("Test Passed: XML successfully loaded and saved.");
    }

    private static Document loadXmlDocument(String filePath) {
        try {
            File file = new File(filePath);
            System.out.println("Looking for file at: " + file.getAbsolutePath());

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();
            return document;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void saveToXml(Document doc, String outputFilename) {
        try {
            File outputFile = new File(outputFilename);
            outputFile.getParentFile().mkdirs(); // Ensure directories exist

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult fileResult = new StreamResult(outputFile);

            transformer.transform(source, fileResult);
            System.out.println("Saved XML to: " + outputFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}