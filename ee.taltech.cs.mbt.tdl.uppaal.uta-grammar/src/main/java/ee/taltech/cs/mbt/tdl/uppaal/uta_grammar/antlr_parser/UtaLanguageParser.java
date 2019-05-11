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
		RULE_parameterSequence = 21, RULE_parameter = 22, RULE_referenceModifier = 23, 
		RULE_argumentSequence = 24, RULE_type = 25, RULE_typeIdentifier = 26, 
		RULE_arrayVariableLookup = 27, RULE_fieldDeclaration = 28, RULE_identifierDeclaration = 29, 
		RULE_arraySizeModifier = 30, RULE_typePrefix = 31;
	public static final String[] ruleNames = {
		"synchronization", "selectionSequence", "selection", "systemDefinition", 
		"systemLine", "systemProcessSequence", "systemProcessGroup", "progressMeasureDeclaration", 
		"declarationSequence", "declaration", "channelPrioritySequence", "channelPriorityGroup", 
		"channelReference", "variableInitialization", "initializerExpression", 
		"declarationOfFunction", "statementBlock", "statementSequence", "statement", 
		"expressionSequence", "expression", "parameterSequence", "parameter", 
		"referenceModifier", "argumentSequence", "type", "typeIdentifier", "arrayVariableLookup", 
		"fieldDeclaration", "identifierDeclaration", "arraySizeModifier", "typePrefix"
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
			setState(70);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new ActiveSynchronizationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				expression(0);
				setState(65);
				match(COMMON_TOK_EXCLAMATION_MARK);
				}
				break;
			case 2:
				_localctx = new ReactiveSynchronizationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				expression(0);
				setState(68);
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
			setState(72);
			selection();
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(73);
				match(SEP_ENUMERATION);
				setState(74);
				selection();
				}
				}
				setState(79);
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
			setState(80);
			match(IDENTIFIER_NAME);
			setState(81);
			match(COMMON_TOK_COLON);
			setState(82);
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
			setState(85);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INTEGER) | (1L << TYPE_CLOCK) | (1L << TYPE_CHANNEL) | (1L << TYPE_BOOLEAN) | (1L << TYPE_SCALAR) | (1L << TYPE_STRUCT) | (1L << TYPE_PREFIX_URGENT) | (1L << TYPE_PREFIX_BROADCAST) | (1L << TYPE_PREFIX_META) | (1L << TYPE_PREFIX_CONST) | (1L << PHRASE_VOID))) != 0) || _la==PHRASE_TYPEDEF || _la==IDENTIFIER_NAME) {
				{
				setState(84);
				declarationSequence();
				}
			}

			setState(88);
			_la = _input.LA(1);
			if (_la==PHRASE_SYSTEM) {
				{
				setState(87);
				systemLine();
				}
			}

			setState(91);
			_la = _input.LA(1);
			if (_la==PHRASE_PROGRESS) {
				{
				setState(90);
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
			setState(93);
			match(PHRASE_SYSTEM);
			setState(94);
			systemProcessSequence();
			setState(95);
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
			setState(97);
			systemProcessGroup();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMON_TOK_LESS_THAN) {
				{
				{
				setState(98);
				match(COMMON_TOK_LESS_THAN);
				setState(99);
				systemProcessGroup();
				}
				}
				setState(104);
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
			setState(105);
			match(IDENTIFIER_NAME);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(106);
				match(SEP_ENUMERATION);
				setState(107);
				match(IDENTIFIER_NAME);
				}
				}
				setState(112);
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
			setState(113);
			match(PHRASE_PROGRESS);
			setState(114);
			match(GROUP_LEFT_CURLY);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPR_LITERAL_TRUE) | (1L << EXPR_LITERAL_FALSE) | (1L << EXPR_LITERAL_DEADLOCK) | (1L << UNARY_OP_INCREMENT) | (1L << UNARY_OP_DECREMENT) | (1L << COMMON_TOK_PLUS) | (1L << COMMON_TOK_MINUS) | (1L << COMMON_TOK_EXCLAMATION_MARK) | (1L << GROUP_LEFT_PAREN) | (1L << PHRASE_NOT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (PHRASE_FOR_ALL - 67)) | (1L << (PHRASE_EXISTS - 67)) | (1L << (IDENTIFIER_NAME - 67)) | (1L << (NATURAL_NUMBER - 67)))) != 0)) {
				{
				{
				setState(115);
				expression(0);
				setState(116);
				match(SEP_SEMICOLON);
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(123);
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
			setState(126); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(125);
					declaration();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(128); 
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
			setState(175);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new VariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				type();
				setState(131);
				variableInitialization();
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP_ENUMERATION) {
					{
					{
					setState(132);
					match(SEP_ENUMERATION);
					setState(133);
					variableInitialization();
					}
					}
					setState(138);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(139);
				match(SEP_SEMICOLON);
				}
				break;
			case 2:
				_localctx = new TypeDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(PHRASE_TYPEDEF);
				setState(142);
				type();
				setState(143);
				identifierDeclaration();
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP_ENUMERATION) {
					{
					{
					setState(144);
					match(SEP_ENUMERATION);
					setState(145);
					identifierDeclaration();
					}
					}
					setState(150);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(151);
				match(SEP_SEMICOLON);
				}
				break;
			case 3:
				_localctx = new FunctionDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				declarationOfFunction();
				}
				break;
			case 4:
				_localctx = new ChannelPriorityDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
				match(TYPE_CHANNEL);
				setState(155);
				match(PHRASE_PRIORITY);
				setState(156);
				channelPrioritySequence();
				setState(157);
				match(SEP_SEMICOLON);
				}
				break;
			case 5:
				_localctx = new TemplateInstantiationContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(159);
				match(IDENTIFIER_NAME);
				setState(165);
				_la = _input.LA(1);
				if (_la==GROUP_LEFT_PAREN) {
					{
					setState(160);
					match(GROUP_LEFT_PAREN);
					setState(162);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INTEGER) | (1L << TYPE_CLOCK) | (1L << TYPE_CHANNEL) | (1L << TYPE_BOOLEAN) | (1L << TYPE_SCALAR) | (1L << TYPE_STRUCT) | (1L << TYPE_PREFIX_URGENT) | (1L << TYPE_PREFIX_BROADCAST) | (1L << TYPE_PREFIX_META) | (1L << TYPE_PREFIX_CONST))) != 0) || _la==IDENTIFIER_NAME) {
						{
						setState(161);
						parameterSequence();
						}
					}

					setState(164);
					match(GROUP_RIGHT_PAREN);
					}
				}

				setState(167);
				match(ASSG_OP);
				setState(168);
				match(IDENTIFIER_NAME);
				setState(169);
				match(GROUP_LEFT_PAREN);
				setState(171);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPR_LITERAL_TRUE) | (1L << EXPR_LITERAL_FALSE) | (1L << EXPR_LITERAL_DEADLOCK) | (1L << UNARY_OP_INCREMENT) | (1L << UNARY_OP_DECREMENT) | (1L << COMMON_TOK_PLUS) | (1L << COMMON_TOK_MINUS) | (1L << COMMON_TOK_EXCLAMATION_MARK) | (1L << GROUP_LEFT_PAREN) | (1L << PHRASE_NOT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (PHRASE_FOR_ALL - 67)) | (1L << (PHRASE_EXISTS - 67)) | (1L << (IDENTIFIER_NAME - 67)) | (1L << (NATURAL_NUMBER - 67)))) != 0)) {
					{
					setState(170);
					argumentSequence();
					}
				}

				setState(173);
				match(GROUP_RIGHT_PAREN);
				setState(174);
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
			setState(177);
			channelPriorityGroup();
			setState(180); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(178);
				match(COMMON_TOK_LESS_THAN);
				setState(179);
				channelPriorityGroup();
				}
				}
				setState(182); 
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
			setState(184);
			channelReference();
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(185);
				match(SEP_ENUMERATION);
				setState(186);
				channelReference();
				}
				}
				setState(191);
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
	public static class ChannelIdentifierReferenceContext extends ChannelReferenceContext {
		public TerminalNode IDENTIFIER_NAME() { return getToken(UtaLanguageParser.IDENTIFIER_NAME, 0); }
		public ChannelIdentifierReferenceContext(ChannelReferenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterChannelIdentifierReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitChannelIdentifierReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitChannelIdentifierReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChannelReferenceContext channelReference() throws RecognitionException {
		ChannelReferenceContext _localctx = new ChannelReferenceContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_channelReference);
		try {
			setState(195);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new DefaultChannelReferenceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				match(PHRASE_DEFAULT);
				}
				break;
			case 2:
				_localctx = new ChannelArrayLookupContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				arrayVariableLookup();
				}
				break;
			case 3:
				_localctx = new ChannelIdentifierReferenceContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(194);
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
			setState(197);
			identifierDeclaration();
			setState(200);
			_la = _input.LA(1);
			if (_la==ASSG_OP) {
				{
				setState(198);
				match(ASSG_OP);
				setState(199);
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
			setState(214);
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
				setState(202);
				expression(0);
				}
				break;
			case GROUP_LEFT_CURLY:
				_localctx = new StructuredInitializerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				match(GROUP_LEFT_CURLY);
				setState(204);
				initializerExpression();
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP_ENUMERATION) {
					{
					{
					setState(205);
					match(SEP_ENUMERATION);
					setState(206);
					initializerExpression();
					}
					}
					setState(211);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(212);
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
			setState(233);
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
				setState(216);
				type();
				setState(217);
				match(IDENTIFIER_NAME);
				setState(218);
				match(GROUP_LEFT_PAREN);
				setState(220);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INTEGER) | (1L << TYPE_CLOCK) | (1L << TYPE_CHANNEL) | (1L << TYPE_BOOLEAN) | (1L << TYPE_SCALAR) | (1L << TYPE_STRUCT) | (1L << TYPE_PREFIX_URGENT) | (1L << TYPE_PREFIX_BROADCAST) | (1L << TYPE_PREFIX_META) | (1L << TYPE_PREFIX_CONST))) != 0) || _la==IDENTIFIER_NAME) {
					{
					setState(219);
					parameterSequence();
					}
				}

				setState(222);
				match(GROUP_RIGHT_PAREN);
				setState(223);
				statementBlock();
				}
				break;
			case PHRASE_VOID:
				_localctx = new VoidFunctionDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				match(PHRASE_VOID);
				setState(226);
				match(IDENTIFIER_NAME);
				setState(227);
				match(GROUP_LEFT_PAREN);
				setState(229);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INTEGER) | (1L << TYPE_CLOCK) | (1L << TYPE_CHANNEL) | (1L << TYPE_BOOLEAN) | (1L << TYPE_SCALAR) | (1L << TYPE_STRUCT) | (1L << TYPE_PREFIX_URGENT) | (1L << TYPE_PREFIX_BROADCAST) | (1L << TYPE_PREFIX_META) | (1L << TYPE_PREFIX_CONST))) != 0) || _la==IDENTIFIER_NAME) {
					{
					setState(228);
					parameterSequence();
					}
				}

				setState(231);
				match(GROUP_RIGHT_PAREN);
				setState(232);
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
			setState(235);
			match(GROUP_LEFT_CURLY);
			setState(237);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(236);
				declarationSequence();
				}
				break;
			}
			setState(240);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPR_LITERAL_TRUE) | (1L << EXPR_LITERAL_FALSE) | (1L << EXPR_LITERAL_DEADLOCK) | (1L << UNARY_OP_INCREMENT) | (1L << UNARY_OP_DECREMENT) | (1L << COMMON_TOK_PLUS) | (1L << COMMON_TOK_MINUS) | (1L << COMMON_TOK_EXCLAMATION_MARK) | (1L << GROUP_LEFT_CURLY) | (1L << GROUP_LEFT_PAREN) | (1L << SEP_SEMICOLON) | (1L << PHRASE_NOT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (PHRASE_FOR_ALL - 67)) | (1L << (PHRASE_EXISTS - 67)) | (1L << (PHRASE_IF - 67)) | (1L << (PHRASE_FOR - 67)) | (1L << (PHRASE_WHILE - 67)) | (1L << (PHRASE_RETURN - 67)) | (1L << (PHRASE_DO - 67)) | (1L << (IDENTIFIER_NAME - 67)) | (1L << (NATURAL_NUMBER - 67)))) != 0)) {
				{
				setState(239);
				statementSequence();
				}
			}

			setState(242);
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
			setState(245); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(244);
				statement();
				}
				}
				setState(247); 
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
			setState(298);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				statementBlock();
				}
				break;
			case 2:
				_localctx = new ExpressionStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				expression(0);
				setState(251);
				match(SEP_SEMICOLON);
				}
				break;
			case 3:
				_localctx = new ForLoopStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(253);
				match(PHRASE_FOR);
				setState(254);
				match(GROUP_LEFT_PAREN);
				setState(255);
				expression(0);
				setState(256);
				match(SEP_SEMICOLON);
				setState(257);
				expression(0);
				setState(258);
				match(SEP_SEMICOLON);
				setState(259);
				expression(0);
				setState(260);
				match(GROUP_RIGHT_PAREN);
				setState(261);
				statement();
				}
				break;
			case 4:
				_localctx = new IterationStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(263);
				match(PHRASE_FOR);
				setState(264);
				match(GROUP_LEFT_PAREN);
				setState(265);
				match(IDENTIFIER_NAME);
				setState(266);
				match(COMMON_TOK_COLON);
				setState(267);
				type();
				setState(268);
				match(GROUP_RIGHT_PAREN);
				setState(269);
				statement();
				}
				break;
			case 5:
				_localctx = new WhileLoopStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(271);
				match(PHRASE_WHILE);
				setState(272);
				match(GROUP_LEFT_PAREN);
				setState(273);
				expression(0);
				setState(274);
				match(GROUP_RIGHT_PAREN);
				setState(275);
				statement();
				}
				break;
			case 6:
				_localctx = new DoWhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(277);
				match(PHRASE_DO);
				setState(278);
				statement();
				setState(279);
				match(PHRASE_WHILE);
				setState(280);
				expression(0);
				setState(281);
				match(SEP_SEMICOLON);
				}
				break;
			case 7:
				_localctx = new ConditionalStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(283);
				match(PHRASE_IF);
				setState(284);
				match(GROUP_LEFT_PAREN);
				setState(285);
				expression(0);
				setState(286);
				match(GROUP_RIGHT_PAREN);
				setState(287);
				statement();
				setState(290);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(288);
					match(PHRASE_ELSE);
					setState(289);
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
				setState(292);
				match(PHRASE_RETURN);
				setState(294);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPR_LITERAL_TRUE) | (1L << EXPR_LITERAL_FALSE) | (1L << EXPR_LITERAL_DEADLOCK) | (1L << UNARY_OP_INCREMENT) | (1L << UNARY_OP_DECREMENT) | (1L << COMMON_TOK_PLUS) | (1L << COMMON_TOK_MINUS) | (1L << COMMON_TOK_EXCLAMATION_MARK) | (1L << GROUP_LEFT_PAREN) | (1L << PHRASE_NOT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (PHRASE_FOR_ALL - 67)) | (1L << (PHRASE_EXISTS - 67)) | (1L << (IDENTIFIER_NAME - 67)) | (1L << (NATURAL_NUMBER - 67)))) != 0)) {
					{
					setState(293);
					expression(0);
					}
				}

				setState(296);
				match(SEP_SEMICOLON);
				}
				break;
			case 9:
				_localctx = new EmptyStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(297);
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
			setState(300);
			expression(0);
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(301);
				match(SEP_ENUMERATION);
				setState(302);
				expression(0);
				}
				}
				setState(307);
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
		public TerminalNode PHRASE_OR() { return getToken(UtaLanguageParser.PHRASE_OR, 0); }
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
	public static class PostfixIncrementExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode UNARY_OP_INCREMENT() { return getToken(UtaLanguageParser.UNARY_OP_INCREMENT, 0); }
		public PostfixIncrementExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterPostfixIncrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitPostfixIncrementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitPostfixIncrementExpression(this);
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
	public static class PostfixDecrementExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode UNARY_OP_DECREMENT() { return getToken(UtaLanguageParser.UNARY_OP_DECREMENT, 0); }
		public PostfixDecrementExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterPostfixDecrementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitPostfixDecrementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitPostfixDecrementExpression(this);
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
		public TerminalNode PHRASE_AND() { return getToken(UtaLanguageParser.PHRASE_AND, 0); }
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
	public static class QuantificationExpressionContext extends ExpressionContext {
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
		public TerminalNode PHRASE_EXISTS() { return getToken(UtaLanguageParser.PHRASE_EXISTS, 0); }
		public TerminalNode PHRASE_FOR_ALL() { return getToken(UtaLanguageParser.PHRASE_FOR_ALL, 0); }
		public QuantificationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterQuantificationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitQuantificationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitQuantificationExpression(this);
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
			setState(336);
			switch (_input.LA(1)) {
			case COMMON_TOK_EXCLAMATION_MARK:
			case PHRASE_NOT:
				{
				_localctx = new NegationExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(309);
				_la = _input.LA(1);
				if ( !(_la==COMMON_TOK_EXCLAMATION_MARK || _la==PHRASE_NOT) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(310);
				expression(47);
				}
				break;
			case UNARY_OP_INCREMENT:
				{
				_localctx = new PrefixIncrementExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(311);
				match(UNARY_OP_INCREMENT);
				setState(312);
				expression(45);
				}
				break;
			case UNARY_OP_DECREMENT:
				{
				_localctx = new PrefixDecrementExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(313);
				match(UNARY_OP_DECREMENT);
				setState(314);
				expression(43);
				}
				break;
			case COMMON_TOK_MINUS:
				{
				_localctx = new AdditiveInverseExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(315);
				match(COMMON_TOK_MINUS);
				setState(316);
				expression(42);
				}
				break;
			case COMMON_TOK_PLUS:
				{
				_localctx = new AdditiveIdentityExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(317);
				match(COMMON_TOK_PLUS);
				setState(318);
				expression(41);
				}
				break;
			case PHRASE_FOR_ALL:
			case PHRASE_EXISTS:
				{
				_localctx = new QuantificationExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(319);
				_la = _input.LA(1);
				if ( !(_la==PHRASE_FOR_ALL || _la==PHRASE_EXISTS) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(320);
				match(GROUP_LEFT_PAREN);
				setState(321);
				match(IDENTIFIER_NAME);
				setState(322);
				match(COMMON_TOK_COLON);
				setState(323);
				type();
				setState(324);
				match(GROUP_RIGHT_PAREN);
				setState(325);
				expression(18);
				}
				break;
			case GROUP_LEFT_PAREN:
				{
				_localctx = new ExpressionGroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(327);
				match(GROUP_LEFT_PAREN);
				setState(328);
				expression(0);
				setState(329);
				match(GROUP_RIGHT_PAREN);
				}
				break;
			case EXPR_LITERAL_DEADLOCK:
				{
				_localctx = new DeadlockLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(331);
				match(EXPR_LITERAL_DEADLOCK);
				}
				break;
			case EXPR_LITERAL_TRUE:
				{
				_localctx = new TrueLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(332);
				match(EXPR_LITERAL_TRUE);
				}
				break;
			case EXPR_LITERAL_FALSE:
				{
				_localctx = new FalseLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(333);
				match(EXPR_LITERAL_FALSE);
				}
				break;
			case NATURAL_NUMBER:
				{
				_localctx = new NaturalNumberLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(334);
				match(NATURAL_NUMBER);
				}
				break;
			case IDENTIFIER_NAME:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(335);
				match(IDENTIFIER_NAME);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(460);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(458);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(338);
						if (!(precpred(_ctx, 40))) throw new FailedPredicateException(this, "precpred(_ctx, 40)");
						setState(339);
						match(BINARY_OP_MULTIPLICATION);
						setState(340);
						expression(41);
						}
						break;
					case 2:
						{
						_localctx = new DivisionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(341);
						if (!(precpred(_ctx, 39))) throw new FailedPredicateException(this, "precpred(_ctx, 39)");
						setState(342);
						match(BINARY_OP_DIVISION);
						setState(343);
						expression(40);
						}
						break;
					case 3:
						{
						_localctx = new ModuloExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(344);
						if (!(precpred(_ctx, 38))) throw new FailedPredicateException(this, "precpred(_ctx, 38)");
						setState(345);
						match(BINARY_OP_MODULO);
						setState(346);
						expression(39);
						}
						break;
					case 4:
						{
						_localctx = new SubtractionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(347);
						if (!(precpred(_ctx, 37))) throw new FailedPredicateException(this, "precpred(_ctx, 37)");
						setState(348);
						match(COMMON_TOK_MINUS);
						setState(349);
						expression(38);
						}
						break;
					case 5:
						{
						_localctx = new AdditionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(350);
						if (!(precpred(_ctx, 36))) throw new FailedPredicateException(this, "precpred(_ctx, 36)");
						setState(351);
						match(COMMON_TOK_PLUS);
						setState(352);
						expression(37);
						}
						break;
					case 6:
						{
						_localctx = new LeftShiftExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(353);
						if (!(precpred(_ctx, 35))) throw new FailedPredicateException(this, "precpred(_ctx, 35)");
						setState(354);
						match(BINARY_OP_LEFT_SHIFT);
						setState(355);
						expression(36);
						}
						break;
					case 7:
						{
						_localctx = new RightShiftExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(356);
						if (!(precpred(_ctx, 34))) throw new FailedPredicateException(this, "precpred(_ctx, 34)");
						setState(357);
						match(BINARY_OP_RIGHT_SHIFT);
						setState(358);
						expression(35);
						}
						break;
					case 8:
						{
						_localctx = new MaximumExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(359);
						if (!(precpred(_ctx, 33))) throw new FailedPredicateException(this, "precpred(_ctx, 33)");
						setState(360);
						match(BINARY_OP_MAX);
						setState(361);
						expression(34);
						}
						break;
					case 9:
						{
						_localctx = new MinimumExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(362);
						if (!(precpred(_ctx, 32))) throw new FailedPredicateException(this, "precpred(_ctx, 32)");
						setState(363);
						match(BINARY_OP_MIN);
						setState(364);
						expression(33);
						}
						break;
					case 10:
						{
						_localctx = new LessThanExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(365);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(366);
						match(COMMON_TOK_LESS_THAN);
						setState(367);
						expression(32);
						}
						break;
					case 11:
						{
						_localctx = new LessThanOrEqualExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(368);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(369);
						match(BINARY_OP_LESS_THAN_OR_EQUAL_TO);
						setState(370);
						expression(31);
						}
						break;
					case 12:
						{
						_localctx = new GreaterThanExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(371);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(372);
						match(BINARY_OP_GREATER_THAN);
						setState(373);
						expression(30);
						}
						break;
					case 13:
						{
						_localctx = new GreaterThanOrEqualExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(374);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(375);
						match(BINARY_OP_GREATER_THAN_OR_EQUAL);
						setState(376);
						expression(29);
						}
						break;
					case 14:
						{
						_localctx = new EqualityExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(377);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(378);
						match(BINARY_OP_EQUAL);
						setState(379);
						expression(28);
						}
						break;
					case 15:
						{
						_localctx = new InequalityExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(380);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(381);
						match(BINARY_OP_NOT_EQUAL);
						setState(382);
						expression(27);
						}
						break;
					case 16:
						{
						_localctx = new BitwiseAndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(383);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(384);
						match(COMMON_TOK_AMPERSAND);
						setState(385);
						expression(26);
						}
						break;
					case 17:
						{
						_localctx = new BitwiseXorExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(386);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(387);
						match(BINARY_OP_BITWISE_XOR);
						setState(388);
						expression(25);
						}
						break;
					case 18:
						{
						_localctx = new BitwiseOrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(389);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(390);
						match(BINARY_OP_BITWISE_OR);
						setState(391);
						expression(24);
						}
						break;
					case 19:
						{
						_localctx = new ConjunctionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(392);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(393);
						_la = _input.LA(1);
						if ( !(_la==BINARY_OP_CONJUNCTION || _la==PHRASE_AND) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(394);
						expression(23);
						}
						break;
					case 20:
						{
						_localctx = new DisjunctionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(395);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(396);
						_la = _input.LA(1);
						if ( !(_la==BINARY_OP_DISJUNCTION || _la==PHRASE_OR) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(397);
						expression(22);
						}
						break;
					case 21:
						{
						_localctx = new TernaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(398);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(399);
						match(COMMON_TOK_QUESTION_MARK);
						setState(400);
						expression(0);
						setState(401);
						match(COMMON_TOK_COLON);
						setState(402);
						expression(20);
						}
						break;
					case 22:
						{
						_localctx = new ImplicationExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(404);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(405);
						match(PHRASE_IMPLY);
						setState(406);
						expression(20);
						}
						break;
					case 23:
						{
						_localctx = new AssignmentExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(407);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(408);
						match(ASSG_OP);
						setState(409);
						expression(16);
						}
						break;
					case 24:
						{
						_localctx = new MultiplicationAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(410);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(411);
						match(ASSG_OP_MULTIPLICATION);
						setState(412);
						expression(15);
						}
						break;
					case 25:
						{
						_localctx = new DivisionAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(413);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(414);
						match(ASSG_OP_DIVISION);
						setState(415);
						expression(14);
						}
						break;
					case 26:
						{
						_localctx = new ModuloAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(416);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(417);
						match(ASSG_OP_MODULO);
						setState(418);
						expression(13);
						}
						break;
					case 27:
						{
						_localctx = new SubtractionAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(419);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(420);
						match(ASSG_OP_SUBTRACTION);
						setState(421);
						expression(12);
						}
						break;
					case 28:
						{
						_localctx = new AdditionAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(422);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(423);
						match(ASSG_OP_ADDITION);
						setState(424);
						expression(11);
						}
						break;
					case 29:
						{
						_localctx = new LeftShiftAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(425);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(426);
						match(ASSG_OP_LEFT_SHIFT);
						setState(427);
						expression(10);
						}
						break;
					case 30:
						{
						_localctx = new RightShiftAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(428);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(429);
						match(ASSG_OP_RIGHT_SHIFT);
						setState(430);
						expression(9);
						}
						break;
					case 31:
						{
						_localctx = new BitwiseAndAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(431);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(432);
						match(ASSG_OP_BITWISE_AND);
						setState(433);
						expression(8);
						}
						break;
					case 32:
						{
						_localctx = new BitwiseXorAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(434);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(435);
						match(ASSG_OP_BITWISE_XOR);
						setState(436);
						expression(7);
						}
						break;
					case 33:
						{
						_localctx = new BitwiseOrAssignmentExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(437);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(438);
						match(ASSG_OP_BITWISE_OR);
						setState(439);
						expression(6);
						}
						break;
					case 34:
						{
						_localctx = new ArrayLookupExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(440);
						if (!(precpred(_ctx, 49))) throw new FailedPredicateException(this, "precpred(_ctx, 49)");
						setState(441);
						match(GROUP_LEFT_BRACKET);
						setState(442);
						expression(0);
						setState(443);
						match(GROUP_RIGHT_BRACKET);
						}
						break;
					case 35:
						{
						_localctx = new FieldAccessExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(445);
						if (!(precpred(_ctx, 48))) throw new FailedPredicateException(this, "precpred(_ctx, 48)");
						setState(446);
						match(BINARY_OP_ACCESS_FIELD);
						setState(447);
						match(IDENTIFIER_NAME);
						}
						break;
					case 36:
						{
						_localctx = new PostfixIncrementExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(448);
						if (!(precpred(_ctx, 46))) throw new FailedPredicateException(this, "precpred(_ctx, 46)");
						setState(449);
						match(UNARY_OP_INCREMENT);
						}
						break;
					case 37:
						{
						_localctx = new PostfixDecrementExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(450);
						if (!(precpred(_ctx, 44))) throw new FailedPredicateException(this, "precpred(_ctx, 44)");
						setState(451);
						match(UNARY_OP_DECREMENT);
						}
						break;
					case 38:
						{
						_localctx = new CallExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(452);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(453);
						match(GROUP_LEFT_PAREN);
						setState(455);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPR_LITERAL_TRUE) | (1L << EXPR_LITERAL_FALSE) | (1L << EXPR_LITERAL_DEADLOCK) | (1L << UNARY_OP_INCREMENT) | (1L << UNARY_OP_DECREMENT) | (1L << COMMON_TOK_PLUS) | (1L << COMMON_TOK_MINUS) | (1L << COMMON_TOK_EXCLAMATION_MARK) | (1L << GROUP_LEFT_PAREN) | (1L << PHRASE_NOT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (PHRASE_FOR_ALL - 67)) | (1L << (PHRASE_EXISTS - 67)) | (1L << (IDENTIFIER_NAME - 67)) | (1L << (NATURAL_NUMBER - 67)))) != 0)) {
							{
							setState(454);
							argumentSequence();
							}
						}

						setState(457);
						match(GROUP_RIGHT_PAREN);
						}
						break;
					}
					} 
				}
				setState(462);
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
			setState(463);
			parameter();
			setState(468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(464);
				match(SEP_ENUMERATION);
				setState(465);
				parameter();
				}
				}
				setState(470);
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
		public ReferenceModifierContext referenceModifier() {
			return getRuleContext(ReferenceModifierContext.class,0);
		}
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
			setState(471);
			type();
			setState(473);
			_la = _input.LA(1);
			if (_la==COMMON_TOK_AMPERSAND) {
				{
				setState(472);
				referenceModifier();
				}
			}

			setState(475);
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

	public static class ReferenceModifierContext extends ParserRuleContext {
		public TerminalNode COMMON_TOK_AMPERSAND() { return getToken(UtaLanguageParser.COMMON_TOK_AMPERSAND, 0); }
		public ReferenceModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterReferenceModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitReferenceModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitReferenceModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceModifierContext referenceModifier() throws RecognitionException {
		ReferenceModifierContext _localctx = new ReferenceModifierContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_referenceModifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			match(COMMON_TOK_AMPERSAND);
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
		enterRule(_localctx, 48, RULE_argumentSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			expression(0);
			setState(484);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(480);
				match(SEP_ENUMERATION);
				setState(481);
				expression(0);
				}
				}
				setState(486);
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
		enterRule(_localctx, 50, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_PREFIX_URGENT) | (1L << TYPE_PREFIX_BROADCAST) | (1L << TYPE_PREFIX_META) | (1L << TYPE_PREFIX_CONST))) != 0)) {
				{
				setState(487);
				typePrefix();
				}
			}

			setState(490);
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
	public static class CustomTypeIdContext extends TypeIdentifierContext {
		public TerminalNode IDENTIFIER_NAME() { return getToken(UtaLanguageParser.IDENTIFIER_NAME, 0); }
		public CustomTypeIdContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterCustomTypeId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitCustomTypeId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitCustomTypeId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerTypeIdContext extends TypeIdentifierContext {
		public TerminalNode TYPE_INTEGER() { return getToken(UtaLanguageParser.TYPE_INTEGER, 0); }
		public IntegerTypeIdContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterIntegerTypeId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitIntegerTypeId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitIntegerTypeId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClockTypeIdContext extends TypeIdentifierContext {
		public TerminalNode TYPE_CLOCK() { return getToken(UtaLanguageParser.TYPE_CLOCK, 0); }
		public ClockTypeIdContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterClockTypeId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitClockTypeId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitClockTypeId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ChannelTypeIdContext extends TypeIdentifierContext {
		public TerminalNode TYPE_CHANNEL() { return getToken(UtaLanguageParser.TYPE_CHANNEL, 0); }
		public ChannelTypeIdContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterChannelTypeId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitChannelTypeId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitChannelTypeId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ScalarTypeIdContext extends TypeIdentifierContext {
		public TerminalNode TYPE_SCALAR() { return getToken(UtaLanguageParser.TYPE_SCALAR, 0); }
		public TerminalNode GROUP_LEFT_BRACKET() { return getToken(UtaLanguageParser.GROUP_LEFT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_BRACKET() { return getToken(UtaLanguageParser.GROUP_RIGHT_BRACKET, 0); }
		public ScalarTypeIdContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterScalarTypeId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitScalarTypeId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitScalarTypeId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanTypeIdContext extends TypeIdentifierContext {
		public TerminalNode TYPE_BOOLEAN() { return getToken(UtaLanguageParser.TYPE_BOOLEAN, 0); }
		public BooleanTypeIdContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterBooleanTypeId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitBooleanTypeId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitBooleanTypeId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructTypeIdContext extends TypeIdentifierContext {
		public TerminalNode TYPE_STRUCT() { return getToken(UtaLanguageParser.TYPE_STRUCT, 0); }
		public TerminalNode GROUP_LEFT_CURLY() { return getToken(UtaLanguageParser.GROUP_LEFT_CURLY, 0); }
		public TerminalNode GROUP_RIGHT_CURLY() { return getToken(UtaLanguageParser.GROUP_RIGHT_CURLY, 0); }
		public List<FieldDeclarationContext> fieldDeclaration() {
			return getRuleContexts(FieldDeclarationContext.class);
		}
		public FieldDeclarationContext fieldDeclaration(int i) {
			return getRuleContext(FieldDeclarationContext.class,i);
		}
		public StructTypeIdContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterStructTypeId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitStructTypeId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitStructTypeId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoundedIntegerTypeIdContext extends TypeIdentifierContext {
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
		public BoundedIntegerTypeIdContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterBoundedIntegerTypeId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitBoundedIntegerTypeId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitBoundedIntegerTypeId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeIdentifierContext typeIdentifier() throws RecognitionException {
		TypeIdentifierContext _localctx = new TypeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_typeIdentifier);
		int _la;
		try {
			setState(518);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				_localctx = new IntegerTypeIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(492);
				match(TYPE_INTEGER);
				}
				break;
			case 2:
				_localctx = new ClockTypeIdContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(493);
				match(TYPE_CLOCK);
				}
				break;
			case 3:
				_localctx = new ChannelTypeIdContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(494);
				match(TYPE_CHANNEL);
				}
				break;
			case 4:
				_localctx = new BooleanTypeIdContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(495);
				match(TYPE_BOOLEAN);
				}
				break;
			case 5:
				_localctx = new BoundedIntegerTypeIdContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(496);
				match(TYPE_INTEGER);
				setState(497);
				match(GROUP_LEFT_BRACKET);
				setState(498);
				expression(0);
				setState(499);
				match(SEP_ENUMERATION);
				setState(500);
				expression(0);
				setState(501);
				match(GROUP_RIGHT_BRACKET);
				}
				break;
			case 6:
				_localctx = new ScalarTypeIdContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(503);
				match(TYPE_SCALAR);
				setState(504);
				match(GROUP_LEFT_BRACKET);
				setState(505);
				expression(0);
				setState(506);
				match(GROUP_RIGHT_BRACKET);
				}
				break;
			case 7:
				_localctx = new StructTypeIdContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(508);
				match(TYPE_STRUCT);
				setState(509);
				match(GROUP_LEFT_CURLY);
				setState(511); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(510);
					fieldDeclaration();
					}
					}
					setState(513); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INTEGER) | (1L << TYPE_CLOCK) | (1L << TYPE_CHANNEL) | (1L << TYPE_BOOLEAN) | (1L << TYPE_SCALAR) | (1L << TYPE_STRUCT) | (1L << TYPE_PREFIX_URGENT) | (1L << TYPE_PREFIX_BROADCAST) | (1L << TYPE_PREFIX_META) | (1L << TYPE_PREFIX_CONST))) != 0) || _la==IDENTIFIER_NAME );
				setState(515);
				match(GROUP_RIGHT_CURLY);
				}
				break;
			case 8:
				_localctx = new CustomTypeIdContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(517);
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
		enterRule(_localctx, 54, RULE_arrayVariableLookup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			match(IDENTIFIER_NAME);
			setState(525); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(521);
				match(GROUP_LEFT_BRACKET);
				setState(522);
				expression(0);
				setState(523);
				match(GROUP_RIGHT_BRACKET);
				}
				}
				setState(527); 
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
		enterRule(_localctx, 56, RULE_fieldDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			type();
			setState(530);
			identifierDeclaration();
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(531);
				match(SEP_ENUMERATION);
				setState(532);
				identifierDeclaration();
				}
				}
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(538);
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
		enterRule(_localctx, 58, RULE_identifierDeclaration);
		int _la;
		try {
			setState(547);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				_localctx = new ArrayIdentifierDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(540);
				match(IDENTIFIER_NAME);
				setState(542); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(541);
					arraySizeModifier();
					}
					}
					setState(544); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==GROUP_LEFT_BRACKET );
				}
				break;
			case 2:
				_localctx = new BaseIdentifierDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(546);
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
	public static class ExpressionArraySizeModifierContext extends ArraySizeModifierContext {
		public TerminalNode GROUP_LEFT_BRACKET() { return getToken(UtaLanguageParser.GROUP_LEFT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_BRACKET() { return getToken(UtaLanguageParser.GROUP_RIGHT_BRACKET, 0); }
		public ExpressionArraySizeModifierContext(ArraySizeModifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterExpressionArraySizeModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitExpressionArraySizeModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitExpressionArraySizeModifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeArraySizeModifierContext extends ArraySizeModifierContext {
		public TerminalNode GROUP_LEFT_BRACKET() { return getToken(UtaLanguageParser.GROUP_LEFT_BRACKET, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_BRACKET() { return getToken(UtaLanguageParser.GROUP_RIGHT_BRACKET, 0); }
		public TypeArraySizeModifierContext(ArraySizeModifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).enterTypeArraySizeModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UtaLanguageListener ) ((UtaLanguageListener)listener).exitTypeArraySizeModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UtaLanguageVisitor ) return ((UtaLanguageVisitor<? extends T>)visitor).visitTypeArraySizeModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraySizeModifierContext arraySizeModifier() throws RecognitionException {
		ArraySizeModifierContext _localctx = new ArraySizeModifierContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_arraySizeModifier);
		try {
			setState(557);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				_localctx = new ExpressionArraySizeModifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(549);
				match(GROUP_LEFT_BRACKET);
				setState(550);
				expression(0);
				setState(551);
				match(GROUP_RIGHT_BRACKET);
				}
				break;
			case 2:
				_localctx = new TypeArraySizeModifierContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(553);
				match(GROUP_LEFT_BRACKET);
				setState(554);
				type();
				setState(555);
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
		enterRule(_localctx, 62, RULE_typePrefix);
		try {
			setState(563);
			switch (_input.LA(1)) {
			case TYPE_PREFIX_URGENT:
				_localctx = new TypePrefixUrgentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(559);
				match(TYPE_PREFIX_URGENT);
				}
				break;
			case TYPE_PREFIX_BROADCAST:
				_localctx = new TypePrefixBroadcastContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(560);
				match(TYPE_PREFIX_BROADCAST);
				}
				break;
			case TYPE_PREFIX_META:
				_localctx = new TypePrefixMetaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(561);
				match(TYPE_PREFIX_META);
				}
				break;
			case TYPE_PREFIX_CONST:
				_localctx = new TypePrefixConstantContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(562);
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
			return precpred(_ctx, 40);
		case 1:
			return precpred(_ctx, 39);
		case 2:
			return precpred(_ctx, 38);
		case 3:
			return precpred(_ctx, 37);
		case 4:
			return precpred(_ctx, 36);
		case 5:
			return precpred(_ctx, 35);
		case 6:
			return precpred(_ctx, 34);
		case 7:
			return precpred(_ctx, 33);
		case 8:
			return precpred(_ctx, 32);
		case 9:
			return precpred(_ctx, 31);
		case 10:
			return precpred(_ctx, 30);
		case 11:
			return precpred(_ctx, 29);
		case 12:
			return precpred(_ctx, 28);
		case 13:
			return precpred(_ctx, 27);
		case 14:
			return precpred(_ctx, 26);
		case 15:
			return precpred(_ctx, 25);
		case 16:
			return precpred(_ctx, 24);
		case 17:
			return precpred(_ctx, 23);
		case 18:
			return precpred(_ctx, 22);
		case 19:
			return precpred(_ctx, 21);
		case 20:
			return precpred(_ctx, 20);
		case 21:
			return precpred(_ctx, 19);
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
			return precpred(_ctx, 49);
		case 34:
			return precpred(_ctx, 48);
		case 35:
			return precpred(_ctx, 46);
		case 36:
			return precpred(_ctx, 44);
		case 37:
			return precpred(_ctx, 17);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3S\u0238\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\3\2\3\2\5\2I\n\2\3\3\3\3\3\3\7\3N\n\3\f\3\16\3Q\13"+
		"\3\3\4\3\4\3\4\3\4\3\5\5\5X\n\5\3\5\5\5[\n\5\3\5\5\5^\n\5\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\7\7g\n\7\f\7\16\7j\13\7\3\b\3\b\3\b\7\bo\n\b\f\b\16\b"+
		"r\13\b\3\t\3\t\3\t\3\t\3\t\7\ty\n\t\f\t\16\t|\13\t\3\t\3\t\3\n\6\n\u0081"+
		"\n\n\r\n\16\n\u0082\3\13\3\13\3\13\3\13\7\13\u0089\n\13\f\13\16\13\u008c"+
		"\13\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0095\n\13\f\13\16\13\u0098"+
		"\13\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a5"+
		"\n\13\3\13\5\13\u00a8\n\13\3\13\3\13\3\13\3\13\5\13\u00ae\n\13\3\13\3"+
		"\13\5\13\u00b2\n\13\3\f\3\f\3\f\6\f\u00b7\n\f\r\f\16\f\u00b8\3\r\3\r\3"+
		"\r\7\r\u00be\n\r\f\r\16\r\u00c1\13\r\3\16\3\16\3\16\5\16\u00c6\n\16\3"+
		"\17\3\17\3\17\5\17\u00cb\n\17\3\20\3\20\3\20\3\20\3\20\7\20\u00d2\n\20"+
		"\f\20\16\20\u00d5\13\20\3\20\3\20\5\20\u00d9\n\20\3\21\3\21\3\21\3\21"+
		"\5\21\u00df\n\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00e8\n\21\3"+
		"\21\3\21\5\21\u00ec\n\21\3\22\3\22\5\22\u00f0\n\22\3\22\5\22\u00f3\n\22"+
		"\3\22\3\22\3\23\6\23\u00f8\n\23\r\23\16\23\u00f9\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0125\n\24\3\24\3\24"+
		"\5\24\u0129\n\24\3\24\3\24\5\24\u012d\n\24\3\25\3\25\3\25\7\25\u0132\n"+
		"\25\f\25\16\25\u0135\13\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\5\26\u0153\n\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26"+
		"\u01ca\n\26\3\26\7\26\u01cd\n\26\f\26\16\26\u01d0\13\26\3\27\3\27\3\27"+
		"\7\27\u01d5\n\27\f\27\16\27\u01d8\13\27\3\30\3\30\5\30\u01dc\n\30\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\32\7\32\u01e5\n\32\f\32\16\32\u01e8\13\32"+
		"\3\33\5\33\u01eb\n\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\6\34\u0202\n\34"+
		"\r\34\16\34\u0203\3\34\3\34\3\34\5\34\u0209\n\34\3\35\3\35\3\35\3\35\3"+
		"\35\6\35\u0210\n\35\r\35\16\35\u0211\3\36\3\36\3\36\3\36\7\36\u0218\n"+
		"\36\f\36\16\36\u021b\13\36\3\36\3\36\3\37\3\37\6\37\u0221\n\37\r\37\16"+
		"\37\u0222\3\37\5\37\u0226\n\37\3 \3 \3 \3 \3 \3 \3 \3 \5 \u0230\n \3!"+
		"\3!\3!\3!\5!\u0236\n!\3!\2\3*\"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@\2\6\4\2\66\66AA\3\2EF\4\2$$CC\4\2%%BB\u0287"+
		"\2H\3\2\2\2\4J\3\2\2\2\6R\3\2\2\2\bW\3\2\2\2\n_\3\2\2\2\fc\3\2\2\2\16"+
		"k\3\2\2\2\20s\3\2\2\2\22\u0080\3\2\2\2\24\u00b1\3\2\2\2\26\u00b3\3\2\2"+
		"\2\30\u00ba\3\2\2\2\32\u00c5\3\2\2\2\34\u00c7\3\2\2\2\36\u00d8\3\2\2\2"+
		" \u00eb\3\2\2\2\"\u00ed\3\2\2\2$\u00f7\3\2\2\2&\u012c\3\2\2\2(\u012e\3"+
		"\2\2\2*\u0152\3\2\2\2,\u01d1\3\2\2\2.\u01d9\3\2\2\2\60\u01df\3\2\2\2\62"+
		"\u01e1\3\2\2\2\64\u01ea\3\2\2\2\66\u0208\3\2\2\28\u020a\3\2\2\2:\u0213"+
		"\3\2\2\2<\u0225\3\2\2\2>\u022f\3\2\2\2@\u0235\3\2\2\2BC\5*\26\2CD\7\66"+
		"\2\2DI\3\2\2\2EF\5*\26\2FG\7\67\2\2GI\3\2\2\2HB\3\2\2\2HE\3\2\2\2I\3\3"+
		"\2\2\2JO\5\6\4\2KL\7>\2\2LN\5\6\4\2MK\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3"+
		"\2\2\2P\5\3\2\2\2QO\3\2\2\2RS\7R\2\2ST\7\61\2\2TU\5\64\33\2U\7\3\2\2\2"+
		"VX\5\22\n\2WV\3\2\2\2WX\3\2\2\2XZ\3\2\2\2Y[\5\n\6\2ZY\3\2\2\2Z[\3\2\2"+
		"\2[]\3\2\2\2\\^\5\20\t\2]\\\3\2\2\2]^\3\2\2\2^\t\3\2\2\2_`\7P\2\2`a\5"+
		"\f\7\2ab\7?\2\2b\13\3\2\2\2ch\5\16\b\2de\7\65\2\2eg\5\16\b\2fd\3\2\2\2"+
		"gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\r\3\2\2\2jh\3\2\2\2kp\7R\2\2lm\7>\2\2"+
		"mo\7R\2\2nl\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\17\3\2\2\2rp\3\2\2"+
		"\2st\7Q\2\2tz\78\2\2uv\5*\26\2vw\7?\2\2wy\3\2\2\2xu\3\2\2\2y|\3\2\2\2"+
		"zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}~\79\2\2~\21\3\2\2\2\177\u0081"+
		"\5\24\13\2\u0080\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\23\3\2\2\2\u0084\u0085\5\64\33\2\u0085\u008a\5\34"+
		"\17\2\u0086\u0087\7>\2\2\u0087\u0089\5\34\17\2\u0088\u0086\3\2\2\2\u0089"+
		"\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2"+
		"\2\2\u008c\u008a\3\2\2\2\u008d\u008e\7?\2\2\u008e\u00b2\3\2\2\2\u008f"+
		"\u0090\7G\2\2\u0090\u0091\5\64\33\2\u0091\u0096\5<\37\2\u0092\u0093\7"+
		">\2\2\u0093\u0095\5<\37\2\u0094\u0092\3\2\2\2\u0095\u0098\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0099\u009a\7?\2\2\u009a\u00b2\3\2\2\2\u009b\u00b2\5 \21\2\u009c"+
		"\u009d\7\b\2\2\u009d\u009e\7N\2\2\u009e\u009f\5\26\f\2\u009f\u00a0\7?"+
		"\2\2\u00a0\u00b2\3\2\2\2\u00a1\u00a7\7R\2\2\u00a2\u00a4\7<\2\2\u00a3\u00a5"+
		"\5,\27\2\u00a4\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00a8\7=\2\2\u00a7\u00a2\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2"+
		"\2\2\u00a9\u00aa\7\23\2\2\u00aa\u00ab\7R\2\2\u00ab\u00ad\7<\2\2\u00ac"+
		"\u00ae\5\62\32\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3"+
		"\2\2\2\u00af\u00b0\7=\2\2\u00b0\u00b2\7?\2\2\u00b1\u0084\3\2\2\2\u00b1"+
		"\u008f\3\2\2\2\u00b1\u009b\3\2\2\2\u00b1\u009c\3\2\2\2\u00b1\u00a1\3\2"+
		"\2\2\u00b2\25\3\2\2\2\u00b3\u00b6\5\30\r\2\u00b4\u00b5\7\65\2\2\u00b5"+
		"\u00b7\5\30\r\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b6\3"+
		"\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\27\3\2\2\2\u00ba\u00bf\5\32\16\2\u00bb"+
		"\u00bc\7>\2\2\u00bc\u00be\5\32\16\2\u00bd\u00bb\3\2\2\2\u00be\u00c1\3"+
		"\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\31\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c2\u00c6\7O\2\2\u00c3\u00c6\58\35\2\u00c4\u00c6\7R\2"+
		"\2\u00c5\u00c2\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\33"+
		"\3\2\2\2\u00c7\u00ca\5<\37\2\u00c8\u00c9\7\23\2\2\u00c9\u00cb\5\36\20"+
		"\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\35\3\2\2\2\u00cc\u00d9"+
		"\5*\26\2\u00cd\u00ce\78\2\2\u00ce\u00d3\5\36\20\2\u00cf\u00d0\7>\2\2\u00d0"+
		"\u00d2\5\36\20\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3"+
		"\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6"+
		"\u00d7\79\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00cc\3\2\2\2\u00d8\u00cd\3\2"+
		"\2\2\u00d9\37\3\2\2\2\u00da\u00db\5\64\33\2\u00db\u00dc\7R\2\2\u00dc\u00de"+
		"\7<\2\2\u00dd\u00df\5,\27\2\u00de\u00dd\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e1\7=\2\2\u00e1\u00e2\5\"\22\2\u00e2\u00ec\3\2"+
		"\2\2\u00e3\u00e4\7@\2\2\u00e4\u00e5\7R\2\2\u00e5\u00e7\7<\2\2\u00e6\u00e8"+
		"\5,\27\2\u00e7\u00e6\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"\u00ea\7=\2\2\u00ea\u00ec\5\"\22\2\u00eb\u00da\3\2\2\2\u00eb\u00e3\3\2"+
		"\2\2\u00ec!\3\2\2\2\u00ed\u00ef\78\2\2\u00ee\u00f0\5\22\n\2\u00ef\u00ee"+
		"\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00f3\5$\23\2\u00f2"+
		"\u00f1\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\79"+
		"\2\2\u00f5#\3\2\2\2\u00f6\u00f8\5&\24\2\u00f7\u00f6\3\2\2\2\u00f8\u00f9"+
		"\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa%\3\2\2\2\u00fb"+
		"\u012d\5\"\22\2\u00fc\u00fd\5*\26\2\u00fd\u00fe\7?\2\2\u00fe\u012d\3\2"+
		"\2\2\u00ff\u0100\7J\2\2\u0100\u0101\7<\2\2\u0101\u0102\5*\26\2\u0102\u0103"+
		"\7?\2\2\u0103\u0104\5*\26\2\u0104\u0105\7?\2\2\u0105\u0106\5*\26\2\u0106"+
		"\u0107\7=\2\2\u0107\u0108\5&\24\2\u0108\u012d\3\2\2\2\u0109\u010a\7J\2"+
		"\2\u010a\u010b\7<\2\2\u010b\u010c\7R\2\2\u010c\u010d\7\61\2\2\u010d\u010e"+
		"\5\64\33\2\u010e\u010f\7=\2\2\u010f\u0110\5&\24\2\u0110\u012d\3\2\2\2"+
		"\u0111\u0112\7K\2\2\u0112\u0113\7<\2\2\u0113\u0114\5*\26\2\u0114\u0115"+
		"\7=\2\2\u0115\u0116\5&\24\2\u0116\u012d\3\2\2\2\u0117\u0118\7M\2\2\u0118"+
		"\u0119\5&\24\2\u0119\u011a\7K\2\2\u011a\u011b\5*\26\2\u011b\u011c\7?\2"+
		"\2\u011c\u012d\3\2\2\2\u011d\u011e\7H\2\2\u011e\u011f\7<\2\2\u011f\u0120"+
		"\5*\26\2\u0120\u0121\7=\2\2\u0121\u0124\5&\24\2\u0122\u0123\7I\2\2\u0123"+
		"\u0125\5&\24\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u012d\3\2"+
		"\2\2\u0126\u0128\7L\2\2\u0127\u0129\5*\26\2\u0128\u0127\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012d\7?\2\2\u012b\u012d\7?\2"+
		"\2\u012c\u00fb\3\2\2\2\u012c\u00fc\3\2\2\2\u012c\u00ff\3\2\2\2\u012c\u0109"+
		"\3\2\2\2\u012c\u0111\3\2\2\2\u012c\u0117\3\2\2\2\u012c\u011d\3\2\2\2\u012c"+
		"\u0126\3\2\2\2\u012c\u012b\3\2\2\2\u012d\'\3\2\2\2\u012e\u0133\5*\26\2"+
		"\u012f\u0130\7>\2\2\u0130\u0132\5*\26\2\u0131\u012f\3\2\2\2\u0132\u0135"+
		"\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134)\3\2\2\2\u0135"+
		"\u0133\3\2\2\2\u0136\u0137\b\26\1\2\u0137\u0138\t\2\2\2\u0138\u0153\5"+
		"*\26\61\u0139\u013a\7/\2\2\u013a\u0153\5*\26/\u013b\u013c\7\60\2\2\u013c"+
		"\u0153\5*\26-\u013d\u013e\7\63\2\2\u013e\u0153\5*\26,\u013f\u0140\7\62"+
		"\2\2\u0140\u0153\5*\26+\u0141\u0142\t\3\2\2\u0142\u0143\7<\2\2\u0143\u0144"+
		"\7R\2\2\u0144\u0145\7\61\2\2\u0145\u0146\5\64\33\2\u0146\u0147\7=\2\2"+
		"\u0147\u0148\5*\26\24\u0148\u0153\3\2\2\2\u0149\u014a\7<\2\2\u014a\u014b"+
		"\5*\26\2\u014b\u014c\7=\2\2\u014c\u0153\3\2\2\2\u014d\u0153\7\22\2\2\u014e"+
		"\u0153\7\20\2\2\u014f\u0153\7\21\2\2\u0150\u0153\7S\2\2\u0151\u0153\7"+
		"R\2\2\u0152\u0136\3\2\2\2\u0152\u0139\3\2\2\2\u0152\u013b\3\2\2\2\u0152"+
		"\u013d\3\2\2\2\u0152\u013f\3\2\2\2\u0152\u0141\3\2\2\2\u0152\u0149\3\2"+
		"\2\2\u0152\u014d\3\2\2\2\u0152\u014e\3\2\2\2\u0152\u014f\3\2\2\2\u0152"+
		"\u0150\3\2\2\2\u0152\u0151\3\2\2\2\u0153\u01ce\3\2\2\2\u0154\u0155\f*"+
		"\2\2\u0155\u0156\7\'\2\2\u0156\u01cd\5*\26+\u0157\u0158\f)\2\2\u0158\u0159"+
		"\7(\2\2\u0159\u01cd\5*\26*\u015a\u015b\f(\2\2\u015b\u015c\7)\2\2\u015c"+
		"\u01cd\5*\26)\u015d\u015e\f\'\2\2\u015e\u015f\7\63\2\2\u015f\u01cd\5*"+
		"\26(\u0160\u0161\f&\2\2\u0161\u0162\7\62\2\2\u0162\u01cd\5*\26\'\u0163"+
		"\u0164\f%\2\2\u0164\u0165\7\"\2\2\u0165\u01cd\5*\26&\u0166\u0167\f$\2"+
		"\2\u0167\u0168\7#\2\2\u0168\u01cd\5*\26%\u0169\u016a\f#\2\2\u016a\u016b"+
		"\7+\2\2\u016b\u01cd\5*\26$\u016c\u016d\f\"\2\2\u016d\u016e\7,\2\2\u016e"+
		"\u01cd\5*\26#\u016f\u0170\f!\2\2\u0170\u0171\7\65\2\2\u0171\u01cd\5*\26"+
		"\"\u0172\u0173\f \2\2\u0173\u0174\7\36\2\2\u0174\u01cd\5*\26!\u0175\u0176"+
		"\f\37\2\2\u0176\u0177\7-\2\2\u0177\u01cd\5*\26 \u0178\u0179\f\36\2\2\u0179"+
		"\u017a\7\37\2\2\u017a\u01cd\5*\26\37\u017b\u017c\f\35\2\2\u017c\u017d"+
		"\7 \2\2\u017d\u01cd\5*\26\36\u017e\u017f\f\34\2\2\u017f\u0180\7!\2\2\u0180"+
		"\u01cd\5*\26\35\u0181\u0182\f\33\2\2\u0182\u0183\7\64\2\2\u0183\u01cd"+
		"\5*\26\34\u0184\u0185\f\32\2\2\u0185\u0186\7*\2\2\u0186\u01cd\5*\26\33"+
		"\u0187\u0188\f\31\2\2\u0188\u0189\7&\2\2\u0189\u01cd\5*\26\32\u018a\u018b"+
		"\f\30\2\2\u018b\u018c\t\4\2\2\u018c\u01cd\5*\26\31\u018d\u018e\f\27\2"+
		"\2\u018e\u018f\t\5\2\2\u018f\u01cd\5*\26\30\u0190\u0191\f\26\2\2\u0191"+
		"\u0192\7\67\2\2\u0192\u0193\5*\26\2\u0193\u0194\7\61\2\2\u0194\u0195\5"+
		"*\26\26\u0195\u01cd\3\2\2\2\u0196\u0197\f\25\2\2\u0197\u0198\7D\2\2\u0198"+
		"\u01cd\5*\26\26\u0199\u019a\f\22\2\2\u019a\u019b\7\23\2\2\u019b\u01cd"+
		"\5*\26\22\u019c\u019d\f\21\2\2\u019d\u019e\7\26\2\2\u019e\u01cd\5*\26"+
		"\21\u019f\u01a0\f\20\2\2\u01a0\u01a1\7\27\2\2\u01a1\u01cd\5*\26\20\u01a2"+
		"\u01a3\f\17\2\2\u01a3\u01a4\7\30\2\2\u01a4\u01cd\5*\26\17\u01a5\u01a6"+
		"\f\16\2\2\u01a6\u01a7\7\24\2\2\u01a7\u01cd\5*\26\16\u01a8\u01a9\f\r\2"+
		"\2\u01a9\u01aa\7\25\2\2\u01aa\u01cd\5*\26\r\u01ab\u01ac\f\f\2\2\u01ac"+
		"\u01ad\7\34\2\2\u01ad\u01cd\5*\26\f\u01ae\u01af\f\13\2\2\u01af\u01b0\7"+
		"\35\2\2\u01b0\u01cd\5*\26\13\u01b1\u01b2\f\n\2\2\u01b2\u01b3\7\32\2\2"+
		"\u01b3\u01cd\5*\26\n\u01b4\u01b5\f\t\2\2\u01b5\u01b6\7\33\2\2\u01b6\u01cd"+
		"\5*\26\t\u01b7\u01b8\f\b\2\2\u01b8\u01b9\7\31\2\2\u01b9\u01cd\5*\26\b"+
		"\u01ba\u01bb\f\63\2\2\u01bb\u01bc\7:\2\2\u01bc\u01bd\5*\26\2\u01bd\u01be"+
		"\7;\2\2\u01be\u01cd\3\2\2\2\u01bf\u01c0\f\62\2\2\u01c0\u01c1\7.\2\2\u01c1"+
		"\u01cd\7R\2\2\u01c2\u01c3\f\60\2\2\u01c3\u01cd\7/\2\2\u01c4\u01c5\f.\2"+
		"\2\u01c5\u01cd\7\60\2\2\u01c6\u01c7\f\23\2\2\u01c7\u01c9\7<\2\2\u01c8"+
		"\u01ca\5\62\32\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cb\3"+
		"\2\2\2\u01cb\u01cd\7=\2\2\u01cc\u0154\3\2\2\2\u01cc\u0157\3\2\2\2\u01cc"+
		"\u015a\3\2\2\2\u01cc\u015d\3\2\2\2\u01cc\u0160\3\2\2\2\u01cc\u0163\3\2"+
		"\2\2\u01cc\u0166\3\2\2\2\u01cc\u0169\3\2\2\2\u01cc\u016c\3\2\2\2\u01cc"+
		"\u016f\3\2\2\2\u01cc\u0172\3\2\2\2\u01cc\u0175\3\2\2\2\u01cc\u0178\3\2"+
		"\2\2\u01cc\u017b\3\2\2\2\u01cc\u017e\3\2\2\2\u01cc\u0181\3\2\2\2\u01cc"+
		"\u0184\3\2\2\2\u01cc\u0187\3\2\2\2\u01cc\u018a\3\2\2\2\u01cc\u018d\3\2"+
		"\2\2\u01cc\u0190\3\2\2\2\u01cc\u0196\3\2\2\2\u01cc\u0199\3\2\2\2\u01cc"+
		"\u019c\3\2\2\2\u01cc\u019f\3\2\2\2\u01cc\u01a2\3\2\2\2\u01cc\u01a5\3\2"+
		"\2\2\u01cc\u01a8\3\2\2\2\u01cc\u01ab\3\2\2\2\u01cc\u01ae\3\2\2\2\u01cc"+
		"\u01b1\3\2\2\2\u01cc\u01b4\3\2\2\2\u01cc\u01b7\3\2\2\2\u01cc\u01ba\3\2"+
		"\2\2\u01cc\u01bf\3\2\2\2\u01cc\u01c2\3\2\2\2\u01cc\u01c4\3\2\2\2\u01cc"+
		"\u01c6\3\2\2\2\u01cd\u01d0\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2"+
		"\2\2\u01cf+\3\2\2\2\u01d0\u01ce\3\2\2\2\u01d1\u01d6\5.\30\2\u01d2\u01d3"+
		"\7>\2\2\u01d3\u01d5\5.\30\2\u01d4\u01d2\3\2\2\2\u01d5\u01d8\3\2\2\2\u01d6"+
		"\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7-\3\2\2\2\u01d8\u01d6\3\2\2\2"+
		"\u01d9\u01db\5\64\33\2\u01da\u01dc\5\60\31\2\u01db\u01da\3\2\2\2\u01db"+
		"\u01dc\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\5<\37\2\u01de/\3\2\2\2"+
		"\u01df\u01e0\7\64\2\2\u01e0\61\3\2\2\2\u01e1\u01e6\5*\26\2\u01e2\u01e3"+
		"\7>\2\2\u01e3\u01e5\5*\26\2\u01e4\u01e2\3\2\2\2\u01e5\u01e8\3\2\2\2\u01e6"+
		"\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\63\3\2\2\2\u01e8\u01e6\3\2\2"+
		"\2\u01e9\u01eb\5@!\2\u01ea\u01e9\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb\u01ec"+
		"\3\2\2\2\u01ec\u01ed\5\66\34\2\u01ed\65\3\2\2\2\u01ee\u0209\7\6\2\2\u01ef"+
		"\u0209\7\7\2\2\u01f0\u0209\7\b\2\2\u01f1\u0209\7\t\2\2\u01f2\u01f3\7\6"+
		"\2\2\u01f3\u01f4\7:\2\2\u01f4\u01f5\5*\26\2\u01f5\u01f6\7>\2\2\u01f6\u01f7"+
		"\5*\26\2\u01f7\u01f8\7;\2\2\u01f8\u0209\3\2\2\2\u01f9\u01fa\7\n\2\2\u01fa"+
		"\u01fb\7:\2\2\u01fb\u01fc\5*\26\2\u01fc\u01fd\7;\2\2\u01fd\u0209\3\2\2"+
		"\2\u01fe\u01ff\7\13\2\2\u01ff\u0201\78\2\2\u0200\u0202\5:\36\2\u0201\u0200"+
		"\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0201\3\2\2\2\u0203\u0204\3\2\2\2\u0204"+
		"\u0205\3\2\2\2\u0205\u0206\79\2\2\u0206\u0209\3\2\2\2\u0207\u0209\7R\2"+
		"\2\u0208\u01ee\3\2\2\2\u0208\u01ef\3\2\2\2\u0208\u01f0\3\2\2\2\u0208\u01f1"+
		"\3\2\2\2\u0208\u01f2\3\2\2\2\u0208\u01f9\3\2\2\2\u0208\u01fe\3\2\2\2\u0208"+
		"\u0207\3\2\2\2\u0209\67\3\2\2\2\u020a\u020f\7R\2\2\u020b\u020c\7:\2\2"+
		"\u020c\u020d\5*\26\2\u020d\u020e\7;\2\2\u020e\u0210\3\2\2\2\u020f\u020b"+
		"\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u020f\3\2\2\2\u0211\u0212\3\2\2\2\u0212"+
		"9\3\2\2\2\u0213\u0214\5\64\33\2\u0214\u0219\5<\37\2\u0215\u0216\7>\2\2"+
		"\u0216\u0218\5<\37\2\u0217\u0215\3\2\2\2\u0218\u021b\3\2\2\2\u0219\u0217"+
		"\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021c\3\2\2\2\u021b\u0219\3\2\2\2\u021c"+
		"\u021d\7?\2\2\u021d;\3\2\2\2\u021e\u0220\7R\2\2\u021f\u0221\5> \2\u0220"+
		"\u021f\3\2\2\2\u0221\u0222\3\2\2\2\u0222\u0220\3\2\2\2\u0222\u0223\3\2"+
		"\2\2\u0223\u0226\3\2\2\2\u0224\u0226\7R\2\2\u0225\u021e\3\2\2\2\u0225"+
		"\u0224\3\2\2\2\u0226=\3\2\2\2\u0227\u0228\7:\2\2\u0228\u0229\5*\26\2\u0229"+
		"\u022a\7;\2\2\u022a\u0230\3\2\2\2\u022b\u022c\7:\2\2\u022c\u022d\5\64"+
		"\33\2\u022d\u022e\7;\2\2\u022e\u0230\3\2\2\2\u022f\u0227\3\2\2\2\u022f"+
		"\u022b\3\2\2\2\u0230?\3\2\2\2\u0231\u0236\7\f\2\2\u0232\u0236\7\r\2\2"+
		"\u0233\u0236\7\16\2\2\u0234\u0236\7\17\2\2\u0235\u0231\3\2\2\2\u0235\u0232"+
		"\3\2\2\2\u0235\u0233\3\2\2\2\u0235\u0234\3\2\2\2\u0236A\3\2\2\2\61HOW"+
		"Z]hpz\u0082\u008a\u0096\u00a4\u00a7\u00ad\u00b1\u00b8\u00bf\u00c5\u00ca"+
		"\u00d3\u00d8\u00de\u00e7\u00eb\u00ef\u00f2\u00f9\u0124\u0128\u012c\u0133"+
		"\u0152\u01c9\u01cc\u01ce\u01d6\u01db\u01e6\u01ea\u0203\u0208\u0211\u0219"+
		"\u0222\u0225\u022f\u0235";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}