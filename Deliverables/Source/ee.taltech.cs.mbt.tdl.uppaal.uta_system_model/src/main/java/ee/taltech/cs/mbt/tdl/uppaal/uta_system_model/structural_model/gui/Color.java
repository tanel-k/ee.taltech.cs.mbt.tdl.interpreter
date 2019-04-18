package ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui;

import java.util.Collection;

public class Color {
	public static final int MAX_VALUE = 0xFFFFFF;
	public static final int MIN_VALUE = 0;

	public static final Color WHITE = Color.of(MAX_VALUE);
	public static final Color BLACK = Color.of(MIN_VALUE);
	public static final Color RED = Color.of(0xFF0000);
	public static final Color GREEN = Color.of(0x008000);
	public static final Color YELLOW = Color.of(0xFFFF00);
	public static final Color GRAY = Color.of(0x808080) ;
	public static final Color CYAN = Color.of(0x00FFFF);
	public static final Color BLUE = Color.of(0x0000FF);
	public static final Color MAGENTA = Color.of(0xFF00FF);
	public static final Color ORANGE = Color.of(0xFFA500);

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
