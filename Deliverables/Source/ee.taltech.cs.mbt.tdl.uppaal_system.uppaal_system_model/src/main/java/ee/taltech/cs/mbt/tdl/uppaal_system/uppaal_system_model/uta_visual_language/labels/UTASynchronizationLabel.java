package ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_visual_language.labels;

import ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_visual_language.labels.generic.AbsUppaalGuiLabel;

public class UTASynchronizationLabel extends AbsUppaalGuiLabel<String> {
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