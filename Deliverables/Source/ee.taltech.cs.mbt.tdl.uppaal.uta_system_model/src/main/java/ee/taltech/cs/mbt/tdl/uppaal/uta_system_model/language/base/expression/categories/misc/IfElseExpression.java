package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsTernaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.visitation.IExpressionVisitor;

/**
 * Represents an UPPAAL ternary expression.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  Expression '?' Expression ':' Expression
 *             | ...
 * </pre>
 * We chose not to call this a ternary as that would clash
 * with the name of the parent class {@link AbsTernaryExpression}.
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
public class IfElseExpression extends AbsTernaryExpression {
	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitIfElse(this);
	}
}
