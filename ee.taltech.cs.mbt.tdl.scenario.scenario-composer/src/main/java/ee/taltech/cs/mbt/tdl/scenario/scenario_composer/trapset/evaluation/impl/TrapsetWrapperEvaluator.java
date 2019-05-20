package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.evaluation.impl;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.TrapsetWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.evaluation.AbsTrapsetExpressionEvaluator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.base.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.impl.WrappedTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.AbsTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.transitions.Transition;

import java.util.Map;

public class TrapsetWrapperEvaluator extends AbsTrapsetExpressionEvaluator<TrapsetWrapperNode> {
	public static TrapsetWrapperEvaluator getInstance(
			UtaSystem system,
			TrapsetWrapperNode trapsetDerivingNode,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		return new TrapsetWrapperEvaluator(system, trapsetDerivingNode, baseTrapsetMap);
	}

	protected TrapsetWrapperEvaluator(UtaSystem system, TrapsetWrapperNode trapsetDerivingNode, Map<TrapsetNode, BaseTrapset> baseTrapsetMap) {
		super(system, trapsetDerivingNode, baseTrapsetMap);
	}

	@Override
	protected AbsTrapsetEvaluation evaluate(UtaSystem system, TrapsetWrapperNode trapsetWrapper, Map<TrapsetNode, BaseTrapset> baseTrapsetMap) {
		BaseTrapset wrappedTrapset = baseTrapsetMap.get(trapsetWrapper.getChildContainer().getChild());
		Identifier trapsetName = wrappedTrapset.getName();
		WrappedTrapsetEvaluation resultTrapset = new WrappedTrapsetEvaluation();
		resultTrapset.setName(trapsetName);

		for (Transition transition : wrappedTrapset) {
			AssignmentExpression markerExpression = (AssignmentExpression) new AssignmentExpression()
					.setLeftChild(IdentifierExpression.of(trapsetName))
					.setRightChild(wrappedTrapset.getMarkerCondition(transition).deepClone());
			resultTrapset.addTrap(BaseTrap.of(wrappedTrapset.getParentTemplate(transition), transition, markerExpression));
		}

		return resultTrapset;
	}
}
