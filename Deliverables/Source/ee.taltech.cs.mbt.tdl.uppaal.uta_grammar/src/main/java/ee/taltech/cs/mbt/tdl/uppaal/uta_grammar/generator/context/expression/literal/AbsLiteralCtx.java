package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.literal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.AbsExpressionCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.IExpressionCtxVisitor;

public abstract class AbsLiteralCtx extends AbsExpressionCtx {
	public abstract <T> T accept(ILiteralVisitor<T> visitor);

	public <T> T accept(IExpressionCtxVisitor<T> visitor) {
		return visitor.visitLiteral(this);
	}
}
