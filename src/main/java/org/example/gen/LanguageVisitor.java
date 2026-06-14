// Generated from C:/Users/Anthony/IdeaProjects/CompiladoresLayze/src/main/antlr4/org/example/Language.g4 by ANTLR 4.13.2
 package org.example.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LanguageParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(LanguageParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#decls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecls(LanguageParser.DeclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#listDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListDecl(LanguageParser.ListDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#declTip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclTip(LanguageParser.DeclTipContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#listId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListId(LanguageParser.ListIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#tip}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTip(LanguageParser.TipContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#cmdComp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdComp(LanguageParser.CmdCompContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#listCmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListCmd(LanguageParser.ListCmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#cmdIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdIf(LanguageParser.CmdIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#cmdIfCasado}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdIfCasado(LanguageParser.CmdIfCasadoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#cmdIfNaoCasado}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdIfNaoCasado(LanguageParser.CmdIfNaoCasadoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#cmds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmds(LanguageParser.CmdsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#cmdRead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdRead(LanguageParser.CmdReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#cmdWrite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdWrite(LanguageParser.CmdWriteContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#listW}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListW(LanguageParser.ListWContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#elemW}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElemW(LanguageParser.ElemWContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#cmdAtrib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdAtrib(LanguageParser.CmdAtribContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(LanguageParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#exprRel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRel(LanguageParser.ExprRelContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#exprSimple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSimple(LanguageParser.ExprSimpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#exprMult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMult(LanguageParser.ExprMultContext ctx);
	/**
	 * Visit a parse tree produced by {@link LanguageParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(LanguageParser.TermoContext ctx);
}