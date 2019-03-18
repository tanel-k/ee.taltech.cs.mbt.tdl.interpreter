package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.AbsIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.identifier_types.AbsTypeIdentifier;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class VariableDeclaration<TypeIdentifier extends AbsTypeIdentifier> extends AbsDeclarationStatement {
	private Type<TypeIdentifier> type;
	private Map<AbsIdentifier, AbsExpression> identifierMap;

	public VariableDeclaration() {
		this.identifierMap = new LinkedHashMap<>();
	}

	public Type<TypeIdentifier> getType() {
		return type;
	}

	public void setType(Type<TypeIdentifier> type) {
		this.type = type;
	}

	public Set<AbsIdentifier> getIdentifiers() {
		return identifierMap.keySet();
	}

	public Map<AbsIdentifier, AbsExpression> getIdentifierMap() {
		return identifierMap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getType(), getIdentifierMap());
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
			&& Objects.equals(other.identifierMap, this.identifierMap);
	}
}
