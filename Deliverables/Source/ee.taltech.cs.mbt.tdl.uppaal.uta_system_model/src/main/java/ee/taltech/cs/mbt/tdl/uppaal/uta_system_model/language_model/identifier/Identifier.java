package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier;

import java.util.Objects;

/**
 * Represents a valid identifier in UPPAAL.<br/>
 * Adapted from UPPAAL documentation:<br/>
 * <i>
 * The valid identifier names are described by the following regular expression:<br/>
 * [a-zA-Z_]([a-zA-Z0-9_])*
 * </i>
 */
public class Identifier {
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String name) {
		this.text = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(text);
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
		return Objects.equals(other.text, this.text);
	}
}
