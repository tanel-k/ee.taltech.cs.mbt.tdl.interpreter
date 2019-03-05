package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.AbsOperatorNode;

public abstract class AbsLogicalOperatorNode<O extends AbsExpressionNode> extends AbsOperatorNode<O> {
	private boolean negated;

	public boolean isNegated() {
		return negated;
	}

	public void setNegated(boolean negated) {
		this.negated = negated;
	}

	public AbsLogicalOperatorNode(int arity) {
		super(arity);
	}
}
