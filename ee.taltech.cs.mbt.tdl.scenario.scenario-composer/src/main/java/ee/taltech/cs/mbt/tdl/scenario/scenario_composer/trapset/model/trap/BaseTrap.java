package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap;

import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.transitions.Transition;

public class BaseTrap {
	public static BaseTrap of(Template parentTemplate, Transition transition, AssignmentExpression markerAssignment) {
		return new BaseTrap(parentTemplate, transition, markerAssignment);
	}

	private Template parentTemplate;
	private Transition transition;
	private AssignmentExpression markerAssignment;

	protected BaseTrap(Template parentTemplate, Transition transition, AssignmentExpression markerAssignment) {
		this.parentTemplate = parentTemplate;
		this.transition = transition;
		this.markerAssignment = markerAssignment;
	}

	public Template getParentTemplate() {
		return parentTemplate;
	}

	public Transition getTransition() {
		return transition;
	}

	public AssignmentExpression getMarkerAssignment() {
		return markerAssignment;
	}
}
