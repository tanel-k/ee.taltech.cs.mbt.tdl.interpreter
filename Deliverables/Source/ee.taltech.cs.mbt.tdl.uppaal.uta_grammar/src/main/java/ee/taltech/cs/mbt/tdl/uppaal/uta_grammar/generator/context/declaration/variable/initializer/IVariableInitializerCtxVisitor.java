package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.variable.initializer;

public interface IVariableInitializerCtxVisitor<T> {
	T visitFlatVariableInitializer(FlatVarInitializerCtx flatVarInitializerCtx);
	T visitStructuredVariableInitializer(StructuredVarInitializerCtx structuredVarInitializerCtx);
}
