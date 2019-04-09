package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IExpressionVisitor;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Represents a natural number literal.
 */
public class NaturalNumberLiteral extends AbsLiteralExpression {
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

	private BigInteger value;

	private NaturalNumberLiteral(BigInteger value) {
		this.value = value;
	}

	public BigInteger getValue() {
		return value;
	}

	@Override
	public AbsExpression deepClone() {
		return this; // singleton
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visitNaturalNumberLiteral(this);
	}

	@Override
	public int hashCode() {
		return getValue().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof NaturalNumberLiteral))
			return false;
		NaturalNumberLiteral other = (NaturalNumberLiteral) obj;
		return other.getValue().equals(this.getValue());
	}
}
