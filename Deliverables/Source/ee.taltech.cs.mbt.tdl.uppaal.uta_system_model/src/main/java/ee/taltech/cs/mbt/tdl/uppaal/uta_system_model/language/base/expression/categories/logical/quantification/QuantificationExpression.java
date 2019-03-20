package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.quantification;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsUnaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.traversal.IExpressionVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;

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
 * @param <VarTypeIdentifier> See {@link AbsTypeIdentifier}.
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
public class QuantificationExpression<VarTypeIdentifier extends AbsTypeIdentifier> extends AbsUnaryExpression
{
	private EQuantificationType quantificationType;
	private Type<VarTypeIdentifier> iterationVariableType;
	private IdentifierName identifierName;

	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}

	@Override
	public void accept(IExpressionVisitor visitor) {
		visitor.visitQuantification(this);
	}

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
	public IdentifierName getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(IdentifierName identifierName) {
		this.identifierName = identifierName;
		invalidateSubtreeHash();
	}

	/**
	 * @return The type (domain) we quantify over.
	 */
	public Type<VarTypeIdentifier> getIterationVariableType() {
		return iterationVariableType;
	}

	public void setIterationVariableType(Type<VarTypeIdentifier> iterationVariableType) {
		this.iterationVariableType = iterationVariableType;
		invalidateSubtreeHash();
	}

	@Override
	protected int getLocalHash() {
		return Objects.hash(
			getQuantificationType(),
			getIdentifierName(),
			getIterationVariableType()
		);
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			if (obj == this)
				return true;
			if (!(obj instanceof QuantificationExpression))
				return false;
			QuantificationExpression other = (QuantificationExpression) obj;
			return Objects.equals(other.quantificationType, this.quantificationType)
				&& Objects.equals(other.identifierName, this.identifierName)
				&& Objects.equals(other.iterationVariableType, this.iterationVariableType);
		}
		return false;
	}
}
