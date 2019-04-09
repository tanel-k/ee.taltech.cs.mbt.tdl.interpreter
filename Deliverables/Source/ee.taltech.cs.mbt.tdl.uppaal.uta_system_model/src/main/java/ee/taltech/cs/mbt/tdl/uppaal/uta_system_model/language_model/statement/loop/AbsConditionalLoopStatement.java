package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.loop;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;

/**
 * Represents UPPAAL loop statements which have a loop condition.<br/>
 * All loop statements except {@link IterationLoop} are in this class.
 */
public abstract class AbsConditionalLoopStatement extends AbsLoopStatement {
	private AbsExpression condition;

	public AbsExpression getCondition() {
		return condition;
	}

	public AbsConditionalLoopStatement setCondition(AbsExpression condition) {
		this.condition = condition;
		return this;
	}
}
