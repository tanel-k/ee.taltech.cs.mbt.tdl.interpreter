package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.TdlExpressionReducer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.TrapsetQuantifierEvaluator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system.ScenarioCompositionParameters;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system.ScenarioSystemComposer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.extraction.BaseTrapsetsExtractor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.extraction.BaseTrapsetsExtractor.InvalidBaseTrapsetDefinitionException;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.extraction.DerivedTrapsetsExtractor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.util.Map;
import java.util.Optional;

public class ScenarioComposer {
	public static ScenarioComposer newInstance(ScenarioSpecification specification) {
		return new ScenarioComposer(specification);
	}

	private ScenarioSpecification specification;

	private ScenarioComposer(ScenarioSpecification specification) {
		this.specification = specification;
	}

	public UtaSystem compose() throws InvalidBaseTrapsetDefinitionException /* FIXME */ {
		TdlExpression tdlExpressionCpy = specification
				.getTdlExpression()
				.deepClone();
		UtaSystem sutModelCpy = specification
				.getSutModel()
				.deepClone();

		Map<TrapsetNode, BaseTrapset> baseTrapsetMap = BaseTrapsetsExtractor
				.getInstance(sutModelCpy, tdlExpressionCpy)
				.extract();
		Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> mapDerivedTrapsets = DerivedTrapsetsExtractor
				.getInstance(sutModelCpy, tdlExpressionCpy, baseTrapsetMap)
				.extract();

		/*
		 * NOTE:
		 * At some point we should consider collecting data related to normalization and reduction
		 * in order to present it to the user if required.
		 * We will need an object structure for representing expression tree diffs.
		 */
		// Replace immediately evaluable trapset quantifiers with True/False:
		TrapsetQuantifierEvaluator
				.getInstance(sutModelCpy, tdlExpressionCpy, mapDerivedTrapsets)
				.evaluate();

		// Normalize the TDL expression and pull True/False up the tree according to semantics:
		TdlExpressionReducer
				.getInstance(tdlExpressionCpy)
				.reduce();

		Optional<BooleanValueWrapperNode> optRootBooleanWrapper = tdlExpressionCpy.getRootBooleanWrapper();
		if (optRootBooleanWrapper.isPresent()) {
			// TODO: entire tree has been reduced (throw Exception?).
		}

		// Compose SUT model and TDL recognition wrapper:
		ScenarioCompositionParameters compositionParameters = new ScenarioCompositionParameters()
				.setSutModel(sutModelCpy)
				.setTdlExpression(tdlExpressionCpy)
				.setDerivedTrapsetMap(mapDerivedTrapsets);
		ScenarioSystemComposer
				.newInstance(compositionParameters)
				.compose();

		return sutModelCpy;
	}
}
