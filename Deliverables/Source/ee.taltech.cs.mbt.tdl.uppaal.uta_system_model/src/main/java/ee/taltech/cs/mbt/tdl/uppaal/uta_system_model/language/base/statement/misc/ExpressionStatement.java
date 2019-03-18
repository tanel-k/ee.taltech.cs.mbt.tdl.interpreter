package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.AbsStatement;

public class ExpressionStatement extends AbsStatement {
	private AbsExpression expression;

	public ExpressionStatement() { }

	public AbsExpression getExpression() {
		return expression;
	}

	public void setExpression(AbsExpression expression) {
		this.expression = expression;
	}
}
