package ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.AbsLiteralExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class Trapset implements Iterable<Transition> {
	private Identifier name;
	private ETrapsetType type;
	private AbsDeclarationStatement declaration;

	private LinkedHashSet<Transition> markedTransitions = new LinkedHashSet<>();
	private LinkedHashMap<Transition, Template> mapTransitionParent = new LinkedHashMap<>();
	private LinkedHashMap<Transition, AssignmentExpression> mapTransitionToMarkerAssignment = new LinkedHashMap<>();
	private LinkedHashMap<Transition, AbsExpression> mapTransitionToCondition = new LinkedHashMap<>();

	public Trapset() { }

	public AbsDeclarationStatement getDeclaration() {
		return declaration;
	}

	public Trapset setDeclaration(AbsDeclarationStatement declaration) {
		this.declaration = declaration;
		return this;
	}

	public ETrapsetType getType() {
		return type;
	}

	public Trapset setType(ETrapsetType type) {
		this.type = type;
		return this;
	}

	public Identifier getName() {
		return name;
	}

	public Trapset setName(Identifier name) {
		this.name = name;
		return this;
	}

	public boolean isEmpty() {
		return markedTransitions.isEmpty();
	}

	public boolean contains(Transition transition) {
		return markedTransitions.contains(transition);
	}
	public int getTrapCount() {
		return markedTransitions.size();
	}

	public boolean isConditional(Transition transition) {
		return !(getMarkerCondition(transition) instanceof AbsLiteralExpression); // FIXME
	}

	public Template getParentTemplate(Transition transition) {
		return mapTransitionParent.get(transition);
	}

	public AbsExpression getMarkerCondition(Transition transition) {
		return mapTransitionToCondition.get(transition);
	}

	public AssignmentExpression getMarkerAssignment(Transition transition) {
		return mapTransitionToMarkerAssignment.get(transition);
	}

	public boolean addTrap(Template parentTemplate, Transition transition, AssignmentExpression markerAssignment) {
		boolean newTransition = this.markedTransitions.add(transition);
		this.mapTransitionParent.put(transition, parentTemplate);
		this.mapTransitionToMarkerAssignment.put(transition, markerAssignment);
		this.mapTransitionToCondition.put(transition, markerAssignment.getRightChild());
		return newTransition;
	}

	@Override
	public Iterator<Transition> iterator() {
		return markedTransitions.iterator();
	}
}
