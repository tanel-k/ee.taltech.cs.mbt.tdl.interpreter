package ee.taltech.cs.mbt.tdl.expression.parser.facade.converter;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.ExpressionTree;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.logical.generic.AbsLogicalOperatorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ParseTreeConverter implements IConverter<ParseTree, ExpressionTree> {
	@Override
	public ExpressionTree convert(ParseTree parseTree) {
		ExpressionTree<AbsLogicalOperatorNode> expressionTree = new ExpressionTree<>();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(new ParseTreeConversionListener(), parseTree);
		return expressionTree;
	}
}
