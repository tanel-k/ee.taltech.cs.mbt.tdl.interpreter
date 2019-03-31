package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.internal.AbsUnaryExprNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;

import java.util.Objects;

/**
 * Represents a quantifier expression.<br/>
 * <br/>
 * Adapted from UPPAAL documentation:
 * <i>
 * An expression `forall (ID : Type) Expr` evaluates to
 * `true` if `Expr` evaluates to true for all values of `ID` in `Type`.<br/>
 * An expression `exists (ID : Type) Expr` evaluates to
 * `true` if `Expr` evaluates to true for some value `ID` in `Type`.<br/>
 * The scope of `ID` is `Expr`.<br/>
 * `Type` must be a bounded integer or a scalar set.
 * </i>
 * <br/>
 * Syntax:<br/>
 * <pre>
 * Expression ::= ...
 *             |  'forall' '(' ID ':' Type ')' Expression
 *             |  'exists' '(' ID ':' Type ')' Expression
 * </pre>
 *
 * <table>
 *   <tr>
 *     <th>Method</th>
 *     <th>Return type description</th>
 *   </tr>
 *   <tr>
 *     <td>{@link #getChild()} ()}</td>
 *     <td>The quantified expression.</td>
 *   </tr>
 * </table>
 */
public class QuantificationExpression extends AbsUnaryExprNode {
	/** The type of a quantification expression. */
	public enum EQuantificationType {
		UNIVERSAL,
		EXISTENTIAL
	}

	private EQuantificationType quantificationType;
	private BaseType iterationVariableType;
	private Identifier variableName;

	/**
	 * @return The class of quantification.
	 */
	public EQuantificationType getQuantificationType() {
		return quantificationType;
	}

	public void setQuantificationType(EQuantificationType quantificationType) {
		this.quantificationType = quantificationType;
	}

	/**
	 * @return The identifier for the quantification variable.
	 */
	public Identifier getIdentifierName() {
		return variableName;
	}

	public void setIdentifierName(Identifier identifierName) {
		this.variableName = identifierName;
	}

	/**
	 * @return The type (domain) we quantify over.
	 */
	public BaseType getIterationVariableType() {
		return iterationVariableType;
	}

	public void setIterationVariableType(BaseType iterationVariableType) {
		this.iterationVariableType = iterationVariableType;
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitQuantificationExpr(this);
	}

	@Override
	protected QuantificationExpression topLevelClone() {
		QuantificationExpression clone = new QuantificationExpression();
		clone.setQuantificationType(getQuantificationType());
		clone.setIdentifierName(getIdentifierName());
		clone.setIterationVariableType(getIterationVariableType().deepClone());
		return clone;
	}

	@Override
	public QuantificationExpression deepClone() {
		return (QuantificationExpression) super.deepClone();
	}
}
