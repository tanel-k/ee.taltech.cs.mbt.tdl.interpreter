package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.labels;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.template.Synchronization;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.labels.generic.AbsUtaLabel;

public class UtaSynchronizationLabel extends AbsUtaLabel<Synchronization> {
	public boolean isOutbound() {
		return getContent().isActiveSync();
	}

	public void setOutbound(boolean outbound) {
		getContent().setActiveSync(outbound);
	}
}
