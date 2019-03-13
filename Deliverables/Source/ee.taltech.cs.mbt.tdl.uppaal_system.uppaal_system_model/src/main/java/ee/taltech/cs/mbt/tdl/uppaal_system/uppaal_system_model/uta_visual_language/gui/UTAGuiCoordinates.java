package ee.taltech.cs.mbt.tdl.uppaal_system.uppaal_system_model.uta_visual_language.gui;

public class UTAGuiCoordinates {
	private int x;
	private int y;
	private String color;

	public UTAGuiCoordinates() { }

	public UTAGuiCoordinates(int x, int y) {
		this(x, y, null);
	}

	public UTAGuiCoordinates(int x, int y, String color) {
		this.x = x;
		this.y = y;
		this.color = color;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
