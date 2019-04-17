package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.generic;

import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.trap.BaseTrap;
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

public abstract class AbsTrapset<TrapType extends BaseTrap> implements Iterable<Transition> {
	private Identifier name;
	private AbsDeclarationStatement declaration;

	private LinkedHashSet<Transition> markedTransitions = new LinkedHashSet<>();
	private LinkedHashMap<Transition, Template> mapTransitionParent = new LinkedHashMap<>();
	private LinkedHashMap<Transition, AssignmentExpression> mapTransitionToMarkerAssignment = new LinkedHashMap<>();
	private LinkedHashMap<Transition, AbsExpression> mapTransitionToCondition = new LinkedHashMap<>();

	protected AbsTrapset() { }

	public AbsDeclarationStatement getDeclaration() {
		return declaration;
	}

	public AbsTrapset setDeclaration(AbsDeclarationStatement declaration) {
		this.declaration = declaration;
		return this;
	}

	public Identifier getName() {
		return name;
	}

	public AbsTrapset setName(Identifier name) {
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

	public int getUnconditionalTrapCount() {
		throw new UnsupportedOperationException();
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

	public boolean addTrap(TrapType trap) {
		boolean newTransition = this.markedTransitions.add(trap.getTransition());
		this.mapTransitionParent.put(trap.getTransition(), trap.getParentTemplate());
		this.mapTransitionToMarkerAssignment.put(trap.getTransition(), trap.getMarkerAssignment());
		this.mapTransitionToCondition.put(trap.getTransition(), trap.getMarkerAssignment().getRightChild());
		return newTransition;
	}

	public abstract <T> T accept(ITrapsetVisitor<T> visitor);

	@Override
	public Iterator<Transition> iterator() {
		return markedTransitions.iterator();
	}
}
