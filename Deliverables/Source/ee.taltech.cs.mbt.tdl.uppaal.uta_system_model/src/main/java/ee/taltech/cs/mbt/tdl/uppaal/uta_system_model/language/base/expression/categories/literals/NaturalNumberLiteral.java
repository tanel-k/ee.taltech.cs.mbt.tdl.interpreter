package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.literals;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.traversal.IExpressionVisitor;

import java.math.BigInteger;

public class NaturalNumberLiteral extends AbsLiteralExpression<BigInteger> {
	public static NaturalNumberLiteral of(long value) {
		return new NaturalNumberLiteral(BigInteger.valueOf(value));
	}

	public static NaturalNumberLiteral of(int value) {
		return of(Integer.valueOf(value).longValue());
	}

	public static NaturalNumberLiteral of(String value) {
		return new NaturalNumberLiteral(new BigInteger(value));
	}

	NaturalNumberLiteral(BigInteger value) {
		super(value);
	}

	@Override
	public void accept(IExpressionVisitor visitor) {
		visitor.visitNaturalNumber(this);
	}
}
