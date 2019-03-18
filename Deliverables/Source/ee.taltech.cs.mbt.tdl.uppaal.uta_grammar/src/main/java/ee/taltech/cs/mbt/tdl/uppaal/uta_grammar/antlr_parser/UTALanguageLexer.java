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
		GROUP_RIGHT_PAREN=59, SEP_ENUMERATION=60, SEP_SEMICOLON=61, PHRASE_VOID=62, 
		PHRASE_NOT=63, PHRASE_OR=64, PHRASE_AND=65, PHRASE_IMPLY=66, PHRASE_FOR_ALL=67, 
		PHRASE_EXISTS=68, PHRASE_TYPEDEF=69, PHRASE_IF=70, PHRASE_ELSE=71, PHRASE_FOR=72, 
		PHRASE_WHILE=73, PHRASE_RETURN=74, PHRASE_DO=75, PHRASE_PRIORITY=76, PHRASE_DEFAULT=77, 
		PHRASE_SYSTEM=78, PHRASE_PROGRESS=79, IDENTIFIER_NAME=80, NATURAL_NUMBER=81;
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
		"PHRASE_VOID", "PHRASE_NOT", "PHRASE_OR", "PHRASE_AND", "PHRASE_IMPLY", 
		"PHRASE_FOR_ALL", "PHRASE_EXISTS", "PHRASE_TYPEDEF", "PHRASE_IF", "PHRASE_ELSE", 
		"PHRASE_FOR", "PHRASE_WHILE", "PHRASE_RETURN", "PHRASE_DO", "PHRASE_PRIORITY", 
		"PHRASE_DEFAULT", "PHRASE_SYSTEM", "PHRASE_PROGRESS", "IDENTIFIER_NAME", 
		"NATURAL_NUMBER", "SYMBOL_ASSIGNMENT", "SYMBOL_ASSIGNMENT_LEGACY"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "'int'", "'clock'", "'chan'", "'bool'", "'scalar'", 
		"'struct'", "'urgent'", "'broadcast'", "'meta'", "'const'", "'true'", 
		"'false'", "'deadlock'", null, "'-='", "'+='", "'*='", "'/='", "'%='", 
		"'|='", "'&='", "'^='", "'<<='", "'>>='", "'<='", "'>='", "'=='", "'!='", 
		"'<<'", "'>>'", "'&&'", "'||'", "'|'", "'*'", "'/'", "'%'", "'^'", "'>?'", 
		"'<?'", "'>'", "'.'", "'++'", "'--'", "':'", "'+'", "'-'", "'&'", "'<'", 
		"'!'", "'?'", "'{'", "'}'", "'['", "']'", "'('", "')'", "','", "';'", 
		"'void'", "'not'", "'or'", "'and'", "'imply'", "'forall'", "'exists'", 
		"'typedef'", "'if'", "'else'", "'for'", "'while'", "'return'", "'do'", 
		"'priority'", "'default'", "'system'", "'progress'"
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
		"SEP_SEMICOLON", "PHRASE_VOID", "PHRASE_NOT", "PHRASE_OR", "PHRASE_AND", 
		"PHRASE_IMPLY", "PHRASE_FOR_ALL", "PHRASE_EXISTS", "PHRASE_TYPEDEF", "PHRASE_IF", 
		"PHRASE_ELSE", "PHRASE_FOR", "PHRASE_WHILE", "PHRASE_RETURN", "PHRASE_DO", 
		"PHRASE_PRIORITY", "PHRASE_DEFAULT", "PHRASE_SYSTEM", "PHRASE_PROGRESS", 
		"IDENTIFIER_NAME", "NATURAL_NUMBER"
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


	public static final int CHANNEL_LANGUAGE = 0;
	public static final int CHANNEL_WHITESPACE = 1;
	public static final int CHANNEL_COMMENTS = 2;


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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2S\u020c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\3\2\3\2\3\2\3\2\7\2\u00ae\n\2\f\2\16\2\u00b1\13\2\3\2\5\2\u00b4\n\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\7\3\u00bc\n\3\f\3\16\3\u00bf\13\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\4\6\4\u00c7\n\4\r\4\16\4\u00c8\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\5\22\u0121\n\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3&\3"+
		"&\3\'\3\'\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3-\3-\3.\3.\3.\3/\3/\3/"+
		"\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66"+
		"\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3?\3?\3?\3"+
		"@\3@\3@\3@\3A\3A\3A\3B\3B\3B\3B\3C\3C\3C\3C\3C\3C\3D\3D\3D\3D\3D\3D\3"+
		"D\3E\3E\3E\3E\3E\3E\3E\3F\3F\3F\3F\3F\3F\3F\3F\3G\3G\3G\3H\3H\3H\3H\3"+
		"H\3I\3I\3I\3I\3J\3J\3J\3J\3J\3J\3K\3K\3K\3K\3K\3K\3K\3L\3L\3L\3M\3M\3"+
		"M\3M\3M\3M\3M\3M\3M\3N\3N\3N\3N\3N\3N\3N\3N\3O\3O\3O\3O\3O\3O\3O\3P\3"+
		"P\3P\3P\3P\3P\3P\3P\3P\3Q\3Q\7Q\u01fe\nQ\fQ\16Q\u0201\13Q\3R\6R\u0204"+
		"\nR\rR\16R\u0205\3S\3S\3T\3T\3T\4\u00af\u00bd\2U\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		")Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081"+
		"B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095"+
		"L\u0097M\u0099N\u009bO\u009dP\u009fQ\u00a1R\u00a3S\u00a5\2\u00a7\2\3\2"+
		"\7\3\3\f\f\5\2\13\f\17\17\"\"\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\u020f"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2"+
		"{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097"+
		"\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2"+
		"\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\3\u00a9\3\2\2\2\5\u00b7\3\2\2\2\7\u00c6"+
		"\3\2\2\2\t\u00cc\3\2\2\2\13\u00d0\3\2\2\2\r\u00d6\3\2\2\2\17\u00db\3\2"+
		"\2\2\21\u00e0\3\2\2\2\23\u00e7\3\2\2\2\25\u00ee\3\2\2\2\27\u00f5\3\2\2"+
		"\2\31\u00ff\3\2\2\2\33\u0104\3\2\2\2\35\u010a\3\2\2\2\37\u010f\3\2\2\2"+
		"!\u0115\3\2\2\2#\u0120\3\2\2\2%\u0122\3\2\2\2\'\u0125\3\2\2\2)\u0128\3"+
		"\2\2\2+\u012b\3\2\2\2-\u012e\3\2\2\2/\u0131\3\2\2\2\61\u0134\3\2\2\2\63"+
		"\u0137\3\2\2\2\65\u013a\3\2\2\2\67\u013e\3\2\2\29\u0142\3\2\2\2;\u0145"+
		"\3\2\2\2=\u0148\3\2\2\2?\u014b\3\2\2\2A\u014e\3\2\2\2C\u0151\3\2\2\2E"+
		"\u0154\3\2\2\2G\u0157\3\2\2\2I\u015a\3\2\2\2K\u015c\3\2\2\2M\u015e\3\2"+
		"\2\2O\u0160\3\2\2\2Q\u0162\3\2\2\2S\u0164\3\2\2\2U\u0167\3\2\2\2W\u016a"+
		"\3\2\2\2Y\u016c\3\2\2\2[\u016e\3\2\2\2]\u0171\3\2\2\2_\u0174\3\2\2\2a"+
		"\u0176\3\2\2\2c\u0178\3\2\2\2e\u017a\3\2\2\2g\u017c\3\2\2\2i\u017e\3\2"+
		"\2\2k\u0180\3\2\2\2m\u0182\3\2\2\2o\u0184\3\2\2\2q\u0186\3\2\2\2s\u0188"+
		"\3\2\2\2u\u018a\3\2\2\2w\u018c\3\2\2\2y\u018e\3\2\2\2{\u0190\3\2\2\2}"+
		"\u0192\3\2\2\2\177\u0197\3\2\2\2\u0081\u019b\3\2\2\2\u0083\u019e\3\2\2"+
		"\2\u0085\u01a2\3\2\2\2\u0087\u01a8\3\2\2\2\u0089\u01af\3\2\2\2\u008b\u01b6"+
		"\3\2\2\2\u008d\u01be\3\2\2\2\u008f\u01c1\3\2\2\2\u0091\u01c6\3\2\2\2\u0093"+
		"\u01ca\3\2\2\2\u0095\u01d0\3\2\2\2\u0097\u01d7\3\2\2\2\u0099\u01da\3\2"+
		"\2\2\u009b\u01e3\3\2\2\2\u009d\u01eb\3\2\2\2\u009f\u01f2\3\2\2\2\u00a1"+
		"\u01fb\3\2\2\2\u00a3\u0203\3\2\2\2\u00a5\u0207\3\2\2\2\u00a7\u0209\3\2"+
		"\2\2\u00a9\u00aa\7\61\2\2\u00aa\u00ab\7\61\2\2\u00ab\u00af\3\2\2\2\u00ac"+
		"\u00ae\13\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00b0\3"+
		"\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2"+
		"\u00b4\t\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\b\2"+
		"\2\2\u00b6\4\3\2\2\2\u00b7\u00b8\7\61\2\2\u00b8\u00b9\7,\2\2\u00b9\u00bd"+
		"\3\2\2\2\u00ba\u00bc\13\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2"+
		"\u00bd\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd"+
		"\3\2\2\2\u00c0\u00c1\7,\2\2\u00c1\u00c2\7\61\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c4\b\3\2\2\u00c4\6\3\2\2\2\u00c5\u00c7\t\3\2\2\u00c6\u00c5\3\2\2\2"+
		"\u00c7\u00c8\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca"+
		"\3\2\2\2\u00ca\u00cb\b\4\3\2\u00cb\b\3\2\2\2\u00cc\u00cd\7k\2\2\u00cd"+
		"\u00ce\7p\2\2\u00ce\u00cf\7v\2\2\u00cf\n\3\2\2\2\u00d0\u00d1\7e\2\2\u00d1"+
		"\u00d2\7n\2\2\u00d2\u00d3\7q\2\2\u00d3\u00d4\7e\2\2\u00d4\u00d5\7m\2\2"+
		"\u00d5\f\3\2\2\2\u00d6\u00d7\7e\2\2\u00d7\u00d8\7j\2\2\u00d8\u00d9\7c"+
		"\2\2\u00d9\u00da\7p\2\2\u00da\16\3\2\2\2\u00db\u00dc\7d\2\2\u00dc\u00dd"+
		"\7q\2\2\u00dd\u00de\7q\2\2\u00de\u00df\7n\2\2\u00df\20\3\2\2\2\u00e0\u00e1"+
		"\7u\2\2\u00e1\u00e2\7e\2\2\u00e2\u00e3\7c\2\2\u00e3\u00e4\7n\2\2\u00e4"+
		"\u00e5\7c\2\2\u00e5\u00e6\7t\2\2\u00e6\22\3\2\2\2\u00e7\u00e8\7u\2\2\u00e8"+
		"\u00e9\7v\2\2\u00e9\u00ea\7t\2\2\u00ea\u00eb\7w\2\2\u00eb\u00ec\7e\2\2"+
		"\u00ec\u00ed\7v\2\2\u00ed\24\3\2\2\2\u00ee\u00ef\7w\2\2\u00ef\u00f0\7"+
		"t\2\2\u00f0\u00f1\7i\2\2\u00f1\u00f2\7g\2\2\u00f2\u00f3\7p\2\2\u00f3\u00f4"+
		"\7v\2\2\u00f4\26\3\2\2\2\u00f5\u00f6\7d\2\2\u00f6\u00f7\7t\2\2\u00f7\u00f8"+
		"\7q\2\2\u00f8\u00f9\7c\2\2\u00f9\u00fa\7f\2\2\u00fa\u00fb\7e\2\2\u00fb"+
		"\u00fc\7c\2\2\u00fc\u00fd\7u\2\2\u00fd\u00fe\7v\2\2\u00fe\30\3\2\2\2\u00ff"+
		"\u0100\7o\2\2\u0100\u0101\7g\2\2\u0101\u0102\7v\2\2\u0102\u0103\7c\2\2"+
		"\u0103\32\3\2\2\2\u0104\u0105\7e\2\2\u0105\u0106\7q\2\2\u0106\u0107\7"+
		"p\2\2\u0107\u0108\7u\2\2\u0108\u0109\7v\2\2\u0109\34\3\2\2\2\u010a\u010b"+
		"\7v\2\2\u010b\u010c\7t\2\2\u010c\u010d\7w\2\2\u010d\u010e\7g\2\2\u010e"+
		"\36\3\2\2\2\u010f\u0110\7h\2\2\u0110\u0111\7c\2\2\u0111\u0112\7n\2\2\u0112"+
		"\u0113\7u\2\2\u0113\u0114\7g\2\2\u0114 \3\2\2\2\u0115\u0116\7f\2\2\u0116"+
		"\u0117\7g\2\2\u0117\u0118\7c\2\2\u0118\u0119\7f\2\2\u0119\u011a\7n\2\2"+
		"\u011a\u011b\7q\2\2\u011b\u011c\7e\2\2\u011c\u011d\7m\2\2\u011d\"\3\2"+
		"\2\2\u011e\u0121\5\u00a5S\2\u011f\u0121\5\u00a7T\2\u0120\u011e\3\2\2\2"+
		"\u0120\u011f\3\2\2\2\u0121$\3\2\2\2\u0122\u0123\7/\2\2\u0123\u0124\7?"+
		"\2\2\u0124&\3\2\2\2\u0125\u0126\7-\2\2\u0126\u0127\7?\2\2\u0127(\3\2\2"+
		"\2\u0128\u0129\7,\2\2\u0129\u012a\7?\2\2\u012a*\3\2\2\2\u012b\u012c\7"+
		"\61\2\2\u012c\u012d\7?\2\2\u012d,\3\2\2\2\u012e\u012f\7\'\2\2\u012f\u0130"+
		"\7?\2\2\u0130.\3\2\2\2\u0131\u0132\7~\2\2\u0132\u0133\7?\2\2\u0133\60"+
		"\3\2\2\2\u0134\u0135\7(\2\2\u0135\u0136\7?\2\2\u0136\62\3\2\2\2\u0137"+
		"\u0138\7`\2\2\u0138\u0139\7?\2\2\u0139\64\3\2\2\2\u013a\u013b\7>\2\2\u013b"+
		"\u013c\7>\2\2\u013c\u013d\7?\2\2\u013d\66\3\2\2\2\u013e\u013f\7@\2\2\u013f"+
		"\u0140\7@\2\2\u0140\u0141\7?\2\2\u01418\3\2\2\2\u0142\u0143\7>\2\2\u0143"+
		"\u0144\7?\2\2\u0144:\3\2\2\2\u0145\u0146\7@\2\2\u0146\u0147\7?\2\2\u0147"+
		"<\3\2\2\2\u0148\u0149\7?\2\2\u0149\u014a\7?\2\2\u014a>\3\2\2\2\u014b\u014c"+
		"\7#\2\2\u014c\u014d\7?\2\2\u014d@\3\2\2\2\u014e\u014f\7>\2\2\u014f\u0150"+
		"\7>\2\2\u0150B\3\2\2\2\u0151\u0152\7@\2\2\u0152\u0153\7@\2\2\u0153D\3"+
		"\2\2\2\u0154\u0155\7(\2\2\u0155\u0156\7(\2\2\u0156F\3\2\2\2\u0157\u0158"+
		"\7~\2\2\u0158\u0159\7~\2\2\u0159H\3\2\2\2\u015a\u015b\7~\2\2\u015bJ\3"+
		"\2\2\2\u015c\u015d\7,\2\2\u015dL\3\2\2\2\u015e\u015f\7\61\2\2\u015fN\3"+
		"\2\2\2\u0160\u0161\7\'\2\2\u0161P\3\2\2\2\u0162\u0163\7`\2\2\u0163R\3"+
		"\2\2\2\u0164\u0165\7@\2\2\u0165\u0166\7A\2\2\u0166T\3\2\2\2\u0167\u0168"+
		"\7>\2\2\u0168\u0169\7A\2\2\u0169V\3\2\2\2\u016a\u016b\7@\2\2\u016bX\3"+
		"\2\2\2\u016c\u016d\7\60\2\2\u016dZ\3\2\2\2\u016e\u016f\7-\2\2\u016f\u0170"+
		"\7-\2\2\u0170\\\3\2\2\2\u0171\u0172\7/\2\2\u0172\u0173\7/\2\2\u0173^\3"+
		"\2\2\2\u0174\u0175\7<\2\2\u0175`\3\2\2\2\u0176\u0177\7-\2\2\u0177b\3\2"+
		"\2\2\u0178\u0179\7/\2\2\u0179d\3\2\2\2\u017a\u017b\7(\2\2\u017bf\3\2\2"+
		"\2\u017c\u017d\7>\2\2\u017dh\3\2\2\2\u017e\u017f\7#\2\2\u017fj\3\2\2\2"+
		"\u0180\u0181\7A\2\2\u0181l\3\2\2\2\u0182\u0183\7}\2\2\u0183n\3\2\2\2\u0184"+
		"\u0185\7\177\2\2\u0185p\3\2\2\2\u0186\u0187\7]\2\2\u0187r\3\2\2\2\u0188"+
		"\u0189\7_\2\2\u0189t\3\2\2\2\u018a\u018b\7*\2\2\u018bv\3\2\2\2\u018c\u018d"+
		"\7+\2\2\u018dx\3\2\2\2\u018e\u018f\7.\2\2\u018fz\3\2\2\2\u0190\u0191\7"+
		"=\2\2\u0191|\3\2\2\2\u0192\u0193\7x\2\2\u0193\u0194\7q\2\2\u0194\u0195"+
		"\7k\2\2\u0195\u0196\7f\2\2\u0196~\3\2\2\2\u0197\u0198\7p\2\2\u0198\u0199"+
		"\7q\2\2\u0199\u019a\7v\2\2\u019a\u0080\3\2\2\2\u019b\u019c\7q\2\2\u019c"+
		"\u019d\7t\2\2\u019d\u0082\3\2\2\2\u019e\u019f\7c\2\2\u019f\u01a0\7p\2"+
		"\2\u01a0\u01a1\7f\2\2\u01a1\u0084\3\2\2\2\u01a2\u01a3\7k\2\2\u01a3\u01a4"+
		"\7o\2\2\u01a4\u01a5\7r\2\2\u01a5\u01a6\7n\2\2\u01a6\u01a7\7{\2\2\u01a7"+
		"\u0086\3\2\2\2\u01a8\u01a9\7h\2\2\u01a9\u01aa\7q\2\2\u01aa\u01ab\7t\2"+
		"\2\u01ab\u01ac\7c\2\2\u01ac\u01ad\7n\2\2\u01ad\u01ae\7n\2\2\u01ae\u0088"+
		"\3\2\2\2\u01af\u01b0\7g\2\2\u01b0\u01b1\7z\2\2\u01b1\u01b2\7k\2\2\u01b2"+
		"\u01b3\7u\2\2\u01b3\u01b4\7v\2\2\u01b4\u01b5\7u\2\2\u01b5\u008a\3\2\2"+
		"\2\u01b6\u01b7\7v\2\2\u01b7\u01b8\7{\2\2\u01b8\u01b9\7r\2\2\u01b9\u01ba"+
		"\7g\2\2\u01ba\u01bb\7f\2\2\u01bb\u01bc\7g\2\2\u01bc\u01bd\7h\2\2\u01bd"+
		"\u008c\3\2\2\2\u01be\u01bf\7k\2\2\u01bf\u01c0\7h\2\2\u01c0\u008e\3\2\2"+
		"\2\u01c1\u01c2\7g\2\2\u01c2\u01c3\7n\2\2\u01c3\u01c4\7u\2\2\u01c4\u01c5"+
		"\7g\2\2\u01c5\u0090\3\2\2\2\u01c6\u01c7\7h\2\2\u01c7\u01c8\7q\2\2\u01c8"+
		"\u01c9\7t\2\2\u01c9\u0092\3\2\2\2\u01ca\u01cb\7y\2\2\u01cb\u01cc\7j\2"+
		"\2\u01cc\u01cd\7k\2\2\u01cd\u01ce\7n\2\2\u01ce\u01cf\7g\2\2\u01cf\u0094"+
		"\3\2\2\2\u01d0\u01d1\7t\2\2\u01d1\u01d2\7g\2\2\u01d2\u01d3\7v\2\2\u01d3"+
		"\u01d4\7w\2\2\u01d4\u01d5\7t\2\2\u01d5\u01d6\7p\2\2\u01d6\u0096\3\2\2"+
		"\2\u01d7\u01d8\7f\2\2\u01d8\u01d9\7q\2\2\u01d9\u0098\3\2\2\2\u01da\u01db"+
		"\7r\2\2\u01db\u01dc\7t\2\2\u01dc\u01dd\7k\2\2\u01dd\u01de\7q\2\2\u01de"+
		"\u01df\7t\2\2\u01df\u01e0\7k\2\2\u01e0\u01e1\7v\2\2\u01e1\u01e2\7{\2\2"+
		"\u01e2\u009a\3\2\2\2\u01e3\u01e4\7f\2\2\u01e4\u01e5\7g\2\2\u01e5\u01e6"+
		"\7h\2\2\u01e6\u01e7\7c\2\2\u01e7\u01e8\7w\2\2\u01e8\u01e9\7n\2\2\u01e9"+
		"\u01ea\7v\2\2\u01ea\u009c\3\2\2\2\u01eb\u01ec\7u\2\2\u01ec\u01ed\7{\2"+
		"\2\u01ed\u01ee\7u\2\2\u01ee\u01ef\7v\2\2\u01ef\u01f0\7g\2\2\u01f0\u01f1"+
		"\7o\2\2\u01f1\u009e\3\2\2\2\u01f2\u01f3\7r\2\2\u01f3\u01f4\7t\2\2\u01f4"+
		"\u01f5\7q\2\2\u01f5\u01f6\7i\2\2\u01f6\u01f7\7t\2\2\u01f7\u01f8\7g\2\2"+
		"\u01f8\u01f9\7u\2\2\u01f9\u01fa\7u\2\2\u01fa\u00a0\3\2\2\2\u01fb\u01ff"+
		"\t\4\2\2\u01fc\u01fe\t\5\2\2\u01fd\u01fc\3\2\2\2\u01fe\u0201\3\2\2\2\u01ff"+
		"\u01fd\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u00a2\3\2\2\2\u0201\u01ff\3\2"+
		"\2\2\u0202\u0204\t\6\2\2\u0203\u0202\3\2\2\2\u0204\u0205\3\2\2\2\u0205"+
		"\u0203\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u00a4\3\2\2\2\u0207\u0208\7?"+
		"\2\2\u0208\u00a6\3\2\2\2\u0209\u020a\7<\2\2\u020a\u020b\7?\2\2\u020b\u00a8"+
		"\3\2\2\2\n\2\u00af\u00b3\u00bd\u00c8\u0120\u01ff\u0205\4\2\4\2\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}