package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.conditional;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.AbsStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.traversal.IStatementVisitor;

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
	public void accept(IStatementVisitor visitor) {
		visitor.visitConditional(this);
	}
}
