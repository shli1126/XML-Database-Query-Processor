package main;

import main.antlr.XPathBaseVisitor;
import main.antlr.XPathParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class XPathEvaluator extends XPathBaseVisitor<List<Node>> {

    private final String inputXmlFile;

    public XPathEvaluator(String inputXmlFile) {
        this.inputXmlFile = inputXmlFile;
    }

    @Override
    public List<Node> visitAp(XPathParser.ApContext ctx) {
        String fileName = ctx.getChild(0).getChild(2).getText();
        fileName = fileName.substring(1, fileName.length() - 1);

        if (!new File(fileName).exists()) {
            fileName = inputXmlFile;
        }

        Document document;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return Eval_A(ctx, document.getDocumentElement());
    }

    public List<Node> Eval_A(ParseTree t, Node n) {
        String op = t.getChild(1).getText();
        ParseTree rp = t.getChild(2);

        if (op.equals("/")) {
            return Eval_R(rp, n);
        } else if (op.equals("//")) {
            Set<Node> nodes = new HashSet<>();
            nodes.add(n);
            getAllDescendants(n, nodes);

            List<Node> res = new ArrayList<>();
            for (Node node : nodes) {
                res.addAll(Eval_R(rp, node));
            }
            return res;
        }
        return new ArrayList<>();
    }

    public List<Node> Eval_R(ParseTree t, Node n) {
        List<Node> res = new ArrayList<>();
        if (t == null) {
            return res;
        }
        if (t.getChildCount() == 1) {
            if (t.getText().matches("[a-zA-Z_][a-zA-Z0-9_-]*")) {
                String tagName = t.getChild(0).getText();
                NodeList nodes = n.getChildNodes();
                for (int i = 0; i < nodes.getLength(); i++) {
                    Node node = nodes.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals(tagName)) {
                        res.add(node);
                    }
                }
            } else if (t.getText().equals("*")) {
                NodeList nodes = n.getChildNodes();
                for (int i = 0; i < nodes.getLength(); i++) {
                    res.add(nodes.item(i));
                }
            } else if (t.getText().equals(".")) {
                res.add(n);
            } else if (t.getText().equals("..")) {
                Node parent = n.getParentNode();
                if (parent != null) {
                    res.add(parent);
                }
            } else if (t.getText().equals("text()")) {
                NodeList nodes = n.getChildNodes();
                for (int i = 0; i < nodes.getLength(); i++) {
                    if (nodes.item(i).getNodeType() == Node.TEXT_NODE) {
                        res.add(nodes.item(i));
                    }
                }
            }
        } else {
            if (t.getChildCount() == 2 && t.getChild(0).getText().equals("@")) {
                if (n.getNodeType() == Node.ELEMENT_NODE && n.hasAttributes()) {
                    String attName = t.getChild(1).getText();
                    Node attNode = ((org.w3c.dom.Element) n).getAttributeNode(attName);
                    if (attNode != null) {
                        res.add(attNode);
                    }
                }
            } else if (t.getChildCount() == 3 && "(".equals(t.getChild(0).getText())
                    && ")".equals(t.getChild(2).getText())) {
                res.addAll(Eval_R(t.getChild(1), n));
            } else if (t.getChildCount() == 3) {
                ParseTree left = t.getChild(0);
                ParseTree op = t.getChild(1);
                ParseTree right = t.getChild(2);
                switch (op.getText()) {
                    case "/" -> {
                        List<Node> nodes = Eval_R(left, n);
                        for (Node node : nodes) {
                            res.addAll(Eval_R(right, node));
                        }
                        res = res.stream().distinct().collect(Collectors.toList());
                    }
                    case "//" -> {
                        List<Node> nodes = Eval_R(left, n);
                        Set<Node> descendants = new HashSet<>();
                        for (Node node : nodes) {
                            descendants.add(node);
                            getAllDescendants(node, descendants);
                        }
                        for (Node node : descendants) {
                            res.addAll(Eval_R(right, node));
                        }
                        res = res.stream().distinct().collect(Collectors.toList());
                    }
                    case "," -> {
                        res.addAll(Eval_R(left, n));
                        res.addAll(Eval_R(right, n));
                    }
                    default -> {
                    }
                }
            } else if (t.getChildCount() == 4
                    && t.getChild(1).getText().equals("[")
                    && t.getChild(3).getText().equals("]")) {
                ParseTree rp = t.getChild(0);
                ParseTree filter = t.getChild(2);
                List<Node> nodes = Eval_R(rp, n);
                for (Node node : nodes) {
                    if (Eval_F(filter, node)) {
                        res.add(node);
                    }
                }
            }
        }
        return res;
    }

    public Boolean Eval_F(ParseTree t, Node n) {
        if (t.getChildCount() == 1) {
            List<Node> res = Eval_R(t.getChild(0), n);
            return !res.isEmpty();
        } else if (t.getChildCount() == 2) {
            return !Eval_F(t.getChild(1), n);
        } else if (t.getChildCount() == 3) {

            String op = t.getChild(1).getText();

            if (t.getChild(2).getText().startsWith("'") || t.getChild(2).getText().startsWith("\"")) {
                String target = t.getChild(2).getText();
                target = target.substring(1, target.length() - 1);
                List<Node> nodes = Eval_R(t.getChild(0), n);
                for (Node node : nodes) {
                    if (node.getTextContent().equals(target)) {
                        return true;
                    }
                }
                return false;
            }
            if (t.getChild(1).getText().equals("and")) {
                return Eval_F(t.getChild(0), n) && Eval_F(t.getChild(2), n);
            }
            if (t.getChild(1).getText().equals("or")) {
                return Eval_F(t.getChild(0), n) || Eval_F(t.getChild(2), n);
            }
            if (t.getChild(0).getText().equals("(") && t.getChild(2).getText().equals(")")) {
                return Eval_F(t.getChild(1), n);
            }

            List<Node> left = Eval_R(t.getChild(0), n);
            List<Node> right = Eval_R(t.getChild(2), n);

            if (op.equals("=") || op.equals("eq")) {
                for (Node i : left) {
                    for (Node j : right) {
                        if (i.isEqualNode(j)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            if (op.equals("==") || op.equals("is")) {
                for (Node i : left) {
                    for (Node j : right) {
                        if (i.getNodeType() == Node.TEXT_NODE && j.getNodeType() == Node.TEXT_NODE && i.isSameNode(j)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }

    public void getAllDescendants(Node node, Set<Node> descendants) {
        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node curNode = nodes.item(i);
            descendants.add(curNode);
            getAllDescendants(curNode, descendants);
        }
    }
}