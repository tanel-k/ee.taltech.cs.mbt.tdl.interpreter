package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.field;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.BaseTypeExtensionMap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.BaseTypeExtensionMap.BaseTypeExtension;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.ITypeExtensionGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IFieldDeclarationVisitor;

public class FieldDeclarationGroup extends AbsFieldDeclaration implements ITypeExtensionGroup<AbsFieldDeclaration, FieldDeclaration> {
	private BaseTypeExtensionMap baseTypeExtensionMap = new BaseTypeExtensionMap();

	public BaseTypeExtensionMap getBaseTypeExtensionMap() {
		return baseTypeExtensionMap;
	}

	@Override
	public FieldDeclaration mapToIndependent(BaseTypeExtension baseTypeExtension) {
		FieldDeclaration fieldDeclaration = new FieldDeclaration();
		fieldDeclaration.setType(baseTypeExtension.toDetachedInstance());
		fieldDeclaration.setIdentifier(baseTypeExtension.getIdentifier());
		return fieldDeclaration;
	}

	@Override
	public FieldDeclarationGroup deepClone() {
		FieldDeclarationGroup clone = new FieldDeclarationGroup();
		clone.baseTypeExtensionMap = baseTypeExtensionMap.deepClone();
		return clone;
	}

	@Override
	public <T> T accept(IFieldDeclarationVisitor<T> visitor) {
		return visitor.visitFieldDeclarationGroup(this);
	}
}
