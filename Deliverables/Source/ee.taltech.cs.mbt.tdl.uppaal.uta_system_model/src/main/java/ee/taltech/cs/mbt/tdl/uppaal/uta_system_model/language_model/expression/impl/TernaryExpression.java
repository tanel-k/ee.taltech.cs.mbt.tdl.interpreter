package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal.AbsTernaryExprNode;

/**
 * Represents an UPPAAL ternary expression.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  Expression '?' Expression ':' Expression
 *             | ...
 * </pre>
 * We chose not to call this a ternary as that would clash
 * with the name of the parent class {@link AbsTernaryExprNode}.
 * <table>
 *   <tr>
 *     <th>Method</th>
 *     <th>Return type description</th>
 *   </tr>
 *   <tr>
 *     <td>{@link #getLeftChild()}</td>
 *     <td>The conditional expression.</td>
 *   </tr>
 *   <tr>
 *     <td>{@link #getMiddleChild()}</td>
 *     <td>Expression that's returned when the condition applies.</td>
 *   </tr>
 *   <tr>
 *     <td>{@link #getRightChild()}</td>
 *     <td>Expression that's returned when the condition fails.</td>
 *   </tr>
 * </table>
 */
public class TernaryExpression extends AbsTernaryExprNode {
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitTernaryExpr(this);
	}

	@Override
	protected TernaryExpression topLevelClone() {
		return new TernaryExpression();
	}

	@Override
	public TernaryExpression deepClone() {
		return (TernaryExpression) super.deepClone();
	}
}
