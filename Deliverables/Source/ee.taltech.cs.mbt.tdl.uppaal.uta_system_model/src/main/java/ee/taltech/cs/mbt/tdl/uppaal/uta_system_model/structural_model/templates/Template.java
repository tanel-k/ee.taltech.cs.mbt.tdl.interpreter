package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates;

import ee.taltech.cs.mbt.tdl.commons.utils.data_structures.DirectedMultigraph;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;

import java.util.LinkedList;
import java.util.List;

public class Template {
	private String name;
	private List<ParameterDeclaration> parameters;
	private Location initialLocation;
	private DirectedMultigraph<Location, Transition> locationGraph;
	private List<AbsDeclarationStatement> localDeclarations;

	public Template() { }

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

	public Location getInitialLocation() {
		return initialLocation;
	}

	public void setInitialLocation(Location initialLocation) {
		this.initialLocation = initialLocation;
	}

	public DirectedMultigraph<Location, Transition> getLocationGraph() {
		return locationGraph == null
				? (locationGraph = new DirectedMultigraph<>())
				: locationGraph;
	}

	public void setLocationGraph(DirectedMultigraph<Location, Transition> locationGraph) {
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
