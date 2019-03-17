package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.categories.logical.inequality;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_language_model.expression.generic.internal.AbsBinaryExpression;

public class LTEExpression extends AbsBinaryExpression {
	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}
}
