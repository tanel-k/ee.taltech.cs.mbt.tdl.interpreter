package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.operands.arity;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.operands.OperandContainer;

public class BinaryOperandContainer<OperandType extends AbsExpressionNode> extends OperandContainer<OperandType> {
	public BinaryOperandContainer() {
		super(ARITY_BINARY);
	}

	public OperandType getLeftOperand() {
		return getOperand(ORDINAL_FIRST);
	}

	public BinaryOperandContainer<OperandType> setLeftOperand(OperandType operand) {
		setOperand(ORDINAL_FIRST, operand);
		return this;
	}

	public OperandType getRightOperand() {
		return super.getOperand(ORDINAL_SECOND);
	}

	public BinaryOperandContainer<OperandType> setRightOperand(OperandType operand) {
		setOperand(ORDINAL_SECOND, operand);
		return this;
	}
}
