package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsUnaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.AbsIdentifier;

import java.util.Objects;

public class FieldAccessExpression<IdentifierType extends AbsIdentifier> extends AbsUnaryExpression {
	private IdentifierType fieldIdentifier;

	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}

	public IdentifierType getFieldIdentifier() {
		return fieldIdentifier;
	}

	public void setFieldIdentifier(IdentifierType fieldIdentifier) {
		this.fieldIdentifier = fieldIdentifier;
		invalidateSubtreeHash();
	}

	@Override
	protected int getLocalHash() {
		return Objects.hash(getFieldIdentifier());
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			if (obj == this)
				return true;
			if (!(obj instanceof FieldAccessExpression))
				return false;
			FieldAccessExpression other = (FieldAccessExpression) obj;
			return Objects.equals(other.fieldIdentifier, this.fieldIdentifier);
		}
		return false;
	}
}
