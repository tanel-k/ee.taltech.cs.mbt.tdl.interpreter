package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.classes;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.AbsExpressionCtx;

public abstract class AbsUnaryExprCtx extends AbsExpressionCtx {
	private AbsExpressionCtx child;

	public AbsExpressionCtx getChild() {
		return child;
	}

	public void setChild(AbsExpressionCtx child) {
		this.child = child;
	}
}
