package impl.XPath;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import antlr.XPath.XPathBaseVisitor;

public class XPathEvaluator extends XPathBaseVisitor<List<Node>> {

    private Document document;

    // no need for constructor, default rule is ap, starts with doc("filename.xml")
    // TODO
    private void setDocument(String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(fileName);
        } catch (Exception e) {
            throw new RuntimeException("Error setting the document: " + fileName, e);

        }
    }

    public void getAllDescendants(Node node, Set<Node> descendants) {
        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node curNode = nodes.item(i);
            descendants.add(curNode);
            getAllDescendants(curNode, descendants);
        }
    }

    public List<Node> Eval_A(ParseTree t) {

        String op = t.getChild(1).getText();
        ParseTree rp = t.getChild(2);

        Node root = document.getDocumentElement();

        if (op.equals("/")) {
            return Eval_R(rp, root);
        } else if (op.equals("//")) {
            Set<Node> nodes = new HashSet<>();
            nodes.add(root);
            getAllDescendants(root, nodes);

            List<Node> res = new ArrayList<>();
            for (Node n : nodes) {
                res.addAll(Eval_R(rp, n));
            }
            return res;
        }
        return new ArrayList<>();
    }

    public List<Node> Eval_R(ParseTree t, Node n) {

        List<Node> res = new ArrayList<>();

        // case  TAGNAME | '*' | '.' | '..' | 'text()'
        if (t.getChildCount() == 1) {
            // TAGNAME
            if (t.getText().matches("[a-zA-Z_][a-zA-Z0-9_-]*")) {
                String tagName = t.getChild(0).getText();
                NodeList nodes = n.getChildNodes();
                for (int i = 0; i < nodes.getLength(); i++) {
                    Node node = nodes.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals(tagName)){
                        res.add(node);
                    }
                }
            }
            // '*'
            else if (t.getChild(0).getText().equals("*")) {
                NodeList nodes = n.getChildNodes();
                for (int i = 0; i < nodes.getLength(); i++) {
                    res.add(nodes.item(i));
                }
            }
            // '.'
            else if (t.getChild(0).getText().equals(".")) {
                res.add(n);
            }
            // '..'
            else if (t.getChild(0).getText().equals("..")) {
                Node parent = n.getParentNode();
                if (parent != null ){
                    res.add(parent);
                }
            }
            // 'text()'
            else if (t.getChild(0).getText().equals("..")) {
                
            }

            

        } else {
            return null;
        }
        return null;

    }


}
