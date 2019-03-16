// Generated from TDLExpressionLanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TDLExpressionLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LEFT_BRACKET=1, RIGHT_BRACKET=2, LEFT_PAREN=3, RIGHT_PAREN=4, LOP_UNIVERSAL_QUANTIFIER=5, 
		LOP_EXISTENTIAL_QUANTIFIER=6, LOP_NEGATION=7, LOP_CONJUNCTION=8, LOP_DISJUNCTION=9, 
		LOP_IMPLICATION=10, LOP_EQUIVALENCE=11, LOP_LEADS_TO=12, LOP_REPETITION_COUNT=13, 
		TOP_ABSOLUTE_COMPLEMENT=14, TOP_RELATIVE_COMPLEMENT=15, TOP_LINKED_PAIR=16, 
		REL_LESS_THAN_OR_EQ=17, REL_GREATER_THAN_OR_EQ=18, REL_LESS_THAN=19, REL_GREATER_THAN=20, 
		REL_EQUAL=21, TRAPSET_ID=22, NATURAL_NUMBER=23, NUMERIC_ID=24, WS=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "LOP_UNIVERSAL_QUANTIFIER", 
		"LOP_EXISTENTIAL_QUANTIFIER", "LOP_NEGATION", "LOP_CONJUNCTION", "LOP_DISJUNCTION", 
		"LOP_IMPLICATION", "LOP_EQUIVALENCE", "LOP_LEADS_TO", "LOP_REPETITION_COUNT", 
		"TOP_ABSOLUTE_COMPLEMENT", "TOP_RELATIVE_COMPLEMENT", "TOP_LINKED_PAIR", 
		"REL_LESS_THAN_OR_EQ", "REL_GREATER_THAN_OR_EQ", "REL_LESS_THAN", "REL_GREATER_THAN", 
		"REL_EQUAL", "TRAPSET_ID", "NATURAL_NUMBER", "NUMERIC_ID", "TRAPSET_PREFIX", 
		"ZERO", "ANY_DIGIT", "NONZERO_DIGIT", "BLANK", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "']'", "'('", "')'", null, null, "'~'", "'&'", "'|'", null, 
		null, null, "'#'", "'!'", "'\\'", "';'", null, null, "'<'", "'>'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "LOP_UNIVERSAL_QUANTIFIER", 
		"LOP_EXISTENTIAL_QUANTIFIER", "LOP_NEGATION", "LOP_CONJUNCTION", "LOP_DISJUNCTION", 
		"LOP_IMPLICATION", "LOP_EQUIVALENCE", "LOP_LEADS_TO", "LOP_REPETITION_COUNT", 
		"TOP_ABSOLUTE_COMPLEMENT", "TOP_RELATIVE_COMPLEMENT", "TOP_LINKED_PAIR", 
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


	public TDLExpressionLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TDLExpressionLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u00b8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\7\13T\n\13\f\13\16\13W\13\13\3\13\3\13\3\f\3\f\7\f]\n\f\f\f\16"+
		"\f`\13\f\3\f\3\f\7\fd\n\f\f\f\16\fg\13\f\3\f\3\f\3\r\3\r\7\rm\n\r\f\r"+
		"\16\rp\13\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\7\22~\n\22\f\22\16\22\u0081\13\22\3\22\3\22\3\23\3\23\7\23\u0087\n\23"+
		"\f\23\16\23\u008a\13\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\5\27\u0096\n\27\3\30\3\30\3\30\7\30\u009b\n\30\f\30\16\30\u009e\13"+
		"\30\5\30\u00a0\n\30\3\31\6\31\u00a3\n\31\r\31\16\31\u00a4\3\32\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\6\37\u00b3\n\37\r\37"+
		"\16\37\u00b4\3\37\3\37\2\2 \3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\2\65\2\67\29\2;\2=\33\3\2\n\4\2WWww\4\2GGgg\4\2VVvv\4\2TTtt\3\2\62"+
		"\62\3\2\62;\3\2\63;\5\2\13\f\17\17\"\"\u00bd\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2=\3\2\2\2"+
		"\3?\3\2\2\2\5A\3\2\2\2\7C\3\2\2\2\tE\3\2\2\2\13G\3\2\2\2\rI\3\2\2\2\17"+
		"K\3\2\2\2\21M\3\2\2\2\23O\3\2\2\2\25Q\3\2\2\2\27Z\3\2\2\2\31j\3\2\2\2"+
		"\33s\3\2\2\2\35u\3\2\2\2\37w\3\2\2\2!y\3\2\2\2#{\3\2\2\2%\u0084\3\2\2"+
		"\2\'\u008d\3\2\2\2)\u008f\3\2\2\2+\u0091\3\2\2\2-\u0093\3\2\2\2/\u009f"+
		"\3\2\2\2\61\u00a2\3\2\2\2\63\u00a6\3\2\2\2\65\u00a9\3\2\2\2\67\u00ab\3"+
		"\2\2\29\u00ad\3\2\2\2;\u00af\3\2\2\2=\u00b2\3\2\2\2?@\7]\2\2@\4\3\2\2"+
		"\2AB\7_\2\2B\6\3\2\2\2CD\7*\2\2D\b\3\2\2\2EF\7+\2\2F\n\3\2\2\2GH\t\2\2"+
		"\2H\f\3\2\2\2IJ\t\3\2\2J\16\3\2\2\2KL\7\u0080\2\2L\20\3\2\2\2MN\7(\2\2"+
		"N\22\3\2\2\2OP\7~\2\2P\24\3\2\2\2QU\7/\2\2RT\5;\36\2SR\3\2\2\2TW\3\2\2"+
		"\2US\3\2\2\2UV\3\2\2\2VX\3\2\2\2WU\3\2\2\2XY\7@\2\2Y\26\3\2\2\2Z^\7>\2"+
		"\2[]\5;\36\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_a\3\2\2\2`^\3\2"+
		"\2\2ae\7/\2\2bd\5;\36\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2"+
		"\2\2ge\3\2\2\2hi\7@\2\2i\30\3\2\2\2jn\7\u0080\2\2km\5;\36\2lk\3\2\2\2"+
		"mp\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2qr\7@\2\2r\32\3\2\2"+
		"\2st\7%\2\2t\34\3\2\2\2uv\7#\2\2v\36\3\2\2\2wx\7^\2\2x \3\2\2\2yz\7=\2"+
		"\2z\"\3\2\2\2{\177\7>\2\2|~\5;\36\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2"+
		"\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2\2\2\u0081\177\3\2\2\2\u0082\u0083"+
		"\7?\2\2\u0083$\3\2\2\2\u0084\u0088\7@\2\2\u0085\u0087\5;\36\2\u0086\u0085"+
		"\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\7?\2\2\u008c&\3\2\2\2\u008d"+
		"\u008e\7>\2\2\u008e(\3\2\2\2\u008f\u0090\7@\2\2\u0090*\3\2\2\2\u0091\u0092"+
		"\7?\2\2\u0092,\3\2\2\2\u0093\u0095\5\63\32\2\u0094\u0096\5\61\31\2\u0095"+
		"\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096.\3\2\2\2\u0097\u00a0\5\65\33"+
		"\2\u0098\u009c\59\35\2\u0099\u009b\5\67\34\2\u009a\u0099\3\2\2\2\u009b"+
		"\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u00a0\3\2"+
		"\2\2\u009e\u009c\3\2\2\2\u009f\u0097\3\2\2\2\u009f\u0098\3\2\2\2\u00a0"+
		"\60\3\2\2\2\u00a1\u00a3\5\67\34\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2"+
		"\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\62\3\2\2\2\u00a6\u00a7"+
		"\t\4\2\2\u00a7\u00a8\t\5\2\2\u00a8\64\3\2\2\2\u00a9\u00aa\t\6\2\2\u00aa"+
		"\66\3\2\2\2\u00ab\u00ac\t\7\2\2\u00ac8\3\2\2\2\u00ad\u00ae\t\b\2\2\u00ae"+
		":\3\2\2\2\u00af\u00b0\t\t\2\2\u00b0<\3\2\2\2\u00b1\u00b3\5;\36\2\u00b2"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\b\37\2\2\u00b7>\3\2\2\2\16\2U^en"+
		"\177\u0088\u0095\u009c\u009f\u00a4\u00b4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}