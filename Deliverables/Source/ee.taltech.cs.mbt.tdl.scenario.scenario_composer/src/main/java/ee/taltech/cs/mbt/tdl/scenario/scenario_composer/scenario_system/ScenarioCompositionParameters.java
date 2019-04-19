package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.AbsDerivedTrapset;

import java.util.LinkedHashMap;
import java.util.Map;

public class ScenarioCompositionParameters {
	private TdlExpression tdlExpression;
	private Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> derivedTrapsetMap = new LinkedHashMap<>();

	public Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> getDerivedTrapsetMap() {
		return derivedTrapsetMap;
	}

	public ScenarioCompositionParameters setDerivedTrapsetMap(Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> derivedTrapsetMap) {
		this.derivedTrapsetMap = derivedTrapsetMap;
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
