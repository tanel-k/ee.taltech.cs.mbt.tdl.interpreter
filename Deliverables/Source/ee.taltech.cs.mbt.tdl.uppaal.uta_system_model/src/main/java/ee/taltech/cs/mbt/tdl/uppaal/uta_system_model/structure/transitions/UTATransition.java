package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.transitions;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.Color;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.IColorable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.IPositionable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.locations.UTALocation;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class UTATransition implements IColorable {
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

	private String id;
	private Color color;
	private UTALocation sourceLocation;
	private UTALocation targetLocation;
	private List<TransitionNail> transitionNails  = new LinkedList<>();
	private UTATransitionLabelContainer labelContainer;

	public UTATransition() { }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UTALocation getSourceLocation() {
		return sourceLocation;
	}

	public void setSourceLocation(UTALocation sourceLocation) {
		this.sourceLocation = sourceLocation;
	}

	public UTALocation getTargetLocation() {
		return targetLocation;
	}

	public void setTargetLocation(UTALocation targetLocation) {
		this.targetLocation = targetLocation;
	}

	public UTATransitionLabelContainer getLabelContainer() {
		return labelContainer;
	}

	public void setLabelContainer(UTATransitionLabelContainer labelContainer) {
		this.labelContainer = labelContainer;
	}

	public List<TransitionNail> getTransitionNails() {
		return transitionNails;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof  UTATransition))
			return false;
		UTATransition other = (UTATransition) obj;
		return Objects.equals(other.id, this.id);
	}
}
