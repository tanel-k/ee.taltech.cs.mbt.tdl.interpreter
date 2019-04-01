package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IInitializerVisitor;

/**
 * Represents a flat UPPAAL variable initializer ({@link AbsExpression}.<br/>
 * Example: <i>bool b = true;</i>
 */
public class FlatVariableInitializer extends AbsVariableInitializer {
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