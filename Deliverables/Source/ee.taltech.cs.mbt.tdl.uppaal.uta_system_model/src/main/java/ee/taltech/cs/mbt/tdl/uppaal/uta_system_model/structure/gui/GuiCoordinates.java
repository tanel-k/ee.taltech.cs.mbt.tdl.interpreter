package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui;

public class GuiCoordinates {
	private int x;
	private int y;
	private String color;

	public GuiCoordinates() { }

	public GuiCoordinates(int x, int y) {
		this(x, y, null);
	}

	public GuiCoordinates(int x, int y, String color) {
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
