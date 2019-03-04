package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.arity;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.AbsExpressionNode;

public interface IBinaryOperator<O extends AbsExpressionNode> {
	public O getFirstOperand();
	public void setFirstOperand(O operand);
	public O getSecondOperand();
	public void setSecondOperand(O operand);
}
