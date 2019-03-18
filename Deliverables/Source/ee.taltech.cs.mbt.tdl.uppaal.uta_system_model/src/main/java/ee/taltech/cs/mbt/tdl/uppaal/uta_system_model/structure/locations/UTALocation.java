package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.locations;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.IGuiPositionable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.GuiCoordinates;


public class UTALocation {
	public static class LocationName implements IGuiPositionable {
		private GuiCoordinates guiCoordinates;
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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

	private String id;
	private LocationName name;
	private GuiCoordinates nameCoordinates;
	private UTALocationLabelContainer labelContainer;
	private UTALocationExitPolicy exitPolicy = UTALocationExitPolicy.NORMAL;

	public UTALocation() { }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocationName getName() {
		return name;
	}

	public void setName(LocationName name) {
		this.name = name;
	}

	public GuiCoordinates getNameCoordinates() {
		return nameCoordinates;
	}

	public void setNameCoordinates(GuiCoordinates nameCoordinates) {
		this.nameCoordinates = nameCoordinates;
	}

	public UTALocationExitPolicy getExitPolicy() {
		return exitPolicy;
	}

	public void setExitPolicy(UTALocationExitPolicy exitPolicy) {
		this.exitPolicy = exitPolicy;
	}

	public UTALocationLabelContainer getLabelContainer() {
		return labelContainer;
	}

	public void setLabelContainer(UTALocationLabelContainer locationLabelContainer) {
		this.labelContainer = locationLabelContainer;
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
		if (!(obj instanceof  UTALocation))
			return false;
		UTALocation other = (UTALocation) obj;
		return (id == null && other.id == null)
			|| id.equals(other.id);
	}
}
