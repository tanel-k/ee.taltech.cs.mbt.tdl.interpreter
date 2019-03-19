package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.base;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;

import java.util.LinkedHashSet;
import java.util.Set;

public class TypeDeclaration<TypeIdentifier extends AbsTypeIdentifier> extends AbsDeclarationStatement {
	private Type<TypeIdentifier> type;
	private Set<Identifier> identifiers = new LinkedHashSet<>();

	public Type<TypeIdentifier> getType() {
		return type;
	}

	public void setType(Type<TypeIdentifier> type) {
		this.type = type;
	}

	public Set<Identifier> getIdentifiers() {
		return identifiers;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitTypeDeclaration(this);
	}
}
