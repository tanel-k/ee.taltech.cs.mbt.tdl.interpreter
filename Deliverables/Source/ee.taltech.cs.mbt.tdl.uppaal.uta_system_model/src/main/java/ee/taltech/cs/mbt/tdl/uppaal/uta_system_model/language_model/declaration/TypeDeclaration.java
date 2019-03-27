package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IDeclarationVisitor;

import java.util.Objects;

/**
 * Adapter from UPPAAL documentation:<br/>
 * The <i>typedef</i> keyword is used to name types.<br/>
 * Syntax:<br/>
 * <pre>
 * TypeDecl     ::= 'typedef' Type ID ArrayDecl* (',' ID ArrayDecl*)* ';'
 * </pre>
 */
public class TypeDeclaration extends AbsDeclarationStatement {
	private Type type;
	private Identifier identifier;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}

	@Override
	public <T> T accept(IDeclarationVisitor<T> declarationVisitor) {
		return declarationVisitor.visitTypeDeclaration(this);
	}
}
