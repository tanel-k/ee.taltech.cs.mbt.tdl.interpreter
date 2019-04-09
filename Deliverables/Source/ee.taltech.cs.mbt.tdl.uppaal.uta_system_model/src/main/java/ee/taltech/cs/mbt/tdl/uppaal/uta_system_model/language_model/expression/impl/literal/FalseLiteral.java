package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;

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
