package ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IStatementVisitor;

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

	public ForLoop setInitializer(AbsExpression initializer) {
		this.initializer = initializer;
		return this;
	}

	public AbsExpression getUpdate() {
		return update;
	}

	public ForLoop setUpdate(AbsExpression update) {
		this.update = update;
		return this;
	}

	@Override
	public <T> T accept(IStatementVisitor<T> visitor) {
		return visitor.visitForStatement(this);
	}

	@Override
	public ForLoop deepClone() {
		ForLoop clone = new ForLoop();
		clone.initializer = initializer.deepClone();
		clone.update = update.deepClone();
		clone.setCondition(getCondition().deepClone());
		clone.setStatement(getStatement().deepClone());
		return clone;
	}
}
