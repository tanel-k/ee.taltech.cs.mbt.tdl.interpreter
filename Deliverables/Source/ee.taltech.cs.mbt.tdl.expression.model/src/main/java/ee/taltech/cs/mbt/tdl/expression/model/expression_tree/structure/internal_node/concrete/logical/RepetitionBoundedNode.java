package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.concrete.logical;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.generic.logical.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.generic.logical.AbsUnaryLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.leaf_node.pseudo_leaf.BoundNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;

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

	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitRepetitionBoundedNode(this);
	}
}
