package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;

public abstract class AbsTypeIdentifierCtx extends AbsCodeGenerationCtx {
	public abstract <T> T accept(ITypeIdCtxVisitor<T> visitor);
}
