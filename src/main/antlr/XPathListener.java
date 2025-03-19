// Generated from src/main/antlr/XPath.g4 by ANTLR 4.13.2

package main.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPathParser}.
 */
public interface XPathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void enterXq(XPathParser.XqContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 */
	void exitXq(XPathParser.XqContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(XPathParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(XPathParser.ForClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#letClause}.
	 * @param ctx the parse tree
	 */
	void enterLetClause(XPathParser.LetClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#letClause}.
	 * @param ctx the parse tree
	 */
	void exitLetClause(XPathParser.LetClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(XPathParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(XPathParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterReturnClause(XPathParser.ReturnClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitReturnClause(XPathParser.ReturnClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void enterJoinClause(XPathParser.JoinClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void exitJoinClause(XPathParser.JoinClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(XPathParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(XPathParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterAp(XPathParser.ApContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitAp(XPathParser.ApContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#doc}.
	 * @param ctx the parse tree
	 */
	void enterDoc(XPathParser.DocContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#doc}.
	 * @param ctx the parse tree
	 */
	void exitDoc(XPathParser.DocContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp(XPathParser.RpContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp(XPathParser.RpContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterF(XPathParser.FContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitF(XPathParser.FContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(XPathParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(XPathParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XPathParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XPathParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#attrName}.
	 * @param ctx the parse tree
	 */
	void enterAttrName(XPathParser.AttrNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#attrName}.
	 * @param ctx the parse tree
	 */
	void exitAttrName(XPathParser.AttrNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#keyList}.
	 * @param ctx the parse tree
	 */
	void enterKeyList(XPathParser.KeyListContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#keyList}.
	 * @param ctx the parse tree
	 */
	void exitKeyList(XPathParser.KeyListContext ctx);
}