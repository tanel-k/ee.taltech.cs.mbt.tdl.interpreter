package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_structural_model.labels;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_structural_model.labels.generic.AbsUTAGuiLabel;

public class UTASynchronizationLabel extends AbsUTAGuiLabel<String> {
	public static final String LABEL_TYPE = "SYNCHRONIZATION";

	private boolean inbound;
	private String channelName;

	public boolean isInbound() {
		return inbound;
	}

	public void setInbound(boolean inbound) {
		this.inbound = inbound;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public UTASynchronizationLabel() {
		super(LABEL_TYPE);
	}
}
// TODO