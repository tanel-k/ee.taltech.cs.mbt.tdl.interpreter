package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.generic.logical.AbsLogicalOperatorNode;

public class ExpressionTree {
	private AbsLogicalOperatorNode<?> rootNode;

	public AbsLogicalOperatorNode<?> getRootNode() {
		return rootNode;
	}

	public void setRootNode(AbsLogicalOperatorNode<?> rootNode) {
		this.rootNode = rootNode;
	}

	public ExpressionTree() {}
}
