package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.ErrorListenerFactory;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.UtaLanguageParserFactory;

public class NtaConverterFactory {
	public static NtaConverter newConverter(UtaLanguageParserFactory languageParserFactory) {
		languageParserFactory.getErrorListeners().add(ErrorListenerFactory.silentListener());
		NtaTemplateConverter templateParser = NtaTemplateConverter.newInstance(languageParserFactory);
		return NtaConverter.newInstance(templateParser, languageParserFactory);
	}
}
