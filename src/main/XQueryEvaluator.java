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
import org.w3c.dom.NamedNodeMap;

public class XQueryEvaluator extends XQueryBaseVisitor<List<Node>> {

    private Map<String, List<Node>> variableContext;
    private Document document;

    public XQueryEvaluator(Document document) {
        this.document = document;
        this.variableContext = new HashMap<>();
    }


    // entry point is visitXq instead of visitAp for xquery
    @Override
    public List<Node> visitXq(XQueryParser.XqContext ctx) {
        // TODO
        // rule 22
        if (ctx.var() != null) {
            String varName = ctx.var().getText();
            System.out.println("Looking up variable: " + varName);
            System.out.println("Available variables: " + variableContext.keySet());

            if (variableContext.containsKey(varName)) {
                List<Node> values = variableContext.get(varName);
                System.out.println("Found " + values.size() + " values for " + varName);
                return values;
            } else {
                System.out.println("Variable not found in context: " + varName);
                return new ArrayList<>();
            }
        }
        // rule 23
        else if (ctx.STRING() != null) {
            String text = ctx.STRING().getText();
            text = text.substring(1, text.length() - 1);
            List<Node> result = new ArrayList<>();
            result.add(document.createTextNode(text));
            return result;
        }
        // case 24
        else if (ctx.ap() != null) {
            return visitAp(ctx.ap());
        }
        // case 25
        else if (ctx.getChildCount() == 3 && ctx.getChild(0).getText().equals("(") && ctx.getChild(2).getText().equals(")")) {
            return visit(ctx.xq(0));
        }
        // case 26
        else if (ctx.getChildCount() == 3 && ctx.getChild(1).getText().equals(",")) {
            List<Node> result = new ArrayList<>();
            result.addAll(visit(ctx.xq(0)));
            result.addAll(visit(ctx.xq(1)));
            return result;
        }
        // case 27
        else if (ctx.getChildCount() == 3 && ctx.getChild(1).getText().equals("/")) {
            System.out.println("Ever reach / case???" + ctx.getText());

            List<Node> intermediateResults = visit(ctx.xq(0));
            System.out.println("How much intermediateResults" + intermediateResults.size());
            List<Node> finalResults = new ArrayList<>();
            for (Node n : intermediateResults) {
                finalResults.addAll(Eval_R(ctx.rp(), n));
            }
            return finalResults.stream().distinct().collect(Collectors.toList());
        }
        // case 28
        else if (ctx.getChildCount() == 3 && ctx.getChild(1).getText().equals("//")) {
            System.out.println("Ever reach // case???" + ctx.getText());

            List<Node> intermediateResults = visit(ctx.xq(0));
            System.out.println("How much intermediateResults" + intermediateResults.size());

            List<Node> finalResults = new ArrayList<>();
            for (Node n : intermediateResults) {
                Set<Node> descendants = new HashSet<>();
                descendants.add(n);
                getAllDescendants(n, descendants);
                for (Node descendant : descendants) {
                    finalResults.addAll(Eval_R(ctx.rp(), descendant));
                }
            }
            return finalResults.stream().distinct().collect(Collectors.toList());
        }
        // case 29
        else if (ctx.tagName() != null && ctx.tagName().size() == 2) {
            String tagName = ctx.tagName(0).getText();
            List<Node> content = visit(ctx.xq(0));
            Element element = document.createElement(tagName);
            for (Node node : content) {
                Node imported = document.importNode(node.cloneNode(true), true);
                element.appendChild(imported);
            }
            List<Node> result = new ArrayList<>();
            result.add(element);
            return result;
        }
        // case 40
        else if (ctx.forClause() != null) {
            return processFLWOR(ctx);
        }
        // case 38
        else if (ctx.letClause() != null) {
            Map<String, List<Node>> oldContext = new HashMap<>(variableContext);
            visitLetClause(ctx.letClause());
            List<Node> result = visit(ctx.xq(0));
            variableContext = oldContext; // Restore the context
            return result;
        }

        System.out.println("Unhandled xQuery expression: " + ctx.getText());
        return new ArrayList<>();
    }

