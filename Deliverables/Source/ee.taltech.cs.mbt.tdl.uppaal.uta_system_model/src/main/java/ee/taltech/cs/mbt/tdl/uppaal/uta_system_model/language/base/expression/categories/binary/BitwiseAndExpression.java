package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.categories.binary;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.internal.AbsBinaryExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.IHasAssignmentCounterpart;

public class BitwiseAndExpression extends AbsBinaryExpression implements IHasAssignmentCounterpart {
	@Override
	public Associativity getAssociativity() {
		return Associativity.LEFT;
	}
}
