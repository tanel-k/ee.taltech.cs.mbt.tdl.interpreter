package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.arity;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.AbsOperatorNode;

public abstract class AbsBinaryOperatorNode<O extends AbsExpressionNode>
	extends AbsOperatorNode<O>
	implements IBinaryOperator<O>
{
	@Override
	public O getFirstOperand() {
		return getOperand(ORD_FIRST_OPERAND);
	}

	@Override
	public void setFirstOperand(O operand) {
		this.setOperand(ORD_FIRST_OPERAND, operand);
	}

	@Override
	public O getSecondOperand() {
		return getOperand(ORD_SECOND_OPERAND);
	}

	@Override
	public void setSecondOperand(O operand) {
		this.setOperand(ORD_SECOND_OPERAND, operand);
	}

	public AbsBinaryOperatorNode() {
		super(ARITY_BINARY);
	}
}
