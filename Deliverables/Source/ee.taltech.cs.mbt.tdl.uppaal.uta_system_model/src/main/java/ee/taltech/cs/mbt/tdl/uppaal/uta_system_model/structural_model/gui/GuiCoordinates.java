package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GuiCoordinates {
	public static Integer distanceBetween(GuiCoordinates start, GuiCoordinates end) {
		double xDiff = (double) (end.x - start.x);
		double yDiff = (double) (end.y - start.y);
		return (int) Math.floor(Math.sqrt(Math.pow(xDiff, 2.0) + Math.pow(yDiff, 2.0)));
	}

	public static List<GuiCoordinates> evenlyDistributedCoordinatesBetween(GuiCoordinates start, GuiCoordinates end, Integer count) {
		List<GuiCoordinates> coordinates = new ArrayList<>(count);
		int xDiff = Math.floorDiv(end.x - start.x, count + 1);
		int yDiff = Math.floorDiv(end.y - start.y, count + 1);

		for (int i = 1; i <= count; i++) {
			coordinates.add(i - 1, GuiCoordinates.of(start.x + xDiff * i, start.y + yDiff * i));
		}

		return coordinates;
	}

	public static GuiCoordinates middleCoordinates(GuiCoordinates start, GuiCoordinates end) {
		return GuiCoordinates.of(Math.floorDiv(start.x + end.x, 2), Math.floorDiv(start.y + end.y, 2));
	}

	public static GuiCoordinates of(int x, int y) {
		return new GuiCoordinates(x, y);
	}

	private int x;
	private int y;

	private GuiCoordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof GuiCoordinates))
			return false;
		GuiCoordinates other = (GuiCoordinates) obj;
		return this.x == other.x
				&& this.y == other.y;
	}
}
