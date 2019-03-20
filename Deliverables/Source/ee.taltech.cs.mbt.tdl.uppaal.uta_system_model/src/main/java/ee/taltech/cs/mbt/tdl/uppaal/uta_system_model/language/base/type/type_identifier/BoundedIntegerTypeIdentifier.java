package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.visitation.ITypeIdentifierVisitor;

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
public class BoundedIntegerTypeIdentifier extends AbsTypeIdentifier {
	private AbsExpression minBoundExpression;
	private AbsExpression maxBoundExpression;

	public AbsExpression getMinBoundExpression() {
		return minBoundExpression;
	}

	public void setMinBoundExpression(AbsExpression minBoundExpression) {
		this.minBoundExpression = minBoundExpression;
	}

	public AbsExpression getMaxBoundExpression() {
		return maxBoundExpression;
	}

	public void setMaxBoundExpression(AbsExpression maxBoundExpression) {
		this.maxBoundExpression = maxBoundExpression;
	}

	@Override
	public void accept(ITypeIdentifierVisitor visitor) {
		visitor.visitBoundedIntegerTypeIdentifier(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getMinBoundExpression(), getMaxBoundExpression());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BoundedIntegerTypeIdentifier))
			return false;
		BoundedIntegerTypeIdentifier other = (BoundedIntegerTypeIdentifier) obj;
		return Objects.equals(other.minBoundExpression, this.minBoundExpression)
			&& Objects.equals(other.maxBoundExpression, this.maxBoundExpression);
	}
}
