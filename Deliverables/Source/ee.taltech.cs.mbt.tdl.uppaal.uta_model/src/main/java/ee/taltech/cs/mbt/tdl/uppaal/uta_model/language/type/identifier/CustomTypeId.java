package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.ITypeIdentifierVisitor;

/**
 * Identifies the use of a named type.<br/>
 * Syntax fragment:<br/>
 * <pre>
 * TypeId        ::= ID | ...
 * </pre>
 */
public class CustomTypeId extends AbsTypeId {
	public static CustomTypeId of(Identifier identifier) {
		return new CustomTypeId()
				.setIdentifier(identifier);
	}

	private Identifier identifier;

	public Identifier getIdentifier() {
		return identifier;
	}

	public CustomTypeId setIdentifier(Identifier identifier) {
		this.identifier = identifier;
		return this;
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
