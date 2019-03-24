package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.UtaLanguageParserFactory;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeNta;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeNtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeTemplate;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.composite.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.templates.UtaTemplate;

public class NtaConverter {
	public static NtaConverter newInstance(TemplateConverter templateParser, UtaLanguageParserFactory languageParserFactory) {
		return new NtaConverter(templateParser, languageParserFactory);
	}

	private TemplateConverter templateConverter;
	private UtaLanguageParserFactory languageParserFactory;

	private NtaConverter(TemplateConverter templateConverter, UtaLanguageParserFactory languageParserFactory) {
		this.templateConverter = templateConverter;
		this.languageParserFactory = languageParserFactory;
	}

	private void injectGlobalDeclarations(UtaSystem utaSystem, XmlNodeNtaSystem ntaSystem) throws EmbeddedCodeParseException {
		if (!ntaSystem.isSetDeclaration() || !ntaSystem.getDeclaration().isSetValue())
			return;

		String globalDeclarations = ntaSystem.getDeclaration().getValue();
		try {
			utaSystem.setGlobalDeclarations(
				getLanguageParserFactory().declarationsParser()
					.parseInput(globalDeclarations)
			);
		} catch (ParseException ex) {
			throw new EmbeddedCodeParseException("Could not parse global declarations.", ex)
				.setEmbeddedCode(globalDeclarations);
		}
	}

	private void injectSystemDefinition(UtaSystem utaSystem, XmlNodeNtaSystem ntaSystem) throws EmbeddedCodeParseException {
		if (!ntaSystem.isSetSystem() || !ntaSystem.getSystem().isSetValue())
			return;

		String systemDefinition = ntaSystem.getSystem().getValue();
		try {
			utaSystem.setSystemDefinition(
				getLanguageParserFactory().systemDefinitionParser()
					.parseInput(systemDefinition)
			);
		} catch (ParseException ex) {
			throw new EmbeddedCodeParseException("Could not parse system definition.", ex)
				.setEmbeddedCode(systemDefinition);
		}
	}

	private void injectTemplates(UtaSystem utaSystem, XmlNodeNtaSystem ntaSystem) throws EmbeddedCodeParseException {
		if (!ntaSystem.isSetTemplates())
			return;

		for (XmlNodeTemplate xmlTemplate : ntaSystem.getTemplates()) {
			UtaTemplate template = getTemplateConverter().parse(xmlTemplate);
			utaSystem.getTemplateMap().put(template.getName(), template);
		}
	}

	private TemplateConverter getTemplateConverter() {
		return templateConverter;
	}

	private UtaLanguageParserFactory getLanguageParserFactory() {
		return languageParserFactory;
	}

	public UtaSystem convert(XmlNodeNta ntaXml) throws EmbeddedCodeParseException {
		UtaSystem system = new UtaSystem();

		injectGlobalDeclarations(system, ntaXml);
		injectSystemDefinition(system, ntaXml);
		injectTemplates(system, ntaXml);

		return system;
	}
}
