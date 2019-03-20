package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.array_modifier;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.array_modifier.visitation.IArrayModifierVisitor;

public class SizeExpressionArrayModifier extends AbsArrayModifier<AbsExpression> {
	@Override
	public void accept(IArrayModifierVisitor arrayModifierVisitor) {
		arrayModifierVisitor.visitSizeExpressionModifier(this);
	}
}
