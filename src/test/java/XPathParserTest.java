import antlr.XPath.XPathLexer;
import antlr.XPath.XPathParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class XPathParserTest {

    private ParseTree parseXPath(String input) {
        CharStream inputStream = CharStreams.fromString(input);
        XPathLexer lexer = new XPathLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XPathParser parser = new XPathParser(tokens);

        parser.removeErrorListeners();  // remove the default listener
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                    int line, int charPositionInLine,
                                    String msg, RecognitionException e) {
                throw new RuntimeException("Syntax Error at line " + line + ":" + charPositionInLine + " " + msg);
            }
        });

        return parser.ap();     // absolute path as standard rule
    }

    @Test
    public void testSimpleAbsolutePath() {
        ParseTree tree = parseXPath("doc(\"j_caesar.xml\")/ACT/SCENE");
        assertNotNull(tree);
        assertTrue(tree.toStringTree().contains("ACT"));
        assertTrue(tree.toStringTree().contains("SCENE"));
    }

    @Test
    public void testXPathWithFilter() {
        ParseTree tree = parseXPath("doc(\"j_caesar.xml\")/ACT[SCENE/SPEECH/text() = \"CAESAR\"]");
        assertNotNull(tree);
        assertTrue(tree.toStringTree().contains("CAESAR"));
    }


    @Test
    public void testInvalidXPath() {
        assertThrows(RuntimeException.class, () -> parseXPath("SCENE//"));
    }
}
