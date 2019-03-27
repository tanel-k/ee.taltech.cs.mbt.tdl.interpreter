package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.conditional;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.declaration.function.statement.IStatementVisitor;

/**
 * Represents an UPPAAL 'If'-statement.<br/>
 * Syntax:<br/>
 * <pre>
 * IfStatment ::= 'if' '(' Expression ')' Statement [ 'else' Statement ]
 * </pre>
 */
public class ConditionalStatement extends AbsStatement {
	private AbsExpression conditionExpression;

	private AbsStatement primaryStatement;
	private AbsStatement alternativeStatement;

	public ConditionalStatement() { }

	public AbsExpression getConditionExpression() {
		return conditionExpression;
	}

	public void setConditionExpression(AbsExpression conditionExpression) {
		this.conditionExpression = conditionExpression;
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
		return visitor.visitConditional(this);
	}
}
