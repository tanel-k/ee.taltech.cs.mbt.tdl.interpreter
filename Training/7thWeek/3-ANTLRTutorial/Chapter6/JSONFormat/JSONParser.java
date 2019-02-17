// Generated from JSON.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JSONParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, LCURL=3, RCURL=4, LSQUARE=5, RSQUARE=6, NAME_VALUE_SEP=7, 
		SEQ_SEP=8, BOOL_TRUE=9, BOOL_FALSE=10, VALUE_NULL=11, NUMBER=12, STRING=13, 
		WS=14;
	public static final int
		RULE_json = 0, RULE_object = 1, RULE_nameValue = 2, RULE_array = 3, RULE_value = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"json", "object", "nameValue", "array", "value"
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

	@Override
	public String getGrammarFileName() { return "JSON.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JSONParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class JsonContext extends ParserRuleContext {
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public JsonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_json; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).enterJson(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).exitJson(this);
		}
	}

	public final JsonContext json() throws RecognitionException {
		JsonContext _localctx = new JsonContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_json);
		try {
			setState(12);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LCURL:
				enterOuterAlt(_localctx, 1);
				{
				setState(10);
				object();
				}
				break;
			case LSQUARE:
				enterOuterAlt(_localctx, 2);
				{
				setState(11);
				array();
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

	public static class ObjectContext extends ParserRuleContext {
		public TerminalNode LCURL() { return getToken(JSONParser.LCURL, 0); }
		public List<NameValueContext> nameValue() {
			return getRuleContexts(NameValueContext.class);
		}
		public NameValueContext nameValue(int i) {
			return getRuleContext(NameValueContext.class,i);
		}
		public TerminalNode RCURL() { return getToken(JSONParser.RCURL, 0); }
		public List<TerminalNode> SEQ_SEP() { return getTokens(JSONParser.SEQ_SEP); }
		public TerminalNode SEQ_SEP(int i) {
			return getToken(JSONParser.SEQ_SEP, i);
		}
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).exitObject(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_object);
		int _la;
		try {
			setState(27);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				match(LCURL);
				setState(15);
				nameValue();
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEQ_SEP) {
					{
					{
					setState(16);
					match(SEQ_SEP);
					setState(17);
					nameValue();
					}
					}
					setState(22);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(23);
				match(RCURL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				match(LCURL);
				setState(26);
				match(RCURL);
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

	public static class NameValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(JSONParser.STRING, 0); }
		public TerminalNode NAME_VALUE_SEP() { return getToken(JSONParser.NAME_VALUE_SEP, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public NameValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).enterNameValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).exitNameValue(this);
		}
	}

	public final NameValueContext nameValue() throws RecognitionException {
		NameValueContext _localctx = new NameValueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nameValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(STRING);
			setState(30);
			match(NAME_VALUE_SEP);
			setState(31);
			value();
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

	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode LSQUARE() { return getToken(JSONParser.LSQUARE, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode RSQUARE() { return getToken(JSONParser.RSQUARE, 0); }
		public List<TerminalNode> SEQ_SEP() { return getTokens(JSONParser.SEQ_SEP); }
		public TerminalNode SEQ_SEP(int i) {
			return getToken(JSONParser.SEQ_SEP, i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).exitArray(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_array);
		int _la;
		try {
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				match(LSQUARE);
				setState(34);
				value();
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEQ_SEP) {
					{
					{
					setState(35);
					match(SEQ_SEP);
					setState(36);
					value();
					}
					}
					setState(41);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(42);
				match(RSQUARE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				match(LSQUARE);
				setState(45);
				match(RSQUARE);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(JSONParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(JSONParser.NUMBER, 0); }
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TerminalNode BOOL_TRUE() { return getToken(JSONParser.BOOL_TRUE, 0); }
		public TerminalNode BOOL_FALSE() { return getToken(JSONParser.BOOL_FALSE, 0); }
		public TerminalNode VALUE_NULL() { return getToken(JSONParser.VALUE_NULL, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSONListener ) ((JSONListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_value);
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				match(STRING);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				match(NUMBER);
				}
				break;
			case LCURL:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				object();
				}
				break;
			case LSQUARE:
				enterOuterAlt(_localctx, 4);
				{
				setState(51);
				array();
				}
				break;
			case BOOL_TRUE:
				enterOuterAlt(_localctx, 5);
				{
				setState(52);
				match(BOOL_TRUE);
				}
				break;
			case BOOL_FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(53);
				match(BOOL_FALSE);
				}
				break;
			case VALUE_NULL:
				enterOuterAlt(_localctx, 7);
				{
				setState(54);
				match(VALUE_NULL);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20<\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\5\2\17\n\2\3\3\3\3\3\3\3\3\7\3\25\n"+
		"\3\f\3\16\3\30\13\3\3\3\3\3\3\3\3\3\5\3\36\n\3\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\7\5(\n\5\f\5\16\5+\13\5\3\5\3\5\3\5\3\5\5\5\61\n\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\5\6:\n\6\3\6\2\2\7\2\4\6\b\n\2\2\2A\2\16\3\2\2\2\4"+
		"\35\3\2\2\2\6\37\3\2\2\2\b\60\3\2\2\2\n9\3\2\2\2\f\17\5\4\3\2\r\17\5\b"+
		"\5\2\16\f\3\2\2\2\16\r\3\2\2\2\17\3\3\2\2\2\20\21\7\5\2\2\21\26\5\6\4"+
		"\2\22\23\7\n\2\2\23\25\5\6\4\2\24\22\3\2\2\2\25\30\3\2\2\2\26\24\3\2\2"+
		"\2\26\27\3\2\2\2\27\31\3\2\2\2\30\26\3\2\2\2\31\32\7\6\2\2\32\36\3\2\2"+
		"\2\33\34\7\5\2\2\34\36\7\6\2\2\35\20\3\2\2\2\35\33\3\2\2\2\36\5\3\2\2"+
		"\2\37 \7\17\2\2 !\7\t\2\2!\"\5\n\6\2\"\7\3\2\2\2#$\7\7\2\2$)\5\n\6\2%"+
		"&\7\n\2\2&(\5\n\6\2\'%\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2"+
		"\2+)\3\2\2\2,-\7\b\2\2-\61\3\2\2\2./\7\7\2\2/\61\7\b\2\2\60#\3\2\2\2\60"+
		".\3\2\2\2\61\t\3\2\2\2\62:\7\17\2\2\63:\7\16\2\2\64:\5\4\3\2\65:\5\b\5"+
		"\2\66:\7\13\2\2\67:\7\f\2\28:\7\r\2\29\62\3\2\2\29\63\3\2\2\29\64\3\2"+
		"\2\29\65\3\2\2\29\66\3\2\2\29\67\3\2\2\298\3\2\2\2:\13\3\2\2\2\b\16\26"+
		"\35)\609";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}