package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.identifier.IdentifierName;

import java.util.Objects;

/**
 * Identifies the use of a named type.<br/>
 * Syntax fragment:<br/>
 * <pre>
 * TypeId        ::= ID | ...
 * </pre>
 */
public class IdRefTypeId extends AbsTypeId {
	private IdentifierName identifierName;

	public IdentifierName getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(IdentifierName identifierName) {
		this.identifierName = identifierName;
	}

	@Override
	public <T> T accept(ITypeIdentifierVisitor<T> visitor) {
		return visitor.visitIdRefTypeIdentifier(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getIdentifierName());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof IdRefTypeId))
			return false;
		IdRefTypeId other = (IdRefTypeId) obj;
		return Objects.equals(other.getIdentifierName(), this.getIdentifierName());
	}
}
