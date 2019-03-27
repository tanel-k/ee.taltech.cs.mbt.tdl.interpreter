package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.IStatementVisitor;

/**
 * Represents an expression being used as a statement
 * (generally either a plain assignment or an assignment operation).<br/>
 * Syntax:<br/>
 * <pre>
 * Statement       ::= ...
 *                  |  Expression ';'
 *                  | ...
 * </pre>
 */
public class ExpressionStatement extends AbsStatement {
	private AbsExpression expression;

	public ExpressionStatement() { }

	public AbsExpression getExpression() {
		return expression;
	}

	public void setExpression(AbsExpression expression) {
		this.expression = expression;
	}

	@Override
	public <T> T accept(IStatementVisitor<T> visitor) {
		return visitor.visitExpression(this);
	}
}
