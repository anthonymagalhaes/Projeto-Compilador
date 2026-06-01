// Generated from C:/Users/Anthony/IdeaProjects/CompiladoresLayze/src/main/antlr4/org/example/Language.g4 by ANTLR 4.13.2
 package org.example.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROGRAM=1, INTEGER=2, BOOLEAN=3, BEGIN=4, END=5, WHILE=6, DO=7, READ=8, 
		VAR=9, FALSE=10, TRUE=11, WRITE=12, OPAD=13, OPMULT=14, OPLOG=15, OPNEG=16, 
		OPREL=17, PVIG=18, ATRIB=19, PONTO=20, DPONTOS=21, VIG=22, ABPAR=23, FPAR=24, 
		STRING=25, CADEIA=26, IF=27, ELSE=28, THEN=29, CTE=30, IDENTIFIER=31, 
		WS=32, COMENTARIO=33, ERRO_LEXICO=34;
	public static final int
		RULE_prog = 0, RULE_decls = 1, RULE_listDecl = 2, RULE_declTip = 3, RULE_listId = 4, 
		RULE_tip = 5, RULE_cmdComp = 6, RULE_listCmd = 7, RULE_cmd = 8, RULE_cmdIf = 9, 
		RULE_cmdWhile = 10, RULE_cmdRead = 11, RULE_cmdWrite = 12, RULE_listW = 13, 
		RULE_elemW = 14, RULE_cmdAtrib = 15, RULE_expr = 16, RULE_exprRel = 17, 
		RULE_exprSimple = 18, RULE_exprMult = 19, RULE_termo = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decls", "listDecl", "declTip", "listId", "tip", "cmdComp", "listCmd", 
			"cmd", "cmdIf", "cmdWhile", "cmdRead", "cmdWrite", "listW", "elemW", 
			"cmdAtrib", "expr", "exprRel", "exprSimple", "exprMult", "termo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'integer'", "'boolean'", "'begin'", "'end'", "'while'", 
			"'do'", "'read'", "'var'", "'false'", "'true'", "'write'", null, null, 
			null, "'~'", null, "';'", "':='", "'.'", "':'", "','", "'('", "')'", 
			"'string'", null, "'if'", "'else'", "'then'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROGRAM", "INTEGER", "BOOLEAN", "BEGIN", "END", "WHILE", "DO", 
			"READ", "VAR", "FALSE", "TRUE", "WRITE", "OPAD", "OPMULT", "OPLOG", "OPNEG", 
			"OPREL", "PVIG", "ATRIB", "PONTO", "DPONTOS", "VIG", "ABPAR", "FPAR", 
			"STRING", "CADEIA", "IF", "ELSE", "THEN", "CTE", "IDENTIFIER", "WS", 
			"COMENTARIO", "ERRO_LEXICO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(LanguageParser.PROGRAM, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LanguageParser.IDENTIFIER, 0); }
		public TerminalNode PVIG() { return getToken(LanguageParser.PVIG, 0); }
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public CmdCompContext cmdComp() {
			return getRuleContext(CmdCompContext.class,0);
		}
		public TerminalNode PONTO() { return getToken(LanguageParser.PONTO, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(PROGRAM);
			setState(43);
			match(IDENTIFIER);
			setState(44);
			match(PVIG);
			setState(45);
			decls();
			setState(46);
			cmdComp();
			setState(47);
			match(PONTO);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclsContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(LanguageParser.VAR, 0); }
		public ListDeclContext listDecl() {
			return getRuleContext(ListDeclContext.class,0);
		}
		public DeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitDecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitDecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclsContext decls() throws RecognitionException {
		DeclsContext _localctx = new DeclsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decls);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(VAR);
				setState(50);
				listDecl();
				}
				break;
			case BEGIN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListDeclContext extends ParserRuleContext {
		public DeclTipContext declTip() {
			return getRuleContext(DeclTipContext.class,0);
		}
		public ListDeclContext listDecl() {
			return getRuleContext(ListDeclContext.class,0);
		}
		public ListDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterListDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitListDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitListDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListDeclContext listDecl() throws RecognitionException {
		ListDeclContext _localctx = new ListDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_listDecl);
		try {
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				declTip();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				declTip();
				setState(56);
				listDecl();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclTipContext extends ParserRuleContext {
		public ListIdContext listId() {
			return getRuleContext(ListIdContext.class,0);
		}
		public TerminalNode DPONTOS() { return getToken(LanguageParser.DPONTOS, 0); }
		public TipContext tip() {
			return getRuleContext(TipContext.class,0);
		}
		public TerminalNode PVIG() { return getToken(LanguageParser.PVIG, 0); }
		public DeclTipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declTip; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterDeclTip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitDeclTip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitDeclTip(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclTipContext declTip() throws RecognitionException {
		DeclTipContext _localctx = new DeclTipContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declTip);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			listId();
			setState(61);
			match(DPONTOS);
			setState(62);
			tip();
			setState(63);
			match(PVIG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(LanguageParser.IDENTIFIER, 0); }
		public TerminalNode VIG() { return getToken(LanguageParser.VIG, 0); }
		public ListIdContext listId() {
			return getRuleContext(ListIdContext.class,0);
		}
		public ListIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterListId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitListId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitListId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListIdContext listId() throws RecognitionException {
		ListIdContext _localctx = new ListIdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_listId);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(IDENTIFIER);
				setState(67);
				match(VIG);
				setState(68);
				listId();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(LanguageParser.INTEGER, 0); }
		public TerminalNode BOOLEAN() { return getToken(LanguageParser.BOOLEAN, 0); }
		public TerminalNode STRING() { return getToken(LanguageParser.STRING, 0); }
		public TipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tip; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterTip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitTip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitTip(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipContext tip() throws RecognitionException {
		TipContext _localctx = new TipContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tip);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33554444L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdCompContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(LanguageParser.BEGIN, 0); }
		public ListCmdContext listCmd() {
			return getRuleContext(ListCmdContext.class,0);
		}
		public TerminalNode END() { return getToken(LanguageParser.END, 0); }
		public CmdCompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdComp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterCmdComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitCmdComp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitCmdComp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdCompContext cmdComp() throws RecognitionException {
		CmdCompContext _localctx = new CmdCompContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdComp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(BEGIN);
			setState(74);
			listCmd();
			setState(75);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListCmdContext extends ParserRuleContext {
		public CmdContext cmd() {
			return getRuleContext(CmdContext.class,0);
		}
		public TerminalNode PVIG() { return getToken(LanguageParser.PVIG, 0); }
		public ListCmdContext listCmd() {
			return getRuleContext(ListCmdContext.class,0);
		}
		public ListCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterListCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitListCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitListCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListCmdContext listCmd() throws RecognitionException {
		ListCmdContext _localctx = new ListCmdContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_listCmd);
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				cmd();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				cmd();
				setState(79);
				match(PVIG);
				setState(80);
				listCmd();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public CmdIfContext cmdIf() {
			return getRuleContext(CmdIfContext.class,0);
		}
		public CmdWhileContext cmdWhile() {
			return getRuleContext(CmdWhileContext.class,0);
		}
		public CmdReadContext cmdRead() {
			return getRuleContext(CmdReadContext.class,0);
		}
		public CmdWriteContext cmdWrite() {
			return getRuleContext(CmdWriteContext.class,0);
		}
		public CmdAtribContext cmdAtrib() {
			return getRuleContext(CmdAtribContext.class,0);
		}
		public CmdCompContext cmdComp() {
			return getRuleContext(CmdCompContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmd);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				cmdIf();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				cmdWhile();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				cmdRead();
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 4);
				{
				setState(87);
				cmdWrite();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 5);
				{
				setState(88);
				cmdAtrib();
				}
				break;
			case BEGIN:
				enterOuterAlt(_localctx, 6);
				{
				setState(89);
				cmdComp();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdIfContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(LanguageParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(LanguageParser.THEN, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(LanguageParser.ELSE, 0); }
		public CmdIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterCmdIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitCmdIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitCmdIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdIfContext cmdIf() throws RecognitionException {
		CmdIfContext _localctx = new CmdIfContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdIf);
		try {
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				match(IF);
				setState(93);
				expr(0);
				setState(94);
				match(THEN);
				setState(95);
				cmd();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				match(IF);
				setState(98);
				expr(0);
				setState(99);
				match(THEN);
				setState(100);
				cmd();
				setState(101);
				match(ELSE);
				setState(102);
				cmd();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdWhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(LanguageParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DO() { return getToken(LanguageParser.DO, 0); }
		public CmdContext cmd() {
			return getRuleContext(CmdContext.class,0);
		}
		public CmdWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterCmdWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitCmdWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitCmdWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdWhileContext cmdWhile() throws RecognitionException {
		CmdWhileContext _localctx = new CmdWhileContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdWhile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(WHILE);
			setState(107);
			expr(0);
			setState(108);
			match(DO);
			setState(109);
			cmd();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdReadContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(LanguageParser.READ, 0); }
		public TerminalNode ABPAR() { return getToken(LanguageParser.ABPAR, 0); }
		public ListIdContext listId() {
			return getRuleContext(ListIdContext.class,0);
		}
		public TerminalNode FPAR() { return getToken(LanguageParser.FPAR, 0); }
		public CmdReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdRead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterCmdRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitCmdRead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitCmdRead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdReadContext cmdRead() throws RecognitionException {
		CmdReadContext _localctx = new CmdReadContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdRead);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(READ);
			setState(112);
			match(ABPAR);
			setState(113);
			listId();
			setState(114);
			match(FPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdWriteContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(LanguageParser.WRITE, 0); }
		public TerminalNode ABPAR() { return getToken(LanguageParser.ABPAR, 0); }
		public ListWContext listW() {
			return getRuleContext(ListWContext.class,0);
		}
		public TerminalNode FPAR() { return getToken(LanguageParser.FPAR, 0); }
		public CmdWriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWrite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterCmdWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitCmdWrite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitCmdWrite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdWriteContext cmdWrite() throws RecognitionException {
		CmdWriteContext _localctx = new CmdWriteContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cmdWrite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(WRITE);
			setState(117);
			match(ABPAR);
			setState(118);
			listW();
			setState(119);
			match(FPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListWContext extends ParserRuleContext {
		public ElemWContext elemW() {
			return getRuleContext(ElemWContext.class,0);
		}
		public TerminalNode VIG() { return getToken(LanguageParser.VIG, 0); }
		public ListWContext listW() {
			return getRuleContext(ListWContext.class,0);
		}
		public ListWContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listW; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterListW(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitListW(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitListW(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListWContext listW() throws RecognitionException {
		ListWContext _localctx = new ListWContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_listW);
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				elemW();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				elemW();
				setState(123);
				match(VIG);
				setState(124);
				listW();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElemWContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CADEIA() { return getToken(LanguageParser.CADEIA, 0); }
		public ElemWContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elemW; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterElemW(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitElemW(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitElemW(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElemWContext elemW() throws RecognitionException {
		ElemWContext _localctx = new ElemWContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_elemW);
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
			case TRUE:
			case OPAD:
			case OPNEG:
			case ABPAR:
			case CTE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				expr(0);
				}
				break;
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(CADEIA);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdAtribContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(LanguageParser.IDENTIFIER, 0); }
		public TerminalNode ATRIB() { return getToken(LanguageParser.ATRIB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CmdAtribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAtrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterCmdAtrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitCmdAtrib(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitCmdAtrib(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdAtribContext cmdAtrib() throws RecognitionException {
		CmdAtribContext _localctx = new CmdAtribContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_cmdAtrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(IDENTIFIER);
			setState(133);
			match(ATRIB);
			setState(134);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprRelContext exprRel() {
			return getRuleContext(ExprRelContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OPLOG() { return getToken(LanguageParser.OPLOG, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(137);
			exprRel(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(139);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(140);
					match(OPLOG);
					setState(141);
					exprRel(0);
					}
					} 
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprRelContext extends ParserRuleContext {
		public ExprSimpleContext exprSimple() {
			return getRuleContext(ExprSimpleContext.class,0);
		}
		public ExprRelContext exprRel() {
			return getRuleContext(ExprRelContext.class,0);
		}
		public TerminalNode OPREL() { return getToken(LanguageParser.OPREL, 0); }
		public ExprRelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprRel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterExprRel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitExprRel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitExprRel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprRelContext exprRel() throws RecognitionException {
		return exprRel(0);
	}

	private ExprRelContext exprRel(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprRelContext _localctx = new ExprRelContext(_ctx, _parentState);
		ExprRelContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_exprRel, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(148);
			exprSimple(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(155);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprRelContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exprRel);
					setState(150);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(151);
					match(OPREL);
					setState(152);
					exprSimple(0);
					}
					} 
				}
				setState(157);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprSimpleContext extends ParserRuleContext {
		public ExprMultContext exprMult() {
			return getRuleContext(ExprMultContext.class,0);
		}
		public ExprSimpleContext exprSimple() {
			return getRuleContext(ExprSimpleContext.class,0);
		}
		public TerminalNode OPAD() { return getToken(LanguageParser.OPAD, 0); }
		public ExprSimpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprSimple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterExprSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitExprSimple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitExprSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprSimpleContext exprSimple() throws RecognitionException {
		return exprSimple(0);
	}

	private ExprSimpleContext exprSimple(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprSimpleContext _localctx = new ExprSimpleContext(_ctx, _parentState);
		ExprSimpleContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_exprSimple, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(159);
			exprMult(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprSimpleContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exprSimple);
					setState(161);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(162);
					match(OPAD);
					setState(163);
					exprMult(0);
					}
					} 
				}
				setState(168);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprMultContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExprMultContext exprMult() {
			return getRuleContext(ExprMultContext.class,0);
		}
		public TerminalNode OPMULT() { return getToken(LanguageParser.OPMULT, 0); }
		public ExprMultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprMult; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterExprMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitExprMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitExprMult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprMultContext exprMult() throws RecognitionException {
		return exprMult(0);
	}

	private ExprMultContext exprMult(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprMultContext _localctx = new ExprMultContext(_ctx, _parentState);
		ExprMultContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_exprMult, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(170);
			termo();
			}
			_ctx.stop = _input.LT(-1);
			setState(177);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprMultContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exprMult);
					setState(172);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(173);
					match(OPMULT);
					setState(174);
					termo();
					}
					} 
				}
				setState(179);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(LanguageParser.IDENTIFIER, 0); }
		public TerminalNode CTE() { return getToken(LanguageParser.CTE, 0); }
		public TerminalNode ABPAR() { return getToken(LanguageParser.ABPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FPAR() { return getToken(LanguageParser.FPAR, 0); }
		public TerminalNode TRUE() { return getToken(LanguageParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(LanguageParser.FALSE, 0); }
		public TerminalNode OPNEG() { return getToken(LanguageParser.OPNEG, 0); }
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public TerminalNode OPAD() { return getToken(LanguageParser.OPAD, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LanguageListener ) ((LanguageListener)listener).exitTermo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LanguageVisitor ) return ((LanguageVisitor<? extends T>)visitor).visitTermo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_termo);
		try {
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				match(IDENTIFIER);
				}
				break;
			case CTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				match(CTE);
				}
				break;
			case ABPAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				match(ABPAR);
				setState(183);
				expr(0);
				setState(184);
				match(FPAR);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(186);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 5);
				{
				setState(187);
				match(FALSE);
				}
				break;
			case OPNEG:
				enterOuterAlt(_localctx, 6);
				{
				setState(188);
				match(OPNEG);
				setState(189);
				termo();
				}
				break;
			case OPAD:
				enterOuterAlt(_localctx, 7);
				{
				setState(190);
				match(OPAD);
				setState(191);
				termo();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 17:
			return exprRel_sempred((ExprRelContext)_localctx, predIndex);
		case 18:
			return exprSimple_sempred((ExprSimpleContext)_localctx, predIndex);
		case 19:
			return exprMult_sempred((ExprMultContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exprRel_sempred(ExprRelContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exprSimple_sempred(ExprSimpleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exprMult_sempred(ExprMultContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\"\u00c3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u00015\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002;\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004F\b\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007S\b\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0003\b[\b\b\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\ti\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u007f\b\r\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u0083\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0005\u0010\u008f\b\u0010\n\u0010\f\u0010\u0092\t\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005"+
		"\u0011\u009a\b\u0011\n\u0011\f\u0011\u009d\t\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00a5\b\u0012"+
		"\n\u0012\f\u0012\u00a8\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u00b0\b\u0013\n\u0013\f\u0013"+
		"\u00b3\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0003\u0014\u00c1\b\u0014\u0001\u0014\u0000\u0004 \"$&\u0015"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(\u0000\u0001\u0002\u0000\u0002\u0003\u0019\u0019\u00c3"+
		"\u0000*\u0001\u0000\u0000\u0000\u00024\u0001\u0000\u0000\u0000\u0004:"+
		"\u0001\u0000\u0000\u0000\u0006<\u0001\u0000\u0000\u0000\bE\u0001\u0000"+
		"\u0000\u0000\nG\u0001\u0000\u0000\u0000\fI\u0001\u0000\u0000\u0000\u000e"+
		"R\u0001\u0000\u0000\u0000\u0010Z\u0001\u0000\u0000\u0000\u0012h\u0001"+
		"\u0000\u0000\u0000\u0014j\u0001\u0000\u0000\u0000\u0016o\u0001\u0000\u0000"+
		"\u0000\u0018t\u0001\u0000\u0000\u0000\u001a~\u0001\u0000\u0000\u0000\u001c"+
		"\u0082\u0001\u0000\u0000\u0000\u001e\u0084\u0001\u0000\u0000\u0000 \u0088"+
		"\u0001\u0000\u0000\u0000\"\u0093\u0001\u0000\u0000\u0000$\u009e\u0001"+
		"\u0000\u0000\u0000&\u00a9\u0001\u0000\u0000\u0000(\u00c0\u0001\u0000\u0000"+
		"\u0000*+\u0005\u0001\u0000\u0000+,\u0005\u001f\u0000\u0000,-\u0005\u0012"+
		"\u0000\u0000-.\u0003\u0002\u0001\u0000./\u0003\f\u0006\u0000/0\u0005\u0014"+
		"\u0000\u00000\u0001\u0001\u0000\u0000\u000012\u0005\t\u0000\u000025\u0003"+
		"\u0004\u0002\u000035\u0001\u0000\u0000\u000041\u0001\u0000\u0000\u0000"+
		"43\u0001\u0000\u0000\u00005\u0003\u0001\u0000\u0000\u00006;\u0003\u0006"+
		"\u0003\u000078\u0003\u0006\u0003\u000089\u0003\u0004\u0002\u00009;\u0001"+
		"\u0000\u0000\u0000:6\u0001\u0000\u0000\u0000:7\u0001\u0000\u0000\u0000"+
		";\u0005\u0001\u0000\u0000\u0000<=\u0003\b\u0004\u0000=>\u0005\u0015\u0000"+
		"\u0000>?\u0003\n\u0005\u0000?@\u0005\u0012\u0000\u0000@\u0007\u0001\u0000"+
		"\u0000\u0000AF\u0005\u001f\u0000\u0000BC\u0005\u001f\u0000\u0000CD\u0005"+
		"\u0016\u0000\u0000DF\u0003\b\u0004\u0000EA\u0001\u0000\u0000\u0000EB\u0001"+
		"\u0000\u0000\u0000F\t\u0001\u0000\u0000\u0000GH\u0007\u0000\u0000\u0000"+
		"H\u000b\u0001\u0000\u0000\u0000IJ\u0005\u0004\u0000\u0000JK\u0003\u000e"+
		"\u0007\u0000KL\u0005\u0005\u0000\u0000L\r\u0001\u0000\u0000\u0000MS\u0003"+
		"\u0010\b\u0000NO\u0003\u0010\b\u0000OP\u0005\u0012\u0000\u0000PQ\u0003"+
		"\u000e\u0007\u0000QS\u0001\u0000\u0000\u0000RM\u0001\u0000\u0000\u0000"+
		"RN\u0001\u0000\u0000\u0000S\u000f\u0001\u0000\u0000\u0000T[\u0003\u0012"+
		"\t\u0000U[\u0003\u0014\n\u0000V[\u0003\u0016\u000b\u0000W[\u0003\u0018"+
		"\f\u0000X[\u0003\u001e\u000f\u0000Y[\u0003\f\u0006\u0000ZT\u0001\u0000"+
		"\u0000\u0000ZU\u0001\u0000\u0000\u0000ZV\u0001\u0000\u0000\u0000ZW\u0001"+
		"\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000ZY\u0001\u0000\u0000\u0000"+
		"[\u0011\u0001\u0000\u0000\u0000\\]\u0005\u001b\u0000\u0000]^\u0003 \u0010"+
		"\u0000^_\u0005\u001d\u0000\u0000_`\u0003\u0010\b\u0000`i\u0001\u0000\u0000"+
		"\u0000ab\u0005\u001b\u0000\u0000bc\u0003 \u0010\u0000cd\u0005\u001d\u0000"+
		"\u0000de\u0003\u0010\b\u0000ef\u0005\u001c\u0000\u0000fg\u0003\u0010\b"+
		"\u0000gi\u0001\u0000\u0000\u0000h\\\u0001\u0000\u0000\u0000ha\u0001\u0000"+
		"\u0000\u0000i\u0013\u0001\u0000\u0000\u0000jk\u0005\u0006\u0000\u0000"+
		"kl\u0003 \u0010\u0000lm\u0005\u0007\u0000\u0000mn\u0003\u0010\b\u0000"+
		"n\u0015\u0001\u0000\u0000\u0000op\u0005\b\u0000\u0000pq\u0005\u0017\u0000"+
		"\u0000qr\u0003\b\u0004\u0000rs\u0005\u0018\u0000\u0000s\u0017\u0001\u0000"+
		"\u0000\u0000tu\u0005\f\u0000\u0000uv\u0005\u0017\u0000\u0000vw\u0003\u001a"+
		"\r\u0000wx\u0005\u0018\u0000\u0000x\u0019\u0001\u0000\u0000\u0000y\u007f"+
		"\u0003\u001c\u000e\u0000z{\u0003\u001c\u000e\u0000{|\u0005\u0016\u0000"+
		"\u0000|}\u0003\u001a\r\u0000}\u007f\u0001\u0000\u0000\u0000~y\u0001\u0000"+
		"\u0000\u0000~z\u0001\u0000\u0000\u0000\u007f\u001b\u0001\u0000\u0000\u0000"+
		"\u0080\u0083\u0003 \u0010\u0000\u0081\u0083\u0005\u001a\u0000\u0000\u0082"+
		"\u0080\u0001\u0000\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083"+
		"\u001d\u0001\u0000\u0000\u0000\u0084\u0085\u0005\u001f\u0000\u0000\u0085"+
		"\u0086\u0005\u0013\u0000\u0000\u0086\u0087\u0003 \u0010\u0000\u0087\u001f"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0006\u0010\uffff\uffff\u0000\u0089"+
		"\u008a\u0003\"\u0011\u0000\u008a\u0090\u0001\u0000\u0000\u0000\u008b\u008c"+
		"\n\u0002\u0000\u0000\u008c\u008d\u0005\u000f\u0000\u0000\u008d\u008f\u0003"+
		"\"\u0011\u0000\u008e\u008b\u0001\u0000\u0000\u0000\u008f\u0092\u0001\u0000"+
		"\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000"+
		"\u0000\u0000\u0091!\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0006\u0011\uffff\uffff\u0000\u0094\u0095\u0003$\u0012"+
		"\u0000\u0095\u009b\u0001\u0000\u0000\u0000\u0096\u0097\n\u0002\u0000\u0000"+
		"\u0097\u0098\u0005\u0011\u0000\u0000\u0098\u009a\u0003$\u0012\u0000\u0099"+
		"\u0096\u0001\u0000\u0000\u0000\u009a\u009d\u0001\u0000\u0000\u0000\u009b"+
		"\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c"+
		"#\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0006\u0012\uffff\uffff\u0000\u009f\u00a0\u0003&\u0013\u0000\u00a0\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a2\n\u0002\u0000\u0000\u00a2\u00a3\u0005"+
		"\r\u0000\u0000\u00a3\u00a5\u0003&\u0013\u0000\u00a4\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7%\u0001\u0000\u0000"+
		"\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9\u00aa\u0006\u0013\uffff"+
		"\uffff\u0000\u00aa\u00ab\u0003(\u0014\u0000\u00ab\u00b1\u0001\u0000\u0000"+
		"\u0000\u00ac\u00ad\n\u0002\u0000\u0000\u00ad\u00ae\u0005\u000e\u0000\u0000"+
		"\u00ae\u00b0\u0003(\u0014\u0000\u00af\u00ac\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b2\'\u0001\u0000\u0000\u0000\u00b3\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b4\u00c1\u0005\u001f\u0000\u0000\u00b5\u00c1"+
		"\u0005\u001e\u0000\u0000\u00b6\u00b7\u0005\u0017\u0000\u0000\u00b7\u00b8"+
		"\u0003 \u0010\u0000\u00b8\u00b9\u0005\u0018\u0000\u0000\u00b9\u00c1\u0001"+
		"\u0000\u0000\u0000\u00ba\u00c1\u0005\u000b\u0000\u0000\u00bb\u00c1\u0005"+
		"\n\u0000\u0000\u00bc\u00bd\u0005\u0010\u0000\u0000\u00bd\u00c1\u0003("+
		"\u0014\u0000\u00be\u00bf\u0005\r\u0000\u0000\u00bf\u00c1\u0003(\u0014"+
		"\u0000\u00c0\u00b4\u0001\u0000\u0000\u0000\u00c0\u00b5\u0001\u0000\u0000"+
		"\u0000\u00c0\u00b6\u0001\u0000\u0000\u0000\u00c0\u00ba\u0001\u0000\u0000"+
		"\u0000\u00c0\u00bb\u0001\u0000\u0000\u0000\u00c0\u00bc\u0001\u0000\u0000"+
		"\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c1)\u0001\u0000\u0000\u0000"+
		"\r4:ERZh~\u0082\u0090\u009b\u00a6\u00b1\u00c0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}