package main;

import main.antlr.XQueryBaseVisitor;
import main.antlr.XQueryParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.*;

public class XQueryEvaluator extends XQueryBaseVisitor<List<Node>> {
    // add required data structures
    // may need map for storing var?



    // entry point is visitXq instead of visitAp for xquery
    @Override
    public List<Node> visitXq(XQueryParser.XqContext ctx) {
        // TODO
        return new ArrayList<>();
    }

    // combine old visitAp and Eval_A?
    @Override
    public List<Node> visitAp(XQueryParser.ApContext ctx) {

    }

    // old Eval_R?
    @Override
    public List<Node> visitRp(XQueryParser.RpContext ctx) {
        // TODO
        return new ArrayList<>();
    }

    // old Eval_F?
    @Override
    public List<Node> visitF(XQueryParser.FContext ctx) {
        // TODO
        return new ArrayList<>();
    }

    @Override
    public List<Node> visitForClause(XQueryParser.ForClauseContext ctx) {
        // TODO
        return new ArrayList<>();
    }

    @Override
    public List<Node> visitLetClause(XQueryParser.LetClauseContext ctx) {
        // TODO
        return new ArrayList<>();
    }

    @Override
    public List<Node> visitWhereClause(XQueryParser.WhereClauseContext ctx) {
        // TODO
        return new ArrayList<>();
    }

    @Override
    public List<Node> visitReturnClause(XQueryParser.ReturnClauseContext ctx) {
        // TODO
        return new ArrayList<>();
    }

    @Override
    public Boolean visitCond(XQueryParser.CondContext ctx) {
        // TODO
        return false;
    }

    // TODO!!
    // add more if needed, see main.antlr.XQueryBaseVisitor.java
    // e.g. visitDoc(), visitVar(), visitTagName(), visitAttrName()

}