package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.templates;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.generic.DirectedMultigraph;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.variable_declaration.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.locations.UtaLocation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.transitions.UtaTransition;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class UtaTemplate {
	private String name;
	private List<ParameterDeclaration> parameters = new LinkedList<>();
	private DirectedMultigraph<UtaLocation, UtaTransition> locationGraph = new DirectedMultigraph<>();

	private UtaLocation initialLocation;
	private Set<AbsDeclarationStatement> localDeclarations = new LinkedHashSet<>();

	public UtaTemplate() { }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ParameterDeclaration> getParameters() {
		return parameters;
	}

	public UtaLocation getInitialLocation() {
		return initialLocation;
	}

	public void setInitialLocation(UtaLocation initialLocation) {
		this.initialLocation = initialLocation;
	}

	public DirectedMultigraph<UtaLocation, UtaTransition> getLocationGraph() {
		return locationGraph;
	}

	public Set<AbsDeclarationStatement> getLocalDeclarations() {
		return localDeclarations;
	}
}
