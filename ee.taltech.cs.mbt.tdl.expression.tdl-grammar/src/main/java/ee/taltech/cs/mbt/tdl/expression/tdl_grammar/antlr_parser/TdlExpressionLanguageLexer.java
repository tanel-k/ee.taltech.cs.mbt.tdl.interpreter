// Generated from TdlExpressionLanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TdlExpressionLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LEFT_BRACKET=1, RIGHT_BRACKET=2, LEFT_PAREN=3, RIGHT_PAREN=4, LOP_UNIVERSAL_QUANTIFIER=5, 
		LOP_EXISTENTIAL_QUANTIFIER=6, LOP_NEGATION=7, LOP_CONJUNCTION=8, LOP_DISJUNCTION=9, 
		LOP_IMPLICATION=10, LOP_EQUIVALENCE=11, LOP_LEADS_TO=12, LOP_REPETITION_COUNT=13, 
		TOP_ABSOLUTE_COMPLEMENT=14, TOP_RELATIVE_COMPLEMENT=15, TOP_LINKED_PAIRS=16, 
		REL_LESS_THAN_OR_EQ=17, REL_GREATER_THAN_OR_EQ=18, REL_LESS_THAN=19, REL_GREATER_THAN=20, 
		REL_EQUAL=21, TRAPSET_ID=22, NATURAL_NUMBER=23, NUMERIC_ID=24, WS=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "LOP_UNIVERSAL_QUANTIFIER", 
		"LOP_EXISTENTIAL_QUANTIFIER", "LOP_NEGATION", "LOP_CONJUNCTION", "LOP_DISJUNCTION", 
		"LOP_IMPLICATION", "LOP_EQUIVALENCE", "LOP_LEADS_TO", "LOP_REPETITION_COUNT", 
		"TOP_ABSOLUTE_COMPLEMENT", "TOP_RELATIVE_COMPLEMENT", "TOP_LINKED_PAIRS", 
		"REL_LESS_THAN_OR_EQ", "REL_GREATER_THAN_OR_EQ", "REL_LESS_THAN", "REL_GREATER_THAN", 
		"REL_EQUAL", "TRAPSET_ID", "NATURAL_NUMBER", "NUMERIC_ID", "TRAPSET_PREFIX", 
		"ZERO", "ANY_DIGIT", "NONZERO_DIGIT", "BLANK", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "']'", "'('", "')'", null, null, "'~'", "'&&'", "'||'", null, 
		null, null, "'#'", "'!'", "'\\'", "';'", null, null, "'<'", "'>'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "LOP_UNIVERSAL_QUANTIFIER", 
		"LOP_EXISTENTIAL_QUANTIFIER", "LOP_NEGATION", "LOP_CONJUNCTION", "LOP_DISJUNCTION", 
		"LOP_IMPLICATION", "LOP_EQUIVALENCE", "LOP_LEADS_TO", "LOP_REPETITION_COUNT", 
		"TOP_ABSOLUTE_COMPLEMENT", "TOP_RELATIVE_COMPLEMENT", "TOP_LINKED_PAIRS", 
		"REL_LESS_THAN_OR_EQ", "REL_GREATER_THAN_OR_EQ", "REL_LESS_THAN", "REL_GREATER_THAN", 
		"REL_EQUAL", "TRAPSET_ID", "NATURAL_NUMBER", "NUMERIC_ID", "WS"
	};
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


	public TdlExpressionLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TdlExpressionLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u00ba\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\13\3\13\7\13V\n\13\f\13\16\13Y\13\13\3\13\3\13\3\f\3\f\7\f_\n"+
		"\f\f\f\16\fb\13\f\3\f\3\f\7\ff\n\f\f\f\16\fi\13\f\3\f\3\f\3\r\3\r\7\r"+
		"o\n\r\f\r\16\rr\13\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\22\3\22\7\22\u0080\n\22\f\22\16\22\u0083\13\22\3\22\3\22\3\23\3\23\7"+
		"\23\u0089\n\23\f\23\16\23\u008c\13\23\3\23\3\23\3\24\3\24\3\25\3\25\3"+
		"\26\3\26\3\27\3\27\5\27\u0098\n\27\3\30\3\30\3\30\7\30\u009d\n\30\f\30"+
		"\16\30\u00a0\13\30\5\30\u00a2\n\30\3\31\6\31\u00a5\n\31\r\31\16\31\u00a6"+
		"\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\6\37\u00b5"+
		"\n\37\r\37\16\37\u00b6\3\37\3\37\2\2 \3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\2\65\2\67\29\2;\2=\33\3\2\n\4\2CCcc\4\2GGgg\4\2VVvv\4\2"+
		"UUuu\3\2\62\62\3\2\62;\3\2\63;\5\2\13\f\17\17\"\"\u00bf\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2=\3\2\2\2\3?\3\2\2\2\5A\3\2\2\2\7C\3\2\2\2\tE\3\2\2\2\13G\3\2\2\2\r"+
		"I\3\2\2\2\17K\3\2\2\2\21M\3\2\2\2\23P\3\2\2\2\25S\3\2\2\2\27\\\3\2\2\2"+
		"\31l\3\2\2\2\33u\3\2\2\2\35w\3\2\2\2\37y\3\2\2\2!{\3\2\2\2#}\3\2\2\2%"+
		"\u0086\3\2\2\2\'\u008f\3\2\2\2)\u0091\3\2\2\2+\u0093\3\2\2\2-\u0095\3"+
		"\2\2\2/\u00a1\3\2\2\2\61\u00a4\3\2\2\2\63\u00a8\3\2\2\2\65\u00ab\3\2\2"+
		"\2\67\u00ad\3\2\2\29\u00af\3\2\2\2;\u00b1\3\2\2\2=\u00b4\3\2\2\2?@\7]"+
		"\2\2@\4\3\2\2\2AB\7_\2\2B\6\3\2\2\2CD\7*\2\2D\b\3\2\2\2EF\7+\2\2F\n\3"+
		"\2\2\2GH\t\2\2\2H\f\3\2\2\2IJ\t\3\2\2J\16\3\2\2\2KL\7\u0080\2\2L\20\3"+
		"\2\2\2MN\7(\2\2NO\7(\2\2O\22\3\2\2\2PQ\7~\2\2QR\7~\2\2R\24\3\2\2\2SW\7"+
		"/\2\2TV\5;\36\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3"+
		"\2\2\2Z[\7@\2\2[\26\3\2\2\2\\`\7>\2\2]_\5;\36\2^]\3\2\2\2_b\3\2\2\2`^"+
		"\3\2\2\2`a\3\2\2\2ac\3\2\2\2b`\3\2\2\2cg\7/\2\2df\5;\36\2ed\3\2\2\2fi"+
		"\3\2\2\2ge\3\2\2\2gh\3\2\2\2hj\3\2\2\2ig\3\2\2\2jk\7@\2\2k\30\3\2\2\2"+
		"lp\7\u0080\2\2mo\5;\36\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qs\3\2"+
		"\2\2rp\3\2\2\2st\7@\2\2t\32\3\2\2\2uv\7%\2\2v\34\3\2\2\2wx\7#\2\2x\36"+
		"\3\2\2\2yz\7^\2\2z \3\2\2\2{|\7=\2\2|\"\3\2\2\2}\u0081\7>\2\2~\u0080\5"+
		";\36\2\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\7?\2\2\u0085"+
		"$\3\2\2\2\u0086\u008a\7@\2\2\u0087\u0089\5;\36\2\u0088\u0087\3\2\2\2\u0089"+
		"\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2"+
		"\2\2\u008c\u008a\3\2\2\2\u008d\u008e\7?\2\2\u008e&\3\2\2\2\u008f\u0090"+
		"\7>\2\2\u0090(\3\2\2\2\u0091\u0092\7@\2\2\u0092*\3\2\2\2\u0093\u0094\7"+
		"?\2\2\u0094,\3\2\2\2\u0095\u0097\5\63\32\2\u0096\u0098\5\61\31\2\u0097"+
		"\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098.\3\2\2\2\u0099\u00a2\5\65\33"+
		"\2\u009a\u009e\59\35\2\u009b\u009d\5\67\34\2\u009c\u009b\3\2\2\2\u009d"+
		"\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a2\3\2"+
		"\2\2\u00a0\u009e\3\2\2\2\u00a1\u0099\3\2\2\2\u00a1\u009a\3\2\2\2\u00a2"+
		"\60\3\2\2\2\u00a3\u00a5\5\67\34\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6\3\2"+
		"\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\62\3\2\2\2\u00a8\u00a9"+
		"\t\4\2\2\u00a9\u00aa\t\5\2\2\u00aa\64\3\2\2\2\u00ab\u00ac\t\6\2\2\u00ac"+
		"\66\3\2\2\2\u00ad\u00ae\t\7\2\2\u00ae8\3\2\2\2\u00af\u00b0\t\b\2\2\u00b0"+
		":\3\2\2\2\u00b1\u00b2\t\t\2\2\u00b2<\3\2\2\2\u00b3\u00b5\5;\36\2\u00b4"+
		"\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2"+
		"\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\b\37\2\2\u00b9>\3\2\2\2\16\2W`gp"+
		"\u0081\u008a\u0097\u009e\u00a1\u00a6\u00b6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}