// Generated from TdlExpressionLanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TdlExpressionLanguageParser}.
 */
public interface TdlExpressionLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code GroundTermExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGroundTermExpression(TdlExpressionLanguageParser.GroundTermExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GroundTermExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGroundTermExpression(TdlExpressionLanguageParser.GroundTermExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LeadsToExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLeadsToExpression(TdlExpressionLanguageParser.LeadsToExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LeadsToExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLeadsToExpression(TdlExpressionLanguageParser.LeadsToExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImplicativeExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterImplicativeExpression(TdlExpressionLanguageParser.ImplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImplicativeExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitImplicativeExpression(TdlExpressionLanguageParser.ImplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GroupedExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGroupedExpression(TdlExpressionLanguageParser.GroupedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GroupedExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGroupedExpression(TdlExpressionLanguageParser.GroupedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConjunctiveExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConjunctiveExpression(TdlExpressionLanguageParser.ConjunctiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConjunctiveExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConjunctiveExpression(TdlExpressionLanguageParser.ConjunctiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EquivalenceExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEquivalenceExpression(TdlExpressionLanguageParser.EquivalenceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EquivalenceExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEquivalenceExpression(TdlExpressionLanguageParser.EquivalenceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalRepetitionExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalRepetitionExpression(TdlExpressionLanguageParser.ConditionalRepetitionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalRepetitionExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalRepetitionExpression(TdlExpressionLanguageParser.ConditionalRepetitionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegatedExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegatedExpression(TdlExpressionLanguageParser.NegatedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegatedExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegatedExpression(TdlExpressionLanguageParser.NegatedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TimeBoundedLeadsToExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTimeBoundedLeadsToExpression(TdlExpressionLanguageParser.TimeBoundedLeadsToExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TimeBoundedLeadsToExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTimeBoundedLeadsToExpression(TdlExpressionLanguageParser.TimeBoundedLeadsToExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DisjunctiveExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDisjunctiveExpression(TdlExpressionLanguageParser.DisjunctiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DisjunctiveExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDisjunctiveExpression(TdlExpressionLanguageParser.DisjunctiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UniversalTrapsetExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#quantifiedTrapsetExpression}.
	 * @param ctx the parse tree
	 */
	void enterUniversalTrapsetExpression(TdlExpressionLanguageParser.UniversalTrapsetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UniversalTrapsetExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#quantifiedTrapsetExpression}.
	 * @param ctx the parse tree
	 */
	void exitUniversalTrapsetExpression(TdlExpressionLanguageParser.UniversalTrapsetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistentialTrapsetExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#quantifiedTrapsetExpression}.
	 * @param ctx the parse tree
	 */
	void enterExistentialTrapsetExpression(TdlExpressionLanguageParser.ExistentialTrapsetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistentialTrapsetExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#quantifiedTrapsetExpression}.
	 * @param ctx the parse tree
	 */
	void exitExistentialTrapsetExpression(TdlExpressionLanguageParser.ExistentialTrapsetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AbsoluteTrapsetComplementExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void enterAbsoluteTrapsetComplementExpression(TdlExpressionLanguageParser.AbsoluteTrapsetComplementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AbsoluteTrapsetComplementExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void exitAbsoluteTrapsetComplementExpression(TdlExpressionLanguageParser.AbsoluteTrapsetComplementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelativeTrapsetComplementExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelativeTrapsetComplementExpression(TdlExpressionLanguageParser.RelativeTrapsetComplementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelativeTrapsetComplementExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelativeTrapsetComplementExpression(TdlExpressionLanguageParser.RelativeTrapsetComplementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LinkedTrapsetPairExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void enterLinkedTrapsetPairExpression(TdlExpressionLanguageParser.LinkedTrapsetPairExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LinkedTrapsetPairExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void exitLinkedTrapsetPairExpression(TdlExpressionLanguageParser.LinkedTrapsetPairExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BaseTrapsetExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void enterBaseTrapsetExpression(TdlExpressionLanguageParser.BaseTrapsetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BaseTrapsetExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void exitBaseTrapsetExpression(TdlExpressionLanguageParser.BaseTrapsetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessThanBound}
	 * labeled alternative in {@link TdlExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void enterLessThanBound(TdlExpressionLanguageParser.LessThanBoundContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessThanBound}
	 * labeled alternative in {@link TdlExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void exitLessThanBound(TdlExpressionLanguageParser.LessThanBoundContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterThanBound}
	 * labeled alternative in {@link TdlExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanBound(TdlExpressionLanguageParser.GreaterThanBoundContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterThanBound}
	 * labeled alternative in {@link TdlExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanBound(TdlExpressionLanguageParser.GreaterThanBoundContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessThanOrEqBound}
	 * labeled alternative in {@link TdlExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void enterLessThanOrEqBound(TdlExpressionLanguageParser.LessThanOrEqBoundContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessThanOrEqBound}
	 * labeled alternative in {@link TdlExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void exitLessThanOrEqBound(TdlExpressionLanguageParser.LessThanOrEqBoundContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterThanOrEqBound}
	 * labeled alternative in {@link TdlExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanOrEqBound(TdlExpressionLanguageParser.GreaterThanOrEqBoundContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterThanOrEqBound}
	 * labeled alternative in {@link TdlExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanOrEqBound(TdlExpressionLanguageParser.GreaterThanOrEqBoundContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityBound}
	 * labeled alternative in {@link TdlExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void enterEqualityBound(TdlExpressionLanguageParser.EqualityBoundContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityBound}
	 * labeled alternative in {@link TdlExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void exitEqualityBound(TdlExpressionLanguageParser.EqualityBoundContext ctx);
}