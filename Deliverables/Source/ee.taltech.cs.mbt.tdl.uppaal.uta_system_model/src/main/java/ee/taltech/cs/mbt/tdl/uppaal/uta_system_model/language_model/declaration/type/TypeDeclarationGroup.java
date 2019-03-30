package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.type;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.IBaseTypeSharingGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.BaseSharingTypeMap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.BaseSharingTypeMap.BaseSharingType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IDeclarationVisitor;

public class TypeDeclarationGroup extends AbsTypeDeclaration implements IBaseTypeSharingGroup<AbsTypeDeclaration, TypeDeclaration> {
	private BaseSharingTypeMap<Identifier> baseSharingTypeMap = new BaseSharingTypeMap<>();

	@Override
	public BaseSharingTypeMap<Identifier> getBaseSharingTypeMap() {
		return baseSharingTypeMap;
	}

	@Override
	public TypeDeclaration mapToIndependent(BaseSharingType<Identifier> extendedType) {
		TypeDeclaration typeDeclaration = new TypeDeclaration();
		typeDeclaration.setIdentifier(extendedType.getKey());
		typeDeclaration.setType(extendedType.toDetachedInstance());
		return typeDeclaration;
	}

	public AbsTypeDeclaration reduceToOnlyEntryIfApplicable() {
		return getOnlyEntry().orElse(this);
	}

	@Override
	public <T> T accept(IDeclarationVisitor<T> visitor) {
		return visitor.visitTypeDeclarationGroup(this);
	}
}
