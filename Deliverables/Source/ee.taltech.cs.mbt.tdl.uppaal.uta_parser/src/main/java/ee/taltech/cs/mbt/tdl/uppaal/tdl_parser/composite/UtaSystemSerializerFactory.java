package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite;

public class UtaSystemSerializerFactory {
	public static UtaSystemParser newParser() {
		return new UtaSystemParser();
	}

	public static UtaSystemSerializer newSerializer() {
		return new UtaSystemSerializer();
	}
}
