package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.logical.arity;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.arity.AbsBinaryOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.logical.INegatable;

public abstract class AbsBinaryLogicalOperatorNode<O extends AbsExpressionNode>
	extends AbsBinaryOperatorNode<O>
	implements INegatable
{
	private boolean negated;

	public boolean isNegated() {
		return negated;
	}

	public void setNegated(boolean negated) {
		this.negated = negated;
	}
}
