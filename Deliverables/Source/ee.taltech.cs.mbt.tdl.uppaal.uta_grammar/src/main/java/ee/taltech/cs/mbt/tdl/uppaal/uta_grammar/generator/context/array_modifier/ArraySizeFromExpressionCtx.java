package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.array_modifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.AbsExpressionCtx;

public class ArraySizeFromExpressionCtx extends AbsArraySizeModCtx {
	private AbsExpressionCtx sizeExpression;

	public AbsExpressionCtx getSizeExpression() {
		return sizeExpression;
	}

	public void setSizeExpression(AbsExpressionCtx sizeExpression) {
		this.sizeExpression = sizeExpression;
	}

	@Override
	public <T> T accept(ICodeGenerationCtxVisitor<T> visitor) {
		return visitor.visitArraySizeFromExpression(this);
	}
}
