package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;

public class TrueLiteral extends AbsLiteralExpression {
	public static TrueLiteral getInstance() {
		return INSTANCE;
	}

	private static final TrueLiteral INSTANCE = new TrueLiteral();

	private TrueLiteral() { }

	@Override
	public TrueLiteral deepClone() {
		return this; // singleton
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitTrueLiteral(this);
	}
}
