package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.AbsInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal.ChildContainer;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IBooleanNodeVisitor;

import java.util.Objects;

public abstract class AbsBooleanInternalNode<
			OperandType extends AbsExpressionNode,
			ContainerType extends ChildContainer<OperandType>
		> extends AbsInternalNode<OperandType, ContainerType> {
	private boolean negated;

	protected AbsBooleanInternalNode(ContainerType operandContainer, Boolean commutative) {
		super(operandContainer, commutative);
	}

	@Override
	protected AbsBooleanInternalNode<OperandType, ContainerType> setChildContainer(ContainerType childContainer) {
		return (AbsBooleanInternalNode<OperandType, ContainerType>) super.setChildContainer(childContainer);
	}

	public boolean isNegated() {
		return negated;
	}

	public void setNegated(boolean negated) {
		this.negated = negated;
	}

	public abstract <T> T accept(IBooleanNodeVisitor<T> visitor);

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.negated);
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return ((AbsBooleanInternalNode) obj).negated == this.negated;
		}
		return false;
	}

	@Override
	public abstract AbsBooleanInternalNode<OperandType, ContainerType> deepClone();
}
