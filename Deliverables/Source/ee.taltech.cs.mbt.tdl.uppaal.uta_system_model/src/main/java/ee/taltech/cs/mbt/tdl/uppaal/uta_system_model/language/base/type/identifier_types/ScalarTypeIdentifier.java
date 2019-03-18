package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.identifier_types;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

import java.util.Objects;

public class ScalarTypeIdentifier extends AbsTypeIdentifier {
	public static final String ID = "Scalar";

	private AbsExpression sizeExpression;

	public ScalarTypeIdentifier() {
		super(ID);
	}

	public ScalarTypeIdentifier(AbsExpression sizeExpression) {
		this();
		this.sizeExpression = sizeExpression;
	}

	public AbsExpression getSizeExpression() {
		return this.sizeExpression;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getSizeExpression());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ScalarTypeIdentifier))
			return false;
		ScalarTypeIdentifier other = (ScalarTypeIdentifier) obj;
		return Objects.equals(other.sizeExpression, this.sizeExpression);
	}
}
