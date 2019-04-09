package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal.AbsUnaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents an UPPAAL structured type field access.<br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  Expression '.' ID
 *             | ...
 * </pre>
 * <table>
 *   <tr>
 *     <th>Method</th>
 *     <th>Return type description</th>
 *   </tr>
 *   <tr>
 *     <td>{@link #getChild()}</td>
 *     <td>The expression that gets called.</td>
 *   </tr>
 * </table>
 */
public class CallExpression extends AbsUnaryExprNode {
	private List<AbsExpression> arguments = new LinkedList<>();

	/**
	 * @return Arguments supplied in the call.
	 */
	public List<AbsExpression> getArguments() {
		return arguments;
	}

	public CallExpression addArgument(AbsExpression argument) {
		getArguments().add(argument);
		return this;
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitCallExpr(this);
	}

	@Override
	protected CallExpression topLevelClone() {
		CallExpression clone = new CallExpression();
		clone.getArguments().stream()
				.map(AbsExpression::deepClone)
				.forEachOrdered(clone.getArguments()::add);
		return clone;
	}

	@Override
	public CallExpression deepClone() {
		return (CallExpression) super.deepClone();
	}
}
