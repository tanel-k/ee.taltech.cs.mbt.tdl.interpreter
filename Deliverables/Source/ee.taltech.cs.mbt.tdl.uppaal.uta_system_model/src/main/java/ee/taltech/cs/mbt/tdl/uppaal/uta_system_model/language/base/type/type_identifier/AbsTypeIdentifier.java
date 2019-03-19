package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.traversal.ITypeIdentifierVisitor;

public abstract class AbsTypeIdentifier {
	AbsTypeIdentifier() { }

	public abstract void accept(ITypeIdentifierVisitor visitor);
}
