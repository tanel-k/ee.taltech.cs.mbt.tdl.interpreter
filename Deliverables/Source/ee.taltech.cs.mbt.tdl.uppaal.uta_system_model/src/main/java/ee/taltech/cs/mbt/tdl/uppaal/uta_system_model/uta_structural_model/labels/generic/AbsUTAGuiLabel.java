package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_structural_model.labels.generic;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_structural_model.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.uta_structural_model.gui.IGuiPositionable;

public abstract class AbsUTAGuiLabel<ContentType> implements IGuiPositionable {
	private String labelType;
	private ContentType content;
	private GuiCoordinates guiCoordinates;

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

	@Override
	public GuiCoordinates getGuiCoordinates() {
		return guiCoordinates;
	}

	@Override
	public void setGuiCoordinates(GuiCoordinates guiCoordinates) {
		this.guiCoordinates = guiCoordinates;
	}
}
