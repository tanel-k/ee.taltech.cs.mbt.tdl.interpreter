package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.variable;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.identifier.AbsTypeId;

import java.util.Objects;

/**
 * Represents the declaration of a field in an UPPAAL struct.<br/>
 * @param <FieldTypeIdentifier> See {@link AbsTypeId} and {@link Type}.
 */
public class FieldDeclaration<FieldTypeIdentifier extends AbsTypeId> {
	private Type<FieldTypeIdentifier> type;
	private IdentifierName identifierName;

	public Type<FieldTypeIdentifier> getType() {
		return type;
	}

	public void setType(Type<FieldTypeIdentifier> type) {
		this.type = type;
	}

	public IdentifierName getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(IdentifierName identifierName) {
		this.identifierName = identifierName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getType(), getIdentifierName());
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
			&& Objects.equals(other.identifierName, this.identifierName);
	}
}
