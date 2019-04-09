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

	public ConditionalStatement setCondition(AbsExpression condition) {
		this.condition = condition;
		return this;
	}

	public AbsStatement getPrimaryStatement() {
		return primaryStatement;
	}

	public ConditionalStatement setPrimaryStatement(AbsStatement primaryStatement) {
		this.primaryStatement = primaryStatement;
		return this;
	}

	public AbsStatement getAlternativeStatement() {
		return alternativeStatement;
	}

	public ConditionalStatement setAlternativeStatement(AbsStatement alternativeStatement) {
		this.alternativeStatement = alternativeStatement;
		return this;
	}

	@Override
	public <T> T accept(IStatementVisitor<T> visitor) {
		return visitor.visitConditionalStatement(this);
	}
}
