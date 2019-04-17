package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.generic.AbsDerivedTrapset;

import java.util.LinkedHashMap;
import java.util.Map;

public class ScenarioCompositionParameters {
	private TdlExpression expression;
	private Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> derivedTrapsetMap = new LinkedHashMap<>();

	public Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> getDerivedTrapsetMap() {
		return derivedTrapsetMap;
	}

	public ScenarioCompositionParameters setDerivedTrapsetMap(Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> derivedTrapsetMap) {
		this.derivedTrapsetMap = derivedTrapsetMap;
		return this;
	}

	public TdlExpression getExpression() {
		return expression;
	}

	public ScenarioCompositionParameters setExpression(TdlExpression expression) {
		this.expression = expression;
		return this;
	}
}
