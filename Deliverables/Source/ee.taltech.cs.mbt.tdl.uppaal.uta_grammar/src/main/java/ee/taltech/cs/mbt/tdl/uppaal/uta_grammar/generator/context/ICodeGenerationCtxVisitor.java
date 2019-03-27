package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context;

public interface ICodeGenerationCtxVisitor<T> {
	T visitVariableInitialization(VariableInitializationCtx ctx);
}
