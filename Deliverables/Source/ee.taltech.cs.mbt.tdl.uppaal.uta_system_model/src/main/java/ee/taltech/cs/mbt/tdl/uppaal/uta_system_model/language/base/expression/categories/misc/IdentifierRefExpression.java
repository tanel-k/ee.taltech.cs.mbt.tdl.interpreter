package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.leaf.AbsLeafExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.traversal.IExpressionVisitor;

import java.util.Objects;

public class IdentifierRefExpression<IdentifierType> extends AbsLeafExpression {
	private IdentifierType identifier;

	public IdentifierType getIdentifier() {
		return identifier;
	}

	public void setIdentifier(IdentifierType identifier) {
		this.identifier = identifier;
		invalidateSubtreeHash();
	}

	@Override
	protected int getLocalHash() {
		return Objects.hash(getIdentifier());
	}

	@Override
	public void accept(IExpressionVisitor visitor) {
		visitor.visitIdentifierRef(this);
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
