package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.categories.literals;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.generic.leaf.AbsLeafExpression;

import java.util.Objects;

public class LiteralExpression<RepresentationType> extends AbsLeafExpression {
	private RepresentationType representation;

	public LiteralExpression(RepresentationType representation) {
		this.representation = representation;
	}

	public RepresentationType getLiteralRepresentation() {
		return representation;
	}

	@Override
	protected int getLocalHash() {
		return Objects.hash(getLiteralRepresentation());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LiteralExpression))
			return false;
		LiteralExpression other = (LiteralExpression) obj;
		return Objects.equals(other.representation, this.representation);
	}
}
