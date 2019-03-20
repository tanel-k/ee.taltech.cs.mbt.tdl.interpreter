package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsUnaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.traversal.IExpressionVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;

import java.util.Objects;

public class FieldAccessExpression extends AbsUnaryExpression {
	private IdentifierName identifierName;

	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}

	@Override
	public void accept(IExpressionVisitor visitor) {
		visitor.visitFieldAccess(this);
	}

	public IdentifierName getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(IdentifierName identifierName) {
		this.identifierName = identifierName;
		invalidateSubtreeHash();
	}

	@Override
	protected int getLocalHash() {
		return Objects.hash(getIdentifierName());
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			if (obj == this)
				return true;
			if (!(obj instanceof FieldAccessExpression))
				return false;
			FieldAccessExpression other = (FieldAccessExpression) obj;
			return Objects.equals(other.identifierName, this.identifierName);
		}
		return false;
	}
}
