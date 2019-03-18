package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

public abstract class AbsConditionalLoopStatement extends AbsLoopStatement {
	private AbsExpression loopCondition;

	public AbsExpression getLoopCondition() {
		return loopCondition;
	}

	public void setLoopCondition(AbsExpression loopCondition) {
		this.loopCondition = loopCondition;
	}
}
