package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.identifier;

import java.util.Objects;

/**
 * Represents a valid identifier in UPPAAL.<br/>
 * Adapted from UPPAAL documentation:<br/>
 * <i>
 * The valid identifier names are described by the following regular expression:<br/>
 * [a-zA-Z_]([a-zA-Z0-9_])*
 * </i>
 */
public class IdentifierName {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof IdentifierName))
			return false;
		IdentifierName other = (IdentifierName) obj;
		return Objects.equals(other.getName(), this.getName());
	}
}
