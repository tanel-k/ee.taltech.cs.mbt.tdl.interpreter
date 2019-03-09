package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.operands.arity;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.operands.OperandContainer;

public class UnaryOperandContainer<OperandType> extends OperandContainer<OperandType> {
	public OperandType getOperand() {
		return getOperand(ORDINAL_FIRST);
	}

	public void setOperand(OperandType operand) {
		setOperand(ORDINAL_SECOND, operand);
	}

	public UnaryOperandContainer() {
		super(ARITY_UNARY);
	}
}
