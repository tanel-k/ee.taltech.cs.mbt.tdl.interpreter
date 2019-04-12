package ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;

/**
 * Represents a trapset labeling in a TDL source project.<br/>
 * A trapset label is an assignment expression where:
 * <ul>
 *   <li>the LHS is an array access expression that specifies an entry in a trapset flag array;</li>
 *   <li>the RHS is an update function for the specified flag.</li>
 * </ul>
 */
public class TrapsetTransitionLabel {
	public static TrapsetTransitionLabel of(Transition markedTransition, AssignmentExpression originExpression) {
		return new TrapsetTransitionLabel(markedTransition, originExpression);
	}

	private Transition markedTransition;
	private AssignmentExpression originExpression;

	public AssignmentExpression getOriginExpression() {
		return originExpression;
	}

	public Transition getMarkedTransition() {
		return markedTransition;
	}

	private TrapsetTransitionLabel(Transition markedTransition, AssignmentExpression originExpression) {
		this.markedTransition = markedTransition;
		this.originExpression = originExpression;
	}

	@Override
	public String toString() {
		String sourceId = markedTransition.getSource().getId();
		String targetId = markedTransition.getTarget().getId();
		String exprStr = originExpression.toString();
		return getClass().getSimpleName() + "(" + sourceId + "->" + targetId + ";" + exprStr + ")";
	}
}
