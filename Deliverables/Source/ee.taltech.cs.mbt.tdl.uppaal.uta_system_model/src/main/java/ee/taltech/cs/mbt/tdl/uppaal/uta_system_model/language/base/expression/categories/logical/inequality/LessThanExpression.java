package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.inequality;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsBinaryExpression;

public class LessThanExpression extends AbsBinaryExpression {
	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}
}
