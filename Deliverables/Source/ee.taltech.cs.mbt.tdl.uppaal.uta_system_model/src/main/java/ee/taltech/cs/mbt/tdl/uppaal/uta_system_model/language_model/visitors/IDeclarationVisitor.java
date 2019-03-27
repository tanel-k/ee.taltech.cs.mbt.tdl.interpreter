package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.FunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.ChannelPrioritySequence;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclaration;

public interface IDeclarationVisitor<T> {
	T visitVariableDeclaration(VariableDeclaration decl);
	T visitTypeDeclaration(TypeDeclaration decl);
	T visitChannelPriorityDeclaration(ChannelPrioritySequence decl);
	T visitTemplateInstantiation(TemplateInstantiation decl);
	T visitFunctionDeclaration(FunctionDeclaration decl);
}
