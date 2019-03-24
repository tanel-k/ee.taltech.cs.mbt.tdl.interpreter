package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.initializer;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.initializer.visitation.IInitializerVisitor;

/**
 * Represents a flat UPPAAL variable initializer ({@link AbsExpression}.<br/>
 * Example: <i>bool b = true;</i>
 */
public class FlatInitializer extends AbsInitializer {
	private AbsExpression expression;

	public AbsExpression getExpression() {
		return expression;
	}

	public void setExpression(AbsExpression expression) {
		this.expression = expression;
	}

	@Override
	public <T> T accept(IInitializerVisitor<T> visitor) {
		return visitor.visitFlatInitializer(this);
	}
}
