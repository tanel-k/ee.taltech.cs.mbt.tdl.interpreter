package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.classes.AbsUnaryExprCtx;

public class GroupedExprCtx extends AbsUnaryExprCtx {
	@Override
	public <T> T accept(IExpressionCtxVisitor<T> visitor) {
		return visitor.visitGroupedExpr(this);
	}
}
