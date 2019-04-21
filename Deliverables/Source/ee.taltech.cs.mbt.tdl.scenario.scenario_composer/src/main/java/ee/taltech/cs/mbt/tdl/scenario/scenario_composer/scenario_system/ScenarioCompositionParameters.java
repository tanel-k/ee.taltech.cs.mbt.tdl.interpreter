package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScenarioCompositionParameters {
	private UtaSystem sutModel;
	private TdlExpression tdlExpression;
	private Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> derivedTrapsetMap;

	public UtaSystem getSutModel() {
		return sutModel;
	}

	public ScenarioCompositionParameters setSutModel(UtaSystem sutModel) {
		this.sutModel = sutModel;
		return this;
	}

	public Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> getDerivedTrapsetMap() {
		return derivedTrapsetMap;
	}

	public ScenarioCompositionParameters setDerivedTrapsetMap(Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> derivedTrapsetMap) {
		this.derivedTrapsetMap = Collections.unmodifiableMap(derivedTrapsetMap);
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
