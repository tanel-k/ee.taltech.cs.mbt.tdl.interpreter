package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.structure.node.internal.logical;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.structure.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.structure.node.internal.AbsOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.structure.node.internal.IBinaryOperatorNode;

public abstract class AbsBinaryLogicalOperatorNode<O extends AbsExpressionNode>
	extends AbsLogicalOperatorNode<O>
	implements IBinaryOperatorNode<O>
{
	@Override
	public O getFirstOperand() {
		return getOperand(AbsOperatorNode.ORD_FIRST_OPERAND);
	}

	@Override
	public void setFirstOperand(O operand) {
		setOperand(AbsOperatorNode.ORD_FIRST_OPERAND, operand);
	}

	@Override
	public O getSecondOperand() {
		return getOperand(AbsOperatorNode.ORD_SECOND_OPERAND);
	}

	@Override
	public void setSecondOperand(O operand) {
		setOperand(AbsOperatorNode.ORD_SECOND_OPERAND, operand);
	}

	public AbsBinaryLogicalOperatorNode() {
		super(AbsOperatorNode.ARITY_BINARY);
	}
}
