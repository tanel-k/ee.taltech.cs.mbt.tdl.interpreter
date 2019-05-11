// Generated from SExpressionLanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_grammar.antlr_parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SExpressionLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DELIMITED_STRING=1, NON_DELIMITED_STRING=2, SEQ_SEP=3, LPAREN=4, RPAREN=5, 
		ALPHANUMERIC=6, SPECIAL=7, ESCAPED_RESERVED_TOK=8, WS=9;
	public static final int
		RULE_sexpr = 0, RULE_sequence = 1, RULE_item = 2, RULE_string = 3;
	public static final String[] ruleNames = {
		"sexpr", "sequence", "item", "string"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'.'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "DELIMITED_STRING", "NON_DELIMITED_STRING", "SEQ_SEP", "LPAREN", 
		"RPAREN", "ALPHANUMERIC", "SPECIAL", "ESCAPED_RESERVED_TOK", "WS"
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

	@Override
	public String getGrammarFileName() { return "SExpressionLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SExpressionLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SexprContext extends ParserRuleContext {
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public SexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SExpressionLanguageListener ) ((SExpressionLanguageListener)listener).enterSexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SExpressionLanguageListener ) ((SExpressionLanguageListener)listener).exitSexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SExpressionLanguageVisitor ) return ((SExpressionLanguageVisitor<? extends T>)visitor).visitSexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SexprContext sexpr() throws RecognitionException {
		SexprContext _localctx = new SexprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			sequence();
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

	public static class SequenceContext extends ParserRuleContext {
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
	 
		public SequenceContext() { }
		public void copyFrom(SequenceContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EmptySequenceContext extends SequenceContext {
		public TerminalNode LPAREN() { return getToken(SExpressionLanguageParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SExpressionLanguageParser.RPAREN, 0); }
		public EmptySequenceContext(SequenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SExpressionLanguageListener ) ((SExpressionLanguageListener)listener).enterEmptySequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SExpressionLanguageListener ) ((SExpressionLanguageListener)listener).exitEmptySequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SExpressionLanguageVisitor ) return ((SExpressionLanguageVisitor<? extends T>)visitor).visitEmptySequence(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NonEmptySequenceContext extends SequenceContext {
		public TerminalNode LPAREN() { return getToken(SExpressionLanguageParser.LPAREN, 0); }
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(SExpressionLanguageParser.RPAREN, 0); }
		public List<TerminalNode> SEQ_SEP() { return getTokens(SExpressionLanguageParser.SEQ_SEP); }
		public TerminalNode SEQ_SEP(int i) {
			return getToken(SExpressionLanguageParser.SEQ_SEP, i);
		}
		public NonEmptySequenceContext(SequenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SExpressionLanguageListener ) ((SExpressionLanguageListener)listener).enterNonEmptySequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SExpressionLanguageListener ) ((SExpressionLanguageListener)listener).exitNonEmptySequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SExpressionLanguageVisitor ) return ((SExpressionLanguageVisitor<? extends T>)visitor).visitNonEmptySequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sequence);
		int _la;
		try {
			setState(23);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new NonEmptySequenceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(10);
				match(LPAREN);
				setState(11);
				item();
				setState(16);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEQ_SEP) {
					{
					{
					setState(12);
					match(SEQ_SEP);
					setState(13);
					item();
					}
					}
					setState(18);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(19);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new EmptySequenceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				match(LPAREN);
				setState(22);
				match(RPAREN);
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

	public static class ItemContext extends ParserRuleContext {
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
	 
		public ItemContext() { }
		public void copyFrom(ItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringItemContext extends ItemContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public StringItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SExpressionLanguageListener ) ((SExpressionLanguageListener)listener).enterStringItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SExpressionLanguageListener ) ((SExpressionLanguageListener)listener).exitStringItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SExpressionLanguageVisitor ) return ((SExpressionLanguageVisitor<? extends T>)visitor).visitStringItem(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SequenceItemContext extends ItemContext {
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public SequenceItemContext(ItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SExpressionLanguageListener ) ((SExpressionLanguageListener)listener).enterSequenceItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SExpressionLanguageListener ) ((SExpressionLanguageListener)listener).exitSequenceItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SExpressionLanguageVisitor ) return ((SExpressionLanguageVisitor<? extends T>)visitor).visitSequenceItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_item);
		try {
			setState(27);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new SequenceItemContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				sequence();
				}
				break;
			case DELIMITED_STRING:
			case NON_DELIMITED_STRING:
				_localctx = new StringItemContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(26);
				string();
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

	public static class StringContext extends ParserRuleContext {
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
	 
		public StringContext() { }
		public void copyFrom(StringContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DelimitedStringContext extends StringContext {
		public TerminalNode DELIMITED_STRING() { return getToken(SExpressionLanguageParser.DELIMITED_STRING, 0); }
		public DelimitedStringContext(StringContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SExpressionLanguageListener ) ((SExpressionLanguageListener)listener).enterDelimitedString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SExpressionLanguageListener ) ((SExpressionLanguageListener)listener).exitDelimitedString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SExpressionLanguageVisitor ) return ((SExpressionLanguageVisitor<? extends T>)visitor).visitDelimitedString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NonDelimitedStringContext extends StringContext {
		public TerminalNode NON_DELIMITED_STRING() { return getToken(SExpressionLanguageParser.NON_DELIMITED_STRING, 0); }
		public NonDelimitedStringContext(StringContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SExpressionLanguageListener ) ((SExpressionLanguageListener)listener).enterNonDelimitedString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SExpressionLanguageListener ) ((SExpressionLanguageListener)listener).exitNonDelimitedString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SExpressionLanguageVisitor ) return ((SExpressionLanguageVisitor<? extends T>)visitor).visitNonDelimitedString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_string);
		try {
			setState(31);
			switch (_input.LA(1)) {
			case DELIMITED_STRING:
				_localctx = new DelimitedStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				match(DELIMITED_STRING);
				}
				break;
			case NON_DELIMITED_STRING:
				_localctx = new NonDelimitedStringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				match(NON_DELIMITED_STRING);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13$\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\3\3\3\3\3\3\3\7\3\21\n\3\f\3\16\3\24\13\3"+
		"\3\3\3\3\3\3\3\3\5\3\32\n\3\3\4\3\4\5\4\36\n\4\3\5\3\5\5\5\"\n\5\3\5\2"+
		"\2\6\2\4\6\b\2\2#\2\n\3\2\2\2\4\31\3\2\2\2\6\35\3\2\2\2\b!\3\2\2\2\n\13"+
		"\5\4\3\2\13\3\3\2\2\2\f\r\7\6\2\2\r\22\5\6\4\2\16\17\7\5\2\2\17\21\5\6"+
		"\4\2\20\16\3\2\2\2\21\24\3\2\2\2\22\20\3\2\2\2\22\23\3\2\2\2\23\25\3\2"+
		"\2\2\24\22\3\2\2\2\25\26\7\7\2\2\26\32\3\2\2\2\27\30\7\6\2\2\30\32\7\7"+
		"\2\2\31\f\3\2\2\2\31\27\3\2\2\2\32\5\3\2\2\2\33\36\5\4\3\2\34\36\5\b\5"+
		"\2\35\33\3\2\2\2\35\34\3\2\2\2\36\7\3\2\2\2\37\"\7\3\2\2 \"\7\4\2\2!\37"+
		"\3\2\2\2! \3\2\2\2\"\t\3\2\2\2\6\22\31\35!";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}