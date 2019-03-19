package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class FieldDeclaration<FieldTypeIdentifier extends AbsTypeIdentifier> implements Iterable<Identifier> {
	private Type<FieldTypeIdentifier> type;
	private Set<Identifier> identifiers = new LinkedHashSet<>();

	public Type<FieldTypeIdentifier> getType() {
		return type;
	}

	public Set<Identifier> getIdentifiers() {
		return identifiers;
	}

	@Override
	public Iterator<Identifier> iterator() {
		return identifiers.iterator();
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
