package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.FieldDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.traversal.ITypeIdentifierVisitor;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class StructTypeIdentifier extends AbsTypeIdentifier {
	private Set<FieldDeclaration> fieldDeclarations = new LinkedHashSet<>();

	public Set<FieldDeclaration> getFieldDeclarations() {
		return fieldDeclarations;
	}

	@Override
	public void accept(ITypeIdentifierVisitor visitor) {
		visitor.visitStructTypeIdentifier(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getFieldDeclarations());
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
