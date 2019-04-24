package ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.modifier;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;

import java.math.BigInteger;
import java.util.Objects;

public class Bound implements IDeepCloneable<Bound> {
	private EBoundType boundType;
	private BigInteger boundValue;

	public EBoundType getBoundType() {
		return boundType;
	}

	public void setBoundType(EBoundType boundType) {
		this.boundType = boundType;
	}

	public BigInteger getBoundValue() {
		return boundValue;
	}

	public void setBoundValue(BigInteger boundValue) {
		if (boundValue == null)
			throw new IllegalArgumentException("Bound value cannot be empty.");
		if (BigInteger.ZERO.compareTo(boundValue) > 0)
			throw new IllegalArgumentException("Bound value must be >= 0.");
		this.boundValue = boundValue;
	}

	@Override
	public Bound deepClone() {
		Bound clone = new Bound();
		clone.setBoundValue(getBoundValue());
		clone.setBoundType(getBoundType());
		return clone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(boundType, boundValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Bound))
			return false;
		Bound other = (Bound) obj;
		return other.boundType == this.boundType
				&& Objects.equals(other.boundValue, this.boundValue);
	}
}
