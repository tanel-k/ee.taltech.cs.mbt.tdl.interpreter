package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.parameter;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.identifier.variant.IdentifierNameVariantCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.identifier.AbsTypeIdentifierCtx;

public class ParameterCtx extends AbsCodeGenerationCtx {
	private boolean byReference;
	private AbsTypeIdentifierCtx type;
	private IdentifierNameVariantCtx nameVariant;

	public boolean isByReference() {
		return byReference;
	}

	public void setByReference(boolean byReference) {
		this.byReference = byReference;
	}

	public AbsTypeIdentifierCtx getType() {
		return type;
	}

	public void setType(AbsTypeIdentifierCtx type) {
		this.type = type;
	}

	public IdentifierNameVariantCtx getNameVariant() {
		return nameVariant;
	}

	public void setNameVariant(IdentifierNameVariantCtx nameVariant) {
		this.nameVariant = nameVariant;
	}

	@Override
	public <T> T accept(ICodeGenerationCtxVisitor<T> visitor) {
		return visitor.visitParameterCtx(this);
	}
}
