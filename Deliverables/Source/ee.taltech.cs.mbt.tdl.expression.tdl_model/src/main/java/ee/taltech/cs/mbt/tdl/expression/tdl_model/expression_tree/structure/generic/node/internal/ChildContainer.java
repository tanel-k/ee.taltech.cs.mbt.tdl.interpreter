package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.internal;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class ChildContainer<OperandType extends AbsExpressionNode> {
	public static final int ARITY_UNARY = 1;
	public static final int ARITY_BINARY = 2;

	public static final int ORDINAL_FIRST = 0;
	public static final int ORDINAL_SECOND = 1;

	public final int arity;

	private int height;
	private int hashCode;
	private boolean localCacheValid;

	private AbsExpressionNode owner;
	private ArrayList<OperandType> operands;
	private LinkedHashMap<OperandType, Integer> ordinalCache;

	protected void validateLocalCache() {
		if (!isLocalCacheValid()) {
			this.hashCode = this.operands.hashCode();
			this.height = 1 + (getStreamView()
					.mapToInt(AbsExpressionNode::getHeight)
					.max()
					.orElse(0));
			setLocalCacheValid(true);
		}
	}

	protected void invalidateLocalCache() {
		setLocalCacheValid(false);
	}

	public ChildContainer(int arity) {
		this.arity = arity;
		this.ordinalCache = new LinkedHashMap<>(arity);
		this.operands = new ArrayList<>(Collections.nCopies(this.arity, null));
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

	AbsExpressionNode getOwner() {
		return owner;
	}

	ChildContainer<OperandType> setOwner(AbsExpressionNode owner) {
		this.owner = owner;
		return this;
	}

	public int getHeight() {
		validateLocalCache();
		return this.height;
	}

	public List<OperandType> getListView() {
		return Collections.unmodifiableList(this.operands);
	}

	public Stream<OperandType> getStreamView() {
		return getListView().stream();
	}

	public OperandType getOperand(int ordinal) {
		if (ordinal < 0 || arity <= ordinal) {
			throw new IllegalArgumentException("Ordinal out of bounds.");
		}
		return this.operands.get(ordinal);
	}

	public ChildContainer<OperandType> setOperand(int ordinal, OperandType operand) {
		if (ordinal < 0 || arity <= ordinal) {
			throw new IllegalArgumentException("Ordinal out of bounds.");
		}
		invalidateLocalCache();
		this.ordinalCache.remove(getOperand(ordinal));
		this.ordinalCache.put(operand, ordinal);
		this.operands.set(ordinal, operand);
		operand.setParentNode(getOwner());
		return this;
	}

	public ChildContainer<OperandType> replaceOperand(OperandType operand, OperandType otherOperand) {
		if (ordinalCache.containsKey(operand)) {
			return setOperand(ordinalCache.get(operand), otherOperand);
		}
		return this;
	}

	@Override
	public int hashCode() {
		validateLocalCache();
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
				&& Objects.equals(other.operands, this.operands);
	}
}
