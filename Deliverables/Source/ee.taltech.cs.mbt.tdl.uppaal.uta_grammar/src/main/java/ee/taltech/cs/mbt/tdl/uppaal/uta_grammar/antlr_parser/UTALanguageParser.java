// Generated from UTALanguage.g4 by ANTLR 4.5
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
public class UTALanguageParser extends Parser {
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
		RULE_utaTemplateParameterList = 0, RULE_utaTransitionUpdateList = 1, RULE_utaDeclarations = 2, 
		RULE_utaTransitionSynchronization = 3, RULE_utaTransitionSelectionSequence = 4, 
		RULE_utaTransitionGuardExpression = 5, RULE_utaLocationInvariantExpression = 6, 
		RULE_utaSystemDefinition = 7, RULE_systemDeclarationSequence = 8, RULE_systemDeclarationStatement = 9, 
		RULE_processVariableAssignment = 10, RULE_systemLine = 11, RULE_systemProcessesList = 12, 
		RULE_systemProcessRefList = 13, RULE_systemProcessExpression = 14, RULE_progressMeasureDeclaration = 15, 
		RULE_selection = 16, RULE_declarationSequence = 17, RULE_declaration = 18, 
		RULE_declarationOfChannelPriority = 19, RULE_channelPrioritySpecExpression = 20, 
		RULE_channelRefList = 21, RULE_channelRefExpression = 22, RULE_channelVariableRefExpression = 23, 
		RULE_declarationOfVariable = 24, RULE_variableInitialization = 25, RULE_initializerExpression = 26, 
		RULE_declarationOfType = 27, RULE_declarationOfFunction = 28, RULE_functionNameParamsBody = 29, 
		RULE_statementBlock = 30, RULE_statement = 31, RULE_forLoopStatement = 32, 
		RULE_forLoopHeader = 33, RULE_iterationStatement = 34, RULE_iterationHeader = 35, 
		RULE_whileLoopStatement = 36, RULE_whileLoopHeader = 37, RULE_doWhileStatement = 38, 
		RULE_conditionalStatement = 39, RULE_returnStatement = 40, RULE_loopInitializer = 41, 
		RULE_loopCondition = 42, RULE_loopUpdate = 43, RULE_loopBody = 44, RULE_expression = 45, 
		RULE_parameterList = 46, RULE_parameter = 47, RULE_parameterIdentifier = 48, 
		RULE_argumentList = 49, RULE_type = 50, RULE_typeIdentifier = 51, RULE_fieldDeclaration = 52, 
		RULE_identifier = 53, RULE_arrayModifier = 54, RULE_typePrefix = 55;
	public static final String[] ruleNames = {
		"utaTemplateParameterList", "utaTransitionUpdateList", "utaDeclarations", 
		"utaTransitionSynchronization", "utaTransitionSelectionSequence", "utaTransitionGuardExpression", 
		"utaLocationInvariantExpression", "utaSystemDefinition", "systemDeclarationSequence", 
		"systemDeclarationStatement", "processVariableAssignment", "systemLine", 
		"systemProcessesList", "systemProcessRefList", "systemProcessExpression", 
		"progressMeasureDeclaration", "selection", "declarationSequence", "declaration", 
		"declarationOfChannelPriority", "channelPrioritySpecExpression", "channelRefList", 
		"channelRefExpression", "channelVariableRefExpression", "declarationOfVariable", 
		"variableInitialization", "initializerExpression", "declarationOfType", 
		"declarationOfFunction", "functionNameParamsBody", "statementBlock", "statement", 
		"forLoopStatement", "forLoopHeader", "iterationStatement", "iterationHeader", 
		"whileLoopStatement", "whileLoopHeader", "doWhileStatement", "conditionalStatement", 
		"returnStatement", "loopInitializer", "loopCondition", "loopUpdate", "loopBody", 
		"expression", "parameterList", "parameter", "parameterIdentifier", "argumentList", 
		"type", "typeIdentifier", "fieldDeclaration", "identifier", "arrayModifier", 
		"typePrefix"
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
	public String getGrammarFileName() { return "UTALanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public UTALanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class UtaTemplateParameterListContext extends ParserRuleContext {
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public UtaTemplateParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_utaTemplateParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterUtaTemplateParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitUtaTemplateParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitUtaTemplateParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UtaTemplateParameterListContext utaTemplateParameterList() throws RecognitionException {
		UtaTemplateParameterListContext _localctx = new UtaTemplateParameterListContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_utaTemplateParameterList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			parameterList();
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

	public static class UtaTransitionUpdateListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UTALanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UTALanguageParser.SEP_ENUMERATION, i);
		}
		public UtaTransitionUpdateListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_utaTransitionUpdateList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterUtaTransitionUpdateList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitUtaTransitionUpdateList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitUtaTransitionUpdateList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UtaTransitionUpdateListContext utaTransitionUpdateList() throws RecognitionException {
		UtaTransitionUpdateListContext _localctx = new UtaTransitionUpdateListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_utaTransitionUpdateList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			expression(0);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(115);
				match(SEP_ENUMERATION);
				setState(116);
				expression(0);
				}
				}
				setState(121);
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

