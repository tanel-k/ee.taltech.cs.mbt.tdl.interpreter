package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic.arity;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.AbsExpressionNode;

public interface IUnaryOperator<O extends AbsExpressionNode> {
	public O getOperand();
	public void setOperand(O operand);
}
