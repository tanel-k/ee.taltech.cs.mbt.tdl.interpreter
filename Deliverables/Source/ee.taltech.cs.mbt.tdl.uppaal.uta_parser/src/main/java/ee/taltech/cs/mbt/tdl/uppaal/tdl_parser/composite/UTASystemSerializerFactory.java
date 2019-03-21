package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite;

public class UTASystemSerializerFactory {
	public static UTASystemParser newParser() {
		return new UTASystemParser();
	}

	public static UTASystemSerializer newSerializer() {
		return new UTASystemSerializer();
	}
}
