package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.UTADeclarationsParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.UTASystemDefinitionParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.xml.NtaMarshaller;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.xml.NtaMarshaller.NtaMarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.xml.jaxb.XmlNodeGlobalDeclarations;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.xml.jaxb.XmlNodeNtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.xml.jaxb.XmlNodeSystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.xml.jaxb.XmlNodeTemplate;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.composite.UTASystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.templates.UTATemplate;

import java.io.InputStream;

public class UTASystemParser {
	UTASystemParser() { }

	private void injectGlobalDeclarations(UTASystem utaSystem, XmlNodeNtaSystem ntaSystem) throws UTASystemDeserializationEx {
		if (!ntaSystem.isSetDeclaration())
			return;
		XmlNodeGlobalDeclarations globalDeclarations = ntaSystem.getDeclaration();
		if (!globalDeclarations.isSetValue())
			return;
		try {
			utaSystem.getGlobalDeclarations().addAll(
				new UTADeclarationsParser().parseInput(ntaSystem.getDeclaration().getValue())
			);
		} catch (ParseException ex) {
			throw new UTASystemDeserializationEx("Could not parse global declarations [" + ex.getMessage() + "].", ex);
		}
	}

	private void injectSystemDefinition(UTASystem utaSystem, XmlNodeNtaSystem ntaSystem) throws UTASystemDeserializationEx {
		if (!ntaSystem.isSetSystem())
			return;
		XmlNodeSystemDefinition systemDefinition = ntaSystem.getSystem();
		if (!systemDefinition.isSetValue())
			return;
		try {
			utaSystem.setSystemDefinition(
				new UTASystemDefinitionParser().parseInput(systemDefinition.getValue())
			);
		} catch (ParseException ex) {
			throw new UTASystemDeserializationEx("Could not parse system definition [" + ex.getMessage() + "].", ex);
		}
	}

	private void injectTemplates(UTASystem utaSystem, XmlNodeNtaSystem ntaSystem) throws UTASystemDeserializationEx {
		if (!ntaSystem.isSetTemplates())
			return;
		UTATemplateParser templateParser = UTATemplateSerializerFactory.newParser();
		for (XmlNodeTemplate xmlTemplate : ntaSystem.getTemplates()) {
			UTATemplate template = templateParser.parse(xmlTemplate);
			if (utaSystem.getTemplateMap().put(template.getName(), template) != null) {
				throw new UTASystemDeserializationEx("Template name " + template.getName() + " is not unique within system.");
			}
		}
	}

	public UTASystem parse(InputStream in) throws UTASystemDeserializationEx
	{
		try {
			XmlNodeNtaSystem ntaSystem = NtaMarshaller.unmarshal(in);
			UTASystem system = new UTASystem();

			injectGlobalDeclarations(system, ntaSystem);
			injectSystemDefinition(system, ntaSystem);
			injectTemplates(system, ntaSystem);

			return system;
		} catch (NtaMarshallingException ex) {
			throw new UTASystemDeserializationEx("Failed to deserialize system representation.", ex);
		}
	}
}
