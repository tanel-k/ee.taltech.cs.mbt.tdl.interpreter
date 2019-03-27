package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.array_modifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic.AbsExpression;

/**
 * An {@link AbsArrayModifier} that specifies the array size using an expression.
 */
public class SizeExpressionArrayModifier extends AbsArrayModifier<AbsExpression> {
	@Override
	public <T> T accept(IArrayModifierVisitor<T> visitor) {
		return visitor.visitSizeExpressionModifier(this);
	}
}
