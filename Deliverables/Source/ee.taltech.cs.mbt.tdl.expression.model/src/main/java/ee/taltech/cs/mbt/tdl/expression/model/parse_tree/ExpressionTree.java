package ee.taltech.cs.mbt.tdl.expression.model.parse_tree;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.AbsOperatorNode;

public class ExpressionTree {
	private AbsOperatorNode<?> rootNode;

	public AbsOperatorNode<?> getRootNode() {
		return rootNode;
	}

	public void setRootNode(AbsOperatorNode<?> rootNode) {
		this.rootNode = rootNode;
	}

	public ExpressionTree() {}
}
