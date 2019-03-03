// Generated from TDLExpressionLanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.expression.grammar.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TDLExpressionLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TDLExpressionLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code timeBoundedLeadsToExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeBoundedLeadsToExpression(TDLExpressionLanguageParser.TimeBoundedLeadsToExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equivalenceExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquivalenceExpression(TDLExpressionLanguageParser.EquivalenceExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code leadsToExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeadsToExpression(TDLExpressionLanguageParser.LeadsToExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalRepetitionExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalRepetitionExpression(TDLExpressionLanguageParser.ConditionalRepetitionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negatedExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegatedExpression(TDLExpressionLanguageParser.NegatedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code disjunctiveExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunctiveExpression(TDLExpressionLanguageParser.DisjunctiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code implicativeExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicativeExpression(TDLExpressionLanguageParser.ImplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code groupedExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupedExpression(TDLExpressionLanguageParser.GroupedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code groundTermExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroundTermExpression(TDLExpressionLanguageParser.GroundTermExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conjunctiveExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunctiveExpression(TDLExpressionLanguageParser.ConjunctiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code universalTrapsetExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#quantifiedTrapsetExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniversalTrapsetExpression(TDLExpressionLanguageParser.UniversalTrapsetExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code existentialTrapsetExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#quantifiedTrapsetExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistentialTrapsetExpression(TDLExpressionLanguageParser.ExistentialTrapsetExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TDLExpressionLanguageParser#relationOverNaturals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationOverNaturals(TDLExpressionLanguageParser.RelationOverNaturalsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code linkedTrapsetPairExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinkedTrapsetPairExpression(TDLExpressionLanguageParser.LinkedTrapsetPairExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code groupedTrapsetExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupedTrapsetExpression(TDLExpressionLanguageParser.GroupedTrapsetExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relativeTrapsetComplementExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelativeTrapsetComplementExpression(TDLExpressionLanguageParser.RelativeTrapsetComplementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code absoluteTrapsetComplementExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsoluteTrapsetComplementExpression(TDLExpressionLanguageParser.AbsoluteTrapsetComplementExpressionContext ctx);
}