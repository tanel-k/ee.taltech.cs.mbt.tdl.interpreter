package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.evaluation.impl;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.LinkedPairsNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.evaluation.AbsTrapsetExpressionEvaluator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.base.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.impl.LinkedPairsTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.AbsTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.LinkedPairTrap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.transitions.Transition;

import java.util.Map;
import java.util.Set;

public class LinkedPairsEvaluator extends AbsTrapsetExpressionEvaluator<LinkedPairsNode> {
	private static final String LINKED_PAIR_NAME_MODIFIER = "_LinkedPairsWith_";

	public static LinkedPairsEvaluator getInstance(
			UtaSystem system,
			LinkedPairsNode trapsetDerivingNode,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		return new LinkedPairsEvaluator(system, trapsetDerivingNode, baseTrapsetMap);
	}

	private LinkedPairsEvaluator(
			UtaSystem system,
			LinkedPairsNode trapsetDerivingNode,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		super(system, trapsetDerivingNode, baseTrapsetMap);
	}

	@Override
	protected AbsTrapsetEvaluation evaluate(
			UtaSystem system,
			LinkedPairsNode linkedPairs,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		TrapsetNode leftTrapsetNode = linkedPairs.getChildContainer().getLeftChild();
		TrapsetNode rightTrapsetNode = linkedPairs.getChildContainer().getRightChild();

		BaseTrapset ingressTrapset = baseTrapsetMap.get(leftTrapsetNode);
		BaseTrapset egressTrapset = baseTrapsetMap.get(rightTrapsetNode);

		Identifier trapsetName = Identifier.of(
				ingressTrapset.getName() + LINKED_PAIR_NAME_MODIFIER + egressTrapset.getName()
		);
		LinkedPairsTrapsetEvaluation resultTrapset = new LinkedPairsTrapsetEvaluation();
		resultTrapset.setName(trapsetName);

		// -ingressTransition- L -egressTransition-
		for (Transition ingressTransition : ingressTrapset) {
			Template ingressParentTpl = ingressTrapset.getParentTemplate(ingressTransition);
			Location target = ingressParentTpl.getLocationGraph().getTargetVertex(ingressTransition);
			Set<Transition> egressTransitionCandidates = ingressParentTpl.getLocationGraph().getEdgesFrom(target);

			// Check edges leaving the target of the ingress transition:
			for (Transition egressTransition : egressTransitionCandidates) {
				if (egressTransition == ingressTransition)
					continue; // Loop corner-case.
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
