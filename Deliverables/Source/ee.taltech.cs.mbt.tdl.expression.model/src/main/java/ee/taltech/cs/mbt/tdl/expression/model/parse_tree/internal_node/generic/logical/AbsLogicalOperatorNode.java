package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.logical;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.AbsOperatorNode;

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
