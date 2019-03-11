package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.logical.generic.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.modifier.Bound;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.modifier.IBounded;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.operands.arity.UnaryOperandContainer;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IExpressionTreeVisitor;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.traversal.IVisitableNode;

public class BoundedRepetitionNode extends AbsLogicalOperatorNode<
		AbsLogicalOperatorNode,
		UnaryOperandContainer<AbsLogicalOperatorNode>
		> implements IBounded, IVisitableNode {
	private Bound bound;

	public BoundedRepetitionNode() {
		super(new UnaryOperandContainer<>());
	}

	@Override
	public Bound getBound() {
		return bound;
	}

	@Override
	public void setBound(Bound bound) {
		this.bound = bound;
	}

	@Override
	public void accept(IExpressionTreeVisitor visitor) {
		visitor.visitBoundedRepetitionNode(this);
	}
}
