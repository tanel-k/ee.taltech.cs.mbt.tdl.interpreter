package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.visitation;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.ChannelPriorityDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.function.ValueFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.function.VoidFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.system.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.type.container.TypeDeclarationList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.container.VariableDeclarationList;

public class BaseDeclarationVisitor implements IDeclarationVisitor {
	@Override public void visitVariableDeclaration(VariableDeclaration variableDeclaration) { }
	@Override public void visitVariableDeclarationList(VariableDeclarationList variableDeclarationList) { }
	@Override public void visitTypeDeclaration(TypeDeclaration typeDeclaration) { }
	@Override public void visitTypeDeclarationList(TypeDeclarationList typeDeclarations) { }
	@Override public void visitVoidFunctionDeclaration(VoidFunctionDeclaration voidFunctionDeclaration) { }
	@Override public void visitValueFunctionDeclaration(ValueFunctionDeclaration valueFunctionDeclaration) { }
	@Override public void visitChannelPriorityDeclaration(ChannelPriorityDeclaration channelRefs) { }
	@Override public void visitTemplateInstantiation(TemplateInstantiation templateInstantiation) { }
}
