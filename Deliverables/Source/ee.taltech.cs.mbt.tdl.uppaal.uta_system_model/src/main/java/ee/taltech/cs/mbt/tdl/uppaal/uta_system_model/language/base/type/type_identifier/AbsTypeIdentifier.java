package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.visitation.ITypeIdentifierVisitor;

public abstract class AbsTypeIdentifier {
	public abstract void accept(ITypeIdentifierVisitor visitor);
}