	public static class UtaDeclarationsContext extends ParserRuleContext {
		public DeclarationSequenceContext declarationSequence() {
			return getRuleContext(DeclarationSequenceContext.class,0);
		}
		public UtaDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_utaDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterUtaDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitUtaDeclarations(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitUtaDeclarations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UtaDeclarationsContext utaDeclarations() throws RecognitionException {
		UtaDeclarationsContext _localctx = new UtaDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_utaDeclarations);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			declarationSequence();
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

	public static class UtaTransitionSynchronizationContext extends ParserRuleContext {
		public UtaTransitionSynchronizationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_utaTransitionSynchronization; }
	 
		public UtaTransitionSynchronizationContext() { }
		public void copyFrom(UtaTransitionSynchronizationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ActiveSynchronizationContext extends UtaTransitionSynchronizationContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMON_TOK_EXCLAMATION_MARK() { return getToken(UTALanguageParser.COMMON_TOK_EXCLAMATION_MARK, 0); }
		public ActiveSynchronizationContext(UtaTransitionSynchronizationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterActiveSynchronization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitActiveSynchronization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitActiveSynchronization(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReactiveSynchronizationContext extends UtaTransitionSynchronizationContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMON_TOK_QUESTION_MARK() { return getToken(UTALanguageParser.COMMON_TOK_QUESTION_MARK, 0); }
		public ReactiveSynchronizationContext(UtaTransitionSynchronizationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterReactiveSynchronization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitReactiveSynchronization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitReactiveSynchronization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UtaTransitionSynchronizationContext utaTransitionSynchronization() throws RecognitionException {
		UtaTransitionSynchronizationContext _localctx = new UtaTransitionSynchronizationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_utaTransitionSynchronization);
		try {
			setState(130);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ActiveSynchronizationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				expression(0);
				setState(125);
				match(COMMON_TOK_EXCLAMATION_MARK);
				}
				break;
			case 2:
				_localctx = new ReactiveSynchronizationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				expression(0);
				setState(128);
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

	public static class UtaTransitionSelectionSequenceContext extends ParserRuleContext {
		public List<SelectionContext> selection() {
			return getRuleContexts(SelectionContext.class);
		}
		public SelectionContext selection(int i) {
			return getRuleContext(SelectionContext.class,i);
		}
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UTALanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UTALanguageParser.SEP_ENUMERATION, i);
		}
		public UtaTransitionSelectionSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_utaTransitionSelectionSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterUtaTransitionSelectionSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitUtaTransitionSelectionSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitUtaTransitionSelectionSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UtaTransitionSelectionSequenceContext utaTransitionSelectionSequence() throws RecognitionException {
		UtaTransitionSelectionSequenceContext _localctx = new UtaTransitionSelectionSequenceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_utaTransitionSelectionSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			selection();
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(133);
				match(SEP_ENUMERATION);
				setState(134);
				selection();
				}
				}
				setState(139);
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

	public static class UtaTransitionGuardExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UtaTransitionGuardExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_utaTransitionGuardExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterUtaTransitionGuardExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitUtaTransitionGuardExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitUtaTransitionGuardExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UtaTransitionGuardExpressionContext utaTransitionGuardExpression() throws RecognitionException {
		UtaTransitionGuardExpressionContext _localctx = new UtaTransitionGuardExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_utaTransitionGuardExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			expression(0);
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

	public static class UtaLocationInvariantExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UtaLocationInvariantExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_utaLocationInvariantExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterUtaLocationInvariantExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitUtaLocationInvariantExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitUtaLocationInvariantExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UtaLocationInvariantExpressionContext utaLocationInvariantExpression() throws RecognitionException {
		UtaLocationInvariantExpressionContext _localctx = new UtaLocationInvariantExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_utaLocationInvariantExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			expression(0);
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

	public static class UtaSystemDefinitionContext extends ParserRuleContext {
		public SystemDeclarationSequenceContext systemDeclarationSequence() {
			return getRuleContext(SystemDeclarationSequenceContext.class,0);
		}
		public SystemLineContext systemLine() {
			return getRuleContext(SystemLineContext.class,0);
		}
		public ProgressMeasureDeclarationContext progressMeasureDeclaration() {
			return getRuleContext(ProgressMeasureDeclarationContext.class,0);
		}
		public UtaSystemDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_utaSystemDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterUtaSystemDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitUtaSystemDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitUtaSystemDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UtaSystemDefinitionContext utaSystemDefinition() throws RecognitionException {
		UtaSystemDefinitionContext _localctx = new UtaSystemDefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_utaSystemDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			systemDeclarationSequence();
			setState(146);
			_la = _input.LA(1);
			if (_la==PHRASE_SYSTEM) {
				{
				setState(145);
				systemLine();
				}
			}

			setState(149);
			_la = _input.LA(1);
			if (_la==PHRASE_PROGRESS) {
				{
				setState(148);
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

	public static class SystemDeclarationSequenceContext extends ParserRuleContext {
		public List<SystemDeclarationStatementContext> systemDeclarationStatement() {
			return getRuleContexts(SystemDeclarationStatementContext.class);
		}
		public SystemDeclarationStatementContext systemDeclarationStatement(int i) {
			return getRuleContext(SystemDeclarationStatementContext.class,i);
		}
		public SystemDeclarationSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_systemDeclarationSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterSystemDeclarationSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitSystemDeclarationSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitSystemDeclarationSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SystemDeclarationSequenceContext systemDeclarationSequence() throws RecognitionException {
		SystemDeclarationSequenceContext _localctx = new SystemDeclarationSequenceContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_systemDeclarationSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INTEGER) | (1L << TYPE_CLOCK) | (1L << TYPE_CHANNEL) | (1L << TYPE_BOOLEAN) | (1L << TYPE_SCALAR) | (1L << TYPE_STRUCT) | (1L << TYPE_PREFIX_URGENT) | (1L << TYPE_PREFIX_BROADCAST) | (1L << TYPE_PREFIX_META) | (1L << TYPE_PREFIX_CONST) | (1L << PHRASE_VOID))) != 0) || _la==PHRASE_TYPEDEF || _la==IDENTIFIER_NAME) {
				{
				{
				setState(151);
				systemDeclarationStatement();
				}
				}
				setState(156);
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

	public static class SystemDeclarationStatementContext extends ParserRuleContext {
		public ProcessVariableAssignmentContext processVariableAssignment() {
			return getRuleContext(ProcessVariableAssignmentContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public SystemDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_systemDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterSystemDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitSystemDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitSystemDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SystemDeclarationStatementContext systemDeclarationStatement() throws RecognitionException {
		SystemDeclarationStatementContext _localctx = new SystemDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_systemDeclarationStatement);
		try {
			setState(159);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				processVariableAssignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				declaration();
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

	public static class ProcessVariableAssignmentContext extends ParserRuleContext {
		public ProcessVariableAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_processVariableAssignment; }
	 
		public ProcessVariableAssignmentContext() { }
		public void copyFrom(ProcessVariableAssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProcessVarFullTemplateInstantiationContext extends ProcessVariableAssignmentContext {
		public List<TerminalNode> IDENTIFIER_NAME() { return getTokens(UTALanguageParser.IDENTIFIER_NAME); }
		public TerminalNode IDENTIFIER_NAME(int i) {
			return getToken(UTALanguageParser.IDENTIFIER_NAME, i);
		}
		public TerminalNode ASSG_OP() { return getToken(UTALanguageParser.ASSG_OP, 0); }
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UTALanguageParser.GROUP_LEFT_PAREN, 0); }
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UTALanguageParser.GROUP_RIGHT_PAREN, 0); }
		public TerminalNode SEP_SEMICOLON() { return getToken(UTALanguageParser.SEP_SEMICOLON, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ProcessVarFullTemplateInstantiationContext(ProcessVariableAssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterProcessVarFullTemplateInstantiation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitProcessVarFullTemplateInstantiation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitProcessVarFullTemplateInstantiation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ProcessVarPartialTemplateInstantiationContext extends ProcessVariableAssignmentContext {
		public List<TerminalNode> IDENTIFIER_NAME() { return getTokens(UTALanguageParser.IDENTIFIER_NAME); }
		public TerminalNode IDENTIFIER_NAME(int i) {
			return getToken(UTALanguageParser.IDENTIFIER_NAME, i);
		}
		public List<TerminalNode> GROUP_LEFT_PAREN() { return getTokens(UTALanguageParser.GROUP_LEFT_PAREN); }
		public TerminalNode GROUP_LEFT_PAREN(int i) {
			return getToken(UTALanguageParser.GROUP_LEFT_PAREN, i);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public List<TerminalNode> GROUP_RIGHT_PAREN() { return getTokens(UTALanguageParser.GROUP_RIGHT_PAREN); }
		public TerminalNode GROUP_RIGHT_PAREN(int i) {
			return getToken(UTALanguageParser.GROUP_RIGHT_PAREN, i);
		}
		public TerminalNode ASSG_OP() { return getToken(UTALanguageParser.ASSG_OP, 0); }
		public TerminalNode SEP_SEMICOLON() { return getToken(UTALanguageParser.SEP_SEMICOLON, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ProcessVarPartialTemplateInstantiationContext(ProcessVariableAssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterProcessVarPartialTemplateInstantiation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitProcessVarPartialTemplateInstantiation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitProcessVarPartialTemplateInstantiation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcessVariableAssignmentContext processVariableAssignment() throws RecognitionException {
		ProcessVariableAssignmentContext _localctx = new ProcessVariableAssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_processVariableAssignment);
		int _la;
		try {
			setState(183);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new ProcessVarPartialTemplateInstantiationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				match(IDENTIFIER_NAME);
				setState(162);
				match(GROUP_LEFT_PAREN);
				setState(163);
				parameterList();
				setState(164);
				match(GROUP_RIGHT_PAREN);
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
					argumentList();
					}
				}

				setState(171);
				match(GROUP_RIGHT_PAREN);
				setState(172);
				match(SEP_SEMICOLON);
				}
				break;
			case 2:
				_localctx = new ProcessVarFullTemplateInstantiationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(IDENTIFIER_NAME);
				setState(175);
				match(ASSG_OP);
				setState(176);
				match(IDENTIFIER_NAME);
				setState(177);
				match(GROUP_LEFT_PAREN);
				setState(179);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPR_LITERAL_TRUE) | (1L << EXPR_LITERAL_FALSE) | (1L << EXPR_LITERAL_DEADLOCK) | (1L << UNARY_OP_INCREMENT) | (1L << UNARY_OP_DECREMENT) | (1L << COMMON_TOK_PLUS) | (1L << COMMON_TOK_MINUS) | (1L << COMMON_TOK_EXCLAMATION_MARK) | (1L << GROUP_LEFT_PAREN) | (1L << PHRASE_NOT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (PHRASE_FOR_ALL - 67)) | (1L << (PHRASE_EXISTS - 67)) | (1L << (IDENTIFIER_NAME - 67)) | (1L << (NATURAL_NUMBER - 67)))) != 0)) {
					{
					setState(178);
					argumentList();
					}
				}

				setState(181);
				match(GROUP_RIGHT_PAREN);
				setState(182);
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

	public static class SystemLineContext extends ParserRuleContext {
		public TerminalNode PHRASE_SYSTEM() { return getToken(UTALanguageParser.PHRASE_SYSTEM, 0); }
		public SystemProcessesListContext systemProcessesList() {
			return getRuleContext(SystemProcessesListContext.class,0);
		}
		public TerminalNode SEP_SEMICOLON() { return getToken(UTALanguageParser.SEP_SEMICOLON, 0); }
		public SystemLineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_systemLine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterSystemLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitSystemLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitSystemLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SystemLineContext systemLine() throws RecognitionException {
		SystemLineContext _localctx = new SystemLineContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_systemLine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(PHRASE_SYSTEM);
			setState(186);
			systemProcessesList();
			setState(187);
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

	public static class SystemProcessesListContext extends ParserRuleContext {
		public List<SystemProcessRefListContext> systemProcessRefList() {
			return getRuleContexts(SystemProcessRefListContext.class);
		}
		public SystemProcessRefListContext systemProcessRefList(int i) {
			return getRuleContext(SystemProcessRefListContext.class,i);
		}
		public List<TerminalNode> COMMON_TOK_LESS_THAN() { return getTokens(UTALanguageParser.COMMON_TOK_LESS_THAN); }
		public TerminalNode COMMON_TOK_LESS_THAN(int i) {
			return getToken(UTALanguageParser.COMMON_TOK_LESS_THAN, i);
		}
		public SystemProcessesListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_systemProcessesList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterSystemProcessesList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitSystemProcessesList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitSystemProcessesList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SystemProcessesListContext systemProcessesList() throws RecognitionException {
		SystemProcessesListContext _localctx = new SystemProcessesListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_systemProcessesList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			systemProcessRefList();
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMON_TOK_LESS_THAN) {
				{
				{
				setState(190);
				match(COMMON_TOK_LESS_THAN);
				setState(191);
				systemProcessRefList();
				}
				}
				setState(196);
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

	public static class SystemProcessRefListContext extends ParserRuleContext {
		public List<SystemProcessExpressionContext> systemProcessExpression() {
			return getRuleContexts(SystemProcessExpressionContext.class);
		}
		public SystemProcessExpressionContext systemProcessExpression(int i) {
			return getRuleContext(SystemProcessExpressionContext.class,i);
		}
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UTALanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UTALanguageParser.SEP_ENUMERATION, i);
		}
		public SystemProcessRefListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_systemProcessRefList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterSystemProcessRefList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitSystemProcessRefList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitSystemProcessRefList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SystemProcessRefListContext systemProcessRefList() throws RecognitionException {
		SystemProcessRefListContext _localctx = new SystemProcessRefListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_systemProcessRefList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			systemProcessExpression();
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(198);
				match(SEP_ENUMERATION);
				setState(199);
				systemProcessExpression();
				}
				}
				setState(204);
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

	public static class SystemProcessExpressionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER_NAME() { return getToken(UTALanguageParser.IDENTIFIER_NAME, 0); }
		public SystemProcessExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_systemProcessExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterSystemProcessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitSystemProcessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitSystemProcessExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SystemProcessExpressionContext systemProcessExpression() throws RecognitionException {
		SystemProcessExpressionContext _localctx = new SystemProcessExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_systemProcessExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(IDENTIFIER_NAME);
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
		public TerminalNode PHRASE_PROGRESS() { return getToken(UTALanguageParser.PHRASE_PROGRESS, 0); }
		public TerminalNode GROUP_LEFT_CURLY() { return getToken(UTALanguageParser.GROUP_LEFT_CURLY, 0); }
		public TerminalNode GROUP_RIGHT_CURLY() { return getToken(UTALanguageParser.GROUP_RIGHT_CURLY, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SEP_SEMICOLON() { return getTokens(UTALanguageParser.SEP_SEMICOLON); }
		public TerminalNode SEP_SEMICOLON(int i) {
			return getToken(UTALanguageParser.SEP_SEMICOLON, i);
		}
		public ProgressMeasureDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_progressMeasureDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterProgressMeasureDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitProgressMeasureDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitProgressMeasureDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgressMeasureDeclarationContext progressMeasureDeclaration() throws RecognitionException {
		ProgressMeasureDeclarationContext _localctx = new ProgressMeasureDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_progressMeasureDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(PHRASE_PROGRESS);
			setState(208);
			match(GROUP_LEFT_CURLY);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPR_LITERAL_TRUE) | (1L << EXPR_LITERAL_FALSE) | (1L << EXPR_LITERAL_DEADLOCK) | (1L << UNARY_OP_INCREMENT) | (1L << UNARY_OP_DECREMENT) | (1L << COMMON_TOK_PLUS) | (1L << COMMON_TOK_MINUS) | (1L << COMMON_TOK_EXCLAMATION_MARK) | (1L << GROUP_LEFT_PAREN) | (1L << PHRASE_NOT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (PHRASE_FOR_ALL - 67)) | (1L << (PHRASE_EXISTS - 67)) | (1L << (IDENTIFIER_NAME - 67)) | (1L << (NATURAL_NUMBER - 67)))) != 0)) {
				{
				{
				setState(209);
				expression(0);
				setState(210);
				match(SEP_SEMICOLON);
				}
				}
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(217);
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

	public static class SelectionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER_NAME() { return getToken(UTALanguageParser.IDENTIFIER_NAME, 0); }
		public TerminalNode COMMON_TOK_COLON() { return getToken(UTALanguageParser.COMMON_TOK_COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitSelection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_selection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(IDENTIFIER_NAME);
			setState(220);
			match(COMMON_TOK_COLON);
			setState(221);
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
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterDeclarationSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitDeclarationSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitDeclarationSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationSequenceContext declarationSequence() throws RecognitionException {
		DeclarationSequenceContext _localctx = new DeclarationSequenceContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_declarationSequence);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(223);
					declaration();
					}
					} 
				}
				setState(228);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationOfVariableContext declarationOfVariable() {
			return getRuleContext(DeclarationOfVariableContext.class,0);
		}
		public DeclarationOfTypeContext declarationOfType() {
			return getRuleContext(DeclarationOfTypeContext.class,0);
		}
		public DeclarationOfFunctionContext declarationOfFunction() {
			return getRuleContext(DeclarationOfFunctionContext.class,0);
		}
		public DeclarationOfChannelPriorityContext declarationOfChannelPriority() {
			return getRuleContext(DeclarationOfChannelPriorityContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_declaration);
		try {
			setState(233);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				declarationOfVariable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				declarationOfType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(231);
				declarationOfFunction();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(232);
				declarationOfChannelPriority();
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

	public static class DeclarationOfChannelPriorityContext extends ParserRuleContext {
		public TerminalNode TYPE_CHANNEL() { return getToken(UTALanguageParser.TYPE_CHANNEL, 0); }
		public TerminalNode PHRASE_PRIORITY() { return getToken(UTALanguageParser.PHRASE_PRIORITY, 0); }
		public ChannelPrioritySpecExpressionContext channelPrioritySpecExpression() {
			return getRuleContext(ChannelPrioritySpecExpressionContext.class,0);
		}
		public TerminalNode SEP_SEMICOLON() { return getToken(UTALanguageParser.SEP_SEMICOLON, 0); }
		public DeclarationOfChannelPriorityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationOfChannelPriority; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterDeclarationOfChannelPriority(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitDeclarationOfChannelPriority(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitDeclarationOfChannelPriority(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationOfChannelPriorityContext declarationOfChannelPriority() throws RecognitionException {
		DeclarationOfChannelPriorityContext _localctx = new DeclarationOfChannelPriorityContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_declarationOfChannelPriority);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(TYPE_CHANNEL);
			setState(236);
			match(PHRASE_PRIORITY);
			setState(237);
			channelPrioritySpecExpression();
			setState(238);
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

	public static class ChannelPrioritySpecExpressionContext extends ParserRuleContext {
		public List<ChannelRefListContext> channelRefList() {
			return getRuleContexts(ChannelRefListContext.class);
		}
		public ChannelRefListContext channelRefList(int i) {
			return getRuleContext(ChannelRefListContext.class,i);
		}
		public List<TerminalNode> COMMON_TOK_LESS_THAN() { return getTokens(UTALanguageParser.COMMON_TOK_LESS_THAN); }
		public TerminalNode COMMON_TOK_LESS_THAN(int i) {
			return getToken(UTALanguageParser.COMMON_TOK_LESS_THAN, i);
		}
		public ChannelPrioritySpecExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_channelPrioritySpecExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterChannelPrioritySpecExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitChannelPrioritySpecExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitChannelPrioritySpecExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChannelPrioritySpecExpressionContext channelPrioritySpecExpression() throws RecognitionException {
		ChannelPrioritySpecExpressionContext _localctx = new ChannelPrioritySpecExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_channelPrioritySpecExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			channelRefList();
			setState(243); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(241);
				match(COMMON_TOK_LESS_THAN);
				setState(242);
				channelRefList();
				}
				}
				setState(245); 
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

	public static class ChannelRefListContext extends ParserRuleContext {
		public List<ChannelRefExpressionContext> channelRefExpression() {
			return getRuleContexts(ChannelRefExpressionContext.class);
		}
		public ChannelRefExpressionContext channelRefExpression(int i) {
			return getRuleContext(ChannelRefExpressionContext.class,i);
		}
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UTALanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UTALanguageParser.SEP_ENUMERATION, i);
		}
		public ChannelRefListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_channelRefList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterChannelRefList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitChannelRefList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitChannelRefList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChannelRefListContext channelRefList() throws RecognitionException {
		ChannelRefListContext _localctx = new ChannelRefListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_channelRefList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			channelRefExpression();
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(248);
				match(SEP_ENUMERATION);
				setState(249);
				channelRefExpression();
				}
				}
				setState(254);
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

	public static class ChannelRefExpressionContext extends ParserRuleContext {
		public ChannelRefExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_channelRefExpression; }
	 
		public ChannelRefExpressionContext() { }
		public void copyFrom(ChannelRefExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ChannelDefaultPriorityRefContext extends ChannelRefExpressionContext {
		public TerminalNode PHRASE_DEFAULT() { return getToken(UTALanguageParser.PHRASE_DEFAULT, 0); }
		public ChannelDefaultPriorityRefContext(ChannelRefExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterChannelDefaultPriorityRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitChannelDefaultPriorityRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitChannelDefaultPriorityRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ChannelVariablePriorityRefContext extends ChannelRefExpressionContext {
		public ChannelVariableRefExpressionContext channelVariableRefExpression() {
			return getRuleContext(ChannelVariableRefExpressionContext.class,0);
		}
		public ChannelVariablePriorityRefContext(ChannelRefExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterChannelVariablePriorityRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitChannelVariablePriorityRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitChannelVariablePriorityRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChannelRefExpressionContext channelRefExpression() throws RecognitionException {
		ChannelRefExpressionContext _localctx = new ChannelRefExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_channelRefExpression);
		try {
			setState(257);
			switch (_input.LA(1)) {
			case PHRASE_DEFAULT:
				_localctx = new ChannelDefaultPriorityRefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				match(PHRASE_DEFAULT);
				}
				break;
			case IDENTIFIER_NAME:
				_localctx = new ChannelVariablePriorityRefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				channelVariableRefExpression(0);
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

	public static class ChannelVariableRefExpressionContext extends ParserRuleContext {
		public ChannelVariableRefExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_channelVariableRefExpression; }
	 
		public ChannelVariableRefExpressionContext() { }
		public void copyFrom(ChannelVariableRefExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ChannelVarRefArrayLookupContext extends ChannelVariableRefExpressionContext {
		public ChannelVariableRefExpressionContext channelVariableRefExpression() {
			return getRuleContext(ChannelVariableRefExpressionContext.class,0);
		}
		public TerminalNode GROUP_LEFT_BRACKET() { return getToken(UTALanguageParser.GROUP_LEFT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_BRACKET() { return getToken(UTALanguageParser.GROUP_RIGHT_BRACKET, 0); }
		public ChannelVarRefArrayLookupContext(ChannelVariableRefExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterChannelVarRefArrayLookup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitChannelVarRefArrayLookup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitChannelVarRefArrayLookup(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ChannelVarIdentifierRefContext extends ChannelVariableRefExpressionContext {
		public TerminalNode IDENTIFIER_NAME() { return getToken(UTALanguageParser.IDENTIFIER_NAME, 0); }
		public ChannelVarIdentifierRefContext(ChannelVariableRefExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterChannelVarIdentifierRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitChannelVarIdentifierRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitChannelVarIdentifierRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChannelVariableRefExpressionContext channelVariableRefExpression() throws RecognitionException {
		return channelVariableRefExpression(0);
	}

	private ChannelVariableRefExpressionContext channelVariableRefExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ChannelVariableRefExpressionContext _localctx = new ChannelVariableRefExpressionContext(_ctx, _parentState);
		ChannelVariableRefExpressionContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_channelVariableRefExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ChannelVarIdentifierRefContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(260);
			match(IDENTIFIER_NAME);
			}
			_ctx.stop = _input.LT(-1);
			setState(269);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ChannelVarRefArrayLookupContext(new ChannelVariableRefExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_channelVariableRefExpression);
					setState(262);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(263);
					match(GROUP_LEFT_BRACKET);
					setState(264);
					expression(0);
					setState(265);
					match(GROUP_RIGHT_BRACKET);
					}
					} 
				}
				setState(271);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class DeclarationOfVariableContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<VariableInitializationContext> variableInitialization() {
			return getRuleContexts(VariableInitializationContext.class);
		}
		public VariableInitializationContext variableInitialization(int i) {
			return getRuleContext(VariableInitializationContext.class,i);
		}
		public TerminalNode SEP_SEMICOLON() { return getToken(UTALanguageParser.SEP_SEMICOLON, 0); }
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UTALanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UTALanguageParser.SEP_ENUMERATION, i);
		}
		public DeclarationOfVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationOfVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterDeclarationOfVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitDeclarationOfVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitDeclarationOfVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationOfVariableContext declarationOfVariable() throws RecognitionException {
		DeclarationOfVariableContext _localctx = new DeclarationOfVariableContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_declarationOfVariable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			type();
			setState(273);
			variableInitialization();
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(274);
				match(SEP_ENUMERATION);
				setState(275);
				variableInitialization();
				}
				}
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(281);
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

	public static class VariableInitializationContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSG_OP() { return getToken(UTALanguageParser.ASSG_OP, 0); }
		public InitializerExpressionContext initializerExpression() {
			return getRuleContext(InitializerExpressionContext.class,0);
		}
		public VariableInitializationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitialization; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterVariableInitialization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitVariableInitialization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitVariableInitialization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableInitializationContext variableInitialization() throws RecognitionException {
		VariableInitializationContext _localctx = new VariableInitializationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_variableInitialization);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			identifier();
			setState(286);
			_la = _input.LA(1);
			if (_la==ASSG_OP) {
				{
				setState(284);
				match(ASSG_OP);
				setState(285);
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
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterFlatInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitFlatInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitFlatInitializer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructuredInitializerContext extends InitializerExpressionContext {
		public TerminalNode GROUP_LEFT_CURLY() { return getToken(UTALanguageParser.GROUP_LEFT_CURLY, 0); }
		public List<InitializerExpressionContext> initializerExpression() {
			return getRuleContexts(InitializerExpressionContext.class);
		}
		public InitializerExpressionContext initializerExpression(int i) {
			return getRuleContext(InitializerExpressionContext.class,i);
		}
		public TerminalNode GROUP_RIGHT_CURLY() { return getToken(UTALanguageParser.GROUP_RIGHT_CURLY, 0); }
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UTALanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UTALanguageParser.SEP_ENUMERATION, i);
		}
		public StructuredInitializerContext(InitializerExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterStructuredInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitStructuredInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitStructuredInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerExpressionContext initializerExpression() throws RecognitionException {
		InitializerExpressionContext _localctx = new InitializerExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_initializerExpression);
		int _la;
		try {
			setState(300);
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
				setState(288);
				expression(0);
				}
				break;
			case GROUP_LEFT_CURLY:
				_localctx = new StructuredInitializerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				match(GROUP_LEFT_CURLY);
				setState(290);
				initializerExpression();
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP_ENUMERATION) {
					{
					{
					setState(291);
					match(SEP_ENUMERATION);
					setState(292);
					initializerExpression();
					}
					}
					setState(297);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(298);
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

	public static class DeclarationOfTypeContext extends ParserRuleContext {
		public TerminalNode PHRASE_TYPEDEF() { return getToken(UTALanguageParser.PHRASE_TYPEDEF, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode SEP_SEMICOLON() { return getToken(UTALanguageParser.SEP_SEMICOLON, 0); }
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UTALanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UTALanguageParser.SEP_ENUMERATION, i);
		}
		public DeclarationOfTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationOfType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterDeclarationOfType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitDeclarationOfType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitDeclarationOfType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationOfTypeContext declarationOfType() throws RecognitionException {
		DeclarationOfTypeContext _localctx = new DeclarationOfTypeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_declarationOfType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(PHRASE_TYPEDEF);
			setState(303);
			type();
			setState(304);
			identifier();
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(305);
				match(SEP_ENUMERATION);
				setState(306);
				identifier();
				}
				}
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(312);
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
	public static class DeclarationOfVoidFunctionContext extends DeclarationOfFunctionContext {
		public TerminalNode PHRASE_VOID() { return getToken(UTALanguageParser.PHRASE_VOID, 0); }
		public FunctionNameParamsBodyContext functionNameParamsBody() {
			return getRuleContext(FunctionNameParamsBodyContext.class,0);
		}
		public DeclarationOfVoidFunctionContext(DeclarationOfFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterDeclarationOfVoidFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitDeclarationOfVoidFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitDeclarationOfVoidFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclarationOfValueFunctionContext extends DeclarationOfFunctionContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FunctionNameParamsBodyContext functionNameParamsBody() {
			return getRuleContext(FunctionNameParamsBodyContext.class,0);
		}
		public DeclarationOfValueFunctionContext(DeclarationOfFunctionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterDeclarationOfValueFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitDeclarationOfValueFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitDeclarationOfValueFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationOfFunctionContext declarationOfFunction() throws RecognitionException {
		DeclarationOfFunctionContext _localctx = new DeclarationOfFunctionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_declarationOfFunction);
		try {
			setState(319);
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
				_localctx = new DeclarationOfValueFunctionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				type();
				setState(315);
				functionNameParamsBody();
				}
				break;
			case PHRASE_VOID:
				_localctx = new DeclarationOfVoidFunctionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(317);
				match(PHRASE_VOID);
				setState(318);
				functionNameParamsBody();
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

	public static class FunctionNameParamsBodyContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER_NAME() { return getToken(UTALanguageParser.IDENTIFIER_NAME, 0); }
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UTALanguageParser.GROUP_LEFT_PAREN, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UTALanguageParser.GROUP_RIGHT_PAREN, 0); }
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public FunctionNameParamsBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionNameParamsBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterFunctionNameParamsBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitFunctionNameParamsBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitFunctionNameParamsBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionNameParamsBodyContext functionNameParamsBody() throws RecognitionException {
		FunctionNameParamsBodyContext _localctx = new FunctionNameParamsBodyContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_functionNameParamsBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(IDENTIFIER_NAME);
			setState(322);
			match(GROUP_LEFT_PAREN);
			setState(323);
			parameterList();
			setState(324);
			match(GROUP_RIGHT_PAREN);
			setState(325);
			statementBlock();
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
		public TerminalNode GROUP_LEFT_CURLY() { return getToken(UTALanguageParser.GROUP_LEFT_CURLY, 0); }
		public DeclarationSequenceContext declarationSequence() {
			return getRuleContext(DeclarationSequenceContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_CURLY() { return getToken(UTALanguageParser.GROUP_RIGHT_CURLY, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterStatementBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitStatementBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitStatementBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementBlockContext statementBlock() throws RecognitionException {
		StatementBlockContext _localctx = new StatementBlockContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_statementBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(GROUP_LEFT_CURLY);
			setState(328);
			declarationSequence();
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPR_LITERAL_TRUE) | (1L << EXPR_LITERAL_FALSE) | (1L << EXPR_LITERAL_DEADLOCK) | (1L << UNARY_OP_INCREMENT) | (1L << UNARY_OP_DECREMENT) | (1L << COMMON_TOK_PLUS) | (1L << COMMON_TOK_MINUS) | (1L << COMMON_TOK_EXCLAMATION_MARK) | (1L << GROUP_LEFT_CURLY) | (1L << GROUP_LEFT_PAREN) | (1L << SEP_SEMICOLON) | (1L << PHRASE_NOT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (PHRASE_FOR_ALL - 67)) | (1L << (PHRASE_EXISTS - 67)) | (1L << (PHRASE_IF - 67)) | (1L << (PHRASE_FOR - 67)) | (1L << (PHRASE_WHILE - 67)) | (1L << (PHRASE_RETURN - 67)) | (1L << (PHRASE_DO - 67)) | (1L << (IDENTIFIER_NAME - 67)) | (1L << (NATURAL_NUMBER - 67)))) != 0)) {
				{
				{
				setState(329);
				statement();
				}
				}
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(335);
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
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public StatementReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterStatementReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitStatementReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitStatementReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatetementBlockContext extends StatementContext {
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public StatetementBlockContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterStatetementBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitStatetementBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitStatetementBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementEmptyContext extends StatementContext {
		public TerminalNode SEP_SEMICOLON() { return getToken(UTALanguageParser.SEP_SEMICOLON, 0); }
		public StatementEmptyContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterStatementEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitStatementEmpty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitStatementEmpty(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementExpressionContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEP_SEMICOLON() { return getToken(UTALanguageParser.SEP_SEMICOLON, 0); }
		public StatementExpressionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterStatementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitStatementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitStatementExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementForLoopContext extends StatementContext {
		public ForLoopStatementContext forLoopStatement() {
			return getRuleContext(ForLoopStatementContext.class,0);
		}
		public StatementForLoopContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterStatementForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitStatementForLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitStatementForLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementIterationContext extends StatementContext {
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public StatementIterationContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterStatementIteration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitStatementIteration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitStatementIteration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementConditionalContext extends StatementContext {
		public ConditionalStatementContext conditionalStatement() {
			return getRuleContext(ConditionalStatementContext.class,0);
		}
		public StatementConditionalContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterStatementConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitStatementConditional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitStatementConditional(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementDoWhileContext extends StatementContext {
		public DoWhileStatementContext doWhileStatement() {
			return getRuleContext(DoWhileStatementContext.class,0);
		}
		public StatementDoWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterStatementDoWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitStatementDoWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitStatementDoWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementWhileLoopContext extends StatementContext {
		public WhileLoopStatementContext whileLoopStatement() {
			return getRuleContext(WhileLoopStatementContext.class,0);
		}
		public StatementWhileLoopContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterStatementWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitStatementWhileLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitStatementWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_statement);
		try {
			setState(348);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new StatetementBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				statementBlock();
				}
				break;
			case 2:
				_localctx = new StatementEmptyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
				match(SEP_SEMICOLON);
				}
				break;
			case 3:
				_localctx = new StatementExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(339);
				expression(0);
				setState(340);
				match(SEP_SEMICOLON);
				}
				break;
			case 4:
				_localctx = new StatementForLoopContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(342);
				forLoopStatement();
				}
				break;
			case 5:
				_localctx = new StatementIterationContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(343);
				iterationStatement();
				}
				break;
			case 6:
				_localctx = new StatementWhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(344);
				whileLoopStatement();
				}
				break;
			case 7:
				_localctx = new StatementDoWhileContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(345);
				doWhileStatement();
				}
				break;
			case 8:
				_localctx = new StatementConditionalContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(346);
				conditionalStatement();
				}
				break;
			case 9:
				_localctx = new StatementReturnContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(347);
				returnStatement();
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

	public static class ForLoopStatementContext extends ParserRuleContext {
		public ForLoopHeaderContext forLoopHeader() {
			return getRuleContext(ForLoopHeaderContext.class,0);
		}
		public LoopBodyContext loopBody() {
			return getRuleContext(LoopBodyContext.class,0);
		}
		public ForLoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterForLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitForLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitForLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForLoopStatementContext forLoopStatement() throws RecognitionException {
		ForLoopStatementContext _localctx = new ForLoopStatementContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_forLoopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			forLoopHeader();
			setState(351);
			loopBody();
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

	public static class ForLoopHeaderContext extends ParserRuleContext {
		public TerminalNode PHRASE_FOR() { return getToken(UTALanguageParser.PHRASE_FOR, 0); }
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UTALanguageParser.GROUP_LEFT_PAREN, 0); }
		public LoopInitializerContext loopInitializer() {
			return getRuleContext(LoopInitializerContext.class,0);
		}
		public List<TerminalNode> SEP_SEMICOLON() { return getTokens(UTALanguageParser.SEP_SEMICOLON); }
		public TerminalNode SEP_SEMICOLON(int i) {
			return getToken(UTALanguageParser.SEP_SEMICOLON, i);
		}
		public LoopConditionContext loopCondition() {
			return getRuleContext(LoopConditionContext.class,0);
		}
		public LoopUpdateContext loopUpdate() {
			return getRuleContext(LoopUpdateContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UTALanguageParser.GROUP_RIGHT_PAREN, 0); }
		public ForLoopHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoopHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterForLoopHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitForLoopHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitForLoopHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForLoopHeaderContext forLoopHeader() throws RecognitionException {
		ForLoopHeaderContext _localctx = new ForLoopHeaderContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_forLoopHeader);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(PHRASE_FOR);
			setState(354);
			match(GROUP_LEFT_PAREN);
			setState(355);
			loopInitializer();
			setState(356);
			match(SEP_SEMICOLON);
			setState(357);
			loopCondition();
			setState(358);
			match(SEP_SEMICOLON);
			setState(359);
			loopUpdate();
			setState(360);
			match(GROUP_RIGHT_PAREN);
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

	public static class IterationStatementContext extends ParserRuleContext {
		public IterationHeaderContext iterationHeader() {
			return getRuleContext(IterationHeaderContext.class,0);
		}
		public LoopBodyContext loopBody() {
			return getRuleContext(LoopBodyContext.class,0);
		}
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterIterationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitIterationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitIterationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_iterationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			iterationHeader();
			setState(363);
			loopBody();
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

	public static class IterationHeaderContext extends ParserRuleContext {
		public TerminalNode PHRASE_FOR() { return getToken(UTALanguageParser.PHRASE_FOR, 0); }
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UTALanguageParser.GROUP_LEFT_PAREN, 0); }
		public TerminalNode IDENTIFIER_NAME() { return getToken(UTALanguageParser.IDENTIFIER_NAME, 0); }
		public TerminalNode COMMON_TOK_COLON() { return getToken(UTALanguageParser.COMMON_TOK_COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UTALanguageParser.GROUP_RIGHT_PAREN, 0); }
		public IterationHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterIterationHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitIterationHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitIterationHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationHeaderContext iterationHeader() throws RecognitionException {
		IterationHeaderContext _localctx = new IterationHeaderContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_iterationHeader);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			match(PHRASE_FOR);
			setState(366);
			match(GROUP_LEFT_PAREN);
			setState(367);
			match(IDENTIFIER_NAME);
			setState(368);
			match(COMMON_TOK_COLON);
			setState(369);
			type();
			setState(370);
			match(GROUP_RIGHT_PAREN);
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

	public static class WhileLoopStatementContext extends ParserRuleContext {
		public WhileLoopHeaderContext whileLoopHeader() {
			return getRuleContext(WhileLoopHeaderContext.class,0);
		}
		public LoopBodyContext loopBody() {
			return getRuleContext(LoopBodyContext.class,0);
		}
		public WhileLoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterWhileLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitWhileLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitWhileLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileLoopStatementContext whileLoopStatement() throws RecognitionException {
		WhileLoopStatementContext _localctx = new WhileLoopStatementContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_whileLoopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			whileLoopHeader();
			setState(373);
			loopBody();
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

	public static class WhileLoopHeaderContext extends ParserRuleContext {
		public TerminalNode PHRASE_WHILE() { return getToken(UTALanguageParser.PHRASE_WHILE, 0); }
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UTALanguageParser.GROUP_LEFT_PAREN, 0); }
		public LoopConditionContext loopCondition() {
			return getRuleContext(LoopConditionContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UTALanguageParser.GROUP_RIGHT_PAREN, 0); }
		public WhileLoopHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoopHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterWhileLoopHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitWhileLoopHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitWhileLoopHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileLoopHeaderContext whileLoopHeader() throws RecognitionException {
		WhileLoopHeaderContext _localctx = new WhileLoopHeaderContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_whileLoopHeader);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			match(PHRASE_WHILE);
			setState(376);
			match(GROUP_LEFT_PAREN);
			setState(377);
			loopCondition();
			setState(378);
			match(GROUP_RIGHT_PAREN);
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

	public static class DoWhileStatementContext extends ParserRuleContext {
		public TerminalNode PHRASE_DO() { return getToken(UTALanguageParser.PHRASE_DO, 0); }
		public LoopBodyContext loopBody() {
			return getRuleContext(LoopBodyContext.class,0);
		}
		public TerminalNode PHRASE_WHILE() { return getToken(UTALanguageParser.PHRASE_WHILE, 0); }
		public LoopConditionContext loopCondition() {
			return getRuleContext(LoopConditionContext.class,0);
		}
		public TerminalNode SEP_SEMICOLON() { return getToken(UTALanguageParser.SEP_SEMICOLON, 0); }
		public DoWhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterDoWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitDoWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitDoWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoWhileStatementContext doWhileStatement() throws RecognitionException {
		DoWhileStatementContext _localctx = new DoWhileStatementContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_doWhileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(PHRASE_DO);
			setState(381);
			loopBody();
			setState(382);
			match(PHRASE_WHILE);
			setState(383);
			loopCondition();
			setState(384);
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

	public static class ConditionalStatementContext extends ParserRuleContext {
		public TerminalNode PHRASE_IF() { return getToken(UTALanguageParser.PHRASE_IF, 0); }
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UTALanguageParser.GROUP_LEFT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UTALanguageParser.GROUP_RIGHT_PAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode PHRASE_ELSE() { return getToken(UTALanguageParser.PHRASE_ELSE, 0); }
		public ConditionalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterConditionalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitConditionalStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitConditionalStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionalStatementContext conditionalStatement() throws RecognitionException {
		ConditionalStatementContext _localctx = new ConditionalStatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_conditionalStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			match(PHRASE_IF);
			setState(387);
			match(GROUP_LEFT_PAREN);
			setState(388);
			expression(0);
			setState(389);
			match(GROUP_RIGHT_PAREN);
			setState(390);
			statement();
			setState(393);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(391);
				match(PHRASE_ELSE);
				setState(392);
				statement();
				}
				break;
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode PHRASE_RETURN() { return getToken(UTALanguageParser.PHRASE_RETURN, 0); }
		public TerminalNode SEP_SEMICOLON() { return getToken(UTALanguageParser.SEP_SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(PHRASE_RETURN);
			setState(397);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXPR_LITERAL_TRUE) | (1L << EXPR_LITERAL_FALSE) | (1L << EXPR_LITERAL_DEADLOCK) | (1L << UNARY_OP_INCREMENT) | (1L << UNARY_OP_DECREMENT) | (1L << COMMON_TOK_PLUS) | (1L << COMMON_TOK_MINUS) | (1L << COMMON_TOK_EXCLAMATION_MARK) | (1L << GROUP_LEFT_PAREN) | (1L << PHRASE_NOT))) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & ((1L << (PHRASE_FOR_ALL - 67)) | (1L << (PHRASE_EXISTS - 67)) | (1L << (IDENTIFIER_NAME - 67)) | (1L << (NATURAL_NUMBER - 67)))) != 0)) {
				{
				setState(396);
				expression(0);
				}
			}

			setState(399);
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

	public static class LoopInitializerContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LoopInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterLoopInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitLoopInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitLoopInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopInitializerContext loopInitializer() throws RecognitionException {
		LoopInitializerContext _localctx = new LoopInitializerContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_loopInitializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			expression(0);
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

	public static class LoopConditionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LoopConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterLoopCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitLoopCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitLoopCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopConditionContext loopCondition() throws RecognitionException {
		LoopConditionContext _localctx = new LoopConditionContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_loopCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			expression(0);
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

	public static class LoopUpdateContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LoopUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterLoopUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitLoopUpdate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitLoopUpdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopUpdateContext loopUpdate() throws RecognitionException {
		LoopUpdateContext _localctx = new LoopUpdateContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_loopUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			expression(0);
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

	public static class LoopBodyContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LoopBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterLoopBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitLoopBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitLoopBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopBodyContext loopBody() throws RecognitionException {
		LoopBodyContext _localctx = new LoopBodyContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_loopBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			statement();
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
	public static class ExpressionExistentialQuantificationContext extends ExpressionContext {
		public TerminalNode PHRASE_EXISTS() { return getToken(UTALanguageParser.PHRASE_EXISTS, 0); }
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UTALanguageParser.GROUP_LEFT_PAREN, 0); }
		public TerminalNode IDENTIFIER_NAME() { return getToken(UTALanguageParser.IDENTIFIER_NAME, 0); }
		public TerminalNode COMMON_TOK_COLON() { return getToken(UTALanguageParser.COMMON_TOK_COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UTALanguageParser.GROUP_RIGHT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionExistentialQuantificationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionExistentialQuantification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionExistentialQuantification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionExistentialQuantification(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionUniversalQuantificationContext extends ExpressionContext {
		public TerminalNode PHRASE_FOR_ALL() { return getToken(UTALanguageParser.PHRASE_FOR_ALL, 0); }
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UTALanguageParser.GROUP_LEFT_PAREN, 0); }
		public TerminalNode IDENTIFIER_NAME() { return getToken(UTALanguageParser.IDENTIFIER_NAME, 0); }
		public TerminalNode COMMON_TOK_COLON() { return getToken(UTALanguageParser.COMMON_TOK_COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UTALanguageParser.GROUP_RIGHT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionUniversalQuantificationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionUniversalQuantification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionUniversalQuantification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionUniversalQuantification(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpMultiplicationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_MULTIPLICATION() { return getToken(UTALanguageParser.BINARY_OP_MULTIPLICATION, 0); }
		public ExpressionBinaryOpMultiplicationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpMultiplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionAssignOpBitwiseAndContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_BITWISE_AND() { return getToken(UTALanguageParser.ASSG_OP_BITWISE_AND, 0); }
		public ExpressionAssignOpBitwiseAndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionAssignOpBitwiseAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionAssignOpBitwiseAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionAssignOpBitwiseAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpGreaterThanContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_GREATER_THAN() { return getToken(UTALanguageParser.BINARY_OP_GREATER_THAN, 0); }
		public ExpressionBinaryOpGreaterThanContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpGreaterThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpGreaterThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpGreaterThan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionAssignOpMultiplicationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_MULTIPLICATION() { return getToken(UTALanguageParser.ASSG_OP_MULTIPLICATION, 0); }
		public ExpressionAssignOpMultiplicationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionAssignOpMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionAssignOpMultiplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionAssignOpMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpMaximumContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_MAX() { return getToken(UTALanguageParser.BINARY_OP_MAX, 0); }
		public ExpressionBinaryOpMaximumContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpMaximum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpMaximum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpMaximum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionNaturalNumberContext extends ExpressionContext {
		public TerminalNode NATURAL_NUMBER() { return getToken(UTALanguageParser.NATURAL_NUMBER, 0); }
		public ExpressionNaturalNumberContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionNaturalNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionNaturalNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionNaturalNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionDecrementAndGetContext extends ExpressionContext {
		public TerminalNode UNARY_OP_DECREMENT() { return getToken(UTALanguageParser.UNARY_OP_DECREMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionDecrementAndGetContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionDecrementAndGet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionDecrementAndGet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionDecrementAndGet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionCallContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UTALanguageParser.GROUP_LEFT_PAREN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UTALanguageParser.GROUP_RIGHT_PAREN, 0); }
		public ExpressionCallContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionTernaryContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMON_TOK_QUESTION_MARK() { return getToken(UTALanguageParser.COMMON_TOK_QUESTION_MARK, 0); }
		public TerminalNode COMMON_TOK_COLON() { return getToken(UTALanguageParser.COMMON_TOK_COLON, 0); }
		public ExpressionTernaryContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionTernary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionTernary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionTernary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpEqualContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_EQUAL() { return getToken(UTALanguageParser.BINARY_OP_EQUAL, 0); }
		public ExpressionBinaryOpEqualContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionAssignOpModuloContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_MODULO() { return getToken(UTALanguageParser.ASSG_OP_MODULO, 0); }
		public ExpressionAssignOpModuloContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionAssignOpModulo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionAssignOpModulo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionAssignOpModulo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionAssignOpBitwiseXORContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_BITWISE_XOR() { return getToken(UTALanguageParser.ASSG_OP_BITWISE_XOR, 0); }
		public ExpressionAssignOpBitwiseXORContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionAssignOpBitwiseXOR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionAssignOpBitwiseXOR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionAssignOpBitwiseXOR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpLessThanOrEqualContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_LESS_THAN_OR_EQUAL_TO() { return getToken(UTALanguageParser.BINARY_OP_LESS_THAN_OR_EQUAL_TO, 0); }
		public ExpressionBinaryOpLessThanOrEqualContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpLessThanOrEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpLessThanOrEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpLessThanOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpRightShiftContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_RIGHT_SHIFT() { return getToken(UTALanguageParser.BINARY_OP_RIGHT_SHIFT, 0); }
		public ExpressionBinaryOpRightShiftContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpRightShift(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpRightShift(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpRightShift(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpConjunctionPhraseContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PHRASE_AND() { return getToken(UTALanguageParser.PHRASE_AND, 0); }
		public ExpressionBinaryOpConjunctionPhraseContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpConjunctionPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpConjunctionPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpConjunctionPhrase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionUnaryOpNegatedPhraseContext extends ExpressionContext {
		public TerminalNode PHRASE_NOT() { return getToken(UTALanguageParser.PHRASE_NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionUnaryOpNegatedPhraseContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionUnaryOpNegatedPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionUnaryOpNegatedPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionUnaryOpNegatedPhrase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpLessThanContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMON_TOK_LESS_THAN() { return getToken(UTALanguageParser.COMMON_TOK_LESS_THAN, 0); }
		public ExpressionBinaryOpLessThanContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpLessThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpLessThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpLessThan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionAssignOpSubtractionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_SUBTRACTION() { return getToken(UTALanguageParser.ASSG_OP_SUBTRACTION, 0); }
		public ExpressionAssignOpSubtractionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionAssignOpSubtraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionAssignOpSubtraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionAssignOpSubtraction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionIdentifierRefContext extends ExpressionContext {
		public TerminalNode IDENTIFIER_NAME() { return getToken(UTALanguageParser.IDENTIFIER_NAME, 0); }
		public ExpressionIdentifierRefContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionIdentifierRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionIdentifierRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionIdentifierRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpLeftShiftContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_LEFT_SHIFT() { return getToken(UTALanguageParser.BINARY_OP_LEFT_SHIFT, 0); }
		public ExpressionBinaryOpLeftShiftContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpLeftShift(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpLeftShift(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpLeftShift(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpSubtractionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMON_TOK_MINUS() { return getToken(UTALanguageParser.COMMON_TOK_MINUS, 0); }
		public ExpressionBinaryOpSubtractionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpSubtraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpSubtraction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpSubtraction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionTrueLiteralContext extends ExpressionContext {
		public TerminalNode EXPR_LITERAL_TRUE() { return getToken(UTALanguageParser.EXPR_LITERAL_TRUE, 0); }
		public ExpressionTrueLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionTrueLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionTrueLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionTrueLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpDisjunctionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_DISJUNCTION() { return getToken(UTALanguageParser.BINARY_OP_DISJUNCTION, 0); }
		public ExpressionBinaryOpDisjunctionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpDisjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpDisjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpDisjunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpBitwiseXORContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_BITWISE_XOR() { return getToken(UTALanguageParser.BINARY_OP_BITWISE_XOR, 0); }
		public ExpressionBinaryOpBitwiseXORContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpBitwiseXOR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpBitwiseXOR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpBitwiseXOR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionFalseLiteralContext extends ExpressionContext {
		public TerminalNode EXPR_LITERAL_FALSE() { return getToken(UTALanguageParser.EXPR_LITERAL_FALSE, 0); }
		public ExpressionFalseLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionFalseLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionFalseLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionFalseLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpBitwiseAndContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMON_TOK_AMPERSAND() { return getToken(UTALanguageParser.COMMON_TOK_AMPERSAND, 0); }
		public ExpressionBinaryOpBitwiseAndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpBitwiseAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpBitwiseAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpBitwiseAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionGetAndIncrementContext extends ExpressionContext {
		public TerminalNode UNARY_OP_INCREMENT() { return getToken(UTALanguageParser.UNARY_OP_INCREMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionGetAndIncrementContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionGetAndIncrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionGetAndIncrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionGetAndIncrement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpMinimumContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_MIN() { return getToken(UTALanguageParser.BINARY_OP_MIN, 0); }
		public ExpressionBinaryOpMinimumContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpMinimum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpMinimum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpMinimum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionFieldAccessContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode BINARY_OP_ACCESS_FIELD() { return getToken(UTALanguageParser.BINARY_OP_ACCESS_FIELD, 0); }
		public TerminalNode IDENTIFIER_NAME() { return getToken(UTALanguageParser.IDENTIFIER_NAME, 0); }
		public ExpressionFieldAccessContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionFieldAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionFieldAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionFieldAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpBitwiseOrContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_BITWISE_OR() { return getToken(UTALanguageParser.BINARY_OP_BITWISE_OR, 0); }
		public ExpressionBinaryOpBitwiseOrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpBitwiseOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpBitwiseOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpBitwiseOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionIncrementAndGetContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode UNARY_OP_INCREMENT() { return getToken(UTALanguageParser.UNARY_OP_INCREMENT, 0); }
		public ExpressionIncrementAndGetContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionIncrementAndGet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionIncrementAndGet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionIncrementAndGet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpAdditionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMON_TOK_PLUS() { return getToken(UTALanguageParser.COMMON_TOK_PLUS, 0); }
		public ExpressionBinaryOpAdditionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpAddition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpAddition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpAddition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionAssignOpRightShiftContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_RIGHT_SHIFT() { return getToken(UTALanguageParser.ASSG_OP_RIGHT_SHIFT, 0); }
		public ExpressionAssignOpRightShiftContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionAssignOpRightShift(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionAssignOpRightShift(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionAssignOpRightShift(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionUnaryOpNegatedContext extends ExpressionContext {
		public TerminalNode COMMON_TOK_EXCLAMATION_MARK() { return getToken(UTALanguageParser.COMMON_TOK_EXCLAMATION_MARK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionUnaryOpNegatedContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionUnaryOpNegated(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionUnaryOpNegated(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionUnaryOpNegated(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionDeadlockLiteralContext extends ExpressionContext {
		public TerminalNode EXPR_LITERAL_DEADLOCK() { return getToken(UTALanguageParser.EXPR_LITERAL_DEADLOCK, 0); }
		public ExpressionDeadlockLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionDeadlockLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionDeadlockLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionDeadlockLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpDivisionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_DIVISION() { return getToken(UTALanguageParser.BINARY_OP_DIVISION, 0); }
		public ExpressionBinaryOpDivisionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpDivision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpDivision(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpNotEqualContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_NOT_EQUAL() { return getToken(UTALanguageParser.BINARY_OP_NOT_EQUAL, 0); }
		public ExpressionBinaryOpNotEqualContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpNotEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpNotEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpNotEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionAssignOpBitwiseOrContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_BITWISE_OR() { return getToken(UTALanguageParser.ASSG_OP_BITWISE_OR, 0); }
		public ExpressionAssignOpBitwiseOrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionAssignOpBitwiseOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionAssignOpBitwiseOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionAssignOpBitwiseOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionAssignOpDivisionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_DIVISION() { return getToken(UTALanguageParser.ASSG_OP_DIVISION, 0); }
		public ExpressionAssignOpDivisionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionAssignOpDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionAssignOpDivision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionAssignOpDivision(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionGroupedContext extends ExpressionContext {
		public TerminalNode GROUP_LEFT_PAREN() { return getToken(UTALanguageParser.GROUP_LEFT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_PAREN() { return getToken(UTALanguageParser.GROUP_RIGHT_PAREN, 0); }
		public ExpressionGroupedContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionGrouped(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionGrouped(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionGrouped(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionArrayLookupContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GROUP_LEFT_BRACKET() { return getToken(UTALanguageParser.GROUP_LEFT_BRACKET, 0); }
		public TerminalNode GROUP_RIGHT_BRACKET() { return getToken(UTALanguageParser.GROUP_RIGHT_BRACKET, 0); }
		public ExpressionArrayLookupContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionArrayLookup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionArrayLookup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionArrayLookup(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionUnaryOpNegativeContext extends ExpressionContext {
		public TerminalNode COMMON_TOK_MINUS() { return getToken(UTALanguageParser.COMMON_TOK_MINUS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionUnaryOpNegativeContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionUnaryOpNegative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionUnaryOpNegative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionUnaryOpNegative(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpDisjunctionPhraseContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PHRASE_OR() { return getToken(UTALanguageParser.PHRASE_OR, 0); }
		public ExpressionBinaryOpDisjunctionPhraseContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpDisjunctionPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpDisjunctionPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpDisjunctionPhrase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpGreaterThanOrEqualContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_GREATER_THAN_OR_EQUAL() { return getToken(UTALanguageParser.BINARY_OP_GREATER_THAN_OR_EQUAL, 0); }
		public ExpressionBinaryOpGreaterThanOrEqualContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpGreaterThanOrEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpGreaterThanOrEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpGreaterThanOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionAssignOpLeftShiftContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_LEFT_SHIFT() { return getToken(UTALanguageParser.ASSG_OP_LEFT_SHIFT, 0); }
		public ExpressionAssignOpLeftShiftContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionAssignOpLeftShift(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionAssignOpLeftShift(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionAssignOpLeftShift(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpModuloContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_MODULO() { return getToken(UTALanguageParser.BINARY_OP_MODULO, 0); }
		public ExpressionBinaryOpModuloContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpModulo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpModulo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpModulo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionAssignOpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP() { return getToken(UTALanguageParser.ASSG_OP, 0); }
		public ExpressionAssignOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionAssignOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionAssignOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionAssignOp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpImplicationPhraseContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PHRASE_IMPLY() { return getToken(UTALanguageParser.PHRASE_IMPLY, 0); }
		public ExpressionBinaryOpImplicationPhraseContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpImplicationPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpImplicationPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpImplicationPhrase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionGetAndDecrementContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode UNARY_OP_DECREMENT() { return getToken(UTALanguageParser.UNARY_OP_DECREMENT, 0); }
		public ExpressionGetAndDecrementContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionGetAndDecrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionGetAndDecrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionGetAndDecrement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionUnaryOpPositiveContext extends ExpressionContext {
		public TerminalNode COMMON_TOK_PLUS() { return getToken(UTALanguageParser.COMMON_TOK_PLUS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionUnaryOpPositiveContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionUnaryOpPositive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionUnaryOpPositive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionUnaryOpPositive(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionBinaryOpConjunctionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BINARY_OP_CONJUNCTION() { return getToken(UTALanguageParser.BINARY_OP_CONJUNCTION, 0); }
		public ExpressionBinaryOpConjunctionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionBinaryOpConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionBinaryOpConjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionBinaryOpConjunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionAssignOpAdditionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSG_OP_ADDITION() { return getToken(UTALanguageParser.ASSG_OP_ADDITION, 0); }
		public ExpressionAssignOpAdditionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterExpressionAssignOpAddition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitExpressionAssignOpAddition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitExpressionAssignOpAddition(this);
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
		int _startState = 90;
		enterRecursionRule(_localctx, 90, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			switch (_input.LA(1)) {
			case COMMON_TOK_EXCLAMATION_MARK:
				{
				_localctx = new ExpressionUnaryOpNegatedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(410);
				match(COMMON_TOK_EXCLAMATION_MARK);
				setState(411);
				expression(51);
				}
				break;
			case UNARY_OP_INCREMENT:
				{
				_localctx = new ExpressionGetAndIncrementContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(412);
				match(UNARY_OP_INCREMENT);
				setState(413);
				expression(49);
				}
				break;
			case UNARY_OP_DECREMENT:
				{
				_localctx = new ExpressionDecrementAndGetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(414);
				match(UNARY_OP_DECREMENT);
				setState(415);
				expression(47);
				}
				break;
			case COMMON_TOK_MINUS:
				{
				_localctx = new ExpressionUnaryOpNegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(416);
				match(COMMON_TOK_MINUS);
				setState(417);
				expression(46);
				}
				break;
			case COMMON_TOK_PLUS:
				{
				_localctx = new ExpressionUnaryOpPositiveContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(418);
				match(COMMON_TOK_PLUS);
				setState(419);
				expression(45);
				}
				break;
			case PHRASE_NOT:
				{
				_localctx = new ExpressionUnaryOpNegatedPhraseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(420);
				match(PHRASE_NOT);
				setState(421);
				expression(12);
				}
				break;
			case PHRASE_FOR_ALL:
				{
				_localctx = new ExpressionUniversalQuantificationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(422);
				match(PHRASE_FOR_ALL);
				setState(423);
				match(GROUP_LEFT_PAREN);
				setState(424);
				match(IDENTIFIER_NAME);
				setState(425);
				match(COMMON_TOK_COLON);
				setState(426);
				type();
				setState(427);
				match(GROUP_RIGHT_PAREN);
				setState(428);
				expression(8);
				}
				break;
			case PHRASE_EXISTS:
				{
				_localctx = new ExpressionExistentialQuantificationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(430);
				match(PHRASE_EXISTS);
				setState(431);
				match(GROUP_LEFT_PAREN);
				setState(432);
				match(IDENTIFIER_NAME);
				setState(433);
				match(COMMON_TOK_COLON);
				setState(434);
				type();
				setState(435);
				match(GROUP_RIGHT_PAREN);
				setState(436);
				expression(7);
				}
				break;
			case GROUP_LEFT_PAREN:
				{
				_localctx = new ExpressionGroupedContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(438);
				match(GROUP_LEFT_PAREN);
				setState(439);
				expression(0);
				setState(440);
				match(GROUP_RIGHT_PAREN);
				}
				break;
			case EXPR_LITERAL_DEADLOCK:
				{
				_localctx = new ExpressionDeadlockLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(442);
				match(EXPR_LITERAL_DEADLOCK);
				}
				break;
			case EXPR_LITERAL_TRUE:
				{
				_localctx = new ExpressionTrueLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(443);
				match(EXPR_LITERAL_TRUE);
				}
				break;
			case EXPR_LITERAL_FALSE:
				{
				_localctx = new ExpressionFalseLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(444);
				match(EXPR_LITERAL_FALSE);
				}
				break;
			case NATURAL_NUMBER:
				{
				_localctx = new ExpressionNaturalNumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(445);
				match(NATURAL_NUMBER);
				}
				break;
			case IDENTIFIER_NAME:
				{
				_localctx = new ExpressionIdentifierRefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(446);
				match(IDENTIFIER_NAME);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(576);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(574);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionBinaryOpMultiplicationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(449);
						if (!(precpred(_ctx, 44))) throw new FailedPredicateException(this, "precpred(_ctx, 44)");
						setState(450);
						match(BINARY_OP_MULTIPLICATION);
						setState(451);
						expression(45);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionBinaryOpDivisionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(452);
						if (!(precpred(_ctx, 43))) throw new FailedPredicateException(this, "precpred(_ctx, 43)");
						setState(453);
						match(BINARY_OP_DIVISION);
						setState(454);
						expression(44);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionBinaryOpModuloContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(455);
						if (!(precpred(_ctx, 42))) throw new FailedPredicateException(this, "precpred(_ctx, 42)");
						setState(456);
						match(BINARY_OP_MODULO);
						setState(457);
						expression(43);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionBinaryOpSubtractionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(458);
						if (!(precpred(_ctx, 41))) throw new FailedPredicateException(this, "precpred(_ctx, 41)");
						setState(459);
						match(COMMON_TOK_MINUS);
						setState(460);
						expression(42);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionBinaryOpAdditionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(461);
						if (!(precpred(_ctx, 40))) throw new FailedPredicateException(this, "precpred(_ctx, 40)");
						setState(462);
						match(COMMON_TOK_PLUS);
						setState(463);
						expression(41);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionBinaryOpLeftShiftContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(464);
						if (!(precpred(_ctx, 39))) throw new FailedPredicateException(this, "precpred(_ctx, 39)");
						setState(465);
						match(BINARY_OP_LEFT_SHIFT);
						setState(466);
						expression(40);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionBinaryOpRightShiftContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(467);
						if (!(precpred(_ctx, 38))) throw new FailedPredicateException(this, "precpred(_ctx, 38)");
						setState(468);
						match(BINARY_OP_RIGHT_SHIFT);
						setState(469);
						expression(39);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionBinaryOpMaximumContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(470);
						if (!(precpred(_ctx, 37))) throw new FailedPredicateException(this, "precpred(_ctx, 37)");
						setState(471);
						match(BINARY_OP_MAX);
						setState(472);
						expression(38);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionBinaryOpMinimumContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(473);
						if (!(precpred(_ctx, 36))) throw new FailedPredicateException(this, "precpred(_ctx, 36)");
						setState(474);
						match(BINARY_OP_MIN);
						setState(475);
						expression(37);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionBinaryOpLessThanContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(476);
						if (!(precpred(_ctx, 35))) throw new FailedPredicateException(this, "precpred(_ctx, 35)");
						setState(477);
						match(COMMON_TOK_LESS_THAN);
						setState(478);
						expression(36);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionBinaryOpLessThanOrEqualContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(479);
						if (!(precpred(_ctx, 34))) throw new FailedPredicateException(this, "precpred(_ctx, 34)");
						setState(480);
						match(BINARY_OP_LESS_THAN_OR_EQUAL_TO);
						setState(481);
						expression(35);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionBinaryOpGreaterThanContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(482);
						if (!(precpred(_ctx, 33))) throw new FailedPredicateException(this, "precpred(_ctx, 33)");
						setState(483);
						match(BINARY_OP_GREATER_THAN);
						setState(484);
						expression(34);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionBinaryOpGreaterThanOrEqualContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(485);
						if (!(precpred(_ctx, 32))) throw new FailedPredicateException(this, "precpred(_ctx, 32)");
						setState(486);
						match(BINARY_OP_GREATER_THAN_OR_EQUAL);
						setState(487);
						expression(33);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionBinaryOpEqualContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(488);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(489);
						match(BINARY_OP_EQUAL);
						setState(490);
						expression(32);
						}
						break;
					case 15:
						{
						_localctx = new ExpressionBinaryOpNotEqualContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(491);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(492);
						match(BINARY_OP_NOT_EQUAL);
						setState(493);
						expression(31);
						}
						break;
					case 16:
						{
						_localctx = new ExpressionBinaryOpBitwiseAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(494);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(495);
						match(COMMON_TOK_AMPERSAND);
						setState(496);
						expression(30);
						}
						break;
					case 17:
						{
						_localctx = new ExpressionBinaryOpBitwiseXORContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(497);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(498);
						match(BINARY_OP_BITWISE_XOR);
						setState(499);
						expression(29);
						}
						break;
					case 18:
						{
						_localctx = new ExpressionBinaryOpBitwiseOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(500);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(501);
						match(BINARY_OP_BITWISE_OR);
						setState(502);
						expression(28);
						}
						break;
					case 19:
						{
						_localctx = new ExpressionBinaryOpConjunctionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(503);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(504);
						match(BINARY_OP_CONJUNCTION);
						setState(505);
						expression(27);
						}
						break;
					case 20:
						{
						_localctx = new ExpressionBinaryOpDisjunctionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(506);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(507);
						match(BINARY_OP_DISJUNCTION);
						setState(508);
						expression(26);
						}
						break;
					case 21:
						{
						_localctx = new ExpressionTernaryContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(509);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(510);
						match(COMMON_TOK_QUESTION_MARK);
						setState(511);
						expression(0);
						setState(512);
						match(COMMON_TOK_COLON);
						setState(513);
						expression(24);
						}
						break;
					case 22:
						{
						_localctx = new ExpressionAssignOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(515);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(516);
						match(ASSG_OP);
						setState(517);
						expression(23);
						}
						break;
					case 23:
						{
						_localctx = new ExpressionAssignOpAdditionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(518);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(519);
						match(ASSG_OP_ADDITION);
						setState(520);
						expression(22);
						}
						break;
					case 24:
						{
						_localctx = new ExpressionAssignOpSubtractionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(521);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(522);
						match(ASSG_OP_SUBTRACTION);
						setState(523);
						expression(21);
						}
						break;
					case 25:
						{
						_localctx = new ExpressionAssignOpMultiplicationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(524);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(525);
						match(ASSG_OP_MULTIPLICATION);
						setState(526);
						expression(20);
						}
						break;
					case 26:
						{
						_localctx = new ExpressionAssignOpDivisionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(527);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(528);
						match(ASSG_OP_DIVISION);
						setState(529);
						expression(19);
						}
						break;
					case 27:
						{
						_localctx = new ExpressionAssignOpModuloContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(530);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(531);
						match(ASSG_OP_MODULO);
						setState(532);
						expression(18);
						}
						break;
					case 28:
						{
						_localctx = new ExpressionAssignOpBitwiseAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(533);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(534);
						match(ASSG_OP_BITWISE_AND);
						setState(535);
						expression(17);
						}
						break;
					case 29:
						{
						_localctx = new ExpressionAssignOpBitwiseOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(536);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(537);
						match(ASSG_OP_BITWISE_OR);
						setState(538);
						expression(16);
						}
						break;
					case 30:
						{
						_localctx = new ExpressionAssignOpLeftShiftContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(539);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(540);
						match(ASSG_OP_LEFT_SHIFT);
						setState(541);
						expression(15);
						}
						break;
					case 31:
						{
						_localctx = new ExpressionAssignOpRightShiftContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(542);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(543);
						match(ASSG_OP_RIGHT_SHIFT);
						setState(544);
						expression(14);
						}
						break;
					case 32:
						{
						_localctx = new ExpressionAssignOpBitwiseXORContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(545);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(546);
						match(ASSG_OP_BITWISE_XOR);
						setState(547);
						expression(13);
						}
						break;
					case 33:
						{
						_localctx = new ExpressionBinaryOpDisjunctionPhraseContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(548);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(549);
						match(PHRASE_OR);
						setState(550);
						expression(12);
						}
						break;
					case 34:
						{
						_localctx = new ExpressionBinaryOpImplicationPhraseContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(551);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(552);
						match(PHRASE_IMPLY);
						setState(553);
						expression(11);
						}
						break;
					case 35:
						{
						_localctx = new ExpressionBinaryOpConjunctionPhraseContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(554);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(555);
						match(PHRASE_AND);
						setState(556);
						expression(10);
						}
						break;
					case 36:
						{
						_localctx = new ExpressionArrayLookupContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(557);
						if (!(precpred(_ctx, 53))) throw new FailedPredicateException(this, "precpred(_ctx, 53)");
						setState(558);
						match(GROUP_LEFT_BRACKET);
						setState(559);
						expression(0);
						setState(560);
						match(GROUP_RIGHT_BRACKET);
						}
						break;
					case 37:
						{
						_localctx = new ExpressionFieldAccessContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(562);
						if (!(precpred(_ctx, 52))) throw new FailedPredicateException(this, "precpred(_ctx, 52)");
						setState(563);
						match(BINARY_OP_ACCESS_FIELD);
						setState(564);
						match(IDENTIFIER_NAME);
						}
						break;
					case 38:
						{
						_localctx = new ExpressionIncrementAndGetContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(565);
						if (!(precpred(_ctx, 50))) throw new FailedPredicateException(this, "precpred(_ctx, 50)");
						setState(566);
						match(UNARY_OP_INCREMENT);
						}
						break;
					case 39:
						{
						_localctx = new ExpressionGetAndDecrementContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(567);
						if (!(precpred(_ctx, 48))) throw new FailedPredicateException(this, "precpred(_ctx, 48)");
						setState(568);
						match(UNARY_OP_DECREMENT);
						}
						break;
					case 40:
						{
						_localctx = new ExpressionCallContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(569);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(570);
						match(GROUP_LEFT_PAREN);
						setState(571);
						argumentList();
						setState(572);
						match(GROUP_RIGHT_PAREN);
						}
						break;
					}
					} 
				}
				setState(578);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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

	public static class ParameterListContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UTALanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UTALanguageParser.SEP_ENUMERATION, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579);
			parameter();
			setState(584);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(580);
				match(SEP_ENUMERATION);
				setState(581);
				parameter();
				}
				}
				setState(586);
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
		public ParameterIdentifierContext parameterIdentifier() {
			return getRuleContext(ParameterIdentifierContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
			type();
			setState(588);
			parameterIdentifier();
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

	public static class ParameterIdentifierContext extends ParserRuleContext {
		public ParameterIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterIdentifier; }
	 
		public ParameterIdentifierContext() { }
		public void copyFrom(ParameterIdentifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ByValueVariableContext extends ParameterIdentifierContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ByValueVariableContext(ParameterIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterByValueVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitByValueVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitByValueVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ByReferenceVariableContext extends ParameterIdentifierContext {
		public TerminalNode COMMON_TOK_AMPERSAND() { return getToken(UTALanguageParser.COMMON_TOK_AMPERSAND, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ByReferenceVariableContext(ParameterIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterByReferenceVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitByReferenceVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitByReferenceVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterIdentifierContext parameterIdentifier() throws RecognitionException {
		ParameterIdentifierContext _localctx = new ParameterIdentifierContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_parameterIdentifier);
		try {
			setState(593);
			switch (_input.LA(1)) {
			case COMMON_TOK_AMPERSAND:
				_localctx = new ByReferenceVariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(590);
				match(COMMON_TOK_AMPERSAND);
				setState(591);
				identifier();
				}
				break;
			case IDENTIFIER_NAME:
				_localctx = new ByValueVariableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(592);
				identifier();
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

	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UTALanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UTALanguageParser.SEP_ENUMERATION, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
			expression(0);
			setState(600);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(596);
				match(SEP_ENUMERATION);
				setState(597);
				expression(0);
				}
				}
				setState(602);
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
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(604);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_PREFIX_URGENT) | (1L << TYPE_PREFIX_BROADCAST) | (1L << TYPE_PREFIX_META) | (1L << TYPE_PREFIX_CONST))) != 0)) {
				{
				setState(603);
				typePrefix();
				}
			}

			setState(606);
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
		public TerminalNode TYPE_CHANNEL() { return getToken(UTALanguageParser.TYPE_CHANNEL, 0); }
		public TypeIdChannelContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterTypeIdChannel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitTypeIdChannel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitTypeIdChannel(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIdBooleanContext extends TypeIdentifierContext {
		public TerminalNode TYPE_BOOLEAN() { return getToken(UTALanguageParser.TYPE_BOOLEAN, 0); }
		public TypeIdBooleanContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterTypeIdBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitTypeIdBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitTypeIdBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIdStructContext extends TypeIdentifierContext {
		public TerminalNode TYPE_STRUCT() { return getToken(UTALanguageParser.TYPE_STRUCT, 0); }
		public TerminalNode GROUP_LEFT_CURLY() { return getToken(UTALanguageParser.GROUP_LEFT_CURLY, 0); }
		public TerminalNode GROUP_RIGHT_CURLY() { return getToken(UTALanguageParser.GROUP_RIGHT_CURLY, 0); }
		public List<FieldDeclarationContext> fieldDeclaration() {
			return getRuleContexts(FieldDeclarationContext.class);
		}
		public FieldDeclarationContext fieldDeclaration(int i) {
			return getRuleContext(FieldDeclarationContext.class,i);
		}
		public TypeIdStructContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterTypeIdStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitTypeIdStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitTypeIdStruct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIdIdentifierNameContext extends TypeIdentifierContext {
		public TerminalNode IDENTIFIER_NAME() { return getToken(UTALanguageParser.IDENTIFIER_NAME, 0); }
		public TypeIdIdentifierNameContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterTypeIdIdentifierName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitTypeIdIdentifierName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitTypeIdIdentifierName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIdIntegerBoundedContext extends TypeIdentifierContext {
		public TerminalNode TYPE_INTEGER() { return getToken(UTALanguageParser.TYPE_INTEGER, 0); }
		public TerminalNode GROUP_LEFT_BRACKET() { return getToken(UTALanguageParser.GROUP_LEFT_BRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SEP_ENUMERATION() { return getToken(UTALanguageParser.SEP_ENUMERATION, 0); }
		public TerminalNode GROUP_RIGHT_BRACKET() { return getToken(UTALanguageParser.GROUP_RIGHT_BRACKET, 0); }
		public TypeIdIntegerBoundedContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterTypeIdIntegerBounded(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitTypeIdIntegerBounded(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitTypeIdIntegerBounded(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIdIntegerContext extends TypeIdentifierContext {
		public TerminalNode TYPE_INTEGER() { return getToken(UTALanguageParser.TYPE_INTEGER, 0); }
		public TypeIdIntegerContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterTypeIdInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitTypeIdInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitTypeIdInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIdScalarContext extends TypeIdentifierContext {
		public TerminalNode TYPE_SCALAR() { return getToken(UTALanguageParser.TYPE_SCALAR, 0); }
		public TerminalNode GROUP_LEFT_BRACKET() { return getToken(UTALanguageParser.GROUP_LEFT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_BRACKET() { return getToken(UTALanguageParser.GROUP_RIGHT_BRACKET, 0); }
		public TypeIdScalarContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterTypeIdScalar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitTypeIdScalar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitTypeIdScalar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIdClockContext extends TypeIdentifierContext {
		public TerminalNode TYPE_CLOCK() { return getToken(UTALanguageParser.TYPE_CLOCK, 0); }
		public TypeIdClockContext(TypeIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterTypeIdClock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitTypeIdClock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitTypeIdClock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeIdentifierContext typeIdentifier() throws RecognitionException {
		TypeIdentifierContext _localctx = new TypeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_typeIdentifier);
		int _la;
		try {
			setState(634);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				_localctx = new TypeIdIntegerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(608);
				match(TYPE_INTEGER);
				}
				break;
			case 2:
				_localctx = new TypeIdClockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(609);
				match(TYPE_CLOCK);
				}
				break;
			case 3:
				_localctx = new TypeIdChannelContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(610);
				match(TYPE_CHANNEL);
				}
				break;
			case 4:
				_localctx = new TypeIdBooleanContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(611);
				match(TYPE_BOOLEAN);
				}
				break;
			case 5:
				_localctx = new TypeIdIntegerBoundedContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(612);
				match(TYPE_INTEGER);
				setState(613);
				match(GROUP_LEFT_BRACKET);
				setState(614);
				expression(0);
				setState(615);
				match(SEP_ENUMERATION);
				setState(616);
				expression(0);
				setState(617);
				match(GROUP_RIGHT_BRACKET);
				}
				break;
			case 6:
				_localctx = new TypeIdScalarContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(619);
				match(TYPE_SCALAR);
				setState(620);
				match(GROUP_LEFT_BRACKET);
				setState(621);
				expression(0);
				setState(622);
				match(GROUP_RIGHT_BRACKET);
				}
				break;
			case 7:
				_localctx = new TypeIdStructContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(624);
				match(TYPE_STRUCT);
				setState(625);
				match(GROUP_LEFT_CURLY);
				setState(627); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(626);
					fieldDeclaration();
					}
					}
					setState(629); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TYPE_INTEGER) | (1L << TYPE_CLOCK) | (1L << TYPE_CHANNEL) | (1L << TYPE_BOOLEAN) | (1L << TYPE_SCALAR) | (1L << TYPE_STRUCT) | (1L << TYPE_PREFIX_URGENT) | (1L << TYPE_PREFIX_BROADCAST) | (1L << TYPE_PREFIX_META) | (1L << TYPE_PREFIX_CONST))) != 0) || _la==IDENTIFIER_NAME );
				setState(631);
				match(GROUP_RIGHT_CURLY);
				}
				break;
			case 8:
				_localctx = new TypeIdIdentifierNameContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(633);
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

	public static class FieldDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode SEP_SEMICOLON() { return getToken(UTALanguageParser.SEP_SEMICOLON, 0); }
		public List<TerminalNode> SEP_ENUMERATION() { return getTokens(UTALanguageParser.SEP_ENUMERATION); }
		public TerminalNode SEP_ENUMERATION(int i) {
			return getToken(UTALanguageParser.SEP_ENUMERATION, i);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitFieldDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitFieldDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_fieldDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			type();
			setState(637);
			identifier();
			setState(642);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP_ENUMERATION) {
				{
				{
				setState(638);
				match(SEP_ENUMERATION);
				setState(639);
				identifier();
				}
				}
				setState(644);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(645);
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

	public static class IdentifierContext extends ParserRuleContext {
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	 
		public IdentifierContext() { }
		public void copyFrom(IdentifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayIdentifierContext extends IdentifierContext {
		public TerminalNode IDENTIFIER_NAME() { return getToken(UTALanguageParser.IDENTIFIER_NAME, 0); }
		public List<ArrayModifierContext> arrayModifier() {
			return getRuleContexts(ArrayModifierContext.class);
		}
		public ArrayModifierContext arrayModifier(int i) {
			return getRuleContext(ArrayModifierContext.class,i);
		}
		public ArrayIdentifierContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterArrayIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitArrayIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitArrayIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BaseIdentifierContext extends IdentifierContext {
		public TerminalNode IDENTIFIER_NAME() { return getToken(UTALanguageParser.IDENTIFIER_NAME, 0); }
		public BaseIdentifierContext(IdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterBaseIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitBaseIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitBaseIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_identifier);
		int _la;
		try {
			setState(654);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				_localctx = new ArrayIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(647);
				match(IDENTIFIER_NAME);
				setState(649); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(648);
					arrayModifier();
					}
					}
					setState(651); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==GROUP_LEFT_BRACKET );
				}
				break;
			case 2:
				_localctx = new BaseIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(653);
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

	public static class ArrayModifierContext extends ParserRuleContext {
		public ArrayModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayModifier; }
	 
		public ArrayModifierContext() { }
		public void copyFrom(ArrayModifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArraySizeFromExpressionContext extends ArrayModifierContext {
		public TerminalNode GROUP_LEFT_BRACKET() { return getToken(UTALanguageParser.GROUP_LEFT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_BRACKET() { return getToken(UTALanguageParser.GROUP_RIGHT_BRACKET, 0); }
		public ArraySizeFromExpressionContext(ArrayModifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterArraySizeFromExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitArraySizeFromExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitArraySizeFromExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArraySizeFromTypeContext extends ArrayModifierContext {
		public TerminalNode GROUP_LEFT_BRACKET() { return getToken(UTALanguageParser.GROUP_LEFT_BRACKET, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode GROUP_RIGHT_BRACKET() { return getToken(UTALanguageParser.GROUP_RIGHT_BRACKET, 0); }
		public ArraySizeFromTypeContext(ArrayModifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterArraySizeFromType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitArraySizeFromType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitArraySizeFromType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayModifierContext arrayModifier() throws RecognitionException {
		ArrayModifierContext _localctx = new ArrayModifierContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_arrayModifier);
		try {
			setState(664);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				_localctx = new ArraySizeFromExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(656);
				match(GROUP_LEFT_BRACKET);
				setState(657);
				expression(0);
				setState(658);
				match(GROUP_RIGHT_BRACKET);
				}
				break;
			case 2:
				_localctx = new ArraySizeFromTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(660);
				match(GROUP_LEFT_BRACKET);
				setState(661);
				type();
				setState(662);
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
		public TerminalNode TYPE_PREFIX_URGENT() { return getToken(UTALanguageParser.TYPE_PREFIX_URGENT, 0); }
		public TypePrefixUrgentContext(TypePrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterTypePrefixUrgent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitTypePrefixUrgent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitTypePrefixUrgent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypePrefixBroadcastContext extends TypePrefixContext {
		public TerminalNode TYPE_PREFIX_BROADCAST() { return getToken(UTALanguageParser.TYPE_PREFIX_BROADCAST, 0); }
		public TypePrefixBroadcastContext(TypePrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterTypePrefixBroadcast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitTypePrefixBroadcast(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitTypePrefixBroadcast(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypePrefixMetaContext extends TypePrefixContext {
		public TerminalNode TYPE_PREFIX_META() { return getToken(UTALanguageParser.TYPE_PREFIX_META, 0); }
		public TypePrefixMetaContext(TypePrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterTypePrefixMeta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitTypePrefixMeta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitTypePrefixMeta(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypePrefixConstantContext extends TypePrefixContext {
		public TerminalNode TYPE_PREFIX_CONST() { return getToken(UTALanguageParser.TYPE_PREFIX_CONST, 0); }
		public TypePrefixConstantContext(TypePrefixContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).enterTypePrefixConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTALanguageListener ) ((UTALanguageListener)listener).exitTypePrefixConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UTALanguageVisitor ) return ((UTALanguageVisitor<? extends T>)visitor).visitTypePrefixConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypePrefixContext typePrefix() throws RecognitionException {
		TypePrefixContext _localctx = new TypePrefixContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_typePrefix);
		try {
			setState(670);
			switch (_input.LA(1)) {
			case TYPE_PREFIX_URGENT:
				_localctx = new TypePrefixUrgentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(666);
				match(TYPE_PREFIX_URGENT);
				}
				break;
			case TYPE_PREFIX_BROADCAST:
				_localctx = new TypePrefixBroadcastContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(667);
				match(TYPE_PREFIX_BROADCAST);
				}
				break;
			case TYPE_PREFIX_META:
				_localctx = new TypePrefixMetaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(668);
				match(TYPE_PREFIX_META);
				}
				break;
			case TYPE_PREFIX_CONST:
				_localctx = new TypePrefixConstantContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(669);
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
		case 23:
			return channelVariableRefExpression_sempred((ChannelVariableRefExpressionContext)_localctx, predIndex);
		case 45:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean channelVariableRefExpression_sempred(ChannelVariableRefExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 44);
		case 2:
			return precpred(_ctx, 43);
		case 3:
			return precpred(_ctx, 42);
		case 4:
			return precpred(_ctx, 41);
		case 5:
			return precpred(_ctx, 40);
		case 6:
			return precpred(_ctx, 39);
		case 7:
			return precpred(_ctx, 38);
		case 8:
			return precpred(_ctx, 37);
		case 9:
			return precpred(_ctx, 36);
		case 10:
			return precpred(_ctx, 35);
		case 11:
			return precpred(_ctx, 34);
		case 12:
			return precpred(_ctx, 33);
		case 13:
			return precpred(_ctx, 32);
		case 14:
			return precpred(_ctx, 31);
		case 15:
			return precpred(_ctx, 30);
		case 16:
			return precpred(_ctx, 29);
		case 17:
			return precpred(_ctx, 28);
		case 18:
			return precpred(_ctx, 27);
		case 19:
			return precpred(_ctx, 26);
		case 20:
			return precpred(_ctx, 25);
		case 21:
			return precpred(_ctx, 24);
		case 22:
			return precpred(_ctx, 23);
		case 23:
			return precpred(_ctx, 22);
		case 24:
			return precpred(_ctx, 21);
		case 25:
			return precpred(_ctx, 20);
		case 26:
			return precpred(_ctx, 19);
		case 27:
			return precpred(_ctx, 18);
		case 28:
			return precpred(_ctx, 17);
		case 29:
			return precpred(_ctx, 16);
		case 30:
			return precpred(_ctx, 15);
		case 31:
			return precpred(_ctx, 14);
		case 32:
			return precpred(_ctx, 13);
		case 33:
			return precpred(_ctx, 11);
		case 34:
			return precpred(_ctx, 10);
		case 35:
			return precpred(_ctx, 9);
		case 36:
			return precpred(_ctx, 53);
		case 37:
			return precpred(_ctx, 52);
		case 38:
			return precpred(_ctx, 50);
		case 39:
			return precpred(_ctx, 48);
		case 40:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3S\u02a3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\3\3\3\3\3\7\3"+
		"x\n\3\f\3\16\3{\13\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0085\n\5\3\6"+
		"\3\6\3\6\7\6\u008a\n\6\f\6\16\6\u008d\13\6\3\7\3\7\3\b\3\b\3\t\3\t\5\t"+
		"\u0095\n\t\3\t\5\t\u0098\n\t\3\n\7\n\u009b\n\n\f\n\16\n\u009e\13\n\3\13"+
		"\3\13\5\13\u00a2\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00ac\n\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b6\n\f\3\f\3\f\5\f\u00ba\n\f\3\r"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\7\16\u00c3\n\16\f\16\16\16\u00c6\13\16\3\17"+
		"\3\17\3\17\7\17\u00cb\n\17\f\17\16\17\u00ce\13\17\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\7\21\u00d7\n\21\f\21\16\21\u00da\13\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\23\7\23\u00e3\n\23\f\23\16\23\u00e6\13\23\3\24\3\24"+
		"\3\24\3\24\5\24\u00ec\n\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\6\26"+
		"\u00f6\n\26\r\26\16\26\u00f7\3\27\3\27\3\27\7\27\u00fd\n\27\f\27\16\27"+
		"\u0100\13\27\3\30\3\30\5\30\u0104\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\7\31\u010e\n\31\f\31\16\31\u0111\13\31\3\32\3\32\3\32\3\32\7"+
		"\32\u0117\n\32\f\32\16\32\u011a\13\32\3\32\3\32\3\33\3\33\3\33\5\33\u0121"+
		"\n\33\3\34\3\34\3\34\3\34\3\34\7\34\u0128\n\34\f\34\16\34\u012b\13\34"+
		"\3\34\3\34\5\34\u012f\n\34\3\35\3\35\3\35\3\35\3\35\7\35\u0136\n\35\f"+
		"\35\16\35\u0139\13\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\5\36\u0142\n"+
		"\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \7 \u014d\n \f \16 \u0150\13"+
		" \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u015f\n!\3\"\3\"\3\"\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3\'\3\'"+
		"\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\5)\u018c\n)\3*\3*"+
		"\5*\u0190\n*\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/"+
		"\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/"+
		"\3/\3/\3/\3/\3/\3/\5/\u01c2\n/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/"+
		"\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/"+
		"\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/"+
		"\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/"+
		"\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/"+
		"\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\7/\u0241"+
		"\n/\f/\16/\u0244\13/\3\60\3\60\3\60\7\60\u0249\n\60\f\60\16\60\u024c\13"+
		"\60\3\61\3\61\3\61\3\62\3\62\3\62\5\62\u0254\n\62\3\63\3\63\3\63\7\63"+
		"\u0259\n\63\f\63\16\63\u025c\13\63\3\64\5\64\u025f\n\64\3\64\3\64\3\65"+
		"\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\65\3\65\6\65\u0276\n\65\r\65\16\65\u0277\3\65\3\65\3\65\5"+
		"\65\u027d\n\65\3\66\3\66\3\66\3\66\7\66\u0283\n\66\f\66\16\66\u0286\13"+
		"\66\3\66\3\66\3\67\3\67\6\67\u028c\n\67\r\67\16\67\u028d\3\67\5\67\u0291"+
		"\n\67\38\38\38\38\38\38\38\38\58\u029b\n8\39\39\39\39\59\u02a1\n9\39\2"+
		"\4\60\\:\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668"+
		":<>@BDFHJLNPRTVXZ\\^`bdfhjlnp\2\2\u02d8\2r\3\2\2\2\4t\3\2\2\2\6|\3\2\2"+
		"\2\b\u0084\3\2\2\2\n\u0086\3\2\2\2\f\u008e\3\2\2\2\16\u0090\3\2\2\2\20"+
		"\u0092\3\2\2\2\22\u009c\3\2\2\2\24\u00a1\3\2\2\2\26\u00b9\3\2\2\2\30\u00bb"+
		"\3\2\2\2\32\u00bf\3\2\2\2\34\u00c7\3\2\2\2\36\u00cf\3\2\2\2 \u00d1\3\2"+
		"\2\2\"\u00dd\3\2\2\2$\u00e4\3\2\2\2&\u00eb\3\2\2\2(\u00ed\3\2\2\2*\u00f2"+
		"\3\2\2\2,\u00f9\3\2\2\2.\u0103\3\2\2\2\60\u0105\3\2\2\2\62\u0112\3\2\2"+
		"\2\64\u011d\3\2\2\2\66\u012e\3\2\2\28\u0130\3\2\2\2:\u0141\3\2\2\2<\u0143"+
		"\3\2\2\2>\u0149\3\2\2\2@\u015e\3\2\2\2B\u0160\3\2\2\2D\u0163\3\2\2\2F"+
		"\u016c\3\2\2\2H\u016f\3\2\2\2J\u0176\3\2\2\2L\u0179\3\2\2\2N\u017e\3\2"+
		"\2\2P\u0184\3\2\2\2R\u018d\3\2\2\2T\u0193\3\2\2\2V\u0195\3\2\2\2X\u0197"+
		"\3\2\2\2Z\u0199\3\2\2\2\\\u01c1\3\2\2\2^\u0245\3\2\2\2`\u024d\3\2\2\2"+
		"b\u0253\3\2\2\2d\u0255\3\2\2\2f\u025e\3\2\2\2h\u027c\3\2\2\2j\u027e\3"+
		"\2\2\2l\u0290\3\2\2\2n\u029a\3\2\2\2p\u02a0\3\2\2\2rs\5^\60\2s\3\3\2\2"+
		"\2ty\5\\/\2uv\7>\2\2vx\5\\/\2wu\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2"+
		"z\5\3\2\2\2{y\3\2\2\2|}\5$\23\2}\7\3\2\2\2~\177\5\\/\2\177\u0080\7\66"+
		"\2\2\u0080\u0085\3\2\2\2\u0081\u0082\5\\/\2\u0082\u0083\7\67\2\2\u0083"+
		"\u0085\3\2\2\2\u0084~\3\2\2\2\u0084\u0081\3\2\2\2\u0085\t\3\2\2\2\u0086"+
		"\u008b\5\"\22\2\u0087\u0088\7>\2\2\u0088\u008a\5\"\22\2\u0089\u0087\3"+
		"\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\13\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u008f\5\\/\2\u008f\r\3\2\2\2\u0090"+
		"\u0091\5\\/\2\u0091\17\3\2\2\2\u0092\u0094\5\22\n\2\u0093\u0095\5\30\r"+
		"\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0098"+
		"\5 \21\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\21\3\2\2\2\u0099"+
		"\u009b\5\24\13\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3"+
		"\2\2\2\u009c\u009d\3\2\2\2\u009d\23\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00a2\5\26\f\2\u00a0\u00a2\5&\24\2\u00a1\u009f\3\2\2\2\u00a1\u00a0\3"+
		"\2\2\2\u00a2\25\3\2\2\2\u00a3\u00a4\7R\2\2\u00a4\u00a5\7<\2\2\u00a5\u00a6"+
		"\5^\60\2\u00a6\u00a7\7=\2\2\u00a7\u00a8\7\23\2\2\u00a8\u00a9\7R\2\2\u00a9"+
		"\u00ab\7<\2\2\u00aa\u00ac\5d\63\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7=\2\2\u00ae\u00af\7?\2\2\u00af\u00ba"+
		"\3\2\2\2\u00b0\u00b1\7R\2\2\u00b1\u00b2\7\23\2\2\u00b2\u00b3\7R\2\2\u00b3"+
		"\u00b5\7<\2\2\u00b4\u00b6\5d\63\2\u00b5\u00b4\3\2\2\2\u00b5\u00b6\3\2"+
		"\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\7=\2\2\u00b8\u00ba\7?\2\2\u00b9\u00a3"+
		"\3\2\2\2\u00b9\u00b0\3\2\2\2\u00ba\27\3\2\2\2\u00bb\u00bc\7P\2\2\u00bc"+
		"\u00bd\5\32\16\2\u00bd\u00be\7?\2\2\u00be\31\3\2\2\2\u00bf\u00c4\5\34"+
		"\17\2\u00c0\u00c1\7\65\2\2\u00c1\u00c3\5\34\17\2\u00c2\u00c0\3\2\2\2\u00c3"+
		"\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\33\3\2\2"+
		"\2\u00c6\u00c4\3\2\2\2\u00c7\u00cc\5\36\20\2\u00c8\u00c9\7>\2\2\u00c9"+
		"\u00cb\5\36\20\2\u00ca\u00c8\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3"+
		"\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\35\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf"+
		"\u00d0\7R\2\2\u00d0\37\3\2\2\2\u00d1\u00d2\7Q\2\2\u00d2\u00d8\78\2\2\u00d3"+
		"\u00d4\5\\/\2\u00d4\u00d5\7?\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d3\3\2\2"+
		"\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db"+
		"\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dc\79\2\2\u00dc!\3\2\2\2\u00dd\u00de"+
		"\7R\2\2\u00de\u00df\7\61\2\2\u00df\u00e0\5f\64\2\u00e0#\3\2\2\2\u00e1"+
		"\u00e3\5&\24\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2"+
		"\2\2\u00e4\u00e5\3\2\2\2\u00e5%\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00ec"+
		"\5\62\32\2\u00e8\u00ec\58\35\2\u00e9\u00ec\5:\36\2\u00ea\u00ec\5(\25\2"+
		"\u00eb\u00e7\3\2\2\2\u00eb\u00e8\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ea"+
		"\3\2\2\2\u00ec\'\3\2\2\2\u00ed\u00ee\7\b\2\2\u00ee\u00ef\7N\2\2\u00ef"+
		"\u00f0\5*\26\2\u00f0\u00f1\7?\2\2\u00f1)\3\2\2\2\u00f2\u00f5\5,\27\2\u00f3"+
		"\u00f4\7\65\2\2\u00f4\u00f6\5,\27\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\3"+
		"\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8+\3\2\2\2\u00f9\u00fe"+
		"\5.\30\2\u00fa\u00fb\7>\2\2\u00fb\u00fd\5.\30\2\u00fc\u00fa\3\2\2\2\u00fd"+
		"\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff-\3\2\2\2"+
		"\u0100\u00fe\3\2\2\2\u0101\u0104\7O\2\2\u0102\u0104\5\60\31\2\u0103\u0101"+
		"\3\2\2\2\u0103\u0102\3\2\2\2\u0104/\3\2\2\2\u0105\u0106\b\31\1\2\u0106"+
		"\u0107\7R\2\2\u0107\u010f\3\2\2\2\u0108\u0109\f\4\2\2\u0109\u010a\7:\2"+
		"\2\u010a\u010b\5\\/\2\u010b\u010c\7;\2\2\u010c\u010e\3\2\2\2\u010d\u0108"+
		"\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"\61\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\5f\64\2\u0113\u0118\5\64\33"+
		"\2\u0114\u0115\7>\2\2\u0115\u0117\5\64\33\2\u0116\u0114\3\2\2\2\u0117"+
		"\u011a\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011b\3\2"+
		"\2\2\u011a\u0118\3\2\2\2\u011b\u011c\7?\2\2\u011c\63\3\2\2\2\u011d\u0120"+
		"\5l\67\2\u011e\u011f\7\23\2\2\u011f\u0121\5\66\34\2\u0120\u011e\3\2\2"+
		"\2\u0120\u0121\3\2\2\2\u0121\65\3\2\2\2\u0122\u012f\5\\/\2\u0123\u0124"+
		"\78\2\2\u0124\u0129\5\66\34\2\u0125\u0126\7>\2\2\u0126\u0128\5\66\34\2"+
		"\u0127\u0125\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a"+
		"\3\2\2\2\u012a\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012d\79\2\2\u012d"+
		"\u012f\3\2\2\2\u012e\u0122\3\2\2\2\u012e\u0123\3\2\2\2\u012f\67\3\2\2"+
		"\2\u0130\u0131\7G\2\2\u0131\u0132\5f\64\2\u0132\u0137\5l\67\2\u0133\u0134"+
		"\7>\2\2\u0134\u0136\5l\67\2\u0135\u0133\3\2\2\2\u0136\u0139\3\2\2\2\u0137"+
		"\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u0137\3\2"+
		"\2\2\u013a\u013b\7?\2\2\u013b9\3\2\2\2\u013c\u013d\5f\64\2\u013d\u013e"+
		"\5<\37\2\u013e\u0142\3\2\2\2\u013f\u0140\7@\2\2\u0140\u0142\5<\37\2\u0141"+
		"\u013c\3\2\2\2\u0141\u013f\3\2\2\2\u0142;\3\2\2\2\u0143\u0144\7R\2\2\u0144"+
		"\u0145\7<\2\2\u0145\u0146\5^\60\2\u0146\u0147\7=\2\2\u0147\u0148\5> \2"+
		"\u0148=\3\2\2\2\u0149\u014a\78\2\2\u014a\u014e\5$\23\2\u014b\u014d\5@"+
		"!\2\u014c\u014b\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c\3\2\2\2\u014e"+
		"\u014f\3\2\2\2\u014f\u0151\3\2\2\2\u0150\u014e\3\2\2\2\u0151\u0152\79"+
		"\2\2\u0152?\3\2\2\2\u0153\u015f\5> \2\u0154\u015f\7?\2\2\u0155\u0156\5"+
		"\\/\2\u0156\u0157\7?\2\2\u0157\u015f\3\2\2\2\u0158\u015f\5B\"\2\u0159"+
		"\u015f\5F$\2\u015a\u015f\5J&\2\u015b\u015f\5N(\2\u015c\u015f\5P)\2\u015d"+
		"\u015f\5R*\2\u015e\u0153\3\2\2\2\u015e\u0154\3\2\2\2\u015e\u0155\3\2\2"+
		"\2\u015e\u0158\3\2\2\2\u015e\u0159\3\2\2\2\u015e\u015a\3\2\2\2\u015e\u015b"+
		"\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015d\3\2\2\2\u015fA\3\2\2\2\u0160"+
		"\u0161\5D#\2\u0161\u0162\5Z.\2\u0162C\3\2\2\2\u0163\u0164\7J\2\2\u0164"+
		"\u0165\7<\2\2\u0165\u0166\5T+\2\u0166\u0167\7?\2\2\u0167\u0168\5V,\2\u0168"+
		"\u0169\7?\2\2\u0169\u016a\5X-\2\u016a\u016b\7=\2\2\u016bE\3\2\2\2\u016c"+
		"\u016d\5H%\2\u016d\u016e\5Z.\2\u016eG\3\2\2\2\u016f\u0170\7J\2\2\u0170"+
		"\u0171\7<\2\2\u0171\u0172\7R\2\2\u0172\u0173\7\61\2\2\u0173\u0174\5f\64"+
		"\2\u0174\u0175\7=\2\2\u0175I\3\2\2\2\u0176\u0177\5L\'\2\u0177\u0178\5"+
		"Z.\2\u0178K\3\2\2\2\u0179\u017a\7K\2\2\u017a\u017b\7<\2\2\u017b\u017c"+
		"\5V,\2\u017c\u017d\7=\2\2\u017dM\3\2\2\2\u017e\u017f\7M\2\2\u017f\u0180"+
		"\5Z.\2\u0180\u0181\7K\2\2\u0181\u0182\5V,\2\u0182\u0183\7?\2\2\u0183O"+
		"\3\2\2\2\u0184\u0185\7H\2\2\u0185\u0186\7<\2\2\u0186\u0187\5\\/\2\u0187"+
		"\u0188\7=\2\2\u0188\u018b\5@!\2\u0189\u018a\7I\2\2\u018a\u018c\5@!\2\u018b"+
		"\u0189\3\2\2\2\u018b\u018c\3\2\2\2\u018cQ\3\2\2\2\u018d\u018f\7L\2\2\u018e"+
		"\u0190\5\\/\2\u018f\u018e\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\3\2"+
		"\2\2\u0191\u0192\7?\2\2\u0192S\3\2\2\2\u0193\u0194\5\\/\2\u0194U\3\2\2"+
		"\2\u0195\u0196\5\\/\2\u0196W\3\2\2\2\u0197\u0198\5\\/\2\u0198Y\3\2\2\2"+
		"\u0199\u019a\5@!\2\u019a[\3\2\2\2\u019b\u019c\b/\1\2\u019c\u019d\7\66"+
		"\2\2\u019d\u01c2\5\\/\65\u019e\u019f\7/\2\2\u019f\u01c2\5\\/\63\u01a0"+
		"\u01a1\7\60\2\2\u01a1\u01c2\5\\/\61\u01a2\u01a3\7\63\2\2\u01a3\u01c2\5"+
		"\\/\60\u01a4\u01a5\7\62\2\2\u01a5\u01c2\5\\//\u01a6\u01a7\7A\2\2\u01a7"+
		"\u01c2\5\\/\16\u01a8\u01a9\7E\2\2\u01a9\u01aa\7<\2\2\u01aa\u01ab\7R\2"+
		"\2\u01ab\u01ac\7\61\2\2\u01ac\u01ad\5f\64\2\u01ad\u01ae\7=\2\2\u01ae\u01af"+
		"\5\\/\n\u01af\u01c2\3\2\2\2\u01b0\u01b1\7F\2\2\u01b1\u01b2\7<\2\2\u01b2"+
		"\u01b3\7R\2\2\u01b3\u01b4\7\61\2\2\u01b4\u01b5\5f\64\2\u01b5\u01b6\7="+
		"\2\2\u01b6\u01b7\5\\/\t\u01b7\u01c2\3\2\2\2\u01b8\u01b9\7<\2\2\u01b9\u01ba"+
		"\5\\/\2\u01ba\u01bb\7=\2\2\u01bb\u01c2\3\2\2\2\u01bc\u01c2\7\22\2\2\u01bd"+
		"\u01c2\7\20\2\2\u01be\u01c2\7\21\2\2\u01bf\u01c2\7S\2\2\u01c0\u01c2\7"+
		"R\2\2\u01c1\u019b\3\2\2\2\u01c1\u019e\3\2\2\2\u01c1\u01a0\3\2\2\2\u01c1"+
		"\u01a2\3\2\2\2\u01c1\u01a4\3\2\2\2\u01c1\u01a6\3\2\2\2\u01c1\u01a8\3\2"+
		"\2\2\u01c1\u01b0\3\2\2\2\u01c1\u01b8\3\2\2\2\u01c1\u01bc\3\2\2\2\u01c1"+
		"\u01bd\3\2\2\2\u01c1\u01be\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c0\3\2"+
		"\2\2\u01c2\u0242\3\2\2\2\u01c3\u01c4\f.\2\2\u01c4\u01c5\7\'\2\2\u01c5"+
		"\u0241\5\\//\u01c6\u01c7\f-\2\2\u01c7\u01c8\7(\2\2\u01c8\u0241\5\\/.\u01c9"+
		"\u01ca\f,\2\2\u01ca\u01cb\7)\2\2\u01cb\u0241\5\\/-\u01cc\u01cd\f+\2\2"+
		"\u01cd\u01ce\7\63\2\2\u01ce\u0241\5\\/,\u01cf\u01d0\f*\2\2\u01d0\u01d1"+
		"\7\62\2\2\u01d1\u0241\5\\/+\u01d2\u01d3\f)\2\2\u01d3\u01d4\7\"\2\2\u01d4"+
		"\u0241\5\\/*\u01d5\u01d6\f(\2\2\u01d6\u01d7\7#\2\2\u01d7\u0241\5\\/)\u01d8"+
		"\u01d9\f\'\2\2\u01d9\u01da\7+\2\2\u01da\u0241\5\\/(\u01db\u01dc\f&\2\2"+
		"\u01dc\u01dd\7,\2\2\u01dd\u0241\5\\/\'\u01de\u01df\f%\2\2\u01df\u01e0"+
		"\7\65\2\2\u01e0\u0241\5\\/&\u01e1\u01e2\f$\2\2\u01e2\u01e3\7\36\2\2\u01e3"+
		"\u0241\5\\/%\u01e4\u01e5\f#\2\2\u01e5\u01e6\7-\2\2\u01e6\u0241\5\\/$\u01e7"+
		"\u01e8\f\"\2\2\u01e8\u01e9\7\37\2\2\u01e9\u0241\5\\/#\u01ea\u01eb\f!\2"+
		"\2\u01eb\u01ec\7 \2\2\u01ec\u0241\5\\/\"\u01ed\u01ee\f \2\2\u01ee\u01ef"+
		"\7!\2\2\u01ef\u0241\5\\/!\u01f0\u01f1\f\37\2\2\u01f1\u01f2\7\64\2\2\u01f2"+
		"\u0241\5\\/ \u01f3\u01f4\f\36\2\2\u01f4\u01f5\7*\2\2\u01f5\u0241\5\\/"+
		"\37\u01f6\u01f7\f\35\2\2\u01f7\u01f8\7&\2\2\u01f8\u0241\5\\/\36\u01f9"+
		"\u01fa\f\34\2\2\u01fa\u01fb\7$\2\2\u01fb\u0241\5\\/\35\u01fc\u01fd\f\33"+
		"\2\2\u01fd\u01fe\7%\2\2\u01fe\u0241\5\\/\34\u01ff\u0200\f\32\2\2\u0200"+
		"\u0201\7\67\2\2\u0201\u0202\5\\/\2\u0202\u0203\7\61\2\2\u0203\u0204\5"+
		"\\/\32\u0204\u0241\3\2\2\2\u0205\u0206\f\31\2\2\u0206\u0207\7\23\2\2\u0207"+
		"\u0241\5\\/\31\u0208\u0209\f\30\2\2\u0209\u020a\7\25\2\2\u020a\u0241\5"+
		"\\/\30\u020b\u020c\f\27\2\2\u020c\u020d\7\24\2\2\u020d\u0241\5\\/\27\u020e"+
		"\u020f\f\26\2\2\u020f\u0210\7\26\2\2\u0210\u0241\5\\/\26\u0211\u0212\f"+
		"\25\2\2\u0212\u0213\7\27\2\2\u0213\u0241\5\\/\25\u0214\u0215\f\24\2\2"+
		"\u0215\u0216\7\30\2\2\u0216\u0241\5\\/\24\u0217\u0218\f\23\2\2\u0218\u0219"+
		"\7\32\2\2\u0219\u0241\5\\/\23\u021a\u021b\f\22\2\2\u021b\u021c\7\31\2"+
		"\2\u021c\u0241\5\\/\22\u021d\u021e\f\21\2\2\u021e\u021f\7\34\2\2\u021f"+
		"\u0241\5\\/\21\u0220\u0221\f\20\2\2\u0221\u0222\7\35\2\2\u0222\u0241\5"+
		"\\/\20\u0223\u0224\f\17\2\2\u0224\u0225\7\33\2\2\u0225\u0241\5\\/\17\u0226"+
		"\u0227\f\r\2\2\u0227\u0228\7B\2\2\u0228\u0241\5\\/\16\u0229\u022a\f\f"+
		"\2\2\u022a\u022b\7D\2\2\u022b\u0241\5\\/\r\u022c\u022d\f\13\2\2\u022d"+
		"\u022e\7C\2\2\u022e\u0241\5\\/\f\u022f\u0230\f\67\2\2\u0230\u0231\7:\2"+
		"\2\u0231\u0232\5\\/\2\u0232\u0233\7;\2\2\u0233\u0241\3\2\2\2\u0234\u0235"+
		"\f\66\2\2\u0235\u0236\7.\2\2\u0236\u0241\7R\2\2\u0237\u0238\f\64\2\2\u0238"+
		"\u0241\7/\2\2\u0239\u023a\f\62\2\2\u023a\u0241\7\60\2\2\u023b\u023c\f"+
		"\b\2\2\u023c\u023d\7<\2\2\u023d\u023e\5d\63\2\u023e\u023f\7=\2\2\u023f"+
		"\u0241\3\2\2\2\u0240\u01c3\3\2\2\2\u0240\u01c6\3\2\2\2\u0240\u01c9\3\2"+
		"\2\2\u0240\u01cc\3\2\2\2\u0240\u01cf\3\2\2\2\u0240\u01d2\3\2\2\2\u0240"+
		"\u01d5\3\2\2\2\u0240\u01d8\3\2\2\2\u0240\u01db\3\2\2\2\u0240\u01de\3\2"+
		"\2\2\u0240\u01e1\3\2\2\2\u0240\u01e4\3\2\2\2\u0240\u01e7\3\2\2\2\u0240"+
		"\u01ea\3\2\2\2\u0240\u01ed\3\2\2\2\u0240\u01f0\3\2\2\2\u0240\u01f3\3\2"+
		"\2\2\u0240\u01f6\3\2\2\2\u0240\u01f9\3\2\2\2\u0240\u01fc\3\2\2\2\u0240"+
		"\u01ff\3\2\2\2\u0240\u0205\3\2\2\2\u0240\u0208\3\2\2\2\u0240\u020b\3\2"+
		"\2\2\u0240\u020e\3\2\2\2\u0240\u0211\3\2\2\2\u0240\u0214\3\2\2\2\u0240"+
		"\u0217\3\2\2\2\u0240\u021a\3\2\2\2\u0240\u021d\3\2\2\2\u0240\u0220\3\2"+
		"\2\2\u0240\u0223\3\2\2\2\u0240\u0226\3\2\2\2\u0240\u0229\3\2\2\2\u0240"+
		"\u022c\3\2\2\2\u0240\u022f\3\2\2\2\u0240\u0234\3\2\2\2\u0240\u0237\3\2"+
		"\2\2\u0240\u0239\3\2\2\2\u0240\u023b\3\2\2\2\u0241\u0244\3\2\2\2\u0242"+
		"\u0240\3\2\2\2\u0242\u0243\3\2\2\2\u0243]\3\2\2\2\u0244\u0242\3\2\2\2"+
		"\u0245\u024a\5`\61\2\u0246\u0247\7>\2\2\u0247\u0249\5`\61\2\u0248\u0246"+
		"\3\2\2\2\u0249\u024c\3\2\2\2\u024a\u0248\3\2\2\2\u024a\u024b\3\2\2\2\u024b"+
		"_\3\2\2\2\u024c\u024a\3\2\2\2\u024d\u024e\5f\64\2\u024e\u024f\5b\62\2"+
		"\u024fa\3\2\2\2\u0250\u0251\7\64\2\2\u0251\u0254\5l\67\2\u0252\u0254\5"+
		"l\67\2\u0253\u0250\3\2\2\2\u0253\u0252\3\2\2\2\u0254c\3\2\2\2\u0255\u025a"+
		"\5\\/\2\u0256\u0257\7>\2\2\u0257\u0259\5\\/\2\u0258\u0256\3\2\2\2\u0259"+
		"\u025c\3\2\2\2\u025a\u0258\3\2\2\2\u025a\u025b\3\2\2\2\u025be\3\2\2\2"+
		"\u025c\u025a\3\2\2\2\u025d\u025f\5p9\2\u025e\u025d\3\2\2\2\u025e\u025f"+
		"\3\2\2\2\u025f\u0260\3\2\2\2\u0260\u0261\5h\65\2\u0261g\3\2\2\2\u0262"+
		"\u027d\7\6\2\2\u0263\u027d\7\7\2\2\u0264\u027d\7\b\2\2\u0265\u027d\7\t"+
		"\2\2\u0266\u0267\7\6\2\2\u0267\u0268\7:\2\2\u0268\u0269\5\\/\2\u0269\u026a"+
		"\7>\2\2\u026a\u026b\5\\/\2\u026b\u026c\7;\2\2\u026c\u027d\3\2\2\2\u026d"+
		"\u026e\7\n\2\2\u026e\u026f\7:\2\2\u026f\u0270\5\\/\2\u0270\u0271\7;\2"+
		"\2\u0271\u027d\3\2\2\2\u0272\u0273\7\13\2\2\u0273\u0275\78\2\2\u0274\u0276"+
		"\5j\66\2\u0275\u0274\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0275\3\2\2\2\u0277"+
		"\u0278\3\2\2\2\u0278\u0279\3\2\2\2\u0279\u027a\79\2\2\u027a\u027d\3\2"+
		"\2\2\u027b\u027d\7R\2\2\u027c\u0262\3\2\2\2\u027c\u0263\3\2\2\2\u027c"+
		"\u0264\3\2\2\2\u027c\u0265\3\2\2\2\u027c\u0266\3\2\2\2\u027c\u026d\3\2"+
		"\2\2\u027c\u0272\3\2\2\2\u027c\u027b\3\2\2\2\u027di\3\2\2\2\u027e\u027f"+
		"\5f\64\2\u027f\u0284\5l\67\2\u0280\u0281\7>\2\2\u0281\u0283\5l\67\2\u0282"+
		"\u0280\3\2\2\2\u0283\u0286\3\2\2\2\u0284\u0282\3\2\2\2\u0284\u0285\3\2"+
		"\2\2\u0285\u0287\3\2\2\2\u0286\u0284\3\2\2\2\u0287\u0288\7?\2\2\u0288"+
		"k\3\2\2\2\u0289\u028b\7R\2\2\u028a\u028c\5n8\2\u028b\u028a\3\2\2\2\u028c"+
		"\u028d\3\2\2\2\u028d\u028b\3\2\2\2\u028d\u028e\3\2\2\2\u028e\u0291\3\2"+
		"\2\2\u028f\u0291\7R\2\2\u0290\u0289\3\2\2\2\u0290\u028f\3\2\2\2\u0291"+
		"m\3\2\2\2\u0292\u0293\7:\2\2\u0293\u0294\5\\/\2\u0294\u0295\7;\2\2\u0295"+
		"\u029b\3\2\2\2\u0296\u0297\7:\2\2\u0297\u0298\5f\64\2\u0298\u0299\7;\2"+
		"\2\u0299\u029b\3\2\2\2\u029a\u0292\3\2\2\2\u029a\u0296\3\2\2\2\u029bo"+
		"\3\2\2\2\u029c\u02a1\7\f\2\2\u029d\u02a1\7\r\2\2\u029e\u02a1\7\16\2\2"+
		"\u029f\u02a1\7\17\2\2\u02a0\u029c\3\2\2\2\u02a0\u029d\3\2\2\2\u02a0\u029e"+
		"\3\2\2\2\u02a0\u029f\3\2\2\2\u02a1q\3\2\2\2-y\u0084\u008b\u0094\u0097"+
		"\u009c\u00a1\u00ab\u00b5\u00b9\u00c4\u00cc\u00d8\u00e4\u00eb\u00f7\u00fe"+
		"\u0103\u010f\u0118\u0120\u0129\u012e\u0137\u0141\u014e\u015e\u018b\u018f"+
		"\u01c1\u0240\u0242\u024a\u0253\u025a\u025e\u0277\u027c\u0284\u028d\u0290"+
		"\u029a\u02a0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}