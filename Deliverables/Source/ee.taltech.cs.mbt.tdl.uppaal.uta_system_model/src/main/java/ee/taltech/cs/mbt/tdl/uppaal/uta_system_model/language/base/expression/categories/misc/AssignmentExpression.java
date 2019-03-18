package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsBinaryExpression;

public class AssignmentExpression extends AbsBinaryExpression {
	public AssignmentExpression() { }

	@Override
	public Associativity getAssociativity() {
		return Associativity.RIGHT;
	}
}
