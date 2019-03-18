package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.array.AbsArrayDeclaration;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ArrayIdentifier extends AbsIdentifier {
	private List<AbsArrayDeclaration> arrayDeclarations;

	public ArrayIdentifier() {
		this.arrayDeclarations = new LinkedList<>();
	}

	public List<AbsArrayDeclaration> getArrayDeclarations() {
		return arrayDeclarations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getArrayDeclarations());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ArrayIdentifier))
			return false;
		ArrayIdentifier other = (ArrayIdentifier) obj;
		return Objects.equals(other.arrayDeclarations, this.arrayDeclarations);
	}
}
