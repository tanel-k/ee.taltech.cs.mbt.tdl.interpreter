package ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_visual_language.labels.generic;

import ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_visual_language.gui.generic.AbsUTAGuiPositionable;

public abstract class AbsUppaalGuiLabel<ContentType> extends AbsUTAGuiPositionable {
	private String labelType;
	private ContentType content;

	public AbsUppaalGuiLabel(String labelType) {
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
