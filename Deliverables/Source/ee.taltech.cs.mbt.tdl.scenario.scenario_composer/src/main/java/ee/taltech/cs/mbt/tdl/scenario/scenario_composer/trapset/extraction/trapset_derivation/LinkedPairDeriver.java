package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.extraction.trapset_derivation;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.extraction.trapset_derivation.generic.AbsTrapsetDeriver;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.derived.LinkedPairTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.LinkedPairTrap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;

import java.util.Map;
import java.util.Set;

public class LinkedPairDeriver extends AbsTrapsetDeriver<LinkedPairNode> {
	private static final String LINKED_PAIR_NAME_MODIFIER = "_LinkedPairsWith_";

	public static LinkedPairDeriver getInstance(
			UtaSystem system,
			LinkedPairNode trapsetDerivingNode,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		return new LinkedPairDeriver(system, trapsetDerivingNode, baseTrapsetMap);
	}

	private LinkedPairDeriver(
			UtaSystem system,
			LinkedPairNode trapsetDerivingNode,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		super(system, trapsetDerivingNode, baseTrapsetMap);
	}

	@Override
	protected AbsDerivedTrapset derive(
			UtaSystem system,
			LinkedPairNode linkedPair,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		TrapsetNode leftTrapsetNode = linkedPair.getChildContainer().getLeftChild();
		TrapsetNode rightTrapsetNode = linkedPair.getChildContainer().getRightChild();

		BaseTrapset ingressTrapset = baseTrapsetMap.get(leftTrapsetNode);
		BaseTrapset egressTrapset = baseTrapsetMap.get(rightTrapsetNode);

		Identifier trapsetName = Identifier.of(
				ingressTrapset.getName() + LINKED_PAIR_NAME_MODIFIER + egressTrapset.getName()
		);
		LinkedPairTrapset derivedTrapset = new LinkedPairTrapset();
		derivedTrapset.setName(trapsetName);

		// -ingressTransition- L -egressTransition-
		for (Transition ingressTransition : ingressTrapset) {
			Template ingressParentTpl = ingressTrapset.getParentTemplate(ingressTransition);
			Location target = ingressParentTpl.getLocationGraph().getTargetVertex(ingressTransition);
			Set<Transition> egressTransitions = ingressParentTpl.getLocationGraph().getEdgesFrom(target);

			// Check edges leaving the target of the ingress transition:
			for (Transition egressTransition : egressTransitions) {
				if (!egressTrapset.contains(egressTransition))
					continue;

				AssignmentExpression markerExpression = (AssignmentExpression) new AssignmentExpression()
						.setLeftChild(IdentifierExpression.of(trapsetName))
						.setRightChild(egressTrapset.getMarkerCondition(egressTransition).deepClone());
				derivedTrapset.addTrap(LinkedPairTrap.of(
						ingressTrapset, ingressTransition, ingressParentTpl, egressTransition, markerExpression
				));
			}
		}

		return derivedTrapset;
	}
}
