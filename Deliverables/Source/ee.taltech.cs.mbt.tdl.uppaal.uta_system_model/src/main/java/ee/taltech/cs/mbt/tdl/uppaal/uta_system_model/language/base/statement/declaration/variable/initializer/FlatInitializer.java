package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable.initializer;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable.initializer.visitation.IInitializerVisitor;

public class FlatInitializer extends AbsInitializer {
	private AbsExpression expression;

	public AbsExpression getExpression() {
		return expression;
	}

	public void setExpression(AbsExpression expression) {
		this.expression = expression;
	}

	@Override
	void accept(IInitializerVisitor visitor) {
		visitor.visitFlatInitializer(this);
	}
}
