package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.visitation.ITypeIdentifierVisitor;

import java.util.Objects;

/**
 * Identifies the use of a named type.<br/>
 * Syntax fragment:<br/>
 * <pre>
 * TypeId        ::= ID | ...
 * </pre>
 */
public class IdRefTypeIdentifier extends AbsTypeIdentifier {
	private IdentifierName identifierName;

	public IdentifierName getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(IdentifierName identifierName) {
		this.identifierName = identifierName;
	}

	@Override
	public void accept(ITypeIdentifierVisitor visitor) {
		visitor.visitIdRefTypeIdentifier(this);
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
		if (!(obj instanceof IdRefTypeIdentifier))
			return false;
		IdRefTypeIdentifier other = (IdRefTypeIdentifier) obj;
		return Objects.equals(other.getIdentifierName(), this.getIdentifierName());
	}
}
