package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.Color;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.IColorable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.IPositionable;

import java.util.Objects;

public class Location implements IPositionable, IColorable {
	public static final String LOCATION_ID_PREFIX = "id";

	public enum ELocationExitPolicy {
		NORMAL, URGENT, COMMITTED
	}

	public static class LocationName implements IPositionable {
		private String name;
		private GuiCoordinates coordinates;

		public String getName() {
			return name;
		}

		public LocationName setName(String name) {
			this.name = name;
			return this;
		}

		@Override
		public GuiCoordinates getCoordinates() {
			return coordinates;
		}

		@Override
		public LocationName setCoordinates(GuiCoordinates coordinates) {
			this.coordinates = coordinates;
			return this;
		}
	}

	public static int parseIdString(String stringId) {
		return Integer.parseInt(
				stringId.replace(LOCATION_ID_PREFIX, "")
		);
	}

	public static String composeIdString(int numericId) {
		return LOCATION_ID_PREFIX + numericId;
	}

	private String id;
	private LocationName name;
	private LocationLabels labels;
	private ELocationExitPolicy exitPolicy = ELocationExitPolicy.NORMAL;
	private Color color;
	private GuiCoordinates coordinates;

	public Location() { }

	public String getId() {
		return id;
	}

	public Location setId(String id) {
		this.id = id;
		return this;
	}

	public LocationName getName() {
		return name;
	}

	public Location setName(LocationName name) {
		this.name = name;
		return this;
	}

	@Override
	public GuiCoordinates getCoordinates() {
		return coordinates;
	}

	@Override
	public Location setCoordinates(GuiCoordinates coordinates) {
		this.coordinates = coordinates;
		return this;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public Location setColor(Color color) {
		this.color = color;
		return this;
	}

	public ELocationExitPolicy getExitPolicy() {
		return exitPolicy;
	}

	public Location setExitPolicy(ELocationExitPolicy exitPolicy) {
		this.exitPolicy = exitPolicy;
		return this;
	}

	public LocationLabels getLabels() {
		return labels;
	}

	public Location setLabels(LocationLabels locationLabelContainer) {
		this.labels = locationLabelContainer;
		return this;
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
		if (!(obj instanceof Location))
			return false;
		Location other = (Location) obj;
		return Objects.equals(other.id, this.id);
	}
}
