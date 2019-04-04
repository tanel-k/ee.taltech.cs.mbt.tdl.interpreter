// Generated from TdlExpressionLanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.expression.tdl_grammar.antlr_parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TdlExpressionLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TdlExpressionLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code GroundTermExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroundTermExpression(TdlExpressionLanguageParser.GroundTermExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LeadsToExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeadsToExpression(TdlExpressionLanguageParser.LeadsToExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImplicativeExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplicativeExpression(TdlExpressionLanguageParser.ImplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GroupedExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupedExpression(TdlExpressionLanguageParser.GroupedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConjunctiveExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunctiveExpression(TdlExpressionLanguageParser.ConjunctiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EquivalenceExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquivalenceExpression(TdlExpressionLanguageParser.EquivalenceExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegatedExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegatedExpression(TdlExpressionLanguageParser.NegatedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConditionalRepetitionExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalRepetitionExpression(TdlExpressionLanguageParser.ConditionalRepetitionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TimeBoundedLeadsToExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeBoundedLeadsToExpression(TdlExpressionLanguageParser.TimeBoundedLeadsToExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DisjunctiveExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunctiveExpression(TdlExpressionLanguageParser.DisjunctiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UniversalTrapsetExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#quantifiedTrapsetExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniversalTrapsetExpression(TdlExpressionLanguageParser.UniversalTrapsetExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExistentialTrapsetExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#quantifiedTrapsetExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistentialTrapsetExpression(TdlExpressionLanguageParser.ExistentialTrapsetExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AbsoluteTrapsetComplementExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsoluteTrapsetComplementExpression(TdlExpressionLanguageParser.AbsoluteTrapsetComplementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelativeTrapsetComplementExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelativeTrapsetComplementExpression(TdlExpressionLanguageParser.RelativeTrapsetComplementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LinkedTrapsetPairExpression}
	 * labeled alternative in {@link TdlExpressionLanguageParser#trapsetExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinkedTrapsetPairExpression(TdlExpressionLanguageParser.LinkedTrapsetPairExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThanBound}
	 * labeled alternative in {@link TdlExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThanBound(TdlExpressionLanguageParser.LessThanBoundContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterThanBound}
	 * labeled alternative in {@link TdlExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanBound(TdlExpressionLanguageParser.GreaterThanBoundContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThanOrEqBound}
	 * labeled alternative in {@link TdlExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThanOrEqBound(TdlExpressionLanguageParser.LessThanOrEqBoundContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterThanOrEqBound}
	 * labeled alternative in {@link TdlExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanOrEqBound(TdlExpressionLanguageParser.GreaterThanOrEqBoundContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualityBound}
	 * labeled alternative in {@link TdlExpressionLanguageParser#boundOverNaturals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityBound(TdlExpressionLanguageParser.EqualityBoundContext ctx);
}