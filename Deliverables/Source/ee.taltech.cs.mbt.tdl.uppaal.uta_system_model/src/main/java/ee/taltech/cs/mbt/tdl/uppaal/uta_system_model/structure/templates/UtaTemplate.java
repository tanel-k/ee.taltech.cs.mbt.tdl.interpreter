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
	private List<ParameterDeclaration> parameters;
	private UtaLocation initialLocation;
	private DirectedMultigraph<UtaLocation, UtaTransition> locationGraph;
	private List<AbsDeclarationStatement> localDeclarations;

	public UtaTemplate() { }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ParameterDeclaration> getParameters() {
		return parameters == null
			? (parameters = new LinkedList<>())
			: parameters;
	}

	public void setParameters(List<ParameterDeclaration> parameters) {
		this.parameters = parameters;
	}

	public UtaLocation getInitialLocation() {
		return initialLocation;
	}

	public void setInitialLocation(UtaLocation initialLocation) {
		this.initialLocation = initialLocation;
	}

	public DirectedMultigraph<UtaLocation, UtaTransition> getLocationGraph() {
		return locationGraph == null
			? (locationGraph = new DirectedMultigraph<>())
			: locationGraph;
	}

	public void setLocationGraph(DirectedMultigraph<UtaLocation, UtaTransition> locationGraph) {
		this.locationGraph = locationGraph;
	}

	public List<AbsDeclarationStatement> getLocalDeclarations() {
		return localDeclarations == null
			? (localDeclarations = new LinkedList<>())
			: localDeclarations;
	}

	public void setLocalDeclarations(List<AbsDeclarationStatement> localDeclarations) {
		this.localDeclarations = localDeclarations;
	}
}
