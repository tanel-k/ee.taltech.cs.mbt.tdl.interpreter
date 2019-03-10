package ee.taltech.cs.mbt.tdl.expression.parser;

import ee.taltech.cs.mbt.tdl.expression.grammar_facade.ExpressionParser;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.ExpressionTree;

public class Test {
	public static void main(String... args) {
		String input = "U(!TR1) -> E(TR1;TR2)";
		ExpressionParser expressionParser = new ExpressionParser();
		expressionParser.getParserFacade().getErrorStrategyConfig().setRecoveryEnabled(false);
		ExpressionTree tree = expressionParser.parseExpression(input);
		tree.getRootNode();
	}
}
