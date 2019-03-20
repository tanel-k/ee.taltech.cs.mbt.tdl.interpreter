package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.visitation;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.ChannelPriorityDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.function.ValueFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.function.VoidFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.system.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.type.container.TypeDeclarationList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.container.VariableDeclarationList;

public interface IDeclarationVisitor {
	void visitVariableDeclaration(VariableDeclaration variableDeclaration);
	void visitVariableDeclarationList(VariableDeclarationList variableDeclarationList);
	void visitTypeDeclaration(TypeDeclaration typeDeclaration);
	void visitTypeDeclarationList(TypeDeclarationList typeDeclarations);
	void visitVoidFunctionDeclaration(VoidFunctionDeclaration voidFunctionDeclaration);
	void visitValueFunctionDeclaration(ValueFunctionDeclaration valueFunctionDeclaration);
	void visitChannelPriorityDeclaration(ChannelPriorityDeclaration channelRefs);
	void visitTemplateInstantiation(TemplateInstantiation templateInstantiation);
}
