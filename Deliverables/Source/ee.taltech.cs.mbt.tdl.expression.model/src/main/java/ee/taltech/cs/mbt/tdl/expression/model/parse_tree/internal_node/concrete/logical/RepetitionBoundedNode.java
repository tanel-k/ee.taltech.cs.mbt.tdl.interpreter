package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.concrete.logical;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.arity.AbsUnaryOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.leaf_node.bound.BoundNode;

public class RepetitionBoundedNode extends AbsUnaryOperatorNode<AbsExpressionNode> implements IBounded {
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
