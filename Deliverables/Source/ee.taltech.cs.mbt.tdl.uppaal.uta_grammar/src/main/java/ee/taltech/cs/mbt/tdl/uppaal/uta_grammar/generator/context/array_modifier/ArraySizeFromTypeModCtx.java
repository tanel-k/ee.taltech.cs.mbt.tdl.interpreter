package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.array_modifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.TypeCtx;

public class ArraySizeFromTypeModCtx extends AbsArraySizeModCtx {
	private TypeCtx sizeType;

	public TypeCtx getSizeType() {
		return sizeType;
	}

	public void setSizeType(TypeCtx sizeType) {
		this.sizeType = sizeType;
	}

	@Override
	public <T> T accept(ICodeGenerationCtxVisitor<T> visitor) {
		return visitor.visitArraySizeFromType(this);
	}
}
