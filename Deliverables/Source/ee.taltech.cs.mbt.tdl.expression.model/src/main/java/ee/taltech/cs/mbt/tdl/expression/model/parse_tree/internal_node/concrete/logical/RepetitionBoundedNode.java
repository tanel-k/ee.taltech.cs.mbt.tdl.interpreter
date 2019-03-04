package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.concrete.logical;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.logical.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.logical.AbsUnaryLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.leaf_node.bound.BoundNode;

public class RepetitionBoundedNode extends AbsUnaryLogicalOperatorNode<AbsLogicalOperatorNode> implements IBounded {
	private BoundNode boundNode;

	@Override
	public BoundNode getBoundNode() {
		return boundNode;
	}

	@Override
	public void setBoundNode(BoundNode boundNode) {
		this.boundNode = boundNode;
	}
}
