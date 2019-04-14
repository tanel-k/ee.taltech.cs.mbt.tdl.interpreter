package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;

public class BinaryChildContainer<OperandType extends AbsExpressionNode> extends ChildContainer<OperandType> {
	public BinaryChildContainer() {
		super(ARITY_BINARY);
	}

	public OperandType getLeftOperand() {
		return getOperand(ORDINAL_FIRST);
	}

	public BinaryChildContainer<OperandType> setLeftOperand(OperandType operand) {
		setOperand(ORDINAL_FIRST, operand);
		return this;
	}

	public OperandType getRightOperand() {
		return super.getOperand(ORDINAL_SECOND);
	}

	public BinaryChildContainer<OperandType> setRightOperand(OperandType operand) {
		setOperand(ORDINAL_SECOND, operand);
		return this;
	}
}
