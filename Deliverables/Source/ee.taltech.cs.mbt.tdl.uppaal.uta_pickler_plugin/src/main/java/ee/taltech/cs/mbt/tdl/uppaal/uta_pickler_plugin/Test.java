package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin;

import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.GenerationException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.InvalidSystemStructureException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.UtaParser;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.language.EmbeddedCodeSyntaxException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.UtaSerializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.language.SyntaxRepresentationException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.UtaNodeMarshaller.MarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.SystemPickleGeneratorFactory;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import picklePackage.PickleNameSystemFactory;

public class Test {
	public static void main(String... args) throws MarshallingException, InvalidSystemStructureException, EmbeddedCodeSyntaxException, GenerationException, SyntaxRepresentationException {
		UtaSystem sourceSystem = UtaParser.newInstance().parse(Test.class.getResourceAsStream("/Recognizer.xml"));
		/*
		String pickleClass = SystemPickleGeneratorFactory
				.systemGenerator("picklePackage", "pickleName")
				.generate(sourceSystem);
		System.out.println(pickleClass);
		*/
		UtaSerializer.newInstance().serialize(sourceSystem, System.out);
		System.out.println("----------------------------------------------------------------------------------");
		UtaSystem lastPickle = PickleNameSystemFactory.getInstance().newPickleNameSystem();
		UtaSerializer.newInstance().serialize(lastPickle, System.out);
	}
}
