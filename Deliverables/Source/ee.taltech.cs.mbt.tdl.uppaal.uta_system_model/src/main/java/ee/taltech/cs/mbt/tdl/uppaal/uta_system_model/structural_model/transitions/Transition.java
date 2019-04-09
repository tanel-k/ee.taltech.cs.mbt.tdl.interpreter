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

	public Transition setSource(Location source) {
		this.source = source;
		return this;
	}

	public Location getTarget() {
		return target;
	}

	public Transition setTarget(Location target) {
		this.target = target;
		return this;
	}

	public TransitionLabels getLabels() {
		return labels;
	}

	public Transition setLabels(TransitionLabels labels) {
		this.labels = labels;
		return this;
	}

	public List<GuiCoordinates> getNails() {
		return nails;
	}

	public Transition addNail(GuiCoordinates nail) {
		getNails().add(nail);
		return this;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public Transition setColor(Color color) {
		this.color = color;
		return this;
	}
}
