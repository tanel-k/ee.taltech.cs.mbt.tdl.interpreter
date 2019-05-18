package ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.locations;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.IDeepCloneable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.gui.Color;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.gui.IColorable;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.gui.IPositionable;

import java.util.Objects;

public class Location implements IPositionable, IColorable, IDeepCloneable<Location> {
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
	private LocationName locationName;
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
		return locationName;
	}

	public Location setName(LocationName name) {
		this.locationName = name;
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

	@Override
	public Location deepClone() {
		Location clone = new Location();
		clone.color = color;
		clone.id = id;
		clone.coordinates = coordinates;
		clone.exitPolicy = exitPolicy;
		clone.locationName = locationName != null
				? (new LocationName().setName(locationName.name).setCoordinates(locationName.coordinates))
				: null;
		clone.labels = labels != null
				? labels.deepClone()
				: null;
		return clone;
	}
}
