package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.type.identifiers;

import java.util.Objects;

public abstract class AbsTypeIdentifier {
	private String id;

	public String getId() {
		return id;
	}

	public AbsTypeIdentifier(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof  AbsTypeIdentifier))
			return false;
		AbsTypeIdentifier other = (AbsTypeIdentifier) obj;
		return Objects.equals(other.id, this.id);
	}
}
