package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.xml.jaxb.XmlNodeName;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.xml.jaxb.XmlNodeTemplate;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.templates.UTATemplate;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.templates.UTATemplate.TemplateName;
import org.omg.CORBA.DynAnyPackage.Invalid;

public class UTATemplateParser {
	UTATemplateParser() { }

	public static class MissingNameException extends UTATemplateParseException { }

	public static class InvalidParametersException extends UTATemplateParseException {
		public InvalidParametersException(String msg, Throwable t) { super(msg, t); }
	}

	public static class InvalidLocalDeclarationsException extends UTATemplateParseException {
		public InvalidLocalDeclarationsException(String msg, Throwable t) { super(msg, t); }
	}

	public static class InvalidLocationsException extends UTATemplateParseException {
		public InvalidLocationsException(String msg) { super(msg); }
		public InvalidLocationsException(String msg, Throwable t) { super(msg, t); }
	}

	private void injectName(UTATemplate utaTemplate, XmlNodeTemplate templateXml) throws MissingNameException {
		XmlNodeName nameXml;
		if (!templateXml.isSetName() || !(nameXml = templateXml.getName()).isSetValue())
			throw new MissingNameException();
		TemplateName templateName = new UTATemplate.TemplateName();
		templateName.setNameString(nameXml.getValue());
		if (nameXml.isSetX() && nameXml.isSetY()) {
			templateName.setGuiCoordinates(
				new GuiCoordinates(nameXml.getX(), nameXml.getY())
			);
		}
	}

	private void injectParameters(UTATemplate utaTemplate, XmlNodeTemplate templateXml) throws InvalidParametersException {
		if (!templateXml.isSetParameter())
			return;
		templateXml.getParameter();
	}

	private void injectLocalDeclarations(UTATemplate utaTemplate, XmlNodeTemplate templateXml) {
		templateXml.getDeclaration();
	}

	private void injectLocations(UTATemplate utaTemplate, XmlNodeTemplate templateXml) throws InvalidLocationsException {
		templateXml.getInit();
		templateXml.getLocations();
		templateXml.getTransitions();
	}

	public UTATemplate parse(XmlNodeTemplate templateXml) throws MissingNameException, InvalidParametersException, InvalidLocationsException
	{
		UTATemplate utaTemplate = new UTATemplate();
		injectName(utaTemplate, templateXml);
		injectParameters(utaTemplate, templateXml);
		injectLocalDeclarations(utaTemplate, templateXml);
		injectLocations(utaTemplate, templateXml);
		return utaTemplate;
	}
}
