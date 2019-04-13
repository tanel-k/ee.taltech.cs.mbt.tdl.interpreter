package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.operands;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OperandContainer<OperandType extends AbsExpressionNode> {
	public static final int ARITY_UNARY = 1;
	public static final int ARITY_BINARY = 2;

	public static final int ORDINAL_FIRST = 0;
	public static final int ORDINAL_SECOND = 1;

	public final int arity;
	private ArrayList<OperandType> operands;
	private LinkedHashMap<OperandType, Integer> operandOrdinals;

	public OperandContainer(int arity) {
		this.arity = arity;
		this.operandOrdinals = new LinkedHashMap<>(arity);
		this.operands = new ArrayList<>(Collections.nCopies(this.arity, null));
	}

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

	public OperandContainer<OperandType> setOperand(int ordinal, OperandType operand) {
		if (ordinal < 0 || arity <= ordinal) {
			throw new IllegalArgumentException("Ordinal out of bounds.");
		}
		this.operandOrdinals.remove(getOperand(ordinal));
		this.operandOrdinals.put(operand, ordinal);
		this.operands.set(ordinal, operand);
		return this;
	}

	public OperandContainer<OperandType> replaceOperand(OperandType operand, OperandType otherOperand) {
		if (operandOrdinals.containsKey(operand)) {
			return setOperand(operandOrdinals.get(operand), otherOperand);
		}
		return this;
	}
}
