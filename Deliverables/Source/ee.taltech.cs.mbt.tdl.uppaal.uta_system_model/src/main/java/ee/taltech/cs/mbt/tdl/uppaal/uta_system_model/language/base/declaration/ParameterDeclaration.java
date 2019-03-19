package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.ParameterIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;

public class ParameterDeclaration<ParamTypeIdentifier extends AbsTypeIdentifier> {
	private Type<ParamTypeIdentifier> type;
	private ParameterIdentifier identifier;

	public Type<ParamTypeIdentifier> getType() {
		return type;
	}

	public void setType(Type<ParamTypeIdentifier> type) {
		this.type = type;
	}

	public ParameterIdentifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(ParameterIdentifier identifier) {
		this.identifier = identifier;
	}
}
