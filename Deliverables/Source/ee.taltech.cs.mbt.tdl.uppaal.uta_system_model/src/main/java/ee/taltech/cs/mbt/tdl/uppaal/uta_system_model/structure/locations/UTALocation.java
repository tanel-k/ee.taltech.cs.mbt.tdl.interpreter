package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.locations;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.Color;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.IColorable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.IPositionable;

import java.util.Objects;

public class UTALocation implements IPositionable, IColorable {
	public static class LocationName implements IPositionable {
		private String name;
		private GuiCoordinates coordinates;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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
	private LocationName name;
	private UTALocationLabelContainer labelContainer;
	private ELocationExitPolicy exitPolicy = ELocationExitPolicy.NORMAL;
	private Color color;
	private GuiCoordinates coordinates;

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

	@Override
	public GuiCoordinates getCoordinates() {
		return coordinates;
	}

	@Override
	public void setCoordinates(GuiCoordinates coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	public ELocationExitPolicy getExitPolicy() {
		return exitPolicy;
	}

	public void setExitPolicy(ELocationExitPolicy exitPolicy) {
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
		return Objects.equals(other.id, this.id);
	}
}
