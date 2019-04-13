package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.ITypeIdentifierVisitor;

import java.util.Objects;

/**
 * Identifies a bounded integer Uppaal type.<br/>
 * Bounds are defined using expressions (@see {@link AbsExpression}).
 * Syntax fragment:<br/>
 * <pre>
 * TypeId        ::= ...
 *                |  'int' '[' Expression ',' Expression ']'
 *                | ...
 * </pre>
 */
public class BoundedIntegerTypeId extends AbsTypeId {
	public static BoundedIntegerTypeId of(AbsExpression minimumBound, AbsExpression maximumBound) {
		return new BoundedIntegerTypeId()
				.setMinimumBound(minimumBound)
				.setMaximumBound(maximumBound);
	}

	private AbsExpression minimumBound;
	private AbsExpression maximumBound;

	public AbsExpression getMinimumBound() {
		return minimumBound;
	}

	public BoundedIntegerTypeId setMinimumBound(AbsExpression minimumBound) {
		this.minimumBound = minimumBound;
		return this;
	}

	public AbsExpression getMaximumBound() {
		return maximumBound;
	}

	public BoundedIntegerTypeId setMaximumBound(AbsExpression maximumBound) {
		this.maximumBound = maximumBound;
		return this;
	}

	@Override
	public BoundedIntegerTypeId deepClone() {
		BoundedIntegerTypeId clone = new BoundedIntegerTypeId();
		clone.setMinimumBound(getMinimumBound().deepClone());
		clone.setMaximumBound(getMaximumBound().deepClone());
		return clone;
	}

	@Override
	public <T> T accept(ITypeIdentifierVisitor<T> visitor) {
		return visitor.visitBoundedIntegerTypeIdentifier(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getMinimumBound(), getMaximumBound());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BoundedIntegerTypeId))
			return false;
		BoundedIntegerTypeId other = (BoundedIntegerTypeId) obj;
		return Objects.equals(other.minimumBound, this.minimumBound)
			&& Objects.equals(other.maximumBound, this.maximumBound);
	}
}
