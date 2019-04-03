package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.IHasAssignmentCounterpart;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal.AbsBinaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;

/**
 * Represents a subtraction operation.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  Expression '-' Expression
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
public class SubtractionExpression extends AbsBinaryExprNode implements IHasAssignmentCounterpart {
	private boolean assignment;

	@Override
	public boolean isAssignment() {
		return assignment;
	}

	@Override
	public void setAssignment(boolean assignment) {
		this.assignment = assignment;
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitSubtractionExpr(this);
	}

	@Override
	protected SubtractionExpression topLevelClone() {
		SubtractionExpression clone = new SubtractionExpression();
		clone.setAssignment(isAssignment());
		return clone;
	}

	@Override
	public SubtractionExpression deepClone() {
		return (SubtractionExpression) super.deepClone();
	}
}
