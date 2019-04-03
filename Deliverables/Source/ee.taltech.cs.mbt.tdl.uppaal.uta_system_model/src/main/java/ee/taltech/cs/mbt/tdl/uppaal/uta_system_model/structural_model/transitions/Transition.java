package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.Color;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.IColorable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.IPositionable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location;

import java.util.LinkedList;
import java.util.List;

public class Transition implements IColorable {
	public static class Nail implements IPositionable {
		private GuiCoordinates coordinates;

		@Override
		public GuiCoordinates getCoordinates() {
			return coordinates;
		}

		@Override
		public void setCoordinates(GuiCoordinates coordinates) {
			this.coordinates = coordinates;
		}
	}

	private Location source;
	private Location target;

	private Color color;
	private List<Nail> nails = new LinkedList<>();
	private TransitionLabels labels;

	public Transition() { }

	public Location getSource() {
		return source;
	}

	public void setSource(Location source) {
		this.source = source;
	}

	public Location getTarget() {
		return target;
	}

	public void setTarget(Location target) {
		this.target = target;
	}

	public TransitionLabels getLabels() {
		return labels;
	}

	public void setLabels(TransitionLabels labels) {
		this.labels = labels;
	}

	public List<Nail> getNails() {
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