    // combine old visitAp and Eval_A?
    @Override
    public List<Node> visitAp(XQueryParser.ApContext ctx) {
        String fileName = ctx.doc().STRING().getText();
        fileName = fileName.substring(1, fileName.length() - 1);

        Document document;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(fileName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Node root = document.getDocumentElement();
        String op = ctx.getChild(1).getText();
        XQueryParser.RpContext rp = ctx.rp();

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
        System.out.println("Unhandled Ap expression: " + ctx.getText());
        return new ArrayList<>();
    }

    // old Eval_R?
    @Override
    public List<Node> visitRp(XQueryParser.RpContext ctx) {
        // TODO
        return new ArrayList<>();
    }

    public List<Node> Eval_R(XQueryParser.RpContext ctx, Node n) {

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
                System.out.println("Ever reach this text()??");
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
                XQueryParser.RpContext left = ctx.rp(0);
                String op = ctx.getChild(1).getText();
                XQueryParser.RpContext right = ctx.rp(1);
                switch (op) {
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
                }
            } else if (ctx.getChildCount() == 4
                    && ctx.getChild(1).getText().equals("[")
                    && ctx.getChild(3).getText().equals("]")) {
                XQueryParser.RpContext rp = ctx.rp(0);
                XQueryParser.FContext filter = ctx.f();
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


    // old Eval_F?
    @Override
    public List<Node> visitF(XQueryParser.FContext ctx) {
        // TODO
        return new ArrayList<>();
    }

    public Boolean Eval_F(XQueryParser.FContext ctx, Node n) {
        // Case: Single rp filter
        if (ctx.getChildCount() == 1) {
            List<Node> res = Eval_R(ctx.rp(0), n);
            return !res.isEmpty();
        }
        // Case: NOT filter
        else if (ctx.getChildCount() == 2) {
            return !Eval_F(ctx.f(0), n);
        }
        else if (ctx.getChildCount() == 3) {
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
                        if (nodesAreValueEqual(i, j)) {
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

//    @Override
//    public List<Node> visitForClause(XQueryParser.ForClauseContext ctx) {
//        // TODO
//        return new ArrayList<>();
//    }

    @Override
    public List<Node> visitLetClause(XQueryParser.LetClauseContext ctx) {
        // TODO
        // does not return a node list, instead, update the varContext
        for (int i = 0; i < ctx.var().size(); i++) {
            String varName = ctx.var(i).getText();
            List<Node> varValue = visit(ctx.xq(i));
            variableContext.put(varName, varValue);
        }
        return null;
    }

    @Override
    public List<Node> visitWhereClause(XQueryParser.WhereClauseContext ctx) {
        // TODO
        return null;
    }

    @Override
    public List<Node> visitReturnClause(XQueryParser.ReturnClauseContext ctx) {
        // TODO
        return visit(ctx.xq());
    }

    @Override
    public List<Node> visitCond(XQueryParser.CondContext ctx) {
        // TODO
        return new ArrayList<>();
    }

    public Boolean evaluateCondition(XQueryParser.CondContext ctx) {


        String condText = ctx.getText();
        if (condText.contains("/text()=")) {
            // Parse the condition manually since the grammar had trouble
            int equalsPos = condText.indexOf('=');
            String leftPart = condText.substring(0, equalsPos);
            String rightPart = condText.substring(equalsPos + 1);

            // Extract the variable path (e.g., "$sp/LINE")
            int textFuncPos = leftPart.indexOf("/text()");
            String varPath = leftPart.substring(0, textFuncPos);

            // Extract the target string, removing quotes
            if ((rightPart.startsWith("\"") && rightPart.endsWith("\"")) ||
                    (rightPart.startsWith("'") && rightPart.endsWith("'"))) {
                rightPart = rightPart.substring(1, rightPart.length() - 1);
            }

            System.out.println("Comparing " + varPath + " text with: " + rightPart);

            // Extract parts of the path
            String[] pathParts = varPath.split("/");
            String varName = pathParts[0]; // "$sp"
            String elementName = pathParts.length > 1 ? pathParts[1] : null; // "LINE"

            // Evaluate the path
            if (variableContext.containsKey(varName)) {
                List<Node> contextNodes = variableContext.get(varName);
                for (Node contextNode : contextNodes) {
                    if (elementName != null) {
                        // Find children with matching element name
                        NodeList children = contextNode.getChildNodes();
                        for (int i = 0; i < children.getLength(); i++) {
                            Node child = children.item(i);
                            if (child.getNodeType() == Node.ELEMENT_NODE &&
                                    child.getNodeName().equals(elementName)) {
                                if (child.getTextContent().equals(rightPart)) {
                                    return true;
                                }
                            }
                        }
                    } else {
                        // Just check the context node text
                        if (contextNode.getTextContent().equals(rightPart)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        // Rule 30-31: Value and identity equality
        if (ctx.getChildCount() == 3 && (ctx.EQ() != null || ctx.IS() != null)) {
            List<Node> left = visit(ctx.xq(0));
            List<Node> right = visit(ctx.xq(1));

            // Rule 30: Value equality (=, eq)
            if (ctx.EQ() != null) {
                for (Node leftNode : left) {
                    for (Node rightNode : right) {
                        if (nodesAreValueEqual(leftNode, rightNode)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            // Rule 31: Identity equality (==, is)
            else if (ctx.IS() != null) {
                for (Node leftNode : left) {
                    for (Node rightNode : right) {
                        if (leftNode.isSameNode(rightNode)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        // Rule 32: Empty condition
        else if (ctx.getChildCount() == 4 && ctx.getChild(0).getText().equals("empty")) {
            return visit(ctx.xq(0)).isEmpty();
        }
        // Rule 33: Some satisfies condition (existential quantification)
        else if (ctx.getChildCount() >= 5 && ctx.getChild(0).getText().equals("some")) {
            return evaluateSomeCondition(ctx);
        }
        // Rule 34: Parenthesized condition
        else if (ctx.getChildCount() == 3 && ctx.getChild(0).getText().equals("(") && ctx.getChild(2).getText().equals(")")) {
            return evaluateCondition(ctx.cond(0));
        }
        // Rule 35: AND condition
        else if (ctx.getChildCount() == 3 && ctx.getChild(1).getText().equals("and")) {
            return evaluateCondition(ctx.cond(0)) && evaluateCondition(ctx.cond(1));
        }
        // Rule 36: OR condition
        else if (ctx.getChildCount() == 3 && ctx.getChild(1).getText().equals("or")) {
            return evaluateCondition(ctx.cond(0)) || evaluateCondition(ctx.cond(1));
        }
        // Rule 37: NOT condition
        else if (ctx.getChildCount() == 2 && ctx.getChild(0).getText().equals("not")) {
            return !evaluateCondition(ctx.cond(0));
        }
        System.out.println("Unhandled Cond expression: " + ctx.getText());
        return false;
    }

    // TODO!!
    // add more if needed, see main.antlr.XQueryBaseVisitor.java
    // e.g. visitDoc(), visitVar(), visitTagName(), visitAttrName()
    public void getAllDescendants(Node node, Set<Node> descendants) {
        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node curNode = nodes.item(i);
            descendants.add(curNode);
            getAllDescendants(curNode, descendants);
        }
    }

    private List<Node> processFLWOR(XQueryParser.XqContext ctx) {
        System.out.println("Starting FLWOR processing with correct variable scoping");

        // Save original context to restore later
        Map<String, List<Node>> savedContext = new HashMap<>(variableContext);

        // Get the list of variables and their expressions from the FOR clause
        XQueryParser.ForClauseContext forClause = ctx.forClause();
        List<String> varNames = new ArrayList<>();
        List<XQueryParser.XqContext> varExpressions = new ArrayList<>();

        for (int i = 0; i < forClause.var().size(); i++) {
            varNames.add(forClause.var(i).getText());
            varExpressions.add(forClause.xq(i));
        }

        // Use a recursive approach to process the nested variable bindings
        List<Node> results = evaluateNestedForBindings(ctx, 0, varNames, varExpressions);

        // Restore original context
        variableContext = savedContext;
        return results;
    }

    private List<Node> evaluateNestedForBindings(XQueryParser.XqContext ctx,
                                                 int currentVarIndex,
                                                 List<String> varNames,
                                                 List<XQueryParser.XqContext> varExpressions) {
        List<Node> results = new ArrayList<>();

        // Base case: all variables have been bound
        if (currentVarIndex == varNames.size()) {
            // Process LET clause if present
            if (ctx.letClause() != null) {
                visitLetClause(ctx.letClause());
            }

            // Process WHERE clause if present
            if (ctx.whereClause() != null) {
                boolean conditionMet = evaluateCondition(ctx.whereClause().cond());
                if (!conditionMet) {
                    return results;
                }
            }

            // Process RETURN clause
            results.addAll(visit(ctx.returnClause().xq()));
            return results;
        }

        // Evaluate the current variable expression with current context
        String currentVarName = varNames.get(currentVarIndex);
        List<Node> currentVarValues = visit(varExpressions.get(currentVarIndex));

        System.out.println("Evaluated " + currentVarName + " and found " + currentVarValues.size() + " values");

        // For each value of the current variable, bind it and recurse
        for (Node value : currentVarValues) {
            // Bind the current variable to its value
            List<Node> singleValue = new ArrayList<>();
            singleValue.add(value);
            variableContext.put(currentVarName, singleValue);

            System.out.println("Bound " + currentVarName + " to " + (value.getNodeType() == Node.ELEMENT_NODE ?
                    value.getNodeName() : "non-element node"));

            // Proceed to the next variable with updated context
            results.addAll(evaluateNestedForBindings(ctx, currentVarIndex + 1, varNames, varExpressions));
        }

        return results;
    }

    private boolean nodesAreValueEqual(Node n1, Node n2) {
        // Different node types
        if (n1.getNodeType() != n2.getNodeType()) {
            return false;
        }

        // Text nodes - compare content
        if (n1.getNodeType() == Node.TEXT_NODE) {
            return n1.getNodeValue().equals(n2.getNodeValue());
        }

        // Element nodes
        if (n1.getNodeType() == Node.ELEMENT_NODE) {
            // Check tag names
            if (!n1.getNodeName().equals(n2.getNodeName())) {
                return false;
            }

            // Check attributes
            NamedNodeMap attrs1 = n1.getAttributes();
            NamedNodeMap attrs2 = n2.getAttributes();

            if (attrs1.getLength() != attrs2.getLength()) {
                return false;
            }

            for (int i = 0; i < attrs1.getLength(); i++) {
                Node attr1 = attrs1.item(i);
                Node attr2 = attrs2.getNamedItem(attr1.getNodeName());

                if (attr2 == null || !attr1.getNodeValue().equals(attr2.getNodeValue())) {
                    return false;
                }
            }

            // Check children
            NodeList children1 = n1.getChildNodes();
            NodeList children2 = n2.getChildNodes();

            List<Node> elemChildren1 = getElementNodes(children1);
            List<Node> elemChildren2 = getElementNodes(children2);

            if (elemChildren1.size() != elemChildren2.size()) {
                return false;
            }

            for (int i = 0; i < elemChildren1.size(); i++) {
                if (!nodesAreValueEqual(elemChildren1.get(i), elemChildren2.get(i))) {
                    return false;
                }
            }
            // All checks passed
            return true;
        }
        // Other node types - compare by value
        return n1.getNodeValue() != null && n1.getNodeValue().equals(n2.getNodeValue());
    }

    private List<Node> getElementNodes(NodeList nodeList) {
        List<Node> result = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                result.add(node);
            }
        }
        return result;
    }

    private Boolean evaluateSomeCondition(XQueryParser.CondContext ctx) {
        // Save the current variable context to restore later
        Map<String, List<Node>> savedContext = new HashMap<>(variableContext);

        int varCount = ctx.var().size();
        List<String> varNames = new ArrayList<>();
        List<XQueryParser.XqContext> xqContexts = new ArrayList<>();

        // Get all variables and their XQ expressions
        for (int i = 0; i < varCount; i++) {
            varNames.add(ctx.var(i).getText());
            xqContexts.add(ctx.xq(i));
        }

        // Get the condition to be evaluated
        XQueryParser.CondContext condToEval = ctx.cond(0);

        // Implement recursive evaluation using backtracking
        return backtrackSome(0, varNames, xqContexts, condToEval, savedContext);
    }

    // Recursive backtracking for "some" expression
    private Boolean backtrackSome(int index, List<String> varNames, List<XQueryParser.XqContext> xqContexts,
                                  XQueryParser.CondContext condToEval, Map<String, List<Node>> originalContext) {
        if (index == varNames.size()) {
            // All variables bound, evaluate the condition
            return evaluateCondition(condToEval);
        }

        String currentVar = varNames.get(index);
        List<Node> possibleValues = visit(xqContexts.get(index));

        for (Node value : possibleValues) {
            // Bind this variable to the current value
            List<Node> singleValue = new ArrayList<>();
            singleValue.add(value);
            variableContext.put(currentVar, singleValue);

            // Recursively try the next variable
            if (backtrackSome(index + 1, varNames, xqContexts, condToEval, originalContext)) {
                // Restore context before returning
                variableContext = new HashMap<>(originalContext);
                return true;
            }
        }

        // Restore context when backtracking
        variableContext = new HashMap<>(originalContext);
        return false;
    }

}
