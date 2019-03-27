package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.channel_priority.ChannelPriorityDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.ValueFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.VoidFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.system.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.type.container.TypeDeclarationList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.variable.container.VariableDeclarationList;

public interface IDeclarationVisitor<T> {
	T visitVariableDeclaration(VariableDeclaration stmt);
	T visitVariableDeclarationList(VariableDeclarationList stmt);
	T visitTypeDeclaration(TypeDeclaration stmt);
	T visitTypeDeclarationList(TypeDeclarationList stmt);
	T visitVoidFunctionDeclaration(VoidFunctionDeclaration stmt);
	T visitValueFunctionDeclaration(ValueFunctionDeclaration stmt);
	T visitChannelPriorityDeclaration(ChannelPriorityDeclaration stmt);
	T visitTemplateInstantiation(TemplateInstantiation stmt);
}
