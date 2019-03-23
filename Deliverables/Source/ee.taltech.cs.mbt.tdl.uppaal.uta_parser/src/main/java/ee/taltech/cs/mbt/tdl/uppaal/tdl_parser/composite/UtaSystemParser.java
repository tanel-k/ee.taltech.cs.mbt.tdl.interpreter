package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.UtaLanguageParserFactory;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.NtaMarshaller;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.NtaMarshaller.NtaMarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeGlobalDeclarations;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeNtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeSystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.XmlNodeTemplate;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.composite.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.templates.UtaTemplate;

import java.io.InputStream;

public class UtaSystemParser { // FIXME: Extract XML/structure validation
	private UtaLanguageParserFactory parserFactory = UtaLanguageParserFactory.newInstance();
	UtaSystemParser() { }
	UtaSystemParser(UtaLanguageParserFactory parserFactory) { this.parserFactory = parserFactory; }

	private void injectGlobalDeclarations(UtaSystem utaSystem, XmlNodeNtaSystem ntaSystem) throws SystemDeserializationException {
		if (!ntaSystem.isSetDeclaration())
			return;
		XmlNodeGlobalDeclarations globalDeclarations = ntaSystem.getDeclaration();
		if (!globalDeclarations.isSetValue())
			return;
		try {
			utaSystem.getGlobalDeclarations().addAll(parserFactory.declarationsParser().parseInput(ntaSystem.getDeclaration().getValue()));
		} catch (ParseException ex) {
			throw new SystemDeserializationException("Could not parse global declarations [" + ex.getMessage() + "].", ex);
		}
	}

	private void injectSystemDefinition(UtaSystem utaSystem, XmlNodeNtaSystem ntaSystem) throws SystemDeserializationException {
		if (!ntaSystem.isSetSystem())
			return;
		XmlNodeSystemDefinition systemDefinition = ntaSystem.getSystem();
		if (!systemDefinition.isSetValue())
			return;
		try {
			utaSystem.setSystemDefinition(parserFactory.systemDefinitionParser().parseInput(systemDefinition.getValue()));
		} catch (ParseException ex) {
			throw new SystemDeserializationException("Could not parse system definition [" + ex.getMessage() + "].", ex);
		}
	}

	private void injectTemplates(UtaSystem utaSystem, XmlNodeNtaSystem ntaSystem) throws SystemDeserializationException {
		if (!ntaSystem.isSetTemplates())
			return;
		UtaTemplateParser templateParser = UtaTemplateSerializerFactory.newParser();
		for (XmlNodeTemplate xmlTemplate : ntaSystem.getTemplates()) {
			UtaTemplate template = templateParser.parse(xmlTemplate);
			if (utaSystem.getTemplateMap().put(template.getName(), template) != null) {
				throw new SystemDeserializationException("Template name " + template.getName() + " is not unique within system.");
			}
		}
	}

	public UtaSystem parse(InputStream in) throws SystemDeserializationException
	{
		try {
			XmlNodeNtaSystem ntaSystem = NtaMarshaller.unmarshal(in);
			UtaSystem system = new UtaSystem();

			injectGlobalDeclarations(system, ntaSystem);
			injectSystemDefinition(system, ntaSystem);
			injectTemplates(system, ntaSystem);

			return system;
		} catch (NtaMarshallingException ex) {
			throw new SystemDeserializationException("Failed to deserialize system representation.", ex);
		}
	}
}
