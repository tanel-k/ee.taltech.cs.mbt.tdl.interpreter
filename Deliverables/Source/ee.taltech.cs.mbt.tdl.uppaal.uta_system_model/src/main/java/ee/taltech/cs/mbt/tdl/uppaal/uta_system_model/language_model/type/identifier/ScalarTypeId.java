package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.ITypeIdentifierVisitor;

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
public class ScalarTypeId extends AbsTypeId {
	private AbsExpression sizeExpression;

	public AbsExpression getSizeExpression() {
		return this.sizeExpression;
	}

	public void setSizeExpression(AbsExpression sizeExpression) {
		this.sizeExpression = sizeExpression;
	}

	@Override
	public ScalarTypeId deepClone() {
		ScalarTypeId clone = new ScalarTypeId();
		clone.setSizeExpression(getSizeExpression().deepClone());
		return clone;
	}

	@Override
	public <T> T accept(ITypeIdentifierVisitor<T> visitor) {
		return visitor.visitScalarTypeIdentifier(this);
	}
}
