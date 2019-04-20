package ee.taltech.cs.mbt.tdl.scenario.scenario_composer;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.TdlExpressionReducer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.TrapsetQuantifierEvaluator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system.ScenarioCompositionParameters;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system.ScenarioSystemComposer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.extraction.BaseTrapsetsExtractor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.extraction.DerivedTrapsetsExtractor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.util.Map;

public class ScenarioComposer {
	public static ScenarioComposer newInstance(ScenarioSpecification specification) {
		return new ScenarioComposer(specification);
	}

	private ScenarioSpecification specification;

	private ScenarioComposer(ScenarioSpecification specification) {
		this.specification = specification;
	}

	public UtaSystem compose() {
		TdlExpression tdlExpression = specification
				.getTdlExpression()
				.deepClone();
		UtaSystem sutModel = specification
				.getSutModel()
				.deepClone();

		Map<TrapsetNode, BaseTrapset> baseTrapsetMap = BaseTrapsetsExtractor
				.getInstance(sutModel, tdlExpression)
				.extract();
		Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> mapDerivedTrapsets = DerivedTrapsetsExtractor
				.getInstance(sutModel, tdlExpression, baseTrapsetMap)
				.extract();

		// Replace immediately evaluable trapset quantifiers:
		TrapsetQuantifierEvaluator
				.getInstance(sutModel, tdlExpression, mapDerivedTrapsets)
				.evaluate();

		// Normalize the TDL expression and process True/False nodes:
		TdlExpressionReducer
				.getInstance(tdlExpression)
				.reduce();

		if (tdlExpression.getRootNode() instanceof BooleanValueWrapperNode) {
			// TODO: entire tree has been reduced.
		}

		// Compose SUT model and TDL recognition wrapper:
		ScenarioCompositionParameters compositionParameters = new ScenarioCompositionParameters()
				.setSutModel(sutModel)
				.setTdlExpression(tdlExpression)
				.setDerivedTrapsetMap(mapDerivedTrapsets);
		ScenarioSystemComposer
				.newInstance(compositionParameters)
				.compose();

		return sutModel;
	}
}
