package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IStatementVisitor;

/**
 * Represents an UPPAAL 'If'-statement.<br/>
 * Syntax:<br/>
 * <pre>
 * IfStatment ::= 'if' '(' Expression ')' Statement [ 'else' Statement ]
 * </pre>
 */
public class ConditionalStatement extends AbsStatement {
	private AbsExpression condition;

	private AbsStatement primaryStatement;
	private AbsStatement alternativeStatement;

	public ConditionalStatement() { }

	public AbsExpression getCondition() {
		return condition;
	}

	public void setCondition(AbsExpression condition) {
		this.condition = condition;
	}

	public AbsStatement getPrimaryStatement() {
		return primaryStatement;
	}

	public void setPrimaryStatement(AbsStatement primaryStatement) {
		this.primaryStatement = primaryStatement;
	}

	public AbsStatement getAlternativeStatement() {
		return alternativeStatement;
	}

	public void setAlternativeStatement(AbsStatement alternativeStatement) {
		this.alternativeStatement = alternativeStatement;
	}

	@Override
	public <T> T accept(IStatementVisitor<T> visitor) {
		return visitor.visitConditionalStatement(this);
	}
}
