// Generated from /Users/shaolongli/Desktop/cse232B_Milestone1/src/main/antlr4/XPath.g4 by ANTLR 4.13.1

package antlr.XPath;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class XPathLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, TAGNAME=19, ATTRNAME=20, STRING=21, EQ=22, IS=23, WS=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "TAGNAME", "ATTRNAME", "STRING", "EQ", "IS", "WS"
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


	public XPathLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XPath.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0018\u009c\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0005"+
		"\u0012m\b\u0012\n\u0012\f\u0012p\t\u0012\u0001\u0013\u0001\u0013\u0005"+
		"\u0013t\b\u0013\n\u0013\f\u0013w\t\u0013\u0001\u0014\u0001\u0014\u0005"+
		"\u0014{\b\u0014\n\u0014\f\u0014~\t\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0005\u0014\u0083\b\u0014\n\u0014\f\u0014\u0086\t\u0014\u0001\u0014"+
		"\u0003\u0014\u0089\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015"+
		"\u008e\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u0094\b\u0016\u0001\u0017\u0004\u0017\u0097\b\u0017\u000b\u0017\f\u0017"+
		"\u0098\u0001\u0017\u0001\u0017\u0000\u0000\u0018\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018\u0001\u0000\u0005\u0003"+
		"\u0000AZ__az\u0005\u0000--09AZ__az\u0003\u0000\n\n\r\r\"\"\u0003\u0000"+
		"\n\n\r\r\'\'\u0003\u0000\t\n\r\r  \u00a3\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000"+
		"\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00011"+
		"\u0001\u0000\u0000\u0000\u00033\u0001\u0000\u0000\u0000\u00056\u0001\u0000"+
		"\u0000\u0000\u0007:\u0001\u0000\u0000\u0000\t<\u0001\u0000\u0000\u0000"+
		"\u000b>\u0001\u0000\u0000\u0000\rG\u0001\u0000\u0000\u0000\u000fI\u0001"+
		"\u0000\u0000\u0000\u0011K\u0001\u0000\u0000\u0000\u0013N\u0001\u0000\u0000"+
		"\u0000\u0015U\u0001\u0000\u0000\u0000\u0017W\u0001\u0000\u0000\u0000\u0019"+
		"Y\u0001\u0000\u0000\u0000\u001b[\u0001\u0000\u0000\u0000\u001d]\u0001"+
		"\u0000\u0000\u0000\u001f_\u0001\u0000\u0000\u0000!c\u0001\u0000\u0000"+
		"\u0000#f\u0001\u0000\u0000\u0000%j\u0001\u0000\u0000\u0000\'q\u0001\u0000"+
		"\u0000\u0000)\u0088\u0001\u0000\u0000\u0000+\u008d\u0001\u0000\u0000\u0000"+
		"-\u0093\u0001\u0000\u0000\u0000/\u0096\u0001\u0000\u0000\u000012\u0005"+
		"/\u0000\u00002\u0002\u0001\u0000\u0000\u000034\u0005/\u0000\u000045\u0005"+
		"/\u0000\u00005\u0004\u0001\u0000\u0000\u000067\u0005d\u0000\u000078\u0005"+
		"o\u0000\u000089\u0005c\u0000\u00009\u0006\u0001\u0000\u0000\u0000:;\u0005"+
		"(\u0000\u0000;\b\u0001\u0000\u0000\u0000<=\u0005)\u0000\u0000=\n\u0001"+
		"\u0000\u0000\u0000>?\u0005d\u0000\u0000?@\u0005o\u0000\u0000@A\u0005c"+
		"\u0000\u0000AB\u0005u\u0000\u0000BC\u0005m\u0000\u0000CD\u0005e\u0000"+
		"\u0000DE\u0005n\u0000\u0000EF\u0005t\u0000\u0000F\f\u0001\u0000\u0000"+
		"\u0000GH\u0005*\u0000\u0000H\u000e\u0001\u0000\u0000\u0000IJ\u0005.\u0000"+
		"\u0000J\u0010\u0001\u0000\u0000\u0000KL\u0005.\u0000\u0000LM\u0005.\u0000"+
		"\u0000M\u0012\u0001\u0000\u0000\u0000NO\u0005t\u0000\u0000OP\u0005e\u0000"+
		"\u0000PQ\u0005x\u0000\u0000QR\u0005t\u0000\u0000RS\u0005(\u0000\u0000"+
		"ST\u0005)\u0000\u0000T\u0014\u0001\u0000\u0000\u0000UV\u0005@\u0000\u0000"+
		"V\u0016\u0001\u0000\u0000\u0000WX\u0005[\u0000\u0000X\u0018\u0001\u0000"+
		"\u0000\u0000YZ\u0005]\u0000\u0000Z\u001a\u0001\u0000\u0000\u0000[\\\u0005"+
		",\u0000\u0000\\\u001c\u0001\u0000\u0000\u0000]^\u0005=\u0000\u0000^\u001e"+
		"\u0001\u0000\u0000\u0000_`\u0005a\u0000\u0000`a\u0005n\u0000\u0000ab\u0005"+
		"d\u0000\u0000b \u0001\u0000\u0000\u0000cd\u0005o\u0000\u0000de\u0005r"+
		"\u0000\u0000e\"\u0001\u0000\u0000\u0000fg\u0005n\u0000\u0000gh\u0005o"+
		"\u0000\u0000hi\u0005t\u0000\u0000i$\u0001\u0000\u0000\u0000jn\u0007\u0000"+
		"\u0000\u0000km\u0007\u0001\u0000\u0000lk\u0001\u0000\u0000\u0000mp\u0001"+
		"\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000"+
		"o&\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qu\u0007\u0000\u0000"+
		"\u0000rt\u0007\u0001\u0000\u0000sr\u0001\u0000\u0000\u0000tw\u0001\u0000"+
		"\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000v(\u0001"+
		"\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000x|\u0005\"\u0000\u0000y{\b"+
		"\u0002\u0000\u0000zy\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000"+
		"|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u007f\u0001\u0000"+
		"\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0089\u0005\"\u0000\u0000"+
		"\u0080\u0084\u0005\'\u0000\u0000\u0081\u0083\b\u0003\u0000\u0000\u0082"+
		"\u0081\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000\u0000\u0084"+
		"\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085"+
		"\u0087\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087"+
		"\u0089\u0005\'\u0000\u0000\u0088x\u0001\u0000\u0000\u0000\u0088\u0080"+
		"\u0001\u0000\u0000\u0000\u0089*\u0001\u0000\u0000\u0000\u008a\u008e\u0005"+
		"=\u0000\u0000\u008b\u008c\u0005e\u0000\u0000\u008c\u008e\u0005q\u0000"+
		"\u0000\u008d\u008a\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000"+
		"\u0000\u008e,\u0001\u0000\u0000\u0000\u008f\u0090\u0005=\u0000\u0000\u0090"+
		"\u0094\u0005=\u0000\u0000\u0091\u0092\u0005i\u0000\u0000\u0092\u0094\u0005"+
		"s\u0000\u0000\u0093\u008f\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000"+
		"\u0000\u0000\u0094.\u0001\u0000\u0000\u0000\u0095\u0097\u0007\u0004\u0000"+
		"\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000"+
		"\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000"+
		"\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009b\u0006\u0017\u0000"+
		"\u0000\u009b0\u0001\u0000\u0000\u0000\t\u0000nu|\u0084\u0088\u008d\u0093"+
		"\u0098\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}