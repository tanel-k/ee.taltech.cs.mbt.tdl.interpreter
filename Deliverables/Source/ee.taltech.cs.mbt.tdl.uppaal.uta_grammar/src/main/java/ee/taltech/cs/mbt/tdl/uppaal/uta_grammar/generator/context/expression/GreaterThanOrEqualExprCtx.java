package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.classes.AbsBinaryExprCtx;

public class GreaterThanOrEqualExprCtx extends AbsBinaryExprCtx {
	@Override
	public <T> T accept(IExpressionCtxVisitor<T> visitor) {
		return visitor.visitGreaterThanOrEqualExpr(this);
	}
}
