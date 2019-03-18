package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.identifier_types.AbsTypeIdentifier;

import java.util.Objects;

public class Type<TypeIdentifier extends AbsTypeIdentifier> {
	private ETypePrefix typePrefix = ETypePrefix.NONE;
	private TypeIdentifier typeIdentifier;

	public Type(ETypePrefix typePrefix, TypeIdentifier typeIdentifier) {
		this.typePrefix = typePrefix;
		this.typeIdentifier = typeIdentifier;
	}

	public Type(TypeIdentifier typeIdentifier) {
		this(ETypePrefix.NONE, typeIdentifier);
	}

	public ETypePrefix getTypePrefix() {
		return typePrefix;
	}

	public void setTypePrefix(ETypePrefix typePrefix) {
		this.typePrefix = typePrefix;
	}

	public TypeIdentifier getTypeIdentifier() {
		return typeIdentifier;
	}

	public void setTypeIdentifier(TypeIdentifier typeIdentifier) {
		this.typeIdentifier = typeIdentifier;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getTypePrefix(), getTypeIdentifier());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Type))
			return false;
		Type other = (Type) obj;
		return Objects.equals(other.typePrefix, this.typePrefix)
			&& Objects.equals(other.typeIdentifier, this.typeIdentifier);
	}
}
