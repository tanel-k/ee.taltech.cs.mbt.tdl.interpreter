package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.operator.arity;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.operator.IOperator;

public interface IUnaryOperator<O> extends IOperator<O> {
	default O getOperand() {
		return getOperand(ORDINAL_FIRST);
	}

	default void setOperand(O operand) {
		setOperand(ORDINAL_FIRST, operand);
	}

	@Override
	default int getOperatorArity() {
		return ARITY_UNARY;
	}
}
