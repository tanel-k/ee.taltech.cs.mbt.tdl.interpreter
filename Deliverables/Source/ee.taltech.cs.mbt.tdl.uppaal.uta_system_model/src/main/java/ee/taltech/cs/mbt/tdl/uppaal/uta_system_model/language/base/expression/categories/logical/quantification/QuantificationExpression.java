package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.quantification;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsUnaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.AbsIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.identifier_types.AbsTypeIdentifier;

import java.util.Objects;

public class QuantificationExpression<
		VarTypeIdentifier extends AbsTypeIdentifier, IdentifierType extends AbsIdentifier
	> extends AbsUnaryExpression
{
	public static enum QuantificationType { UNIVERSAL, EXISTENTIAL };

	private QuantificationType quantificationType;
	private Type<VarTypeIdentifier> iterationVariableType;
	private IdentifierType iterationVariableIdentifier;

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

	public IdentifierType getIterationVariableIdentifier() {
		return iterationVariableIdentifier;
	}

	public void setIterationVariableIdentifier(IdentifierType iterationVariableIdentifier) {
		this.iterationVariableIdentifier = iterationVariableIdentifier;
		invalidateSubtreeHash();
	}

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
			getIterationVariableIdentifier(),
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
				&& Objects.equals(other.iterationVariableIdentifier, this.iterationVariableIdentifier)
				&& Objects.equals(other.iterationVariableType, this.iterationVariableType);
		}
		return false;
	}
}
