package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.derived;

import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.IDerivedTrapsetVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.LinkedPairTrap;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.ITrapsetVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedPairTrapset extends AbsDerivedTrapset<LinkedPairTrap> {
	public LinkedPairTrapset() { }

	private Map<Transition, BaseTrapset> mapTransitionIngressTrapset = new LinkedHashMap<>();
	private Map<Transition, Transition> mapTransitionIngressTransition = new LinkedHashMap<>();

	@Override
	public boolean addTrap(LinkedPairTrap trap) {
		boolean newTrap = super.addTrap(trap);
		mapTransitionIngressTrapset.put(trap.getTransition(), trap.getIngressTrapset());
		mapTransitionIngressTransition.put(trap.getTransition(), trap.getIngressTransition());
		return newTrap;
	}

	@Override
	public <T> T accept(ITrapsetVisitor<T> visitor) {
		return visitor.visitLinkedPair(this);
	}

	public BaseTrapset getIngressTrapset(Transition transition) {
		return mapTransitionIngressTrapset.get(transition);
	}

	public Transition getIngressTransition(Transition transition) {
		return mapTransitionIngressTransition.get(transition);
	}

	@Override
	public <T> T accept(IDerivedTrapsetVisitor<T> visitor) {
		return visitor.visitLinkedPair(this);
	}
}
