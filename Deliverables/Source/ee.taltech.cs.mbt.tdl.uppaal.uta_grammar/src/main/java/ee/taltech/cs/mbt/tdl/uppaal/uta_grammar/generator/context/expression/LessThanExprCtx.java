package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.classes.AbsBinaryExprCtx;

public class LessThanExprCtx extends AbsBinaryExprCtx {
	@Override
	public <T> T accept(IExpressionCtxVisitor<T> visitor) {
		return visitor.visitLessThanExpr(this);
	}
}
