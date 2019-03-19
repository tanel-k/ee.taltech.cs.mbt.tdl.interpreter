package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.array_modifier.AbsArrayModifier;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Identifier {
	private String name;
	private List<AbsArrayModifier> arrayModifiers;

	public Identifier() {
		this.arrayModifiers = new LinkedList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AbsArrayModifier> getArrayModifiers() {
		return arrayModifiers;
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
		if (!(obj instanceof Identifier))
			return false;
		Identifier other = (Identifier) obj;
		return Objects.equals(other.getName(), this.getName());
	}
}
