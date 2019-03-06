package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.operator.arity;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.operator.IOperator;

public interface IBinaryOperator<O> extends IOperator<O> {
	@Override
	default int getArity() {
		return ARITY_BINARY;
	}

	default O getFirstOperand() {
		return getOperand(ORDINAL_FIRST);
	}

	default void setFirstOperand(O operand) {
		setOperand(ORDINAL_FIRST, operand);
	}

	default O getSecondOperand() {
		return getOperand(ORDINAL_SECOND);
	}

	default void setSecondOperand(O operand) {
		setOperand(ORDINAL_SECOND, operand);
	}
}
