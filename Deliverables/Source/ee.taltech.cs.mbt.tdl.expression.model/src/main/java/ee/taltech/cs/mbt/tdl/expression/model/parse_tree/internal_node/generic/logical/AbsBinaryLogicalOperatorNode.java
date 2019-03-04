package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.logical;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.arity.IBinaryOperatorNode;

public abstract class AbsBinaryLogicalOperatorNode<O extends AbsExpressionNode>
	extends AbsLogicalOperatorNode<O>
	implements IBinaryOperatorNode<O>
{
	@Override
	public O getFirstOperand() {
		return getOperand(ORD_FIRST_OPERAND);
	}

	@Override
	public void setFirstOperand(O operand) {
		setOperand(ORD_FIRST_OPERAND, operand);
	}

	@Override
	public O getSecondOperand() {
		return getOperand(ORD_SECOND_OPERAND);
	}

	@Override
	public void setSecondOperand(O operand) {
		setOperand(ORD_SECOND_OPERAND, operand);
	}

	public AbsBinaryLogicalOperatorNode() {
		super(ARITY_BINARY);
	}
}
