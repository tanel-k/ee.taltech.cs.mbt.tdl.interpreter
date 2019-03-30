package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer.AbsVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.IBaseTypeSharingGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.BaseSharingTypeMap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.BaseSharingTypeMap.BaseSharingType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IDeclarationVisitor;

import java.util.HashMap;
import java.util.Map;

public class VariableDeclarationGroup extends AbsVariableDeclaration implements IBaseTypeSharingGroup<AbsVariableDeclaration, VariableDeclaration> {
	private BaseSharingTypeMap<Identifier> baseSharingTypeMap = new BaseSharingTypeMap<>();
	private Map<Identifier, AbsVariableInitializer> initializerMap = new HashMap<>();

	public BaseSharingTypeMap<Identifier> getBaseSharingTypeMap() {
		return baseSharingTypeMap;
	}

	public Map<Identifier, AbsVariableInitializer> getInitializerMap() {
		return initializerMap;
	}

	@Override
	public VariableDeclaration mapToIndependent(BaseSharingType<Identifier> sharingType) {
		Identifier identifier = sharingType.getKey();
		VariableDeclaration variableDeclaration = new VariableDeclaration();
		variableDeclaration.setInitializer(initializerMap.get(identifier));
		variableDeclaration.setType(sharingType.toDetachedInstance());
		variableDeclaration.setIdentifier(identifier);
		return variableDeclaration;
	}

	public AbsVariableDeclaration reduceToOnlyEntryIfApplicable() {
		return getOnlyEntry().orElse(this);
	}


	@Override
	public <T> T accept(IDeclarationVisitor<T> visitor) {
		return visitor.visitVariableDeclarationGroup(this);
	}
}
