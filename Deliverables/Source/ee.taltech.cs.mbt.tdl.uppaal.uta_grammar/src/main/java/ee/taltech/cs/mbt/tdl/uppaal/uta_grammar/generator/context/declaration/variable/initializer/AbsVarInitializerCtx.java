package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.variable.initializer;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;

public abstract class AbsVarInitializerCtx extends AbsCodeGenerationCtx {
	public abstract <T> T accept(IVariableInitializerCtxVisitor<T> visitor);
}
