package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.base;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.AbsIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.identifier_types.AbsTypeIdentifier;

import java.util.LinkedHashSet;
import java.util.Set;

public class TypeDeclaration<TypeIdentifier extends AbsTypeIdentifier> {
	private Type<TypeIdentifier> type;
	private Set<AbsIdentifier> identifiers;

	public TypeDeclaration() {
		this.identifiers = new LinkedHashSet<>();
	}

	public Type<TypeIdentifier> getType() {
		return type;
	}

	public void setType(Type<TypeIdentifier> type) {
		this.type = type;
	}

	public Set<AbsIdentifier> getIdentifiers() {
		return identifiers;
	}
}
