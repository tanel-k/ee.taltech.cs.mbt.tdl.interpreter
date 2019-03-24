package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion.UtaCodeException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion.UtaNodeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion.UtaConverterFactory;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.validation.UtaNodeValidator;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.UtaLanguageParserFactory;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.UtaNodeMarshaller;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.UtaNodeMarshaller.UtaMarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.UtaNode;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.validation.ValidationResult;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.composite.UtaSystem;

import java.io.InputStream;

public class UtaParser {
	public static UtaParser newInstance() {
		return newInstance(UtaLanguageParserFactory.newInstance());
	}

	public static UtaParser newInstance(UtaLanguageParserFactory languageParserFactory) {
		if (languageParserFactory == null)
			throw new IllegalArgumentException("Missing language parser factory.");
		UtaParser parser = new UtaParser();
		parser.converter = UtaConverterFactory.newConverter(languageParserFactory);
		return parser;
	}

	private UtaNodeConverter converter;

	private UtaParser() { }

	public UtaNodeConverter getConverter() {
		return converter;
	}

	public UtaSystem parse(InputStream in) throws UtaParseException {
		try {
			UtaNode ntaXml = UtaNodeMarshaller.unmarshal(in);
			UtaNodeValidator validator = UtaNodeValidator.newInstance(ntaXml);
			ValidationResult validationResult = validator.validate();
			if (validationResult.hasErrors())
				throw UtaParseException.wrap(validationResult);
			return getConverter().convert(ntaXml);
		} catch (UtaMarshallingException ex) {
			throw UtaParseException.wrap(ex);
		} catch (UtaCodeException ex) {
			throw UtaParseException.wrap(ex);
		}
	}
}
