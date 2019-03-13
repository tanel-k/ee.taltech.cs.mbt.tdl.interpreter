package ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.labels.generic;

import ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.gui.generic.AbsUTAGuiPositionable;

public abstract class AbsUTAGuiLabel<ContentType> extends AbsUTAGuiPositionable {
	private String labelType;
	private ContentType content;

	public AbsUTAGuiLabel(String labelType) {
		this.labelType = labelType;
	}

	public String getLabelType() {
		return labelType;
	}

	public void setLabelType(String labelType) {
		this.labelType = labelType;
	}

	public ContentType getContent() {
		return content;
	}

	public void setContent(ContentType content) {
		this.content = content;
	}
}
