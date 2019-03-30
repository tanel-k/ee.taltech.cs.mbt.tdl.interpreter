package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.FunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.ChannelPrioritySequence;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.type.TypeDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclarationGroup;

public interface IDeclarationVisitor<T> {
	T visitVariableDeclaration(VariableDeclaration decl);
	T visitTypeDeclaration(TypeDeclaration decl);
	T visitChannelPriorityDeclaration(ChannelPrioritySequence decl);
	T visitTemplateInstantiation(TemplateInstantiation decl);
	T visitFunctionDeclaration(FunctionDeclaration decl);
	T visitVariableDeclarationGroup(VariableDeclarationGroup decl);
	T visitTypeDeclarationGroup(TypeDeclarationGroup decl);
}
