package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.generic.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.AbsExpressionTree;

public class ExpressionTree extends AbsExpressionTree<AbsLogicalOperatorNode> {
	public ExpressionTree() { }
	public ExpressionTree(AbsLogicalOperatorNode rootNode) {
		setRootNode(rootNode);
	}
}
