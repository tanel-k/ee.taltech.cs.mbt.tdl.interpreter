package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.struct;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;

import java.util.Objects;

/**
 * Represents the declaration of a field in an UPPAAL struct.<br/>
 */
public class FieldDeclaration {
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

	@Override
	public int hashCode() {
		return Objects.hash(getType(), getIdentifier());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FieldDeclaration))
			return false;
		FieldDeclaration other = (FieldDeclaration) obj;
		return Objects.equals(other.type, this.type)
			&& Objects.equals(other.identifier, this.identifier);
	}
}
