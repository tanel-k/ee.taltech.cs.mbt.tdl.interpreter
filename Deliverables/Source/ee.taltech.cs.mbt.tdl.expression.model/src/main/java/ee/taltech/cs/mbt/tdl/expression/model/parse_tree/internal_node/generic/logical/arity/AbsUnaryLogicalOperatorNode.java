package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.logical.arity;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.arity.AbsUnaryOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.arity.IUnaryOperator;
import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.logical.AbsLogicalOperatorNode;

public abstract class AbsUnaryLogicalOperatorNode<O extends AbsExpressionNode>
	extends AbsLogicalOperatorNode<O>
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

	public AbsUnaryLogicalOperatorNode() {
		super(ARITY_UNARY);
	}
}

