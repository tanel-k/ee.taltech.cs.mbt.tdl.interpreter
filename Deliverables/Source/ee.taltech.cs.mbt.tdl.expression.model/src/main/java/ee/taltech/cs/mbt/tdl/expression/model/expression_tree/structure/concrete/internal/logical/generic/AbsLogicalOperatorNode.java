package ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.concrete.internal.logical.generic;

import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.AbsOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.model.expression_tree.structure.generic.node.internal.operands.OperandContainer;

public abstract class AbsLogicalOperatorNode<OperandType, ContainerType extends OperandContainer<OperandType>>
	extends AbsOperatorNode<ContainerType>
{
	private boolean negated;

	public boolean isNegated() {
		return negated;
	}

	public void setNegated(boolean negated) {
		this.negated = negated;
	}

	public AbsLogicalOperatorNode(ContainerType operandContainer) {
		super(operandContainer);
	}
}
