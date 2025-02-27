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
		T__17=18, T__18=19, T__19=20, TAGNAME=21, ATTRNAME=22, STRING=23, EQ=24, 
		IS=25, WS=26;
	public static final int
		RULE_ap = 0, RULE_doc = 1, RULE_rp = 2, RULE_f = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"ap", "doc", "rp", "f"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/'", "'//'", "'doc'", "'('", "'\"'", "')'", "'document'", "'*'", 
			"'.'", "'..'", "'text'", "'text()'", "'@'", "'['", "']'", "','", "'='", 
			"'and'", "'or'", "'not'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "TAGNAME", "ATTRNAME", 
			"STRING", "EQ", "IS", "WS"
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
		enterRule(_localctx, 0, RULE_ap);
		try {
			setState(16);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(8);
				doc();
				setState(9);
				match(T__0);
				setState(10);
				rp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(12);
				doc();
				setState(13);
				match(T__1);
				setState(14);
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
		enterRule(_localctx, 2, RULE_doc);
		try {
			setState(30);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				match(T__2);
				setState(19);
				match(T__3);
				setState(20);
				match(T__4);
				setState(21);
				match(STRING);
				setState(22);
				match(T__4);
				setState(23);
				match(T__5);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(24);
				match(T__6);
				setState(25);
				match(T__3);
				setState(26);
				match(T__4);
				setState(27);
				match(STRING);
				setState(28);
				match(T__4);
				setState(29);
				match(T__5);
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
		public TerminalNode TAGNAME() { return getToken(XPathParser.TAGNAME, 0); }
		public TerminalNode ATTRNAME() { return getToken(XPathParser.ATTRNAME, 0); }
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAGNAME:
				{
				setState(33);
				match(TAGNAME);
				}
				break;
			case T__7:
				{
				setState(34);
				match(T__7);
				}
				break;
			case T__8:
				{
				setState(35);
				match(T__8);
				}
				break;
			case T__9:
				{
				setState(36);
				match(T__9);
				}
				break;
			case T__10:
				{
				setState(37);
				match(T__10);
				}
				break;
			case T__11:
				{
				setState(38);
				match(T__11);
				}
				break;
			case T__12:
				{
				setState(39);
				match(T__12);
				setState(40);
				match(ATTRNAME);
				}
				break;
			case T__3:
				{
				setState(41);
				match(T__3);
				setState(42);
				rp(0);
				setState(43);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(61);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(47);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(48);
						match(T__0);
						setState(49);
						rp(5);
						}
						break;
					case 2:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(50);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(51);
						match(T__1);
						setState(52);
						rp(4);
						}
						break;
					case 3:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(53);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(54);
						match(T__15);
						setState(55);
						rp(2);
						}
						break;
					case 4:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(56);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(57);
						match(T__13);
						setState(58);
						f(0);
						setState(59);
						match(T__14);
						}
						break;
					}
					} 
				}
				setState(65);
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_f, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(67);
				rp(0);
				}
				break;
			case 2:
				{
				setState(68);
				rp(0);
				setState(69);
				match(EQ);
				setState(70);
				rp(0);
				}
				break;
			case 3:
				{
				setState(72);
				rp(0);
				setState(73);
				match(IS);
				setState(74);
				rp(0);
				}
				break;
			case 4:
				{
				setState(76);
				rp(0);
				setState(77);
				match(T__16);
				setState(78);
				match(STRING);
				}
				break;
			case 5:
				{
				setState(80);
				match(T__3);
				setState(81);
				f(0);
				setState(82);
				match(T__5);
				}
				break;
			case 6:
				{
				setState(84);
				match(T__19);
				setState(85);
				f(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(96);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(94);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new FContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(88);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(89);
						match(T__17);
						setState(90);
						f(4);
						}
						break;
					case 2:
						{
						_localctx = new FContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(91);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(92);
						match(T__18);
						setState(93);
						f(3);
						}
						break;
					}
					} 
				}
				setState(98);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 3:
			return f_sempred((FContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 1);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean f_sempred(FContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001ad\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003"+
		"\u0000\u0011\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001\u001f\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002.\b"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002>\b\u0002\n\u0002\f\u0002A\t"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003W\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003_\b"+
		"\u0003\n\u0003\f\u0003b\t\u0003\u0001\u0003\u0000\u0002\u0004\u0006\u0004"+
		"\u0000\u0002\u0004\u0006\u0000\u0000s\u0000\u0010\u0001\u0000\u0000\u0000"+
		"\u0002\u001e\u0001\u0000\u0000\u0000\u0004-\u0001\u0000\u0000\u0000\u0006"+
		"V\u0001\u0000\u0000\u0000\b\t\u0003\u0002\u0001\u0000\t\n\u0005\u0001"+
		"\u0000\u0000\n\u000b\u0003\u0004\u0002\u0000\u000b\u0011\u0001\u0000\u0000"+
		"\u0000\f\r\u0003\u0002\u0001\u0000\r\u000e\u0005\u0002\u0000\u0000\u000e"+
		"\u000f\u0003\u0004\u0002\u0000\u000f\u0011\u0001\u0000\u0000\u0000\u0010"+
		"\b\u0001\u0000\u0000\u0000\u0010\f\u0001\u0000\u0000\u0000\u0011\u0001"+
		"\u0001\u0000\u0000\u0000\u0012\u0013\u0005\u0003\u0000\u0000\u0013\u0014"+
		"\u0005\u0004\u0000\u0000\u0014\u0015\u0005\u0005\u0000\u0000\u0015\u0016"+
		"\u0005\u0017\u0000\u0000\u0016\u0017\u0005\u0005\u0000\u0000\u0017\u001f"+
		"\u0005\u0006\u0000\u0000\u0018\u0019\u0005\u0007\u0000\u0000\u0019\u001a"+
		"\u0005\u0004\u0000\u0000\u001a\u001b\u0005\u0005\u0000\u0000\u001b\u001c"+
		"\u0005\u0017\u0000\u0000\u001c\u001d\u0005\u0005\u0000\u0000\u001d\u001f"+
		"\u0005\u0006\u0000\u0000\u001e\u0012\u0001\u0000\u0000\u0000\u001e\u0018"+
		"\u0001\u0000\u0000\u0000\u001f\u0003\u0001\u0000\u0000\u0000 !\u0006\u0002"+
		"\uffff\uffff\u0000!.\u0005\u0015\u0000\u0000\".\u0005\b\u0000\u0000#."+
		"\u0005\t\u0000\u0000$.\u0005\n\u0000\u0000%.\u0005\u000b\u0000\u0000&"+
		".\u0005\f\u0000\u0000\'(\u0005\r\u0000\u0000(.\u0005\u0016\u0000\u0000"+
		")*\u0005\u0004\u0000\u0000*+\u0003\u0004\u0002\u0000+,\u0005\u0006\u0000"+
		"\u0000,.\u0001\u0000\u0000\u0000- \u0001\u0000\u0000\u0000-\"\u0001\u0000"+
		"\u0000\u0000-#\u0001\u0000\u0000\u0000-$\u0001\u0000\u0000\u0000-%\u0001"+
		"\u0000\u0000\u0000-&\u0001\u0000\u0000\u0000-\'\u0001\u0000\u0000\u0000"+
		"-)\u0001\u0000\u0000\u0000.?\u0001\u0000\u0000\u0000/0\n\u0004\u0000\u0000"+
		"01\u0005\u0001\u0000\u00001>\u0003\u0004\u0002\u000523\n\u0003\u0000\u0000"+
		"34\u0005\u0002\u0000\u00004>\u0003\u0004\u0002\u000456\n\u0001\u0000\u0000"+
		"67\u0005\u0010\u0000\u00007>\u0003\u0004\u0002\u000289\n\u0002\u0000\u0000"+
		"9:\u0005\u000e\u0000\u0000:;\u0003\u0006\u0003\u0000;<\u0005\u000f\u0000"+
		"\u0000<>\u0001\u0000\u0000\u0000=/\u0001\u0000\u0000\u0000=2\u0001\u0000"+
		"\u0000\u0000=5\u0001\u0000\u0000\u0000=8\u0001\u0000\u0000\u0000>A\u0001"+
		"\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000"+
		"@\u0005\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000BC\u0006\u0003"+
		"\uffff\uffff\u0000CW\u0003\u0004\u0002\u0000DE\u0003\u0004\u0002\u0000"+
		"EF\u0005\u0018\u0000\u0000FG\u0003\u0004\u0002\u0000GW\u0001\u0000\u0000"+
		"\u0000HI\u0003\u0004\u0002\u0000IJ\u0005\u0019\u0000\u0000JK\u0003\u0004"+
		"\u0002\u0000KW\u0001\u0000\u0000\u0000LM\u0003\u0004\u0002\u0000MN\u0005"+
		"\u0011\u0000\u0000NO\u0005\u0017\u0000\u0000OW\u0001\u0000\u0000\u0000"+
		"PQ\u0005\u0004\u0000\u0000QR\u0003\u0006\u0003\u0000RS\u0005\u0006\u0000"+
		"\u0000SW\u0001\u0000\u0000\u0000TU\u0005\u0014\u0000\u0000UW\u0003\u0006"+
		"\u0003\u0001VB\u0001\u0000\u0000\u0000VD\u0001\u0000\u0000\u0000VH\u0001"+
		"\u0000\u0000\u0000VL\u0001\u0000\u0000\u0000VP\u0001\u0000\u0000\u0000"+
		"VT\u0001\u0000\u0000\u0000W`\u0001\u0000\u0000\u0000XY\n\u0003\u0000\u0000"+
		"YZ\u0005\u0012\u0000\u0000Z_\u0003\u0006\u0003\u0004[\\\n\u0002\u0000"+
		"\u0000\\]\u0005\u0013\u0000\u0000]_\u0003\u0006\u0003\u0003^X\u0001\u0000"+
		"\u0000\u0000^[\u0001\u0000\u0000\u0000_b\u0001\u0000\u0000\u0000`^\u0001"+
		"\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000a\u0007\u0001\u0000\u0000"+
		"\u0000b`\u0001\u0000\u0000\u0000\b\u0010\u001e-=?V^`";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}