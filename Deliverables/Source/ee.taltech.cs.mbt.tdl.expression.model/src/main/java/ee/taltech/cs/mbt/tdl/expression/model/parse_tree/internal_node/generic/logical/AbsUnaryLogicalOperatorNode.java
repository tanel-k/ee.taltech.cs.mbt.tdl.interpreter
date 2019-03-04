package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.logical;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.arity.IUnaryOperatorNode;

public abstract class AbsUnaryLogicalOperatorNode<O extends AbsExpressionNode>
	extends AbsLogicalOperatorNode<O>
	implements IUnaryOperatorNode<O>
{
	@Override
	public O getOperand() {
		return getOperand(ORD_FIRST_OPERAND);
	}

	@Override
	public void setOperand(O operand) {
		setOperand(ORD_FIRST_OPERAND, operand);
	}

	public AbsUnaryLogicalOperatorNode() {
		super(ARITY_UNARY);
	}
}

