package impl.XPath;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
    } catch (IOException | ParserConfigurationException | SAXException e) {
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

    // single child case
    if (t.getChildCount() == 1) {
      // TAGNAME
      if (t.getText().matches("[a-zA-Z_][a-zA-Z0-9_-]*")) {
        String tagName = t.getChild(0).getText();
        NodeList nodes = n.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
          Node node = nodes.item(i);
          if (
            node.getNodeType() == Node.ELEMENT_NODE &&
            node.getNodeName().equals(tagName)
          ) {
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
        if (parent != null) {
          res.add(parent);
        }
      }
      // 'text()'
      else if (t.getChild(0).getText().equals("text()")) {
        NodeList nodes = n.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
          if (nodes.item(i).getNodeType() == Node.TEXT_NODE) {
            res.add(nodes.item(i));
          }
        }
      }
    }
    // multiple child case
    else {
      // '@' ATTRNAME
      if (t.getChild(0).getText().equals("@")) {
        if (n.getNodeType() == Node.ELEMENT_NODE && n.hasAttributes()) {
          String attName = t.getChild(1).getText();
          Node attNode = ((org.w3c.dom.Element) n).getAttributeNode(attName);
          if (attNode != null) {
            res.add(attNode);
          }
        }
      }
      // '(' rp ')'
      else if (
        "(".equals(t.getChild(0).getText()) &&
        ")".equals(t.getChild(2).getText())
      ) {
        res.addAll(Eval_R(t, (Node) t.getChild(1)));
      } else if (t.getChildCount() == 3) {
        ParseTree left = t.getChild(0);
        ParseTree op = t.getChild(1);
        ParseTree right = t.getChild(0);
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
          default -> {}
        }
      } else if (
        t.getChildCount() == 4 &&
        t.getChild(1).getText().equals("[") &&
        t.getChild(3).getText().equals("]")
      ) {
        ParseTree rp = t.getChild(0);
        ParseTree filter = t.getChild(0);
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
    return null;
  }
}
