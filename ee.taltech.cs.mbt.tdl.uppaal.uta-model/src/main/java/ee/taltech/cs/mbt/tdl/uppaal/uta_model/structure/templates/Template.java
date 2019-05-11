package ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.templates;

import ee.taltech.cs.mbt.tdl.commons.utils.data_structures.DirectedMultigraph;
import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.commons.utils.objects.ObjectUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.transitions.Transition;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Template implements IDeepCloneable<Template> {
	private Identifier name;
	private List<ParameterDeclaration> parameters = new LinkedList<>();
	private Location initialLocation;
	private DirectedMultigraph<Location, Transition> locationGraph = new DirectedMultigraph<>();
	private List<AbsDeclarationStatement> declarations = new LinkedList<>();

	public Template() { }

	public Identifier getName() {
		return name;
	}

	public Template setName(Identifier name) {
		this.name = name;
		return this;
	}

	public List<ParameterDeclaration> getParameters() {
		return parameters;
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
		return locationGraph;
	}

	public List<AbsDeclarationStatement> getDeclarations() {
		return declarations;
	}

	public Template setDeclarations(List<AbsDeclarationStatement> declarations) {
		this.declarations = declarations != null ? declarations : this.declarations;
		return this;
	}

	@Override
	public Template deepClone() {
		Template clone = new Template();

		clone.name = name.deepClone();
		parameters.stream()
				.forEachOrdered(p -> clone.parameters.add(p.deepClone()));
		declarations.stream()
				.forEachOrdered(d -> clone.declarations.add(d.deepClone()));

		Map<Location, Location> locationCloneMap = new HashMap<>();
		for (Transition transition : locationGraph.getEdges()) {
			Transition transitionClone = transition.deepClone();
			Location srcLocation = locationGraph.getSourceVertex(transition);
			Location tgtLocation = locationGraph.getTargetVertex(transition);

			Location srcLocClone = locationCloneMap.computeIfAbsent(srcLocation, Location::deepClone);
			Location tgtLocClone = locationCloneMap.computeIfAbsent(tgtLocation, Location::deepClone);

			Location initLocClone = ObjectUtils.firstEquivalent(initialLocation, srcLocClone, tgtLocClone);
			if (initLocClone != null) {
				clone.initialLocation = initLocClone;
			}

			transitionClone.setSource(srcLocClone);
			transitionClone.setTarget(tgtLocClone);
			clone.locationGraph.addEdge(srcLocClone, tgtLocClone, transitionClone);
		}

		return clone;
	}
}
