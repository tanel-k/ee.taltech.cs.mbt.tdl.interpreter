package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.type;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IDeclarationVisitor;

/**
 * Adapter from UPPAAL documentation:<br/>
 * The <i>typedef</i> keyword is used to name types.<br/>
 * Syntax:<br/>
 * <pre>
 * TypeDecl     ::= 'typedef' Type ID ArrayDecl* (',' ID ArrayDecl*)* ';'
 * </pre>
 * Note that the language allows type declarations to be grouped.<br/>
 * This class represents a single non-grouped type declaration.
 */
public class TypeDeclaration extends AbsTypeDeclaration {
	private Type type;
	private Identifier identifier;

	public Type getType() {
		return type;
	}

	public TypeDeclaration setType(Type type) {
		this.type = type;
		return this;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public TypeDeclaration setIdentifier(Identifier identifier) {
		this.identifier = identifier;
		return this;
	}

	@Override
	public <T> T accept(IDeclarationVisitor<T> visitor) {
		return visitor.visitTypeDeclaration(this);
	}

	@Override
	public TypeDeclaration deepClone() {
		TypeDeclaration clone = new TypeDeclaration();
		clone.type = type.deepClone();
		clone.identifier = identifier.deepClone();
		return clone;
	}
}
