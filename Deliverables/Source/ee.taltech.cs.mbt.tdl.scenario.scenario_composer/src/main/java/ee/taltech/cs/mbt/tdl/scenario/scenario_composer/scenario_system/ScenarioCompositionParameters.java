package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.generic.AbsEvaluatedTrapset;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;

import java.util.Collections;
import java.util.Map;

public class ScenarioCompositionParameters {
	private UtaSystem sutModel;
	private TdlExpression tdlExpression;
	private Map<AbsTrapsetExpressionNode, AbsEvaluatedTrapset> trapsetEvaluationMap;

	public UtaSystem getSutModel() {
		return sutModel;
	}

	public ScenarioCompositionParameters setSutModel(UtaSystem sutModel) {
		this.sutModel = sutModel;
		return this;
	}

	public Map<AbsTrapsetExpressionNode, AbsEvaluatedTrapset> getTrapsetEvaluationMap() {
		return trapsetEvaluationMap;
	}

	public ScenarioCompositionParameters setTrapsetEvaluationMap(Map<AbsTrapsetExpressionNode, AbsEvaluatedTrapset> trapsetEvaluationMap) {
		this.trapsetEvaluationMap = Collections.unmodifiableMap(trapsetEvaluationMap);
		return this;
	}

	public TdlExpression getTdlExpression() {
		return tdlExpression;
	}

	public ScenarioCompositionParameters setTdlExpression(TdlExpression expression) {
		this.tdlExpression = expression;
		return this;
	}
}
