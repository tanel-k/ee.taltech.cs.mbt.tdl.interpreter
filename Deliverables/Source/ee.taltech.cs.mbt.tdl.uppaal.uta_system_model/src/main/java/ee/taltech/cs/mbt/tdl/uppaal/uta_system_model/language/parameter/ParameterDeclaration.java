package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.parameter;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.identifier.AbsTypeId;

/**
 * Represents the declaration of a parameter in an UPPAAL function or template.<br/>
 * @param <ParamTypeIdentifier> See {@link AbsTypeId}, {@link Type}.
 */
public class ParameterDeclaration<ParamTypeIdentifier extends AbsTypeId> {
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
