package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.type;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.IDeclarationVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.type.identifier.AbsTypeId;

import java.util.Objects;

/**
 * Adapter from UPPAAL documentation:<br/>
 * The <i>typedef</i> keyword is used to name types.<br/>
 * Syntax:<br/>
 * <pre>
 * TypeDecl     ::= 'typedef' Type ID ArrayDecl* (',' ID ArrayDecl*)* ';'
 * </pre>
 * @param <TypeIdentifier> Base type identifier for the declared type (@see {@link AbsTypeId}).
 */
public class TypeDeclaration<TypeIdentifier extends AbsTypeId> extends AbsDeclarationStatement {
	private Type<TypeIdentifier> type;
	private IdentifierName identifierName;

	public Type<TypeIdentifier> getType() {
		return type;
	}

	public void setType(Type<TypeIdentifier> type) {
		this.type = type;
	}

	public IdentifierName getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(IdentifierName identifierName) {
		this.identifierName = identifierName;
	}

	@Override
	public <T> T accept(IDeclarationVisitor<T> declarationVisitor) {
		return declarationVisitor.visitTypeDeclaration(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getType(), getIdentifierName());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof TypeDeclaration))
			return false;
		TypeDeclaration other = (TypeDeclaration) obj;
		return Objects.equals(other.identifierName, this.identifierName)
			&& Objects.equals(other.type, this.type);
	}
}