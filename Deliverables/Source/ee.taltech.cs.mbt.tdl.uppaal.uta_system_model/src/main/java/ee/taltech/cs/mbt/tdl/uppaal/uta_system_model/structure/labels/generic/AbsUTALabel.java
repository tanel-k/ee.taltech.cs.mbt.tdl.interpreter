package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.labels.generic;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.IPositionable;

public abstract class AbsUTALabel<ContentType> implements IPositionable {
	private ContentType content;
	private GuiCoordinates coordinates;

	@Override
	public GuiCoordinates getCoordinates() {
		return coordinates;
	}

	@Override
	public void setCoordinates(GuiCoordinates coordinates) {
		this.coordinates = coordinates;
	}

	public ContentType getContent() {
		return content;
	}

	public void setContent(ContentType content) {
		this.content = content;
	}
}
