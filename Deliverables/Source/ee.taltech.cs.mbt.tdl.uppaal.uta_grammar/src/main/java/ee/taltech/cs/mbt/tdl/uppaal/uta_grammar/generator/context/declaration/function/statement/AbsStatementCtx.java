package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.function.statement;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;

public abstract class AbsStatementCtx extends AbsCodeGenerationCtx {
	public abstract <T> T accept(IStatementCtxVisitor<T> visitor);
}
