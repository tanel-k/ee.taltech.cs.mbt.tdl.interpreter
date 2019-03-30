package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IFieldDeclarationVisitor;

public abstract class AbsFieldDeclaration {
	public abstract AbsFieldDeclaration deepClone();
	public abstract <T> T accept(IFieldDeclarationVisitor<T> visitor);
}
