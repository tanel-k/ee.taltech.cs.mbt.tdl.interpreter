package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.ITypeIdentifierVisitor;

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
	public CustomTypeId deepClone() {
		CustomTypeId clone = new CustomTypeId();
		clone.setIdentifier(getIdentifier());
		return clone;
	}

	@Override
	public <T> T accept(ITypeIdentifierVisitor<T> visitor) {
		return visitor.visitCustomTypeIdentifier(this);
	}
}
