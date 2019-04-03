package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.parameter;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;

/**
 * Represents the declaration of a parameter in an UPPAAL function or template.<br/>
 */
public class ParameterDeclaration {
	private Type type;
	private Identifier identifier;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}
}
