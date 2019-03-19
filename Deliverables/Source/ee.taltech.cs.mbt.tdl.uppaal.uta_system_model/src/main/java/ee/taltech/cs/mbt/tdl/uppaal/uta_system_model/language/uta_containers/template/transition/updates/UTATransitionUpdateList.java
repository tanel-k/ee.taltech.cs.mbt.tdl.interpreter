package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.uta_containers.template.transition.updates;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

import java.util.LinkedList;
import java.util.List;

public class UTATransitionUpdateList {
	private List<AbsExpression> assignments = new LinkedList<>();;

	public List<AbsExpression> getAssignments() {
		return assignments;
	}
}
