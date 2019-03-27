package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.IStatementVisitor;

/**
 * Represents the UPPAAL for (... ;... ;...){...} loop.<br/>
 * Syntax:<br/>
 * <pre>
 * ForLoop ::= 'for' '(' Expression ';' Expression ';' Expression ')' Statement
 * </pre>
 */
public class ForLoop extends AbsConditionalLoopStatement{
	private AbsExpression initializer;
	private AbsExpression update;

	public AbsExpression getInitializer() {
		return initializer;
	}

	public void setInitializer(AbsExpression initializer) {
		this.initializer = initializer;
	}

	public AbsExpression getUpdate() {
		return update;
	}

	public void setUpdate(AbsExpression update) {
		this.update = update;
	}

	@Override
	public <T> T accept(IStatementVisitor<T> visitor) {
		return visitor.visitFor(this);
	}
}
