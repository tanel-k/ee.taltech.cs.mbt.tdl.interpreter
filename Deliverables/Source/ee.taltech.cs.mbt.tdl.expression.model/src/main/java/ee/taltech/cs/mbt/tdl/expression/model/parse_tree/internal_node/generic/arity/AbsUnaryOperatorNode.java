package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.arity;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.AbsOperatorNode;

public abstract class AbsUnaryOperatorNode<O extends AbsExpressionNode>
	extends AbsOperatorNode<O>
	implements IUnaryOperator<O>
{
	@Override
	public O getOperand() {
		return getOperand(ORD_FIRST_OPERAND);
	}

	@Override
	public void setOperand(O operand) {
		setOperand(ORD_FIRST_OPERAND, operand);
	}

	public AbsUnaryOperatorNode() {
		super(ARITY_UNARY);
	}
}
