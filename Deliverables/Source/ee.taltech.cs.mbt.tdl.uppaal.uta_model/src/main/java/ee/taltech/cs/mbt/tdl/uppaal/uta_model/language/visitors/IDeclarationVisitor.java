package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.FunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.ChannelPrioritySequence;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.type.TypeDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.VariableDeclarationGroup;

public interface IDeclarationVisitor<T> {
	T visitVariableDeclaration(VariableDeclaration decl);
	T visitTypeDeclaration(TypeDeclaration decl);
	T visitChannelPriorityDeclaration(ChannelPrioritySequence decl);
	T visitTemplateInstantiation(TemplateInstantiation decl);
	T visitFunctionDeclaration(FunctionDeclaration decl);
	T visitVariableDeclarationGroup(VariableDeclarationGroup decl);
	T visitTypeDeclarationGroup(TypeDeclarationGroup decl);
}
