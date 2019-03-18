package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsTernaryExpression;

public class IfElseExpression extends AbsTernaryExpression {
	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}
}
