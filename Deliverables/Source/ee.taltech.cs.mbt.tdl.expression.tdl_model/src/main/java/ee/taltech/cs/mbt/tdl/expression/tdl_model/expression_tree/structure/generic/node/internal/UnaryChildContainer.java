package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;

public class UnaryChildContainer<OperandType extends AbsExpressionNode> extends ChildContainer<OperandType> {
	public UnaryChildContainer() {
		super(ARITY_UNARY);
	}

	public OperandType getOperand() {
		return getOperand(ORDINAL_FIRST);
	}

	public UnaryChildContainer<OperandType> setOperand(OperandType operand) {
		setOperand(ORDINAL_FIRST, operand);
		return this;
	}
}
