package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.configuration.ErrorStrategyConfigFactory;
import ee.taltech.cs.mbt.tdl.commons.utils.validation.ValidationResult;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.InvalidSystemStructureException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion.UtaNodeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.language.EmbeddedCodeSyntaxException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.language.ParseQueue;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.validation.UtaNodeValidator;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.UtaLanguageParserFactory;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.UtaNodeMarshaller;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.UtaNodeMarshaller.MarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.UtaNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.io.InputStream;

public class UtaParser {
	public static UtaParser newInstance() {
		UtaLanguageParserFactory parserFactory = UtaLanguageParserFactory.newInstance();
		parserFactory.setErrorStrategyConfig(ErrorStrategyConfigFactory.failFastConfig());
		parserFactory.getErrorListeners().clear();
		return newInstance(parserFactory);
	}

	public static UtaParser newInstance(UtaLanguageParserFactory parserFactory) {
		if (parserFactory == null)
			throw new IllegalArgumentException("Expecting a UtaLanguageParserFactory instance.");
		return new UtaParser(parserFactory);
	}

	private UtaLanguageParserFactory parserFactory;

	private UtaParser(UtaLanguageParserFactory parserFactory) {
		this.parserFactory = parserFactory;
	}

	private UtaNode unmarshal(InputStream in) throws MarshallingException {
		return UtaNodeMarshaller.unmarshal(in);
	}

	private void validateStructure(UtaNode utaNode) throws InvalidSystemStructureException {
		UtaNodeValidator validator = UtaNodeValidator.newInstance(utaNode);
		ValidationResult validationResult = validator.validate();

		if (validationResult.hasErrors())
			throw new InvalidSystemStructureException("UTA system contains structural errors.", validationResult);
	}

	private UtaSystem convert(UtaNode utaNode, ParseQueue parseQueue) {
		UtaNodeConverter converter = UtaNodeConverter.newInstance(parserFactory, parseQueue);
		return converter.convert(utaNode);
	}

	public UtaSystem parse(InputStream in) throws MarshallingException, InvalidSystemStructureException, EmbeddedCodeSyntaxException {
		// XML -> JAXB representation of system
		UtaNode utaNode = unmarshal(in);

		// Ensure consistency of JAXB representation
		validateStructure(utaNode);

		ParseQueue parseQueue = new ParseQueue();

		// JAXB representation -> system model (enqueue parse operations)
		UtaSystem utaSystem = convert(utaNode, parseQueue);

		// Run enqueued embedded code parse operations
		parseQueue.executeRemaining();

		return utaSystem;
	}
}
