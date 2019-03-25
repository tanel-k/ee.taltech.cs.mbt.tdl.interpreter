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
	T visitVariableDeclaration(VariableDeclaration stmt);
	T visitVariableDeclarationList(VariableDeclarationList stmt);
	T visitTypeDeclaration(TypeDeclaration stmt);
	T visitTypeDeclarationList(TypeDeclarationList stmt);
	T visitVoidFunctionDeclaration(VoidFunctionDeclaration stmt);
	T visitValueFunctionDeclaration(ValueFunctionDeclaration stmt);
	T visitChannelPriorityDeclaration(ChannelPriorityDeclaration stmt);
	T visitTemplateInstantiation(TemplateInstantiation stmt);
}
