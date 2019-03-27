package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.classes.AbsBinaryExprCtx;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.classes.IHasAssignmentVariant;

public class AdditionExprCtx extends AbsBinaryExprCtx implements IHasAssignmentVariant {
	private boolean assignment;

	@Override
	public boolean isAssignment() {
		return assignment;
	}

	@Override
	public void setAssignment(boolean assignment) {
		this.assignment = assignment;
	}

	@Override
	public <T> T accept(IExpressionCtxVisitor<T> visitor) {
		return visitor.visitAdditionExpr(this);
	}
}
