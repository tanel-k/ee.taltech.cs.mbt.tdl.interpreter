package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.traversal.ITypeIdentifierVisitor;

import java.util.Objects;

public class ScalarTypeIdentifier extends AbsTypeIdentifier {
	private AbsExpression sizeExpression;

	public AbsExpression getSizeExpression() {
		return this.sizeExpression;
	}

	public void setSizeExpression(AbsExpression sizeExpression) {
		this.sizeExpression = sizeExpression;
	}

	@Override
	public void accept(ITypeIdentifierVisitor visitor) {
		visitor.visitScalarTypeIdentifier(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getSizeExpression());
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
