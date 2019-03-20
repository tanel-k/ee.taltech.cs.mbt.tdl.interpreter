package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui;

public class GuiCoordinates implements IColorable {
	private Integer x;
	private Integer y;
	private Color color;

	public GuiCoordinates() {
		this(null, null, Color.BLACK);
	}

	public GuiCoordinates(Integer x, Integer y)
	{
		this(x, y, Color.BLACK);
	}

	public GuiCoordinates(Integer x, Integer y, Color color) {
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

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}
}
