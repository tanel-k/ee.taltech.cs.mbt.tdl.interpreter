// Generated from SExpressionLanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_grammar.antlr_parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SExpressionLanguageParser}.
 */
public interface SExpressionLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SExpressionLanguageParser#sExpr}.
	 * @param ctx the parse tree
	 */
	void enterSExpr(SExpressionLanguageParser.SExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SExpressionLanguageParser#sExpr}.
	 * @param ctx the parse tree
	 */
	void exitSExpr(SExpressionLanguageParser.SExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NonEmptySequence}
	 * labeled alternative in {@link SExpressionLanguageParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterNonEmptySequence(SExpressionLanguageParser.NonEmptySequenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NonEmptySequence}
	 * labeled alternative in {@link SExpressionLanguageParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitNonEmptySequence(SExpressionLanguageParser.NonEmptySequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptySequence}
	 * labeled alternative in {@link SExpressionLanguageParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterEmptySequence(SExpressionLanguageParser.EmptySequenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptySequence}
	 * labeled alternative in {@link SExpressionLanguageParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitEmptySequence(SExpressionLanguageParser.EmptySequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SequenceItem}
	 * labeled alternative in {@link SExpressionLanguageParser#item}.
	 * @param ctx the parse tree
	 */
	void enterSequenceItem(SExpressionLanguageParser.SequenceItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SequenceItem}
	 * labeled alternative in {@link SExpressionLanguageParser#item}.
	 * @param ctx the parse tree
	 */
	void exitSequenceItem(SExpressionLanguageParser.SequenceItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringItem}
	 * labeled alternative in {@link SExpressionLanguageParser#item}.
	 * @param ctx the parse tree
	 */
	void enterStringItem(SExpressionLanguageParser.StringItemContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringItem}
	 * labeled alternative in {@link SExpressionLanguageParser#item}.
	 * @param ctx the parse tree
	 */
	void exitStringItem(SExpressionLanguageParser.StringItemContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DelimitedString}
	 * labeled alternative in {@link SExpressionLanguageParser#string}.
	 * @param ctx the parse tree
	 */
	void enterDelimitedString(SExpressionLanguageParser.DelimitedStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DelimitedString}
	 * labeled alternative in {@link SExpressionLanguageParser#string}.
	 * @param ctx the parse tree
	 */
	void exitDelimitedString(SExpressionLanguageParser.DelimitedStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NonDelimitedString}
	 * labeled alternative in {@link SExpressionLanguageParser#string}.
	 * @param ctx the parse tree
	 */
	void enterNonDelimitedString(SExpressionLanguageParser.NonDelimitedStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NonDelimitedString}
	 * labeled alternative in {@link SExpressionLanguageParser#string}.
	 * @param ctx the parse tree
	 */
	void exitNonDelimitedString(SExpressionLanguageParser.NonDelimitedStringContext ctx);
}