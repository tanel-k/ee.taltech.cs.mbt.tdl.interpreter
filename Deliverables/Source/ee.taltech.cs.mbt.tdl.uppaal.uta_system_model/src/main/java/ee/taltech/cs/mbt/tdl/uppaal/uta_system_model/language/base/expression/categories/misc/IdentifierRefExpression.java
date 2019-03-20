package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.leaf.AbsLeafExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.traversal.IExpressionVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;

import java.util.Objects;

/**
 * Represents a simple identifier reference expression.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ID
 *             |  ...
 * </pre>
 */
public class IdentifierRefExpression extends AbsLeafExpression {
	private IdentifierName identifierName;

	/**
	 * @return The referenced identifier.
	 */
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
			return Objects.equals(other.identifierName, this.identifierName);
		}
		return false;
	}
}
