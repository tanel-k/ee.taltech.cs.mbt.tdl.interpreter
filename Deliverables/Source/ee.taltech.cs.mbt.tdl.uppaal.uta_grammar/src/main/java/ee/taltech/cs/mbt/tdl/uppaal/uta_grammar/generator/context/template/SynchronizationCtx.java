package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.template;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.AbsCodeGenerationCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.AbsExpressionCtx;

public class SynchronizationCtx extends AbsCodeGenerationCtx {
	private boolean active;
	private AbsExpressionCtx expression;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public AbsExpressionCtx getExpression() {
		return expression;
	}

	public void setExpression(AbsExpressionCtx expression) {
		this.expression = expression;
	}

	@Override
	public <T> T accept(ICodeGenerationCtxVisitor<T> visitor) {
		return visitor.visitSynchronizationCtx(this);
	}
}
