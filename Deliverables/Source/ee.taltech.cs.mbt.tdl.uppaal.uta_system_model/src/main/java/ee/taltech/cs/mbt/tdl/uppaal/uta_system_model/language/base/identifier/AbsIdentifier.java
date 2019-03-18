package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier;

import java.util.Objects;

public abstract class AbsIdentifier {
	private String name;

	public AbsIdentifier() { }

	public AbsIdentifier(String name) {
		this.name = name;
	}

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
		if (!(obj instanceof AbsIdentifier))
			return false;
		AbsIdentifier other = (AbsIdentifier) obj;
		return Objects.equals(other.getName(), this.getName());
	}
}
