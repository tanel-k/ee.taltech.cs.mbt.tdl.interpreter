package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.categories.logical.inequality;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic.internal.AbsBinaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.IExpressionVisitor;

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
public class LessThanExpression extends AbsBinaryExpression {
	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitLessThan(this);
	}
}
