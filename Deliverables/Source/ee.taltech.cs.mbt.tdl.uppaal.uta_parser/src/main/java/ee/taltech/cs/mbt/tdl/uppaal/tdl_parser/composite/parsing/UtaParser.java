package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion.NtaConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion.NtaConverterFactory;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion.NtaEmbeddedCodeParseException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.validation.NtaValidator;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.UtaLanguageParserFactory;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.NtaMarshaller;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.NtaMarshaller.NtaMarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeNta;
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
		parser.converter = NtaConverterFactory.newConverter(languageParserFactory);
		return parser;
	}

	private NtaConverter converter;

	private UtaParser() { }

	public NtaConverter getConverter() {
		return converter;
	}

	public UtaSystem parse(InputStream in) throws UtaParseException {
		try {
			XmlNodeNta ntaXml = NtaMarshaller.unmarshal(in);
			NtaValidator validator = NtaValidator.newInstance(ntaXml);
			ValidationResult validationResult = validator.validate();
			if (validationResult.hasErrors())
				throw UtaParseException.wrap(validationResult);
			return getConverter().convert(ntaXml);
		} catch (NtaMarshallingException ex) {
			throw UtaParseException.wrap(ex);
		} catch (NtaEmbeddedCodeParseException ex) {
			throw UtaParseException.wrap(ex);
		}
	}
}
