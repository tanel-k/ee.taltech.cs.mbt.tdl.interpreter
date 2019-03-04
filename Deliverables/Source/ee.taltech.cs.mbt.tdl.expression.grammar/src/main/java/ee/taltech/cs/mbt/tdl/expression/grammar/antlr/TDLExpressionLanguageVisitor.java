// Generated from TDLExpressionLanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.expression.grammar.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete parse_tree visitor for a parse parse_tree produced
 * by {@link TDLExpressionLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TDLExpressionLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse parse_tree produced by the {@code GroundTermExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitGroundTermExpression(TDLExpressionLanguageParser.GroundTermExpressionContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code LeadsToExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitLeadsToExpression(TDLExpressionLanguageParser.LeadsToExpressionContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code ImplicativeExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitImplicativeExpression(TDLExpressionLanguageParser.ImplicativeExpressionContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code GroupedExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitGroupedExpression(TDLExpressionLanguageParser.GroupedExpressionContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code ConjunctiveExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitConjunctiveExpression(TDLExpressionLanguageParser.ConjunctiveExpressionContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code EquivalenceExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitEquivalenceExpression(TDLExpressionLanguageParser.EquivalenceExpressionContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code NegatedExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitNegatedExpression(TDLExpressionLanguageParser.NegatedExpressionContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code ConditionalRepetitionExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitConditionalRepetitionExpression(TDLExpressionLanguageParser.ConditionalRepetitionExpressionContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code TimeBoundedLeadsToExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitTimeBoundedLeadsToExpression(TDLExpressionLanguageParser.TimeBoundedLeadsToExpressionContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code DisjunctiveExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#expression}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitDisjunctiveExpression(TDLExpressionLanguageParser.DisjunctiveExpressionContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code UniversalTrapsetExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#quantifiedTrapsetExpression}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitUniversalTrapsetExpression(TDLExpressionLanguageParser.UniversalTrapsetExpressionContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code ExistentialTrapsetExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#quantifiedTrapsetExpression}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitExistentialTrapsetExpression(TDLExpressionLanguageParser.ExistentialTrapsetExpressionContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code RelativeTrapsetComplementExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitRelativeTrapsetComplementExpression(TDLExpressionLanguageParser.RelativeTrapsetComplementExpressionContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code TrapsetIdentifierExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitTrapsetIdentifierExpression(TDLExpressionLanguageParser.TrapsetIdentifierExpressionContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code AbsoluteTrapsetComplementExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitAbsoluteTrapsetComplementExpression(TDLExpressionLanguageParser.AbsoluteTrapsetComplementExpressionContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code LinkedTrapsetPairExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitLinkedTrapsetPairExpression(TDLExpressionLanguageParser.LinkedTrapsetPairExpressionContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code GroupedTrapsetExpression}
	 * labeled alternative in {@link TDLExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitGroupedTrapsetExpression(TDLExpressionLanguageParser.GroupedTrapsetExpressionContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code LessThanBound}
	 * labeled alternative in {@link TDLExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitLessThanBound(TDLExpressionLanguageParser.LessThanBoundContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code GreaterThanBound}
	 * labeled alternative in {@link TDLExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitGreaterThanBound(TDLExpressionLanguageParser.GreaterThanBoundContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code LessThanOrEqBound}
	 * labeled alternative in {@link TDLExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitLessThanOrEqBound(TDLExpressionLanguageParser.LessThanOrEqBoundContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code GreaterThanOrEqBound}
	 * labeled alternative in {@link TDLExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitGreaterThanOrEqBound(TDLExpressionLanguageParser.GreaterThanOrEqBoundContext ctx);
	/**
	 * Visit a parse parse_tree produced by the {@code EqualityBound}
	 * labeled alternative in {@link TDLExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse parse_tree
	 * @return the visitor result
	 */
	T visitEqualityBound(TDLExpressionLanguageParser.EqualityBoundContext ctx);
}