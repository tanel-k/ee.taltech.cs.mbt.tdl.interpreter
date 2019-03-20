package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsBinaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.traversal.IExpressionVisitor;

/**
 * Represents a basic UPPAAL assignment expression.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  Expression ':=' Expression
 *             |  Expression '=' Expression
 *             | ...
 * </pre>
 * <table>
 *   <tr>
 *     <th>Method</th>
 *     <th>Return type description</th>
 *   </tr>
 *   <tr>
 *     <td>{@link #getLeftChild()}</td>
 *     <td>The expression that will be assigned to.</td>
 *   </tr>
 *   <tr>
 *     <td>{@link #getRightChild()}</td>
 *     <td>The assigned value.</td>
 *   </tr>
 * </table>
 */
public class AssignmentExpression extends AbsBinaryExpression {
	@Override
	public Associativity getAssociativity() {
		return Associativity.RIGHT;
	}

	@Override
	public void accept(IExpressionVisitor visitor) {
		visitor.visitAssignment(this);
	}
}
