// Generated from UTALanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class UTALanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SKIP_SL_COMMENT=1, SKIP_ML_COMMENT=2, SKIP_WS=3, TYPE_INTEGER=4, TYPE_CLOCK=5, 
		TYPE_CHANNEL=6, TYPE_BOOLEAN=7, TYPE_SCALAR=8, TYPE_STRUCT=9, TYPE_PREFIX_URGENT=10, 
		TYPE_PREFIX_BROADCAST=11, TYPE_PREFIX_META=12, TYPE_PREFIX_CONST=13, EXPR_LITERAL_TRUE=14, 
		EXPR_LITERAL_FALSE=15, EXPR_LITERAL_DEADLOCK=16, ASSG_OP=17, ASSG_OP_SUBTRACTION=18, 
		ASSG_OP_ADDITION=19, ASSG_OP_MULTIPLICATION=20, ASSG_OP_DIVISION=21, ASSG_OP_MODULO=22, 
		ASSG_OP_BITWISE_OR=23, ASSG_OP_BITWISE_AND=24, ASSG_OP_BITWISE_XOR=25, 
		ASSG_OP_LEFT_SHIFT=26, ASSG_OP_RIGHT_SHIFT=27, BINARY_OP_LESS_THAN_OR_EQUAL_TO=28, 
		BINARY_OP_GREATER_THAN_OR_EQUAL=29, BINARY_OP_EQUAL=30, BINARY_OP_NOT_EQUAL=31, 
		BINARY_OP_LEFT_SHIFT=32, BINARY_OP_RIGHT_SHIFT=33, BINARY_OP_CONJUNCTION=34, 
		BINARY_OP_DISJUNCTION=35, BINARY_OP_BITWISE_OR=36, BINARY_OP_MULTIPLICATION=37, 
		BINARY_OP_DIVISION=38, BINARY_OP_MODULO=39, BINARY_OP_BITWISE_XOR=40, 
		BINARY_OP_MAX=41, BINARY_OP_MIN=42, BINARY_OP_GREATER_THAN=43, BINARY_OP_ACCESS_FIELD=44, 
		UNARY_OP_INCREMENT=45, UNARY_OP_DECREMENT=46, COMMON_TOK_COLON=47, COMMON_TOK_PLUS=48, 
		COMMON_TOK_MINUS=49, COMMON_TOK_AMPERSAND=50, COMMON_TOK_LESS_THAN=51, 
		COMMON_TOK_EXCLAMATION_MARK=52, COMMON_TOK_QUESTION_MARK=53, GROUP_LEFT_CURLY=54, 
		GROUP_RIGHT_CURLY=55, GROUP_LEFT_BRACKET=56, GROUP_RIGHT_BRACKET=57, GROUP_LEFT_PAREN=58, 
		GROUP_RIGHT_PAREN=59, SEP_ENUMERATION=60, SEP_SEMICOLON=61, PHRASE_NOT=62, 
		PHRASE_OR=63, PHRASE_AND=64, PHRASE_IMPLY=65, PHRASE_FOR_ALL=66, PHRASE_EXISTS=67, 
		PHRASE_TYPEDEF=68, PHRASE_IF=69, PHRASE_ELSE=70, PHRASE_FOR=71, PHRASE_WHILE=72, 
		PHRASE_RETURN=73, PHRASE_DO=74, PHRASE_PRIORITY=75, PHRASE_DEFAULT=76, 
		PHRASE_SYSTEM=77, PHRASE_PROGRESS=78, IDENTIFIER=79, NATURAL_NUMBER=80;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SKIP_SL_COMMENT", "SKIP_ML_COMMENT", "SKIP_WS", "TYPE_INTEGER", "TYPE_CLOCK", 
		"TYPE_CHANNEL", "TYPE_BOOLEAN", "TYPE_SCALAR", "TYPE_STRUCT", "TYPE_PREFIX_URGENT", 
		"TYPE_PREFIX_BROADCAST", "TYPE_PREFIX_META", "TYPE_PREFIX_CONST", "EXPR_LITERAL_TRUE", 
		"EXPR_LITERAL_FALSE", "EXPR_LITERAL_DEADLOCK", "ASSG_OP", "ASSG_OP_SUBTRACTION", 
		"ASSG_OP_ADDITION", "ASSG_OP_MULTIPLICATION", "ASSG_OP_DIVISION", "ASSG_OP_MODULO", 
		"ASSG_OP_BITWISE_OR", "ASSG_OP_BITWISE_AND", "ASSG_OP_BITWISE_XOR", "ASSG_OP_LEFT_SHIFT", 
		"ASSG_OP_RIGHT_SHIFT", "BINARY_OP_LESS_THAN_OR_EQUAL_TO", "BINARY_OP_GREATER_THAN_OR_EQUAL", 
		"BINARY_OP_EQUAL", "BINARY_OP_NOT_EQUAL", "BINARY_OP_LEFT_SHIFT", "BINARY_OP_RIGHT_SHIFT", 
		"BINARY_OP_CONJUNCTION", "BINARY_OP_DISJUNCTION", "BINARY_OP_BITWISE_OR", 
		"BINARY_OP_MULTIPLICATION", "BINARY_OP_DIVISION", "BINARY_OP_MODULO", 
		"BINARY_OP_BITWISE_XOR", "BINARY_OP_MAX", "BINARY_OP_MIN", "BINARY_OP_GREATER_THAN", 
		"BINARY_OP_ACCESS_FIELD", "UNARY_OP_INCREMENT", "UNARY_OP_DECREMENT", 
		"COMMON_TOK_COLON", "COMMON_TOK_PLUS", "COMMON_TOK_MINUS", "COMMON_TOK_AMPERSAND", 
		"COMMON_TOK_LESS_THAN", "COMMON_TOK_EXCLAMATION_MARK", "COMMON_TOK_QUESTION_MARK", 
		"GROUP_LEFT_CURLY", "GROUP_RIGHT_CURLY", "GROUP_LEFT_BRACKET", "GROUP_RIGHT_BRACKET", 
		"GROUP_LEFT_PAREN", "GROUP_RIGHT_PAREN", "SEP_ENUMERATION", "SEP_SEMICOLON", 
		"PHRASE_NOT", "PHRASE_OR", "PHRASE_AND", "PHRASE_IMPLY", "PHRASE_FOR_ALL", 
		"PHRASE_EXISTS", "PHRASE_TYPEDEF", "PHRASE_IF", "PHRASE_ELSE", "PHRASE_FOR", 
		"PHRASE_WHILE", "PHRASE_RETURN", "PHRASE_DO", "PHRASE_PRIORITY", "PHRASE_DEFAULT", 
		"PHRASE_SYSTEM", "PHRASE_PROGRESS", "IDENTIFIER", "NATURAL_NUMBER", "SYMBOL_ASSIGNMENT", 
		"SYMBOL_ASSIGNMENT_LEGACY"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'int'", "'clock'", "'chan'", "'bool'", "'scalar'", 
		"'struct'", "'urgent'", "'broadcast'", "'meta'", "'const'", "'true'", 
		"'false'", "'deadlock'", null, "'-='", "'+='", "'*='", "'/='", "'%='", 
		"'|='", "'&='", "'^='", "'<<='", "'>>='", "'<='", "'>='", "'=='", "'!='", 
		"'<<'", "'>>'", "'&&'", "'||'", "'|'", "'*'", "'/'", "'%'", "'^'", "'>?'", 
		"'<?'", "'>'", "'.'", "'++'", "'--'", "':'", "'+'", "'-'", "'&'", "'<'", 
		"'!'", "'?'", "'{'", "'}'", "'['", "']'", "'('", "')'", "','", "';'", 
		"'not'", "'or'", "'and'", "'imply'", "'forall'", "'exists'", "'typedef'", 
		"'if'", "'else'", "'for'", "'while'", "'return'", "'do'", "'priority'", 
		"'default'", "'system'", "'progress'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SKIP_SL_COMMENT", "SKIP_ML_COMMENT", "SKIP_WS", "TYPE_INTEGER", 
		"TYPE_CLOCK", "TYPE_CHANNEL", "TYPE_BOOLEAN", "TYPE_SCALAR", "TYPE_STRUCT", 
		"TYPE_PREFIX_URGENT", "TYPE_PREFIX_BROADCAST", "TYPE_PREFIX_META", "TYPE_PREFIX_CONST", 
		"EXPR_LITERAL_TRUE", "EXPR_LITERAL_FALSE", "EXPR_LITERAL_DEADLOCK", "ASSG_OP", 
		"ASSG_OP_SUBTRACTION", "ASSG_OP_ADDITION", "ASSG_OP_MULTIPLICATION", "ASSG_OP_DIVISION", 
		"ASSG_OP_MODULO", "ASSG_OP_BITWISE_OR", "ASSG_OP_BITWISE_AND", "ASSG_OP_BITWISE_XOR", 
		"ASSG_OP_LEFT_SHIFT", "ASSG_OP_RIGHT_SHIFT", "BINARY_OP_LESS_THAN_OR_EQUAL_TO", 
		"BINARY_OP_GREATER_THAN_OR_EQUAL", "BINARY_OP_EQUAL", "BINARY_OP_NOT_EQUAL", 
		"BINARY_OP_LEFT_SHIFT", "BINARY_OP_RIGHT_SHIFT", "BINARY_OP_CONJUNCTION", 
		"BINARY_OP_DISJUNCTION", "BINARY_OP_BITWISE_OR", "BINARY_OP_MULTIPLICATION", 
		"BINARY_OP_DIVISION", "BINARY_OP_MODULO", "BINARY_OP_BITWISE_XOR", "BINARY_OP_MAX", 
		"BINARY_OP_MIN", "BINARY_OP_GREATER_THAN", "BINARY_OP_ACCESS_FIELD", "UNARY_OP_INCREMENT", 
		"UNARY_OP_DECREMENT", "COMMON_TOK_COLON", "COMMON_TOK_PLUS", "COMMON_TOK_MINUS", 
		"COMMON_TOK_AMPERSAND", "COMMON_TOK_LESS_THAN", "COMMON_TOK_EXCLAMATION_MARK", 
		"COMMON_TOK_QUESTION_MARK", "GROUP_LEFT_CURLY", "GROUP_RIGHT_CURLY", "GROUP_LEFT_BRACKET", 
		"GROUP_RIGHT_BRACKET", "GROUP_LEFT_PAREN", "GROUP_RIGHT_PAREN", "SEP_ENUMERATION", 
		"SEP_SEMICOLON", "PHRASE_NOT", "PHRASE_OR", "PHRASE_AND", "PHRASE_IMPLY", 
		"PHRASE_FOR_ALL", "PHRASE_EXISTS", "PHRASE_TYPEDEF", "PHRASE_IF", "PHRASE_ELSE", 
		"PHRASE_FOR", "PHRASE_WHILE", "PHRASE_RETURN", "PHRASE_DO", "PHRASE_PRIORITY", 
		"PHRASE_DEFAULT", "PHRASE_SYSTEM", "PHRASE_PROGRESS", "IDENTIFIER", "NATURAL_NUMBER"
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


	public static final int CHAN_LANGUAGE = 1;
	public static final int CHAN_WHITESPACE = 1;
	public static final int CHAN_COMMENTS = 2;


	public UTALanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "UTALanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2R\u0204\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\3\2\3"+
		"\2\3\2\3\2\7\2\u00ac\n\2\f\2\16\2\u00af\13\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\7\3\u00b9\n\3\f\3\16\3\u00bc\13\3\3\3\3\3\3\3\3\3\3\3\3\4\6\4\u00c4"+
		"\n\4\r\4\16\4\u00c5\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\5\22\u011e\n\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 "+
		"\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3"+
		")\3*\3*\3*\3+\3+\3+\3,\3,\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\61\3\61"+
		"\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39"+
		"\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3?\3?\3@\3@\3@\3A\3A\3A\3A\3B"+
		"\3B\3B\3B\3B\3B\3C\3C\3C\3C\3C\3C\3C\3D\3D\3D\3D\3D\3D\3D\3E\3E\3E\3E"+
		"\3E\3E\3E\3E\3F\3F\3F\3G\3G\3G\3G\3G\3H\3H\3H\3H\3I\3I\3I\3I\3I\3I\3J"+
		"\3J\3J\3J\3J\3J\3J\3K\3K\3K\3L\3L\3L\3L\3L\3L\3L\3L\3L\3M\3M\3M\3M\3M"+
		"\3M\3M\3M\3N\3N\3N\3N\3N\3N\3N\3O\3O\3O\3O\3O\3O\3O\3O\3O\3P\3P\7P\u01f6"+
		"\nP\fP\16P\u01f9\13P\3Q\6Q\u01fc\nQ\rQ\16Q\u01fd\3R\3R\3S\3S\3S\4\u00ad"+
		"\u00ba\2T\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65"+
		"i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008b"+
		"G\u008dH\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009bO\u009dP\u009f"+
		"Q\u00a1R\u00a3\2\u00a5\2\3\2\7\4\2\"\"\60\60\5\2\13\f\17\17\"\"\5\2C\\"+
		"aac|\6\2\62;C\\aac|\3\2\62;\u0207\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3"+
		"\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2"+
		"\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2"+
		"u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2"+
		"\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089"+
		"\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2"+
		"\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b"+
		"\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\3\u00a7\3\2\2"+
		"\2\5\u00b4\3\2\2\2\7\u00c3\3\2\2\2\t\u00c9\3\2\2\2\13\u00cd\3\2\2\2\r"+
		"\u00d3\3\2\2\2\17\u00d8\3\2\2\2\21\u00dd\3\2\2\2\23\u00e4\3\2\2\2\25\u00eb"+
		"\3\2\2\2\27\u00f2\3\2\2\2\31\u00fc\3\2\2\2\33\u0101\3\2\2\2\35\u0107\3"+
		"\2\2\2\37\u010c\3\2\2\2!\u0112\3\2\2\2#\u011d\3\2\2\2%\u011f\3\2\2\2\'"+
		"\u0122\3\2\2\2)\u0125\3\2\2\2+\u0128\3\2\2\2-\u012b\3\2\2\2/\u012e\3\2"+
		"\2\2\61\u0131\3\2\2\2\63\u0134\3\2\2\2\65\u0137\3\2\2\2\67\u013b\3\2\2"+
		"\29\u013f\3\2\2\2;\u0142\3\2\2\2=\u0145\3\2\2\2?\u0148\3\2\2\2A\u014b"+
		"\3\2\2\2C\u014e\3\2\2\2E\u0151\3\2\2\2G\u0154\3\2\2\2I\u0157\3\2\2\2K"+
		"\u0159\3\2\2\2M\u015b\3\2\2\2O\u015d\3\2\2\2Q\u015f\3\2\2\2S\u0161\3\2"+
		"\2\2U\u0164\3\2\2\2W\u0167\3\2\2\2Y\u0169\3\2\2\2[\u016b\3\2\2\2]\u016e"+
		"\3\2\2\2_\u0171\3\2\2\2a\u0173\3\2\2\2c\u0175\3\2\2\2e\u0177\3\2\2\2g"+
		"\u0179\3\2\2\2i\u017b\3\2\2\2k\u017d\3\2\2\2m\u017f\3\2\2\2o\u0181\3\2"+
		"\2\2q\u0183\3\2\2\2s\u0185\3\2\2\2u\u0187\3\2\2\2w\u0189\3\2\2\2y\u018b"+
		"\3\2\2\2{\u018d\3\2\2\2}\u018f\3\2\2\2\177\u0193\3\2\2\2\u0081\u0196\3"+
		"\2\2\2\u0083\u019a\3\2\2\2\u0085\u01a0\3\2\2\2\u0087\u01a7\3\2\2\2\u0089"+
		"\u01ae\3\2\2\2\u008b\u01b6\3\2\2\2\u008d\u01b9\3\2\2\2\u008f\u01be\3\2"+
		"\2\2\u0091\u01c2\3\2\2\2\u0093\u01c8\3\2\2\2\u0095\u01cf\3\2\2\2\u0097"+
		"\u01d2\3\2\2\2\u0099\u01db\3\2\2\2\u009b\u01e3\3\2\2\2\u009d\u01ea\3\2"+
		"\2\2\u009f\u01f3\3\2\2\2\u00a1\u01fb\3\2\2\2\u00a3\u01ff\3\2\2\2\u00a5"+
		"\u0201\3\2\2\2\u00a7\u00a8\7\61\2\2\u00a8\u00a9\7\61\2\2\u00a9\u00ad\3"+
		"\2\2\2\u00aa\u00ac\t\2\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad"+
		"\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b0\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00b0\u00b1\7\f\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\b\2\2\2\u00b3"+
		"\4\3\2\2\2\u00b4\u00b5\7\61\2\2\u00b5\u00b6\7,\2\2\u00b6\u00ba\3\2\2\2"+
		"\u00b7\u00b9\13\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00bb"+
		"\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd"+
		"\u00be\7,\2\2\u00be\u00bf\7\61\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\b\3"+
		"\2\2\u00c1\6\3\2\2\2\u00c2\u00c4\t\3\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c5"+
		"\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7"+
		"\u00c8\b\4\3\2\u00c8\b\3\2\2\2\u00c9\u00ca\7k\2\2\u00ca\u00cb\7p\2\2\u00cb"+
		"\u00cc\7v\2\2\u00cc\n\3\2\2\2\u00cd\u00ce\7e\2\2\u00ce\u00cf\7n\2\2\u00cf"+
		"\u00d0\7q\2\2\u00d0\u00d1\7e\2\2\u00d1\u00d2\7m\2\2\u00d2\f\3\2\2\2\u00d3"+
		"\u00d4\7e\2\2\u00d4\u00d5\7j\2\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7p\2\2"+
		"\u00d7\16\3\2\2\2\u00d8\u00d9\7d\2\2\u00d9\u00da\7q\2\2\u00da\u00db\7"+
		"q\2\2\u00db\u00dc\7n\2\2\u00dc\20\3\2\2\2\u00dd\u00de\7u\2\2\u00de\u00df"+
		"\7e\2\2\u00df\u00e0\7c\2\2\u00e0\u00e1\7n\2\2\u00e1\u00e2\7c\2\2\u00e2"+
		"\u00e3\7t\2\2\u00e3\22\3\2\2\2\u00e4\u00e5\7u\2\2\u00e5\u00e6\7v\2\2\u00e6"+
		"\u00e7\7t\2\2\u00e7\u00e8\7w\2\2\u00e8\u00e9\7e\2\2\u00e9\u00ea\7v\2\2"+
		"\u00ea\24\3\2\2\2\u00eb\u00ec\7w\2\2\u00ec\u00ed\7t\2\2\u00ed\u00ee\7"+
		"i\2\2\u00ee\u00ef\7g\2\2\u00ef\u00f0\7p\2\2\u00f0\u00f1\7v\2\2\u00f1\26"+
		"\3\2\2\2\u00f2\u00f3\7d\2\2\u00f3\u00f4\7t\2\2\u00f4\u00f5\7q\2\2\u00f5"+
		"\u00f6\7c\2\2\u00f6\u00f7\7f\2\2\u00f7\u00f8\7e\2\2\u00f8\u00f9\7c\2\2"+
		"\u00f9\u00fa\7u\2\2\u00fa\u00fb\7v\2\2\u00fb\30\3\2\2\2\u00fc\u00fd\7"+
		"o\2\2\u00fd\u00fe\7g\2\2\u00fe\u00ff\7v\2\2\u00ff\u0100\7c\2\2\u0100\32"+
		"\3\2\2\2\u0101\u0102\7e\2\2\u0102\u0103\7q\2\2\u0103\u0104\7p\2\2\u0104"+
		"\u0105\7u\2\2\u0105\u0106\7v\2\2\u0106\34\3\2\2\2\u0107\u0108\7v\2\2\u0108"+
		"\u0109\7t\2\2\u0109\u010a\7w\2\2\u010a\u010b\7g\2\2\u010b\36\3\2\2\2\u010c"+
		"\u010d\7h\2\2\u010d\u010e\7c\2\2\u010e\u010f\7n\2\2\u010f\u0110\7u\2\2"+
		"\u0110\u0111\7g\2\2\u0111 \3\2\2\2\u0112\u0113\7f\2\2\u0113\u0114\7g\2"+
		"\2\u0114\u0115\7c\2\2\u0115\u0116\7f\2\2\u0116\u0117\7n\2\2\u0117\u0118"+
		"\7q\2\2\u0118\u0119\7e\2\2\u0119\u011a\7m\2\2\u011a\"\3\2\2\2\u011b\u011e"+
		"\5\u00a3R\2\u011c\u011e\5\u00a5S\2\u011d\u011b\3\2\2\2\u011d\u011c\3\2"+
		"\2\2\u011e$\3\2\2\2\u011f\u0120\7/\2\2\u0120\u0121\7?\2\2\u0121&\3\2\2"+
		"\2\u0122\u0123\7-\2\2\u0123\u0124\7?\2\2\u0124(\3\2\2\2\u0125\u0126\7"+
		",\2\2\u0126\u0127\7?\2\2\u0127*\3\2\2\2\u0128\u0129\7\61\2\2\u0129\u012a"+
		"\7?\2\2\u012a,\3\2\2\2\u012b\u012c\7\'\2\2\u012c\u012d\7?\2\2\u012d.\3"+
		"\2\2\2\u012e\u012f\7~\2\2\u012f\u0130\7?\2\2\u0130\60\3\2\2\2\u0131\u0132"+
		"\7(\2\2\u0132\u0133\7?\2\2\u0133\62\3\2\2\2\u0134\u0135\7`\2\2\u0135\u0136"+
		"\7?\2\2\u0136\64\3\2\2\2\u0137\u0138\7>\2\2\u0138\u0139\7>\2\2\u0139\u013a"+
		"\7?\2\2\u013a\66\3\2\2\2\u013b\u013c\7@\2\2\u013c\u013d\7@\2\2\u013d\u013e"+
		"\7?\2\2\u013e8\3\2\2\2\u013f\u0140\7>\2\2\u0140\u0141\7?\2\2\u0141:\3"+
		"\2\2\2\u0142\u0143\7@\2\2\u0143\u0144\7?\2\2\u0144<\3\2\2\2\u0145\u0146"+
		"\7?\2\2\u0146\u0147\7?\2\2\u0147>\3\2\2\2\u0148\u0149\7#\2\2\u0149\u014a"+
		"\7?\2\2\u014a@\3\2\2\2\u014b\u014c\7>\2\2\u014c\u014d\7>\2\2\u014dB\3"+
		"\2\2\2\u014e\u014f\7@\2\2\u014f\u0150\7@\2\2\u0150D\3\2\2\2\u0151\u0152"+
		"\7(\2\2\u0152\u0153\7(\2\2\u0153F\3\2\2\2\u0154\u0155\7~\2\2\u0155\u0156"+
		"\7~\2\2\u0156H\3\2\2\2\u0157\u0158\7~\2\2\u0158J\3\2\2\2\u0159\u015a\7"+
		",\2\2\u015aL\3\2\2\2\u015b\u015c\7\61\2\2\u015cN\3\2\2\2\u015d\u015e\7"+
		"\'\2\2\u015eP\3\2\2\2\u015f\u0160\7`\2\2\u0160R\3\2\2\2\u0161\u0162\7"+
		"@\2\2\u0162\u0163\7A\2\2\u0163T\3\2\2\2\u0164\u0165\7>\2\2\u0165\u0166"+
		"\7A\2\2\u0166V\3\2\2\2\u0167\u0168\7@\2\2\u0168X\3\2\2\2\u0169\u016a\7"+
		"\60\2\2\u016aZ\3\2\2\2\u016b\u016c\7-\2\2\u016c\u016d\7-\2\2\u016d\\\3"+
		"\2\2\2\u016e\u016f\7/\2\2\u016f\u0170\7/\2\2\u0170^\3\2\2\2\u0171\u0172"+
		"\7<\2\2\u0172`\3\2\2\2\u0173\u0174\7-\2\2\u0174b\3\2\2\2\u0175\u0176\7"+
		"/\2\2\u0176d\3\2\2\2\u0177\u0178\7(\2\2\u0178f\3\2\2\2\u0179\u017a\7>"+
		"\2\2\u017ah\3\2\2\2\u017b\u017c\7#\2\2\u017cj\3\2\2\2\u017d\u017e\7A\2"+
		"\2\u017el\3\2\2\2\u017f\u0180\7}\2\2\u0180n\3\2\2\2\u0181\u0182\7\177"+
		"\2\2\u0182p\3\2\2\2\u0183\u0184\7]\2\2\u0184r\3\2\2\2\u0185\u0186\7_\2"+
		"\2\u0186t\3\2\2\2\u0187\u0188\7*\2\2\u0188v\3\2\2\2\u0189\u018a\7+\2\2"+
		"\u018ax\3\2\2\2\u018b\u018c\7.\2\2\u018cz\3\2\2\2\u018d\u018e\7=\2\2\u018e"+
		"|\3\2\2\2\u018f\u0190\7p\2\2\u0190\u0191\7q\2\2\u0191\u0192\7v\2\2\u0192"+
		"~\3\2\2\2\u0193\u0194\7q\2\2\u0194\u0195\7t\2\2\u0195\u0080\3\2\2\2\u0196"+
		"\u0197\7c\2\2\u0197\u0198\7p\2\2\u0198\u0199\7f\2\2\u0199\u0082\3\2\2"+
		"\2\u019a\u019b\7k\2\2\u019b\u019c\7o\2\2\u019c\u019d\7r\2\2\u019d\u019e"+
		"\7n\2\2\u019e\u019f\7{\2\2\u019f\u0084\3\2\2\2\u01a0\u01a1\7h\2\2\u01a1"+
		"\u01a2\7q\2\2\u01a2\u01a3\7t\2\2\u01a3\u01a4\7c\2\2\u01a4\u01a5\7n\2\2"+
		"\u01a5\u01a6\7n\2\2\u01a6\u0086\3\2\2\2\u01a7\u01a8\7g\2\2\u01a8\u01a9"+
		"\7z\2\2\u01a9\u01aa\7k\2\2\u01aa\u01ab\7u\2\2\u01ab\u01ac\7v\2\2\u01ac"+
		"\u01ad\7u\2\2\u01ad\u0088\3\2\2\2\u01ae\u01af\7v\2\2\u01af\u01b0\7{\2"+
		"\2\u01b0\u01b1\7r\2\2\u01b1\u01b2\7g\2\2\u01b2\u01b3\7f\2\2\u01b3\u01b4"+
		"\7g\2\2\u01b4\u01b5\7h\2\2\u01b5\u008a\3\2\2\2\u01b6\u01b7\7k\2\2\u01b7"+
		"\u01b8\7h\2\2\u01b8\u008c\3\2\2\2\u01b9\u01ba\7g\2\2\u01ba\u01bb\7n\2"+
		"\2\u01bb\u01bc\7u\2\2\u01bc\u01bd\7g\2\2\u01bd\u008e\3\2\2\2\u01be\u01bf"+
		"\7h\2\2\u01bf\u01c0\7q\2\2\u01c0\u01c1\7t\2\2\u01c1\u0090\3\2\2\2\u01c2"+
		"\u01c3\7y\2\2\u01c3\u01c4\7j\2\2\u01c4\u01c5\7k\2\2\u01c5\u01c6\7n\2\2"+
		"\u01c6\u01c7\7g\2\2\u01c7\u0092\3\2\2\2\u01c8\u01c9\7t\2\2\u01c9\u01ca"+
		"\7g\2\2\u01ca\u01cb\7v\2\2\u01cb\u01cc\7w\2\2\u01cc\u01cd\7t\2\2\u01cd"+
		"\u01ce\7p\2\2\u01ce\u0094\3\2\2\2\u01cf\u01d0\7f\2\2\u01d0\u01d1\7q\2"+
		"\2\u01d1\u0096\3\2\2\2\u01d2\u01d3\7r\2\2\u01d3\u01d4\7t\2\2\u01d4\u01d5"+
		"\7k\2\2\u01d5\u01d6\7q\2\2\u01d6\u01d7\7t\2\2\u01d7\u01d8\7k\2\2\u01d8"+
		"\u01d9\7v\2\2\u01d9\u01da\7{\2\2\u01da\u0098\3\2\2\2\u01db\u01dc\7f\2"+
		"\2\u01dc\u01dd\7g\2\2\u01dd\u01de\7h\2\2\u01de\u01df\7c\2\2\u01df\u01e0"+
		"\7w\2\2\u01e0\u01e1\7n\2\2\u01e1\u01e2\7v\2\2\u01e2\u009a\3\2\2\2\u01e3"+
		"\u01e4\7u\2\2\u01e4\u01e5\7{\2\2\u01e5\u01e6\7u\2\2\u01e6\u01e7\7v\2\2"+
		"\u01e7\u01e8\7g\2\2\u01e8\u01e9\7o\2\2\u01e9\u009c\3\2\2\2\u01ea\u01eb"+
		"\7r\2\2\u01eb\u01ec\7t\2\2\u01ec\u01ed\7q\2\2\u01ed\u01ee\7i\2\2\u01ee"+
		"\u01ef\7t\2\2\u01ef\u01f0\7g\2\2\u01f0\u01f1\7u\2\2\u01f1\u01f2\7u\2\2"+
		"\u01f2\u009e\3\2\2\2\u01f3\u01f7\t\4\2\2\u01f4\u01f6\t\5\2\2\u01f5\u01f4"+
		"\3\2\2\2\u01f6\u01f9\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8"+
		"\u00a0\3\2\2\2\u01f9\u01f7\3\2\2\2\u01fa\u01fc\t\6\2\2\u01fb\u01fa\3\2"+
		"\2\2\u01fc\u01fd\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe"+
		"\u00a2\3\2\2\2\u01ff\u0200\7?\2\2\u0200\u00a4\3\2\2\2\u0201\u0202\7<\2"+
		"\2\u0202\u0203\7?\2\2\u0203\u00a6\3\2\2\2\t\2\u00ad\u00ba\u00c5\u011d"+
		"\u01f7\u01fd\4\2\4\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}