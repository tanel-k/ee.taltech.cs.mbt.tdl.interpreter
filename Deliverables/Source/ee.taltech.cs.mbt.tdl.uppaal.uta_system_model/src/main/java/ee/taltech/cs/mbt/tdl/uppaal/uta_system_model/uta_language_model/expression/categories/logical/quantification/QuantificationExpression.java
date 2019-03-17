package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.categories.logical.quantification;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.generic.internal.AbsUnaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.type.Type;

import java.util.Objects;

public class QuantificationExpression extends AbsUnaryExpression {
	public static enum QuantificationType { UNIVERSAL, EXISTENTIAL };

	private QuantificationType quantificationType;
	private Type iterationVariableType;
	private Identifier iterationVariable;

	public QuantificationExpression(QuantificationType quantificationType) {
		this.quantificationType = quantificationType;
	}

	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}

	public QuantificationType getQuantificationType() {
		return quantificationType;
	}

	public Identifier getIterationVariable() {
		return iterationVariable;
	}

	public void setIterationVariableType(Type iterationVariableType) {
		this.iterationVariableType = iterationVariableType;
		invalidateSubtreeHash();
	}

	public void setIterationVariable(Identifier iterationVariable) {
		this.iterationVariable = iterationVariable;
		invalidateSubtreeHash();
	}

	public Type getIterationVariableType() {
		return iterationVariableType;
	}

	@Override
	protected int getLocalHash() {
		return Objects.hash(
			getQuantificationType(),
			getIterationVariable(),
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
				&& Objects.equals(other.iterationVariable, this.iterationVariable)
				&& Objects.equals(other.iterationVariableType, this.iterationVariableType);
		}
		return false;
	}
}
