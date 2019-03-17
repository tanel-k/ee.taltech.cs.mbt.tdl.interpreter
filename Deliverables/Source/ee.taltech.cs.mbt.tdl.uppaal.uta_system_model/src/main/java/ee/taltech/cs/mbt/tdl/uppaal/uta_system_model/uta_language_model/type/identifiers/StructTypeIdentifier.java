package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.type.identifiers;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.declaration.field.FieldDeclaration;

import java.util.*;

public class StructTypeIdentifier extends AbsTypeIdentifier {
	public static final String ID = "Struct";

	private Set<FieldDeclaration> fieldDeclarations;

	public StructTypeIdentifier() {
		super(ID);
		this.fieldDeclarations = new LinkedHashSet<>();
	}

	public Set<FieldDeclaration> getFieldDeclarations() {
		return fieldDeclarations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getFieldDeclarations());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof StructTypeIdentifier))
			return false;
		StructTypeIdentifier other = (StructTypeIdentifier) obj;
		return Objects.equals(other.fieldDeclarations, this.fieldDeclarations);
	}
}
