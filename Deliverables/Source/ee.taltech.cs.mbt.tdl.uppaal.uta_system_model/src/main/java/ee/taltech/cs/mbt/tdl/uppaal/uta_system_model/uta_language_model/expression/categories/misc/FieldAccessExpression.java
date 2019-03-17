package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.categories.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.generic.internal.AbsUnaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.identifier.Identifier;

import java.util.Objects;

public class FieldAccessExpression extends AbsUnaryExpression {
	private Identifier fieldIdentifier;

	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}

	public Identifier getFieldIdentifier() {
		return fieldIdentifier;
	}

	public void setFieldIdentifier(Identifier fieldIdentifier) {
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
