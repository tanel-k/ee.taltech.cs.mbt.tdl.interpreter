// Generated from UtaLanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class UtaLanguageParser extends Parser {
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
	public static final int
		RULE_synchronization = 0, RULE_selectionSequence = 1, RULE_selection = 2, 
		RULE_systemDefinition = 3, RULE_systemLine = 4, RULE_systemProcessSequence = 5, 
		RULE_systemProcessGroup = 6, RULE_progressMeasureDeclaration = 7, RULE_declarationSequence = 8, 
		RULE_declaration = 9, RULE_channelPrioritySequence = 10, RULE_channelPriorityGroup = 11, 
		RULE_channelReference = 12, RULE_variableInitialization = 13, RULE_initializerExpression = 14, 
		RULE_declarationOfFunction = 15, RULE_statementBlock = 16, RULE_statementSequence = 17, 
		RULE_statement = 18, RULE_expressionSequence = 19, RULE_expression = 20, 
		RULE_parameterSequence = 21, RULE_parameter = 22, RULE_argumentSequence = 23, 
		RULE_type = 24, RULE_typeIdentifier = 25, RULE_arrayVariableLookup = 26, 
		RULE_fieldDeclaration = 27, RULE_identifierDeclaration = 28, RULE_arraySizeModifier = 29, 
		RULE_typePrefix = 30;
	public static final String[] ruleNames = {
		"synchronization", "selectionSequence", "selection", "systemDefinition", 
		"systemLine", "systemProcessSequence", "systemProcessGroup", "progressMeasureDeclaration", 
		"declarationSequence", "declaration", "channelPrioritySequence", "channelPriorityGroup", 
		"channelReference", "variableInitialization", "initializerExpression", 
		"declarationOfFunction", "statementBlock", "statementSequence", "statement", 
		"expressionSequence", "expression", "parameterSequence", "parameter", 
		"argumentSequence", "type", "typeIdentifier", "arrayVariableLookup", "fieldDeclaration", 
		"identifierDeclaration", "arraySizeModifier", "typePrefix"
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

	@Override
	public String getGrammarFileName() { return "UtaLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public UtaLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SynchronizationContext extends ParserRuleContext {
		public SynchronizationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synchronization; }
	 
		public SynchronizationContext() { }
		public void copyFrom(SynchronizationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ActiveSynchronizationContext extends SynchronizationContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMON_TOK_EXCLAMATION_MARK() { return getToken(UtaLanguageParser.COMMON_TOK_EXCLAMATION_MARK, 0); }
		public ActiveSynchronizationContext(SynchronizationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterActiveSynchronization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitActiveSynchronization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitActiveSynchronization(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReactiveSynchronizationContext extends SynchronizationContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMON_TOK_QUESTION_MARK() { return getToken(UtaLanguageParser.COMMON_TOK_QUESTION_MARK, 0); }
		public ReactiveSynchronizationContext(SynchronizationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterReactiveSynchronization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitReactiveSynchronization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitReactiveSynchronization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SynchronizationContext synchronization() throws RecognitionException {
		SynchronizationContext _localctx = new SynchronizationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_synchronization);
		try {
			setState(68);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new ActiveSynchronizationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				expression(0);
				setState(63);
				match(COMMON_TOK_EXCLAMATION_MARK);
				}
				break;
			case 2:
				_localctx = new ReactiveSynchronizationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				expression(0);
				setState(66);
				match(COMMON_TOK_QUESTION_MARK);
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

	public static class SelectionSequenceContext extends ParserRuleContext {
		public List<SelectionContext> selection() {
			return getRuleContexts(SelectionContext.class);
		}
		public SelectionContext selection(int i) {
			return getRuleContext(SelectionContext.class,i);
		}
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UtaLanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UtaLanguageParser.SEP_ENUMERATION, i);
		}
		public SelectionSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterSelectionSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitSelectionSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitSelectionSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionSequenceContext selectionSequence() throws RecognitionException {
		SelectionSequenceContext _localctx = new SelectionSequenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_selectionSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			selection();
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(71);
				match(SEP_ENUMERATION);
				setState(72);
				selection();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class SelectionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER_NAME() { return getToken(UtaLanguageParser.IDENTIFIER_NAME, 0); }
		public TerminalNode COMMON_TOK_COLON() { return getToken(UtaLanguageParser.COMMON_TOK_COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitSelection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_selection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(IDENTIFIER_NAME);
			setState(79);
			match(COMMON_TOK_COLON);
			setState(80);
			type();
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

	public static class SystemDefinitionContext extends ParserRuleContext {
		public DeclarationSequenceContext declarationSequence() {
			return getRuleContext(DeclarationSequenceContext.class,0);
		}
		public SystemLineContext systemLine() {
			return getRuleContext(SystemLineContext.class,0);
		}
		public ProgressMeasureDeclarationContext progressMeasureDeclaration() {
			return getRuleContext(ProgressMeasureDeclarationContext.class,0);
		}
		public SystemDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_systemDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterSystemDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitSystemDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitSystemDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SystemDefinitionContext systemDefinition() throws RecognitionException {
		SystemDefinitionContext _localctx = new SystemDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_systemDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INTEGER) | (1L << TYPE_CLOCK) | (1L << TYPE_CHANNEL) | (1L << TYPE_BOOLEAN) | (1L << TYPE_SCALAR) | (1L << TYPE_STRUCT) | (1L << TYPE_PREFIX_URGENT) | (1L << TYPE_PREFIX_BROADCAST) | (1L << TYPE_PREFIX_META) | (1L << TYPE_PREFIX_CONST) | (1L << PHRASE_VOID))) != 0) || _la==PHRASE_TYPEDEF || _la==IDENTIFIER_NAME) {
				{
				setState(82);
				declarationSequence();
				}
			}

			setState(86);
			_la = _input.LA(1);
			if (_la==PHRASE_SYSTEM) {
				{
				setState(85);
				systemLine();
				}
			}

			setState(89);
			_la = _input.LA(1);
			if (_la==PHRASE_PROGRESS) {
				{
				setState(88);
				progressMeasureDeclaration();
				}
			}

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

	public static class SystemLineContext extends ParserRuleContext {
		public TerminalNode PHRASE_SYSTEM() { return getToken(UtaLanguageParser.PHRASE_SYSTEM, 0); }
		public SystemProcessSequenceContext systemProcessSequence() {
			return getRuleContext(SystemProcessSequenceContext.class,0);
		}
		public TerminalNode SEP_SEMICOLON() { return getToken(UtaLanguageParser.SEP_SEMICOLON, 0); }
		public SystemLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_systemLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterSystemLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitSystemLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitSystemLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SystemLineContext systemLine() throws RecognitionException {
		SystemLineContext _localctx = new SystemLineContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_systemLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(PHRASE_SYSTEM);
			setState(92);
			systemProcessSequence();
			setState(93);
			match(SEP_SEMICOLON);
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

	public static class SystemProcessSequenceContext extends ParserRuleContext {
		public List<SystemProcessGroupContext> systemProcessGroup() {
			return getRuleContexts(SystemProcessGroupContext.class);
		}
		public SystemProcessGroupContext systemProcessGroup(int i) {
			return getRuleContext(SystemProcessGroupContext.class,i);
		}
		public List<TerminalNode> COMMON_TOK_LESS_THAN() { return getTokens(UtaLanguageParser.COMMON_TOK_LESS_THAN); }
		public TerminalNode COMMON_TOK_LESS_THAN(int i) {
			return getToken(UtaLanguageParser.COMMON_TOK_LESS_THAN, i);
		}
		public SystemProcessSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_systemProcessSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterSystemProcessSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitSystemProcessSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitSystemProcessSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SystemProcessSequenceContext systemProcessSequence() throws RecognitionException {
		SystemProcessSequenceContext _localctx = new SystemProcessSequenceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_systemProcessSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			systemProcessGroup();
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMON_TOK_LESS_THAN) {
				{
				{
				setState(96);
				match(COMMON_TOK_LESS_THAN);
				setState(97);
				systemProcessGroup();
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class SystemProcessGroupContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER_NAME() { return getTokens(UtaLanguageParser.IDENTIFIER_NAME); }
		public TerminalNode IDENTIFIER_NAME(int i) {
			return getToken(UtaLanguageParser.IDENTIFIER_NAME, i);
		}
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UtaLanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UtaLanguageParser.SEP_ENUMERATION, i);
		}
		public SystemProcessGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_systemProcessGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterSystemProcessGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitSystemProcessGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitSystemProcessGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SystemProcessGroupContext systemProcessGroup() throws RecognitionException {
		SystemProcessGroupContext _localctx = new SystemProcessGroupContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_systemProcessGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(IDENTIFIER_NAME);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(104);
				match(SEP_ENUMERATION);
				setState(105);
				match(IDENTIFIER_NAME);
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class ProgressMeasureDeclarationContext extends ParserRuleContext {
		public TerminalNode PHRASE_PROGRESS() { return getToken(UtaLanguageParser.PHRASE_PROGRESS, 0); }
		public TerminalNode GROUP_LEFT_CURLY() { return getToken(UtaLanguageParser.GROUP_LEFT_CURLY, 0); }
		public TerminalNode GROUP_RIGHT_CURLY() { return getToken(UtaLanguageParser.GROUP_RIGHT_CURLY, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SEP_SEMICOLON() { return getTokens(UtaLanguageParser.SEP_SEMICOLON); }
		public TerminalNode SEP_SEMICOLON(int i) {
			return getToken(UtaLanguageParser.SEP_SEMICOLON, i);
		}
		public ProgressMeasureDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_progressMeasureDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterProgressMeasureDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitProgressMeasureDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitProgressMeasureDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgressMeasureDeclarationContext progressMeasureDeclaration() throws RecognitionException {
		ProgressMeasureDeclarationContext _localctx = new ProgressMeasureDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_progressMeasureDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(PHRASE_PROGRESS);
			setState(112);
			match(GROUP_LEFT_CURLY);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPR_LITERAL_TRUE) | (1L << EXPR_LITERAL_FALSE) | (1L << EXPR_LITERAL_DEADLOCK) | (1L << UNARY_OP_INCREMENT) | (1L << UNARY_OP_DECREMENT) | (1L << COMMON_TOK_PLUS) | (1L << COMMON_TOK_MINUS) | (1L << COMMON_TOK_EXCLAMATION_MARK) | (1L << GROUP_LEFT_PAREN) | (1L << PHRASE_NOT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (PHRASE_FOR_ALL - 67)) | (1L << (PHRASE_EXISTS - 67)) | (1L << (IDENTIFIER_NAME - 67)) | (1L << (NATURAL_NUMBER - 67)))) != 0)) {
				{
				{
				setState(113);
				expression(0);
				setState(114);
				match(SEP_SEMICOLON);
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
			match(GROUP_RIGHT_CURLY);
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

	public static class DeclarationSequenceContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclarationSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterDeclarationSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitDeclarationSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitDeclarationSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationSequenceContext declarationSequence() throws RecognitionException {
		DeclarationSequenceContext _localctx = new DeclarationSequenceContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declarationSequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(124); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(123);
					declaration();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(126); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionDeclarationContext extends DeclarationContext {
		public DeclarationOfFunctionContext declarationOfFunction() {
			return getRuleContext(DeclarationOfFunctionContext.class,0);
		}
		public FunctionDeclarationContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ChannelPriorityDeclarationContext extends DeclarationContext {
		public TerminalNode TYPE_CHANNEL() { return getToken(UtaLanguageParser.TYPE_CHANNEL, 0); }
		public TerminalNode PHRASE_PRIORITY() { return getToken(UtaLanguageParser.PHRASE_PRIORITY, 0); }
		public ChannelPrioritySequenceContext channelPrioritySequence() {
			return getRuleContext(ChannelPrioritySequenceContext.class,0);
		}
		public TerminalNode SEP_SEMICOLON() { return getToken(UtaLanguageParser.SEP_SEMICOLON, 0); }
		public ChannelPriorityDeclarationContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterChannelPriorityDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitChannelPriorityDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitChannelPriorityDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TemplateInstantiationContext extends DeclarationContext {
		public List<TerminalNode> IDENTIFIER_NAME() { return getTokens(UtaLanguageParser.IDENTIFIER_NAME); }
		public TerminalNode IDENTIFIER_NAME(int i) {
			return getToken(UtaLanguageParser.IDENTIFIER_NAME, i);
		}
		public TerminalNode ASSG_OP() { return getToken(UtaLanguageParser.ASSG_OP, 0); }
		public List<TerminalNode> GROUP_LEFT_PAREN() { return getTokens(UtaLanguageParser.GROUP_LEFT_PAREN); }
		public TerminalNode GROUP_LEFT_PAREN(int i) {
			return getToken(UtaLanguageParser.GROUP_LEFT_PAREN, i);
		}
		public List<TerminalNode> GROUP_RIGHT_PAREN() { return getTokens(UtaLanguageParser.GROUP_RIGHT_PAREN); }
		public TerminalNode GROUP_RIGHT_PAREN(int i) {
			return getToken(UtaLanguageParser.GROUP_RIGHT_PAREN, i);
		}
		public TerminalNode SEP_SEMICOLON() { return getToken(UtaLanguageParser.SEP_SEMICOLON, 0); }
		public ArgumentSequenceContext argumentSequence() {
			return getRuleContext(ArgumentSequenceContext.class,0);
		}
		public ParameterSequenceContext parameterSequence() {
			return getRuleContext(ParameterSequenceContext.class,0);
		}
		public TemplateInstantiationContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterTemplateInstantiation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitTemplateInstantiation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitTemplateInstantiation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableDeclarationContext extends DeclarationContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<VariableInitializationContext> variableInitialization() {
			return getRuleContexts(VariableInitializationContext.class);
		}
		public VariableInitializationContext variableInitialization(int i) {
			return getRuleContext(VariableInitializationContext.class,i);
		}
		public TerminalNode SEP_SEMICOLON() { return getToken(UtaLanguageParser.SEP_SEMICOLON, 0); }
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UtaLanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UtaLanguageParser.SEP_ENUMERATION, i);
		}
		public VariableDeclarationContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeDeclarationContext extends DeclarationContext {
		public TerminalNode PHRASE_TYPEDEF() { return getToken(UtaLanguageParser.PHRASE_TYPEDEF, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<IdentifierDeclarationContext> identifierDeclaration() {
			return getRuleContexts(IdentifierDeclarationContext.class);
		}
		public IdentifierDeclarationContext identifierDeclaration(int i) {
			return getRuleContext(IdentifierDeclarationContext.class,i);
		}
		public TerminalNode SEP_SEMICOLON() { return getToken(UtaLanguageParser.SEP_SEMICOLON, 0); }
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UtaLanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UtaLanguageParser.SEP_ENUMERATION, i);
		}
		public TypeDeclarationContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitTypeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitTypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_declaration);
		int _la;
		try {
			setState(173);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new VariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				type();
				setState(129);
				variableInitialization();
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP_ENUMERATION) {
					{
					{
					setState(130);
					match(SEP_ENUMERATION);
					setState(131);
					variableInitialization();
					}
					}
					setState(136);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(137);
				match(SEP_SEMICOLON);
				}
				break;
			case 2:
				_localctx = new TypeDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				match(PHRASE_TYPEDEF);
				setState(140);
				type();
				setState(141);
				identifierDeclaration();
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP_ENUMERATION) {
					{
					{
					setState(142);
					match(SEP_ENUMERATION);
					setState(143);
					identifierDeclaration();
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(149);
				match(SEP_SEMICOLON);
				}
				break;
			case 3:
				_localctx = new FunctionDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				declarationOfFunction();
				}
				break;
			case 4:
				_localctx = new ChannelPriorityDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(152);
				match(TYPE_CHANNEL);
				setState(153);
				match(PHRASE_PRIORITY);
				setState(154);
				channelPrioritySequence();
				setState(155);
				match(SEP_SEMICOLON);
				}
				break;
			case 5:
				_localctx = new TemplateInstantiationContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(157);
				match(IDENTIFIER_NAME);
				setState(163);
				_la = _input.LA(1);
				if (_la==GROUP_LEFT_PAREN) {
					{
					setState(158);
					match(GROUP_LEFT_PAREN);
					setState(160);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INTEGER) | (1L << TYPE_CLOCK) | (1L << TYPE_CHANNEL) | (1L << TYPE_BOOLEAN) | (1L << TYPE_SCALAR) | (1L << TYPE_STRUCT) | (1L << TYPE_PREFIX_URGENT) | (1L << TYPE_PREFIX_BROADCAST) | (1L << TYPE_PREFIX_META) | (1L << TYPE_PREFIX_CONST))) != 0) || _la==IDENTIFIER_NAME) {
						{
						setState(159);
						parameterSequence();
						}
					}

					setState(162);
					match(GROUP_RIGHT_PAREN);
					}
				}

				setState(165);
				match(ASSG_OP);
				setState(166);
				match(IDENTIFIER_NAME);
				setState(167);
				match(GROUP_LEFT_PAREN);
				setState(169);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPR_LITERAL_TRUE) | (1L << EXPR_LITERAL_FALSE) | (1L << EXPR_LITERAL_DEADLOCK) | (1L << UNARY_OP_INCREMENT) | (1L << UNARY_OP_DECREMENT) | (1L << COMMON_TOK_PLUS) | (1L << COMMON_TOK_MINUS) | (1L << COMMON_TOK_EXCLAMATION_MARK) | (1L << GROUP_LEFT_PAREN) | (1L << PHRASE_NOT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (PHRASE_FOR_ALL - 67)) | (1L << (PHRASE_EXISTS - 67)) | (1L << (IDENTIFIER_NAME - 67)) | (1L << (NATURAL_NUMBER - 67)))) != 0)) {
					{
					setState(168);
					argumentSequence();
					}
				}

				setState(171);
				match(GROUP_RIGHT_PAREN);
				setState(172);
				match(SEP_SEMICOLON);
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

	public static class ChannelPrioritySequenceContext extends ParserRuleContext {
		public List<ChannelPriorityGroupContext> channelPriorityGroup() {
			return getRuleContexts(ChannelPriorityGroupContext.class);
		}
		public ChannelPriorityGroupContext channelPriorityGroup(int i) {
			return getRuleContext(ChannelPriorityGroupContext.class,i);
		}
		public List<TerminalNode> COMMON_TOK_LESS_THAN() { return getTokens(UtaLanguageParser.COMMON_TOK_LESS_THAN); }
		public TerminalNode COMMON_TOK_LESS_THAN(int i) {
			return getToken(UtaLanguageParser.COMMON_TOK_LESS_THAN, i);
		}
		public ChannelPrioritySequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_channelPrioritySequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterChannelPrioritySequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitChannelPrioritySequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitChannelPrioritySequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChannelPrioritySequenceContext channelPrioritySequence() throws RecognitionException {
		ChannelPrioritySequenceContext _localctx = new ChannelPrioritySequenceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_channelPrioritySequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			channelPriorityGroup();
			setState(178); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(176);
				match(COMMON_TOK_LESS_THAN);
				setState(177);
				channelPriorityGroup();
				}
				}
				setState(180); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMON_TOK_LESS_THAN );
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

	public static class ChannelPriorityGroupContext extends ParserRuleContext {
		public List<ChannelReferenceContext> channelReference() {
			return getRuleContexts(ChannelReferenceContext.class);
		}
		public ChannelReferenceContext channelReference(int i) {
			return getRuleContext(ChannelReferenceContext.class,i);
		}
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UtaLanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UtaLanguageParser.SEP_ENUMERATION, i);
		}
		public ChannelPriorityGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_channelPriorityGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterChannelPriorityGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitChannelPriorityGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitChannelPriorityGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChannelPriorityGroupContext channelPriorityGroup() throws RecognitionException {
		ChannelPriorityGroupContext _localctx = new ChannelPriorityGroupContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_channelPriorityGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			channelReference();
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(183);
				match(SEP_ENUMERATION);
				setState(184);
				channelReference();
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class ChannelReferenceContext extends ParserRuleContext {
		public ChannelReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_channelReference; }
	 
		public ChannelReferenceContext() { }
		public void copyFrom(ChannelReferenceContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ChannelArrayLookupContext extends ChannelReferenceContext {
		public ArrayVariableLookupContext arrayVariableLookup() {
			return getRuleContext(ArrayVariableLookupContext.class,0);
		}
		public ChannelArrayLookupContext(ChannelReferenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterChannelArrayLookup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitChannelArrayLookup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitChannelArrayLookup(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ChannelIdentifierRefrenceContext extends ChannelReferenceContext {
		public TerminalNode IDENTIFIER_NAME() { return getToken(UtaLanguageParser.IDENTIFIER_NAME, 0); }
		public ChannelIdentifierRefrenceContext(ChannelReferenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterChannelIdentifierRefrence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitChannelIdentifierRefrence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitChannelIdentifierRefrence(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefaultChannelReferenceContext extends ChannelReferenceContext {
		public TerminalNode PHRASE_DEFAULT() { return getToken(UtaLanguageParser.PHRASE_DEFAULT, 0); }
		public DefaultChannelReferenceContext(ChannelReferenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterDefaultChannelReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitDefaultChannelReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitDefaultChannelReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChannelReferenceContext channelReference() throws RecognitionException {
		ChannelReferenceContext _localctx = new ChannelReferenceContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_channelReference);
		try {
			setState(193);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new DefaultChannelReferenceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				match(PHRASE_DEFAULT);
				}
				break;
			case 2:
				_localctx = new ChannelArrayLookupContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				arrayVariableLookup();
				}
				break;
			case 3:
				_localctx = new ChannelIdentifierRefrenceContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				match(IDENTIFIER_NAME);
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

	public static class VariableInitializationContext extends ParserRuleContext {
		public IdentifierDeclarationContext identifierDeclaration() {
			return getRuleContext(IdentifierDeclarationContext.class,0);
		}
		public TerminalNode ASSG_OP() { return getToken(UtaLanguageParser.ASSG_OP, 0); }
		public InitializerExpressionContext initializerExpression() {
			return getRuleContext(InitializerExpressionContext.class,0);
		}
		public VariableInitializationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitialization; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterVariableInitialization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitVariableInitialization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitVariableInitialization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableInitializationContext variableInitialization() throws RecognitionException {
		VariableInitializationContext _localctx = new VariableInitializationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variableInitialization);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			identifierDeclaration();
			setState(198);
			_la = _input.LA(1);
			if (_la==ASSG_OP) {
				{
				setState(196);
				match(ASSG_OP);
				setState(197);
				initializerExpression();
				}
			}

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

	public static class InitializerExpressionContext extends ParserRuleContext {
		public InitializerExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerExpression; }
	 
		public InitializerExpressionContext() { }
		public void copyFrom(InitializerExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FlatInitializerContext extends InitializerExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FlatInitializerContext(InitializerExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterFlatInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitFlatInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitFlatInitializer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructuredInitializerContext extends InitializerExpressionContext {
		public TerminalNode GROUP_LEFT_CURLY() { return getToken(UtaLanguageParser.GROUP_LEFT_CURLY, 0); }
		public List<InitializerExpressionContext> initializerExpression() {
			return getRuleContexts(InitializerExpressionContext.class);
		}
		public InitializerExpressionContext initializerExpression(int i) {
			return getRuleContext(InitializerExpressionContext.class,i);
		}
		public TerminalNode GROUP_RIGHT_CURLY() { return getToken(UtaLanguageParser.GROUP_RIGHT_CURLY, 0); }
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UtaLanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UtaLanguageParser.SEP_ENUMERATION, i);
		}
		public StructuredInitializerContext(InitializerExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterStructuredInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitStructuredInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitStructuredInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerExpressionContext initializerExpression() throws RecognitionException {
		InitializerExpressionContext _localctx = new InitializerExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_initializerExpression);
		int _la;
		try {
			setState(212);
			switch (_input.LA(1)) {
			case EXPR_LITERAL_TRUE:
			case EXPR_LITERAL_FALSE:
			case EXPR_LITERAL_DEADLOCK:
			case UNARY_OP_INCREMENT:
			case UNARY_OP_DECREMENT:
			case COMMON_TOK_PLUS:
			case COMMON_TOK_MINUS:
			case COMMON_TOK_EXCLAMATION_MARK:
			case GROUP_LEFT_PAREN:
			case PHRASE_NOT:
			case PHRASE_FOR_ALL:
			case PHRASE_EXISTS:
			case IDENTIFIER_NAME:
			case NATURAL_NUMBER:
				_localctx = new FlatInitializerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				expression(0);
				}
				break;
			case GROUP_LEFT_CURLY:
				_localctx = new StructuredInitializerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(GROUP_LEFT_CURLY);
				setState(202);
				initializerExpression();
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP_ENUMERATION) {
					{
					{
					setState(203);
					match(SEP_ENUMERATION);
					setState(204);
					initializerExpression();
					}
					}
					setState(209);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(210);
				match(GROUP_RIGHT_CURLY);
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

	public static class DeclarationOfFunctionContext extends ParserRuleContext {
		public DeclarationOfFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationOfFunction; }
	 
		public DeclarationOfFunctionContext() { }
		public void copyFrom(DeclarationOfFunctionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueFunctionDeclarationContext extends DeclarationOfFunctionContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER_NAME() { return getToken(UtaLanguageParser.IDENTIFIER_NAME, 0); }
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UtaLanguageParser.GROUP_LEFT_PAREN, 0); }
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UtaLanguageParser.GROUP_RIGHT_PAREN, 0); }
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public ParameterSequenceContext parameterSequence() {
			return getRuleContext(ParameterSequenceContext.class,0);
		}
		public ValueFunctionDeclarationContext(DeclarationOfFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterValueFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitValueFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitValueFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VoidFunctionDeclarationContext extends DeclarationOfFunctionContext {
		public TerminalNode PHRASE_VOID() { return getToken(UtaLanguageParser.PHRASE_VOID, 0); }
		public TerminalNode IDENTIFIER_NAME() { return getToken(UtaLanguageParser.IDENTIFIER_NAME, 0); }
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UtaLanguageParser.GROUP_LEFT_PAREN, 0); }
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UtaLanguageParser.GROUP_RIGHT_PAREN, 0); }
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public ParameterSequenceContext parameterSequence() {
			return getRuleContext(ParameterSequenceContext.class,0);
		}
		public VoidFunctionDeclarationContext(DeclarationOfFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterVoidFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitVoidFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitVoidFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationOfFunctionContext declarationOfFunction() throws RecognitionException {
		DeclarationOfFunctionContext _localctx = new DeclarationOfFunctionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_declarationOfFunction);
		int _la;
		try {
			setState(231);
			switch (_input.LA(1)) {
			case TYPE_INTEGER:
			case TYPE_CLOCK:
			case TYPE_CHANNEL:
			case TYPE_BOOLEAN:
			case TYPE_SCALAR:
			case TYPE_STRUCT:
			case TYPE_PREFIX_URGENT:
			case TYPE_PREFIX_BROADCAST:
			case TYPE_PREFIX_META:
			case TYPE_PREFIX_CONST:
			case IDENTIFIER_NAME:
				_localctx = new ValueFunctionDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				type();
				setState(215);
				match(IDENTIFIER_NAME);
				setState(216);
				match(GROUP_LEFT_PAREN);
				setState(218);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INTEGER) | (1L << TYPE_CLOCK) | (1L << TYPE_CHANNEL) | (1L << TYPE_BOOLEAN) | (1L << TYPE_SCALAR) | (1L << TYPE_STRUCT) | (1L << TYPE_PREFIX_URGENT) | (1L << TYPE_PREFIX_BROADCAST) | (1L << TYPE_PREFIX_META) | (1L << TYPE_PREFIX_CONST))) != 0) || _la==IDENTIFIER_NAME) {
					{
					setState(217);
					parameterSequence();
					}
				}

				setState(220);
				match(GROUP_RIGHT_PAREN);
				setState(221);
				statementBlock();
				}
				break;
			case PHRASE_VOID:
				_localctx = new VoidFunctionDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				match(PHRASE_VOID);
				setState(224);
				match(IDENTIFIER_NAME);
				setState(225);
				match(GROUP_LEFT_PAREN);
				setState(227);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INTEGER) | (1L << TYPE_CLOCK) | (1L << TYPE_CHANNEL) | (1L << TYPE_BOOLEAN) | (1L << TYPE_SCALAR) | (1L << TYPE_STRUCT) | (1L << TYPE_PREFIX_URGENT) | (1L << TYPE_PREFIX_BROADCAST) | (1L << TYPE_PREFIX_META) | (1L << TYPE_PREFIX_CONST))) != 0) || _la==IDENTIFIER_NAME) {
					{
					setState(226);
					parameterSequence();
					}
				}

				setState(229);
				match(GROUP_RIGHT_PAREN);
				setState(230);
				statementBlock();
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

	public static class StatementBlockContext extends ParserRuleContext {
		public TerminalNode GROUP_LEFT_CURLY() { return getToken(UtaLanguageParser.GROUP_LEFT_CURLY, 0); }
		public TerminalNode GROUP_RIGHT_CURLY() { return getToken(UtaLanguageParser.GROUP_RIGHT_CURLY, 0); }
		public DeclarationSequenceContext declarationSequence() {
			return getRuleContext(DeclarationSequenceContext.class,0);
		}
		public StatementSequenceContext statementSequence() {
			return getRuleContext(StatementSequenceContext.class,0);
		}
		public StatementBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterStatementBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitStatementBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitStatementBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementBlockContext statementBlock() throws RecognitionException {
		StatementBlockContext _localctx = new StatementBlockContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_statementBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(GROUP_LEFT_CURLY);
			setState(235);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(234);
				declarationSequence();
				}
				break;
			}
			setState(238);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPR_LITERAL_TRUE) | (1L << EXPR_LITERAL_FALSE) | (1L << EXPR_LITERAL_DEADLOCK) | (1L << UNARY_OP_INCREMENT) | (1L << UNARY_OP_DECREMENT) | (1L << COMMON_TOK_PLUS) | (1L << COMMON_TOK_MINUS) | (1L << COMMON_TOK_EXCLAMATION_MARK) | (1L << GROUP_LEFT_CURLY) | (1L << GROUP_LEFT_PAREN) | (1L << SEP_SEMICOLON) | (1L << PHRASE_NOT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (PHRASE_FOR_ALL - 67)) | (1L << (PHRASE_EXISTS - 67)) | (1L << (PHRASE_IF - 67)) | (1L << (PHRASE_FOR - 67)) | (1L << (PHRASE_WHILE - 67)) | (1L << (PHRASE_RETURN - 67)) | (1L << (PHRASE_DO - 67)) | (1L << (IDENTIFIER_NAME - 67)) | (1L << (NATURAL_NUMBER - 67)))) != 0)) {
				{
				setState(237);
				statementSequence();
				}
			}

			setState(240);
			match(GROUP_RIGHT_CURLY);
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

	public static class StatementSequenceContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterStatementSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitStatementSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitStatementSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementSequenceContext statementSequence() throws RecognitionException {
		StatementSequenceContext _localctx = new StatementSequenceContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_statementSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(242);
				statement();
				}
				}
				setState(245); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPR_LITERAL_TRUE) | (1L << EXPR_LITERAL_FALSE) | (1L << EXPR_LITERAL_DEADLOCK) | (1L << UNARY_OP_INCREMENT) | (1L << UNARY_OP_DECREMENT) | (1L << COMMON_TOK_PLUS) | (1L << COMMON_TOK_MINUS) | (1L << COMMON_TOK_EXCLAMATION_MARK) | (1L << GROUP_LEFT_CURLY) | (1L << GROUP_LEFT_PAREN) | (1L << SEP_SEMICOLON) | (1L << PHRASE_NOT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (PHRASE_FOR_ALL - 67)) | (1L << (PHRASE_EXISTS - 67)) | (1L << (PHRASE_IF - 67)) | (1L << (PHRASE_FOR - 67)) | (1L << (PHRASE_WHILE - 67)) | (1L << (PHRASE_RETURN - 67)) | (1L << (PHRASE_DO - 67)) | (1L << (IDENTIFIER_NAME - 67)) | (1L << (NATURAL_NUMBER - 67)))) != 0) );
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatementReturnContext extends StatementContext {
		public TerminalNode PHRASE_RETURN() { return getToken(UtaLanguageParser.PHRASE_RETURN, 0); }
		public TerminalNode SEP_SEMICOLON() { return getToken(UtaLanguageParser.SEP_SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterStatementReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitStatementReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitStatementReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileLoopStatementContext extends StatementContext {
		public TerminalNode PHRASE_WHILE() { return getToken(UtaLanguageParser.PHRASE_WHILE, 0); }
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UtaLanguageParser.GROUP_LEFT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UtaLanguageParser.GROUP_RIGHT_PAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileLoopStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterWhileLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitWhileLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitWhileLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionStatementContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEP_SEMICOLON() { return getToken(UtaLanguageParser.SEP_SEMICOLON, 0); }
		public ExpressionStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionalStatementContext extends StatementContext {
		public TerminalNode PHRASE_IF() { return getToken(UtaLanguageParser.PHRASE_IF, 0); }
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UtaLanguageParser.GROUP_LEFT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UtaLanguageParser.GROUP_RIGHT_PAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode PHRASE_ELSE() { return getToken(UtaLanguageParser.PHRASE_ELSE, 0); }
		public ConditionalStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterConditionalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitConditionalStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitConditionalStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForLoopStatementContext extends StatementContext {
		public TerminalNode PHRASE_FOR() { return getToken(UtaLanguageParser.PHRASE_FOR, 0); }
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UtaLanguageParser.GROUP_LEFT_PAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SEP_SEMICOLON() { return getTokens(UtaLanguageParser.SEP_SEMICOLON); }
		public TerminalNode SEP_SEMICOLON(int i) {
			return getToken(UtaLanguageParser.SEP_SEMICOLON, i);
		}
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UtaLanguageParser.GROUP_RIGHT_PAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForLoopStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterForLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitForLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitForLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IterationStatementContext extends StatementContext {
		public TerminalNode PHRASE_FOR() { return getToken(UtaLanguageParser.PHRASE_FOR, 0); }
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UtaLanguageParser.GROUP_LEFT_PAREN, 0); }
		public TerminalNode IDENTIFIER_NAME() { return getToken(UtaLanguageParser.IDENTIFIER_NAME, 0); }
		public TerminalNode COMMON_TOK_COLON() { return getToken(UtaLanguageParser.COMMON_TOK_COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UtaLanguageParser.GROUP_RIGHT_PAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IterationStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterIterationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitIterationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitIterationStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyStatementContext extends StatementContext {
		public TerminalNode SEP_SEMICOLON() { return getToken(UtaLanguageParser.SEP_SEMICOLON, 0); }
		public EmptyStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitEmptyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitEmptyStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStatementContext extends StatementContext {
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public BlockStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoWhileStatementContext extends StatementContext {
		public TerminalNode PHRASE_DO() { return getToken(UtaLanguageParser.PHRASE_DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode PHRASE_WHILE() { return getToken(UtaLanguageParser.PHRASE_WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEP_SEMICOLON() { return getToken(UtaLanguageParser.SEP_SEMICOLON, 0); }
		public DoWhileStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterDoWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitDoWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitDoWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_statement);
		int _la;
		try {
			setState(296);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				statementBlock();
				}
				break;
			case 2:
				_localctx = new ExpressionStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				expression(0);
				setState(249);
				match(SEP_SEMICOLON);
				}
				break;
			case 3:
				_localctx = new ForLoopStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(251);
				match(PHRASE_FOR);
				setState(252);
				match(GROUP_LEFT_PAREN);
				setState(253);
				expression(0);
				setState(254);
				match(SEP_SEMICOLON);
				setState(255);
				expression(0);
				setState(256);
				match(SEP_SEMICOLON);
				setState(257);
				expression(0);
				setState(258);
				match(GROUP_RIGHT_PAREN);
				setState(259);
				statement();
				}
				break;
			case 4:
				_localctx = new IterationStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(261);
				match(PHRASE_FOR);
				setState(262);
				match(GROUP_LEFT_PAREN);
				setState(263);
				match(IDENTIFIER_NAME);
				setState(264);
				match(COMMON_TOK_COLON);
				setState(265);
				type();
				setState(266);
				match(GROUP_RIGHT_PAREN);
				setState(267);
				statement();
				}
				break;
			case 5:
				_localctx = new WhileLoopStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(269);
				match(PHRASE_WHILE);
				setState(270);
				match(GROUP_LEFT_PAREN);
				setState(271);
				expression(0);
				setState(272);
				match(GROUP_RIGHT_PAREN);
				setState(273);
				statement();
				}
				break;
			case 6:
				_localctx = new DoWhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(275);
				match(PHRASE_DO);
				setState(276);
				statement();
				setState(277);
				match(PHRASE_WHILE);
				setState(278);
				expression(0);
				setState(279);
				match(SEP_SEMICOLON);
				}
				break;
			case 7:
				_localctx = new ConditionalStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(281);
				match(PHRASE_IF);
				setState(282);
				match(GROUP_LEFT_PAREN);
				setState(283);
				expression(0);
				setState(284);
				match(GROUP_RIGHT_PAREN);
				setState(285);
				statement();
				setState(288);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(286);
					match(PHRASE_ELSE);
					setState(287);
					statement();
					}
					break;
				}
				}
				break;
			case 8:
				_localctx = new StatementReturnContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(290);
				match(PHRASE_RETURN);
				setState(292);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPR_LITERAL_TRUE) | (1L << EXPR_LITERAL_FALSE) | (1L << EXPR_LITERAL_DEADLOCK) | (1L << UNARY_OP_INCREMENT) | (1L << UNARY_OP_DECREMENT) | (1L << COMMON_TOK_PLUS) | (1L << COMMON_TOK_MINUS) | (1L << COMMON_TOK_EXCLAMATION_MARK) | (1L << GROUP_LEFT_PAREN) | (1L << PHRASE_NOT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (PHRASE_FOR_ALL - 67)) | (1L << (PHRASE_EXISTS - 67)) | (1L << (IDENTIFIER_NAME - 67)) | (1L << (NATURAL_NUMBER - 67)))) != 0)) {
					{
					setState(291);
					expression(0);
					}
				}

				setState(294);
				match(SEP_SEMICOLON);
				}
				break;
			case 9:
				_localctx = new EmptyStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(295);
				match(SEP_SEMICOLON);
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

	public static class ExpressionSequenceContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UtaLanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UtaLanguageParser.SEP_ENUMERATION, i);
		}
		public ExpressionSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterExpressionSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitExpressionSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitExpressionSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionSequenceContext expressionSequence() throws RecognitionException {
		ExpressionSequenceContext _localctx = new ExpressionSequenceContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_expressionSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			expression(0);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(299);
				match(SEP_ENUMERATION);
				setState(300);
				expression(0);
				}
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BitwiseXorExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_BITWISE_XOR() { return getToken(UtaLanguageParser.BINARY_OP_BITWISE_XOR, 0); }
		public BitwiseXorExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterBitwiseXorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitBitwiseXorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitBitwiseXorExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LeftShiftExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_LEFT_SHIFT() { return getToken(UtaLanguageParser.BINARY_OP_LEFT_SHIFT, 0); }
		public LeftShiftExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterLeftShiftExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitLeftShiftExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitLeftShiftExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DisjunctionExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_DISJUNCTION() { return getToken(UtaLanguageParser.BINARY_OP_DISJUNCTION, 0); }
		public DisjunctionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterDisjunctionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitDisjunctionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitDisjunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterThanExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_GREATER_THAN() { return getToken(UtaLanguageParser.BINARY_OP_GREATER_THAN, 0); }
		public GreaterThanExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterGreaterThanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitGreaterThanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitGreaterThanExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditiveIdentityExpressionContext extends ExpressionContext {
		public TerminalNode COMMON_TOK_PLUS() { return getToken(UtaLanguageParser.COMMON_TOK_PLUS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AdditiveIdentityExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterAdditiveIdentityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitAdditiveIdentityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitAdditiveIdentityExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditiveInverseExpressionContext extends ExpressionContext {
		public TerminalNode COMMON_TOK_MINUS() { return getToken(UtaLanguageParser.COMMON_TOK_MINUS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AdditiveInverseExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterAdditiveInverseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitAdditiveInverseExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitAdditiveInverseExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FieldAccessExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode BINARY_OP_ACCESS_FIELD() { return getToken(UtaLanguageParser.BINARY_OP_ACCESS_FIELD, 0); }
		public TerminalNode IDENTIFIER_NAME() { return getToken(UtaLanguageParser.IDENTIFIER_NAME, 0); }
		public FieldAccessExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterFieldAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitFieldAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitFieldAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModuloAssignmentExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_MODULO() { return getToken(UtaLanguageParser.ASSG_OP_MODULO, 0); }
		public ModuloAssignmentExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterModuloAssignmentExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitModuloAssignmentExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitModuloAssignmentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_EQUAL() { return getToken(UtaLanguageParser.BINARY_OP_EQUAL, 0); }
		public EqualityExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitwiseAndAssignmentExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_BITWISE_AND() { return getToken(UtaLanguageParser.ASSG_OP_BITWISE_AND, 0); }
		public BitwiseAndAssignmentExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterBitwiseAndAssignmentExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitBitwiseAndAssignmentExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitBitwiseAndAssignmentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UniversalQuantificationExpressionContext extends ExpressionContext {
		public TerminalNode PHRASE_FOR_ALL() { return getToken(UtaLanguageParser.PHRASE_FOR_ALL, 0); }
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UtaLanguageParser.GROUP_LEFT_PAREN, 0); }
		public TerminalNode IDENTIFIER_NAME() { return getToken(UtaLanguageParser.IDENTIFIER_NAME, 0); }
		public TerminalNode COMMON_TOK_COLON() { return getToken(UtaLanguageParser.COMMON_TOK_COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UtaLanguageParser.GROUP_RIGHT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UniversalQuantificationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterUniversalQuantificationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitUniversalQuantificationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitUniversalQuantificationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NaturalNumberLiteralContext extends ExpressionContext {
		public TerminalNode NATURAL_NUMBER() { return getToken(UtaLanguageParser.NATURAL_NUMBER, 0); }
		public NaturalNumberLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterNaturalNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitNaturalNumberLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitNaturalNumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionGroupContext extends ExpressionContext {
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UtaLanguageParser.GROUP_LEFT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UtaLanguageParser.GROUP_RIGHT_PAREN, 0); }
		public ExpressionGroupContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterExpressionGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitExpressionGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitExpressionGroup(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RightShiftExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_RIGHT_SHIFT() { return getToken(UtaLanguageParser.BINARY_OP_RIGHT_SHIFT, 0); }
		public RightShiftExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterRightShiftExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitRightShiftExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitRightShiftExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitwiseOrAssignmentExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_BITWISE_OR() { return getToken(UtaLanguageParser.ASSG_OP_BITWISE_OR, 0); }
		public BitwiseOrAssignmentExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterBitwiseOrAssignmentExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitBitwiseOrAssignmentExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitBitwiseOrAssignmentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterThanOrEqualExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_GREATER_THAN_OR_EQUAL() { return getToken(UtaLanguageParser.BINARY_OP_GREATER_THAN_OR_EQUAL, 0); }
		public GreaterThanOrEqualExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterGreaterThanOrEqualExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitGreaterThanOrEqualExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitGreaterThanOrEqualExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivisionAssignmentExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_DIVISION() { return getToken(UtaLanguageParser.ASSG_OP_DIVISION, 0); }
		public DivisionAssignmentExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterDivisionAssignmentExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitDivisionAssignmentExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitDivisionAssignmentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuffixDecrementExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode UNARY_OP_DECREMENT() { return getToken(UtaLanguageParser.UNARY_OP_DECREMENT, 0); }
		public SuffixDecrementExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterSuffixDecrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitSuffixDecrementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitSuffixDecrementExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExistentialQuantificationExpressionContext extends ExpressionContext {
		public TerminalNode PHRASE_EXISTS() { return getToken(UtaLanguageParser.PHRASE_EXISTS, 0); }
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UtaLanguageParser.GROUP_LEFT_PAREN, 0); }
		public TerminalNode IDENTIFIER_NAME() { return getToken(UtaLanguageParser.IDENTIFIER_NAME, 0); }
		public TerminalNode COMMON_TOK_COLON() { return getToken(UtaLanguageParser.COMMON_TOK_COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UtaLanguageParser.GROUP_RIGHT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExistentialQuantificationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterExistentialQuantificationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitExistentialQuantificationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitExistentialQuantificationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicationExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_MULTIPLICATION() { return getToken(UtaLanguageParser.BINARY_OP_MULTIPLICATION, 0); }
		public MultiplicationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterMultiplicationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitMultiplicationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitMultiplicationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModuloExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_MODULO() { return getToken(UtaLanguageParser.BINARY_OP_MODULO, 0); }
		public ModuloExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterModuloExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitModuloExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitModuloExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConjunctionExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_CONJUNCTION() { return getToken(UtaLanguageParser.BINARY_OP_CONJUNCTION, 0); }
		public ConjunctionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterConjunctionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitConjunctionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitConjunctionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiplicationAssignmentExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_MULTIPLICATION() { return getToken(UtaLanguageParser.ASSG_OP_MULTIPLICATION, 0); }
		public MultiplicationAssignmentExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterMultiplicationAssignmentExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitMultiplicationAssignmentExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitMultiplicationAssignmentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TernaryExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMON_TOK_QUESTION_MARK() { return getToken(UtaLanguageParser.COMMON_TOK_QUESTION_MARK, 0); }
		public TerminalNode COMMON_TOK_COLON() { return getToken(UtaLanguageParser.COMMON_TOK_COLON, 0); }
		public TernaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterTernaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitTernaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitTernaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayLookupExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GROUP_LEFT_BRACKET() { return getToken(UtaLanguageParser.GROUP_LEFT_BRACKET, 0); }
		public TerminalNode GROUP_RIGHT_BRACKET() { return getToken(UtaLanguageParser.GROUP_RIGHT_BRACKET, 0); }
		public ArrayLookupExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterArrayLookupExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitArrayLookupExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitArrayLookupExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixIncrementExpressionContext extends ExpressionContext {
		public TerminalNode UNARY_OP_INCREMENT() { return getToken(UtaLanguageParser.UNARY_OP_INCREMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrefixIncrementExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterPrefixIncrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitPrefixIncrementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitPrefixIncrementExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessThanOrEqualExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_LESS_THAN_OR_EQUAL_TO() { return getToken(UtaLanguageParser.BINARY_OP_LESS_THAN_OR_EQUAL_TO, 0); }
		public LessThanOrEqualExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterLessThanOrEqualExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitLessThanOrEqualExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitLessThanOrEqualExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseLiteralContext extends ExpressionContext {
		public TerminalNode EXPR_LITERAL_FALSE() { return getToken(UtaLanguageParser.EXPR_LITERAL_FALSE, 0); }
		public FalseLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterFalseLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitFalseLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitFalseLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InequalityExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_NOT_EQUAL() { return getToken(UtaLanguageParser.BINARY_OP_NOT_EQUAL, 0); }
		public InequalityExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterInequalityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitInequalityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitInequalityExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeadlockLiteralContext extends ExpressionContext {
		public TerminalNode EXPR_LITERAL_DEADLOCK() { return getToken(UtaLanguageParser.EXPR_LITERAL_DEADLOCK, 0); }
		public DeadlockLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterDeadlockLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitDeadlockLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitDeadlockLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueLiteralContext extends ExpressionContext {
		public TerminalNode EXPR_LITERAL_TRUE() { return getToken(UtaLanguageParser.EXPR_LITERAL_TRUE, 0); }
		public TrueLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterTrueLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitTrueLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitTrueLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP() { return getToken(UtaLanguageParser.ASSG_OP, 0); }
		public AssignmentExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitAssignmentExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitAssignmentExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuffixIncrementExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode UNARY_OP_INCREMENT() { return getToken(UtaLanguageParser.UNARY_OP_INCREMENT, 0); }
		public SuffixIncrementExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterSuffixIncrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitSuffixIncrementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitSuffixIncrementExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivisionExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_DIVISION() { return getToken(UtaLanguageParser.BINARY_OP_DIVISION, 0); }
		public DivisionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterDivisionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitDivisionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitDivisionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditionAssignmentExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_ADDITION() { return getToken(UtaLanguageParser.ASSG_OP_ADDITION, 0); }
		public AdditionAssignmentExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterAdditionAssignmentExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitAdditionAssignmentExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitAdditionAssignmentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegationExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMON_TOK_EXCLAMATION_MARK() { return getToken(UtaLanguageParser.COMMON_TOK_EXCLAMATION_MARK, 0); }
		public TerminalNode PHRASE_NOT() { return getToken(UtaLanguageParser.PHRASE_NOT, 0); }
		public NegationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterNegationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitNegationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitNegationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UtaLanguageParser.GROUP_LEFT_PAREN, 0); }
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UtaLanguageParser.GROUP_RIGHT_PAREN, 0); }
		public ArgumentSequenceContext argumentSequence() {
			return getRuleContext(ArgumentSequenceContext.class,0);
		}
		public CallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixDecrementExpressionContext extends ExpressionContext {
		public TerminalNode UNARY_OP_DECREMENT() { return getToken(UtaLanguageParser.UNARY_OP_DECREMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrefixDecrementExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterPrefixDecrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitPrefixDecrementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitPrefixDecrementExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitwiseOrExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_BITWISE_OR() { return getToken(UtaLanguageParser.BINARY_OP_BITWISE_OR, 0); }
		public BitwiseOrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterBitwiseOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitBitwiseOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitBitwiseOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AdditionExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMON_TOK_PLUS() { return getToken(UtaLanguageParser.COMMON_TOK_PLUS, 0); }
		public AdditionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterAdditionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitAdditionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitAdditionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitwiseXorAssignmentExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_BITWISE_XOR() { return getToken(UtaLanguageParser.ASSG_OP_BITWISE_XOR, 0); }
		public BitwiseXorAssignmentExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterBitwiseXorAssignmentExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitBitwiseXorAssignmentExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitBitwiseXorAssignmentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubtractionAssignmentExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_SUBTRACTION() { return getToken(UtaLanguageParser.ASSG_OP_SUBTRACTION, 0); }
		public SubtractionAssignmentExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterSubtractionAssignmentExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitSubtractionAssignmentExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitSubtractionAssignmentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RightShiftAssignmentExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_RIGHT_SHIFT() { return getToken(UtaLanguageParser.ASSG_OP_RIGHT_SHIFT, 0); }
		public RightShiftAssignmentExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterRightShiftAssignmentExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitRightShiftAssignmentExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitRightShiftAssignmentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MaximumExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_MAX() { return getToken(UtaLanguageParser.BINARY_OP_MAX, 0); }
		public MaximumExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterMaximumExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitMaximumExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitMaximumExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierExpressionContext extends ExpressionContext {
		public TerminalNode IDENTIFIER_NAME() { return getToken(UtaLanguageParser.IDENTIFIER_NAME, 0); }
		public IdentifierExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterIdentifierExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitIdentifierExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitIdentifierExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubtractionExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMON_TOK_MINUS() { return getToken(UtaLanguageParser.COMMON_TOK_MINUS, 0); }
		public SubtractionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterSubtractionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitSubtractionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitSubtractionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitwiseAndExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMON_TOK_AMPERSAND() { return getToken(UtaLanguageParser.COMMON_TOK_AMPERSAND, 0); }
		public BitwiseAndExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterBitwiseAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitBitwiseAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitBitwiseAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinimumExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_MIN() { return getToken(UtaLanguageParser.BINARY_OP_MIN, 0); }
		public MinimumExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterMinimumExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitMinimumExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitMinimumExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImplicationExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PHRASE_IMPLY() { return getToken(UtaLanguageParser.PHRASE_IMPLY, 0); }
		public ImplicationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterImplicationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitImplicationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitImplicationExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LeftShiftAssignmentExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_LEFT_SHIFT() { return getToken(UtaLanguageParser.ASSG_OP_LEFT_SHIFT, 0); }
		public LeftShiftAssignmentExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterLeftShiftAssignmentExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitLeftShiftAssignmentExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitLeftShiftAssignmentExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessThanExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMON_TOK_LESS_THAN() { return getToken(UtaLanguageParser.COMMON_TOK_LESS_THAN, 0); }
		public LessThanExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterLessThanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitLessThanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitLessThanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			switch (_input.LA(1)) {
			case COMMON_TOK_EXCLAMATION_MARK:
			case PHRASE_NOT:
				{
				_localctx = new NegationExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(307);
				_la = _input.LA(1);
				if ( !(_la==COMMON_TOK_EXCLAMATION_MARK || _la==PHRASE_NOT) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(308);
				expression(48);
				}
				break;
			case UNARY_OP_INCREMENT:
				{
				_localctx = new PrefixIncrementExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(309);
				match(UNARY_OP_INCREMENT);
				setState(310);
				expression(46);
				}
				break;
			case UNARY_OP_DECREMENT:
				{
				_localctx = new PrefixDecrementExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(311);
				match(UNARY_OP_DECREMENT);
				setState(312);
				expression(44);
				}
				break;
			case COMMON_TOK_MINUS:
				{
				_localctx = new AdditiveInverseExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(313);
				match(COMMON_TOK_MINUS);
				setState(314);
				expression(43);
				}
				break;
			case COMMON_TOK_PLUS:
				{
				_localctx = new AdditiveIdentityExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(315);
				match(COMMON_TOK_PLUS);
				setState(316);
				expression(42);
				}
				break;
			case PHRASE_FOR_ALL:
				{
				_localctx = new UniversalQuantificationExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(317);
				match(PHRASE_FOR_ALL);
				setState(318);
				match(GROUP_LEFT_PAREN);
				setState(319);
				match(IDENTIFIER_NAME);
				setState(320);
				match(COMMON_TOK_COLON);
				setState(321);
				type();
				setState(322);
				match(GROUP_RIGHT_PAREN);
				setState(323);
				expression(19);
				}
				break;
			case PHRASE_EXISTS:
				{
				_localctx = new ExistentialQuantificationExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(325);
				match(PHRASE_EXISTS);
				setState(326);
				match(GROUP_LEFT_PAREN);
				setState(327);
				match(IDENTIFIER_NAME);
				setState(328);
				match(COMMON_TOK_COLON);
				setState(329);
				type();
				setState(330);
				match(GROUP_RIGHT_PAREN);
				setState(331);
				expression(18);
				}
				break;
			case GROUP_LEFT_PAREN:
				{
				_localctx = new ExpressionGroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(333);
				match(GROUP_LEFT_PAREN);
				setState(334);
				expression(0);
				setState(335);
				match(GROUP_RIGHT_PAREN);
				}
				break;
			case EXPR_LITERAL_DEADLOCK:
				{
				_localctx = new DeadlockLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(337);
				match(EXPR_LITERAL_DEADLOCK);
				}
				break;
			case EXPR_LITERAL_TRUE:
				{
				_localctx = new TrueLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(338);
				match(EXPR_LITERAL_TRUE);
				}
				break;
			case EXPR_LITERAL_FALSE:
				{
				_localctx = new FalseLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(339);
				match(EXPR_LITERAL_FALSE);
				}
				break;
			case NATURAL_NUMBER:
				{
				_localctx = new NaturalNumberLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(340);
				match(NATURAL_NUMBER);
				}
				break;
			case IDENTIFIER_NAME:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(341);
				match(IDENTIFIER_NAME);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(466);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(464);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(344);
						if (!(precpred(_ctx, 41))) throw new FailedPredicateException(this, "precpred(_ctx, 41)");
						setState(345);
						match(BINARY_OP_MULTIPLICATION);
						setState(346);
						expression(42);
						}
						break;
					case 2:
						{
						_localctx = new DivisionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(347);
						if (!(precpred(_ctx, 40))) throw new FailedPredicateException(this, "precpred(_ctx, 40)");
						setState(348);
						match(BINARY_OP_DIVISION);
						setState(349);
						expression(41);
						}
						break;
					case 3:
						{
						_localctx = new ModuloExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(350);
						if (!(precpred(_ctx, 39))) throw new FailedPredicateException(this, "precpred(_ctx, 39)");
						setState(351);
						match(BINARY_OP_MODULO);
						setState(352);
						expression(40);
						}
						break;
					case 4:
						{
						_localctx = new SubtractionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(353);
						if (!(precpred(_ctx, 38))) throw new FailedPredicateException(this, "precpred(_ctx, 38)");
						setState(354);
						match(COMMON_TOK_MINUS);
						setState(355);
						expression(39);
						}
						break;
					case 5:
						{
						_localctx = new AdditionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(356);
						if (!(precpred(_ctx, 37))) throw new FailedPredicateException(this, "precpred(_ctx, 37)");
						setState(357);
						match(COMMON_TOK_PLUS);
						setState(358);
						expression(38);
						}
						break;
					case 6:
						{
						_localctx = new LeftShiftExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(359);
						if (!(precpred(_ctx, 36))) throw new FailedPredicateException(this, "precpred(_ctx, 36)");
						setState(360);
						match(BINARY_OP_LEFT_SHIFT);
						setState(361);
						expression(37);
						}
						break;
					case 7:
						{
						_localctx = new RightShiftExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(362);
						if (!(precpred(_ctx, 35))) throw new FailedPredicateException(this, "precpred(_ctx, 35)");
						setState(363);
						match(BINARY_OP_RIGHT_SHIFT);
						setState(364);
						expression(36);
						}
						break;
					case 8:
						{
						_localctx = new MaximumExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(365);
						if (!(precpred(_ctx, 34))) throw new FailedPredicateException(this, "precpred(_ctx, 34)");
						setState(366);
						match(BINARY_OP_MAX);
						setState(367);
						expression(35);
						}
						break;
					case 9:
						{
						_localctx = new MinimumExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(368);
						if (!(precpred(_ctx, 33))) throw new FailedPredicateException(this, "precpred(_ctx, 33)");
						setState(369);
						match(BINARY_OP_MIN);
						setState(370);
						expression(34);
						}
						break;
					case 10:
						{
						_localctx = new LessThanExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(371);
						if (!(precpred(_ctx, 32))) throw new FailedPredicateException(this, "precpred(_ctx, 32)");
						setState(372);
						match(COMMON_TOK_LESS_THAN);
						setState(373);
						expression(33);
						}
						break;
					case 11:
						{
						_localctx = new LessThanOrEqualExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(374);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(375);
						match(BINARY_OP_LESS_THAN_OR_EQUAL_TO);
						setState(376);
						expression(32);
						}
						break;
					case 12:
						{
						_localctx = new GreaterThanExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(377);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(378);
						match(BINARY_OP_GREATER_THAN);
						setState(379);
						expression(31);
						}
						break;
					case 13:
						{
						_localctx = new GreaterThanOrEqualExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(380);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(381);
						match(BINARY_OP_GREATER_THAN_OR_EQUAL);
						setState(382);
						expression(30);
						}
						break;
					case 14:
						{
						_localctx = new EqualityExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(383);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(384);
						match(BINARY_OP_EQUAL);
						setState(385);
						expression(29);
						}
						break;
					case 15:
						{
						_localctx = new InequalityExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(386);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(387);
						match(BINARY_OP_NOT_EQUAL);
						setState(388);
						expression(28);
						}
						break;
					case 16:
						{
						_localctx = new BitwiseAndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(389);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(390);
						match(COMMON_TOK_AMPERSAND);
						setState(391);
						expression(27);
						}
						break;
					case 17:
						{
						_localctx = new BitwiseXorExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(392);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(393);
						match(BINARY_OP_BITWISE_XOR);
						setState(394);
						expression(26);
						}
						break;
					case 18:
						{
						_localctx = new BitwiseOrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(395);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(396);
						match(BINARY_OP_BITWISE_OR);
						setState(397);
						expression(25);
						}
						break;
					case 19:
						{
						_localctx = new ConjunctionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(398);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(399);
						match(BINARY_OP_CONJUNCTION);
						setState(400);
						expression(24);
						}
						break;
					case 20:
						{
						_localctx = new DisjunctionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(401);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(402);
						match(BINARY_OP_DISJUNCTION);
						setState(403);
						expression(23);
						}
						break;
					case 21:
						{
						_localctx = new TernaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(404);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(405);
						match(COMMON_TOK_QUESTION_MARK);
						setState(406);
						expression(0);
						setState(407);
						match(COMMON_TOK_COLON);
						setState(408);
						expression(21);
						}
						break;
					case 22:
						{
						_localctx = new ImplicationExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(410);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(411);
						match(PHRASE_IMPLY);
						setState(412);
						expression(21);
						}
						break;
					case 23:
						{
						_localctx = new AssignmentExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(413);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(414);
						match(ASSG_OP);
						setState(415);
						expression(16);
						}
						break;
					case 24:
						{
						_localctx = new MultiplicationAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(416);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(417);
						match(ASSG_OP_MULTIPLICATION);
						setState(418);
						expression(16);
						}
						break;
					case 25:
						{
						_localctx = new DivisionAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(419);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(420);
						match(ASSG_OP_DIVISION);
						setState(421);
						expression(15);
						}
						break;
					case 26:
						{
						_localctx = new ModuloAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(422);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(423);
						match(ASSG_OP_MODULO);
						setState(424);
						expression(14);
						}
						break;
					case 27:
						{
						_localctx = new SubtractionAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(425);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(426);
						match(ASSG_OP_SUBTRACTION);
						setState(427);
						expression(13);
						}
						break;
					case 28:
						{
						_localctx = new AdditionAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(428);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(429);
						match(ASSG_OP_ADDITION);
						setState(430);
						expression(12);
						}
						break;
					case 29:
						{
						_localctx = new LeftShiftAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(431);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(432);
						match(ASSG_OP_LEFT_SHIFT);
						setState(433);
						expression(11);
						}
						break;
					case 30:
						{
						_localctx = new RightShiftAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(434);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(435);
						match(ASSG_OP_RIGHT_SHIFT);
						setState(436);
						expression(10);
						}
						break;
					case 31:
						{
						_localctx = new BitwiseAndAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(437);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(438);
						match(ASSG_OP_BITWISE_AND);
						setState(439);
						expression(9);
						}
						break;
					case 32:
						{
						_localctx = new BitwiseXorAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(440);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(441);
						match(ASSG_OP_BITWISE_XOR);
						setState(442);
						expression(8);
						}
						break;
					case 33:
						{
						_localctx = new BitwiseOrAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(443);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(444);
						match(ASSG_OP_BITWISE_OR);
						setState(445);
						expression(7);
						}
						break;
					case 34:
						{
						_localctx = new ArrayLookupExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(446);
						if (!(precpred(_ctx, 50))) throw new FailedPredicateException(this, "precpred(_ctx, 50)");
						setState(447);
						match(GROUP_LEFT_BRACKET);
						setState(448);
						expression(0);
						setState(449);
						match(GROUP_RIGHT_BRACKET);
						}
						break;
					case 35:
						{
						_localctx = new FieldAccessExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(451);
						if (!(precpred(_ctx, 49))) throw new FailedPredicateException(this, "precpred(_ctx, 49)");
						setState(452);
						match(BINARY_OP_ACCESS_FIELD);
						setState(453);
						match(IDENTIFIER_NAME);
						}
						break;
					case 36:
						{
						_localctx = new SuffixIncrementExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(454);
						if (!(precpred(_ctx, 47))) throw new FailedPredicateException(this, "precpred(_ctx, 47)");
						setState(455);
						match(UNARY_OP_INCREMENT);
						}
						break;
					case 37:
						{
						_localctx = new SuffixDecrementExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(456);
						if (!(precpred(_ctx, 45))) throw new FailedPredicateException(this, "precpred(_ctx, 45)");
						setState(457);
						match(UNARY_OP_DECREMENT);
						}
						break;
					case 38:
						{
						_localctx = new CallExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(458);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(459);
						match(GROUP_LEFT_PAREN);
						setState(461);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPR_LITERAL_TRUE) | (1L << EXPR_LITERAL_FALSE) | (1L << EXPR_LITERAL_DEADLOCK) | (1L << UNARY_OP_INCREMENT) | (1L << UNARY_OP_DECREMENT) | (1L << COMMON_TOK_PLUS) | (1L << COMMON_TOK_MINUS) | (1L << COMMON_TOK_EXCLAMATION_MARK) | (1L << GROUP_LEFT_PAREN) | (1L << PHRASE_NOT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (PHRASE_FOR_ALL - 67)) | (1L << (PHRASE_EXISTS - 67)) | (1L << (IDENTIFIER_NAME - 67)) | (1L << (NATURAL_NUMBER - 67)))) != 0)) {
							{
							setState(460);
							argumentSequence();
							}
						}

						setState(463);
						match(GROUP_RIGHT_PAREN);
						}
						break;
					}
					} 
				}
				setState(468);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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

	public static class ParameterSequenceContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UtaLanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UtaLanguageParser.SEP_ENUMERATION, i);
		}
		public ParameterSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterParameterSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitParameterSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitParameterSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterSequenceContext parameterSequence() throws RecognitionException {
		ParameterSequenceContext _localctx = new ParameterSequenceContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_parameterSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			parameter();
			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(470);
				match(SEP_ENUMERATION);
				setState(471);
				parameter();
				}
				}
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierDeclarationContext identifierDeclaration() {
			return getRuleContext(IdentifierDeclarationContext.class,0);
		}
		public TerminalNode COMMON_TOK_AMPERSAND() { return getToken(UtaLanguageParser.COMMON_TOK_AMPERSAND, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			type();
			setState(479);
			_la = _input.LA(1);
			if (_la==COMMON_TOK_AMPERSAND) {
				{
				setState(478);
				match(COMMON_TOK_AMPERSAND);
				}
			}

			setState(481);
			identifierDeclaration();
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

	public static class ArgumentSequenceContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UtaLanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UtaLanguageParser.SEP_ENUMERATION, i);
		}
		public ArgumentSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterArgumentSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitArgumentSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitArgumentSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentSequenceContext argumentSequence() throws RecognitionException {
		ArgumentSequenceContext _localctx = new ArgumentSequenceContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_argumentSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			expression(0);
			setState(488);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(484);
				match(SEP_ENUMERATION);
				setState(485);
				expression(0);
				}
				}
				setState(490);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class TypeContext extends ParserRuleContext {
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public TypePrefixContext typePrefix() {
			return getRuleContext(TypePrefixContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_PREFIX_URGENT) | (1L << TYPE_PREFIX_BROADCAST) | (1L << TYPE_PREFIX_META) | (1L << TYPE_PREFIX_CONST))) != 0)) {
				{
				setState(491);
				typePrefix();
				}
			}

			setState(494);
			typeIdentifier();
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

	public static class TypeIdentifierContext extends ParserRuleContext {
		public TypeIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeIdentifier; }
	 
		public TypeIdentifierContext() { }
		public void copyFrom(TypeIdentifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeIdChannelContext extends TypeIdentifierContext {
		public TerminalNode TYPE_CHANNEL() { return getToken(UtaLanguageParser.TYPE_CHANNEL, 0); }
		public TypeIdChannelContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterTypeIdChannel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitTypeIdChannel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitTypeIdChannel(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIdBooleanContext extends TypeIdentifierContext {
		public TerminalNode TYPE_BOOLEAN() { return getToken(UtaLanguageParser.TYPE_BOOLEAN, 0); }
		public TypeIdBooleanContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterTypeIdBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitTypeIdBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitTypeIdBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIdStructContext extends TypeIdentifierContext {
		public TerminalNode TYPE_STRUCT() { return getToken(UtaLanguageParser.TYPE_STRUCT, 0); }
		public TerminalNode GROUP_LEFT_CURLY() { return getToken(UtaLanguageParser.GROUP_LEFT_CURLY, 0); }
		public TerminalNode GROUP_RIGHT_CURLY() { return getToken(UtaLanguageParser.GROUP_RIGHT_CURLY, 0); }
		public List<FieldDeclarationContext> fieldDeclaration() {
			return getRuleContexts(FieldDeclarationContext.class);
		}
		public FieldDeclarationContext fieldDeclaration(int i) {
			return getRuleContext(FieldDeclarationContext.class,i);
		}
		public TypeIdStructContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterTypeIdStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitTypeIdStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitTypeIdStruct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIdIdentifierNameContext extends TypeIdentifierContext {
		public TerminalNode IDENTIFIER_NAME() { return getToken(UtaLanguageParser.IDENTIFIER_NAME, 0); }
		public TypeIdIdentifierNameContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterTypeIdIdentifierName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitTypeIdIdentifierName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitTypeIdIdentifierName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIdIntegerBoundedContext extends TypeIdentifierContext {
		public TerminalNode TYPE_INTEGER() { return getToken(UtaLanguageParser.TYPE_INTEGER, 0); }
		public TerminalNode GROUP_LEFT_BRACKET() { return getToken(UtaLanguageParser.GROUP_LEFT_BRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SEP_ENUMERATION() { return getToken(UtaLanguageParser.SEP_ENUMERATION, 0); }
		public TerminalNode GROUP_RIGHT_BRACKET() { return getToken(UtaLanguageParser.GROUP_RIGHT_BRACKET, 0); }
		public TypeIdIntegerBoundedContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterTypeIdIntegerBounded(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitTypeIdIntegerBounded(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitTypeIdIntegerBounded(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIdIntegerContext extends TypeIdentifierContext {
		public TerminalNode TYPE_INTEGER() { return getToken(UtaLanguageParser.TYPE_INTEGER, 0); }
		public TypeIdIntegerContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterTypeIdInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitTypeIdInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitTypeIdInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIdScalarContext extends TypeIdentifierContext {
		public TerminalNode TYPE_SCALAR() { return getToken(UtaLanguageParser.TYPE_SCALAR, 0); }
		public TerminalNode GROUP_LEFT_BRACKET() { return getToken(UtaLanguageParser.GROUP_LEFT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_BRACKET() { return getToken(UtaLanguageParser.GROUP_RIGHT_BRACKET, 0); }
		public TypeIdScalarContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterTypeIdScalar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitTypeIdScalar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitTypeIdScalar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIdClockContext extends TypeIdentifierContext {
		public TerminalNode TYPE_CLOCK() { return getToken(UtaLanguageParser.TYPE_CLOCK, 0); }
		public TypeIdClockContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterTypeIdClock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitTypeIdClock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitTypeIdClock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeIdentifierContext typeIdentifier() throws RecognitionException {
		TypeIdentifierContext _localctx = new TypeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_typeIdentifier);
		int _la;
		try {
			setState(522);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				_localctx = new TypeIdIntegerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(496);
				match(TYPE_INTEGER);
				}
				break;
			case 2:
				_localctx = new TypeIdClockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(497);
				match(TYPE_CLOCK);
				}
				break;
			case 3:
				_localctx = new TypeIdChannelContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(498);
				match(TYPE_CHANNEL);
				}
				break;
			case 4:
				_localctx = new TypeIdBooleanContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(499);
				match(TYPE_BOOLEAN);
				}
				break;
			case 5:
				_localctx = new TypeIdIntegerBoundedContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(500);
				match(TYPE_INTEGER);
				setState(501);
				match(GROUP_LEFT_BRACKET);
				setState(502);
				expression(0);
				setState(503);
				match(SEP_ENUMERATION);
				setState(504);
				expression(0);
				setState(505);
				match(GROUP_RIGHT_BRACKET);
				}
				break;
			case 6:
				_localctx = new TypeIdScalarContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(507);
				match(TYPE_SCALAR);
				setState(508);
				match(GROUP_LEFT_BRACKET);
				setState(509);
				expression(0);
				setState(510);
				match(GROUP_RIGHT_BRACKET);
				}
				break;
			case 7:
				_localctx = new TypeIdStructContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(512);
				match(TYPE_STRUCT);
				setState(513);
				match(GROUP_LEFT_CURLY);
				setState(515); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(514);
					fieldDeclaration();
					}
					}
					setState(517); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INTEGER) | (1L << TYPE_CLOCK) | (1L << TYPE_CHANNEL) | (1L << TYPE_BOOLEAN) | (1L << TYPE_SCALAR) | (1L << TYPE_STRUCT) | (1L << TYPE_PREFIX_URGENT) | (1L << TYPE_PREFIX_BROADCAST) | (1L << TYPE_PREFIX_META) | (1L << TYPE_PREFIX_CONST))) != 0) || _la==IDENTIFIER_NAME );
				setState(519);
				match(GROUP_RIGHT_CURLY);
				}
				break;
			case 8:
				_localctx = new TypeIdIdentifierNameContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(521);
				match(IDENTIFIER_NAME);
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

	public static class ArrayVariableLookupContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER_NAME() { return getToken(UtaLanguageParser.IDENTIFIER_NAME, 0); }
		public List<TerminalNode> GROUP_LEFT_BRACKET() { return getTokens(UtaLanguageParser.GROUP_LEFT_BRACKET); }
		public TerminalNode GROUP_LEFT_BRACKET(int i) {
			return getToken(UtaLanguageParser.GROUP_LEFT_BRACKET, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> GROUP_RIGHT_BRACKET() { return getTokens(UtaLanguageParser.GROUP_RIGHT_BRACKET); }
		public TerminalNode GROUP_RIGHT_BRACKET(int i) {
			return getToken(UtaLanguageParser.GROUP_RIGHT_BRACKET, i);
		}
		public ArrayVariableLookupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayVariableLookup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterArrayVariableLookup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitArrayVariableLookup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitArrayVariableLookup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayVariableLookupContext arrayVariableLookup() throws RecognitionException {
		ArrayVariableLookupContext _localctx = new ArrayVariableLookupContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_arrayVariableLookup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			match(IDENTIFIER_NAME);
			setState(529); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(525);
				match(GROUP_LEFT_BRACKET);
				setState(526);
				expression(0);
				setState(527);
				match(GROUP_RIGHT_BRACKET);
				}
				}
				setState(531); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==GROUP_LEFT_BRACKET );
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

	public static class FieldDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<IdentifierDeclarationContext> identifierDeclaration() {
			return getRuleContexts(IdentifierDeclarationContext.class);
		}
		public IdentifierDeclarationContext identifierDeclaration(int i) {
			return getRuleContext(IdentifierDeclarationContext.class,i);
		}
		public TerminalNode SEP_SEMICOLON() { return getToken(UtaLanguageParser.SEP_SEMICOLON, 0); }
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UtaLanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UtaLanguageParser.SEP_ENUMERATION, i);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitFieldDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitFieldDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_fieldDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533);
			type();
			setState(534);
			identifierDeclaration();
			setState(539);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(535);
				match(SEP_ENUMERATION);
				setState(536);
				identifierDeclaration();
				}
				}
				setState(541);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(542);
			match(SEP_SEMICOLON);
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

	public static class IdentifierDeclarationContext extends ParserRuleContext {
		public IdentifierDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierDeclaration; }
	 
		public IdentifierDeclarationContext() { }
		public void copyFrom(IdentifierDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BaseIdentifierDeclarationContext extends IdentifierDeclarationContext {
		public TerminalNode IDENTIFIER_NAME() { return getToken(UtaLanguageParser.IDENTIFIER_NAME, 0); }
		public BaseIdentifierDeclarationContext(IdentifierDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterBaseIdentifierDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitBaseIdentifierDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitBaseIdentifierDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayIdentifierDeclarationContext extends IdentifierDeclarationContext {
		public TerminalNode IDENTIFIER_NAME() { return getToken(UtaLanguageParser.IDENTIFIER_NAME, 0); }
		public List<ArraySizeModifierContext> arraySizeModifier() {
			return getRuleContexts(ArraySizeModifierContext.class);
		}
		public ArraySizeModifierContext arraySizeModifier(int i) {
			return getRuleContext(ArraySizeModifierContext.class,i);
		}
		public ArrayIdentifierDeclarationContext(IdentifierDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterArrayIdentifierDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitArrayIdentifierDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitArrayIdentifierDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierDeclarationContext identifierDeclaration() throws RecognitionException {
		IdentifierDeclarationContext _localctx = new IdentifierDeclarationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_identifierDeclaration);
		int _la;
		try {
			setState(551);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				_localctx = new ArrayIdentifierDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(544);
				match(IDENTIFIER_NAME);
				setState(546); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(545);
					arraySizeModifier();
					}
					}
					setState(548); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==GROUP_LEFT_BRACKET );
				}
				break;
			case 2:
				_localctx = new BaseIdentifierDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(550);
				match(IDENTIFIER_NAME);
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

	public static class ArraySizeModifierContext extends ParserRuleContext {
		public ArraySizeModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraySizeModifier; }
	 
		public ArraySizeModifierContext() { }
		public void copyFrom(ArraySizeModifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArraySizeFromExpressionContext extends ArraySizeModifierContext {
		public TerminalNode GROUP_LEFT_BRACKET() { return getToken(UtaLanguageParser.GROUP_LEFT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_BRACKET() { return getToken(UtaLanguageParser.GROUP_RIGHT_BRACKET, 0); }
		public ArraySizeFromExpressionContext(ArraySizeModifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterArraySizeFromExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitArraySizeFromExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitArraySizeFromExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArraySizeFromTypeContext extends ArraySizeModifierContext {
		public TerminalNode GROUP_LEFT_BRACKET() { return getToken(UtaLanguageParser.GROUP_LEFT_BRACKET, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_BRACKET() { return getToken(UtaLanguageParser.GROUP_RIGHT_BRACKET, 0); }
		public ArraySizeFromTypeContext(ArraySizeModifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterArraySizeFromType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitArraySizeFromType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitArraySizeFromType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraySizeModifierContext arraySizeModifier() throws RecognitionException {
		ArraySizeModifierContext _localctx = new ArraySizeModifierContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_arraySizeModifier);
		try {
			setState(561);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				_localctx = new ArraySizeFromExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(553);
				match(GROUP_LEFT_BRACKET);
				setState(554);
				expression(0);
				setState(555);
				match(GROUP_RIGHT_BRACKET);
				}
				break;
			case 2:
				_localctx = new ArraySizeFromTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(557);
				match(GROUP_LEFT_BRACKET);
				setState(558);
				type();
				setState(559);
				match(GROUP_RIGHT_BRACKET);
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

	public static class TypePrefixContext extends ParserRuleContext {
		public TypePrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typePrefix; }
	 
		public TypePrefixContext() { }
		public void copyFrom(TypePrefixContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypePrefixUrgentContext extends TypePrefixContext {
		public TerminalNode TYPE_PREFIX_URGENT() { return getToken(UtaLanguageParser.TYPE_PREFIX_URGENT, 0); }
		public TypePrefixUrgentContext(TypePrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterTypePrefixUrgent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitTypePrefixUrgent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitTypePrefixUrgent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypePrefixBroadcastContext extends TypePrefixContext {
		public TerminalNode TYPE_PREFIX_BROADCAST() { return getToken(UtaLanguageParser.TYPE_PREFIX_BROADCAST, 0); }
		public TypePrefixBroadcastContext(TypePrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterTypePrefixBroadcast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitTypePrefixBroadcast(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitTypePrefixBroadcast(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypePrefixMetaContext extends TypePrefixContext {
		public TerminalNode TYPE_PREFIX_META() { return getToken(UtaLanguageParser.TYPE_PREFIX_META, 0); }
		public TypePrefixMetaContext(TypePrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterTypePrefixMeta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitTypePrefixMeta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitTypePrefixMeta(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypePrefixConstantContext extends TypePrefixContext {
		public TerminalNode TYPE_PREFIX_CONST() { return getToken(UtaLanguageParser.TYPE_PREFIX_CONST, 0); }
		public TypePrefixConstantContext(TypePrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterTypePrefixConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitTypePrefixConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitTypePrefixConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypePrefixContext typePrefix() throws RecognitionException {
		TypePrefixContext _localctx = new TypePrefixContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_typePrefix);
		try {
			setState(567);
			switch (_input.LA(1)) {
			case TYPE_PREFIX_URGENT:
				_localctx = new TypePrefixUrgentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(563);
				match(TYPE_PREFIX_URGENT);
				}
				break;
			case TYPE_PREFIX_BROADCAST:
				_localctx = new TypePrefixBroadcastContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(564);
				match(TYPE_PREFIX_BROADCAST);
				}
				break;
			case TYPE_PREFIX_META:
				_localctx = new TypePrefixMetaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(565);
				match(TYPE_PREFIX_META);
				}
				break;
			case TYPE_PREFIX_CONST:
				_localctx = new TypePrefixConstantContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(566);
				match(TYPE_PREFIX_CONST);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 20:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 41);
		case 1:
			return precpred(_ctx, 40);
		case 2:
			return precpred(_ctx, 39);
		case 3:
			return precpred(_ctx, 38);
		case 4:
			return precpred(_ctx, 37);
		case 5:
			return precpred(_ctx, 36);
		case 6:
			return precpred(_ctx, 35);
		case 7:
			return precpred(_ctx, 34);
		case 8:
			return precpred(_ctx, 33);
		case 9:
			return precpred(_ctx, 32);
		case 10:
			return precpred(_ctx, 31);
		case 11:
			return precpred(_ctx, 30);
		case 12:
			return precpred(_ctx, 29);
		case 13:
			return precpred(_ctx, 28);
		case 14:
			return precpred(_ctx, 27);
		case 15:
			return precpred(_ctx, 26);
		case 16:
			return precpred(_ctx, 25);
		case 17:
			return precpred(_ctx, 24);
		case 18:
			return precpred(_ctx, 23);
		case 19:
			return precpred(_ctx, 22);
		case 20:
			return precpred(_ctx, 21);
		case 21:
			return precpred(_ctx, 20);
		case 22:
			return precpred(_ctx, 16);
		case 23:
			return precpred(_ctx, 15);
		case 24:
			return precpred(_ctx, 14);
		case 25:
			return precpred(_ctx, 13);
		case 26:
			return precpred(_ctx, 12);
		case 27:
			return precpred(_ctx, 11);
		case 28:
			return precpred(_ctx, 10);
		case 29:
			return precpred(_ctx, 9);
		case 30:
			return precpred(_ctx, 8);
		case 31:
			return precpred(_ctx, 7);
		case 32:
			return precpred(_ctx, 6);
		case 33:
			return precpred(_ctx, 50);
		case 34:
			return precpred(_ctx, 49);
		case 35:
			return precpred(_ctx, 47);
		case 36:
			return precpred(_ctx, 45);
		case 37:
			return precpred(_ctx, 17);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3S\u023c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\2\3\2\3\2\5\2G\n\2\3\3\3\3\3\3\7\3L\n\3\f\3\16\3O\13\3\3\4"+
		"\3\4\3\4\3\4\3\5\5\5V\n\5\3\5\5\5Y\n\5\3\5\5\5\\\n\5\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\7\7e\n\7\f\7\16\7h\13\7\3\b\3\b\3\b\7\bm\n\b\f\b\16\bp\13\b"+
		"\3\t\3\t\3\t\3\t\3\t\7\tw\n\t\f\t\16\tz\13\t\3\t\3\t\3\n\6\n\177\n\n\r"+
		"\n\16\n\u0080\3\13\3\13\3\13\3\13\7\13\u0087\n\13\f\13\16\13\u008a\13"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0093\n\13\f\13\16\13\u0096"+
		"\13\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a3"+
		"\n\13\3\13\5\13\u00a6\n\13\3\13\3\13\3\13\3\13\5\13\u00ac\n\13\3\13\3"+
		"\13\5\13\u00b0\n\13\3\f\3\f\3\f\6\f\u00b5\n\f\r\f\16\f\u00b6\3\r\3\r\3"+
		"\r\7\r\u00bc\n\r\f\r\16\r\u00bf\13\r\3\16\3\16\3\16\5\16\u00c4\n\16\3"+
		"\17\3\17\3\17\5\17\u00c9\n\17\3\20\3\20\3\20\3\20\3\20\7\20\u00d0\n\20"+
		"\f\20\16\20\u00d3\13\20\3\20\3\20\5\20\u00d7\n\20\3\21\3\21\3\21\3\21"+
		"\5\21\u00dd\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00e6\n\21\3"+
		"\21\3\21\5\21\u00ea\n\21\3\22\3\22\5\22\u00ee\n\22\3\22\5\22\u00f1\n\22"+
		"\3\22\3\22\3\23\6\23\u00f6\n\23\r\23\16\23\u00f7\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0123\n\24\3\24\3\24"+
		"\5\24\u0127\n\24\3\24\3\24\5\24\u012b\n\24\3\25\3\25\3\25\7\25\u0130\n"+
		"\25\f\25\16\25\u0133\13\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26"+
		"\u0159\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u01d0\n\26\3\26\7\26\u01d3\n"+
		"\26\f\26\16\26\u01d6\13\26\3\27\3\27\3\27\7\27\u01db\n\27\f\27\16\27\u01de"+
		"\13\27\3\30\3\30\5\30\u01e2\n\30\3\30\3\30\3\31\3\31\3\31\7\31\u01e9\n"+
		"\31\f\31\16\31\u01ec\13\31\3\32\5\32\u01ef\n\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\6\33\u0206\n\33\r\33\16\33\u0207\3\33\3\33\3\33\5\33\u020d"+
		"\n\33\3\34\3\34\3\34\3\34\3\34\6\34\u0214\n\34\r\34\16\34\u0215\3\35\3"+
		"\35\3\35\3\35\7\35\u021c\n\35\f\35\16\35\u021f\13\35\3\35\3\35\3\36\3"+
		"\36\6\36\u0225\n\36\r\36\16\36\u0226\3\36\5\36\u022a\n\36\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\5\37\u0234\n\37\3 \3 \3 \3 \5 \u023a\n \3"+
		" \2\3*!\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:"+
		"<>\2\3\4\2\66\66AA\u028d\2F\3\2\2\2\4H\3\2\2\2\6P\3\2\2\2\bU\3\2\2\2\n"+
		"]\3\2\2\2\fa\3\2\2\2\16i\3\2\2\2\20q\3\2\2\2\22~\3\2\2\2\24\u00af\3\2"+
		"\2\2\26\u00b1\3\2\2\2\30\u00b8\3\2\2\2\32\u00c3\3\2\2\2\34\u00c5\3\2\2"+
		"\2\36\u00d6\3\2\2\2 \u00e9\3\2\2\2\"\u00eb\3\2\2\2$\u00f5\3\2\2\2&\u012a"+
		"\3\2\2\2(\u012c\3\2\2\2*\u0158\3\2\2\2,\u01d7\3\2\2\2.\u01df\3\2\2\2\60"+
		"\u01e5\3\2\2\2\62\u01ee\3\2\2\2\64\u020c\3\2\2\2\66\u020e\3\2\2\28\u0217"+
		"\3\2\2\2:\u0229\3\2\2\2<\u0233\3\2\2\2>\u0239\3\2\2\2@A\5*\26\2AB\7\66"+
		"\2\2BG\3\2\2\2CD\5*\26\2DE\7\67\2\2EG\3\2\2\2F@\3\2\2\2FC\3\2\2\2G\3\3"+
		"\2\2\2HM\5\6\4\2IJ\7>\2\2JL\5\6\4\2KI\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3"+
		"\2\2\2N\5\3\2\2\2OM\3\2\2\2PQ\7R\2\2QR\7\61\2\2RS\5\62\32\2S\7\3\2\2\2"+
		"TV\5\22\n\2UT\3\2\2\2UV\3\2\2\2VX\3\2\2\2WY\5\n\6\2XW\3\2\2\2XY\3\2\2"+
		"\2Y[\3\2\2\2Z\\\5\20\t\2[Z\3\2\2\2[\\\3\2\2\2\\\t\3\2\2\2]^\7P\2\2^_\5"+
		"\f\7\2_`\7?\2\2`\13\3\2\2\2af\5\16\b\2bc\7\65\2\2ce\5\16\b\2db\3\2\2\2"+
		"eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\r\3\2\2\2hf\3\2\2\2in\7R\2\2jk\7>\2\2"+
		"km\7R\2\2lj\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\17\3\2\2\2pn\3\2\2"+
		"\2qr\7Q\2\2rx\78\2\2st\5*\26\2tu\7?\2\2uw\3\2\2\2vs\3\2\2\2wz\3\2\2\2"+
		"xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\79\2\2|\21\3\2\2\2}\177\5\24"+
		"\13\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\23\3\2\2\2\u0082\u0083\5\62\32\2\u0083\u0088\5\34\17\2\u0084\u0085\7"+
		">\2\2\u0085\u0087\5\34\17\2\u0086\u0084\3\2\2\2\u0087\u008a\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0088\3\2"+
		"\2\2\u008b\u008c\7?\2\2\u008c\u00b0\3\2\2\2\u008d\u008e\7G\2\2\u008e\u008f"+
		"\5\62\32\2\u008f\u0094\5:\36\2\u0090\u0091\7>\2\2\u0091\u0093\5:\36\2"+
		"\u0092\u0090\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095"+
		"\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0098\7?\2\2\u0098"+
		"\u00b0\3\2\2\2\u0099\u00b0\5 \21\2\u009a\u009b\7\b\2\2\u009b\u009c\7N"+
		"\2\2\u009c\u009d\5\26\f\2\u009d\u009e\7?\2\2\u009e\u00b0\3\2\2\2\u009f"+
		"\u00a5\7R\2\2\u00a0\u00a2\7<\2\2\u00a1\u00a3\5,\27\2\u00a2\u00a1\3\2\2"+
		"\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\7=\2\2\u00a5\u00a0"+
		"\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\7\23\2\2"+
		"\u00a8\u00a9\7R\2\2\u00a9\u00ab\7<\2\2\u00aa\u00ac\5\60\31\2\u00ab\u00aa"+
		"\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7=\2\2\u00ae"+
		"\u00b0\7?\2\2\u00af\u0082\3\2\2\2\u00af\u008d\3\2\2\2\u00af\u0099\3\2"+
		"\2\2\u00af\u009a\3\2\2\2\u00af\u009f\3\2\2\2\u00b0\25\3\2\2\2\u00b1\u00b4"+
		"\5\30\r\2\u00b2\u00b3\7\65\2\2\u00b3\u00b5\5\30\r\2\u00b4\u00b2\3\2\2"+
		"\2\u00b5\u00b6\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\27"+
		"\3\2\2\2\u00b8\u00bd\5\32\16\2\u00b9\u00ba\7>\2\2\u00ba\u00bc\5\32\16"+
		"\2\u00bb\u00b9\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be"+
		"\3\2\2\2\u00be\31\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c4\7O\2\2\u00c1"+
		"\u00c4\5\66\34\2\u00c2\u00c4\7R\2\2\u00c3\u00c0\3\2\2\2\u00c3\u00c1\3"+
		"\2\2\2\u00c3\u00c2\3\2\2\2\u00c4\33\3\2\2\2\u00c5\u00c8\5:\36\2\u00c6"+
		"\u00c7\7\23\2\2\u00c7\u00c9\5\36\20\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9"+
		"\3\2\2\2\u00c9\35\3\2\2\2\u00ca\u00d7\5*\26\2\u00cb\u00cc\78\2\2\u00cc"+
		"\u00d1\5\36\20\2\u00cd\u00ce\7>\2\2\u00ce\u00d0\5\36\20\2\u00cf\u00cd"+
		"\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00d4\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d5\79\2\2\u00d5\u00d7\3\2"+
		"\2\2\u00d6\u00ca\3\2\2\2\u00d6\u00cb\3\2\2\2\u00d7\37\3\2\2\2\u00d8\u00d9"+
		"\5\62\32\2\u00d9\u00da\7R\2\2\u00da\u00dc\7<\2\2\u00db\u00dd\5,\27\2\u00dc"+
		"\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\7="+
		"\2\2\u00df\u00e0\5\"\22\2\u00e0\u00ea\3\2\2\2\u00e1\u00e2\7@\2\2\u00e2"+
		"\u00e3\7R\2\2\u00e3\u00e5\7<\2\2\u00e4\u00e6\5,\27\2\u00e5\u00e4\3\2\2"+
		"\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\7=\2\2\u00e8\u00ea"+
		"\5\"\22\2\u00e9\u00d8\3\2\2\2\u00e9\u00e1\3\2\2\2\u00ea!\3\2\2\2\u00eb"+
		"\u00ed\78\2\2\u00ec\u00ee\5\22\n\2\u00ed\u00ec\3\2\2\2\u00ed\u00ee\3\2"+
		"\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00f1\5$\23\2\u00f0\u00ef\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\79\2\2\u00f3#\3\2\2\2\u00f4"+
		"\u00f6\5&\24\2\u00f5\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f5\3\2"+
		"\2\2\u00f7\u00f8\3\2\2\2\u00f8%\3\2\2\2\u00f9\u012b\5\"\22\2\u00fa\u00fb"+
		"\5*\26\2\u00fb\u00fc\7?\2\2\u00fc\u012b\3\2\2\2\u00fd\u00fe\7J\2\2\u00fe"+
		"\u00ff\7<\2\2\u00ff\u0100\5*\26\2\u0100\u0101\7?\2\2\u0101\u0102\5*\26"+
		"\2\u0102\u0103\7?\2\2\u0103\u0104\5*\26\2\u0104\u0105\7=\2\2\u0105\u0106"+
		"\5&\24\2\u0106\u012b\3\2\2\2\u0107\u0108\7J\2\2\u0108\u0109\7<\2\2\u0109"+
		"\u010a\7R\2\2\u010a\u010b\7\61\2\2\u010b\u010c\5\62\32\2\u010c\u010d\7"+
		"=\2\2\u010d\u010e\5&\24\2\u010e\u012b\3\2\2\2\u010f\u0110\7K\2\2\u0110"+
		"\u0111\7<\2\2\u0111\u0112\5*\26\2\u0112\u0113\7=\2\2\u0113\u0114\5&\24"+
		"\2\u0114\u012b\3\2\2\2\u0115\u0116\7M\2\2\u0116\u0117\5&\24\2\u0117\u0118"+
		"\7K\2\2\u0118\u0119\5*\26\2\u0119\u011a\7?\2\2\u011a\u012b\3\2\2\2\u011b"+
		"\u011c\7H\2\2\u011c\u011d\7<\2\2\u011d\u011e\5*\26\2\u011e\u011f\7=\2"+
		"\2\u011f\u0122\5&\24\2\u0120\u0121\7I\2\2\u0121\u0123\5&\24\2\u0122\u0120"+
		"\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u012b\3\2\2\2\u0124\u0126\7L\2\2\u0125"+
		"\u0127\5*\26\2\u0126\u0125\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128\3\2"+
		"\2\2\u0128\u012b\7?\2\2\u0129\u012b\7?\2\2\u012a\u00f9\3\2\2\2\u012a\u00fa"+
		"\3\2\2\2\u012a\u00fd\3\2\2\2\u012a\u0107\3\2\2\2\u012a\u010f\3\2\2\2\u012a"+
		"\u0115\3\2\2\2\u012a\u011b\3\2\2\2\u012a\u0124\3\2\2\2\u012a\u0129\3\2"+
		"\2\2\u012b\'\3\2\2\2\u012c\u0131\5*\26\2\u012d\u012e\7>\2\2\u012e\u0130"+
		"\5*\26\2\u012f\u012d\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132)\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0135\b\26\1\2"+
		"\u0135\u0136\t\2\2\2\u0136\u0159\5*\26\62\u0137\u0138\7/\2\2\u0138\u0159"+
		"\5*\26\60\u0139\u013a\7\60\2\2\u013a\u0159\5*\26.\u013b\u013c\7\63\2\2"+
		"\u013c\u0159\5*\26-\u013d\u013e\7\62\2\2\u013e\u0159\5*\26,\u013f\u0140"+
		"\7E\2\2\u0140\u0141\7<\2\2\u0141\u0142\7R\2\2\u0142\u0143\7\61\2\2\u0143"+
		"\u0144\5\62\32\2\u0144\u0145\7=\2\2\u0145\u0146\5*\26\25\u0146\u0159\3"+
		"\2\2\2\u0147\u0148\7F\2\2\u0148\u0149\7<\2\2\u0149\u014a\7R\2\2\u014a"+
		"\u014b\7\61\2\2\u014b\u014c\5\62\32\2\u014c\u014d\7=\2\2\u014d\u014e\5"+
		"*\26\24\u014e\u0159\3\2\2\2\u014f\u0150\7<\2\2\u0150\u0151\5*\26\2\u0151"+
		"\u0152\7=\2\2\u0152\u0159\3\2\2\2\u0153\u0159\7\22\2\2\u0154\u0159\7\20"+
		"\2\2\u0155\u0159\7\21\2\2\u0156\u0159\7S\2\2\u0157\u0159\7R\2\2\u0158"+
		"\u0134\3\2\2\2\u0158\u0137\3\2\2\2\u0158\u0139\3\2\2\2\u0158\u013b\3\2"+
		"\2\2\u0158\u013d\3\2\2\2\u0158\u013f\3\2\2\2\u0158\u0147\3\2\2\2\u0158"+
		"\u014f\3\2\2\2\u0158\u0153\3\2\2\2\u0158\u0154\3\2\2\2\u0158\u0155\3\2"+
		"\2\2\u0158\u0156\3\2\2\2\u0158\u0157\3\2\2\2\u0159\u01d4\3\2\2\2\u015a"+
		"\u015b\f+\2\2\u015b\u015c\7\'\2\2\u015c\u01d3\5*\26,\u015d\u015e\f*\2"+
		"\2\u015e\u015f\7(\2\2\u015f\u01d3\5*\26+\u0160\u0161\f)\2\2\u0161\u0162"+
		"\7)\2\2\u0162\u01d3\5*\26*\u0163\u0164\f(\2\2\u0164\u0165\7\63\2\2\u0165"+
		"\u01d3\5*\26)\u0166\u0167\f\'\2\2\u0167\u0168\7\62\2\2\u0168\u01d3\5*"+
		"\26(\u0169\u016a\f&\2\2\u016a\u016b\7\"\2\2\u016b\u01d3\5*\26\'\u016c"+
		"\u016d\f%\2\2\u016d\u016e\7#\2\2\u016e\u01d3\5*\26&\u016f\u0170\f$\2\2"+
		"\u0170\u0171\7+\2\2\u0171\u01d3\5*\26%\u0172\u0173\f#\2\2\u0173\u0174"+
		"\7,\2\2\u0174\u01d3\5*\26$\u0175\u0176\f\"\2\2\u0176\u0177\7\65\2\2\u0177"+
		"\u01d3\5*\26#\u0178\u0179\f!\2\2\u0179\u017a\7\36\2\2\u017a\u01d3\5*\26"+
		"\"\u017b\u017c\f \2\2\u017c\u017d\7-\2\2\u017d\u01d3\5*\26!\u017e\u017f"+
		"\f\37\2\2\u017f\u0180\7\37\2\2\u0180\u01d3\5*\26 \u0181\u0182\f\36\2\2"+
		"\u0182\u0183\7 \2\2\u0183\u01d3\5*\26\37\u0184\u0185\f\35\2\2\u0185\u0186"+
		"\7!\2\2\u0186\u01d3\5*\26\36\u0187\u0188\f\34\2\2\u0188\u0189\7\64\2\2"+
		"\u0189\u01d3\5*\26\35\u018a\u018b\f\33\2\2\u018b\u018c\7*\2\2\u018c\u01d3"+
		"\5*\26\34\u018d\u018e\f\32\2\2\u018e\u018f\7&\2\2\u018f\u01d3\5*\26\33"+
		"\u0190\u0191\f\31\2\2\u0191\u0192\7$\2\2\u0192\u01d3\5*\26\32\u0193\u0194"+
		"\f\30\2\2\u0194\u0195\7%\2\2\u0195\u01d3\5*\26\31\u0196\u0197\f\27\2\2"+
		"\u0197\u0198\7\67\2\2\u0198\u0199\5*\26\2\u0199\u019a\7\61\2\2\u019a\u019b"+
		"\5*\26\27\u019b\u01d3\3\2\2\2\u019c\u019d\f\26\2\2\u019d\u019e\7D\2\2"+
		"\u019e\u01d3\5*\26\27\u019f\u01a0\f\22\2\2\u01a0\u01a1\7\23\2\2\u01a1"+
		"\u01d3\5*\26\22\u01a2\u01a3\f\21\2\2\u01a3\u01a4\7\26\2\2\u01a4\u01d3"+
		"\5*\26\22\u01a5\u01a6\f\20\2\2\u01a6\u01a7\7\27\2\2\u01a7\u01d3\5*\26"+
		"\21\u01a8\u01a9\f\17\2\2\u01a9\u01aa\7\30\2\2\u01aa\u01d3\5*\26\20\u01ab"+
		"\u01ac\f\16\2\2\u01ac\u01ad\7\24\2\2\u01ad\u01d3\5*\26\17\u01ae\u01af"+
		"\f\r\2\2\u01af\u01b0\7\25\2\2\u01b0\u01d3\5*\26\16\u01b1\u01b2\f\f\2\2"+
		"\u01b2\u01b3\7\34\2\2\u01b3\u01d3\5*\26\r\u01b4\u01b5\f\13\2\2\u01b5\u01b6"+
		"\7\35\2\2\u01b6\u01d3\5*\26\f\u01b7\u01b8\f\n\2\2\u01b8\u01b9\7\32\2\2"+
		"\u01b9\u01d3\5*\26\13\u01ba\u01bb\f\t\2\2\u01bb\u01bc\7\33\2\2\u01bc\u01d3"+
		"\5*\26\n\u01bd\u01be\f\b\2\2\u01be\u01bf\7\31\2\2\u01bf\u01d3\5*\26\t"+
		"\u01c0\u01c1\f\64\2\2\u01c1\u01c2\7:\2\2\u01c2\u01c3\5*\26\2\u01c3\u01c4"+
		"\7;\2\2\u01c4\u01d3\3\2\2\2\u01c5\u01c6\f\63\2\2\u01c6\u01c7\7.\2\2\u01c7"+
		"\u01d3\7R\2\2\u01c8\u01c9\f\61\2\2\u01c9\u01d3\7/\2\2\u01ca\u01cb\f/\2"+
		"\2\u01cb\u01d3\7\60\2\2\u01cc\u01cd\f\23\2\2\u01cd\u01cf\7<\2\2\u01ce"+
		"\u01d0\5\60\31\2\u01cf\u01ce\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d1\3"+
		"\2\2\2\u01d1\u01d3\7=\2\2\u01d2\u015a\3\2\2\2\u01d2\u015d\3\2\2\2\u01d2"+
		"\u0160\3\2\2\2\u01d2\u0163\3\2\2\2\u01d2\u0166\3\2\2\2\u01d2\u0169\3\2"+
		"\2\2\u01d2\u016c\3\2\2\2\u01d2\u016f\3\2\2\2\u01d2\u0172\3\2\2\2\u01d2"+
		"\u0175\3\2\2\2\u01d2\u0178\3\2\2\2\u01d2\u017b\3\2\2\2\u01d2\u017e\3\2"+
		"\2\2\u01d2\u0181\3\2\2\2\u01d2\u0184\3\2\2\2\u01d2\u0187\3\2\2\2\u01d2"+
		"\u018a\3\2\2\2\u01d2\u018d\3\2\2\2\u01d2\u0190\3\2\2\2\u01d2\u0193\3\2"+
		"\2\2\u01d2\u0196\3\2\2\2\u01d2\u019c\3\2\2\2\u01d2\u019f\3\2\2\2\u01d2"+
		"\u01a2\3\2\2\2\u01d2\u01a5\3\2\2\2\u01d2\u01a8\3\2\2\2\u01d2\u01ab\3\2"+
		"\2\2\u01d2\u01ae\3\2\2\2\u01d2\u01b1\3\2\2\2\u01d2\u01b4\3\2\2\2\u01d2"+
		"\u01b7\3\2\2\2\u01d2\u01ba\3\2\2\2\u01d2\u01bd\3\2\2\2\u01d2\u01c0\3\2"+
		"\2\2\u01d2\u01c5\3\2\2\2\u01d2\u01c8\3\2\2\2\u01d2\u01ca\3\2\2\2\u01d2"+
		"\u01cc\3\2\2\2\u01d3\u01d6\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d4\u01d5\3\2"+
		"\2\2\u01d5+\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d7\u01dc\5.\30\2\u01d8\u01d9"+
		"\7>\2\2\u01d9\u01db\5.\30\2\u01da\u01d8\3\2\2\2\u01db\u01de\3\2\2\2\u01dc"+
		"\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd-\3\2\2\2\u01de\u01dc\3\2\2\2"+
		"\u01df\u01e1\5\62\32\2\u01e0\u01e2\7\64\2\2\u01e1\u01e0\3\2\2\2\u01e1"+
		"\u01e2\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e4\5:\36\2\u01e4/\3\2\2\2"+
		"\u01e5\u01ea\5*\26\2\u01e6\u01e7\7>\2\2\u01e7\u01e9\5*\26\2\u01e8\u01e6"+
		"\3\2\2\2\u01e9\u01ec\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb"+
		"\61\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ed\u01ef\5> \2\u01ee\u01ed\3\2\2\2"+
		"\u01ee\u01ef\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01f1\5\64\33\2\u01f1\63"+
		"\3\2\2\2\u01f2\u020d\7\6\2\2\u01f3\u020d\7\7\2\2\u01f4\u020d\7\b\2\2\u01f5"+
		"\u020d\7\t\2\2\u01f6\u01f7\7\6\2\2\u01f7\u01f8\7:\2\2\u01f8\u01f9\5*\26"+
		"\2\u01f9\u01fa\7>\2\2\u01fa\u01fb\5*\26\2\u01fb\u01fc\7;\2\2\u01fc\u020d"+
		"\3\2\2\2\u01fd\u01fe\7\n\2\2\u01fe\u01ff\7:\2\2\u01ff\u0200\5*\26\2\u0200"+
		"\u0201\7;\2\2\u0201\u020d\3\2\2\2\u0202\u0203\7\13\2\2\u0203\u0205\78"+
		"\2\2\u0204\u0206\58\35\2\u0205\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207"+
		"\u0205\3\2\2\2\u0207\u0208\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020a\79"+
		"\2\2\u020a\u020d\3\2\2\2\u020b\u020d\7R\2\2\u020c\u01f2\3\2\2\2\u020c"+
		"\u01f3\3\2\2\2\u020c\u01f4\3\2\2\2\u020c\u01f5\3\2\2\2\u020c\u01f6\3\2"+
		"\2\2\u020c\u01fd\3\2\2\2\u020c\u0202\3\2\2\2\u020c\u020b\3\2\2\2\u020d"+
		"\65\3\2\2\2\u020e\u0213\7R\2\2\u020f\u0210\7:\2\2\u0210\u0211\5*\26\2"+
		"\u0211\u0212\7;\2\2\u0212\u0214\3\2\2\2\u0213\u020f\3\2\2\2\u0214\u0215"+
		"\3\2\2\2\u0215\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216\67\3\2\2\2\u0217"+
		"\u0218\5\62\32\2\u0218\u021d\5:\36\2\u0219\u021a\7>\2\2\u021a\u021c\5"+
		":\36\2\u021b\u0219\3\2\2\2\u021c\u021f\3\2\2\2\u021d\u021b\3\2\2\2\u021d"+
		"\u021e\3\2\2\2\u021e\u0220\3\2\2\2\u021f\u021d\3\2\2\2\u0220\u0221\7?"+
		"\2\2\u02219\3\2\2\2\u0222\u0224\7R\2\2\u0223\u0225\5<\37\2\u0224\u0223"+
		"\3\2\2\2\u0225\u0226\3\2\2\2\u0226\u0224\3\2\2\2\u0226\u0227\3\2\2\2\u0227"+
		"\u022a\3\2\2\2\u0228\u022a\7R\2\2\u0229\u0222\3\2\2\2\u0229\u0228\3\2"+
		"\2\2\u022a;\3\2\2\2\u022b\u022c\7:\2\2\u022c\u022d\5*\26\2\u022d\u022e"+
		"\7;\2\2\u022e\u0234\3\2\2\2\u022f\u0230\7:\2\2\u0230\u0231\5\62\32\2\u0231"+
		"\u0232\7;\2\2\u0232\u0234\3\2\2\2\u0233\u022b\3\2\2\2\u0233\u022f\3\2"+
		"\2\2\u0234=\3\2\2\2\u0235\u023a\7\f\2\2\u0236\u023a\7\r\2\2\u0237\u023a"+
		"\7\16\2\2\u0238\u023a\7\17\2\2\u0239\u0235\3\2\2\2\u0239\u0236\3\2\2\2"+
		"\u0239\u0237\3\2\2\2\u0239\u0238\3\2\2\2\u023a?\3\2\2\2\61FMUX[fnx\u0080"+
		"\u0088\u0094\u00a2\u00a5\u00ab\u00af\u00b6\u00bd\u00c3\u00c8\u00d1\u00d6"+
		"\u00dc\u00e5\u00e9\u00ed\u00f0\u00f7\u0122\u0126\u012a\u0131\u0158\u01cf"+
		"\u01d2\u01d4\u01dc\u01e1\u01ea\u01ee\u0207\u020c\u0215\u021d\u0226\u0229"+
		"\u0233\u0239";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}