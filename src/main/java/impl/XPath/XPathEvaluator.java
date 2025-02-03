package impl.XPath;

import antlr.XPath.XPathBaseVisitor;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.List;

public class XPathEvaluator extends XPathBaseVisitor<List<Node>>{
    private Document document;

    // no need for constructor, default rule is ap, starts with doc("filename.xml")
    // TODO

}
