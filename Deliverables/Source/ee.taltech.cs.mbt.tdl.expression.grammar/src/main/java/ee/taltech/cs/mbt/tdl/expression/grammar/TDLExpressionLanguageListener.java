// Generated from TDLExpressionLanguage.g4 by ANTLR 4.5
package ee.taltech.cs.mbt.tdl.expression.grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TDLExpressionLanguageParser}.
 */
public interface TDLExpressionLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TDLExpressionLanguageParser#sample}.
	 * @param ctx the parse tree
	 */
	void enterSample(TDLExpressionLanguageParser.SampleContext ctx);
	/**
	 * Exit a parse tree produced by {@link TDLExpressionLanguageParser#sample}.
	 * @param ctx the parse tree
	 */
	void exitSample(TDLExpressionLanguageParser.SampleContext ctx);
}