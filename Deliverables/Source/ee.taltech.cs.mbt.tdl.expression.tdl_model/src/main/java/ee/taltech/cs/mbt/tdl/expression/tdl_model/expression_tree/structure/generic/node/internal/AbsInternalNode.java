package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;

import java.util.Objects;

public abstract class AbsInternalNode<
			ChildType extends AbsExpressionNode,
			ChildContainerType extends ChildContainer<ChildType>
		>
		extends AbsExpressionNode {
	private ChildContainerType childContainer;

	protected AbsInternalNode(ChildContainerType childContainer) {
		this.childContainer = childContainer;
		childContainer.setSubtreeRoot(this);
	}

	public ChildContainerType getChildContainer() {
		return childContainer;
	}

	protected AbsInternalNode<ChildType, ChildContainerType> setChildContainer(ChildContainerType childContainer) {
		this.childContainer = childContainer;
		return this;
	}

	@Override
	public int getHeight() {
		return getChildContainer().getSubtreeHeight();
	}

	@Override
	public abstract AbsInternalNode<ChildType, ChildContainerType> deepClone();

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
		if (obj.getClass().isInstance(this.getClass()))
			return false;
		AbsInternalNode other = (AbsInternalNode) obj;
		return Objects.equals(this.childContainer, other.childContainer);
	}
}
