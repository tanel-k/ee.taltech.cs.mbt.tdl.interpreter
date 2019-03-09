package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.arity;

public interface IBinaryOperator<O> extends IOperator<O> {
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

	@Override
	default int getArity() {
		return ARITY_BINARY;
	}
}
