package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.declaration.variable.initializer;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.AbsExpressionCtx;

public class FlatVarInitializerCtx extends AbsVarInitializerCtx {
	private AbsExpressionCtx expression;

	public AbsExpressionCtx getExpression() {
		return expression;
	}

	public void setExpression(AbsExpressionCtx expression) {
		this.expression = expression;
	}

	@Override
	public <T> T accept(IVariableInitializerCtxVisitor<T> visitor) {
		return visitor.visitFlatVariableInitializer(this);
	}
}
