package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_size_modifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IArrayModifierVisitor;

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
