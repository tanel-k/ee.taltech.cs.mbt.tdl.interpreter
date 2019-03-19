package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier;

import java.util.Objects;

public class ParameterIdentifier extends Identifier {
	private boolean byReference;

	public boolean isByReference() {
		return byReference;
	}

	public void setByReference(boolean byReference) {
		this.byReference = byReference;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isByReference(), super.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			if (obj == this)
				return true;
			if (!(obj instanceof ParameterIdentifier))
				return false;
			ParameterIdentifier other = (ParameterIdentifier) obj;
			return other.byReference == this.byReference;
		}
		return false;
	}
}
