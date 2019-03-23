package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion;

import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.Color;

public class NtaConversionUtils {
	public static Color parseColor(String colorString) {
		if (colorString == null)
			return null;
		try {
			return Color.of(colorString.replace("#", ""));
		} catch (Throwable t) {
			/* Ignored. */
		}
		return null;
	}
}
