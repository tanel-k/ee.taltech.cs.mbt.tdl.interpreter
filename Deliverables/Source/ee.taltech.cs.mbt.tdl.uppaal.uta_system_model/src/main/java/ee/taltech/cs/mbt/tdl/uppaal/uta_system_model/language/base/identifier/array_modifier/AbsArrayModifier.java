package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.array_modifier;

import java.util.Objects;

public abstract class AbsArrayModifier<SizeSpecifier> {
	private SizeSpecifier sizeSpecifier;

	public SizeSpecifier getSizeSpecifier() {
		return sizeSpecifier;
	}

	public void setSizeSpecifier(SizeSpecifier sizeSpecifier) {
		this.sizeSpecifier = sizeSpecifier;
	}

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
