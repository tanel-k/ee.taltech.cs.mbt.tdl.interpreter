package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IFieldDeclarationVisitor;

public abstract class AbsFieldDeclaration implements IDeepCloneable<AbsFieldDeclaration> {
	@Override
	public abstract AbsFieldDeclaration deepClone();

	public abstract <T> T accept(IFieldDeclarationVisitor<T> visitor);
}
