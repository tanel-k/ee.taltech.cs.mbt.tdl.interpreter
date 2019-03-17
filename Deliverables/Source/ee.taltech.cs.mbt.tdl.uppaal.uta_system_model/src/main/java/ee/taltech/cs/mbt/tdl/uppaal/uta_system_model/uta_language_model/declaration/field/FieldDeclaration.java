package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.declaration.field;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.type.Type;

import java.util.*;

public class FieldDeclaration {
	private Type type;
	private Set<Identifier> identifiers;

	public FieldDeclaration() {
		this.identifiers = new LinkedHashSet<>();
	}

	public FieldDeclaration(Type type) {
		this();
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public Set<Identifier> getIdentifiers() {
		return identifiers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getType(), getIdentifiers());
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
			&& Objects.equals(other.identifiers, this.identifiers);
	}
}
