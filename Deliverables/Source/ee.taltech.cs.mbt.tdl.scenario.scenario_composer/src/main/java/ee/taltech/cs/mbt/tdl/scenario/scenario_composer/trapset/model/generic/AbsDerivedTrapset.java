package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic;

import ee.taltech.cs.mbt.tdl.commons.utils.primitives.IntUtils.IntIterator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Synchronization;

import java.util.LinkedList;
import java.util.List;

public abstract class AbsDerivedTrapset<TrapType extends BaseTrap> extends AbsTrapset<TrapType> {
	public static class TrapsetImplementationDetail {
		public static TrapsetImplementationDetail of(Identifier flagArrayName, Synchronization synchronization) {
			return new TrapsetImplementationDetail(flagArrayName, synchronization);
		}

		private Identifier flagArrayName;
		private IntIterator indexCounter;
		private Synchronization activatingSynchronization;

		private TrapsetImplementationDetail(Identifier flagArrayName, Synchronization activatingSynchronization) {
			this.flagArrayName = flagArrayName;
			this.indexCounter = IntIterator.newInstance();
			this.activatingSynchronization = activatingSynchronization;
		}

		public Identifier getFlagArrayName() {
			return flagArrayName;
		}

		public IntIterator getIndexCounter() {
			return indexCounter;
		}

		public Synchronization getActivatingSynchronization() {
			return activatingSynchronization;
		}
	}

	private List<TrapsetImplementationDetail> implementationDetails = new LinkedList<>();

	public List<TrapsetImplementationDetail> getImplementationDetails() {
		return implementationDetails;
	}

	public abstract <T> T accept(IDerivedTrapsetVisitor<T> visitor);
}
