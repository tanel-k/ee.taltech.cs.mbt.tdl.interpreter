package ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.transitions;

import ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.gui.IColorable;
import ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.gui.IGuiPositionable;
import ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_structural_model.locations.UTALocation;

import java.util.LinkedList;
import java.util.List;

public class UTATransition implements IColorable {
	public static class TransitionNail implements IGuiPositionable {
		private GuiCoordinates guiCoordinates;

		@Override
		public GuiCoordinates getGuiCoordinates() {
			return guiCoordinates;
		}

		@Override
		public void setGuiCoordinates(GuiCoordinates guiCoordinates) {
			this.guiCoordinates = guiCoordinates;
		}
	}

	private String id;
	private String colorString;
	private UTALocation sourceLocation;
	private UTALocation targetLocation;
	private List<TransitionNail> transitionNails;
	private UTATransitionLabelContainer labelContainer;

	public UTATransition() {
		this.transitionNails = new LinkedList<>();
	}

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

	public List<TransitionNail> getTransitionNails() {
		return transitionNails;
	}

	@Override
	public String getColorString() {
		return colorString;
	}

	@Override
	public void setColorString(String colorString) {
		this.colorString = colorString;
	}

	@Override
	public int hashCode() {
		return id == null
				? 0
				: getId().hashCode();
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
		return (id == null && other.id == null)
				|| id.equals(other.id);
	}
}
