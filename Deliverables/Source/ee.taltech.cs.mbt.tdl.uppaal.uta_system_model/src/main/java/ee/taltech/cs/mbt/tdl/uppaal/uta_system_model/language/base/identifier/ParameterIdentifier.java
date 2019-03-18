package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.array.AbsArrayDeclaration;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ParameterIdentifier<IdentifierType extends AbsIdentifier> {
	private boolean byReference;
	private IdentifierType identifier;
	private List<AbsArrayDeclaration> arrayDeclarations;

	public ParameterIdentifier() {
		this.arrayDeclarations = new LinkedList<>();
	}

	public boolean isByReference() {
		return byReference;
	}

	public void setByReference(boolean byReference) {
		this.byReference = byReference;
	}

	public IdentifierType getIdentifier() {
		return identifier;
	}

	public void setIdentifier(IdentifierType identifier) {
		this.identifier = identifier;
	}

	public List<AbsArrayDeclaration> getArrayDeclarations() {
		return arrayDeclarations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isByReference(), getIdentifier(), getArrayDeclarations());
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
			&& Objects.equals(other.identifier, this.identifier)
			&& Objects.equals(other.arrayDeclarations, this.arrayDeclarations);
	}
}
