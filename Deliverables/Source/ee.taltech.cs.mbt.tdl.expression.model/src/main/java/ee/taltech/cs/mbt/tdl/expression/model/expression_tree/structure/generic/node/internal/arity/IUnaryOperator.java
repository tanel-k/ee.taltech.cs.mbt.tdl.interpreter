package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.arity;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.IOperator;

public interface IUnaryOperator<O> extends IOperator<O> {
	default O getOperand() {
		return getOperand(ORDINAL_FIRST);
	}

	default void setOperand(O operand) {
		setOperand(ORDINAL_FIRST, operand);
	}

	@Override
	default int getArity() {
		return ARITY_UNARY;
	}
}
