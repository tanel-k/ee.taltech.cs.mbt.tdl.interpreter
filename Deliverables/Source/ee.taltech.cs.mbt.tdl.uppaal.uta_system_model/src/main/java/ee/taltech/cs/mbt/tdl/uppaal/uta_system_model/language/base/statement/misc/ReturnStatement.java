package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.visitation.IStatementVisitor;

/**
 * Represents a return statement (for both `void`- and value-functions).<br/>
 * Syntax:<br/>
 * <pre>
 * ReturnStatement ::= 'return' [ Expression ] ';'
 * </pre>
 */
public class ReturnStatement extends AbsStatement {
	private AbsExpression returnExpression;

	public ReturnStatement() { }

	public AbsExpression getExpression() {
		return returnExpression;
	}

	public void setExpression(AbsExpression returnExpression) {
		this.returnExpression = returnExpression;
	}

	@Override
	public void accept(IStatementVisitor visitor) {
		visitor.visitReturn(this);
	}
}
