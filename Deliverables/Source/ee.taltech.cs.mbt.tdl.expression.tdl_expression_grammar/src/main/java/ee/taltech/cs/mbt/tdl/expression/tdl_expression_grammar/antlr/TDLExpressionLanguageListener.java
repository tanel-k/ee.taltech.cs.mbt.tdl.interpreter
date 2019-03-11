// Generated from TDLExpressionLanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.expression.tdl_expression_grammar.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TDLExpressionLanguageParser}.
 */
public interface TDLExpressionLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code GroundTermExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGroundTermExpression(TDLExpressionLanguageParser.GroundTermExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GroundTermExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGroundTermExpression(TDLExpressionLanguageParser.GroundTermExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LeadsToExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLeadsToExpression(TDLExpressionLanguageParser.LeadsToExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LeadsToExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLeadsToExpression(TDLExpressionLanguageParser.LeadsToExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImplicativeExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterImplicativeExpression(TDLExpressionLanguageParser.ImplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImplicativeExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitImplicativeExpression(TDLExpressionLanguageParser.ImplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GroupedExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGroupedExpression(TDLExpressionLanguageParser.GroupedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GroupedExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGroupedExpression(TDLExpressionLanguageParser.GroupedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConjunctiveExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConjunctiveExpression(TDLExpressionLanguageParser.ConjunctiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConjunctiveExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConjunctiveExpression(TDLExpressionLanguageParser.ConjunctiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EquivalenceExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEquivalenceExpression(TDLExpressionLanguageParser.EquivalenceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EquivalenceExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEquivalenceExpression(TDLExpressionLanguageParser.EquivalenceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegatedExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegatedExpression(TDLExpressionLanguageParser.NegatedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegatedExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegatedExpression(TDLExpressionLanguageParser.NegatedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConditionalRepetitionExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalRepetitionExpression(TDLExpressionLanguageParser.ConditionalRepetitionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConditionalRepetitionExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalRepetitionExpression(TDLExpressionLanguageParser.ConditionalRepetitionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TimeBoundedLeadsToExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTimeBoundedLeadsToExpression(TDLExpressionLanguageParser.TimeBoundedLeadsToExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TimeBoundedLeadsToExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTimeBoundedLeadsToExpression(TDLExpressionLanguageParser.TimeBoundedLeadsToExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DisjunctiveExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDisjunctiveExpression(TDLExpressionLanguageParser.DisjunctiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DisjunctiveExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDisjunctiveExpression(TDLExpressionLanguageParser.DisjunctiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UniversalTrapsetExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#quantifiedTrapsetExpression}.
	 * @param ctx the parse tree
	 */
	void enterUniversalTrapsetExpression(TDLExpressionLanguageParser.UniversalTrapsetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UniversalTrapsetExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#quantifiedTrapsetExpression}.
	 * @param ctx the parse tree
	 */
	void exitUniversalTrapsetExpression(TDLExpressionLanguageParser.UniversalTrapsetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExistentialTrapsetExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#quantifiedTrapsetExpression}.
	 * @param ctx the parse tree
	 */
	void enterExistentialTrapsetExpression(TDLExpressionLanguageParser.ExistentialTrapsetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExistentialTrapsetExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#quantifiedTrapsetExpression}.
	 * @param ctx the parse tree
	 */
	void exitExistentialTrapsetExpression(TDLExpressionLanguageParser.ExistentialTrapsetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AbsoluteTrapsetComplementExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void enterAbsoluteTrapsetComplementExpression(TDLExpressionLanguageParser.AbsoluteTrapsetComplementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AbsoluteTrapsetComplementExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void exitAbsoluteTrapsetComplementExpression(TDLExpressionLanguageParser.AbsoluteTrapsetComplementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelativeTrapsetComplementExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelativeTrapsetComplementExpression(TDLExpressionLanguageParser.RelativeTrapsetComplementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelativeTrapsetComplementExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelativeTrapsetComplementExpression(TDLExpressionLanguageParser.RelativeTrapsetComplementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LinkedTrapsetPairExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void enterLinkedTrapsetPairExpression(TDLExpressionLanguageParser.LinkedTrapsetPairExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LinkedTrapsetPairExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void exitLinkedTrapsetPairExpression(TDLExpressionLanguageParser.LinkedTrapsetPairExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessThanBound}
	 * labeled alternative in {@link TDLExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void enterLessThanBound(TDLExpressionLanguageParser.LessThanBoundContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessThanBound}
	 * labeled alternative in {@link TDLExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void exitLessThanBound(TDLExpressionLanguageParser.LessThanBoundContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterThanBound}
	 * labeled alternative in {@link TDLExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanBound(TDLExpressionLanguageParser.GreaterThanBoundContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterThanBound}
	 * labeled alternative in {@link TDLExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanBound(TDLExpressionLanguageParser.GreaterThanBoundContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessThanOrEqBound}
	 * labeled alternative in {@link TDLExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void enterLessThanOrEqBound(TDLExpressionLanguageParser.LessThanOrEqBoundContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessThanOrEqBound}
	 * labeled alternative in {@link TDLExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void exitLessThanOrEqBound(TDLExpressionLanguageParser.LessThanOrEqBoundContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterThanOrEqBound}
	 * labeled alternative in {@link TDLExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanOrEqBound(TDLExpressionLanguageParser.GreaterThanOrEqBoundContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterThanOrEqBound}
	 * labeled alternative in {@link TDLExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanOrEqBound(TDLExpressionLanguageParser.GreaterThanOrEqBoundContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityBound}
	 * labeled alternative in {@link TDLExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void enterEqualityBound(TDLExpressionLanguageParser.EqualityBoundContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityBound}
	 * labeled alternative in {@link TDLExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 */
	void exitEqualityBound(TDLExpressionLanguageParser.EqualityBoundContext ctx);
}