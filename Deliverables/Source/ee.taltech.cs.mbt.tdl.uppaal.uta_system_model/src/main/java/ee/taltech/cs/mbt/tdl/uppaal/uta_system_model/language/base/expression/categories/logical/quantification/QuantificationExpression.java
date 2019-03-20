package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.quantification;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsUnaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.traversal.IExpressionVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;

import java.util.Objects;

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

	public EQuantificationType getQuantificationType() {
		return quantificationType;
	}

	public void setQuantificationType(EQuantificationType quantificationType) {
		this.quantificationType = quantificationType;
	}

	public IdentifierName getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(IdentifierName identifierName) {
		this.identifierName = identifierName;
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
