package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.literals;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.leaf.AbsLeafExpression;

import java.util.Objects;

/**
 * Represents leaf nodes that are literals.
 * @param <RepresentationType>
 * Java type used for the representation of the leaf node inside this beam.
 */
public abstract class AbsLiteralExpression<RepresentationType> extends AbsLeafExpression {
	private RepresentationType representation;

	public AbsLiteralExpression(RepresentationType representation) {
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
		if (!(obj instanceof AbsLiteralExpression))
			return false;
		AbsLiteralExpression other = (AbsLiteralExpression) obj;
		return Objects.equals(other.representation, this.representation);
	}
}
