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
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
