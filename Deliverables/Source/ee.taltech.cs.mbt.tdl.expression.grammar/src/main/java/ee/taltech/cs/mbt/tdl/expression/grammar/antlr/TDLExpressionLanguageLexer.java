// Generated from TDLExpressionLanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.expression.grammar.antlr;
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
		REL_LESS_THAN=17, REL_LESS_THAN_OR_EQ=18, REL_GREATER_THAN=19, REL_GREATER_THAN_OR_EQ=20, 
		REL_EQUAL=21, TRAPSET_ID=22, NUMERIC_ID=23, NATURAL_NUMBER=24, WS=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "LOP_UNIVERSAL_QUANTIFIER", 
		"LOP_EXISTENTIAL_QUANTIFIER", "LOP_NEGATION", "LOP_CONJUNCTION", "LOP_DISJUNCTION", 
		"LOP_IMPLICATION", "LOP_EQUIVALENCE", "LOP_LEADS_TO", "LOP_REPETITION_COUNT", 
		"TOP_ABSOLUTE_COMPLEMENT", "TOP_RELATIVE_COMPLEMENT", "TOP_LINKED_PAIR", 
		"REL_LESS_THAN", "REL_LESS_THAN_OR_EQ", "REL_GREATER_THAN", "REL_GREATER_THAN_OR_EQ", 
		"REL_EQUAL", "TRAPSET_ID", "NUMERIC_ID", "NATURAL_NUMBER", "WS", "TRAPSET_PREFIX", 
		"ZERO", "DIGIT", "NONZERO_DIGIT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "']'", "'('", "')'", null, null, "'~'", "'&'", "'|'", "'->'", 
		"'<->'", "'~>'", "'#'", "'!'", "'\\'", "';'", "'<'", "'<='", "'>'", "'>='", 
		"'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LEFT_BRACKET", "RIGHT_BRACKET", "LEFT_PAREN", "RIGHT_PAREN", "LOP_UNIVERSAL_QUANTIFIER", 
		"LOP_EXISTENTIAL_QUANTIFIER", "LOP_NEGATION", "LOP_CONJUNCTION", "LOP_DISJUNCTION", 
		"LOP_IMPLICATION", "LOP_EQUIVALENCE", "LOP_LEADS_TO", "LOP_REPETITION_COUNT", 
		"TOP_ABSOLUTE_COMPLEMENT", "TOP_RELATIVE_COMPLEMENT", "TOP_LINKED_PAIR", 
		"REL_LESS_THAN", "REL_LESS_THAN_OR_EQ", "REL_GREATER_THAN", "REL_GREATER_THAN_OR_EQ", 
		"REL_EQUAL", "TRAPSET_ID", "NUMERIC_ID", "NATURAL_NUMBER", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u008f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\5\27p\n\27\3\30\6\30s\n\30\r\30\16\30t\3\31\3\31\3\31\6\31z\n\31\r\31"+
		"\16\31{\5\31~\n\31\3\32\6\32\u0081\n\32\r\32\16\32\u0082\3\32\3\32\3\33"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\2\2\37\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\2\67\29\2;\2\3\2\t\4\2CCcc\4\2GGgg\5\2"+
		"\13\f\17\17\"\"\4\2VVvv\4\2TTtt\3\2\62;\3\2\63;\u008f\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\3=\3\2\2\2\5?\3\2\2\2\7A\3\2\2\2\tC\3\2\2\2\13E\3\2\2\2\r"+
		"G\3\2\2\2\17I\3\2\2\2\21K\3\2\2\2\23M\3\2\2\2\25O\3\2\2\2\27R\3\2\2\2"+
		"\31V\3\2\2\2\33Y\3\2\2\2\35[\3\2\2\2\37]\3\2\2\2!_\3\2\2\2#a\3\2\2\2%"+
		"c\3\2\2\2\'f\3\2\2\2)h\3\2\2\2+k\3\2\2\2-m\3\2\2\2/r\3\2\2\2\61}\3\2\2"+
		"\2\63\u0080\3\2\2\2\65\u0086\3\2\2\2\67\u0089\3\2\2\29\u008b\3\2\2\2;"+
		"\u008d\3\2\2\2=>\7]\2\2>\4\3\2\2\2?@\7_\2\2@\6\3\2\2\2AB\7*\2\2B\b\3\2"+
		"\2\2CD\7+\2\2D\n\3\2\2\2EF\t\2\2\2F\f\3\2\2\2GH\t\3\2\2H\16\3\2\2\2IJ"+
		"\7\u0080\2\2J\20\3\2\2\2KL\7(\2\2L\22\3\2\2\2MN\7~\2\2N\24\3\2\2\2OP\7"+
		"/\2\2PQ\7@\2\2Q\26\3\2\2\2RS\7>\2\2ST\7/\2\2TU\7@\2\2U\30\3\2\2\2VW\7"+
		"\u0080\2\2WX\7@\2\2X\32\3\2\2\2YZ\7%\2\2Z\34\3\2\2\2[\\\7#\2\2\\\36\3"+
		"\2\2\2]^\7^\2\2^ \3\2\2\2_`\7=\2\2`\"\3\2\2\2ab\7>\2\2b$\3\2\2\2cd\7>"+
		"\2\2de\7?\2\2e&\3\2\2\2fg\7@\2\2g(\3\2\2\2hi\7@\2\2ij\7?\2\2j*\3\2\2\2"+
		"kl\7?\2\2l,\3\2\2\2mo\5\65\33\2np\5/\30\2on\3\2\2\2op\3\2\2\2p.\3\2\2"+
		"\2qs\59\35\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\60\3\2\2\2v~\5\67"+
		"\34\2wy\5;\36\2xz\59\35\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3"+
		"\2\2\2}v\3\2\2\2}w\3\2\2\2~\62\3\2\2\2\177\u0081\t\4\2\2\u0080\177\3\2"+
		"\2\2\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0085\b\32\2\2\u0085\64\3\2\2\2\u0086\u0087\t\5\2"+
		"\2\u0087\u0088\t\6\2\2\u0088\66\3\2\2\2\u0089\u008a\7\62\2\2\u008a8\3"+
		"\2\2\2\u008b\u008c\t\7\2\2\u008c:\3\2\2\2\u008d\u008e\t\b\2\2\u008e<\3"+
		"\2\2\2\b\2ot{}\u0082\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}