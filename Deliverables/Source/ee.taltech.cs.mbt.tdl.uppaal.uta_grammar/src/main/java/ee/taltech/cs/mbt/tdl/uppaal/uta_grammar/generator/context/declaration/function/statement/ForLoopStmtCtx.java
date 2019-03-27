package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.function.statement;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.AbsExpressionCtx;

public class ForLoopStmtCtx extends AbsStatementCtx {
	private AbsExpressionCtx initializer;
	private AbsExpressionCtx condition;
	private AbsExpressionCtx update;
	private AbsStatementCtx statement;

	public AbsExpressionCtx getInitializer() {
		return initializer;
	}

	public void setInitializer(AbsExpressionCtx initializer) {
		this.initializer = initializer;
	}

	public AbsExpressionCtx getCondition() {
		return condition;
	}

	public void setCondition(AbsExpressionCtx condition) {
		this.condition = condition;
	}

	public AbsExpressionCtx getUpdate() {
		return update;
	}

	public void setUpdate(AbsExpressionCtx update) {
		this.update = update;
	}

	public AbsStatementCtx getStatement() {
		return statement;
	}

	public void setStatement(AbsStatementCtx statement) {
		this.statement = statement;
	}

	@Override
	public <T> T accept(IStatementCtxVisitor<T> visitor) {
		return visitor.visitForLoopStatement(this);
	}
}
