package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.logical;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.modifier.BoundNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.structure.node.internal.logical.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.structure.node.internal.logical.AbsUnaryLogicalOperatorNode;
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
