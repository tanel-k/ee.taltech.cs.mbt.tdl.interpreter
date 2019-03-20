package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.arithmetic;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsUnaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.traversal.IExpressionVisitor;

/**
 * Represents an additive inverse expression.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  '-' Expression
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
 *     <td>The expression that is being additively inverted.</td>
 *   </tr>
 * </table>
 */
public class AdditiveInverseExpression extends AbsUnaryExpression {
	@Override
	public Associativity getAssociativity() {
		return Associativity.RIGHT;
	}

	@Override
	public void accept(IExpressionVisitor visitor) {
		visitor.visitAdditiveInverse(this);
	}
}
