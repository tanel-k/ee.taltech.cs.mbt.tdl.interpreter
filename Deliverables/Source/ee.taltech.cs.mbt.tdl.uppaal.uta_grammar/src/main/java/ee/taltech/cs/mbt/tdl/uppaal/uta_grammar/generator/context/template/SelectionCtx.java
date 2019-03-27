package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.template;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.identifier.IdentifierNameCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.TypeCtx;

public class SelectionCtx extends AbsCodeGenerationCtx {
	private IdentifierNameCtx identifierName;
	private TypeCtx type;

	public IdentifierNameCtx getIdentifierName() {
		return identifierName;
	}

	public void setIdentifierName(IdentifierNameCtx identifierName) {
		this.identifierName = identifierName;
	}

	public TypeCtx getType() {
		return type;
	}

	public void setType(TypeCtx type) {
		this.type = type;
	}

	@Override
	public <T> T accept(ICodeGenerationCtxVisitor<T> visitor) {
		return visitor.visitSelectionCtx(this);
	}
}
