package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.visitation.IStatementVisitor;

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
	public void accept(IStatementVisitor visitor) {
		visitor.visitExpression(this);
	}
}
