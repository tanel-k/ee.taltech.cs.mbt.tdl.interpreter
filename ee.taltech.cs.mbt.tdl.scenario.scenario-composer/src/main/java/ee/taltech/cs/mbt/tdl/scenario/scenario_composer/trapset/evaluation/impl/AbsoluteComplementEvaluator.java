package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.evaluation.impl;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.evaluation.AbsTrapsetExpressionEvaluator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.utils.UTAExpressionUtils;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.base.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.impl.AbsoluteComplementTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.AbsTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.LiteralConsts;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.transitions.Transition;

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
	protected AbsTrapsetEvaluation evaluate(
			UtaSystem system,
			AbsoluteComplementNode absoluteComplement,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		BaseTrapset excludedTrapset = baseTrapsetMap.get(absoluteComplement.getChildContainer().getChild());
		Identifier trapsetName = Identifier.of(
				ABSOLUTE_COMPLEMENT_NAME_MODIFIER + excludedTrapset.getName()
		);
		AbsoluteComplementTrapsetEvaluation resultTrapset = new AbsoluteComplementTrapsetEvaluation();
		resultTrapset.setName(trapsetName);

		for (Template template : system.getTemplates()) {
			for (Transition candidateTransition : template.getLocationGraph().getEdges()) {
				AssignmentExpression markerExpression;
				if (excludedTrapset.contains(candidateTransition)) {
					// In excludedTrapset, check if conditionally:
					if (!excludedTrapset.isConditional(candidateTransition))
						continue;

					// Whenever the condition doesn't hold the transition is not trapped:
					markerExpression = (AssignmentExpression) new AssignmentExpression()
							.setLeftChild(IdentifierExpression.of(trapsetName))
							.setRightChild(UTAExpressionUtils.negateCondition(
									excludedTrapset.getMarkerCondition(candidateTransition).deepClone()
							));
				} else {
					// Definitely outside of excludedTrapset.
					markerExpression = (AssignmentExpression) new AssignmentExpression()
							.setLeftChild(IdentifierExpression.of(trapsetName))
							.setRightChild(LiteralConsts.TRUE);
				}
				resultTrapset.addTrap(
						BaseTrap.of(template, candidateTransition, markerExpression)
				);
			}
		}

		return resultTrapset;
	}
}
