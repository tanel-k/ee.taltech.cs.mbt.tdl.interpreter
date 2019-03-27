package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;

public abstract class AbsExpressionCtx extends AbsCodeGenerationCtx {
	public abstract <T> T accept(IExpressionCtxVisitor<T> visitor);
}
