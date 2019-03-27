package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.ITypeIdentifierVisitor;

import java.util.Objects;

/**
 * Identifies the use of a named type.<br/>
 * Syntax fragment:<br/>
 * <pre>
 * TypeId        ::= ID | ...
 * </pre>
 */
public class CustomTypeId extends AbsTypeId {
	private Identifier identifier;

	public Identifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}

	@Override
	public <T> T accept(ITypeIdentifierVisitor<T> visitor) {
		return visitor.visitIdRefTypeIdentifier(this);
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
		if (!(obj instanceof CustomTypeId))
			return false;
		CustomTypeId other = (CustomTypeId) obj;
		return Objects.equals(other.getIdentifier(), this.getIdentifier());
	}
}
