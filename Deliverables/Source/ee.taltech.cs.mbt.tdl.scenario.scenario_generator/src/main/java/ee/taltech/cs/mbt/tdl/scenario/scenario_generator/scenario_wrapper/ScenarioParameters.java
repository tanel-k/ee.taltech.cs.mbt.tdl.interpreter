package ee.taltech.cs.mbt.tdl.scenario.scenario_generator.scenario_wrapper;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset.generic.AbsDerivedTrapset;

import java.util.LinkedHashMap;
import java.util.Map;

public class ScenarioParameters {
	private TdlExpression reducedExpression;
	private Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> derivedTrapsetMap = new LinkedHashMap<>();

	public Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> getDerivedTrapsetMap() {
		return derivedTrapsetMap;
	}

	public ScenarioParameters setDerivedTrapsetMap(Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> derivedTrapsetMap) {
		this.derivedTrapsetMap.putAll(derivedTrapsetMap);
		return this;
	}

	public TdlExpression getReducedExpression() {
		return reducedExpression;
	}

	public ScenarioParameters setReducedExpression(TdlExpression reducedExpression) {
		this.reducedExpression = reducedExpression;
		return this;
	}
}
