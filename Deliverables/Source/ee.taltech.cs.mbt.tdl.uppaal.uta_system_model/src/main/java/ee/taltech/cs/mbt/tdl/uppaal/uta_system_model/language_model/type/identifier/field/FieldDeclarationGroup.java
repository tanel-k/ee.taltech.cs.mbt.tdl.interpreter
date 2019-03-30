package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.IBaseTypeSharingGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.BaseSharingTypeMap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.BaseSharingTypeMap.BaseSharingType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IFieldDeclarationVisitor;

public class FieldDeclarationGroup extends AbsFieldDeclaration implements IBaseTypeSharingGroup<AbsFieldDeclaration, FieldDeclaration> {
	private BaseSharingTypeMap<Identifier> baseSharingTypeMap = new BaseSharingTypeMap<>();

	public BaseSharingTypeMap<Identifier> getBaseSharingTypeMap() {
		return baseSharingTypeMap;
	}

	@Override
	public FieldDeclaration mapToIndependent(BaseSharingType<Identifier> sharingType) {
		FieldDeclaration fieldDeclaration = new FieldDeclaration();
		fieldDeclaration.setType(sharingType.toDetachedInstance());
		fieldDeclaration.setIdentifier(sharingType.getKey());
		return fieldDeclaration;
	}

	@Override
	public FieldDeclarationGroup deepClone() {
		FieldDeclarationGroup clone = new FieldDeclarationGroup();
		clone.baseSharingTypeMap = getBaseSharingTypeMap().deepClone();
		return clone;
	}

	public AbsFieldDeclaration reduceToOnlyEntryIfApplicable() {
		return getOnlyEntry().orElse(this);
	}

	@Override
	public <T> T accept(IFieldDeclarationVisitor<T> visitor) {
		return visitor.visitFieldDeclarationGroup(this);
	}
}
