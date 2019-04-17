package ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset.generic;

import ee.taltech.cs.mbt.tdl.scenario.scenario_generator.trapset.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Synchronization;

import java.util.LinkedList;
import java.util.List;

public abstract class AbsDerivedTrapset<TrapType extends BaseTrap> extends AbsTrapset<TrapType> {
	public static class TrapsetDuplicationParameters {
		public static TrapsetDuplicationParameters of(Identifier arrayName, Synchronization synchronization) {
			return new TrapsetDuplicationParameters(arrayName, synchronization);
		}

		private Identifier arrayName;
		private Synchronization activatingSynchronization;

		private TrapsetDuplicationParameters(Identifier arrayName, Synchronization activatingSynchronization) {
			this.arrayName = arrayName;
			this.activatingSynchronization = activatingSynchronization;
		}

		public Identifier getArrayName() {
			return arrayName;
		}

		public Synchronization getActivatingSynchronization() {
			return activatingSynchronization;
		}
	}

	private List<TrapsetDuplicationParameters> duplications = new LinkedList<>();

	public List<TrapsetDuplicationParameters> getDuplications() {
		return duplications;
	}

	public boolean isDuplicated() {
		return !duplications.isEmpty();
	}

	public abstract <T> T accept(IDerivedTrapsetVisitor<T> visitor);
}
