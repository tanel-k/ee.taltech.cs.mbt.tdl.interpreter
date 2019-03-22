package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.templates;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.generic.DirectedMultigraph;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.variable_declaration.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.locations.UTALocation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.transitions.UTATransition;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class UTATemplate {
	private String name;
	private List<ParameterDeclaration> parameters = new LinkedList<>();
	private DirectedMultigraph<UTALocation, UTATransition> locationGraph = new DirectedMultigraph<>();

	private UTALocation initialLocation;
	private Set<AbsDeclarationStatement> localDeclarations = new LinkedHashSet<>();

	public UTATemplate() { }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ParameterDeclaration> getParameters() {
		return parameters;
	}

	public UTALocation getInitialLocation() {
		return initialLocation;
	}

	public void setInitialLocation(UTALocation initialLocation) {
		this.initialLocation = initialLocation;
	}

	public DirectedMultigraph<UTALocation, UTATransition> getLocationGraph() {
		return locationGraph;
	}

	public Set<AbsDeclarationStatement> getLocalDeclarations() {
		return localDeclarations;
	}
}
