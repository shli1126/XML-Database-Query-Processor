package main;
import java.io.File;
import main.antlr.XQueryBaseVisitor;
import main.antlr.XQueryParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.*;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.util.stream.Collectors;

public class XQueryEvaluator extends XQueryBaseVisitor<List<Node>> {
    // add required data structures
    // may need map for storing var?
    private Document document; // The XML document being queried
    private Map<String, List<Node>> varCtx;

    public XQueryEvaluator(Document document) {
        this.document = document;
        this.varCtx = new HashMap<>();
    }


    @Override
    public List<Node> visitAp(XQueryParser.ApContext ctx) {
        List<Node> docNodes;

        // Get document
        if (ctx.doc() != null) {
            docNodes = visitDoc(ctx.doc());
        } else {
            throw new RuntimeException("Document node not found in absolute path");
        }

        // Apply the relative path
        List<Node> result = new ArrayList<>();
        String op = ctx.getChild(1).getText();

        if (op.equals("/")) {
            // Direct children
            for (Node docNode : docNodes) {
                result.addAll(Eval_R(ctx.rp(), docNode));
            }
        } else if (op.equals("//")) {
            // All descendants
            for (Node docNode : docNodes) {
                Set<Node> descendants = new HashSet<>();
                descendants.add(docNode);
                getAllDescendants(docNode, descendants);
                for (Node descendant : descendants) {
                    result.addAll(Eval_R(ctx.rp(), descendant));
                }
            }
        }

        return result;
    }





    // entry point is visitXq instead of visitAp for xquery
    @Override
    public List<Node> visitXq(XQueryParser.XqContext ctx) {
        // TODO
        // case 22
        if (ctx.var() != null) {
            return visitVar(ctx.var());
        }
        // case 23
        if (ctx.STRING() != null) {
            String text = ctx.STRING().getText();
            text = text.substring(1, text.length() - 1);
            Node node = document.createTextNode(text);
            return List.of(node);
        }
        // case 24
        if (ctx.ap() != null) {
            return visitAp(ctx.ap());
        }
        // case 25
        if (ctx.xq() != null && ctx.getChildCount() == 3 && ctx.getChild(0).getText().equals("(") && ctx.getChild(2).getText().equals(")")) {
            return visitXq(ctx.xq(0));
        }
        // case 26
        if (ctx.getChildCount() == 3 && ctx.getChild(1).getText().equals(",")) {
            List<Node> res = new ArrayList<>();
            res.addAll(visitXq(ctx.xq(0)));
            res.addAll(visitXq(ctx.xq(1)));
            return res;
        }
        // case 27, 28
        if (ctx.rp() != null && ctx.getChildCount() == 3 &&
                (ctx.getChild(1).getText().equals("/") || ctx.getChild(1).getText().equals("//"))) {
            String op = ctx.getChild(1).getText();
            List<Node> nodes = visitXq(ctx.xq(0));
            List<Node> res = new ArrayList<>();

            for (Node node : nodes) {
                if (op.equals("/")) {
                    res.addAll(Eval_R(ctx.rp(), node));
                } else {
                    Set<Node> descendants = new HashSet<>();
                    descendants.add(node);
                    getAllDescendants(node, descendants);
                    for (Node descendant : descendants) {
                        res.addAll(Eval_R(ctx.rp(), descendant));
                    }
                }
            }
            return res;
        }


        // case 29
        if (ctx.tagName() != null && ctx.tagName().size() > 0) {
            String tagName = ctx.tagName(0).getText();
            Element elementNode = document.createElement(tagName);
            if (ctx.xq().size() > 0) {
                List<Node> nodes = visitXq(ctx.xq(0));
                for (Node node : nodes) {
                    if (node.getNodeType() == Node.TEXT_NODE) {
                        elementNode.appendChild(document.createTextNode(node.getTextContent()));
                    } else {
                        elementNode.appendChild(document.importNode(node, true));
                    }                }
            }
            return List.of(elementNode);
        }

        // case 38
        if (ctx.letClause() != null && ctx.forClause() == null &&
                ctx.whereClause() == null && ctx.returnClause() == null) {
            Map<String, List<Node>> temp = new HashMap<>(varCtx);
            evaluateLetClause(ctx.letClause());
            List<Node> res = visitXq(ctx.xq(0));
            varCtx = temp;
            return res;
        }


        // case 40
        if (ctx.forClause() != null && ctx.returnClause() != null) {
            Map<String, List<Node>> temp = new HashMap<>(varCtx);
            List<Map<String, List<Node>>> binds = evaluateForClause(ctx.forClause());
            List<Node> res = new ArrayList<>();

            for (Map<String, List<Node>> bind : binds) {
                varCtx.putAll(bind);

                if (ctx.letClause() != null) {
                    evaluateLetClause(ctx.letClause());
                }

                if (ctx.whereClause() != null) {
                    if (evaluateCond(ctx.whereClause().cond())) {
                        List<Node> nodes = visitXq(ctx.returnClause().xq());
                        res.addAll(nodes);
                    }
                }
            }
            varCtx = temp;
            return res;
        }
        System.err.println("Unhandled visitXq expression: " + ctx.getText());
        throw new RuntimeException("Xq doesn't match any case!");
    }


