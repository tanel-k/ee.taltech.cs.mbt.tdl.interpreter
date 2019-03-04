package ee.taltech.cs.mbt.tdl.expression.model.parse_tree.internal_node.generic;

import ee.taltech.cs.mbt.tdl.expression.model.parse_tree.AbsExpressionNode;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsOperatorNode<O extends AbsExpressionNode> extends AbsExpressionNode {
	public static final int ORD_FIRST_OPERAND = 0;
	public static final int ORD_SECOND_OPERAND = 1;

	public static final int ARITY_UNARY = 1;
	public static final int ARITY_BINARY = 2;

	private int arity;
	private List<O> operandNodes;

	public void setOperand(int ordinal, O operand) {
		if (ordinal >= this.operandNodes.size())
			throw new IllegalArgumentException("Attempted to set operand with out of bounds ordinal.");
		this.operandNodes.set(ordinal, operand);
	}

	public O getOperand(int ordinal) {
		if (ordinal >= this.operandNodes.size())
			throw new IllegalArgumentException("Attempted to retrieve operand with out of bounds ordinal.");
		return this.operandNodes.get(ordinal);
	}

	public AbsOperatorNode(int arity) {
		this.arity = arity;
		this.operandNodes = new ArrayList<>(arity);
	}
}
