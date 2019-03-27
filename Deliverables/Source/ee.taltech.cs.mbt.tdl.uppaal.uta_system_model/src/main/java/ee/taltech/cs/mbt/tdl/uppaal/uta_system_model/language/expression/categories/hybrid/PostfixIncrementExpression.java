package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.categories.hybrid;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic.internal.AbsUnaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.IExpressionVisitor;

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
@Deprecated
public class PostfixIncrementExpression extends AbsUnaryExpression {
	@Override
	public Associativity getAssociativity() {
		return Associativity.RIGHT;
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitPostfixIncrement(this);
	}
}
