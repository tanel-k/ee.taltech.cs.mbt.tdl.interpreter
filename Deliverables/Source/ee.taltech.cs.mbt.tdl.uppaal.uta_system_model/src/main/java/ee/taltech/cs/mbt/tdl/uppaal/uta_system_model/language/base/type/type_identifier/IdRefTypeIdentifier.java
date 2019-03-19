package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.traversal.ITypeIdentifierVisitor;

import java.util.Objects;

public class IdRefTypeIdentifier extends AbsTypeIdentifier {
	private Identifier identifier;

	public Identifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}

	@Override
	public void accept(ITypeIdentifierVisitor visitor) {
		visitor.visitIdRefTypeIdentifier(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getIdentifier());
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
