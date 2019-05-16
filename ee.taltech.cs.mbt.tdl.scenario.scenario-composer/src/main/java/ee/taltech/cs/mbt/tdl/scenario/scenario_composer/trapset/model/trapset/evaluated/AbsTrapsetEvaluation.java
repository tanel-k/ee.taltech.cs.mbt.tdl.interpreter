package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated;

import ee.taltech.cs.mbt.tdl.commons.utils.primitives.IntUtils.IntGenerator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.AbsTrapset;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.template.Synchronization;

import java.util.LinkedList;
import java.util.List;

public abstract class AbsTrapsetEvaluation<TrapType extends BaseTrap> extends AbsTrapset<TrapType> {
	public static class TrapsetImplementationDetail {
		public static TrapsetImplementationDetail of(Identifier flagArrayName, Synchronization synchronization) {
			return new TrapsetImplementationDetail(flagArrayName, synchronization);
		}

		private Identifier flagArrayName;
		private IntGenerator indexCounter;
		private Synchronization activatingSynchronization;

		private TrapsetImplementationDetail(Identifier flagArrayName, Synchronization activatingSynchronization) {
			this.flagArrayName = flagArrayName;
			this.indexCounter = IntGenerator.newInstance();
			this.activatingSynchronization = activatingSynchronization;
		}

		public Identifier getFlagArrayName() {
			return flagArrayName;
		}

		public IntGenerator getIndexCounter() {
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

	public abstract <T> T accept(IEvaluatedTrapsetVisitor<T> visitor);
}
