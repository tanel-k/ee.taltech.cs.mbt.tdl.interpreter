package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.identifier.AbsTypeIdentifierCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.prefix.AbsTypePrefixCtx;

public abstract class TypeCtx extends AbsCodeGenerationCtx {
	private AbsTypePrefixCtx prefix;
	private AbsTypeIdentifierCtx identifier;

	public AbsTypePrefixCtx getPrefix() {
		return prefix;
	}

	public void setPrefix(AbsTypePrefixCtx prefix) {
		this.prefix = prefix;
	}

	public AbsTypeIdentifierCtx getIdentifier() {
		return identifier;
	}

	public void setIdentifier(AbsTypeIdentifierCtx identifier) {
		this.identifier = identifier;
	}
}
