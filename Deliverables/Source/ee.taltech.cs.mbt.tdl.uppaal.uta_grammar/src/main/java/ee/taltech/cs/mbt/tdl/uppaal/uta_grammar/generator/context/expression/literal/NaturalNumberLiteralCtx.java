package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.context.expression.literal;

import java.math.BigInteger;

public class NaturalNumberLiteralCtx extends AbsLiteralCtx {
	private BigInteger numberValue;

	public BigInteger getNumberValue() {
		return numberValue;
	}

	public void setNumberValue(BigInteger numberValue) {
		this.numberValue = numberValue;
	}

	@Override
	public <T> T accept(ILiteralVisitor<T> visitor) {
		return visitor.visitNaturalNumberLiteral(this);
	}
}
