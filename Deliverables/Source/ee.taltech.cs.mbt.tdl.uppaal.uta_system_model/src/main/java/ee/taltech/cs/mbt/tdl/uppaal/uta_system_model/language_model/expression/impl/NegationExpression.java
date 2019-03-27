package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal.AbsUnaryExprNode;

/**
 * Represents a logical negation operation.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  '!' Expression
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
 *     <td>The negated expression.</td>
 *   </tr>
 * </table>
 */
public class NegationExpression extends AbsUnaryExprNode {
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitNegationExpr(this);
	}
}
