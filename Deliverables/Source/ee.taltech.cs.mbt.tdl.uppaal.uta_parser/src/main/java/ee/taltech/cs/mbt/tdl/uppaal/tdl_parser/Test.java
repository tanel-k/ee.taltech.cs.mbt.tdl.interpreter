package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.UtaParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.language.InvalidEmbeddedCodeException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.validation.InvalidSystemStructureException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.UtaNodeMarshaller.MarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.UtaGeneratorFactory;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.CodeGenerationException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.io.InputStream;

public class Test {
	public static void main(String... args) throws MarshallingException, InvalidSystemStructureException, InvalidEmbeddedCodeException, CodeGenerationException {
		InputStream stream = Test.class.getResourceAsStream("/sample.xml");
		UtaSystem system = UtaParser.newInstance().parse(stream);
		System.out.println(
			UtaGeneratorFactory.getInstance().declarationGenerator().generate(system.getGlobalDeclarations())
		);//String tst = UtaGenerators.generate(system);
		// System.out.println(tst);
	}
}
