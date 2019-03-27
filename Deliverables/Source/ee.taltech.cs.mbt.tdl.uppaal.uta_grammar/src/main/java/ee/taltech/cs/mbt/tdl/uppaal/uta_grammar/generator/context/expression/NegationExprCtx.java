package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.classes.AbsUnaryExprCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.classes.IHasPhrasalVariant;

public class NegationExprCtx extends AbsUnaryExprCtx implements IHasPhrasalVariant {
	private boolean phrasal;

	@Override
	public boolean isPhrasal() {
		return phrasal;
	}

	@Override
	public void setPhrasal(boolean phrasal) {
		this.phrasal = phrasal;
	}

	@Override
	public <T> T accept(IExpressionCtxVisitor<T> visitor) {
		return visitor.visitNegationExpr(this);
	}
}
