package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.operands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OperandContainer<OperandType> {
	public static final int ARITY_UNARY = 1;
	public static final int ARITY_BINARY = 2;

	public static final int ORDINAL_FIRST = 0;
	public static final int ORDINAL_SECOND = 1;

	public final int arity;
	private List<OperandType> operands;

	public int getArity() {
		return arity;
	}

	public List<OperandType> getListView() {
		return Collections.unmodifiableList(this.operands);
	}

	public OperandType getOperand(int ordinal) {
		if (ordinal < 0 || arity <= ordinal) {
			throw new IllegalArgumentException("Ordinal out of bounds.");
		}
		return this.operands.get(ordinal);
	}

	public void setOperand(int ordinal, OperandType operand) {
		if (ordinal < 0 || arity <= ordinal) {
			throw new IllegalArgumentException("Ordinal out of bounds.");
		}
		this.operands.set(ordinal, operand);
	}

	public OperandContainer(int arity) {
		this.arity = arity;
		this.operands = new ArrayList<>(Collections.nCopies(this.arity, null));
	}
}
