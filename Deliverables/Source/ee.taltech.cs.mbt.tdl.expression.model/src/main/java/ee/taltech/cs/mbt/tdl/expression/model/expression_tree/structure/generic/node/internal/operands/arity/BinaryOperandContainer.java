package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.operands.arity;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.operands.OperandContainer;

public class BinaryOperandContainer<OperandType> extends OperandContainer<OperandType> {
	public OperandType getLeftOperand() {
		return getOperand(ORDINAL_FIRST);
	}

	public void setLeftOperand(OperandType operand) {
		setOperand(ORDINAL_FIRST, operand);
	}

	public OperandType getRightOperand() {
		return super.getOperand(ORDINAL_SECOND);
	}

	public void setRightOperand(OperandType operand) {
		setOperand(ORDINAL_SECOND, operand);
	}

	public BinaryOperandContainer() {
		super(ARITY_BINARY);
	}
}
