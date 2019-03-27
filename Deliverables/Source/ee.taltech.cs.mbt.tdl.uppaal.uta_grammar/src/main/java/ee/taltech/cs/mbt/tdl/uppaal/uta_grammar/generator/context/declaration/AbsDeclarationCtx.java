package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;

public abstract class AbsDeclarationCtx extends AbsCodeGenerationCtx {
	public abstract <T> T accept(IDeclarationCtxVisitor<T> visitor);
}
