package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.conversion;

import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.IdReferenceNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.NameNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.Color;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location.LocationName;

public class ConversionUtils {
	public static NameNode nameNodeFor(String name, GuiCoordinates coordinates) {
		NameNode nameNode = new NameNode();
		nameNode.setValue(name);
		if (coordinates != null) {
			nameNode.setX(coordinates.getX());
			nameNode.setY(coordinates.getY());
		}
		return nameNode;
	}

	public static NameNode nameNodeFor(LocationName name) {
		return nameNodeFor(name.getName(), name.getCoordinates());
	}

	public static NameNode nameNodeFor(String name) {
		return nameNodeFor(name, null);
	}

	public static IdReferenceNode idReferenceFor(String id) {
		IdReferenceNode idReferenceNode = new IdReferenceNode();
		idReferenceNode.setRef(id);
		return idReferenceNode;
	}

	public static String serializeColor(Color color) {
		if (color == null)
			return null;

		return "#" + String.format("%06X", color.getIntValue());
	}
}
