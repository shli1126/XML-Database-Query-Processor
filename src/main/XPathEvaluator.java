package main;

import java.io.File;

import main.antlr.XPathBaseVisitor;
import main.antlr.XPathParser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.*;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.stream.Collectors;

public class XPathEvaluator extends XPathBaseVisitor<List<Node>> {
    private Map<String, List<Node>> varToValues;
    private Document document;
    private String defaultXmlPath;

    public XPathEvaluator(Document document, String xmlFilePath) {
        this.document = document;
        this.varToValues = new HashMap<>();
        this.defaultXmlPath = xmlFilePath;
    }

    @Override
    public List<Node> visitAp(XPathParser.ApContext ctx) {
        String fileName = ctx.doc().STRING().getText();
        fileName = fileName.substring(1, fileName.length() - 1);

        File xmlFile = new File(fileName);
        if (!xmlFile.exists()) {
            xmlFile = new File(defaultXmlPath);
        }

        Document document;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(xmlFile);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing XML file: " + xmlFile.getAbsolutePath(), e);
        }

        Node root = document.getDocumentElement();
        String op = ctx.getChild(1).getText();
        XPathParser.RpContext rp = ctx.rp();

        if (op.equals("/")) {
            return Eval_R(rp, root);
        } else if (op.equals("//")) {
            Set<Node> nodes = new HashSet<>();
            nodes.add(root);
            getAllDescendants(root, nodes);

            List<Node> res = new ArrayList<>();
            for (Node node : nodes) {
                res.addAll(Eval_R(rp, node));
            }
            return res.stream().distinct().collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    // entry point is visitXq instead of visitAp for xquery
    @Override
    public List<Node> visitXq(XPathParser.XqContext ctx) {
        if (ctx == null) {
            System.out.println("Condition context is null!");
            return new ArrayList<>();
        }
        // TODO
        // rule 22
        if (ctx.var() != null) {
            String var = ctx.var().getText();
            if (varToValues.containsKey(var)) {
                List<Node> values = varToValues.get(var);
                return values;
            } else {
                return new ArrayList<>();
            }
        }
        //rule 23
        else if (ctx.STRING() != null) {
            String text = ctx.STRING().getText().substring(1, ctx.STRING().getText().length() - 1);
            List<Node> res = new ArrayList<>();
            res.add(document.createTextNode(text));
            return res;
        }
        // rule 24
        else if (ctx.ap() != null) {
            return visitAp(ctx.ap());
        }
        // rule 25
        else if (ctx.getChildCount() == 3 && ctx.getChild(0).getText().equals("(") && ctx.getChild(2).getText().equals(")")) {
            return visit(ctx.xq(0));
        }
        // rule 26
        else if (ctx.getChildCount() == 3 && ctx.getChild(1).getText().equals(",")) {
            List<Node> res = new ArrayList<>();
            res.addAll(visit(ctx.xq(0)));
            res.addAll(visit(ctx.xq(1)));
            return res;
        }
        // rule 27
        else if (ctx.getChildCount() == 3 && ctx.getChild(1).getText().equals("/")) {
            List<Node> nodes = visit(ctx.xq(0));
            List<Node> res = new ArrayList<>();
            for (Node node : nodes) {
                res.addAll(Eval_R(ctx.rp(), node));
            }
            return res.stream().distinct().collect(Collectors.toList());
        }
        // rule 28
        else if (ctx.getChildCount() == 3 && ctx.getChild(1).getText().equals("//")) {
            List<Node> nodes = visit(ctx.xq(0));
            List<Node> res = new ArrayList<>();
            for (Node node : nodes) {
                Set<Node> descendants = new HashSet<>();
                descendants.add(node);
                getAllDescendants(node, descendants);
                for (Node descendant : descendants) {
                    res.addAll(Eval_R(ctx.rp(), descendant));
                }
            }
            return res.stream().distinct().collect(Collectors.toList());
        }
        // rule 29
        else if (ctx.tagName() != null && ctx.tagName().size() == 2) {
            String tag = ctx.tagName(0).getText();
            List<Node> nodes = visit(ctx.xq(0));
            Element element = document.createElement(tag);
            for (Node node : nodes) {
                Node importNode = document.importNode(node.cloneNode(true), true);
                element.appendChild(importNode);
            }
            List<Node> res = new ArrayList<>();
            res.add(element);
            return res;
        }
        // rule 40, 40  goes first because only 40 has for clause
        // if 38, 39 goes first, it the FLWR will go into 38, 39 rules since it also has let clause
        else if (ctx.forClause() != null) {
            return visitFLWR(ctx);
        }
        // rule 38 39
        else if (ctx.letClause() != null) {
            Map<String, List<Node>> temp = new HashMap<>(varToValues);
            visitLetClause(ctx.letClause());
            List<Node> res = visit(ctx.xq(0));
            varToValues = temp;
            return res;
        }

        System.out.println("xQuery expression " + ctx.getText() + " is unhandled!");
        return new ArrayList<>();
    }


    public List<Node> visitFLWR(XPathParser.XqContext ctx) {
        if (ctx == null) {
            System.out.println("Condition context is null!");
            return new ArrayList<>();
        }
        Map<String, List<Node>> temp = new HashMap<>(varToValues);
        XPathParser.ForClauseContext forClause = ctx.forClause();
        List<String> vars = new ArrayList<>();
        List<XPathParser.XqContext> xqs = new ArrayList<>();
        for (int i = 0; i < forClause.var().size(); i++) {
            vars.add(forClause.var(i).getText());
            xqs.add(forClause.xq(i));
        }
        List<Node> res = visitBindings(0, ctx, vars, xqs);
        varToValues = temp;
        return res;
    }

    public List<Node> visitBindings(int idx, XPathParser.XqContext ctx, List<String> vars, List<XPathParser.XqContext> xqs) {
        List<Node> res = new ArrayList<>();
        // base case
        if (idx == vars.size()) {
            if (ctx.letClause() != null) {
                visitLetClause(ctx.letClause());
            }
            if (ctx.whereClause() != null) {
                if  (ctx.whereClause().cond() != null) {
                    if (!visitConditon(ctx.whereClause().cond())) {
                        return res;
                    }
                }
            }
            res.addAll(visit(ctx.returnClause().xq()));
            return res;
        }
        String curVar = vars.get(idx);
        List<Node> curVal = visit(xqs.get(idx));
        for (Node node : curVal) {
            List<Node> val = new ArrayList<>();
            val.add(node);
            varToValues.put(curVar, val);
            res.addAll(visitBindings(idx + 1, ctx, vars, xqs));
        }
        return res;
    }


    public boolean visitConditon(XPathParser.CondContext ctx) {
        if (ctx == null) {
            System.out.println("Condition context is null!");
            return false;
        }

        // rule 30
        if (ctx.EQ() != null) {
            List<Node> left = visit(ctx.xq(0));
            List<Node> right = visit(ctx.xq(1));
            for (Node i : left) {
                for (Node j : right) {
                    if (i.getNodeType() == j.getNodeType() && i.getTextContent().equals(j.getTextContent())) {
                        return true;
                    }
                }
            }
            return false;
        }
        // rule 31
        else if (ctx.IS() != null) {
            List<Node> left = visit(ctx.xq(0));
            List<Node> right = visit(ctx.xq(1));
            for (Node i : left) {
                for (Node j : right) {
                    if (i.isSameNode(j)) {
                        return true;
                    }
                }
            }
            return false;
        }
        // Rule 32
        else if (ctx.getChildCount() == 4 && ctx.getChild(0).getText().equals("empty")) {
            return visit(ctx.xq(0)).isEmpty();
        }
        // Rule 33
        else if (ctx.getChild(0).getText().equals("some")) {
            if (ctx == null) {
                System.out.println("Condition context is null!");
                return false;
            }
            Map<String, List<Node>> temp = new HashMap<>(varToValues);
            List<String> vars = new ArrayList<>();
            List<XPathParser.XqContext> xqs = new ArrayList<>();
            int varSize = ctx.var().size();
            for (int i = 0; i < varSize; i++) {
                vars.add(ctx.var(i).getText());
                xqs.add(ctx.xq(i));
            }
            XPathParser.CondContext cond = ctx.cond(0);
            if (cond == null) {
                return false;
            }
            return visitSomeCondition(0, vars, xqs, cond, temp);
        }
        // Rule 34
        else if (ctx.getChildCount() == 3 && ctx.getChild(0).getText().equals("(") && ctx.getChild(2).getText().equals(")")) {
            return visitConditon(ctx.cond(0));
        }
        // Rule 35
        else if (ctx.getChildCount() == 3 && ctx.getChild(1).getText().equals("and")) {
            return visitConditon(ctx.cond(0)) && visitConditon(ctx.cond(1));
        }
        // Rule 36
        else if (ctx.getChildCount() == 3 && ctx.getChild(1).getText().equals("or")) {
            return visitConditon(ctx.cond(0)) || visitConditon(ctx.cond(1));
        }
        // Rule 37
        else if (ctx.getChildCount() == 2 && ctx.getChild(0).getText().equals("not")) {
            return !visitConditon(ctx.cond(0));
        }
        System.out.println("Conditon " + ctx.getText() + " is unhandled!");
        return false;

    }

    boolean visitSomeCondition(int idx, List<String> vars, List<XPathParser.XqContext> xqs,
                               XPathParser.CondContext cond, Map<String, List<Node>> temp) {
        if (idx == vars.size()) {
            return visitConditon(cond);
        }
        String curVar = vars.get(idx);
        List<Node> curVal = visit(xqs.get(idx));

        for (Node node : curVal) {
            List<Node> val = new ArrayList<>();
            val.add(node);
            varToValues.put(curVar, val);
            if (visitSomeCondition(idx + 1, vars, xqs, cond, temp)) {
                varToValues = new HashMap<>(temp);
                return true;
            }
        }
        varToValues = new HashMap<>(temp);
        return false;
    }

    public List<Node> Eval_R(XPathParser.RpContext ctx, Node n) {

        List<Node> res = new ArrayList<>();
        if (ctx == null) {
            return res;
        }
        if (ctx.getChildCount() == 1) {
            String text = ctx.getText();
            if ((ctx.tagName() != null) ||
                    (!text.equals("*") && !text.equals(".") && !text.equals("..") && !text.equals("text()"))) {
                String tagName = text;
                NodeList nodes = n.getChildNodes();
                for (int i = 0; i < nodes.getLength(); i++) {
                    Node node = nodes.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals(tagName)) {
                        res.add(node);
                    }
                }
                return res;
            } else if (ctx.getText().equals("*")) {
                NodeList nodes = n.getChildNodes();
                for (int i = 0; i < nodes.getLength(); i++) {
                    Node node = nodes.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        res.add(node);
                    }
                }
            } else if (ctx.getText().equals(".")) {
                res.add(n);
            } else if (ctx.getText().equals("..")) {
                Node parent = n.getParentNode();
                if (parent != null) {
                    res.add(parent);
                }
            } else if (ctx.getText().equals("text()")) {
//                System.out.println("Ever reach this text()??");
                NodeList nodes = n.getChildNodes();
                for (int i = 0; i < nodes.getLength(); i++) {
                    if (nodes.item(i).getNodeType() == Node.TEXT_NODE) {
                        res.add(nodes.item(i));
                    }
                }
            }
        } else {
            // Cases with multiple children
            if (ctx.getChildCount() == 2 && ctx.getChild(0).getText().equals("@")) {
                if (n.getNodeType() == Node.ELEMENT_NODE && n.hasAttributes()) {
                    String attName = ctx.attrName().getText();
                    Node attNode = ((Element) n).getAttributeNode(attName);
                    if (attNode != null) {
                        res.add(attNode);
                    }
                }
            } else if (ctx.getChildCount() == 3 && "(".equals(ctx.getChild(0).getText())
                    && ")".equals(ctx.getChild(2).getText())) {
                res.addAll(Eval_R(ctx.rp(0), n));
            } else if (ctx.getChildCount() == 3) {
                XPathParser.RpContext left = ctx.rp(0);
                String op = ctx.getChild(1).getText();
                XPathParser.RpContext right = ctx.rp(1);
                if (op.equals("/")) {
                    List<Node> nodes = Eval_R(left, n);
                    for (Node node : nodes) {
                        res.addAll(Eval_R(right, node));
                    }
                    res = res.stream().distinct().collect(Collectors.toList());
                }
                if (op.equals("//")) {
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
                if (op.equals(",")) {
                    res.addAll(Eval_R(left, n));
                    res.addAll(Eval_R(right, n));
                }

            } else if (ctx.getChildCount() == 4
                    && ctx.getChild(1).getText().equals("[")
                    && ctx.getChild(3).getText().equals("]")) {
                XPathParser.RpContext rp = ctx.rp(0);
                XPathParser.FContext filter = ctx.f();
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

    public Boolean Eval_F(XPathParser.FContext ctx, Node n) {
        // Case: Single rp filter
        if (ctx.getChildCount() == 1) {
            List<Node> res = Eval_R(ctx.rp(0), n);
            return !res.isEmpty();
        }
        // Case: NOT filter
        else if (ctx.getChildCount() == 2) {
            return !Eval_F(ctx.f(0), n);
        } else if (ctx.getChildCount() == 3) {
            String op = ctx.getChild(1).getText();

            // Case: rp = STRING
            if (ctx.getChild(2).getText().startsWith("'") || ctx.getChild(2).getText().startsWith("\"")) {
                String target = ctx.STRING().getText();
                target = target.substring(1, target.length() - 1);
                List<Node> nodes = Eval_R(ctx.rp(0), n);
                for (Node node : nodes) {
                    if (node.getTextContent().equals(target)) {
                        return true;
                    }
                }
                return false;
            }
            // Case: AND filter
            if (op.equals("and")) {
                return Eval_F(ctx.f(0), n) && Eval_F(ctx.f(1), n);
            }
            // Case: OR filter
            if (op.equals("or")) {
                return Eval_F(ctx.f(0), n) || Eval_F(ctx.f(1), n);
            }
            // Case: Parenthesized filter
            if (ctx.getChild(0).getText().equals("(") && ctx.getChild(2).getText().equals(")")) {
                return Eval_F(ctx.f(0), n);
            }

            // Case: rp comparison rp
            List<Node> left = Eval_R(ctx.rp(0), n);
            List<Node> right = Eval_R(ctx.rp(1), n);

            // Value equality
            if (op.equals("=") || op.equals("eq")) {
                for (Node i : left) {
                    for (Node j : right) {
                        if (i.getNodeType() == j.getNodeType() && i.getTextContent().equals(j.getTextContent())) { // Compare text content
                            return true;
                        }
                    }
                }
                return false;
            }
            // Identity equality
            if (op.equals("==") || op.equals("is")) {
                for (Node i : left) {
                    for (Node j : right) {
                        if (i.isSameNode(j)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        System.out.println("Unhandled Eval_F expression: " + ctx.getText());
        return false;
    }


    @Override
    public List<Node> visitLetClause(XPathParser.LetClauseContext ctx) {
        // TODO
        for (int i = 0; i < ctx.var().size(); i++) {
            String var = ctx.var(i).getText();
            List<Node> values = visit(ctx.xq(i));
            varToValues.put(var, values);
        }
        return null;
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