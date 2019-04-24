package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.internal.AbsUnaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IExpressionVisitor;

/**
 * Represents a postfix decrement operation.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  Expression '--'
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
public class PostfixDecrementExpression extends AbsUnaryExprNode {
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitPostfixDecrementExpr(this);
	}

	@Override
	protected PostfixDecrementExpression topLevelClone() {
		return new PostfixDecrementExpression();
	}

	@Override
	public PostfixDecrementExpression deepClone() {
		return (PostfixDecrementExpression) super.deepClone();
	}
}
