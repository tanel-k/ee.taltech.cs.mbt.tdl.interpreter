package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.trap;

import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.BaseTrapset;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.transitions.Transition;

public class LinkedPairTrap extends BaseTrap {
	public static LinkedPairTrap of(
			BaseTrapset ingressTrapset,
			Transition ingressTransition,
			Template parentTemplate,
			Transition transition,
			AssignmentExpression markerAssignment
	) {
		return new LinkedPairTrap(ingressTrapset, ingressTransition, parentTemplate, transition, markerAssignment);
	}

	private BaseTrapset ingressTrapset;
	private Transition ingressTransition;

	protected LinkedPairTrap(
			BaseTrapset ingressTrapset,
			Transition ingressTransition,
			Template parentTemplate,
			Transition transition,
			AssignmentExpression markerAssignment
	) {
		super(parentTemplate, transition, markerAssignment);
		this.ingressTrapset = ingressTrapset;
		this.ingressTransition = ingressTransition;
	}

	public BaseTrapset getIngressTrapset() {
		return ingressTrapset;
	}

	public Transition getIngressTransition() {
		return ingressTransition;
	}
}
