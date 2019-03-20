package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.binary;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.IHasAssignmentCounterpart;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsBinaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.traversal.IExpressionVisitor;

/**
 * Represents a left shift operation.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  Expression '&lt;&lt;' Expression
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
 *     <td>The expression for the shifted value.</td>
 *   </tr>
 *   <tr>
 *     <td>{@link #getRightChild()}</td>
 *     <td>The expression for the shift amount.</td>
 *   </tr>
 * </table>
 */
public class LeftShiftExpression extends AbsBinaryExpression implements IHasAssignmentCounterpart {
	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}

	@Override
	public void accept(IExpressionVisitor visitor) {
		visitor.visitLeftShift(this);
	}
}
