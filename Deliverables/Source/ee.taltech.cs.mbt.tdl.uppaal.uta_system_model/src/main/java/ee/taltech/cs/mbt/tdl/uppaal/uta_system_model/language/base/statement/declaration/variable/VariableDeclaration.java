package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable.initializer.AbsInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class VariableDeclaration<TypeIdentifier extends AbsTypeIdentifier> extends AbsDeclarationStatement {
	private Type<TypeIdentifier> type;
	private Map<Identifier, AbsInitializer> initializerMap = new LinkedHashMap<>();

	public Type<TypeIdentifier> getType() {
		return type;
	}

	public void setType(Type<TypeIdentifier> type) {
		this.type = type;
	}

	public Set<Identifier> getIdentifiers() {
		return initializerMap.keySet();
	}

	public Map<Identifier, AbsInitializer> getInitializerMap() {
		return initializerMap;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitVariableDeclaration(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getType(), getInitializerMap());
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
			&& Objects.equals(other.initializerMap, this.initializerMap);
	}
}