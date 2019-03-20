package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier;

import java.util.Objects;

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
