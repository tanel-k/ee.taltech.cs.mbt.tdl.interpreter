package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable.initializer.AbsInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;

import java.util.Objects;

public class VariableDeclaration<
		TypeIdentifier extends AbsTypeIdentifier, InitializerType extends AbsInitializer
	> extends AbsDeclarationStatement
{
	private Type<TypeIdentifier> type;
	private IdentifierName identifierName;
	private InitializerType initializer;

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

	public InitializerType getInitializer() {
		return initializer;
	}

	public void setInitializer(InitializerType initializer) {
		this.initializer = initializer;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitVariableDeclaration(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(
			getType(),
			getIdentifierName(),
			getInitializer()
		);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof VariableDeclaration))
			return false;
		VariableDeclaration other = (VariableDeclaration) obj;
		return Objects.equals(other.type, this.type)
			&& Objects.equals(other.identifierName, this.identifierName)
			&& Objects.equals(other.initializer, this.initializer);
	}
}
