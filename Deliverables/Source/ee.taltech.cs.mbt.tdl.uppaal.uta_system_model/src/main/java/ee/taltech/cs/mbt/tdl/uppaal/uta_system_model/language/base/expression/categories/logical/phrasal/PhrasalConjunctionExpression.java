package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.logical.phrasal;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsBinaryExpression;

public class PhrasalConjunctionExpression extends AbsBinaryExpression {
	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}
}
