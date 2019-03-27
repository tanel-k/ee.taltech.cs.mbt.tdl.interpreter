package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.UtaParseException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.UtaParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.UtaGenerator;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.io.InputStream;

public class Test {
	public static void main(String... args) throws UtaParseException {
		InputStream stream = Test.class.getResourceAsStream("/sample.xml");
		UtaSystem system = UtaParser.newInstance().parse(stream);
		String tst = UtaGenerator.generate(system);
		System.out.println(tst);
	}
}
