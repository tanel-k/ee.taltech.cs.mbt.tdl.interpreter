package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal.AbsBinaryExprNode;

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
public class AssignmentExpression extends AbsBinaryExprNode {
	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitAssignmentExpr(this);
	}
}
