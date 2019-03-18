package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.literals;

import java.math.BigInteger;

public class BasicLiterals {
	public static final class KeywordLiteral extends LiteralExpression<String> {
		KeywordLiteral(String keyword) {
			super(keyword);
		}
	}

	public static final class NaturalNumberLiteral extends LiteralExpression<BigInteger> {
		NaturalNumberLiteral(BigInteger value) {
			super(value);
		}
	}

	public static final KeywordLiteral DEADLOCK = new KeywordLiteral("deadlock");
	public static final KeywordLiteral TRUE = new KeywordLiteral("true");
	public static final KeywordLiteral FALSE = new KeywordLiteral("false");

	public static final NaturalNumberLiteral NUMERICAL_TRUE = BasicLiterals.naturalNumberLiteral(BigInteger.ONE);
	public static final NaturalNumberLiteral NUMERICAL_FALSE = BasicLiterals.naturalNumberLiteral(BigInteger.ZERO);

	public static NaturalNumberLiteral naturalNumberLiteral(BigInteger value) {
		return new NaturalNumberLiteral(value);
	}
}
