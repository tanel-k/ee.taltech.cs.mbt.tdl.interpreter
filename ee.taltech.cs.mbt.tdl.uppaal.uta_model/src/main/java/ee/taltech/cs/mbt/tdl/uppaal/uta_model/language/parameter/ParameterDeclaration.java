package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.parameter;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.Type;

/**
 * Represents the declaration of a parameter in an UPPAAL function or template.<br/>
 */
public class ParameterDeclaration implements IDeepCloneable<ParameterDeclaration> {
	private Type type;
	private Identifier identifier;

	public Type getType() {
		return type;
	}

	public ParameterDeclaration setType(Type type) {
		this.type = type;
		return this;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public ParameterDeclaration setIdentifier(Identifier identifier) {
		this.identifier = identifier;
		return this;
	}

	@Override
	public ParameterDeclaration deepClone() {
		ParameterDeclaration clone = new ParameterDeclaration();
		clone.type = type.deepClone();
		clone.identifier = identifier.deepClone();
		return clone;
	}
}
