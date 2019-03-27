package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.categories.literals;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.IExpressionVisitor;

import java.math.BigInteger;

/**
 * Represents a natural number literal.
 */
public class NaturalNumberLiteral extends AbsLiteralExpression<BigInteger> {
	public static NaturalNumberLiteral of(long value) {
		if (value < 0)
			throw new IllegalArgumentException("Cannot construct a natural number literal with a negative integer.");
		return new NaturalNumberLiteral(BigInteger.valueOf(value));
	}

	public static NaturalNumberLiteral of(int value) {
		return of(Integer.valueOf(value).longValue());
	}

	public static NaturalNumberLiteral of(String value) {
		return of(new BigInteger(value));
	}

	public static NaturalNumberLiteral of(BigInteger value) {
		if (value.compareTo(BigInteger.ZERO) < 0)
			throw new IllegalArgumentException("Cannot construct a natural number literal with a negative integer.");
		return new NaturalNumberLiteral(value);
	}

	NaturalNumberLiteral(BigInteger value) {
		super(value);
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitNaturalNumber(this);
	}
}
