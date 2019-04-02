package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.UtaParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.language.EmbeddedCodeSyntaxException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.InvalidSystemStructureException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.UtaSerializer;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.language.SyntaxRepresentationException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.UtaNodeMarshaller.MarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.UtaGeneratorFactory;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.CodeGenerationException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.io.InputStream;

public class Test {
	public static void main(String... args) throws MarshallingException, InvalidSystemStructureException, EmbeddedCodeSyntaxException, CodeGenerationException, SyntaxRepresentationException {
		InputStream stream = Test.class.getResourceAsStream("/sample.xml");
		UtaSystem system = UtaParser.newInstance().parse(stream);
		UtaSerializer.newInstance().serialize(system, System.out);
		//String tst = UtaGenerators.generate(system);
		// System.out.println(tst);
	}
}
