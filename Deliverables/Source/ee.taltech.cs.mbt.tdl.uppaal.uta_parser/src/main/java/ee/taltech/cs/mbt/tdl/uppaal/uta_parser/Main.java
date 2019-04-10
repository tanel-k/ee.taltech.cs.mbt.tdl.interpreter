package ee.taltech.cs.mbt.tdl.uppaal.uta_parser;

import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.InvalidSystemStructureException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.UtaParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.language.EmbeddedCodeSyntaxException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.UtaSerializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.language.SyntaxRepresentationException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.UtaNodeMarshaller.MarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

public class Main {
	public static void main(String... args) throws MarshallingException, InvalidSystemStructureException, EmbeddedCodeSyntaxException, SyntaxRepresentationException {
		UtaSystem system = UtaParser.newInstance().parse(Main.class.getResourceAsStream("/test.xml"));
		UtaSerializer.newInstance().serialize(system, System.out);
	}
}
