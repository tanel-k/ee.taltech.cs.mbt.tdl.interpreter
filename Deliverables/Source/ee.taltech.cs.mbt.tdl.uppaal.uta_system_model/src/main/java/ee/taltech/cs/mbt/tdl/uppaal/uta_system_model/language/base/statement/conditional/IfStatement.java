package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.conditional;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.AbsStatement;

public class IfStatement {
	private AbsExpression conditionExpression;

	private AbsStatement primaryStatement;
	private AbsStatement alternativeStatement;

	public IfStatement() { }

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
}
