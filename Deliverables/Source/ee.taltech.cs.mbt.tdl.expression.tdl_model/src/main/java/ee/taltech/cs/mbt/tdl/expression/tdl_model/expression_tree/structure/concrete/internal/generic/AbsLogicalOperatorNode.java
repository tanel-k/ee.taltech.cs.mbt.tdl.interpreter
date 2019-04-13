package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.AbsOperatorNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.operands.OperandContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ILogicalOperatorVisitor;

public abstract class AbsLogicalOperatorNode<
			OperandType extends AbsExpressionNode,
			ContainerType extends OperandContainer<OperandType>
		> extends AbsOperatorNode<OperandType, ContainerType> {
	private boolean negated;

	protected AbsLogicalOperatorNode(ContainerType operandContainer) {
		super(operandContainer);
	}

	@Override
	protected AbsLogicalOperatorNode<OperandType, ContainerType> setOperandContainer(ContainerType operandContainer) {
		return (AbsLogicalOperatorNode<OperandType, ContainerType>) super.setOperandContainer(operandContainer);
	}

	public boolean isNegated() {
		return negated;
	}

	public void setNegated(boolean negated) {
		this.negated = negated;
	}

	public abstract <T> T accept(ILogicalOperatorVisitor<T> visitor);

	@Override
	public abstract AbsLogicalOperatorNode<OperandType, ContainerType> deepClone();
}
