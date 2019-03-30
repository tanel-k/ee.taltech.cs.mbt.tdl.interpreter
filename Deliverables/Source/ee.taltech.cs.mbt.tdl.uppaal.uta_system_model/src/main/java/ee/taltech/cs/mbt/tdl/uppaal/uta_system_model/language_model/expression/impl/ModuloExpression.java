package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl;

import com.sun.org.apache.xpath.internal.operations.Mod;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.IHasAssignmentCounterpart;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal.AbsBinaryExprNode;

/**
 * Represents a modulo operation.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  Expression '%' Expression
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
public class ModuloExpression extends AbsBinaryExprNode implements IHasAssignmentCounterpart {
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
		return visitor.visitModuloExpr(this);
	}

	@Override
	protected ModuloExpression topLevelClone() {
		ModuloExpression clone = new ModuloExpression();
		clone.setAssignment(isAssignment());
		return clone;
	}

	@Override
	public ModuloExpression deepClone() {
		return (ModuloExpression) super.deepClone();
	}
}
