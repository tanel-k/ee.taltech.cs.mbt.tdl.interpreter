package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.AbsIdentifier;

public class VariableInitialization<IdentifierType extends AbsIdentifier> {
	private IdentifierType identifier;
	private AbsExpression initializerExpression;

	public IdentifierType getIdentifier() {
		return identifier;
	}

	public void setIdentifier(IdentifierType identifier) {
		this.identifier = identifier;
	}

	public AbsExpression getInitializerExpression() {
		return initializerExpression;
	}

	public void setInitializerExpression(AbsExpression initializerExpression) {
		this.initializerExpression = initializerExpression;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
