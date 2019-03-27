package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.categories.logical;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic.internal.AbsUnaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.IExpressionVisitor;

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
public class NegationExpression extends AbsUnaryExpression {
	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitNegation(this);
	}
}
