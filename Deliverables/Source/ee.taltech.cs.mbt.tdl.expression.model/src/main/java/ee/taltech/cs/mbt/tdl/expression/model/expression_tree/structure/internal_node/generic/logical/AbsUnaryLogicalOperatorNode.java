package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.generic.logical;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.internal_node.generic.IUnaryOperatorNode;

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

