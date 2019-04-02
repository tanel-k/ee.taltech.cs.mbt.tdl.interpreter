package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization;

import ee.taltech.cs.mbt.tdl.common_utils.validation.ValidationResult;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.InvalidSystemStructureException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.conversion.UtaSystemConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.language.GenerationQueue;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.language.SyntaxRepresentationException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.validation.UtaSystemValidator;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.UtaNodeMarshaller;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.UtaNodeMarshaller.MarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.UtaNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.UtaGeneratorFactory;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.io.OutputStream;

public class UtaSerializer {
	public static UtaSerializer newInstance() {
		return new UtaSerializer();
	}

	public void serialize(UtaSystem utaSystem, OutputStream stream) throws MarshallingException, SyntaxRepresentationException, InvalidSystemStructureException {
		UtaSystemValidator validator = UtaSystemValidator.newInstance(utaSystem);

		ValidationResult<?> validationResult = validator.validate();
		if (validationResult.hasErrors())
			throw new InvalidSystemStructureException("UTA system contains structural errors.", validationResult);

		GenerationQueue generationQueue = new GenerationQueue();
		UtaGeneratorFactory generatorFactory = UtaGeneratorFactory.getInstance();
		UtaSystemConverter converter = UtaSystemConverter.getInstance(generatorFactory, generationQueue);
		UtaNode utaNode = converter.convert(utaSystem);
		generationQueue.executeRemaining();
		UtaNodeMarshaller.marshal(utaNode, stream);
	}
}
