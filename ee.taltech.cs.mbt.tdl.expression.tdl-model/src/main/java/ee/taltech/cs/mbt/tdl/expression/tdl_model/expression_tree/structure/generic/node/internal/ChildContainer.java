package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal;

import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class ChildContainer<ChildType extends AbsExpressionNode> {
	public static final int ARITY_UNARY = 1;
	public static final int ARITY_BINARY = 2;

	public static final int ORDINAL_FIRST = 0;
	public static final int ORDINAL_SECOND = 1;

	public final int arity;

	private boolean childOrderRelevant;
	private int subtreeHeight;
	private int hashCode;
	private boolean localCacheValid;

	private AbsExpressionNode subtreeRoot;
	private ArrayList<ChildType> childList;

	protected void ensureLocalCacheValid() {
		if (!isLocalCacheValid()) {
			this.subtreeHeight = 1 + (
					getStreamView()
							.filter(Objects::nonNull)
							.mapToInt(AbsExpressionNode::getHeight)
							.max()
							.orElse(0)
			);
			this.hashCode = Objects.hash(this.arity, this.childList);
			setLocalCacheValid(true);
		}
	}

	protected void invalidateLocalCache() {
		setLocalCacheValid(false);
	}

	public ChildContainer(int arity) {
		this.arity = arity;
		this.childList = new ArrayList<>(Collections.nCopies(this.arity, null));
	}

	public boolean isChildOrderRelevant() {
		return childOrderRelevant;
	}

	public ChildContainer<ChildType> setChildOrderRelevant(boolean childOrderRelevant) {
		this.childOrderRelevant = childOrderRelevant;
		return this;
	}

	protected boolean isLocalCacheValid() {
		return localCacheValid;
	}

	protected void setLocalCacheValid(boolean localCacheValid) {
		this.localCacheValid = localCacheValid;
	}

	public int getArity() {
		return arity;
	}

	protected AbsExpressionNode getSubtreeRoot() {
		return subtreeRoot;
	}

	protected ChildContainer<ChildType> setSubtreeRoot(AbsExpressionNode subtreeRoot) {
		this.subtreeRoot = subtreeRoot;
		return this;
	}

	public int getSubtreeHeight() {
		ensureLocalCacheValid();
		return this.subtreeHeight;
	}

	public Set<ChildType> getSetView() {
		return CollectionUtils.newSet(getListView());
	}

	public List<ChildType> getListView() {
		return Collections.unmodifiableList(this.childList);
	}

	public Stream<ChildType> getStreamView() {
		return getListView().stream();
	}

	public ChildType getChildNode(int ordinal) {
		if (ordinal < 0 || arity <= ordinal) {
			throw new IllegalArgumentException("Ordinal out of bounds.");
		}
		return this.childList.get(ordinal);
	}

	public ChildContainer<ChildType> setChildNode(int ordinal, ChildType operand) {
		if (ordinal < 0 || arity <= ordinal) {
			throw new IllegalArgumentException("Ordinal out of bounds.");
		}
		invalidateLocalCache();

		if (this.childList.get(ordinal) != null)
			this.childList.get(ordinal).setParentNode(null);

		operand.setParentNode(getSubtreeRoot());
		this.childList.set(ordinal, operand);
		return this;
	}

	public ChildContainer<ChildType> replaceChildNode(ChildType prevChild, ChildType newChild) {
		for (int i = 0; i < arity; i++) {
			ChildType childCandidate = getChildNode(i);
			if (childCandidate != null && prevChild.hashCode() == childCandidate.hashCode()) {
				if (prevChild.equals(childCandidate)) {
					setChildNode(i, newChild);
					break;
				}
			}
		}
		return this;
	}

	@Override
	public int hashCode() {
		ensureLocalCacheValid();
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof ChildContainer))
			return false;
		ChildContainer other = (ChildContainer) obj;
		return other.arity == this.arity
				&& (childOrderRelevant
						? this.childList.equals(other.childList)
						: this.getSetView().equals(other.getSetView())
				);
	}
}
