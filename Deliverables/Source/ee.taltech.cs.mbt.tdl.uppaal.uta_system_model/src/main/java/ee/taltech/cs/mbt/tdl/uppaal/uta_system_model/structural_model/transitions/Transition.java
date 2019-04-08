package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.Color;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.IColorable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.IPositionable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location;

import java.util.LinkedList;
import java.util.List;

public class Transition implements IColorable {
	private Location source;
	private Location target;

	private Color color;
	private TransitionLabels labels;
	private List<GuiCoordinates> nails = new LinkedList<>();

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

	public List<GuiCoordinates> getNails() {
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
