package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite;

public class UTATemplateSerializerFactory {
	public static UTATemplateParser newParser() {
		return new UTATemplateParser();
	}

	public static UTATemplateSerializer newSerializer() {
		return new UTATemplateSerializer();
	}
}
