package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.field;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IFieldDeclarationVisitor;

public abstract class AbsFieldDeclaration implements IDeepCloneable<AbsFieldDeclaration> {
	@Override
	public abstract AbsFieldDeclaration deepClone();

	public abstract <T> T accept(IFieldDeclarationVisitor<T> visitor);
}
