package ee.taltech.cs.mbt.tdl.expression.model.parse_tree;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.AbsOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.logical.AbsLogicalOperatorNode;

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
