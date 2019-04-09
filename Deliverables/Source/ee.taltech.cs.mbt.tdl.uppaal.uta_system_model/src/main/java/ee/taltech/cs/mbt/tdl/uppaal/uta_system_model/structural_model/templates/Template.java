package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates;

import ee.taltech.cs.mbt.tdl.commons.utils.data_structures.DirectedMultigraph;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;

import java.util.LinkedList;
import java.util.List;

public class Template {
	private Identifier name;
	private List<ParameterDeclaration> parameters;
	private Location initialLocation;
	private DirectedMultigraph<Location, Transition> locationGraph;
	private List<AbsDeclarationStatement> localDeclarations;

	public Template() { }

	public Identifier getName() {
		return name;
	}

	public Template setName(Identifier name) {
		this.name = name;
		return this;
	}

	public List<ParameterDeclaration> getParameters() {
		return parameters == null
				? (parameters = new LinkedList<>())
				: parameters;
	}

	public Template setParameters(List<ParameterDeclaration> parameters) {
		this.parameters = parameters;
		return this;
	}

	public Location getInitialLocation() {
		return initialLocation;
	}

	public Template setInitialLocation(Location initialLocation) {
		this.initialLocation = initialLocation;
		return this;
	}

	public DirectedMultigraph<Location, Transition> getLocationGraph() {
		return locationGraph == null
				? (locationGraph = new DirectedMultigraph<>())
				: locationGraph;
	}

	public Template setLocationGraph(DirectedMultigraph<Location, Transition> locationGraph) {
		this.locationGraph = locationGraph;
		return this;
	}

	public List<AbsDeclarationStatement> getLocalDeclarations() {
		return localDeclarations == null
				? (localDeclarations = new LinkedList<>())
				: localDeclarations;
	}

	public Template setLocalDeclarations(List<AbsDeclarationStatement> localDeclarations) {
		this.localDeclarations = localDeclarations;
		return this;
	}
}
