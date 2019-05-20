package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.internal.AbsUnaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IExpressionVisitor;

/**
 * Represents an additive identity expression.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  '+' Expression
 *             | ...
 * </pre>
 * <br/>
 * <table>
 *   <tr>
 *     <th>Method</th>
 *     <th>Return type description</th>
 *   </tr>
 *   <tr>
 *     <td>{@link #getChild()} ()}</td>
 *     <td>The expression whose additive entity is being returned.</td>
 *   </tr>
 * </table>
 */
public class AdditiveIdentityExpression extends AbsUnaryExprNode {
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitAdditiveIdentityExpr(this);
	}

	@Override
	protected AdditiveIdentityExpression topLevelClone() {
		return new AdditiveIdentityExpression();
	}

	@Override
	public AdditiveIdentityExpression deepClone() {
		return (AdditiveIdentityExpression) super.deepClone();
	}
}
