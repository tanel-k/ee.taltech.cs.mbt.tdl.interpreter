package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.transitions;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.Color;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.IColorable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.IPositionable;

import java.util.LinkedList;
import java.util.List;

public class UtaTransition implements IColorable {
	public static class TransitionNail implements IPositionable, IColorable {
		private Color color;
		private GuiCoordinates coordinates;

		@Override
		public Color getColor() {
			return color;
		}

		@Override
		public void setColor(Color color) {
			this.color = color;
		}

		@Override
		public GuiCoordinates getCoordinates() {
			return coordinates;
		}

		@Override
		public void setCoordinates(GuiCoordinates coordinates) {
			this.coordinates = coordinates;
		}
	}

	private Color color;
	private List<TransitionNail> nails = new LinkedList<>();
	private UtaTransitionLabels labels;

	public UtaTransition() { }

	public UtaTransitionLabels getLabels() {
		return labels;
	}

	public void setLabels(UtaTransitionLabels labels) {
		this.labels = labels;
	}

	public List<TransitionNail> getNails() {
		return nails;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}
}