    // old Eval_F?
    @Override
    public List<Node> visitF(XQueryParser.FContext ctx) {
        // TODO
        return new ArrayList<>();
    }

    public List<Map<String, List<Node>>> evaluateForClause(XQueryParser.ForClauseContext ctx) {
        // TODO
        List<Map<String, List<Node>>> res = new ArrayList<>(List.of(new HashMap<>()));
        for (int i = 0; i < ctx.var().size(); i++) {
            String var = ctx.var(i).getText();
            List<Map<String, List<Node>>> tempRes = new ArrayList<>();

            for (Map<String, List<Node>> bind : res) {
                Map<String, List<Node>> tempCtx = new HashMap<>(varCtx);
                varCtx.putAll(bind);

                List<Node> nodes = visitXq(ctx.xq(i));
                for (Node node : nodes) {
                    Map<String, List<Node>> newBind = new HashMap<>(bind);
                    newBind.put(var, List.of(node));
                    tempRes.add(newBind);
                }
                varCtx = tempCtx;
            }
            res = tempRes;
        }
        return res;
    }

    public void evaluateLetClause(XQueryParser.LetClauseContext ctx) {
        // TODO
        for (int i = 0; i < ctx.var().size(); i++) {
            String var = ctx.var(i).getText();
            List<Node> nodes = visitXq(ctx.xq(i));
            varCtx.put(var, nodes);
        }
    }


    public boolean evaluateWhereClause(XQueryParser.WhereClauseContext ctx) {
        // TODO
        return evaluateCond(ctx.cond());
    }

    @Override
    public List<Node> visitReturnClause(XQueryParser.ReturnClauseContext ctx) {
        // TODO
        return visitXq(ctx.xq());
    }


