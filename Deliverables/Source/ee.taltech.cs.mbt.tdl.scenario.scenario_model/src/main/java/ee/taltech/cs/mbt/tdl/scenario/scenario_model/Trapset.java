package ee.taltech.cs.mbt.tdl.scenario.scenario_model;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location;

import java.util.LinkedHashMap;

public class Trapset {
	private Identifier name;
	private LinkedHashMap<Location, AbsExpression> mappings = new LinkedHashMap<>();

	public Trapset() { }

	public Identifier getName() {
		return name;
	}

	public void setName(Identifier name) {
		this.name = name;
	}

	public LinkedHashMap<Location, AbsExpression> getMappings() {
		return mappings;
	}
}
