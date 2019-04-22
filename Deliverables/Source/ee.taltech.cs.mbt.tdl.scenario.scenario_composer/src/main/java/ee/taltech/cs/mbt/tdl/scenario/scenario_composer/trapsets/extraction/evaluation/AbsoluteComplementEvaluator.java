package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.extraction.evaluation;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.extraction.evaluation.generic.AbsTrapsetExpressionEvaluator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.evaluated.AbsoluteComplementTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.generic.AbsEvaluatedTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.NegationExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.LiteralConsts;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;

import java.util.Map;

public class AbsoluteComplementEvaluator extends AbsTrapsetExpressionEvaluator<AbsoluteComplementNode> {
	private static final String ABSOLUTE_COMPLEMENT_NAME_MODIFIER = "AbsoluteComplementOf_";

	public static AbsoluteComplementEvaluator getInstance(
			UtaSystem system,
			AbsoluteComplementNode trapsetDerivingNode,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		return new AbsoluteComplementEvaluator(system, trapsetDerivingNode, baseTrapsetMap);
	}

	protected AbsoluteComplementEvaluator(
			UtaSystem system,
			AbsoluteComplementNode trapsetDerivingNode,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		super(system, trapsetDerivingNode, baseTrapsetMap);
	}

	@Override
	protected AbsEvaluatedTrapset evaluate(
			UtaSystem system,
			AbsoluteComplementNode absoluteComplement,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		BaseTrapset excludedTrapset = baseTrapsetMap.get(absoluteComplement.getChildContainer().getChild());
		Identifier trapsetName = Identifier.of(
				ABSOLUTE_COMPLEMENT_NAME_MODIFIER + excludedTrapset.getName()
		);
		AbsoluteComplementTrapset resultTrapset = new AbsoluteComplementTrapset();
		resultTrapset.setName(trapsetName);

		for (Template parentTemplate : system.getTemplates()) {
			for (Transition candidateTransition : parentTemplate.getLocationGraph().getEdges()) {
				AssignmentExpression markerExpression;
				if (excludedTrapset.contains(candidateTransition)) {
					// In excludedTrapset, check if conditionally:
					if (!excludedTrapset.isConditional(candidateTransition))
						continue;

					// Whenever the condition doesn't hold the transition is not trapped:
					markerExpression = (AssignmentExpression) new AssignmentExpression()
							.setLeftChild(IdentifierExpression.of(trapsetName))
							.setRightChild(new NegationExpression()
									.setChild(excludedTrapset.getMarkerCondition(candidateTransition).deepClone())
							);
				} else {
					// Definitely outside of excludedTrapset.
					markerExpression = (AssignmentExpression) new AssignmentExpression()
							.setLeftChild(IdentifierExpression.of(trapsetName))
							.setRightChild(LiteralConsts.TRUE);
				}
				resultTrapset.addTrap(
						BaseTrap.of(parentTemplate, candidateTransition, markerExpression)
				);
			}
		}

		return resultTrapset;
	}
}
