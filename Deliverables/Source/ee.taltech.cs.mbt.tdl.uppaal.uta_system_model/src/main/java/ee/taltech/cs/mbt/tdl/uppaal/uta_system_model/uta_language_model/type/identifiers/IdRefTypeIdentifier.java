package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.type.identifiers;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.identifier.Identifier;

import java.util.Objects;

public class IdRefTypeIdentifier extends AbsTypeIdentifier {
	public static final String ID = "IdentifierReference";

	public IdRefTypeIdentifier() {
		super(ID);
	}

	private Identifier identifier;

	public Identifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getIdentifier());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof IdRefTypeIdentifier))
			return false;
		IdRefTypeIdentifier other = (IdRefTypeIdentifier) obj;
		return Objects.equals(other.getIdentifier(), this.getIdentifier());
	}
}
