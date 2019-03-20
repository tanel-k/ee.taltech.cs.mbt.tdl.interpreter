package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.visitation.ITypeIdentifierVisitor;

import java.util.Objects;

/**
 * Identifies the UPPAAL scalar type.<br/>
 * Adapted from UPPAAL documentation:<br/>
 * <i>
 * Scalars in UPPAAL are integer-like elements with a limited number of operations:<br/>
 * assignment and identity testing.<br/>
 * Only scalars from the same scalar-set can be compared.<br/>
 * Scalars are unordered.<br/>
 * <br/>
 * Scalar sets are treated as types.<br/>
 * New scalar sets are constructed with the `scalar[n]` type constructor,<br/>
 * where `n` is an integer indicating the size of the scalar set.<br/>
 * `typedef` should be used to name a scalar set that can be used several times.<br/>
 * This is because scalars of different scalar sets are incomparable.<br/>
 * </i>
 * <br/>
 * Syntax fragment:<br/>
 * <pre>
 * TypeId        ::= ...
 *                |  ...
 *                |  'scalar' '[' Expression ']'
 *                |  ...
 * </pre>
 */
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
