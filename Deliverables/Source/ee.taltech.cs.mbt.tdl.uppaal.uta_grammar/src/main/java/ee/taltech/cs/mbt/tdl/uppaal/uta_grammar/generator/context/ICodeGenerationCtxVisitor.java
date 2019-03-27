package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.variable.VariableInitializationCtx;

public interface ICodeGenerationCtxVisitor<T> {
	T visitVariableInitialization(VariableInitializationCtx ctx);
}
