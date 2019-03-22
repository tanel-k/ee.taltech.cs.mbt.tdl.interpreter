package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui;

public class Color {
	public static final int MAX_VALUE = 0xFFFFFF;
	public static final int MIN_VALUE = 0;

	public static final Color WHITE = Color.of(MAX_VALUE);
	public static final Color BLACK = Color.of(MIN_VALUE);

	public static Color of(int hexValue) {
		if (hexValue < MIN_VALUE || hexValue > MAX_VALUE) {
			throw new IllegalArgumentException("Color hexadecimal value out of bounds.");
		}
		return new Color(hexValue);
	}

	public static Color of(String hexString) {
		int hexValue = Integer.parseInt(hexString, 16);
		return of(hexValue);
	}

	private int intValue = 0;

	private Color(int intValue) {
		this.intValue = intValue;
	}

	public int getIntValue() {
		return intValue;
	}
}
