package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.visitation;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.ChannelPriorityDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.function.ValueFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.function.VoidFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.system.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.type.container.TypeDeclarationList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.container.VariableDeclarationList;

public interface IDeclarationVisitor<T> {
	T visitVariableDeclaration(VariableDeclaration variableDeclaration);
	T visitVariableDeclarationList(VariableDeclarationList variableDeclarationList);
	T visitTypeDeclaration(TypeDeclaration typeDeclaration);
	T visitTypeDeclarationList(TypeDeclarationList typeDeclarations);
	T visitVoidFunctionDeclaration(VoidFunctionDeclaration voidFunctionDeclaration);
	T visitValueFunctionDeclaration(ValueFunctionDeclaration valueFunctionDeclaration);
	T visitChannelPriorityDeclaration(ChannelPriorityDeclaration channelRefs);
	T visitTemplateInstantiation(TemplateInstantiation templateInstantiation);
}
