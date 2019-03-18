package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.labels.generic;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.IGuiPositionable;

public abstract class AbsUTAGuiLabel<ContentType> implements IGuiPositionable {
	private ContentType content;
	private GuiCoordinates guiCoordinates;

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
