package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.*;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.xml.jaxb.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.Color;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.labels.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.labels.generic.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.locations.ELocationExitPolicy;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.locations.UtaLocation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.locations.UtaLocation.LocationName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.locations.UtaLocationLabels;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.templates.UtaTemplate;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.transitions.UtaTransition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.transitions.UtaTransitionLabels;

import java.util.HashMap;
import java.util.Map;

public class UtaTemplateParser {// FIXME: Extract XML/structure validation
	private UtaLanguageParserFactory parserFactory = UtaLanguageParserFactory.newInstance();

	UtaTemplateParser() { }
	UtaTemplateParser(UtaLanguageParserFactory parserFactory) { this.parserFactory = parserFactory; }

	private void injectName(UtaTemplate utaTemplate, XmlNodeTemplate templateXml) throws SystemDeserializationException {
		XmlNodeName nameXml;
		if (!templateXml.isSetName() || !(nameXml = templateXml.getName()).isSetValue())
			throw new SystemDeserializationException("Template has no name.");
		utaTemplate.setName(nameXml.getValue());
	}

	private void injectParameters(UtaTemplate template, XmlNodeTemplate templateXml) throws SystemDeserializationException {
		XmlNodeParameters parametersXml;
		if (!templateXml.isSetParameter() || !(parametersXml = templateXml.getParameter()).isSetValue())
			return;
		try {
			template.getParameters().addAll(parserFactory.parameterListParser().parseInput(parametersXml.getValue()));
		} catch (ParseException ex) {
			throw new SystemDeserializationException("Failed to parse parameters for template " + template.getName() + " [" + ex.getMessage() + "]", ex);
		}
	}

	private void injectLocalDeclarations(UtaTemplate utaTemplate, XmlNodeTemplate templateXml) throws SystemDeserializationException {
		if (!templateXml.isSetDeclaration())
			return;
		XmlNodeLocalDeclarations localDeclarations = templateXml.getDeclaration();
		if (!localDeclarations.isSetValue())
			return;
		try {
			utaTemplate.getLocalDeclarations().addAll(parserFactory.declarationsParser().parseInput(templateXml.getDeclaration().getValue()));
		} catch (ParseException ex) {
			throw new SystemDeserializationException("Failed to parse template local declarations [" + ex.getMessage() + "].", ex);
		}
	}

	private void injectLocationData(UtaTemplate template, UtaLocation location, XmlNodeLocation locationXml) throws SystemDeserializationException {
		if (!locationXml.isSetId())
			throw new SystemDeserializationException("Location has no identifier in " + template.getName() + ".");
		location.setId(locationXml.getId());

		if (!locationXml.isSetX() || !locationXml.isSetY())
			throw new SystemDeserializationException(
				"Location " + location.getId() + " in " + template.getName() + " has no coordinates."
			);
		location.setCoordinates(new GuiCoordinates(locationXml.getX(), locationXml.getY()));

		if (locationXml.isSetUrgent() && locationXml.isSetCommitted())
			throw new SystemDeserializationException(
				"Location " + location.getId() + " in " + template.getName() + " cannot be both urgent and committed at the same time."
			);

		Color locationColor = null;
		if (locationXml.isSetColor()) {
			String colorString = locationXml.getColor();
			colorString = colorString.replace("#", "");
			try { locationColor = Color.of(colorString); } catch (Exception ex) { /* Irrelevant. */ }
		}
		location.setColor(locationColor);

		XmlNodeName nameXml;
		if (locationXml.isSetName() && (nameXml = locationXml.getName()).isSetX() && nameXml.isSetY()) {
			LocationName locationName = new UtaLocation.LocationName();
			locationName.setName(nameXml.getValue());
			locationName.setCoordinates(new GuiCoordinates(nameXml.getX(), nameXml.getY()));
			location.setName(locationName);
		}

		ELocationExitPolicy exitPolicy = ELocationExitPolicy.NORMAL;
		if (locationXml.isSetCommitted()) {
			exitPolicy = ELocationExitPolicy.COMMITTED;
		} else if (locationXml.isSetUrgent()) {
			exitPolicy = ELocationExitPolicy.URGENT;
		}
		location.setExitPolicy(exitPolicy);

		injectLocationLabels(template, location, locationXml);
	}

