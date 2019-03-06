package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.operator;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.AbsExpressionNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbsOperatorNode<O extends AbsExpressionNode> extends AbsExpressionNode implements IOperator<O> {
	private int arity;
	private List<O> operandNodes;

	public void setOperand(int ordinal, O operand) {
		if (ordinal >= arity)
			throw new IllegalArgumentException("Attempted to set operand with out of bounds ordinal.");
		this.operandNodes.set(ordinal, operand);
	}

	public O getOperand(int ordinal) {
		if (ordinal >= arity)
			throw new IllegalArgumentException("Attempted to retrieve operand with out of bounds ordinal.");
		return this.operandNodes.get(ordinal);
	}

	public List<O> getOperandNodes() {
		return Collections.unmodifiableList(operandNodes);
	}

	public AbsOperatorNode() {
		this.arity = getArity();
		this.operandNodes = new ArrayList<>(Collections.nCopies(this.arity, null));
	}
}
