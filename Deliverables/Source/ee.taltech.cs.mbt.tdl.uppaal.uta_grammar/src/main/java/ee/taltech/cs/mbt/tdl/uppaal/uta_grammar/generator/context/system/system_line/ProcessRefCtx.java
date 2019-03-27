package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.system.system_line;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.identifier.IdentifierNameCtx;

public class ProcessRefCtx extends AbsCodeGenerationCtx {
	private IdentifierNameCtx identifierName;

	public IdentifierNameCtx getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(IdentifierNameCtx identifierName) {
		this.identifierName = identifierName;
	}

	@Override
	public <T> T accept(ICodeGenerationCtxVisitor<T> visitor) {
		return visitor.visitProcessRef(this);
	}
}
