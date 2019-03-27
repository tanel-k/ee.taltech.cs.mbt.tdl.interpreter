package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.function.statement;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.AbsExpressionCtx;

public class ConditionalStmtCtx extends AbsStatementCtx {
	private AbsExpressionCtx condition;
	private AbsStatementCtx primary;
	private AbsStatementCtx alternative;

	public AbsExpressionCtx getCondition() {
		return condition;
	}

	public void setCondition(AbsExpressionCtx condition) {
		this.condition = condition;
	}

	public AbsStatementCtx getPrimary() {
		return primary;
	}

	public void setPrimary(AbsStatementCtx primary) {
		this.primary = primary;
	}

	public AbsStatementCtx getAlternative() {
		return alternative;
	}

	public void setAlternative(AbsStatementCtx alternative) {
		this.alternative = alternative;
	}

	@Override
	public <T> T accept(IStatementCtxVisitor<T> visitor) {
		return visitor.visitConditionalStatement(this);
	}
}
