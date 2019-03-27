package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.categories.binary;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic.IHasAssignmentCounterpart;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic.internal.AbsBinaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.IExpressionVisitor;

/**
 * Represents a bitwise conjunction operation.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  Expression '&amp;' Expression
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
public class BitwiseAndExpression extends AbsBinaryExpression implements IHasAssignmentCounterpart {
	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitBitwiseAnd(this);
	}
}
