package ee.taltech.cs.mbt.tdl.expression.grammar_facade.parsing;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.ExpressionTree;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.logical.generic.AbsLogicalOperatorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

class ParseTreeConverter {
	ParseTreeConverter() { }

	@SuppressWarnings("unchecked")
	ExpressionTree convert(ParseTree parseTree) {
		ParseTreeConversionListener conversionListener = new ParseTreeConversionListener();

		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(conversionListener, parseTree);

		ExpressionTree expressionTree = new ExpressionTree();
		AbsLogicalOperatorNode rootNode = conversionListener.getRootNode();
		expressionTree.setRootNode(rootNode);

		return expressionTree;
	}
}
