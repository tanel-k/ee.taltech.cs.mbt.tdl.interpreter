package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IExpressionVisitor;

public class DeadlockLiteral extends AbsLiteralExpression {
	public static DeadlockLiteral getInstance() {
		return INSTANCE;
	}

	private static final DeadlockLiteral INSTANCE = new DeadlockLiteral();

	private DeadlockLiteral() { }

	@Override
	public DeadlockLiteral deepClone() {
		return this; // singleton
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitDeadlockLiteral(this);
	}
}
