package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.UtaLanguageParserFactory;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.SystemNode;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.TemplateNode;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.UtaNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.composite.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.templates.UtaTemplate;

public class UtaNodeConverter {
	public static UtaNodeConverter newInstance(TemplateNodeConverter templateParser, UtaLanguageParserFactory languageParserFactory) {
		return new UtaNodeConverter(templateParser, languageParserFactory);
	}

	private TemplateNodeConverter templateNodeConverter;
	private UtaLanguageParserFactory languageParserFactory;

	private UtaNodeConverter(TemplateNodeConverter templateNodeConverter, UtaLanguageParserFactory languageParserFactory) {
		this.templateNodeConverter = templateNodeConverter;
		this.languageParserFactory = languageParserFactory;
	}

	private void injectGlobalDeclarations(UtaSystem utaSystem, SystemNode ntaSystem) throws UtaCodeException {
		if (!ntaSystem.isSetDeclaration() || !ntaSystem.getDeclaration().isSetValue())
			return;

		String globalDeclarations = ntaSystem.getDeclaration().getValue();
		try {
			utaSystem.setGlobalDeclarations(
				getLanguageParserFactory().declarationsParser()
					.parseInput(globalDeclarations)
			);
		} catch (ParseException ex) {
			throw new UtaCodeException("Could not parse global declarations.", ex)
				.setEmbeddedCode(globalDeclarations);
		}
	}

	private void injectSystemDefinition(UtaSystem utaSystem, SystemNode ntaSystem) throws UtaCodeException {
		if (!ntaSystem.isSetSystem() || !ntaSystem.getSystem().isSetValue())
			return;

		String systemDefinition = ntaSystem.getSystem().getValue();
		try {
			utaSystem.setSystemDefinition(
				getLanguageParserFactory().systemDefinitionParser()
					.parseInput(systemDefinition)
			);
		} catch (ParseException ex) {
			throw new UtaCodeException("Could not parse system definition.", ex)
				.setEmbeddedCode(systemDefinition);
		}
	}

	private void injectTemplates(UtaSystem utaSystem, SystemNode ntaSystem) throws UtaCodeException {
		if (!ntaSystem.isSetTemplates())
			return;

		for (TemplateNode xmlTemplate : ntaSystem.getTemplates()) {
			UtaTemplate template = getTemplateNodeConverter().parse(xmlTemplate);
			utaSystem.getTemplateMap().put(template.getName(), template);
		}
	}

	private TemplateNodeConverter getTemplateNodeConverter() {
		return templateNodeConverter;
	}

	private UtaLanguageParserFactory getLanguageParserFactory() {
		return languageParserFactory;
	}

	public UtaSystem convert(UtaNode ntaXml) throws UtaCodeException {
		UtaSystem system = new UtaSystem();

		injectGlobalDeclarations(system, ntaXml);
		injectSystemDefinition(system, ntaXml);
		injectTemplates(system, ntaXml);

		return system;
	}
}
