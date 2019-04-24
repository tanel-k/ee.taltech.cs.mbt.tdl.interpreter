package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;

import java.util.Iterator;
import java.util.Objects;

public abstract class AbsInternalNode<
			ChildType extends AbsExpressionNode,
			ChildContainerType extends ChildContainer<ChildType>
		>
		extends AbsExpressionNode {
	private Boolean commutative;
	private ChildContainerType childContainer;

	protected AbsInternalNode(ChildContainerType childContainer, Boolean commutative) {
		this.childContainer = childContainer;
		this.commutative = commutative;
		childContainer.setSubtreeRoot(this);
		childContainer.setChildOrderRelevant(commutative != null && !commutative);
	}

	public ChildContainerType getChildContainer() {
		return childContainer;
	}

	protected AbsInternalNode<ChildType, ChildContainerType> setChildContainer(ChildContainerType childContainer) {
		this.childContainer = childContainer;
		return this;
	}

	public Boolean isCommutative() {
		return commutative;
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

	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder(getClass().getSimpleName())
			.append("(");
		Iterator<ChildType> childIter = getChildContainer().getListView().iterator();
		while (childIter.hasNext()) {
			buf.append(String.valueOf(childIter.next()));
			if (childIter.hasNext())
				buf.append(",");
		}
		return buf.append(")").toString();
	}
}
