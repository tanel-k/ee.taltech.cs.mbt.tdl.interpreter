package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

/**
 * Represents UPPAAL loop statements which have a loop condition.<br/>
 * All loop statements except {@link IterationLoop} are in this class.
 */
public abstract class AbsConditionalLoopStatement extends AbsLoopStatement {
	private AbsExpression loopCondition;

	public AbsExpression getLoopCondition() {
		return loopCondition;
	}

	public void setLoopCondition(AbsExpression loopCondition) {
		this.loopCondition = loopCondition;
	}
}
