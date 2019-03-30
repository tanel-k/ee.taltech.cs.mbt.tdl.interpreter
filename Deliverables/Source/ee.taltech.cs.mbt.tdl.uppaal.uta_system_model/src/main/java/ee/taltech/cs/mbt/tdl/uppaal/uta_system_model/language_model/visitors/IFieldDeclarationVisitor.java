package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field.FieldDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field.FieldDeclarationGroup;

public interface IFieldDeclarationVisitor<T> {
	T visitFieldDeclaration(FieldDeclaration decl);
	T visitFieldDeclarationGroup(FieldDeclarationGroup decl);
}
