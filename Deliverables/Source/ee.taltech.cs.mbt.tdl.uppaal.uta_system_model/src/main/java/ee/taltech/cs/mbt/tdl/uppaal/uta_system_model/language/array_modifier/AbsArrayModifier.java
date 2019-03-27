package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.array_modifier;

import java.util.Objects;

/**
 * Represents an array modifier which can be appended to
 * an parameter/field identifier in a declaration to mark the
 * latter parameter/field as an array type.
 * @param <SizeSpecifier> Type used to represent the size specified in the modifier.
 */
public abstract class AbsArrayModifier<SizeSpecifier> {
	private SizeSpecifier sizeSpecifier;

	public SizeSpecifier getSizeSpecifier() {
		return sizeSpecifier;
	}

	public void setSizeSpecifier(SizeSpecifier sizeSpecifier) {
		this.sizeSpecifier = sizeSpecifier;
	}

	public abstract <T> T accept(IArrayModifierVisitor<T> visitor);

	@Override
	public int hashCode() {
		return Objects.hash(getSizeSpecifier());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AbsArrayModifier))
			return false;
		AbsArrayModifier other = (AbsArrayModifier) obj;
		return Objects.equals(other.sizeSpecifier, this.sizeSpecifier);
	}
}