	private void injectLocationLabels(UtaTemplate template, UtaLocation location, XmlNodeLocation locationXml) throws SystemDeserializationException {
		UtaLocationLabels labelContainer = new UtaLocationLabels();
		for (XmlNodeLocationLabel locationLabelXml : locationXml.getLabels()) {
			if (!locationLabelXml.isSetValue())
				continue;
			if (!locationLabelXml.isSetKind())
				throw new SystemDeserializationException("Label for location " + location.getId() + " does not specify a kind.");
			AbsUtaLabel<?> label = null;
			switch (locationLabelXml.getKind()) {
				case COMMENTS:
					UtaCommentLabel commentLabel;
					label = (commentLabel = new UtaCommentLabel());
					commentLabel.setContent(locationLabelXml.getValue());
					labelContainer.setCommentLabel(commentLabel);
					break;
				case INVARIANT:
					UtaInvariantLabel invariantLabel;
					label = (invariantLabel = new UtaInvariantLabel());
					try {
						invariantLabel.setContent(parserFactory.invariantParser().parseInput(locationLabelXml.getValue()));
					} catch (ParseException ex) {
						throw new SystemDeserializationException(
							"Failed to parse invariant condition for location "
								+ location.getId()
								+ " in " + template.getName() + " [" + ex.getMessage() + "].",
							ex
						);
					}
					break;
				default:
					break;
			}

			if (!locationLabelXml.isSetX() || !locationLabelXml.isSetY())
				throw new SystemDeserializationException(
					"Location [" + location.getId() + "] label of kind '"
						+ locationLabelXml.getKind().value()
						+ "' has no coordinates in template " + template.getName() + "."
				);
			label.setCoordinates(new GuiCoordinates(locationLabelXml.getX(), locationLabelXml.getY()));
		}
		location.setLabelContainer(labelContainer);
	}

	private void injectTransitionLabels(UtaTemplate template, UtaTransition transition, XmlNodeTransition transitionXml) throws SystemDeserializationException {
		UtaTransitionLabels labelContainer = new UtaTransitionLabels();
		for (XmlNodeTransitionLabel transitionLabelXml : transitionXml.getLabels()) {
			if (!transitionLabelXml.isSetValue())
				continue;
			if (!transitionLabelXml.isSetKind())
				throw new SystemDeserializationException("Label for transition " + transition.getId() + " does not specify a kind.");
			AbsUtaLabel<?> label = null;
			switch (transitionLabelXml.getKind()) {
				case COMMENTS:
					UtaCommentLabel commentLabel;
					label = (commentLabel = new UtaCommentLabel());
					commentLabel.setContent(transitionLabelXml.getValue());
					labelContainer.setCommentLabel(commentLabel);
					break;
				case GUARD:
					UtaGuardLabel guardLabel;
					label = (guardLabel = new UtaGuardLabel());
					try {
						guardLabel.setContent(parserFactory.guardParser().parseInput(transitionLabelXml.getValue()));
					} catch (ParseException ex) {
						throw new SystemDeserializationException(
								"Failed to parse invariant condition for transition "
										+ transition.getId()
										+ " in " + template.getName() + " [" + ex.getMessage() + "].",
								ex
						);
					}
					break;
				case SELECT:
					UtaSelectLabel selectLabel;
					label = (selectLabel = new UtaSelectLabel());
					try {
						selectLabel.setContent(parserFactory.selectionParser().parseInput(transitionLabelXml.getValue()));
					} catch (ParseException ex) {
						throw new SystemDeserializationException(
								"Failed to parse selection expression for transition "
										+ transition.getId()
										+ " in " + template.getName() + " [" + ex.getMessage() + "].",
								ex
						);
					}
					break;
				case ASSIGNMENT:
					UtaUpdatesLabel updatesLabel;
					label = (updatesLabel = new UtaUpdatesLabel());
					try {
						updatesLabel.setContent(parserFactory.updatesParser().parseInput(transitionLabelXml.getValue()));
					} catch (ParseException ex) {
						throw new SystemDeserializationException(
								"Failed to parse assignments for transition "
										+ transition.getId()
										+ " in " + template.getName() + " [" + ex.getMessage() + "].",
								ex
						);
					}
					break;
				case SYNCHRONISATION:
					UtaSynchronizationLabel synchronizationLabel;
					label = (synchronizationLabel = new UtaSynchronizationLabel());
					try {
						synchronizationLabel.setContent(parserFactory.synchronizationParser().parseInput(transitionLabelXml.getValue()));
					} catch (ParseException ex) {
						throw new SystemDeserializationException(
								"Failed to parse synchronization for transition "
										+ transition.getId()
										+ " in " + template.getName() + " [" + ex.getMessage() + "].",
								ex
						);
					}
				default:
					break;
			}

			if (!transitionLabelXml.isSetX() || !transitionLabelXml.isSetY())
				throw new SystemDeserializationException(
						"Transition [" + transition.getId() +"] label of kind '"
								+ transitionLabelXml.getKind().value()
								+ "' has no coordinates in template " + template.getName() + "."
				);
			label.setCoordinates(new GuiCoordinates(transitionLabelXml.getX(), transitionLabelXml.getY()));
		}

		transition.setLabelContainer(labelContainer);
	}

