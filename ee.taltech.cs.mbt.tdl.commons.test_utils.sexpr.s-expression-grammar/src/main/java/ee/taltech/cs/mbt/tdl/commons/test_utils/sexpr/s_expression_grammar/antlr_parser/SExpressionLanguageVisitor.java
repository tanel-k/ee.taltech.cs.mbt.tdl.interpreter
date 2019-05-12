// Generated from SExpressionLanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_grammar.antlr_parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SExpressionLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SExpressionLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SExpressionLanguageParser#sExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSExpr(SExpressionLanguageParser.SExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NonEmptySequence}
	 * labeled alternative in {@link SExpressionLanguageParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonEmptySequence(SExpressionLanguageParser.NonEmptySequenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptySequence}
	 * labeled alternative in {@link SExpressionLanguageParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptySequence(SExpressionLanguageParser.EmptySequenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SequenceItem}
	 * labeled alternative in {@link SExpressionLanguageParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceItem(SExpressionLanguageParser.SequenceItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringItem}
	 * labeled alternative in {@link SExpressionLanguageParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringItem(SExpressionLanguageParser.StringItemContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DelimitedString}
	 * labeled alternative in {@link SExpressionLanguageParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelimitedString(SExpressionLanguageParser.DelimitedStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NonDelimitedString}
	 * labeled alternative in {@link SExpressionLanguageParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonDelimitedString(SExpressionLanguageParser.NonDelimitedStringContext ctx);
}