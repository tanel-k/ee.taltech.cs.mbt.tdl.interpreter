package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.prefix;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;

public abstract class AbsTypePrefixCtx extends AbsCodeGenerationCtx {
	public abstract <T> T accept(ITypePrefixCtxVisitor<T> visitor);
}
