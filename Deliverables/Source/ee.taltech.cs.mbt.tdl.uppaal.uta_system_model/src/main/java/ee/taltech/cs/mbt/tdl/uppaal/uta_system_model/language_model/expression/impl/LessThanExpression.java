package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal.AbsBinaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;

/**
 * Represents a less-than inequality.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  Expression '&lt;' Expression
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
public class LessThanExpression extends AbsBinaryExprNode {
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitLessThanExpr(this);
	}

	@Override
	protected LessThanExpression topLevelClone() {
		return new LessThanExpression();
	}

	@Override
	public LessThanExpression deepClone() {
		return (LessThanExpression) super.deepClone();
	}
}
