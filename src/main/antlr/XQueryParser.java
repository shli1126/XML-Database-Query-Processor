// Generated from src/main/antlr/XQuery.g4 by ANTLR 4.13.2

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
public class XQueryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		EQ=32, IS=33, TAGNAME=34, ATTRNAME=35, STRING=36, VAR=37, WS=38;
	public static final int
		RULE_xq = 0, RULE_forClause = 1, RULE_letClause = 2, RULE_whereClause = 3, 
		RULE_returnClause = 4, RULE_cond = 5, RULE_ap = 6, RULE_doc = 7, RULE_rp = 8, 
		RULE_f = 9, RULE_var = 10, RULE_tagName = 11, RULE_attrName = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"xq", "forClause", "letClause", "whereClause", "returnClause", "cond", 
			"ap", "doc", "rp", "f", "var", "tagName", "attrName"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'/'", "'//'", "'<'", "'>'", "'{'", "'}'", 
			"'</'", "'for'", "'in'", "'let'", "':='", "'where'", "'return'", "'empty'", 
			"'some'", "'satisfies'", "'and'", "'or'", "'not'", "'doc'", "'document'", 
			"'*'", "'.'", "'..'", "'text()'", "'@'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "EQ", "IS", "TAGNAME", 
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
	public String getGrammarFileName() { return "XQuery.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XQueryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class XqContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode STRING() { return getToken(XQueryParser.STRING, 0); }
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
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXq(this);
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
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				{
				setState(27);
				var();
				}
				break;
			case STRING:
				{
				setState(28);
				match(STRING);
				}
				break;
			case T__22:
			case T__23:
				{
				setState(29);
				ap();
				}
				break;
			case T__0:
				{
				setState(30);
				match(T__0);
				setState(31);
				xq(0);
				setState(32);
				match(T__1);
				}
				break;
			case T__5:
				{
				setState(34);
				match(T__5);
				setState(35);
				tagName();
				setState(36);
				match(T__6);
				setState(37);
				match(T__7);
				setState(38);
				xq(0);
				setState(39);
				match(T__8);
				setState(40);
				match(T__9);
				setState(41);
				tagName();
				setState(42);
				match(T__6);
				}
				break;
			case T__10:
				{
				setState(44);
				forClause();
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(45);
					letClause();
					}
				}

				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(48);
					whereClause();
					}
				}

				setState(51);
				returnClause();
				}
				break;
			case T__12:
				{
				setState(53);
				letClause();
				setState(54);
				xq(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(67);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new XqContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(58);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(59);
						match(T__2);
						setState(60);
						xq(7);
						}
						break;
					case 2:
						{
						_localctx = new XqContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(61);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(62);
						match(T__3);
						setState(63);
						rp(0);
						}
						break;
					case 3:
						{
						_localctx = new XqContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(64);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(65);
						match(T__4);
						setState(66);
						rp(0);
						}
						break;
					}
					} 
				}
				setState(71);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterForClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitForClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitForClause(this);
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
			setState(72);
			match(T__10);
			setState(73);
			var();
			setState(74);
			match(T__11);
			setState(75);
			xq(0);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(76);
				match(T__2);
				setState(77);
				var();
				setState(78);
				match(T__11);
				setState(79);
				xq(0);
				}
				}
				setState(85);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterLetClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitLetClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitLetClause(this);
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
			setState(86);
			match(T__12);
			setState(87);
			var();
			setState(88);
			match(T__13);
			setState(89);
			xq(0);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(90);
				match(T__2);
				setState(91);
				var();
				setState(92);
				match(T__13);
				setState(93);
				xq(0);
				}
				}
				setState(99);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitWhereClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__14);
			setState(101);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterReturnClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitReturnClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitReturnClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnClauseContext returnClause() throws RecognitionException {
		ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_returnClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__15);
			setState(104);
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
	public static class CondContext extends ParserRuleContext {
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public TerminalNode EQ() { return getToken(XQueryParser.EQ, 0); }
		public TerminalNode IS() { return getToken(XQueryParser.IS, 0); }
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
		public TerminalNode STRING() { return getToken(XQueryParser.STRING, 0); }
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCond(this);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_cond, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(107);
				xq(0);
				setState(108);
				match(EQ);
				setState(109);
				xq(0);
				}
				break;
			case 2:
				{
				setState(111);
				xq(0);
				setState(112);
				match(IS);
				setState(113);
				xq(0);
				}
				break;
			case 3:
				{
				setState(115);
				match(T__16);
				setState(116);
				match(T__0);
				setState(117);
				xq(0);
				setState(118);
				match(T__1);
				}
				break;
			case 4:
				{
				setState(120);
				match(T__17);
				setState(121);
				var();
				setState(122);
				match(T__11);
				setState(123);
				xq(0);
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(124);
					match(T__2);
					setState(125);
					var();
					setState(126);
					match(T__11);
					setState(127);
					xq(0);
					}
					}
					setState(133);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(134);
				match(T__18);
				setState(135);
				cond(6);
				}
				break;
			case 5:
				{
				setState(137);
				match(T__0);
				setState(138);
				cond(0);
				setState(139);
				match(T__1);
				}
				break;
			case 6:
				{
				setState(141);
				match(T__21);
				setState(142);
				cond(2);
				}
				break;
			case 7:
				{
				setState(143);
				rp(0);
				setState(144);
				match(EQ);
				setState(145);
				match(STRING);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(157);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(155);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(149);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(150);
						match(T__19);
						setState(151);
						cond(5);
						}
						break;
					case 2:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(152);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(153);
						match(T__20);
						setState(154);
						cond(4);
						}
						break;
					}
					} 
				}
				setState(159);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterAp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitAp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitAp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ap);
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				doc();
				setState(161);
				match(T__3);
				setState(162);
				rp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				doc();
				setState(165);
				match(T__4);
				setState(166);
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
		public TerminalNode STRING() { return getToken(XQueryParser.STRING, 0); }
		public DocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterDoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitDoc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitDoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocContext doc() throws RecognitionException {
		DocContext _localctx = new DocContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_doc);
		try {
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(T__22);
				setState(171);
				match(T__0);
				setState(172);
				match(STRING);
				setState(173);
				match(T__1);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(T__23);
				setState(175);
				match(T__0);
				setState(176);
				match(STRING);
				setState(177);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRp(this);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAGNAME:
				{
				setState(181);
				tagName();
				}
				break;
			case T__24:
				{
				setState(182);
				match(T__24);
				}
				break;
			case T__25:
				{
				setState(183);
				match(T__25);
				}
				break;
			case T__26:
				{
				setState(184);
				match(T__26);
				}
				break;
			case T__27:
				{
				setState(185);
				match(T__27);
				}
				break;
			case T__28:
				{
				setState(186);
				match(T__28);
				setState(187);
				attrName();
				}
				break;
			case T__0:
				{
				setState(188);
				match(T__0);
				setState(189);
				rp(0);
				setState(190);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(210);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(208);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(194);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(195);
						match(T__3);
						setState(196);
						rp(5);
						}
						break;
					case 2:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(197);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(198);
						match(T__4);
						setState(199);
						rp(4);
						}
						break;
					case 3:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(200);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(201);
						match(T__2);
						setState(202);
						rp(2);
						}
						break;
					case 4:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(203);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(204);
						match(T__29);
						setState(205);
						f(0);
						setState(206);
						match(T__30);
						}
						break;
					}
					} 
				}
				setState(212);
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
		public TerminalNode EQ() { return getToken(XQueryParser.EQ, 0); }
		public TerminalNode IS() { return getToken(XQueryParser.IS, 0); }
		public TerminalNode STRING() { return getToken(XQueryParser.STRING, 0); }
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitF(this);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_f, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(214);
				rp(0);
				}
				break;
			case 2:
				{
				setState(215);
				rp(0);
				setState(216);
				match(EQ);
				setState(217);
				rp(0);
				}
				break;
			case 3:
				{
				setState(219);
				rp(0);
				setState(220);
				match(IS);
				setState(221);
				rp(0);
				}
				break;
			case 4:
				{
				setState(223);
				rp(0);
				setState(224);
				match(EQ);
				setState(225);
				match(STRING);
				}
				break;
			case 5:
				{
				setState(227);
				match(T__0);
				setState(228);
				f(0);
				setState(229);
				match(T__1);
				}
				break;
			case 6:
				{
				setState(231);
				match(T__21);
				setState(232);
				f(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(243);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(241);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new FContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(235);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(236);
						match(T__19);
						setState(237);
						f(4);
						}
						break;
					case 2:
						{
						_localctx = new FContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(238);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(239);
						match(T__20);
						setState(240);
						f(3);
						}
						break;
					}
					} 
				}
				setState(245);
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
		public TerminalNode VAR() { return getToken(XQueryParser.VAR, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
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
		public TerminalNode TAGNAME() { return getToken(XQueryParser.TAGNAME, 0); }
		public TagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitTagName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagNameContext tagName() throws RecognitionException {
		TagNameContext _localctx = new TagNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tagName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
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
		public TerminalNode ATTRNAME() { return getToken(XQueryParser.ATTRNAME, 0); }
		public AttrNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterAttrName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitAttrName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitAttrName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrNameContext attrName() throws RecognitionException {
		AttrNameContext _localctx = new AttrNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_attrName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return xq_sempred((XqContext)_localctx, predIndex);
		case 5:
			return cond_sempred((CondContext)_localctx, predIndex);
		case 8:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 9:
			return f_sempred((FContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean xq_sempred(XqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
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
		"\u0004\u0001&\u00fd\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000/\b\u0000\u0001\u0000"+
		"\u0003\u00002\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0003\u00009\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u0000D\b\u0000\n\u0000\f\u0000G\t\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001R\b\u0001\n\u0001\f\u0001U\t\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002`\b\u0002\n\u0002\f\u0002c\t\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u0082\b\u0005\n\u0005\f\u0005\u0085\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0094"+
		"\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005\u009c\b\u0005\n\u0005\f\u0005\u009f\t\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006\u00a9\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u00b3\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00c1\b\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0005\b\u00d1\b\b\n\b\f\b\u00d4\t\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u00ea\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u00f2\b\t\n\t\f\t\u00f5\t\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0000\u0004\u0000\n\u0010\u0012\r\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0000"+
		"\u0118\u00008\u0001\u0000\u0000\u0000\u0002H\u0001\u0000\u0000\u0000\u0004"+
		"V\u0001\u0000\u0000\u0000\u0006d\u0001\u0000\u0000\u0000\bg\u0001\u0000"+
		"\u0000\u0000\n\u0093\u0001\u0000\u0000\u0000\f\u00a8\u0001\u0000\u0000"+
		"\u0000\u000e\u00b2\u0001\u0000\u0000\u0000\u0010\u00c0\u0001\u0000\u0000"+
		"\u0000\u0012\u00e9\u0001\u0000\u0000\u0000\u0014\u00f6\u0001\u0000\u0000"+
		"\u0000\u0016\u00f8\u0001\u0000\u0000\u0000\u0018\u00fa\u0001\u0000\u0000"+
		"\u0000\u001a\u001b\u0006\u0000\uffff\uffff\u0000\u001b9\u0003\u0014\n"+
		"\u0000\u001c9\u0005$\u0000\u0000\u001d9\u0003\f\u0006\u0000\u001e\u001f"+
		"\u0005\u0001\u0000\u0000\u001f \u0003\u0000\u0000\u0000 !\u0005\u0002"+
		"\u0000\u0000!9\u0001\u0000\u0000\u0000\"#\u0005\u0006\u0000\u0000#$\u0003"+
		"\u0016\u000b\u0000$%\u0005\u0007\u0000\u0000%&\u0005\b\u0000\u0000&\'"+
		"\u0003\u0000\u0000\u0000\'(\u0005\t\u0000\u0000()\u0005\n\u0000\u0000"+
		")*\u0003\u0016\u000b\u0000*+\u0005\u0007\u0000\u0000+9\u0001\u0000\u0000"+
		"\u0000,.\u0003\u0002\u0001\u0000-/\u0003\u0004\u0002\u0000.-\u0001\u0000"+
		"\u0000\u0000./\u0001\u0000\u0000\u0000/1\u0001\u0000\u0000\u000002\u0003"+
		"\u0006\u0003\u000010\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u0000"+
		"23\u0001\u0000\u0000\u000034\u0003\b\u0004\u000049\u0001\u0000\u0000\u0000"+
		"56\u0003\u0004\u0002\u000067\u0003\u0000\u0000\u000179\u0001\u0000\u0000"+
		"\u00008\u001a\u0001\u0000\u0000\u00008\u001c\u0001\u0000\u0000\u00008"+
		"\u001d\u0001\u0000\u0000\u00008\u001e\u0001\u0000\u0000\u00008\"\u0001"+
		"\u0000\u0000\u00008,\u0001\u0000\u0000\u000085\u0001\u0000\u0000\u0000"+
		"9E\u0001\u0000\u0000\u0000:;\n\u0006\u0000\u0000;<\u0005\u0003\u0000\u0000"+
		"<D\u0003\u0000\u0000\u0007=>\n\u0005\u0000\u0000>?\u0005\u0004\u0000\u0000"+
		"?D\u0003\u0010\b\u0000@A\n\u0004\u0000\u0000AB\u0005\u0005\u0000\u0000"+
		"BD\u0003\u0010\b\u0000C:\u0001\u0000\u0000\u0000C=\u0001\u0000\u0000\u0000"+
		"C@\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000F\u0001\u0001\u0000\u0000\u0000GE\u0001"+
		"\u0000\u0000\u0000HI\u0005\u000b\u0000\u0000IJ\u0003\u0014\n\u0000JK\u0005"+
		"\f\u0000\u0000KS\u0003\u0000\u0000\u0000LM\u0005\u0003\u0000\u0000MN\u0003"+
		"\u0014\n\u0000NO\u0005\f\u0000\u0000OP\u0003\u0000\u0000\u0000PR\u0001"+
		"\u0000\u0000\u0000QL\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000"+
		"SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000T\u0003\u0001\u0000"+
		"\u0000\u0000US\u0001\u0000\u0000\u0000VW\u0005\r\u0000\u0000WX\u0003\u0014"+
		"\n\u0000XY\u0005\u000e\u0000\u0000Ya\u0003\u0000\u0000\u0000Z[\u0005\u0003"+
		"\u0000\u0000[\\\u0003\u0014\n\u0000\\]\u0005\u000e\u0000\u0000]^\u0003"+
		"\u0000\u0000\u0000^`\u0001\u0000\u0000\u0000_Z\u0001\u0000\u0000\u0000"+
		"`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000"+
		"\u0000b\u0005\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000de\u0005"+
		"\u000f\u0000\u0000ef\u0003\n\u0005\u0000f\u0007\u0001\u0000\u0000\u0000"+
		"gh\u0005\u0010\u0000\u0000hi\u0003\u0000\u0000\u0000i\t\u0001\u0000\u0000"+
		"\u0000jk\u0006\u0005\uffff\uffff\u0000kl\u0003\u0000\u0000\u0000lm\u0005"+
		" \u0000\u0000mn\u0003\u0000\u0000\u0000n\u0094\u0001\u0000\u0000\u0000"+
		"op\u0003\u0000\u0000\u0000pq\u0005!\u0000\u0000qr\u0003\u0000\u0000\u0000"+
		"r\u0094\u0001\u0000\u0000\u0000st\u0005\u0011\u0000\u0000tu\u0005\u0001"+
		"\u0000\u0000uv\u0003\u0000\u0000\u0000vw\u0005\u0002\u0000\u0000w\u0094"+
		"\u0001\u0000\u0000\u0000xy\u0005\u0012\u0000\u0000yz\u0003\u0014\n\u0000"+
		"z{\u0005\f\u0000\u0000{\u0083\u0003\u0000\u0000\u0000|}\u0005\u0003\u0000"+
		"\u0000}~\u0003\u0014\n\u0000~\u007f\u0005\f\u0000\u0000\u007f\u0080\u0003"+
		"\u0000\u0000\u0000\u0080\u0082\u0001\u0000\u0000\u0000\u0081|\u0001\u0000"+
		"\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0086\u0001\u0000"+
		"\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0087\u0005\u0013"+
		"\u0000\u0000\u0087\u0088\u0003\n\u0005\u0006\u0088\u0094\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0005\u0001\u0000\u0000\u008a\u008b\u0003\n\u0005\u0000"+
		"\u008b\u008c\u0005\u0002\u0000\u0000\u008c\u0094\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0005\u0016\u0000\u0000\u008e\u0094\u0003\n\u0005\u0002\u008f"+
		"\u0090\u0003\u0010\b\u0000\u0090\u0091\u0005 \u0000\u0000\u0091\u0092"+
		"\u0005$\u0000\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093j\u0001\u0000"+
		"\u0000\u0000\u0093o\u0001\u0000\u0000\u0000\u0093s\u0001\u0000\u0000\u0000"+
		"\u0093x\u0001\u0000\u0000\u0000\u0093\u0089\u0001\u0000\u0000\u0000\u0093"+
		"\u008d\u0001\u0000\u0000\u0000\u0093\u008f\u0001\u0000\u0000\u0000\u0094"+
		"\u009d\u0001\u0000\u0000\u0000\u0095\u0096\n\u0004\u0000\u0000\u0096\u0097"+
		"\u0005\u0014\u0000\u0000\u0097\u009c\u0003\n\u0005\u0005\u0098\u0099\n"+
		"\u0003\u0000\u0000\u0099\u009a\u0005\u0015\u0000\u0000\u009a\u009c\u0003"+
		"\n\u0005\u0004\u009b\u0095\u0001\u0000\u0000\u0000\u009b\u0098\u0001\u0000"+
		"\u0000\u0000\u009c\u009f\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000"+
		"\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u000b\u0001\u0000"+
		"\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u00a0\u00a1\u0003\u000e"+
		"\u0007\u0000\u00a1\u00a2\u0005\u0004\u0000\u0000\u00a2\u00a3\u0003\u0010"+
		"\b\u0000\u00a3\u00a9\u0001\u0000\u0000\u0000\u00a4\u00a5\u0003\u000e\u0007"+
		"\u0000\u00a5\u00a6\u0005\u0005\u0000\u0000\u00a6\u00a7\u0003\u0010\b\u0000"+
		"\u00a7\u00a9\u0001\u0000\u0000\u0000\u00a8\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a4\u0001\u0000\u0000\u0000\u00a9\r\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0005\u0017\u0000\u0000\u00ab\u00ac\u0005\u0001\u0000\u0000\u00ac"+
		"\u00ad\u0005$\u0000\u0000\u00ad\u00b3\u0005\u0002\u0000\u0000\u00ae\u00af"+
		"\u0005\u0018\u0000\u0000\u00af\u00b0\u0005\u0001\u0000\u0000\u00b0\u00b1"+
		"\u0005$\u0000\u0000\u00b1\u00b3\u0005\u0002\u0000\u0000\u00b2\u00aa\u0001"+
		"\u0000\u0000\u0000\u00b2\u00ae\u0001\u0000\u0000\u0000\u00b3\u000f\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b5\u0006\b\uffff\uffff\u0000\u00b5\u00c1\u0003"+
		"\u0016\u000b\u0000\u00b6\u00c1\u0005\u0019\u0000\u0000\u00b7\u00c1\u0005"+
		"\u001a\u0000\u0000\u00b8\u00c1\u0005\u001b\u0000\u0000\u00b9\u00c1\u0005"+
		"\u001c\u0000\u0000\u00ba\u00bb\u0005\u001d\u0000\u0000\u00bb\u00c1\u0003"+
		"\u0018\f\u0000\u00bc\u00bd\u0005\u0001\u0000\u0000\u00bd\u00be\u0003\u0010"+
		"\b\u0000\u00be\u00bf\u0005\u0002\u0000\u0000\u00bf\u00c1\u0001\u0000\u0000"+
		"\u0000\u00c0\u00b4\u0001\u0000\u0000\u0000\u00c0\u00b6\u0001\u0000\u0000"+
		"\u0000\u00c0\u00b7\u0001\u0000\u0000\u0000\u00c0\u00b8\u0001\u0000\u0000"+
		"\u0000\u00c0\u00b9\u0001\u0000\u0000\u0000\u00c0\u00ba\u0001\u0000\u0000"+
		"\u0000\u00c0\u00bc\u0001\u0000\u0000\u0000\u00c1\u00d2\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c3\n\u0004\u0000\u0000\u00c3\u00c4\u0005\u0004\u0000\u0000"+
		"\u00c4\u00d1\u0003\u0010\b\u0005\u00c5\u00c6\n\u0003\u0000\u0000\u00c6"+
		"\u00c7\u0005\u0005\u0000\u0000\u00c7\u00d1\u0003\u0010\b\u0004\u00c8\u00c9"+
		"\n\u0001\u0000\u0000\u00c9\u00ca\u0005\u0003\u0000\u0000\u00ca\u00d1\u0003"+
		"\u0010\b\u0002\u00cb\u00cc\n\u0002\u0000\u0000\u00cc\u00cd\u0005\u001e"+
		"\u0000\u0000\u00cd\u00ce\u0003\u0012\t\u0000\u00ce\u00cf\u0005\u001f\u0000"+
		"\u0000\u00cf\u00d1\u0001\u0000\u0000\u0000\u00d0\u00c2\u0001\u0000\u0000"+
		"\u0000\u00d0\u00c5\u0001\u0000\u0000\u0000\u00d0\u00c8\u0001\u0000\u0000"+
		"\u0000\u00d0\u00cb\u0001\u0000\u0000\u0000\u00d1\u00d4\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d3\u0011\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d6\u0006\t\uffff\uffff\u0000\u00d6\u00ea\u0003\u0010\b"+
		"\u0000\u00d7\u00d8\u0003\u0010\b\u0000\u00d8\u00d9\u0005 \u0000\u0000"+
		"\u00d9\u00da\u0003\u0010\b\u0000\u00da\u00ea\u0001\u0000\u0000\u0000\u00db"+
		"\u00dc\u0003\u0010\b\u0000\u00dc\u00dd\u0005!\u0000\u0000\u00dd\u00de"+
		"\u0003\u0010\b\u0000\u00de\u00ea\u0001\u0000\u0000\u0000\u00df\u00e0\u0003"+
		"\u0010\b\u0000\u00e0\u00e1\u0005 \u0000\u0000\u00e1\u00e2\u0005$\u0000"+
		"\u0000\u00e2\u00ea\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005\u0001\u0000"+
		"\u0000\u00e4\u00e5\u0003\u0012\t\u0000\u00e5\u00e6\u0005\u0002\u0000\u0000"+
		"\u00e6\u00ea\u0001\u0000\u0000\u0000\u00e7\u00e8\u0005\u0016\u0000\u0000"+
		"\u00e8\u00ea\u0003\u0012\t\u0001\u00e9\u00d5\u0001\u0000\u0000\u0000\u00e9"+
		"\u00d7\u0001\u0000\u0000\u0000\u00e9\u00db\u0001\u0000\u0000\u0000\u00e9"+
		"\u00df\u0001\u0000\u0000\u0000\u00e9\u00e3\u0001\u0000\u0000\u0000\u00e9"+
		"\u00e7\u0001\u0000\u0000\u0000\u00ea\u00f3\u0001\u0000\u0000\u0000\u00eb"+
		"\u00ec\n\u0003\u0000\u0000\u00ec\u00ed\u0005\u0014\u0000\u0000\u00ed\u00f2"+
		"\u0003\u0012\t\u0004\u00ee\u00ef\n\u0002\u0000\u0000\u00ef\u00f0\u0005"+
		"\u0015\u0000\u0000\u00f0\u00f2\u0003\u0012\t\u0003\u00f1\u00eb\u0001\u0000"+
		"\u0000\u0000\u00f1\u00ee\u0001\u0000\u0000\u0000\u00f2\u00f5\u0001\u0000"+
		"\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000"+
		"\u0000\u0000\u00f4\u0013\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f6\u00f7\u0005%\u0000\u0000\u00f7\u0015\u0001\u0000\u0000"+
		"\u0000\u00f8\u00f9\u0005\"\u0000\u0000\u00f9\u0017\u0001\u0000\u0000\u0000"+
		"\u00fa\u00fb\u0005#\u0000\u0000\u00fb\u0019\u0001\u0000\u0000\u0000\u0013"+
		".18CESa\u0083\u0093\u009b\u009d\u00a8\u00b2\u00c0\u00d0\u00d2\u00e9\u00f1"+
		"\u00f3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}