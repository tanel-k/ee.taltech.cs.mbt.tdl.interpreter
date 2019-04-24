package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;

import java.util.Objects;

/**
 * Represents a valid identifier in UPPAAL.<br/>
 * Adapted from UPPAAL documentation:<br/>
 * <i>
 * The valid identifier names are described by the following regular expression:<br/>
 * [a-zA-Z_]([a-zA-Z0-9_])*
 * </i>
 */
public class Identifier implements IDeepCloneable<Identifier> {
	public static Identifier of(String identifierString) {
		return new Identifier(identifierString);
	}

	private Identifier(String identifierString) {
		this.identifierString = identifierString;
	}

	private String identifierString;

	@Override
	public Identifier deepClone() {
		return this;
	}

	@Override
	public String toString() {
		return identifierString;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identifierString);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Identifier))
			return false;
		Identifier other = (Identifier) obj;
		return Objects.equals(other.identifierString, this.identifierString);
	}
}
