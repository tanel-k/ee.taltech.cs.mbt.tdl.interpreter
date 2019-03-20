package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.type;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.visitation.IDeclarationVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;

import java.util.Objects;

/**
 * Adapter from UPPAAL documentation:<br/>
 * The <i>typedef</i> keyword is used to name types.<br/>
 * Syntax:<br/>
 * <pre>
 * TypeDecl     ::= 'typedef' Type ID ArrayDecl* (',' ID ArrayDecl*)* ';'
 * </pre>
 * @param <TypeIdentifier> Base type identifier for the declared type (@see {@link AbsTypeIdentifier}).
 */
public class TypeDeclaration<TypeIdentifier extends AbsTypeIdentifier> extends AbsDeclarationStatement {
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
	public void accept(IDeclarationVisitor declarationVisitor) {
		declarationVisitor.visitTypeDeclaration(this);
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
