package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;

import java.util.Objects;

public abstract class AbsOperatorNode<
		OperandType extends AbsExpressionNode,
		ChildContainerType extends ChildContainer<OperandType>
		>
		extends AbsExpressionNode {
	private ChildContainerType childContainer;

	protected AbsOperatorNode(ChildContainerType childContainer) {
		this.childContainer = childContainer;
		childContainer.setOwner(this);
	}

	public ChildContainerType getChildContainer() {
		return childContainer;
	}

	protected AbsOperatorNode<OperandType, ChildContainerType> setChildContainer(ChildContainerType childContainer) {
		this.childContainer = childContainer;
		return this;
	}

	@Override
	public int getHeight() {
		return getChildContainer().getHeight();
	}

	@Override
	public abstract AbsOperatorNode<OperandType, ChildContainerType> deepClone();

	@Override
	public int hashCode() {
		return Objects.hash(getClass(), getHeight(), getChildContainer());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof AbsOperatorNode))
			return false;
		AbsOperatorNode other = (AbsOperatorNode) obj;
		return Objects.equals(this.childContainer, other.childContainer);
	}
}
