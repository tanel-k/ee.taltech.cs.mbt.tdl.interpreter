package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsLogicalOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.Bound;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier.IBounded;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ILogicalOperatorVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.operands.arity.UnaryOperandContainer;

public class BoundedRepetitionNode extends AbsLogicalOperatorNode<
			AbsLogicalOperatorNode,
			UnaryOperandContainer<AbsLogicalOperatorNode>
		> implements IBounded {
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
	public <T> T accept(ITdlExpressionVisitor<T> visitor) {
		return visitor.visitBoundedRepetition(this);
	}

	@Override
	public <T> T accept(ILogicalOperatorVisitor<T> visitor) {
		return visitor.visitBoundedRepetition(this);
	}
}
