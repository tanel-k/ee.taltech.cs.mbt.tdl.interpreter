package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.identifier;

import java.util.Objects;

public class ParameterIdentifier {
	private boolean byReference;
	private Identifier identifier;

	public ParameterIdentifier() { }

	public ParameterIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}

	public boolean isByReference() {
		return byReference;
	}

	public void setByReference(boolean byReference) {
		this.byReference = byReference;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isByReference(), getIdentifier());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ParameterIdentifier))
			return false;
		ParameterIdentifier other = (ParameterIdentifier) obj;
		return Objects.equals(other.byReference, this.byReference)
			&& Objects.equals(other.identifier, this.identifier);
	}
}
