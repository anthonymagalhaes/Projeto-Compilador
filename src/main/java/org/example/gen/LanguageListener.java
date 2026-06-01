// Generated from C:/Users/Anthony/IdeaProjects/CompiladoresLayze/src/main/antlr4/org/example/Language.g4 by ANTLR 4.13.2
 package org.example.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageParser}.
 */
public interface LanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(LanguageParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(LanguageParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#decls}.
	 * @param ctx the parse tree
	 */
	void enterDecls(LanguageParser.DeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#decls}.
	 * @param ctx the parse tree
	 */
	void exitDecls(LanguageParser.DeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#listDecl}.
	 * @param ctx the parse tree
	 */
	void enterListDecl(LanguageParser.ListDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#listDecl}.
	 * @param ctx the parse tree
	 */
	void exitListDecl(LanguageParser.ListDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#declTip}.
	 * @param ctx the parse tree
	 */
	void enterDeclTip(LanguageParser.DeclTipContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#declTip}.
	 * @param ctx the parse tree
	 */
	void exitDeclTip(LanguageParser.DeclTipContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#listId}.
	 * @param ctx the parse tree
	 */
	void enterListId(LanguageParser.ListIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#listId}.
	 * @param ctx the parse tree
	 */
	void exitListId(LanguageParser.ListIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#tip}.
	 * @param ctx the parse tree
	 */
	void enterTip(LanguageParser.TipContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#tip}.
	 * @param ctx the parse tree
	 */
	void exitTip(LanguageParser.TipContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#cmdComp}.
	 * @param ctx the parse tree
	 */
	void enterCmdComp(LanguageParser.CmdCompContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#cmdComp}.
	 * @param ctx the parse tree
	 */
	void exitCmdComp(LanguageParser.CmdCompContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#listCmd}.
	 * @param ctx the parse tree
	 */
	void enterListCmd(LanguageParser.ListCmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#listCmd}.
	 * @param ctx the parse tree
	 */
	void exitListCmd(LanguageParser.ListCmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(LanguageParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(LanguageParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void enterCmdIf(LanguageParser.CmdIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void exitCmdIf(LanguageParser.CmdIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdWhile(LanguageParser.CmdWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdWhile(LanguageParser.CmdWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#cmdRead}.
	 * @param ctx the parse tree
	 */
	void enterCmdRead(LanguageParser.CmdReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#cmdRead}.
	 * @param ctx the parse tree
	 */
	void exitCmdRead(LanguageParser.CmdReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#cmdWrite}.
	 * @param ctx the parse tree
	 */
	void enterCmdWrite(LanguageParser.CmdWriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#cmdWrite}.
	 * @param ctx the parse tree
	 */
	void exitCmdWrite(LanguageParser.CmdWriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#listW}.
	 * @param ctx the parse tree
	 */
	void enterListW(LanguageParser.ListWContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#listW}.
	 * @param ctx the parse tree
	 */
	void exitListW(LanguageParser.ListWContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#elemW}.
	 * @param ctx the parse tree
	 */
	void enterElemW(LanguageParser.ElemWContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#elemW}.
	 * @param ctx the parse tree
	 */
	void exitElemW(LanguageParser.ElemWContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#cmdAtrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtrib(LanguageParser.CmdAtribContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#cmdAtrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtrib(LanguageParser.CmdAtribContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LanguageParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LanguageParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#exprRel}.
	 * @param ctx the parse tree
	 */
	void enterExprRel(LanguageParser.ExprRelContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#exprRel}.
	 * @param ctx the parse tree
	 */
	void exitExprRel(LanguageParser.ExprRelContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#exprSimple}.
	 * @param ctx the parse tree
	 */
	void enterExprSimple(LanguageParser.ExprSimpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#exprSimple}.
	 * @param ctx the parse tree
	 */
	void exitExprSimple(LanguageParser.ExprSimpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#exprMult}.
	 * @param ctx the parse tree
	 */
	void enterExprMult(LanguageParser.ExprMultContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#exprMult}.
	 * @param ctx the parse tree
	 */
	void exitExprMult(LanguageParser.ExprMultContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(LanguageParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(LanguageParser.TermoContext ctx);
}