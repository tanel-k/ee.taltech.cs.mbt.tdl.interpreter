package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.categories.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.generic.leaf.AbsLeafExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.identifier.Identifier;

import java.util.Objects;

public class IdentifierRefExpression extends AbsLeafExpression {
	private Identifier identifier;

	public Identifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
		invalidateSubtreeHash();
	}

	@Override
	protected int getLocalHash() {
		return Objects.hash(getIdentifier());
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			if (obj == this)
				return true;
			if (!(obj instanceof IdentifierRefExpression))
				return false;
			IdentifierRefExpression other = (IdentifierRefExpression) obj;
			return Objects.equals(other.identifier, this.identifier);
		}
		return false;
	}
}
