package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IFieldDeclarationVisitor;

/**
 * Represents the declaration of a field in an UPPAAL struct.<br/>
 */
public class FieldDeclaration extends AbsFieldDeclaration {
	private Type type;
	private Identifier identifier;

	public Type getType() {
		return type;
	}

	public FieldDeclaration setType(Type type) {
		this.type = type;
		return this;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public FieldDeclaration setIdentifier(Identifier identifier) {
		this.identifier = identifier;
		return this;
	}

	@Override
	public FieldDeclaration deepClone() {
		FieldDeclaration clone = new FieldDeclaration();
		clone.identifier = identifier.deepClone();
		clone.type = type.deepClone();
		return clone;
	}

	@Override
	public <T> T accept(IFieldDeclarationVisitor<T> visitor) {
		return visitor.visitFieldDeclaration(this);
	}
}
