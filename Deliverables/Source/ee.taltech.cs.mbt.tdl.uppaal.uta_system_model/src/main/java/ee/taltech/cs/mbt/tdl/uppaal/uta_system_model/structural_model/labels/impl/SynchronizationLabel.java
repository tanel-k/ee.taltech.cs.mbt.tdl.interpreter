package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Synchronization;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.ILabelVisitor;

public class SynchronizationLabel extends AbsUtaLabel<Synchronization> {
	public static SynchronizationLabel of(Synchronization synchronization) {
		SynchronizationLabel inst = new SynchronizationLabel();
		inst.setContent(synchronization);
		return inst;
	}

	public boolean isOutbound() {
		return getContent().isActiveSync();
	}

	public void setOutbound(boolean outbound) {
		getContent().setActiveSync(outbound);
	}

	@Override
	public <T> T accept(ILabelVisitor<T> visitor) {
		return visitor.visitSynchronization(this);
	}
}