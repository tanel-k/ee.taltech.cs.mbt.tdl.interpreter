package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.field.FieldDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.field.FieldDeclarationGroup;

public interface IFieldDeclarationVisitor<T> {
	T visitFieldDeclaration(FieldDeclaration decl);
	T visitFieldDeclarationGroup(FieldDeclarationGroup decl);
}
