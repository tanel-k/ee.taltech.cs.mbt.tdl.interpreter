package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.function.statement;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.AbsExpressionCtx;

public class WhileStmtCtx extends AbsStatementCtx {
	private AbsExpressionCtx condition;
	private AbsStatementCtx statement;

	public AbsExpressionCtx getCondition() {
		return condition;
	}

	public void setCondition(AbsExpressionCtx condition) {
		this.condition = condition;
	}

	public AbsStatementCtx getStatement() {
		return statement;
	}

	public void setStatement(AbsStatementCtx statement) {
		this.statement = statement;
	}

	@Override
	public <T> T accept(IStatementCtxVisitor<T> visitor) {
		return visitor.visitWhileStatement(this);
	}
}
