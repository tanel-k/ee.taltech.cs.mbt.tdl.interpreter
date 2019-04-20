package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui;

import java.util.Objects;

public class GuiCoordinates {
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

	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + x + ", " + y + ")";
	}
}
