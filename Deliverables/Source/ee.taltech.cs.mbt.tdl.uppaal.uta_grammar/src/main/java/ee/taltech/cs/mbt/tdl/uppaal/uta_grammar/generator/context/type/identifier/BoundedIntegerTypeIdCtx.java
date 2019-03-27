package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.type.identifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.AbsExpressionCtx;

public class BoundedIntegerTypeIdCtx extends AbsTypeIdentifierCtx {
	private AbsExpressionCtx lowerBoundExpression;
	private AbsExpressionCtx upperBoundExpression;

	public AbsExpressionCtx getLowerBoundExpression() {
		return lowerBoundExpression;
	}

	public void setLowerBoundExpression(AbsExpressionCtx lowerBoundExpression) {
		this.lowerBoundExpression = lowerBoundExpression;
	}

	public AbsExpressionCtx getUpperBoundExpression() {
		return upperBoundExpression;
	}

	public void setUpperBoundExpression(AbsExpressionCtx upperBoundExpression) {
		this.upperBoundExpression = upperBoundExpression;
	}

	@Override
	public <T> T accept(ITypeIdCtxVisitor<T> visitor) {
		return visitor.visitBoundedIntegerTypeId(this);
	}
}
