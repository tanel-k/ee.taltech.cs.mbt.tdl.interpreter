package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.sections.template.transition;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

import java.util.LinkedList;
import java.util.List;

public class UTATransitionUpdateList {
	private List<AbsExpression> assignments;

	public UTATransitionUpdateList() {
		this.assignments = new LinkedList<>();
	}

	public List<AbsExpression> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<AbsExpression> assignments) {
		this.assignments = assignments;
	}
}
