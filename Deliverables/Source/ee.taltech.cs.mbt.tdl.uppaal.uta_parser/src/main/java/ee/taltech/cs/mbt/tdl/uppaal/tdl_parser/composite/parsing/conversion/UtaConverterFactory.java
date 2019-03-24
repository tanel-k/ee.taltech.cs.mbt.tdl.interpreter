package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.configuration.ErrorListenerFactory;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.UtaLanguageParserFactory;

public class UtaConverterFactory {
	public static UtaNodeConverter newConverter(UtaLanguageParserFactory languageParserFactory) {
		languageParserFactory.getErrorListeners().add(ErrorListenerFactory.silentListener());
		TemplateNodeConverter templateParser = TemplateNodeConverter.newInstance(languageParserFactory);
		return UtaNodeConverter.newInstance(templateParser, languageParserFactory);
	}
}
