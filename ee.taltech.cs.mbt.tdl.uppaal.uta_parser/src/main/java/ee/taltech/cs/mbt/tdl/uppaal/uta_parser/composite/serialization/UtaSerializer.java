package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization;

import ee.taltech.cs.mbt.tdl.commons.utils.validation.ValidationResult;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.InvalidSystemStructureException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.conversion.UtaSystemConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.language.GenerationQueue;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.language.SyntaxRepresentationException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.validation.UtaSystemValidator;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.UtaNodeMarshaller;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.UtaNodeMarshaller.MarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.UtaNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.UtaGeneratorFactory;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;

import java.io.OutputStream;

public class UtaSerializer {
	public static UtaSerializer newInstance() {
		UtaGeneratorFactory generatorFactory = UtaGeneratorFactory.getInstance();
		return newInstance(generatorFactory);
	}

	public static UtaSerializer newInstance(UtaGeneratorFactory generatorFactory) {
		if (generatorFactory == null)
			throw new IllegalArgumentException("Expecting a UtaGeneratorFactory instance.");
		return new UtaSerializer(generatorFactory);
	}

	private UtaGeneratorFactory generatorFactory;

	private UtaSerializer(UtaGeneratorFactory generatorFactory) {
		this.generatorFactory = generatorFactory;
	}

	private void validateStructure(UtaSystem utaSystem) throws InvalidSystemStructureException {
		UtaSystemValidator validator = UtaSystemValidator.newInstance(utaSystem);
		ValidationResult validationResult = validator.validate();

		if (validationResult.hasErrors())
			throw new InvalidSystemStructureException("UTA system contains structural errors.", validationResult);
	}

	private UtaNode convert(UtaSystem utaSystem, GenerationQueue parseQueue) {
		UtaSystemConverter converter = UtaSystemConverter.getInstance(generatorFactory, parseQueue);
		return converter.convert(utaSystem);
	}

	private void marshal(UtaNode utaNode, OutputStream out) throws MarshallingException {
		UtaNodeMarshaller.marshal(utaNode, out);
	}

	public void serialize(UtaSystem utaSystem, OutputStream out) throws MarshallingException, SyntaxRepresentationException, InvalidSystemStructureException {
		// Ensure consistency of system model
		validateStructure(utaSystem);

		GenerationQueue generationQueue = new GenerationQueue();

		// Model -> JAXB representation of system
		UtaNode utaNode = convert(utaSystem, generationQueue);

		// Run enqueued embedded code generation operations
		generationQueue.executeRemaining();

		// JAXB representation of system -> XML
		marshal(utaNode, out);
	}
}
