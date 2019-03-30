package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal.AbsUnaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;

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
public class FieldAccessExpression extends AbsUnaryExprNode {
	private Identifier identifier;

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitFieldAccessExpr(this);
	}

	/**
	 * @return The identifier of the field that is being accessed.
	 */
	public Identifier getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier The identifier of the field that is being accessed.
	 */
	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}

	@Override
	protected FieldAccessExpression topLevelClone() {
		FieldAccessExpression clone = new FieldAccessExpression();
		clone.setIdentifier(getIdentifier());
		return clone;
	}

	@Override
	public FieldAccessExpression deepClone() {
		return (FieldAccessExpression) super.deepClone();
	}
}
