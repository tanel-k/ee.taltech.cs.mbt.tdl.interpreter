package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.extraction.evaluation;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.extraction.evaluation.generic.AbsTrapsetExpressionEvaluator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.evaluated.LinkedPairTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.generic.AbsEvaluatedTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.trap.LinkedPairTrap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;

import java.util.Map;
import java.util.Set;

public class LinkedPairEvaluator extends AbsTrapsetExpressionEvaluator<LinkedPairNode> {
	private static final String LINKED_PAIR_NAME_MODIFIER = "_LinkedPairsWith_";

	public static LinkedPairEvaluator getInstance(
			UtaSystem system,
			LinkedPairNode trapsetDerivingNode,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		return new LinkedPairEvaluator(system, trapsetDerivingNode, baseTrapsetMap);
	}

	private LinkedPairEvaluator(
			UtaSystem system,
			LinkedPairNode trapsetDerivingNode,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		super(system, trapsetDerivingNode, baseTrapsetMap);
	}

	@Override
	protected AbsEvaluatedTrapset evaluate(
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
		LinkedPairTrapset resultTrapset = new LinkedPairTrapset();
		resultTrapset.setName(trapsetName);

		// -ingressTransition- L -egressTransition-
		for (Transition ingressTransition : ingressTrapset) {
			Template ingressParentTpl = ingressTrapset.getParentTemplate(ingressTransition);
			Location target = ingressParentTpl.getLocationGraph().getTargetVertex(ingressTransition);
			Set<Transition> egressTransitionCandidates = ingressParentTpl.getLocationGraph().getEdgesFrom(target);

			// Check edges leaving the target of the ingress transition:
			for (Transition egressTransition : egressTransitionCandidates) {
				if (!egressTrapset.contains(egressTransition))
					continue;

				AssignmentExpression markerExpression = (AssignmentExpression) new AssignmentExpression()
						.setLeftChild(IdentifierExpression.of(trapsetName))
						.setRightChild(egressTrapset.getMarkerCondition(egressTransition).deepClone());

				resultTrapset.addTrap(LinkedPairTrap.of(
						ingressTrapset, ingressTransition, ingressParentTpl, egressTransition, markerExpression
				));
			}
		}

		return resultTrapset;
	}
}
