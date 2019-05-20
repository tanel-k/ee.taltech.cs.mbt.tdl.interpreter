package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IArrayModifierVisitor;

/**
 * An {@link AbsArrayModifier} that specifies the array size using an expression.
 */
public class SizeExpressionArrayModifier extends AbsArrayModifier<AbsExpression> {
	@Override
	public <T> T accept(IArrayModifierVisitor<T> visitor) {
		return visitor.visitSizeExpressionModifier(this);
	}

	@Override
	public SizeExpressionArrayModifier deepClone() {
		SizeExpressionArrayModifier clone = new SizeExpressionArrayModifier();
		clone.setSizeSpecifier(getSizeSpecifier().deepClone());
		return clone;
	}
}
