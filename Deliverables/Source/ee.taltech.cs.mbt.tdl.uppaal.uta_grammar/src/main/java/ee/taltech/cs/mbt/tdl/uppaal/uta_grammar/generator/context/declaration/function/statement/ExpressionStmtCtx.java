package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.function.statement;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.ICodeGenerationCtxVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.AbsExpressionCtx;

public class ExpressionStmtCtx extends AbsStatementCtx {
	private AbsExpressionCtx expression;

	public AbsExpressionCtx getExpression() {
		return expression;
	}

	public void setExpression(AbsExpressionCtx expression) {
		this.expression = expression;
	}

	@Override
	public <T> T accept(IStatementCtxVisitor<T> visitor) {
		return visitor.visitExpressionStatement(this);
	}
}
