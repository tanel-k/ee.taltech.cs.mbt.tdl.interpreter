package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic;

import ee.taltech.cs.mbt.tdl.commons.utils.primitives.IntUtils.IntIterator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Synchronization;

import java.util.LinkedList;
import java.util.List;

public abstract class AbsDerivedTrapset<TrapType extends BaseTrap> extends AbsTrapset<TrapType> {
	public static class TrapsetImplementationDetail {
		public static TrapsetImplementationDetail of(Identifier arrayName, Synchronization synchronization) {
			return new TrapsetImplementationDetail(arrayName, synchronization);
		}

		private Identifier arrayName;
		private IntIterator indexCounter;
		private Synchronization activatingSynchronization;

		private TrapsetImplementationDetail(Identifier arrayName, Synchronization activatingSynchronization) {
			this.arrayName = arrayName;
			this.indexCounter = IntIterator.newInstance();
			this.activatingSynchronization = activatingSynchronization;
		}

		public Identifier getArrayName() {
			return arrayName;
		}

		public IntIterator getIndexCounter() {
			return indexCounter;
		}

		public Synchronization getActivatingSynchronization() {
			return activatingSynchronization;
		}
	}

	private List<TrapsetImplementationDetail> trapsetImplementationDetails = new LinkedList<>();

	public List<TrapsetImplementationDetail> getTrapsetImplementationDetails() {
		return trapsetImplementationDetails;
	}

	public boolean isDuplicated() {
		return !trapsetImplementationDetails.isEmpty();
	}

	public abstract <T> T accept(IDerivedTrapsetVisitor<T> visitor);
}
