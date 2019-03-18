package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.access;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsBinaryExpression;

public class ArrayLookupExpression extends AbsBinaryExpression {
	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}
}
