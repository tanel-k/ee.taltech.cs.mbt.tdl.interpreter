package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IExpressionVisitor;

public class FalseLiteral extends AbsLiteralExpression {
	public static FalseLiteral getInstance() {
		return INSTANCE;
	}

	private static final FalseLiteral INSTANCE = new FalseLiteral();

	private FalseLiteral() { }

	@Override
	public FalseLiteral deepClone() {
		return this; // singleton
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitFalseLiteral(this);
	}
}
