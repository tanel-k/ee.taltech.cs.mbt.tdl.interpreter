package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class ChildContainer<OperandType extends AbsExpressionNode> {
	public static final int ARITY_NONARY = 0;
	public static final int ARITY_UNARY = 1;
	public static final int ARITY_BINARY = 2;

	public static final int ORDINAL_FIRST = 0;
	public static final int ORDINAL_SECOND = 1;

	public final int arity;

	private int subtreeHeight;
	private int hashCode;
	private boolean localCacheValid;

	private AbsExpressionNode subtreeRoot;
	private ArrayList<OperandType> operandList;
	private LinkedHashMap<OperandType, Integer> ordinalCache;

	protected void ensureLocalCacheValid() {
		if (!isLocalCacheValid()) {
			this.subtreeHeight = 1 + (
					getStreamView()
							.mapToInt(AbsExpressionNode::getHeight)
							.max()
							.orElse(0)
			);
			this.hashCode = Objects.hash(this.arity, this.operandList);
			setLocalCacheValid(true);
		}
	}

	protected void invalidateLocalCache() {
		setLocalCacheValid(false);
	}

	public ChildContainer(int arity) {
		this.arity = arity;
		this.ordinalCache = new LinkedHashMap<>(arity);
		this.operandList = new ArrayList<>(Collections.nCopies(this.arity, null));
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

	protected ChildContainer<OperandType> setSubtreeRoot(AbsExpressionNode subtreeRoot) {
		this.subtreeRoot = subtreeRoot;
		return this;
	}

	public int getSubtreeHeight() {
		ensureLocalCacheValid();
		return this.subtreeHeight;
	}

	public Set<OperandType> getSetView() {
		return Collections.unmodifiableSet(this.ordinalCache.keySet());
	}

	public List<OperandType> getListView() {
		return Collections.unmodifiableList(this.operandList);
	}

	public Stream<OperandType> getStreamView() {
		return getListView().stream();
	}

	public OperandType getChildNode(int ordinal) {
		if (ordinal < 0 || arity <= ordinal) {
			throw new IllegalArgumentException("Ordinal out of bounds.");
		}
		return this.operandList.get(ordinal);
	}

	public ChildContainer<OperandType> setChildNode(int ordinal, OperandType operand) {
		if (ordinal < 0 || arity <= ordinal) {
			throw new IllegalArgumentException("Ordinal out of bounds.");
		}
		invalidateLocalCache();

		OperandType prevChild = getChildNode(ordinal);
		if (prevChild != null) {
			this.ordinalCache.remove(getChildNode(ordinal));
		}

		this.ordinalCache.put(operand, ordinal);
		this.operandList.set(ordinal, operand);

		operand.setParentNode(getSubtreeRoot());
		return this;
	}

	public ChildContainer<OperandType> replaceChildNode(OperandType operand, OperandType otherOperand) {
		if (ordinalCache.containsKey(operand)) {
			return setChildNode(ordinalCache.get(operand), otherOperand);
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
		// Note that order should not matter.
		return other.arity == this.arity
				&& this.ordinalCache.keySet().equals(other.ordinalCache.keySet());
	}
}
