package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.literals;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.traversal.IExpressionVisitor;

import java.math.BigInteger;

public class NaturalNumberLiteral extends AbsLiteralExpression<BigInteger> {
	NaturalNumberLiteral(BigInteger value) {
		super(value);
	}

	@Override
	public void accept(IExpressionVisitor visitor) {
		visitor.visitNaturalNumber(this);
	}
}
