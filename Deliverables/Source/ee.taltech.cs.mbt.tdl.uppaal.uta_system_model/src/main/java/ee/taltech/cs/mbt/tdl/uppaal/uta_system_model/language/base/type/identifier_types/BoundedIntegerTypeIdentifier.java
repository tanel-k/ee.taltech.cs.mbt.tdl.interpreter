package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.identifier_types;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

import java.util.Objects;

public class BoundedIntegerTypeIdentifier extends AbsTypeIdentifier {
	public static final String ID = "IntegerWithBoundedDomain";

	private AbsExpression minBoundExpression;
	private AbsExpression maxBoundExpression;

	public BoundedIntegerTypeIdentifier() {
		super(ID);
	}

	public BoundedIntegerTypeIdentifier(AbsExpression minBoundExpression, AbsExpression maxBoundExpression) {
		this();
		this.minBoundExpression = minBoundExpression;
		this.maxBoundExpression = maxBoundExpression;
	}

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
	public int hashCode() {
		return Objects.hash(getId(), getMinBoundExpression(), getMaxBoundExpression());
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
