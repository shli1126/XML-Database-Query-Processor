// Generated from c:/Users/Shaolong Li/Desktop/cse232B_Milestone1/src/main/antlr4/XPath.g4 by ANTLR 4.13.1

package antlr.XPath;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class XPathParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, TAGNAME=19, ATTRNAME=20, STRING=21, EQ=22, IS=23, WS=24;
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
			null, "'/'", "'//'", "'doc'", "'('", "')'", "'document'", "'*'", "'.'", 
			"'..'", "'text()'", "'@'", "'['", "']'", "','", "'='", "'and'", "'or'", 
			"'not'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "TAGNAME", "ATTRNAME", "STRING", 
			"EQ", "IS", "WS"
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
	}

	public final DocContext doc() throws RecognitionException {
		DocContext _localctx = new DocContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_doc);
		try {
			setState(26);
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
				match(STRING);
				setState(21);
				match(T__4);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(22);
				match(T__5);
				setState(23);
				match(T__3);
				setState(24);
				match(STRING);
				setState(25);
				match(T__4);
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
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAGNAME:
				{
				setState(29);
				match(TAGNAME);
				}
				break;
			case T__6:
				{
				setState(30);
				match(T__6);
				}
				break;
			case T__7:
				{
				setState(31);
				match(T__7);
				}
				break;
			case T__8:
				{
				setState(32);
				match(T__8);
				}
				break;
			case T__9:
				{
				setState(33);
				match(T__9);
				}
				break;
			case T__10:
				{
				setState(34);
				match(T__10);
				setState(35);
				match(ATTRNAME);
				}
				break;
			case T__3:
				{
				setState(36);
				match(T__3);
				setState(37);
				rp(0);
				setState(38);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(58);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(56);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(42);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(43);
						match(T__0);
						setState(44);
						rp(5);
						}
						break;
					case 2:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(45);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(46);
						match(T__1);
						setState(47);
						rp(4);
						}
						break;
					case 3:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(48);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(49);
						match(T__13);
						setState(50);
						rp(2);
						}
						break;
					case 4:
						{
						_localctx = new RpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(51);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(52);
						match(T__11);
						setState(53);
						f(0);
						setState(54);
						match(T__12);
						}
						break;
					}
					} 
				}
				setState(60);
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
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(62);
				rp(0);
				}
				break;
			case 2:
				{
				setState(63);
				rp(0);
				setState(64);
				match(EQ);
				setState(65);
				rp(0);
				}
				break;
			case 3:
				{
				setState(67);
				rp(0);
				setState(68);
				match(IS);
				setState(69);
				rp(0);
				}
				break;
			case 4:
				{
				setState(71);
				rp(0);
				setState(72);
				match(T__14);
				setState(73);
				match(STRING);
				}
				break;
			case 5:
				{
				setState(75);
				match(T__3);
				setState(76);
				f(0);
				setState(77);
				match(T__4);
				}
				break;
			case 6:
				{
				setState(79);
				match(T__17);
				setState(80);
				f(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(89);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new FContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(83);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(84);
						match(T__15);
						setState(85);
						f(4);
						}
						break;
					case 2:
						{
						_localctx = new FContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(86);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(87);
						match(T__16);
						setState(88);
						f(3);
						}
						break;
					}
					} 
				}
				setState(93);
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
		"\u0004\u0001\u0018_\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003"+
		"\u0000\u0011\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u001b\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002)\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00029\b\u0002\n\u0002"+
		"\f\u0002<\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003R\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005"+
		"\u0003Z\b\u0003\n\u0003\f\u0003]\t\u0003\u0001\u0003\u0000\u0002\u0004"+
		"\u0006\u0004\u0000\u0002\u0004\u0006\u0000\u0000m\u0000\u0010\u0001\u0000"+
		"\u0000\u0000\u0002\u001a\u0001\u0000\u0000\u0000\u0004(\u0001\u0000\u0000"+
		"\u0000\u0006Q\u0001\u0000\u0000\u0000\b\t\u0003\u0002\u0001\u0000\t\n"+
		"\u0005\u0001\u0000\u0000\n\u000b\u0003\u0004\u0002\u0000\u000b\u0011\u0001"+
		"\u0000\u0000\u0000\f\r\u0003\u0002\u0001\u0000\r\u000e\u0005\u0002\u0000"+
		"\u0000\u000e\u000f\u0003\u0004\u0002\u0000\u000f\u0011\u0001\u0000\u0000"+
		"\u0000\u0010\b\u0001\u0000\u0000\u0000\u0010\f\u0001\u0000\u0000\u0000"+
		"\u0011\u0001\u0001\u0000\u0000\u0000\u0012\u0013\u0005\u0003\u0000\u0000"+
		"\u0013\u0014\u0005\u0004\u0000\u0000\u0014\u0015\u0005\u0015\u0000\u0000"+
		"\u0015\u001b\u0005\u0005\u0000\u0000\u0016\u0017\u0005\u0006\u0000\u0000"+
		"\u0017\u0018\u0005\u0004\u0000\u0000\u0018\u0019\u0005\u0015\u0000\u0000"+
		"\u0019\u001b\u0005\u0005\u0000\u0000\u001a\u0012\u0001\u0000\u0000\u0000"+
		"\u001a\u0016\u0001\u0000\u0000\u0000\u001b\u0003\u0001\u0000\u0000\u0000"+
		"\u001c\u001d\u0006\u0002\uffff\uffff\u0000\u001d)\u0005\u0013\u0000\u0000"+
		"\u001e)\u0005\u0007\u0000\u0000\u001f)\u0005\b\u0000\u0000 )\u0005\t\u0000"+
		"\u0000!)\u0005\n\u0000\u0000\"#\u0005\u000b\u0000\u0000#)\u0005\u0014"+
		"\u0000\u0000$%\u0005\u0004\u0000\u0000%&\u0003\u0004\u0002\u0000&\'\u0005"+
		"\u0005\u0000\u0000\')\u0001\u0000\u0000\u0000(\u001c\u0001\u0000\u0000"+
		"\u0000(\u001e\u0001\u0000\u0000\u0000(\u001f\u0001\u0000\u0000\u0000("+
		" \u0001\u0000\u0000\u0000(!\u0001\u0000\u0000\u0000(\"\u0001\u0000\u0000"+
		"\u0000($\u0001\u0000\u0000\u0000):\u0001\u0000\u0000\u0000*+\n\u0004\u0000"+
		"\u0000+,\u0005\u0001\u0000\u0000,9\u0003\u0004\u0002\u0005-.\n\u0003\u0000"+
		"\u0000./\u0005\u0002\u0000\u0000/9\u0003\u0004\u0002\u000401\n\u0001\u0000"+
		"\u000012\u0005\u000e\u0000\u000029\u0003\u0004\u0002\u000234\n\u0002\u0000"+
		"\u000045\u0005\f\u0000\u000056\u0003\u0006\u0003\u000067\u0005\r\u0000"+
		"\u000079\u0001\u0000\u0000\u00008*\u0001\u0000\u0000\u00008-\u0001\u0000"+
		"\u0000\u000080\u0001\u0000\u0000\u000083\u0001\u0000\u0000\u00009<\u0001"+
		"\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000"+
		";\u0005\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000=>\u0006\u0003"+
		"\uffff\uffff\u0000>R\u0003\u0004\u0002\u0000?@\u0003\u0004\u0002\u0000"+
		"@A\u0005\u0016\u0000\u0000AB\u0003\u0004\u0002\u0000BR\u0001\u0000\u0000"+
		"\u0000CD\u0003\u0004\u0002\u0000DE\u0005\u0017\u0000\u0000EF\u0003\u0004"+
		"\u0002\u0000FR\u0001\u0000\u0000\u0000GH\u0003\u0004\u0002\u0000HI\u0005"+
		"\u000f\u0000\u0000IJ\u0005\u0015\u0000\u0000JR\u0001\u0000\u0000\u0000"+
		"KL\u0005\u0004\u0000\u0000LM\u0003\u0006\u0003\u0000MN\u0005\u0005\u0000"+
		"\u0000NR\u0001\u0000\u0000\u0000OP\u0005\u0012\u0000\u0000PR\u0003\u0006"+
		"\u0003\u0001Q=\u0001\u0000\u0000\u0000Q?\u0001\u0000\u0000\u0000QC\u0001"+
		"\u0000\u0000\u0000QG\u0001\u0000\u0000\u0000QK\u0001\u0000\u0000\u0000"+
		"QO\u0001\u0000\u0000\u0000R[\u0001\u0000\u0000\u0000ST\n\u0003\u0000\u0000"+
		"TU\u0005\u0010\u0000\u0000UZ\u0003\u0006\u0003\u0004VW\n\u0002\u0000\u0000"+
		"WX\u0005\u0011\u0000\u0000XZ\u0003\u0006\u0003\u0003YS\u0001\u0000\u0000"+
		"\u0000YV\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000"+
		"\u0000\u0000[\\\u0001\u0000\u0000\u0000\\\u0007\u0001\u0000\u0000\u0000"+
		"][\u0001\u0000\u0000\u0000\b\u0010\u001a(8:QY[";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}