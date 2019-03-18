package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.field;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.identifier_types.AbsTypeIdentifier;

import java.util.*;

public class FieldDeclaration<FieldTypeIdentifier extends AbsTypeIdentifier> {
	private Type<FieldTypeIdentifier> type;
	private Set<Identifier> identifiers;

	public FieldDeclaration() {
		this.identifiers = new LinkedHashSet<>();
	}

	public Type<FieldTypeIdentifier> getType() {
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
