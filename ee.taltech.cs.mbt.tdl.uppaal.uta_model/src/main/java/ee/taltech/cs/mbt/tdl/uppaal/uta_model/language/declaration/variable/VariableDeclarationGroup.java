package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.initializer.AbsVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.BaseTypeExtensionMap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.BaseTypeExtensionMap.BaseTypeExtension;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.ITypeExtensionGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IDeclarationVisitor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VariableDeclarationGroup extends AbsVariableDeclaration implements ITypeExtensionGroup<AbsVariableDeclaration, VariableDeclaration> {
	private BaseTypeExtensionMap baseTypeExtensionMap = new BaseTypeExtensionMap();
	private Map<Identifier, AbsVariableInitializer> initializerMap = new HashMap<>();

	public BaseTypeExtensionMap getBaseTypeExtensionMap() {
		return baseTypeExtensionMap;
	}

	public Map<Identifier, AbsVariableInitializer> getInitializerMap() {
		return initializerMap;
	}

	@Override
	public VariableDeclaration mapToIndependent(BaseTypeExtension baseTypeExtension) {
		Identifier identifier = baseTypeExtension.getIdentifier();
		VariableDeclaration variableDeclaration = new VariableDeclaration();
		variableDeclaration.setInitializer(initializerMap.get(identifier));
		variableDeclaration.setType(baseTypeExtension.toDetachedInstance());
		variableDeclaration.setIdentifier(identifier);
		return variableDeclaration;
	}

	public VariableDeclarationGroup putItem(
			Identifier identifier,
			AbsVariableInitializer initializer,
			boolean referenceType,
			Collection<AbsArrayModifier> arrayModifiers
	) {
		putItem(identifier, referenceType, arrayModifiers);
		getInitializerMap().put(identifier, initializer);
		return this;
	}

	public void removeItem(Identifier identifier) {
		getBaseTypeExtensionMap().remove(identifier);
		getInitializerMap().remove(identifier);
	}

	@Override
	public <T> T accept(IDeclarationVisitor<T> visitor) {
		return visitor.visitVariableDeclarationGroup(this);
	}

	@Override
	public VariableDeclarationGroup deepClone() {
		VariableDeclarationGroup clone = new VariableDeclarationGroup();
		clone.baseTypeExtensionMap = baseTypeExtensionMap.deepClone();
		initializerMap.entrySet().stream().forEachOrdered(
				e -> clone.initializerMap.put(
						e.getKey().deepClone(),
						e.getValue() != null ? e.getValue().deepClone() : null
				)
		);
		return clone;
	}
}
