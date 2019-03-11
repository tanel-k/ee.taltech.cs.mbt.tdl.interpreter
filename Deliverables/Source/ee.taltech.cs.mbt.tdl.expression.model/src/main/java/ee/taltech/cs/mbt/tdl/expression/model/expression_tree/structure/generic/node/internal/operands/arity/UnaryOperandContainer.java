package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.operands.arity;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.operands.OperandContainer;

public class UnaryOperandContainer<OperandType extends AbsExpressionNode> extends OperandContainer<OperandType> {
	public UnaryOperandContainer() {
		super(ARITY_UNARY);
	}

	public OperandType getOperand() {
		return getOperand(ORDINAL_FIRST);
	}

	public UnaryOperandContainer<OperandType> setOperand(OperandType operand) {
		setOperand(ORDINAL_FIRST, operand);
		return this;
	}
}
