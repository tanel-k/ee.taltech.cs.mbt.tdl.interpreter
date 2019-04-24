package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.type;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.BaseTypeExtensionMap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.BaseTypeExtensionMap.BaseTypeExtension;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.ITypeExtensionGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IDeclarationVisitor;

public class TypeDeclarationGroup extends AbsTypeDeclaration implements ITypeExtensionGroup<AbsTypeDeclaration, TypeDeclaration> {
	private BaseTypeExtensionMap baseTypeExtensionMap = new BaseTypeExtensionMap();

	@Override
	public BaseTypeExtensionMap getBaseTypeExtensionMap() {
		return baseTypeExtensionMap;
	}

	@Override
	public TypeDeclaration mapToIndependent(BaseTypeExtension baseTypeExtension) {
		TypeDeclaration typeDeclaration = new TypeDeclaration();
		typeDeclaration.setIdentifier(baseTypeExtension.getIdentifier());
		typeDeclaration.setType(baseTypeExtension.toDetachedInstance());
		return typeDeclaration;
	}

	@Override
	public <T> T accept(IDeclarationVisitor<T> visitor) {
		return visitor.visitTypeDeclarationGroup(this);
	}

	@Override
	public TypeDeclarationGroup deepClone() {
		TypeDeclarationGroup clone = new TypeDeclarationGroup();
		clone.baseTypeExtensionMap = baseTypeExtensionMap.deepClone();
		return clone;
	}
}
