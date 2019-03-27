package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.AbsExpressionCtx;

public class ScalarTypeIdCtx extends AbsTypeIdentifierCtx {
	private AbsExpressionCtx expression;

	public AbsExpressionCtx getExpression() {
		return expression;
	}

	public void setExpression(AbsExpressionCtx expression) {
		this.expression = expression;
	}

	@Override
	public <T> T accept(ITypeIdCtxVisitor<T> visitor) {
		return visitor.visitScalarTypeId(this);
	}
}
