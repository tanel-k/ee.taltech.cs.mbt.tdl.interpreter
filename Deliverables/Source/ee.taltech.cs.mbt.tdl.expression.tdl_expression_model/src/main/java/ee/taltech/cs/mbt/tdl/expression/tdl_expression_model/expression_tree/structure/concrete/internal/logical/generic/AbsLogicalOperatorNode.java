package ee.taltech.cs.mbt.tdl.expression.tdl_expression_model.expression_tree.structure.concrete.internal.logical.generic;

import ee.taltech.cs.mbt.tdl.expression.tdl_expression_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_expression_model.expression_tree.structure.generic.node.internal.AbsOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_expression_model.expression_tree.structure.generic.node.internal.operands.OperandContainer;

public abstract class AbsLogicalOperatorNode<
		OperandType extends AbsExpressionNode,
		ContainerType extends OperandContainer<OperandType>
		>
		extends AbsOperatorNode<OperandType, ContainerType> {
	private boolean negated;

	public AbsLogicalOperatorNode(ContainerType operandContainer) {
		super(operandContainer);
	}

	public boolean isNegated() {
		return negated;
	}

	public void setNegated(boolean negated) {
		this.negated = negated;
	}
}
