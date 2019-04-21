package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.extraction.trapset_derivation;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.extraction.trapset_derivation.generic.AbsTrapsetDeriver;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.derived.RelativeComplementTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.ConjunctionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.NegationExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;

import java.util.Map;

public class RelativeComplementDeriver extends AbsTrapsetDeriver<RelativeComplementNode> {
	private static final String RELATIVE_COMPLEMENT_NAME_MODIFIER = "_RelativeComplementWith_";

	public static RelativeComplementDeriver getInstance(
			UtaSystem system,
			RelativeComplementNode trapsetDerivingNode,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		return new RelativeComplementDeriver(system, trapsetDerivingNode, baseTrapsetMap);
	}

	private RelativeComplementDeriver(
			UtaSystem system,
			RelativeComplementNode trapsetDerivingNode,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		super(system, trapsetDerivingNode, baseTrapsetMap);
	}

	@Override
	protected AbsDerivedTrapset derive(
			UtaSystem system,
			RelativeComplementNode relativeComplement,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		TrapsetNode leftTrapsetNode = relativeComplement.getChildContainer().getLeftChild();
		TrapsetNode rightTrapsetNode = relativeComplement.getChildContainer().getRightChild();

		BaseTrapset includedTrapset = baseTrapsetMap.get(leftTrapsetNode);
		BaseTrapset excludedTrapset = baseTrapsetMap.get(rightTrapsetNode);

		Identifier trapsetName = Identifier.of(
				includedTrapset.getName() + RELATIVE_COMPLEMENT_NAME_MODIFIER + excludedTrapset.getName()
		);
		RelativeComplementTrapset derivedTrapset = new RelativeComplementTrapset();
		derivedTrapset.setName(trapsetName);

		for (Transition includedTransition : includedTrapset) {
			Template parentTemplate = includedTrapset.getParentTemplate(includedTransition);
			AbsExpression conditionExpr = includedTrapset.getMarkerCondition(includedTransition).deepClone();

			if (excludedTrapset.contains(includedTransition)) {
				// As long as the condition doesn't hold, the transition is excluded from excludedTrapset.
				if (!excludedTrapset.isConditional(includedTransition))
					continue;

				// Negate the inclusion expression:
				conditionExpr = new ConjunctionExpression()
						.setLeftChild(conditionExpr)
						.setRightChild(
								new NegationExpression()
										.setChild(excludedTrapset.getMarkerCondition(includedTransition).deepClone())
						);
			}

			AssignmentExpression markerExpr = (AssignmentExpression) new AssignmentExpression()
					.setLeftChild(IdentifierExpression.of(trapsetName))
					.setRightChild(conditionExpr);
			derivedTrapset.addTrap(BaseTrap.of(parentTemplate, includedTransition, markerExpr));
		}

		return derivedTrapset;
	}
}
