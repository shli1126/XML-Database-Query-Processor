// Generated from src/main/antlr/XPath.g4 by ANTLR 4.13.2

package main.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class XPathParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, EQ=33, IS=34, TAGNAME=35, ATTRNAME=36, STRING=37, VAR=38, WS=39;
	public static final int
		RULE_xq = 0, RULE_forClause = 1, RULE_letClause = 2, RULE_whereClause = 3, 
		RULE_returnClause = 4, RULE_joinClause = 5, RULE_cond = 6, RULE_ap = 7, 
		RULE_doc = 8, RULE_rp = 9, RULE_f = 10, RULE_var = 11, RULE_tagName = 12, 
		RULE_attrName = 13, RULE_keyList = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"xq", "forClause", "letClause", "whereClause", "returnClause", "joinClause", 
			"cond", "ap", "doc", "rp", "f", "var", "tagName", "attrName", "keyList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'/'", "'//'", "'<'", "'>'", "'{'", "'}'", 
			"'</'", "'for'", "'in'", "'let'", "':='", "'where'", "'return'", "'join'", 
			"'empty'", "'some'", "'satisfies'", "'and'", "'or'", "'not'", "'doc'", 
			"'document'", "'*'", "'.'", "'..'", "'text()'", "'@'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "EQ", "IS", "TAGNAME", 
			"ATTRNAME", "STRING", "VAR", "WS"
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
	public String getGrammarFileName() { return "XPath.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XPathParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class XqContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode STRING() { return getToken(XPathParser.STRING, 0); }
		public ApContext ap() {
			return getRuleContext(ApContext.class,0);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<TagNameContext> tagName() {
			return getRuleContexts(TagNameContext.class);
		}
		public TagNameContext tagName(int i) {
			return getRuleContext(TagNameContext.class,i);
		}
		public ForClauseContext forClause() {
			return getRuleContext(ForClauseContext.class,0);
		}
		public ReturnClauseContext returnClause() {
			return getRuleContext(ReturnClauseContext.class,0);
		}
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public JoinClauseContext joinClause() {
			return getRuleContext(JoinClauseContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterXq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitXq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitXq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XqContext xq() throws RecognitionException {
		return xq(0);
	}

	private XqContext xq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XqContext _localctx = new XqContext(_ctx, _parentState);
		XqContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_xq, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				{
				setState(31);
				var();
				}
				break;
			case STRING:
				{
				setState(32);
				match(STRING);
				}
				break;
			case T__23:
			case T__24:
				{
				setState(33);
				ap();
				}
				break;
			case T__0:
				{
				setState(34);
				match(T__0);
				setState(35);
				xq(0);
				setState(36);
				match(T__1);
				}
				break;
			case T__5:
				{
				setState(38);
				match(T__5);
				setState(39);
				tagName();
				setState(40);
				match(T__6);
				setState(41);
				match(T__7);
				setState(42);
				xq(0);
				setState(43);
				match(T__8);
				setState(44);
				match(T__9);
				setState(45);
				tagName();
				setState(46);
				match(T__6);
				}
				break;
			case T__10:
				{
				setState(48);
				forClause();
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(49);
					letClause();
					}
				}

				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(52);
					whereClause();
					}
				}

				setState(55);
				returnClause();
				}
				break;
			case T__12:
				{
				setState(57);
				letClause();
				setState(58);
				xq(2);
				}
				break;
			case T__16:
				{
				setState(60);
				joinClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(72);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new XqContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(63);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(64);
						match(T__2);
						setState(65);
						xq(8);
						}
						break;
					case 2:
						{
						_localctx = new XqContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(66);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(67);
						match(T__3);
						setState(68);
						rp(0);
						}
						break;
					case 3:
						{
						_localctx = new XqContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(69);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(70);
						match(T__4);
						setState(71);
						rp(0);
						}
						break;
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
	public static class ForClauseContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public ForClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterForClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitForClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitForClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForClauseContext forClause() throws RecognitionException {
		ForClauseContext _localctx = new ForClauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_forClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__10);
			setState(78);
			var();
			setState(79);
			match(T__11);
			setState(80);
			xq(0);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(81);
				match(T__2);
				setState(82);
				var();
				setState(83);
				match(T__11);
				setState(84);
				xq(0);
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class LetClauseContext extends ParserRuleContext {
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public LetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterLetClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitLetClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitLetClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetClauseContext letClause() throws RecognitionException {
		LetClauseContext _localctx = new LetClauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_letClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__12);
			setState(92);
			var();
			setState(93);
			match(T__13);
			setState(94);
			xq(0);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(95);
				match(T__2);
				setState(96);
				var();
				setState(97);
				match(T__13);
				setState(98);
				xq(0);
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class WhereClauseContext extends ParserRuleContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitWhereClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__14);
			setState(106);
			cond(0);
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
	public static class ReturnClauseContext extends ParserRuleContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public ReturnClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterReturnClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitReturnClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitReturnClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnClauseContext returnClause() throws RecognitionException {
		ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_returnClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__15);
			setState(109);
			xq(0);
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
	public static class JoinClauseContext extends ParserRuleContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<KeyListContext> keyList() {
			return getRuleContexts(KeyListContext.class);
		}
		public KeyListContext keyList(int i) {
			return getRuleContext(KeyListContext.class,i);
		}
		public JoinClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterJoinClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitJoinClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitJoinClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinClauseContext joinClause() throws RecognitionException {
		JoinClauseContext _localctx = new JoinClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_joinClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__16);
			setState(112);
			match(T__0);
			setState(113);
			xq(0);
			setState(114);
			match(T__2);
			setState(115);
			xq(0);
			setState(116);
			match(T__2);
			setState(117);
			keyList();
			setState(118);
			match(T__2);
			setState(119);
			keyList();
			setState(120);
			match(T__1);
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
	public static class CondContext extends ParserRuleContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public TerminalNode EQ() { return getToken(XPathParser.EQ, 0); }
		public TerminalNode IS() { return getToken(XPathParser.IS, 0); }
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public TerminalNode STRING() { return getToken(XPathParser.STRING, 0); }
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_cond, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(123);
				xq(0);
				setState(124);
				match(EQ);
				setState(125);
				xq(0);
				}
				break;
			case 2:
				{
				setState(127);
				xq(0);
				setState(128);
				match(IS);
				setState(129);
				xq(0);
				}
				break;
			case 3:
				{
				setState(131);
				match(T__17);
				setState(132);
				match(T__0);
				setState(133);
				xq(0);
				setState(134);
				match(T__1);
				}
				break;
			case 4:
				{
				setState(136);
				match(T__18);
				setState(137);
				var();
				setState(138);
				match(T__11);
				setState(139);
				xq(0);
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(140);
					match(T__2);
					setState(141);
					var();
					setState(142);
					match(T__11);
					setState(143);
					xq(0);
					}
					}
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(150);
				match(T__19);
				setState(151);
				cond(6);
				}
				break;
			case 5:
				{
				setState(153);
				match(T__0);
				setState(154);
				cond(0);
				setState(155);
				match(T__1);
				}
				break;
			case 6:
				{
				setState(157);
				match(T__22);
				setState(158);
				cond(2);
				}
				break;
			case 7:
				{
				setState(159);
				rp(0);
				setState(160);
				match(EQ);
				setState(161);
				match(STRING);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(171);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(165);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(166);
						match(T__20);
						setState(167);
						cond(5);
						}
						break;
					case 2:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(168);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(169);
						match(T__21);
						setState(170);
						cond(4);
						}
						break;
					}
					} 
				}
				setState(175);
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
	public static class ApContext extends ParserRuleContext {
		public DocContext doc() {
			return getRuleContext(DocContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public ApContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ap; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitAp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ap);
		try {
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				doc();
				setState(177);
				match(T__3);
				setState(178);
				rp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				doc();
				setState(181);
				match(T__4);
				setState(182);
				rp(0);
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
	public static class DocContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(XPathParser.STRING, 0); }
		public DocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterDoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitDoc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitDoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocContext doc() throws RecognitionException {
		DocContext _localctx = new DocContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_doc);
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				match(T__23);
				setState(187);
				match(T__0);
				setState(188);
				match(STRING);
				setState(189);
				match(T__1);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(T__24);
				setState(191);
				match(T__0);
				setState(192);
				match(STRING);
				setState(193);
				match(T__1);
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
	public static class RpContext extends ParserRuleContext {
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public AttrNameContext attrName() {
			return getRuleContext(AttrNameContext.class,0);
		}
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public RpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitRp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RpContext rp() throws RecognitionException {
		return rp(0);
	}

	private RpContext rp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RpContext _localctx = new RpContext(_ctx, _parentState);
		RpContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAGNAME:
				{
				setState(197);
				tagName();
				}
				break;
			case T__25:
				{
				setState(198);
				match(T__25);
				}
				break;
			case T__26:
				{
				setState(199);
				match(T__26);
				}
				break;
			case T__27:
				{
				setState(200);
				match(T__27);
				}
				break;
			case T__28:
				{
				setState(201);
				match(T__28);
				}
				break;
			case T__29:
				{
				setState(202);
				match(T__29);
				setState(203);
				attrName();
				}
				break;
			case T__0:
				{
				setState(204);
				match(T__0);
				setState(205);
				rp(0);
				setState(206);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(226);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(224);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(210);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(211);
						match(T__3);
						setState(212);
						rp(5);
						}
						break;
					case 2:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(213);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(214);
						match(T__4);
						setState(215);
						rp(4);
						}
						break;
					case 3:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(216);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(217);
						match(T__2);
						setState(218);
						rp(2);
						}
						break;
					case 4:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(219);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(220);
						match(T__30);
						setState(221);
						f(0);
						setState(222);
						match(T__31);
						}
						break;
					}
					} 
				}
				setState(228);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
	public static class FContext extends ParserRuleContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public TerminalNode EQ() { return getToken(XPathParser.EQ, 0); }
		public TerminalNode IS() { return getToken(XPathParser.IS, 0); }
		public TerminalNode STRING() { return getToken(XPathParser.STRING, 0); }
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitF(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FContext f() throws RecognitionException {
		return f(0);
	}

	private FContext f(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FContext _localctx = new FContext(_ctx, _parentState);
		FContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_f, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(230);
				rp(0);
				}
				break;
			case 2:
				{
				setState(231);
				rp(0);
				setState(232);
				match(EQ);
				setState(233);
				rp(0);
				}
				break;
			case 3:
				{
				setState(235);
				rp(0);
				setState(236);
				match(IS);
				setState(237);
				rp(0);
				}
				break;
			case 4:
				{
				setState(239);
				rp(0);
				setState(240);
				match(EQ);
				setState(241);
				match(STRING);
				}
				break;
			case 5:
				{
				setState(243);
				match(T__0);
				setState(244);
				f(0);
				setState(245);
				match(T__1);
				}
				break;
			case 6:
				{
				setState(247);
				match(T__22);
				setState(248);
				f(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(259);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(257);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new FContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(251);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(252);
						match(T__20);
						setState(253);
						f(4);
						}
						break;
					case 2:
						{
						_localctx = new FContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(254);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(255);
						match(T__21);
						setState(256);
						f(3);
						}
						break;
					}
					} 
				}
				setState(261);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
	public static class VarContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(XPathParser.VAR, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			match(VAR);
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
	public static class TagNameContext extends ParserRuleContext {
		public TerminalNode TAGNAME() { return getToken(XPathParser.TAGNAME, 0); }
		public TagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitTagName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagNameContext tagName() throws RecognitionException {
		TagNameContext _localctx = new TagNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tagName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(TAGNAME);
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
	public static class AttrNameContext extends ParserRuleContext {
		public TerminalNode ATTRNAME() { return getToken(XPathParser.ATTRNAME, 0); }
		public AttrNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAttrName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAttrName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitAttrName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrNameContext attrName() throws RecognitionException {
		AttrNameContext _localctx = new AttrNameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_attrName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(ATTRNAME);
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
	public static class KeyListContext extends ParserRuleContext {
		public List<TagNameContext> tagName() {
			return getRuleContexts(TagNameContext.class);
		}
		public TagNameContext tagName(int i) {
			return getRuleContext(TagNameContext.class,i);
		}
		public KeyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterKeyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitKeyList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitKeyList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyListContext keyList() throws RecognitionException {
		KeyListContext _localctx = new KeyListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_keyList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(T__30);
			setState(269);
			tagName();
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(270);
				match(T__2);
				setState(271);
				tagName();
				}
				}
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(277);
			match(T__31);
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
		case 0:
			return xq_sempred((XqContext)_localctx, predIndex);
		case 6:
			return cond_sempred((CondContext)_localctx, predIndex);
		case 9:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 10:
			return f_sempred((FContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean xq_sempred(XqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 1);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean f_sempred(FContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\'\u0118\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0003\u00003\b\u0000\u0001\u0000\u0003\u00006\b\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000>\b"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000I\b\u0000\n\u0000"+
		"\f\u0000L\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001W\b"+
		"\u0001\n\u0001\f\u0001Z\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002e\b\u0002\n\u0002\f\u0002h\t\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006\u0092\b\u0006\n\u0006\f\u0006\u0095\t\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006\u00a4\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00ac\b\u0006\n\u0006"+
		"\f\u0006\u00af\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00b9\b\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u00c3\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00d1\b\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0005\t\u00e1\b\t\n\t\f\t\u00e4\t\t\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u00fa\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u0102\b\n\n\n\f\n\u0105\t\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u0111\b\u000e\n\u000e\f\u000e\u0114\t\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0000\u0004\u0000\f\u0012\u0014\u000f\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0000\u0133"+
		"\u0000=\u0001\u0000\u0000\u0000\u0002M\u0001\u0000\u0000\u0000\u0004["+
		"\u0001\u0000\u0000\u0000\u0006i\u0001\u0000\u0000\u0000\bl\u0001\u0000"+
		"\u0000\u0000\no\u0001\u0000\u0000\u0000\f\u00a3\u0001\u0000\u0000\u0000"+
		"\u000e\u00b8\u0001\u0000\u0000\u0000\u0010\u00c2\u0001\u0000\u0000\u0000"+
		"\u0012\u00d0\u0001\u0000\u0000\u0000\u0014\u00f9\u0001\u0000\u0000\u0000"+
		"\u0016\u0106\u0001\u0000\u0000\u0000\u0018\u0108\u0001\u0000\u0000\u0000"+
		"\u001a\u010a\u0001\u0000\u0000\u0000\u001c\u010c\u0001\u0000\u0000\u0000"+
		"\u001e\u001f\u0006\u0000\uffff\uffff\u0000\u001f>\u0003\u0016\u000b\u0000"+
		" >\u0005%\u0000\u0000!>\u0003\u000e\u0007\u0000\"#\u0005\u0001\u0000\u0000"+
		"#$\u0003\u0000\u0000\u0000$%\u0005\u0002\u0000\u0000%>\u0001\u0000\u0000"+
		"\u0000&\'\u0005\u0006\u0000\u0000\'(\u0003\u0018\f\u0000()\u0005\u0007"+
		"\u0000\u0000)*\u0005\b\u0000\u0000*+\u0003\u0000\u0000\u0000+,\u0005\t"+
		"\u0000\u0000,-\u0005\n\u0000\u0000-.\u0003\u0018\f\u0000./\u0005\u0007"+
		"\u0000\u0000/>\u0001\u0000\u0000\u000002\u0003\u0002\u0001\u000013\u0003"+
		"\u0004\u0002\u000021\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u0000"+
		"35\u0001\u0000\u0000\u000046\u0003\u0006\u0003\u000054\u0001\u0000\u0000"+
		"\u000056\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u000078\u0003\b\u0004"+
		"\u00008>\u0001\u0000\u0000\u00009:\u0003\u0004\u0002\u0000:;\u0003\u0000"+
		"\u0000\u0002;>\u0001\u0000\u0000\u0000<>\u0003\n\u0005\u0000=\u001e\u0001"+
		"\u0000\u0000\u0000= \u0001\u0000\u0000\u0000=!\u0001\u0000\u0000\u0000"+
		"=\"\u0001\u0000\u0000\u0000=&\u0001\u0000\u0000\u0000=0\u0001\u0000\u0000"+
		"\u0000=9\u0001\u0000\u0000\u0000=<\u0001\u0000\u0000\u0000>J\u0001\u0000"+
		"\u0000\u0000?@\n\u0007\u0000\u0000@A\u0005\u0003\u0000\u0000AI\u0003\u0000"+
		"\u0000\bBC\n\u0006\u0000\u0000CD\u0005\u0004\u0000\u0000DI\u0003\u0012"+
		"\t\u0000EF\n\u0005\u0000\u0000FG\u0005\u0005\u0000\u0000GI\u0003\u0012"+
		"\t\u0000H?\u0001\u0000\u0000\u0000HB\u0001\u0000\u0000\u0000HE\u0001\u0000"+
		"\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001"+
		"\u0000\u0000\u0000K\u0001\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000"+
		"\u0000MN\u0005\u000b\u0000\u0000NO\u0003\u0016\u000b\u0000OP\u0005\f\u0000"+
		"\u0000PX\u0003\u0000\u0000\u0000QR\u0005\u0003\u0000\u0000RS\u0003\u0016"+
		"\u000b\u0000ST\u0005\f\u0000\u0000TU\u0003\u0000\u0000\u0000UW\u0001\u0000"+
		"\u0000\u0000VQ\u0001\u0000\u0000\u0000WZ\u0001\u0000\u0000\u0000XV\u0001"+
		"\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000Y\u0003\u0001\u0000\u0000"+
		"\u0000ZX\u0001\u0000\u0000\u0000[\\\u0005\r\u0000\u0000\\]\u0003\u0016"+
		"\u000b\u0000]^\u0005\u000e\u0000\u0000^f\u0003\u0000\u0000\u0000_`\u0005"+
		"\u0003\u0000\u0000`a\u0003\u0016\u000b\u0000ab\u0005\u000e\u0000\u0000"+
		"bc\u0003\u0000\u0000\u0000ce\u0001\u0000\u0000\u0000d_\u0001\u0000\u0000"+
		"\u0000eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000"+
		"\u0000\u0000g\u0005\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000"+
		"ij\u0005\u000f\u0000\u0000jk\u0003\f\u0006\u0000k\u0007\u0001\u0000\u0000"+
		"\u0000lm\u0005\u0010\u0000\u0000mn\u0003\u0000\u0000\u0000n\t\u0001\u0000"+
		"\u0000\u0000op\u0005\u0011\u0000\u0000pq\u0005\u0001\u0000\u0000qr\u0003"+
		"\u0000\u0000\u0000rs\u0005\u0003\u0000\u0000st\u0003\u0000\u0000\u0000"+
		"tu\u0005\u0003\u0000\u0000uv\u0003\u001c\u000e\u0000vw\u0005\u0003\u0000"+
		"\u0000wx\u0003\u001c\u000e\u0000xy\u0005\u0002\u0000\u0000y\u000b\u0001"+
		"\u0000\u0000\u0000z{\u0006\u0006\uffff\uffff\u0000{|\u0003\u0000\u0000"+
		"\u0000|}\u0005!\u0000\u0000}~\u0003\u0000\u0000\u0000~\u00a4\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\u0003\u0000\u0000\u0000\u0080\u0081\u0005\"\u0000"+
		"\u0000\u0081\u0082\u0003\u0000\u0000\u0000\u0082\u00a4\u0001\u0000\u0000"+
		"\u0000\u0083\u0084\u0005\u0012\u0000\u0000\u0084\u0085\u0005\u0001\u0000"+
		"\u0000\u0085\u0086\u0003\u0000\u0000\u0000\u0086\u0087\u0005\u0002\u0000"+
		"\u0000\u0087\u00a4\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u0013\u0000"+
		"\u0000\u0089\u008a\u0003\u0016\u000b\u0000\u008a\u008b\u0005\f\u0000\u0000"+
		"\u008b\u0093\u0003\u0000\u0000\u0000\u008c\u008d\u0005\u0003\u0000\u0000"+
		"\u008d\u008e\u0003\u0016\u000b\u0000\u008e\u008f\u0005\f\u0000\u0000\u008f"+
		"\u0090\u0003\u0000\u0000\u0000\u0090\u0092\u0001\u0000\u0000\u0000\u0091"+
		"\u008c\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000\u0000\u0000\u0093"+
		"\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094"+
		"\u0096\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0096"+
		"\u0097\u0005\u0014\u0000\u0000\u0097\u0098\u0003\f\u0006\u0006\u0098\u00a4"+
		"\u0001\u0000\u0000\u0000\u0099\u009a\u0005\u0001\u0000\u0000\u009a\u009b"+
		"\u0003\f\u0006\u0000\u009b\u009c\u0005\u0002\u0000\u0000\u009c\u00a4\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0005\u0017\u0000\u0000\u009e\u00a4\u0003"+
		"\f\u0006\u0002\u009f\u00a0\u0003\u0012\t\u0000\u00a0\u00a1\u0005!\u0000"+
		"\u0000\u00a1\u00a2\u0005%\u0000\u0000\u00a2\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a3z\u0001\u0000\u0000\u0000\u00a3\u007f\u0001\u0000\u0000\u0000\u00a3"+
		"\u0083\u0001\u0000\u0000\u0000\u00a3\u0088\u0001\u0000\u0000\u0000\u00a3"+
		"\u0099\u0001\u0000\u0000\u0000\u00a3\u009d\u0001\u0000\u0000\u0000\u00a3"+
		"\u009f\u0001\u0000\u0000\u0000\u00a4\u00ad\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\n\u0004\u0000\u0000\u00a6\u00a7\u0005\u0015\u0000\u0000\u00a7\u00ac"+
		"\u0003\f\u0006\u0005\u00a8\u00a9\n\u0003\u0000\u0000\u00a9\u00aa\u0005"+
		"\u0016\u0000\u0000\u00aa\u00ac\u0003\f\u0006\u0004\u00ab\u00a5\u0001\u0000"+
		"\u0000\u0000\u00ab\u00a8\u0001\u0000\u0000\u0000\u00ac\u00af\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000"+
		"\u0000\u0000\u00ae\r\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\u0003\u0010\b\u0000\u00b1\u00b2\u0005\u0004\u0000\u0000"+
		"\u00b2\u00b3\u0003\u0012\t\u0000\u00b3\u00b9\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u0003\u0010\b\u0000\u00b5\u00b6\u0005\u0005\u0000\u0000\u00b6\u00b7"+
		"\u0003\u0012\t\u0000\u00b7\u00b9\u0001\u0000\u0000\u0000\u00b8\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b4\u0001\u0000\u0000\u0000\u00b9\u000f\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bb\u0005\u0018\u0000\u0000\u00bb\u00bc\u0005"+
		"\u0001\u0000\u0000\u00bc\u00bd\u0005%\u0000\u0000\u00bd\u00c3\u0005\u0002"+
		"\u0000\u0000\u00be\u00bf\u0005\u0019\u0000\u0000\u00bf\u00c0\u0005\u0001"+
		"\u0000\u0000\u00c0\u00c1\u0005%\u0000\u0000\u00c1\u00c3\u0005\u0002\u0000"+
		"\u0000\u00c2\u00ba\u0001\u0000\u0000\u0000\u00c2\u00be\u0001\u0000\u0000"+
		"\u0000\u00c3\u0011\u0001\u0000\u0000\u0000\u00c4\u00c5\u0006\t\uffff\uffff"+
		"\u0000\u00c5\u00d1\u0003\u0018\f\u0000\u00c6\u00d1\u0005\u001a\u0000\u0000"+
		"\u00c7\u00d1\u0005\u001b\u0000\u0000\u00c8\u00d1\u0005\u001c\u0000\u0000"+
		"\u00c9\u00d1\u0005\u001d\u0000\u0000\u00ca\u00cb\u0005\u001e\u0000\u0000"+
		"\u00cb\u00d1\u0003\u001a\r\u0000\u00cc\u00cd\u0005\u0001\u0000\u0000\u00cd"+
		"\u00ce\u0003\u0012\t\u0000\u00ce\u00cf\u0005\u0002\u0000\u0000\u00cf\u00d1"+
		"\u0001\u0000\u0000\u0000\u00d0\u00c4\u0001\u0000\u0000\u0000\u00d0\u00c6"+
		"\u0001\u0000\u0000\u0000\u00d0\u00c7\u0001\u0000\u0000\u0000\u00d0\u00c8"+
		"\u0001\u0000\u0000\u0000\u00d0\u00c9\u0001\u0000\u0000\u0000\u00d0\u00ca"+
		"\u0001\u0000\u0000\u0000\u00d0\u00cc\u0001\u0000\u0000\u0000\u00d1\u00e2"+
		"\u0001\u0000\u0000\u0000\u00d2\u00d3\n\u0004\u0000\u0000\u00d3\u00d4\u0005"+
		"\u0004\u0000\u0000\u00d4\u00e1\u0003\u0012\t\u0005\u00d5\u00d6\n\u0003"+
		"\u0000\u0000\u00d6\u00d7\u0005\u0005\u0000\u0000\u00d7\u00e1\u0003\u0012"+
		"\t\u0004\u00d8\u00d9\n\u0001\u0000\u0000\u00d9\u00da\u0005\u0003\u0000"+
		"\u0000\u00da\u00e1\u0003\u0012\t\u0002\u00db\u00dc\n\u0002\u0000\u0000"+
		"\u00dc\u00dd\u0005\u001f\u0000\u0000\u00dd\u00de\u0003\u0014\n\u0000\u00de"+
		"\u00df\u0005 \u0000\u0000\u00df\u00e1\u0001\u0000\u0000\u0000\u00e0\u00d2"+
		"\u0001\u0000\u0000\u0000\u00e0\u00d5\u0001\u0000\u0000\u0000\u00e0\u00d8"+
		"\u0001\u0000\u0000\u0000\u00e0\u00db\u0001\u0000\u0000\u0000\u00e1\u00e4"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e3\u0013\u0001\u0000\u0000\u0000\u00e4\u00e2"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e6\u0006\n\uffff\uffff\u0000\u00e6\u00fa"+
		"\u0003\u0012\t\u0000\u00e7\u00e8\u0003\u0012\t\u0000\u00e8\u00e9\u0005"+
		"!\u0000\u0000\u00e9\u00ea\u0003\u0012\t\u0000\u00ea\u00fa\u0001\u0000"+
		"\u0000\u0000\u00eb\u00ec\u0003\u0012\t\u0000\u00ec\u00ed\u0005\"\u0000"+
		"\u0000\u00ed\u00ee\u0003\u0012\t\u0000\u00ee\u00fa\u0001\u0000\u0000\u0000"+
		"\u00ef\u00f0\u0003\u0012\t\u0000\u00f0\u00f1\u0005!\u0000\u0000\u00f1"+
		"\u00f2\u0005%\u0000\u0000\u00f2\u00fa\u0001\u0000\u0000\u0000\u00f3\u00f4"+
		"\u0005\u0001\u0000\u0000\u00f4\u00f5\u0003\u0014\n\u0000\u00f5\u00f6\u0005"+
		"\u0002\u0000\u0000\u00f6\u00fa\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005"+
		"\u0017\u0000\u0000\u00f8\u00fa\u0003\u0014\n\u0001\u00f9\u00e5\u0001\u0000"+
		"\u0000\u0000\u00f9\u00e7\u0001\u0000\u0000\u0000\u00f9\u00eb\u0001\u0000"+
		"\u0000\u0000\u00f9\u00ef\u0001\u0000\u0000\u0000\u00f9\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00fa\u0103\u0001\u0000"+
		"\u0000\u0000\u00fb\u00fc\n\u0003\u0000\u0000\u00fc\u00fd\u0005\u0015\u0000"+
		"\u0000\u00fd\u0102\u0003\u0014\n\u0004\u00fe\u00ff\n\u0002\u0000\u0000"+
		"\u00ff\u0100\u0005\u0016\u0000\u0000\u0100\u0102\u0003\u0014\n\u0003\u0101"+
		"\u00fb\u0001\u0000\u0000\u0000\u0101\u00fe\u0001\u0000\u0000\u0000\u0102"+
		"\u0105\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0103"+
		"\u0104\u0001\u0000\u0000\u0000\u0104\u0015\u0001\u0000\u0000\u0000\u0105"+
		"\u0103\u0001\u0000\u0000\u0000\u0106\u0107\u0005&\u0000\u0000\u0107\u0017"+
		"\u0001\u0000\u0000\u0000\u0108\u0109\u0005#\u0000\u0000\u0109\u0019\u0001"+
		"\u0000\u0000\u0000\u010a\u010b\u0005$\u0000\u0000\u010b\u001b\u0001\u0000"+
		"\u0000\u0000\u010c\u010d\u0005\u001f\u0000\u0000\u010d\u0112\u0003\u0018"+
		"\f\u0000\u010e\u010f\u0005\u0003\u0000\u0000\u010f\u0111\u0003\u0018\f"+
		"\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0111\u0114\u0001\u0000\u0000"+
		"\u0000\u0112\u0110\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000"+
		"\u0000\u0113\u0115\u0001\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000"+
		"\u0000\u0115\u0116\u0005 \u0000\u0000\u0116\u001d\u0001\u0000\u0000\u0000"+
		"\u001425=HJXf\u0093\u00a3\u00ab\u00ad\u00b8\u00c2\u00d0\u00e0\u00e2\u00f9"+
		"\u0101\u0103\u0112";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}