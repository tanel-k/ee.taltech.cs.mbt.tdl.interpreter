package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.internal.AbsBinaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IExpressionVisitor;

/**
 * Represents an equality test operation.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  Expression '==' Expression
 *             | ...
 * </pre>
 * <br/>
 * <table>
 *   <tr>
 *     <th>Method</th>
 *     <th>Return type description</th>
 *   </tr>
 *   <tr>
 *     <td>{@link #getLeftChild()}</td>
 *     <td>The left operand.</td>
 *   </tr>
 *   <tr>
 *     <td>{@link #getRightChild()}</td>
 *     <td>The right operand.</td>
 *   </tr>
 * </table>
 */
public class EqualityExpression extends AbsBinaryExprNode {
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitEqualityExpr(this);
	}

	@Override
	protected EqualityExpression topLevelClone() {
		return new EqualityExpression();
	}

	@Override
	public EqualityExpression deepClone() {
		return (EqualityExpression) super.deepClone();
	}
}