	private void injectTransitionData(UtaTemplate template, UtaTransition transition, XmlNodeTransition transitionXml) throws SystemDeserializationException {

	}

	private void injectLocations(UtaTemplate template, XmlNodeTemplate templateXml) throws SystemDeserializationException {
		XmlNodeInitialLocation initLocXml;
		if (!templateXml.isSetInit() || !(initLocXml = templateXml.getInit()).isSetRef())
			throw new SystemDeserializationException("Template " + template.getName() + " must have an initial location.");

		if (!templateXml.isSetLocations())
			throw new SystemDeserializationException("Must define at least one location in template " + template.getName() + ".");

		UtaLocation initialLocation = null;
		String initialLocationID = initLocXml.getRef();
		Map<String, UtaLocation> locationMap = new HashMap<>();
		for (XmlNodeLocation locationXml : templateXml.getLocations()) {
			UtaLocation location = new UtaLocation();
			injectLocationData(template, location, locationXml);
			if (locationMap.put(location.getId(), location) != null) {
				throw new SystemDeserializationException(
					"Location id " + location.getId() + " is not unique within template "+  template.getName() + "."
				);
			}
			if (initialLocationID.equals(location.getId())) {
				initialLocation = location;
			}
		}

		if (initialLocation == null)
			throw new SystemDeserializationException(
				"Initial location " + initialLocationID + " in template " + template.getName() + " is undefined."
			);
		template.setInitialLocation(initialLocation);

		for (XmlNodeTransition transitionXml : templateXml.getTransitions()) {
			UtaTransition transition = new UtaTransition();
			injectTransitionData(template, transition, transitionXml);

			transitionXml.isSetSource(); // FIXME
			transitionXml.isSetTarget(); // FIXME

			UtaLocation sourceLocation = locationMap.get(transitionXml.getSource().getRef());
			UtaLocation targetLocation = locationMap.get(transitionXml.getTarget().getRef());
			template.getLocationGraph().addEdge(sourceLocation, targetLocation, transition);
		}
	}

	public UtaTemplate parse(XmlNodeTemplate templateXml) throws SystemDeserializationException
	{
		UtaTemplate utaTemplate = new UtaTemplate();
		injectName(utaTemplate, templateXml);
		injectParameters(utaTemplate, templateXml);
		injectLocalDeclarations(utaTemplate, templateXml);
		injectLocations(utaTemplate, templateXml);
		return utaTemplate;
	}
}
