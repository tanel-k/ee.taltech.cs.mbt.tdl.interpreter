package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal.AbsUnaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;

/**
 * Represents a prefix decrement operation.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  '--' Expression
 *             | ...
 * </pre>
 * <table>
 *   <tr>
 *     <th>Method</th>
 *     <th>Return type description</th>
 *   </tr>
 *   <tr>
 *     <td>{@link #getChild()} ()}</td>
 *     <td>The decremented variable expression.</td>
 *   </tr>
 * </table>
 */
public class PrefixDecrementExpression extends AbsUnaryExprNode {
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitPrefixDecrementExpr(this);
	}

	@Override
	protected PrefixDecrementExpression topLevelClone() {
		return new PrefixDecrementExpression();
	}

	@Override
	public PrefixDecrementExpression deepClone() {
		return (PrefixDecrementExpression) super.deepClone();
	}
}
