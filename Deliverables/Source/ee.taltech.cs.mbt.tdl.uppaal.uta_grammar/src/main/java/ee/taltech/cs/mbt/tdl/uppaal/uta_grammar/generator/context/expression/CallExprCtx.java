package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.classes.AbsUnaryExprCtx;

import java.util.LinkedList;
import java.util.List;

public class CallExprCtx extends AbsUnaryExprCtx {
	private List<AbsExpressionCtx> arguments = new LinkedList<>();

	public List<AbsExpressionCtx> getArguments() {
		return arguments;
	}

	@Override
	public <T> T accept(IExpressionCtxVisitor<T> visitor) {
		return visitor.visitCallExpr(this);
	}
}
