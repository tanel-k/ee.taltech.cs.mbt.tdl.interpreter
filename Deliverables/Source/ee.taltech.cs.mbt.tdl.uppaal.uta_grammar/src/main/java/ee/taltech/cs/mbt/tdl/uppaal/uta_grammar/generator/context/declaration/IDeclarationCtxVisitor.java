package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.TemplateInstantiationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.TypeDeclarationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.channel_priority.ChannelPriorityDeclCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.function.FunctionDeclarationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.variable.VariableDeclarationCtx;

public interface IDeclarationCtxVisitor<T> {
	T visitTypeDeclaration(TypeDeclarationCtx ctx);
	T visitVariableDeclaration(VariableDeclarationCtx ctx);
	T visitFunctionDeclaration(FunctionDeclarationCtx ctx);
	T visitChannelPriorityDeclaration(ChannelPriorityDeclCtx ctx);
	T visitTemplateInstantiation(TemplateInstantiationCtx ctx);
}
