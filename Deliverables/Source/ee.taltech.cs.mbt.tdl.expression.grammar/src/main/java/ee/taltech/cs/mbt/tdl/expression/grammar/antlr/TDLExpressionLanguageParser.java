// Generated from TDLExpressionLanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.expression.grammar.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TDLExpressionLanguageParser extends Parser {
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
	public static final int
		RULE_expression = 0, RULE_quantifiedTrapsetExpression = 1, RULE_trapsetExpression = 2, 
		RULE_boundOverNaturals = 3;
	public static final String[] ruleNames = {
		"expression", "quantifiedTrapsetExpression", "trapsetExpression", "boundOverNaturals"
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

	@Override
	public String getGrammarFileName() { return "TDLExpressionLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TDLExpressionLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
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
	public static class GroundTermExpressionContext extends ExpressionContext {
		public QuantifiedTrapsetExpressionContext quantifiedTrapsetExpression() {
			return getRuleContext(QuantifiedTrapsetExpressionContext.class,0);
		}
		public GroundTermExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterGroundTermExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitGroundTermExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitGroundTermExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LeadsToExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LOP_LEADS_TO() { return getToken(TDLExpressionLanguageParser.LOP_LEADS_TO, 0); }
		public LeadsToExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterLeadsToExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitLeadsToExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitLeadsToExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImplicativeExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LOP_IMPLICATION() { return getToken(TDLExpressionLanguageParser.LOP_IMPLICATION, 0); }
		public ImplicativeExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterImplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitImplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitImplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GroupedExpressionContext extends ExpressionContext {
		public TerminalNode LEFT_PAREN() { return getToken(TDLExpressionLanguageParser.LEFT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(TDLExpressionLanguageParser.RIGHT_PAREN, 0); }
		public GroupedExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterGroupedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitGroupedExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitGroupedExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConjunctiveExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LOP_CONJUNCTION() { return getToken(TDLExpressionLanguageParser.LOP_CONJUNCTION, 0); }
		public ConjunctiveExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterConjunctiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitConjunctiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitConjunctiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EquivalenceExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LOP_EQUIVALENCE() { return getToken(TDLExpressionLanguageParser.LOP_EQUIVALENCE, 0); }
		public EquivalenceExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterEquivalenceExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitEquivalenceExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitEquivalenceExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegatedExpressionContext extends ExpressionContext {
		public TerminalNode LOP_NEGATION() { return getToken(TDLExpressionLanguageParser.LOP_NEGATION, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NegatedExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterNegatedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitNegatedExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitNegatedExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionalRepetitionExpressionContext extends ExpressionContext {
		public TerminalNode LOP_REPETITION_COUNT() { return getToken(TDLExpressionLanguageParser.LOP_REPETITION_COUNT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(TDLExpressionLanguageParser.LEFT_BRACKET, 0); }
		public BoundOverNaturalsContext boundOverNaturals() {
			return getRuleContext(BoundOverNaturalsContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(TDLExpressionLanguageParser.RIGHT_BRACKET, 0); }
		public ConditionalRepetitionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterConditionalRepetitionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitConditionalRepetitionExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitConditionalRepetitionExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TimeBoundedLeadsToExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LOP_LEADS_TO() { return getToken(TDLExpressionLanguageParser.LOP_LEADS_TO, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(TDLExpressionLanguageParser.LEFT_BRACKET, 0); }
		public BoundOverNaturalsContext boundOverNaturals() {
			return getRuleContext(BoundOverNaturalsContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(TDLExpressionLanguageParser.RIGHT_BRACKET, 0); }
		public TimeBoundedLeadsToExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterTimeBoundedLeadsToExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitTimeBoundedLeadsToExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitTimeBoundedLeadsToExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DisjunctiveExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LOP_DISJUNCTION() { return getToken(TDLExpressionLanguageParser.LOP_DISJUNCTION, 0); }
		public DisjunctiveExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterDisjunctiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitDisjunctiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitDisjunctiveExpression(this);
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
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			switch (_input.LA(1)) {
			case LOP_NEGATION:
				{
				_localctx = new NegatedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(9);
				match(LOP_NEGATION);
				setState(10);
				expression(9);
				}
				break;
			case LEFT_PAREN:
				{
				_localctx = new GroupedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(11);
				match(LEFT_PAREN);
				setState(12);
				expression(0);
				setState(13);
				match(RIGHT_PAREN);
				}
				break;
			case LOP_REPETITION_COUNT:
				{
				_localctx = new ConditionalRepetitionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(15);
				match(LOP_REPETITION_COUNT);
				setState(16);
				expression(0);
				setState(17);
				match(LEFT_BRACKET);
				setState(18);
				boundOverNaturals();
				setState(19);
				match(RIGHT_BRACKET);
				}
				break;
			case LOP_UNIVERSAL_QUANTIFIER:
			case LOP_EXISTENTIAL_QUANTIFIER:
				{
				_localctx = new GroundTermExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(21);
				quantifiedTrapsetExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(46);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ConjunctiveExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(24);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(25);
						match(LOP_CONJUNCTION);
						setState(26);
						expression(9);
						}
						break;
					case 2:
						{
						_localctx = new DisjunctiveExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(27);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(28);
						match(LOP_DISJUNCTION);
						setState(29);
						expression(8);
						}
						break;
					case 3:
						{
						_localctx = new ImplicativeExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(30);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(31);
						match(LOP_IMPLICATION);
						setState(32);
						expression(7);
						}
						break;
					case 4:
						{
						_localctx = new EquivalenceExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(33);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(34);
						match(LOP_EQUIVALENCE);
						setState(35);
						expression(6);
						}
						break;
					case 5:
						{
						_localctx = new LeadsToExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(36);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(37);
						match(LOP_LEADS_TO);
						setState(38);
						expression(5);
						}
						break;
					case 6:
						{
						_localctx = new TimeBoundedLeadsToExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(39);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(40);
						match(LOP_LEADS_TO);
						setState(41);
						match(LEFT_BRACKET);
						setState(42);
						boundOverNaturals();
						setState(43);
						match(RIGHT_BRACKET);
						setState(44);
						expression(4);
						}
						break;
					}
					} 
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class QuantifiedTrapsetExpressionContext extends ParserRuleContext {
		public QuantifiedTrapsetExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifiedTrapsetExpression; }
	 
		public QuantifiedTrapsetExpressionContext() { }
		public void copyFrom(QuantifiedTrapsetExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UniversalTrapsetExpressionContext extends QuantifiedTrapsetExpressionContext {
		public TerminalNode LOP_UNIVERSAL_QUANTIFIER() { return getToken(TDLExpressionLanguageParser.LOP_UNIVERSAL_QUANTIFIER, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(TDLExpressionLanguageParser.LEFT_PAREN, 0); }
		public TrapsetExpressionContext trapsetExpression() {
			return getRuleContext(TrapsetExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(TDLExpressionLanguageParser.RIGHT_PAREN, 0); }
		public UniversalTrapsetExpressionContext(QuantifiedTrapsetExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterUniversalTrapsetExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitUniversalTrapsetExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitUniversalTrapsetExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExistentialTrapsetExpressionContext extends QuantifiedTrapsetExpressionContext {
		public TerminalNode LOP_EXISTENTIAL_QUANTIFIER() { return getToken(TDLExpressionLanguageParser.LOP_EXISTENTIAL_QUANTIFIER, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(TDLExpressionLanguageParser.LEFT_PAREN, 0); }
		public TrapsetExpressionContext trapsetExpression() {
			return getRuleContext(TrapsetExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(TDLExpressionLanguageParser.RIGHT_PAREN, 0); }
		public ExistentialTrapsetExpressionContext(QuantifiedTrapsetExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterExistentialTrapsetExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitExistentialTrapsetExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitExistentialTrapsetExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuantifiedTrapsetExpressionContext quantifiedTrapsetExpression() throws RecognitionException {
		QuantifiedTrapsetExpressionContext _localctx = new QuantifiedTrapsetExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_quantifiedTrapsetExpression);
		try {
			setState(61);
			switch (_input.LA(1)) {
			case LOP_UNIVERSAL_QUANTIFIER:
				_localctx = new UniversalTrapsetExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				match(LOP_UNIVERSAL_QUANTIFIER);
				setState(52);
				match(LEFT_PAREN);
				setState(53);
				trapsetExpression();
				setState(54);
				match(RIGHT_PAREN);
				}
				break;
			case LOP_EXISTENTIAL_QUANTIFIER:
				_localctx = new ExistentialTrapsetExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				match(LOP_EXISTENTIAL_QUANTIFIER);
				setState(57);
				match(LEFT_PAREN);
				setState(58);
				trapsetExpression();
				setState(59);
				match(RIGHT_PAREN);
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

	public static class TrapsetExpressionContext extends ParserRuleContext {
		public TrapsetExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trapsetExpression; }
	 
		public TrapsetExpressionContext() { }
		public void copyFrom(TrapsetExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RelativeTrapsetComplementExpressionContext extends TrapsetExpressionContext {
		public List<TerminalNode> TRAPSET_ID() { return getTokens(TDLExpressionLanguageParser.TRAPSET_ID); }
		public TerminalNode TRAPSET_ID(int i) {
			return getToken(TDLExpressionLanguageParser.TRAPSET_ID, i);
		}
		public TerminalNode TOP_RELATIVE_COMPLEMENT() { return getToken(TDLExpressionLanguageParser.TOP_RELATIVE_COMPLEMENT, 0); }
		public RelativeTrapsetComplementExpressionContext(TrapsetExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterRelativeTrapsetComplementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitRelativeTrapsetComplementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitRelativeTrapsetComplementExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AbsoluteTrapsetComplementExpressionContext extends TrapsetExpressionContext {
		public TerminalNode TOP_ABSOLUTE_COMPLEMENT() { return getToken(TDLExpressionLanguageParser.TOP_ABSOLUTE_COMPLEMENT, 0); }
		public TerminalNode TRAPSET_ID() { return getToken(TDLExpressionLanguageParser.TRAPSET_ID, 0); }
		public AbsoluteTrapsetComplementExpressionContext(TrapsetExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterAbsoluteTrapsetComplementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitAbsoluteTrapsetComplementExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitAbsoluteTrapsetComplementExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LinkedTrapsetPairExpressionContext extends TrapsetExpressionContext {
		public List<TerminalNode> TRAPSET_ID() { return getTokens(TDLExpressionLanguageParser.TRAPSET_ID); }
		public TerminalNode TRAPSET_ID(int i) {
			return getToken(TDLExpressionLanguageParser.TRAPSET_ID, i);
		}
		public TerminalNode TOP_LINKED_PAIR() { return getToken(TDLExpressionLanguageParser.TOP_LINKED_PAIR, 0); }
		public LinkedTrapsetPairExpressionContext(TrapsetExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterLinkedTrapsetPairExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitLinkedTrapsetPairExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitLinkedTrapsetPairExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrapsetExpressionContext trapsetExpression() throws RecognitionException {
		TrapsetExpressionContext _localctx = new TrapsetExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_trapsetExpression);
		try {
			setState(71);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new AbsoluteTrapsetComplementExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				match(TOP_ABSOLUTE_COMPLEMENT);
				setState(64);
				match(TRAPSET_ID);
				}
				break;
			case 2:
				_localctx = new RelativeTrapsetComplementExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				match(TRAPSET_ID);
				setState(66);
				match(TOP_RELATIVE_COMPLEMENT);
				setState(67);
				match(TRAPSET_ID);
				}
				break;
			case 3:
				_localctx = new LinkedTrapsetPairExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				match(TRAPSET_ID);
				setState(69);
				match(TOP_LINKED_PAIR);
				setState(70);
				match(TRAPSET_ID);
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

	public static class BoundOverNaturalsContext extends ParserRuleContext {
		public BoundOverNaturalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boundOverNaturals; }
	 
		public BoundOverNaturalsContext() { }
		public void copyFrom(BoundOverNaturalsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GreaterThanOrEqBoundContext extends BoundOverNaturalsContext {
		public TerminalNode REL_GREATER_THAN_OR_EQ() { return getToken(TDLExpressionLanguageParser.REL_GREATER_THAN_OR_EQ, 0); }
		public TerminalNode NATURAL_NUMBER() { return getToken(TDLExpressionLanguageParser.NATURAL_NUMBER, 0); }
		public GreaterThanOrEqBoundContext(BoundOverNaturalsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterGreaterThanOrEqBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitGreaterThanOrEqBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitGreaterThanOrEqBound(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityBoundContext extends BoundOverNaturalsContext {
		public TerminalNode REL_EQUAL() { return getToken(TDLExpressionLanguageParser.REL_EQUAL, 0); }
		public TerminalNode NATURAL_NUMBER() { return getToken(TDLExpressionLanguageParser.NATURAL_NUMBER, 0); }
		public EqualityBoundContext(BoundOverNaturalsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterEqualityBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitEqualityBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitEqualityBound(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterThanBoundContext extends BoundOverNaturalsContext {
		public TerminalNode REL_GREATER_THAN() { return getToken(TDLExpressionLanguageParser.REL_GREATER_THAN, 0); }
		public TerminalNode NATURAL_NUMBER() { return getToken(TDLExpressionLanguageParser.NATURAL_NUMBER, 0); }
		public GreaterThanBoundContext(BoundOverNaturalsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterGreaterThanBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitGreaterThanBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitGreaterThanBound(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessThanBoundContext extends BoundOverNaturalsContext {
		public TerminalNode REL_LESS_THAN() { return getToken(TDLExpressionLanguageParser.REL_LESS_THAN, 0); }
		public TerminalNode NATURAL_NUMBER() { return getToken(TDLExpressionLanguageParser.NATURAL_NUMBER, 0); }
		public LessThanBoundContext(BoundOverNaturalsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterLessThanBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitLessThanBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitLessThanBound(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessThanOrEqBoundContext extends BoundOverNaturalsContext {
		public TerminalNode REL_LESS_THAN_OR_EQ() { return getToken(TDLExpressionLanguageParser.REL_LESS_THAN_OR_EQ, 0); }
		public TerminalNode NATURAL_NUMBER() { return getToken(TDLExpressionLanguageParser.NATURAL_NUMBER, 0); }
		public LessThanOrEqBoundContext(BoundOverNaturalsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).enterLessThanOrEqBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TDLExpressionLanguageListener ) ((TDLExpressionLanguageListener)listener).exitLessThanOrEqBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TDLExpressionLanguageVisitor ) return ((TDLExpressionLanguageVisitor<? extends T>)visitor).visitLessThanOrEqBound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoundOverNaturalsContext boundOverNaturals() throws RecognitionException {
		BoundOverNaturalsContext _localctx = new BoundOverNaturalsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_boundOverNaturals);
		try {
			setState(83);
			switch (_input.LA(1)) {
			case REL_LESS_THAN:
				_localctx = new LessThanBoundContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(REL_LESS_THAN);
				setState(74);
				match(NATURAL_NUMBER);
				}
				break;
			case REL_GREATER_THAN:
				_localctx = new GreaterThanBoundContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(REL_GREATER_THAN);
				setState(76);
				match(NATURAL_NUMBER);
				}
				break;
			case REL_LESS_THAN_OR_EQ:
				_localctx = new LessThanOrEqBoundContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				match(REL_LESS_THAN_OR_EQ);
				setState(78);
				match(NATURAL_NUMBER);
				}
				break;
			case REL_GREATER_THAN_OR_EQ:
				_localctx = new GreaterThanOrEqBoundContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				match(REL_GREATER_THAN_OR_EQ);
				setState(80);
				match(NATURAL_NUMBER);
				}
				break;
			case REL_EQUAL:
				_localctx = new EqualityBoundContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(81);
				match(REL_EQUAL);
				setState(82);
				match(NATURAL_NUMBER);
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
		case 0:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33X\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\5\2\31\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\61\n\2\f\2\16\2\64\13\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3@\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4J\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5V\n\5\3\5\2\3"+
		"\2\6\2\4\6\b\2\2c\2\30\3\2\2\2\4?\3\2\2\2\6I\3\2\2\2\bU\3\2\2\2\n\13\b"+
		"\2\1\2\13\f\7\t\2\2\f\31\5\2\2\13\r\16\7\5\2\2\16\17\5\2\2\2\17\20\7\6"+
		"\2\2\20\31\3\2\2\2\21\22\7\17\2\2\22\23\5\2\2\2\23\24\7\3\2\2\24\25\5"+
		"\b\5\2\25\26\7\4\2\2\26\31\3\2\2\2\27\31\5\4\3\2\30\n\3\2\2\2\30\r\3\2"+
		"\2\2\30\21\3\2\2\2\30\27\3\2\2\2\31\62\3\2\2\2\32\33\f\n\2\2\33\34\7\n"+
		"\2\2\34\61\5\2\2\13\35\36\f\t\2\2\36\37\7\13\2\2\37\61\5\2\2\n !\f\b\2"+
		"\2!\"\7\f\2\2\"\61\5\2\2\t#$\f\7\2\2$%\7\r\2\2%\61\5\2\2\b&\'\f\6\2\2"+
		"\'(\7\16\2\2(\61\5\2\2\7)*\f\5\2\2*+\7\16\2\2+,\7\3\2\2,-\5\b\5\2-.\7"+
		"\4\2\2./\5\2\2\6/\61\3\2\2\2\60\32\3\2\2\2\60\35\3\2\2\2\60 \3\2\2\2\60"+
		"#\3\2\2\2\60&\3\2\2\2\60)\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3"+
		"\2\2\2\63\3\3\2\2\2\64\62\3\2\2\2\65\66\7\7\2\2\66\67\7\5\2\2\678\5\6"+
		"\4\289\7\6\2\29@\3\2\2\2:;\7\b\2\2;<\7\5\2\2<=\5\6\4\2=>\7\6\2\2>@\3\2"+
		"\2\2?\65\3\2\2\2?:\3\2\2\2@\5\3\2\2\2AB\7\20\2\2BJ\7\30\2\2CD\7\30\2\2"+
		"DE\7\21\2\2EJ\7\30\2\2FG\7\30\2\2GH\7\22\2\2HJ\7\30\2\2IA\3\2\2\2IC\3"+
		"\2\2\2IF\3\2\2\2J\7\3\2\2\2KL\7\25\2\2LV\7\31\2\2MN\7\26\2\2NV\7\31\2"+
		"\2OP\7\23\2\2PV\7\31\2\2QR\7\24\2\2RV\7\31\2\2ST\7\27\2\2TV\7\31\2\2U"+
		"K\3\2\2\2UM\3\2\2\2UO\3\2\2\2UQ\3\2\2\2US\3\2\2\2V\t\3\2\2\2\b\30\60\62"+
		"?IU";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}