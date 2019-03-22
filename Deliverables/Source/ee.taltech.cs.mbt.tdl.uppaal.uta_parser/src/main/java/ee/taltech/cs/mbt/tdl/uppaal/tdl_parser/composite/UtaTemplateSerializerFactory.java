package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite;

public class UtaTemplateSerializerFactory {
	public static UtaTemplateParser newParser() {
		return new UtaTemplateParser();
	}

	public static UtaTemplateSerializer newSerializer() {
		return new UtaTemplateSerializer();
	}
}
