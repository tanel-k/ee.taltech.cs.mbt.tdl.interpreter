package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.categories.logical.phrasal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic.internal.AbsUnaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.IExpressionVisitor;

/**
 * Represents a logical negation operation (keyword).<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  'not' Expression
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
@Deprecated
public class PhrasalNegation extends AbsUnaryExpression {
	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitPhrasalNegation(this);
	}
}