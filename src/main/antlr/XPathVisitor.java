// Generated from XPath.g4 by ANTLR 4.13.2

package main.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XPathParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XPathVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XPathParser#xq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXq(XPathParser.XqContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForClause(XPathParser.ForClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#letClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetClause(XPathParser.LetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(XPathParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#returnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnClause(XPathParser.ReturnClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(XPathParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAp(XPathParser.ApContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#doc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoc(XPathParser.DocContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp(XPathParser.RpContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF(XPathParser.FContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(XPathParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(XPathParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathParser#attrName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrName(XPathParser.AttrNameContext ctx);
}