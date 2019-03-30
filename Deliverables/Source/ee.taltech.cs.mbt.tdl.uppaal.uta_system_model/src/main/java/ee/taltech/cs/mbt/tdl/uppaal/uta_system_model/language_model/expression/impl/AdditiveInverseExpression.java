package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal.AbsUnaryExprNode;

/**
 * Represents an additive inverse expression.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  '-' Expression
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
 *     <td>The expression that is being additively inverted.</td>
 *   </tr>
 * </table>
 */
public class AdditiveInverseExpression extends AbsUnaryExprNode {
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitAdditiveInverseExpr(this);
	}

	@Override
	protected AbsUnaryExprNode topLevelClone() {
		return new AdditiveIdentityExpression();
	}

	@Override
	public AdditiveInverseExpression deepClone() {
		return (AdditiveInverseExpression) super.deepClone();
	}
}
