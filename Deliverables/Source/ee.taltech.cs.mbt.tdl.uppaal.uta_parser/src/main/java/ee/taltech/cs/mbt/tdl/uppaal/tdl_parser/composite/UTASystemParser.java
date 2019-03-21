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
	public static class InvalidGlobalDeclarationsException extends UTASystemParseException {
		InvalidGlobalDeclarationsException(Throwable t) { super(t); }
	}

	public static class InvalidSystemDefinitionException extends UTASystemParseException {
		InvalidSystemDefinitionException(Throwable t) { super(t); }
	}

	public static class InvalidSystemInputException extends UTASystemParseException {
		InvalidSystemInputException(String msg, Throwable t) { super(msg, t); }
	}

	UTASystemParser() { }

	private void injectGlobalDeclarations(UTASystem utaSystem, XmlNodeNtaSystem ntaSystem) throws InvalidGlobalDeclarationsException {
		if (!ntaSystem.isSetDeclaration())
			return;
		XmlNodeGlobalDeclarations globalDeclarations = ntaSystem.getDeclaration();
		if (!globalDeclarations.isSetValue())
			return;
		try {
			utaSystem.getGlobalDeclarations().addAll(
				new UTADeclarationsParser().parseInput(ntaSystem.getDeclaration().getValue())
			);
		} catch (ParseException e) {
			throw new InvalidGlobalDeclarationsException(e);
		}
	}

	private void injectSystemDefinition(UTASystem utaSystem, XmlNodeNtaSystem ntaSystem) throws InvalidSystemDefinitionException {
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
			throw new InvalidSystemDefinitionException(ex);
		}
	}

	private void injectTemplates(UTASystem utaSystem, XmlNodeNtaSystem ntaSystem) throws UTATemplateParseException
	{
		if (!ntaSystem.isSetTemplates())
			return;
		UTATemplateParser templateParser = UTATemplateSerializerFactory.newParser();
		for (XmlNodeTemplate xmlTemplate : ntaSystem.getTemplates()) {
			UTATemplate template = templateParser.parse(xmlTemplate);
			utaSystem.getTemplateMap().put(template.getId(), template);
		}
	}

	public UTASystem parse(InputStream in) throws UTASystemParseException
	{
		try {
			XmlNodeNtaSystem ntaSystem = NtaMarshaller.unmarshal(in);
			UTASystem system = new UTASystem();

			injectGlobalDeclarations(system, ntaSystem);
			injectSystemDefinition(system, ntaSystem);
			injectTemplates(system, ntaSystem);

			return system;
		} catch (NtaMarshallingException ex) {
			throw new InvalidSystemInputException("Failed to deserialize system representation.", ex);
		}
	}
}
