package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.IPositionable;

public abstract class AbsUtaLabel<ContentType> implements IPositionable {
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

	public abstract <T> T accept(ILabelVisitor<T> visitor);
}
