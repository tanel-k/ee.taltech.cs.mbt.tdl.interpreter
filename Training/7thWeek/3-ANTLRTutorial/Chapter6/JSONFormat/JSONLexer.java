// Generated from JSON.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JSONLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, LCURL=3, RCURL=4, LSQUARE=5, RSQUARE=6, NAME_VALUE_SEP=7, 
		SEQ_SEP=8, BOOL_TRUE=9, BOOL_FALSE=10, VALUE_NULL=11, NUMBER=12, STRING=13, 
		WS=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LPAREN", "RPAREN", "LCURL", "RCURL", "LSQUARE", "RSQUARE", "NAME_VALUE_SEP", 
			"SEQ_SEP", "BOOL_TRUE", "BOOL_FALSE", "VALUE_NULL", "NUMBER", "STRING", 
			"ESC", "UNICODE", "HEX", "NEG", "POS", "INT", "EXP", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "'['", "']'", "':'", "','", "'true'", 
			"'false'", "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAREN", "RPAREN", "LCURL", "RCURL", "LSQUARE", "RSQUARE", "NAME_VALUE_SEP", 
			"SEQ_SEP", "BOOL_TRUE", "BOOL_FALSE", "VALUE_NULL", "NUMBER", "STRING", 
			"WS"
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


	public JSONLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JSON.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20\u0097\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\5\rP\n\r\3\r\3\r\3\r"+
		"\3\r\5\rV\n\r\3\r\3\r\5\rZ\n\r\3\r\3\r\3\r\3\r\3\r\5\ra\n\r\3\r\5\rd\n"+
		"\r\3\16\3\16\3\16\7\16i\n\16\f\16\16\16l\13\16\3\16\3\16\3\17\3\17\3\17"+
		"\5\17s\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\24\7\24\u0084\n\24\f\24\16\24\u0087\13\24\5\24\u0089\n\24"+
		"\3\25\3\25\5\25\u008d\n\25\3\25\3\25\3\26\6\26\u0092\n\26\r\26\16\26\u0093"+
		"\3\26\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\2\37\2!\2#\2%\2\'\2)\2+\20\3\2\n\4\2$$^^\t\2$$^^ddhhpptt"+
		"vv\5\2\62;CHch\3\2\63;\3\2\62;\4\2GGgg\4\2--//\5\2\13\f\17\17\"\"\2\u009f"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5/\3\2\2\2\7\61\3\2\2"+
		"\2\t\63\3\2\2\2\13\65\3\2\2\2\r\67\3\2\2\2\179\3\2\2\2\21;\3\2\2\2\23"+
		"=\3\2\2\2\25B\3\2\2\2\27H\3\2\2\2\31c\3\2\2\2\33e\3\2\2\2\35o\3\2\2\2"+
		"\37t\3\2\2\2!z\3\2\2\2#|\3\2\2\2%~\3\2\2\2\'\u0088\3\2\2\2)\u008a\3\2"+
		"\2\2+\u0091\3\2\2\2-.\7*\2\2.\4\3\2\2\2/\60\7+\2\2\60\6\3\2\2\2\61\62"+
		"\7}\2\2\62\b\3\2\2\2\63\64\7\177\2\2\64\n\3\2\2\2\65\66\7]\2\2\66\f\3"+
		"\2\2\2\678\7_\2\28\16\3\2\2\29:\7<\2\2:\20\3\2\2\2;<\7.\2\2<\22\3\2\2"+
		"\2=>\7v\2\2>?\7t\2\2?@\7w\2\2@A\7g\2\2A\24\3\2\2\2BC\7h\2\2CD\7c\2\2D"+
		"E\7n\2\2EF\7u\2\2FG\7g\2\2G\26\3\2\2\2HI\7p\2\2IJ\7w\2\2JK\7n\2\2KL\7"+
		"n\2\2L\30\3\2\2\2MP\5#\22\2NP\5%\23\2OM\3\2\2\2ON\3\2\2\2OP\3\2\2\2PQ"+
		"\3\2\2\2QR\5\'\24\2RS\7\60\2\2SU\5\'\24\2TV\5)\25\2UT\3\2\2\2UV\3\2\2"+
		"\2Vd\3\2\2\2WZ\5#\22\2XZ\5%\23\2YW\3\2\2\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2"+
		"\2[\\\5\'\24\2\\]\5)\25\2]d\3\2\2\2^a\5#\22\2_a\5%\23\2`^\3\2\2\2`_\3"+
		"\2\2\2`a\3\2\2\2ab\3\2\2\2bd\5\'\24\2cO\3\2\2\2cY\3\2\2\2c`\3\2\2\2d\32"+
		"\3\2\2\2ej\7$\2\2fi\5\35\17\2gi\n\2\2\2hf\3\2\2\2hg\3\2\2\2il\3\2\2\2"+
		"jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mn\7$\2\2n\34\3\2\2\2or\7^\2\2"+
		"ps\t\3\2\2qs\5\37\20\2rp\3\2\2\2rq\3\2\2\2s\36\3\2\2\2tu\7w\2\2uv\5!\21"+
		"\2vw\5!\21\2wx\5!\21\2xy\5!\21\2y \3\2\2\2z{\t\4\2\2{\"\3\2\2\2|}\7/\2"+
		"\2}$\3\2\2\2~\177\7-\2\2\177&\3\2\2\2\u0080\u0089\7\62\2\2\u0081\u0085"+
		"\t\5\2\2\u0082\u0084\t\6\2\2\u0083\u0082\3\2\2\2\u0084\u0087\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2"+
		"\2\2\u0088\u0080\3\2\2\2\u0088\u0081\3\2\2\2\u0089(\3\2\2\2\u008a\u008c"+
		"\t\7\2\2\u008b\u008d\t\b\2\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u008f\5\'\24\2\u008f*\3\2\2\2\u0090\u0092\t\t\2\2"+
		"\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094"+
		"\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\b\26\2\2\u0096,\3\2\2\2\17\2"+
		"OUY`chjr\u0085\u0088\u008c\u0093\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}