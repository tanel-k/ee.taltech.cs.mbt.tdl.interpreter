package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.variable_declaration;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;

/**
 * Represents the declaration of a parameter in an UPPAAL function or template.<br/>
 * @param <ParamTypeIdentifier> See {@link AbsTypeIdentifier}, {@link Type}.
 */
public class ParameterDeclaration<ParamTypeIdentifier extends AbsTypeIdentifier> {
	private Type<ParamTypeIdentifier> type;
	private IdentifierName identifierName;

	public Type<ParamTypeIdentifier> getType() {
		return type;
	}

	public void setType(Type<ParamTypeIdentifier> type) {
		this.type = type;
	}

	public IdentifierName getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(IdentifierName identifierName) {
		this.identifierName = identifierName;
	}
}
