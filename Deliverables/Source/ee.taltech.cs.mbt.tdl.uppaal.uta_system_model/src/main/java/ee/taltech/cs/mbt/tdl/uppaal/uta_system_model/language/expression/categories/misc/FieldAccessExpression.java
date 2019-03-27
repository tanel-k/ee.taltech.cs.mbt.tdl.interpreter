package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.categories.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic.internal.AbsUnaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.IExpressionVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.identifier.IdentifierName;

import java.util.Objects;

/**
 * Represents an UPPAAL structured type field access.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  Expression '.' ID
 *             | ...
 * </pre>
 * <table>
 *   <tr>
 *     <th>Method</th>
 *     <th>Return type description</th>
 *   </tr>
 *   <tr>
 *     <td>{@link #getChild()} </td>
 *     <td>The structure whose fields are accessed.</td>
 *   </tr>
 * </table>
 */
public class FieldAccessExpression extends AbsUnaryExpression {
	private IdentifierName identifierName;

	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitFieldAccess(this);
	}

	/**
	 * @return The identifier of the field that is being accessed.
	 */
	public IdentifierName getIdentifierName() {
		return identifierName;
	}

	/**
	 * @param identifierName The identifier of the field that is being accessed.
	 */
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
