// Generated from TDLExpressionLanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.expression.grammar.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TDLExpressionLanguageParser}.
 */
public interface TDLExpressionLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code timeBoundedLeadsToExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTimeBoundedLeadsToExpression(TDLExpressionLanguageParser.TimeBoundedLeadsToExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code timeBoundedLeadsToExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTimeBoundedLeadsToExpression(TDLExpressionLanguageParser.TimeBoundedLeadsToExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equivalenceExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEquivalenceExpression(TDLExpressionLanguageParser.EquivalenceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equivalenceExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEquivalenceExpression(TDLExpressionLanguageParser.EquivalenceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code leadsToExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLeadsToExpression(TDLExpressionLanguageParser.LeadsToExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code leadsToExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLeadsToExpression(TDLExpressionLanguageParser.LeadsToExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalRepetitionExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalRepetitionExpression(TDLExpressionLanguageParser.ConditionalRepetitionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalRepetitionExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalRepetitionExpression(TDLExpressionLanguageParser.ConditionalRepetitionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negatedExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegatedExpression(TDLExpressionLanguageParser.NegatedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negatedExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegatedExpression(TDLExpressionLanguageParser.NegatedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code disjunctiveExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDisjunctiveExpression(TDLExpressionLanguageParser.DisjunctiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code disjunctiveExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDisjunctiveExpression(TDLExpressionLanguageParser.DisjunctiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code implicativeExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterImplicativeExpression(TDLExpressionLanguageParser.ImplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code implicativeExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitImplicativeExpression(TDLExpressionLanguageParser.ImplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code groupedExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGroupedExpression(TDLExpressionLanguageParser.GroupedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code groupedExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGroupedExpression(TDLExpressionLanguageParser.GroupedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code groundTermExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGroundTermExpression(TDLExpressionLanguageParser.GroundTermExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code groundTermExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGroundTermExpression(TDLExpressionLanguageParser.GroundTermExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conjunctiveExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConjunctiveExpression(TDLExpressionLanguageParser.ConjunctiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conjunctiveExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConjunctiveExpression(TDLExpressionLanguageParser.ConjunctiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code universalTrapsetExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#quantifiedTrapsetExpression}.
	 * @param ctx the parse tree
	 */
	void enterUniversalTrapsetExpression(TDLExpressionLanguageParser.UniversalTrapsetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code universalTrapsetExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#quantifiedTrapsetExpression}.
	 * @param ctx the parse tree
	 */
	void exitUniversalTrapsetExpression(TDLExpressionLanguageParser.UniversalTrapsetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code existentialTrapsetExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#quantifiedTrapsetExpression}.
	 * @param ctx the parse tree
	 */
	void enterExistentialTrapsetExpression(TDLExpressionLanguageParser.ExistentialTrapsetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code existentialTrapsetExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#quantifiedTrapsetExpression}.
	 * @param ctx the parse tree
	 */
	void exitExistentialTrapsetExpression(TDLExpressionLanguageParser.ExistentialTrapsetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TDLExpressionLanguageParser#relationOverNaturals}.
	 * @param ctx the parse tree
	 */
	void enterRelationOverNaturals(TDLExpressionLanguageParser.RelationOverNaturalsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TDLExpressionLanguageParser#relationOverNaturals}.
	 * @param ctx the parse tree
	 */
	void exitRelationOverNaturals(TDLExpressionLanguageParser.RelationOverNaturalsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code linkedTrapsetPairExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void enterLinkedTrapsetPairExpression(TDLExpressionLanguageParser.LinkedTrapsetPairExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code linkedTrapsetPairExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void exitLinkedTrapsetPairExpression(TDLExpressionLanguageParser.LinkedTrapsetPairExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code groupedTrapsetExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void enterGroupedTrapsetExpression(TDLExpressionLanguageParser.GroupedTrapsetExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code groupedTrapsetExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void exitGroupedTrapsetExpression(TDLExpressionLanguageParser.GroupedTrapsetExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relativeTrapsetComplementExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelativeTrapsetComplementExpression(TDLExpressionLanguageParser.RelativeTrapsetComplementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relativeTrapsetComplementExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelativeTrapsetComplementExpression(TDLExpressionLanguageParser.RelativeTrapsetComplementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code absoluteTrapsetComplementExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void enterAbsoluteTrapsetComplementExpression(TDLExpressionLanguageParser.AbsoluteTrapsetComplementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code absoluteTrapsetComplementExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 */
	void exitAbsoluteTrapsetComplementExpression(TDLExpressionLanguageParser.AbsoluteTrapsetComplementExpressionContext ctx);
}