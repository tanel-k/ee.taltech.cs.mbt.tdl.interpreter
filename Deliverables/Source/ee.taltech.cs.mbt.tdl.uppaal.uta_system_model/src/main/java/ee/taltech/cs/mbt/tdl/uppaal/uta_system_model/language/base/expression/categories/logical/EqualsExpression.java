package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsBinaryExpression;

public class EqualsExpression extends AbsBinaryExpression {
	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}
}
