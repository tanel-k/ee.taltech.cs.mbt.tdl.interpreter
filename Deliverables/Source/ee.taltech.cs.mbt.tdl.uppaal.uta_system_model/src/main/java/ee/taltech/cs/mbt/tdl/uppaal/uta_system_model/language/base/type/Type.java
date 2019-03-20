package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.array_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Type<TypeIdentifier extends AbsTypeIdentifier> {
	private ETypePrefix typePrefix = ETypePrefix.NONE;
	private boolean referenceType = false;
	private TypeIdentifier typeIdentifier;
	private List<AbsArrayModifier> arrayModifiers = new LinkedList<>();

	public Type() { }

	public Type<TypeIdentifier> clone() {
		Type<TypeIdentifier> type = new Type<>();
		type.typePrefix = this.typePrefix;
		type.typeIdentifier = this.typeIdentifier;
		type.referenceType = this.referenceType;
		type.arrayModifiers.addAll(this.arrayModifiers);
		return type;
	}

	public boolean isReferenceType() {
		return referenceType;
	}

	public void setReferenceType(boolean referenceType) {
		this.referenceType = referenceType;
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

	public List<AbsArrayModifier> getArrayModifiers() {
		return arrayModifiers;
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
