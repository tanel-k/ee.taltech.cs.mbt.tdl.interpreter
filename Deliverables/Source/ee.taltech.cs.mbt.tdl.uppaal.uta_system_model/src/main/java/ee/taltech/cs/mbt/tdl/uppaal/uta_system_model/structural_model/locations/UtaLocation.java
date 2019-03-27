package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.Color;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.IColorable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.IPositionable;

import java.util.Objects;

public class UtaLocation implements IPositionable, IColorable {
	public enum ELocationExitPolicy {
		NORMAL, URGENT, COMMITTED
	}

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
	private UtaLocationLabels labelContainer;
	private ELocationExitPolicy exitPolicy = ELocationExitPolicy.NORMAL;
	private Color color;
	private GuiCoordinates coordinates;

	public UtaLocation() { }

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

	public UtaLocationLabels getLabelContainer() {
		return labelContainer;
	}

	public void setLabelContainer(UtaLocationLabels locationLabelContainer) {
		this.labelContainer = locationLabelContainer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof UtaLocation))
			return false;
		UtaLocation other = (UtaLocation) obj;
		return Objects.equals(other.id, this.id);
	}
}
