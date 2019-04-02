package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.language.ParseQueue;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.UtaLanguageParserFactory;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.SystemNode;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.TemplateNode;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.UtaNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;

public class UtaNodeConverter {
	public static UtaNodeConverter newInstance(UtaLanguageParserFactory languageParserFactory, ParseQueue parseQueue) {
		return new UtaNodeConverter(languageParserFactory, parseQueue);
	}

	private TemplateNodeConverter templateNodeConverter;
	private UtaLanguageParserFactory languageParserFactory;
	private ParseQueue parseQueue;

	private UtaNodeConverter(UtaLanguageParserFactory languageParserFactory, ParseQueue parseQueue) {
		this.templateNodeConverter = TemplateNodeConverter.newInstance(this);
		this.languageParserFactory = languageParserFactory;
		this.parseQueue = parseQueue;
	}

	private void injectGlobalDeclarations(UtaSystem utaSystem, SystemNode ntaSystem) {
		if (!ntaSystem.isSetDeclaration() || !ntaSystem.getDeclaration().isSetValue())
			return;

		getParseQueue().enqueue(
				ntaSystem.getDeclaration().getValue(),
				getParserFactory().declarationsParser(),
				utaSystem::setGlobalDeclarations
		);
	}

	private void injectSystemDefinition(UtaSystem utaSystem, SystemNode ntaSystem) {
		if (!ntaSystem.isSetSystem() || !ntaSystem.getSystem().isSetValue())
			return;

		getParseQueue().enqueue(
				ntaSystem.getSystem().getValue(),
				getParserFactory().systemDefinitionParser(),
				utaSystem::setSystemDefinition
		);
	}

	private void injectTemplates(UtaSystem utaSystem, SystemNode ntaSystem) {
		if (!ntaSystem.isSetTemplates())
			return;

		for (TemplateNode xmlTemplate : ntaSystem.getTemplates()) {
			Template template = getTemplateNodeConverter().parse(xmlTemplate);
			utaSystem.getTemplateMap().put(template.getName(), template);
		}
	}

	private TemplateNodeConverter getTemplateNodeConverter() {
		return templateNodeConverter;
	}

	public UtaLanguageParserFactory getParserFactory() {
		return languageParserFactory;
	}

	public ParseQueue getParseQueue() {
		return parseQueue;
	}

	public UtaSystem convert(UtaNode ntaXml) {
		UtaSystem system = new UtaSystem();

		injectGlobalDeclarations(system, ntaXml);
		injectSystemDefinition(system, ntaXml);
		injectTemplates(system, ntaXml);

		return system;
	}
}
