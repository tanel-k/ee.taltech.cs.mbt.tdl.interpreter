package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.type;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;

import java.util.Objects;

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
	public void accept(IStatementVisitor visitor) {
		visitor.visitTypeDeclaration(this);
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