    @Override
    public List<Node> visitDoc(XQueryParser.DocContext ctx) {
        String fileName;
        if (ctx.STRING() != null) {
            fileName = ctx.STRING().getText();
            // Remove quotes from the filename
            fileName = fileName.substring(1, fileName.length() - 1);
        } else {
            throw new RuntimeException("Document name not found in doc node");
        }

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(fileName));
            return List.of(doc.getDocumentElement());
        } catch (Exception e) {
            throw new RuntimeException("Error loading document: " + fileName, e);
        }
    }


    @Override
    public List<Node> visitVar(XQueryParser.VarContext ctx) {
        String var = ctx.getText();
        if (varCtx.containsKey(var)) {
            return new ArrayList<>(varCtx.get(var));
        } else {
            throw new RuntimeException("Var not in varCtx");
        }
    }


    public Boolean evaluateCond(XQueryParser.CondContext ctx) {
        // case 30
        if (ctx.EQ() != null) {
            List<Node> left = visitXq(ctx.xq(0));
            List<Node> right = visitXq(ctx.xq(1));

            // Handle the case where the right-hand side is a string literal
            if (ctx.xq(1).STRING() != null) {
                String target = ctx.xq(1).STRING().getText();
                target = target.substring(1, target.length() - 1); // Remove quotes

                for (Node leftNode : left) {
                    if (leftNode.getTextContent().equals(target)) {
                        return true;
                    }
                }
                return false;
            }

            // Handle the case where the right-hand side is an XQuery expression
            for (Node leftNode : left) {
                String leftText = leftNode.getTextContent();

                for (Node rightNode : right) {
                    String rightText = rightNode.getTextContent();

                    // Compare text content directly
                    if (leftText.equals(rightText)) {
                        return true;
                    }
                }
            }
            return false;
        }
        // case 31
        if (ctx.IS() != null) {
            List<Node> left = visitXq(ctx.xq(0));
            List<Node> right = visitXq(ctx.xq(1));
            for (Node i : left) {
                for (Node j : right) {
                    if (i.isSameNode(j)) {
                        return true;
                    }

                }
            }
            return false;
        }
        // case 32
        if (ctx.getChildCount() == 4 &&
                ctx.getChild(0).getText().equals("empty") &&
                ctx.getChild(1).getText().equals("(") &&
                ctx.getChild(2).getText().equals(")")) {
            return visitXq(ctx.xq(0)).isEmpty();
        }

        // case 33
        if (ctx.getChildCount() > 3 &&
                ctx.getChild(0).equals("some") &&
                ctx.getChild(2).equals("in")
        ) {
            List<XQueryParser.VarContext> vars = new ArrayList<>();
            List<XQueryParser.XqContext> xqs = new ArrayList<>();
            for (int i = 0; i < ctx.var().size(); i++) {
                vars.add(ctx.var(i));
                xqs.add(ctx.xq(i));
            }
            return checkSomeCond(vars, xqs, new HashMap<>(), ctx.cond(0), 0);
        }

        // case 34
        if (ctx.getChildCount() == 3 &&
                ctx.getChild(0).getText().equals("(") &&
                ctx.getChild(2).getText().equals(")")) {
            return evaluateCond(ctx.cond(0));
        }

        // case 35
        if (ctx.getChildCount() == 3 &&
                ctx.getChild(1).getText().equals("and")) {
            boolean left = evaluateCond(ctx.cond(0));
            boolean right = evaluateCond(ctx.cond(1));
            return left && right;
        }

        // case 36
        if (ctx.getChildCount() == 3 &&
                ctx.getChild(1).getText().equals("or")) {
            boolean left = evaluateCond(ctx.cond(0));
            boolean right = evaluateCond(ctx.cond(1));
            return left || right;
        }

        // case 37
        if (ctx.getChildCount() == 2 &&
                ctx.getChild(0).getText().equals("not")) {
            return !evaluateCond(ctx.cond(0));

        }
        System.err.println("Unhandled evaluateCond expression: " + ctx.getText());
        throw new RuntimeException("Cond doesn't match any case!");
    }


    private boolean checkSomeCond(List<XQueryParser.VarContext> vars, List<XQueryParser.XqContext> xqs,
                                  Map<String, List<Node>> curBind, XQueryParser.CondContext cond, int curIdx) {

        if (curIdx >= vars.size()) {
            Map<String, List<Node>> temp = new HashMap<>(varCtx);
            varCtx.putAll(curBind);
            boolean res = evaluateCond(cond);
            varCtx = temp;
            return res;
        }
        XQueryParser.VarContext curVar = vars.get(curIdx);
        XQueryParser.XqContext curXq = xqs.get(curIdx);
        Map<String, List<Node>> temp = new HashMap<>(varCtx);
        varCtx.putAll(curBind);
        List<Node> nodes = visitXq(curXq);
        varCtx = temp;
        for (Node node : nodes) {
            Map<String, List<Node>> newBind = new HashMap<>(curBind);
            newBind.put(curVar.getText(), List.of(node));
            if (checkSomeCond(vars, xqs, newBind, cond, curIdx + 1)) {
                return true;
            }

        }
        return false;
    }


    public List<Node> Eval_A(ParseTree t, Node n) {
        String op = t.getChild(1).getText();
        ParseTree rp = t.getChild(2);
        if (op.equals("/")) {
            return this.Eval_R(rp, n);
        } else if (!op.equals("//")) {
            return new ArrayList<Node>();
        } else {
            Set<Node> nodes = new HashSet<Node>();
            nodes.add(n);
            this.getAllDescendants(n, nodes);
            List<Node> res = new ArrayList<Node>();

            for(Node node : nodes) {
                res.addAll(this.Eval_R(rp, node));
            }

            return res;
        }
    }

    public List<Node> Eval_R(ParseTree t, Node n) {
        List<Node> res = new ArrayList<Node>();
        if (t == null) {
            return res;
        } else {
            if (t.getText().equals("text()")) {
                List<Node> ans = new ArrayList<>();
                NodeList nodes = n.getChildNodes();

                for (int i = 0; i < nodes.getLength(); ++i) {
                    if (nodes.item(i).getNodeType() == Node.TEXT_NODE) {
                        ans.add(nodes.item(i));
                    }
                }

                if (res.isEmpty() && n.getNodeType() == Node.ELEMENT_NODE) {
                    Node textNode = document.createTextNode(n.getTextContent());
                    ans.add(textNode);
                }
                return ans;
            }



            if (t.getChildCount() == 1) {
                if (t.getText().matches("[a-zA-Z_][a-zA-Z0-9_-]*")) {
                    String tagName = t.getChild(0).getText();
                    NodeList nodes = n.getChildNodes();

                    for(int i = 0; i < nodes.getLength(); ++i) {
                        Node node = nodes.item(i);
                        if (node.getNodeType() == 1 && node.getNodeName().equals(tagName)) {
                            res.add(node);
                        }
                    }
                } else if (t.getText().equals("*")) {
                    NodeList nodes = n.getChildNodes();

                    for(int i = 0; i < nodes.getLength(); ++i) {
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

                    for(int i = 0; i < nodes.getLength(); ++i) {
                        if (nodes.item(i).getNodeType() == 3) {
                            res.add(nodes.item(i));
                        }
                    }
                }
            } else if (t.getChildCount() == 2 && t.getChild(0).getText().equals("@")) {
                if (n.getNodeType() == 1 && n.hasAttributes()) {
                    String attName = t.getChild(1).getText();
                    Node attNode = ((Element)n).getAttributeNode(attName);
                    if (attNode != null) {
                        res.add(attNode);
                    }
                }
            } else if (t.getChildCount() == 3 && "(".equals(t.getChild(0).getText()) && ")".equals(t.getChild(2).getText())) {
                res.addAll(this.Eval_R(t.getChild(1), n));
            } else if (t.getChildCount() == 3) {
                ParseTree left = t.getChild(0);
                ParseTree op = t.getChild(1);
                ParseTree right = t.getChild(2);
                switch (op.getText()) {
                    case "/":
                        for(Node node : this.Eval_R(left, n)) {
                            res.addAll(this.Eval_R(right, node));
                        }

                        res = res.stream().distinct().collect(Collectors.toList());
                        break;
                    case "//":
                        List<Node> nodes = this.Eval_R(left, n);
                        Set<Node> descendants = new HashSet<Node>();

                        for(Node node : nodes) {
                            descendants.add(node);
                            this.getAllDescendants(node, descendants);
                        }

                        for(Node node : descendants) {
                            res.addAll(this.Eval_R(right, node));
                        }

                        res = res.stream().distinct().collect(Collectors.toList());
                        break;
                    case ",":
                        res.addAll(this.Eval_R(left, n));
                        res.addAll(this.Eval_R(right, n));
                }
            } else if (t.getChildCount() == 4 && t.getChild(1).getText().equals("[") && t.getChild(3).getText().equals("]")) {
                ParseTree rp = t.getChild(0);
                ParseTree filter = t.getChild(2);

                for(Node node : this.Eval_R(rp, n)) {
                    if (this.Eval_F(filter, node)) {
                        res.add(node);
                    }
                }
            }

            return res;
        }
    }

    public Boolean Eval_F(ParseTree t, Node n) {
        if (t.getChildCount() == 1) {
            List<Node> res = this.Eval_R(t.getChild(0), n);
            return !res.isEmpty();
        } else if (t.getChildCount() == 2) {
            return !this.Eval_F(t.getChild(1), n);
        } else if (t.getChildCount() == 3) {
            String op = t.getChild(1).getText();

            if (t.getChild(2).getText().startsWith("'") || t.getChild(2).getText().startsWith("\"")) {
                String target = t.getChild(2).getText();
                target = target.substring(1, target.length() - 1);

                for (Node node : this.Eval_R(t.getChild(0), n)) {
                    if (node.getTextContent().equals(target)) {
                        return true;
                    }
                }
                return false;
            }


            if (!t.getChild(2).getText().startsWith("'") && !t.getChild(2).getText().startsWith("\"")) {
                if (t.getChild(1).getText().equals("and")) {
                    return this.Eval_F(t.getChild(0), n) && this.Eval_F(t.getChild(2), n);
                } else if (t.getChild(1).getText().equals("or")) {
                    return this.Eval_F(t.getChild(0), n) || this.Eval_F(t.getChild(2), n);
                } else if (t.getChild(0).getText().equals("(") && t.getChild(2).getText().equals(")")) {
                    return this.Eval_F(t.getChild(1), n);
                } else {
                    List<Node> left = this.Eval_R(t.getChild(0), n);
                    List<Node> right = this.Eval_R(t.getChild(2), n);
                    if (!op.equals("=") && !op.equals("eq")) {
                        if (!op.equals("==") && !op.equals("is")) {
                            return false;
                        } else {
                            for(Node i : left) {
                                for(Node j : right) {
                                    if (i.getNodeType() == 3 && j.getNodeType() == 3 && i.isSameNode(j)) {
                                        return true;
                                    }
                                }
                            }

                            return false;
                        }
                    } else {
                        for(Node i : left) {
                            for(Node j : right) {
                                if (i.isEqualNode(j)) {
                                    return true;
                                }
                            }
                        }

                        return false;
                    }
                }
            } else {
                String target = t.getChild(2).getText();
                target = target.substring(1, target.length() - 1);

                for(Node node : this.Eval_R(t.getChild(0), n)) {
                    if (node.getTextContent().equals(target)) {
                        return true;
                    }
                }

                return false;
            }
        } else {
            return false;
        }
    }

    public void getAllDescendants(Node node, Set<Node> descendants) {
        NodeList nodes = node.getChildNodes();

        for(int i = 0; i < nodes.getLength(); ++i) {
            Node curNode = nodes.item(i);
            descendants.add(curNode);
            this.getAllDescendants(curNode, descendants);
        }

    }
    // TODO!!
    // add more if needed, see main.antlr.XQueryBaseVisitor.java
    // e.g. visitDoc(), visitVar(), visitTagName(), visitAttrName()

}    // XPath functions
//    public List<Node> visitAp(XQueryParser.ApContext ctx) {
//        String fileName = ctx.getChild(0).getChild(2).getText();
//        fileName = fileName.substring(1, fileName.length() - 1);
//
//        Document document;
//        try {
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            document = builder.parse(fileName);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        return this.Eval_A(ctx, document.getDocumentElement());
//    }

//    // combine old visitAp and Eval_A?
//    @Override
//    public List<Node> visitAp(XQueryParser.ApContext ctx) {
//        return visitAp(ctx.ap());
//    }
//
//    // old Eval_R?
//    @Override
//    public List<Node> visitRp(XQueryParser.RpContext ctx) {
//        // TODO
//        return visitAp(ctx.ap());
//    }
