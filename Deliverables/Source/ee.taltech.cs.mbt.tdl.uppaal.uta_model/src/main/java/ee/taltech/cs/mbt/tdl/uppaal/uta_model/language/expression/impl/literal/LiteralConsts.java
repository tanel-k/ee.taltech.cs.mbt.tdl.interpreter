package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal;

import java.math.BigInteger;

/**
 * Provides access to singletons for common keyword and natural number literals.<br/>
 */
public class LiteralConsts {
	/**
	 * Literal 'deadlock' is reserved for the UPPAAL requirement specification language.
	 */
	public static final DeadlockLiteral DEADLOCK = DeadlockLiteral.getInstance();

	/**
	 * Boolean literal 'true'.
	 */
	public static final TrueLiteral TRUE = TrueLiteral.getInstance();

	/**
	 * Boolean literal 'false'.
	 */
	public static final FalseLiteral FALSE = FalseLiteral.getInstance();

	/**
	 * Natural number literal 1 (equivalent to the Boolean literal 'true').
	 */
	public static final NaturalNumberLiteral NUMERICAL_TRUE = NaturalNumberLiteral.of(BigInteger.ONE);

	/**
	 * Natural number literal 0 (equivalent to the Boolean literal 'false').
	 */
	public static final NaturalNumberLiteral NUMERICAL_FALSE = NaturalNumberLiteral.of(BigInteger.ZERO);

	private LiteralConsts() { }
}
