package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.internal.AbsUnaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IExpressionVisitor;

/**
 * Represents a postfix increment operation.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  Expression '++'
 *             | ...
 * </pre>
 * <table>
 *   <tr>
 *     <th>Method</th>
 *     <th>Return type description</th>
 *   </tr>
 *   <tr>
 *     <td>{@link #getChild()} ()}</td>
 *     <td>The incremented variable expression.</td>
 *   </tr>
 * </table>
 */
public class PostfixIncrementExpression extends AbsUnaryExprNode {
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitPostfixIncrementExpr(this);
	}

	@Override
	protected PostfixIncrementExpression topLevelClone() {
		return new PostfixIncrementExpression();
	}

	@Override
	public PostfixIncrementExpression deepClone() {
		return (PostfixIncrementExpression) super.deepClone();
	}
}
