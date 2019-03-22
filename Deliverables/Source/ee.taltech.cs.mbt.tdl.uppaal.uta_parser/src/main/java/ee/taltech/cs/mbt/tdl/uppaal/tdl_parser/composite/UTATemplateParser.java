package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.*;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.xml.jaxb.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.Color;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.labels.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.labels.generic.AbsUTALabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.locations.ELocationExitPolicy;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.locations.UTALocation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.locations.UTALocation.LocationName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.locations.UTALocationLabelContainer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.templates.UTATemplate;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.transitions.UTATransition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structure.transitions.UTATransitionLabelContainer;

import java.util.HashMap;
import java.util.Map;

public class UTATemplateParser {
	UTATemplateParser() { }

	private void injectName(UTATemplate utaTemplate, XmlNodeTemplate templateXml) throws UTASystemDeserializationEx {
		XmlNodeName nameXml;
		if (!templateXml.isSetName() || !(nameXml = templateXml.getName()).isSetValue())
			throw new UTASystemDeserializationEx("Template has no name.");
		utaTemplate.setName(nameXml.getValue());
	}

	private void injectParameters(UTATemplate template, XmlNodeTemplate templateXml) throws UTASystemDeserializationEx {
		XmlNodeParameters parametersXml;
		if (!templateXml.isSetParameter() || !(parametersXml = templateXml.getParameter()).isSetValue())
			return;
		try {
			template.getParameters().addAll(
				new UTATemplateParametersParser().parseInput(parametersXml.getValue())
			);
		} catch (ParseException ex) {
			throw new UTASystemDeserializationEx("Failed to parse parameters for template " + template.getName() + " [" + ex.getMessage() + "]", ex);
		}
	}

	private void injectLocalDeclarations(UTATemplate utaTemplate, XmlNodeTemplate templateXml) throws UTASystemDeserializationEx {
		if (!templateXml.isSetDeclaration())
			return;
		XmlNodeLocalDeclarations localDeclarations = templateXml.getDeclaration();
		if (!localDeclarations.isSetValue())
			return;
		try {
			utaTemplate.getLocalDeclarations().addAll(
				new UTADeclarationsParser().parseInput(templateXml.getDeclaration().getValue())
			);
		} catch (ParseException ex) {
			throw new UTASystemDeserializationEx("Failed to parse template local declarations [" + ex.getMessage() + "].", ex);
		}
	}

	private void injectLocationData(UTATemplate template, UTALocation location, XmlNodeLocation locationXml) throws UTASystemDeserializationEx {
		if (!locationXml.isSetId())
			throw new UTASystemDeserializationEx("Location has no identifier in " + template.getName() + ".");
		location.setId(locationXml.getId());

		if (!locationXml.isSetX() || !locationXml.isSetY())
			throw new UTASystemDeserializationEx(
				"Location " + location.getId() + " in " + template.getName() + " has no coordinates."
			);
		location.setCoordinates(new GuiCoordinates(locationXml.getX(), locationXml.getY()));

		if (locationXml.isSetUrgent() && locationXml.isSetCommitted())
			throw new UTASystemDeserializationEx(
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
			LocationName locationName = new UTALocation.LocationName();
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

	private void injectLocationLabels(UTATemplate template, UTALocation location, XmlNodeLocation locationXml) throws UTASystemDeserializationEx {
		UTALocationLabelContainer labelContainer = new UTALocationLabelContainer();
		for (XmlNodeLocationLabel locationLabelXml : locationXml.getLabels()) {
			if (!locationLabelXml.isSetValue())
				continue;
			if (!locationLabelXml.isSetKind())
				throw new UTASystemDeserializationEx("Label for location " + location.getId() + " does not specify a kind.");
			AbsUTALabel<?> label = null;
			switch (locationLabelXml.getKind()) {
				case COMMENTS:
					UTACommentLabel commentLabel;
					label = (commentLabel = new UTACommentLabel());
					commentLabel.setContent(locationLabelXml.getValue());
					labelContainer.setCommentLabel(commentLabel);
					break;
				case INVARIANT:
					UTAInvariantLabel invariantLabel;
					label = (invariantLabel = new UTAInvariantLabel());
					try {
						new UTAInvariantParser().parseInput(locationLabelXml.getValue());
					} catch (ParseException ex) {
						throw new UTASystemDeserializationEx(
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
				throw new UTASystemDeserializationEx(
					"Location [" + location.getId() + "] label of kind '"
						+ locationLabelXml.getKind().value()
						+ "' has no coordinates in template " + template.getName() + "."
				);
			label.setCoordinates(new GuiCoordinates(locationLabelXml.getX(), locationLabelXml.getY()));
		}
		location.setLabelContainer(labelContainer);
	}

	private void injectTransitionLabels(UTATemplate template, UTATransition transition, XmlNodeTransition transitionXml) throws UTASystemDeserializationEx {
		UTATransitionLabelContainer labelContainer = new UTATransitionLabelContainer();
		for (XmlNodeTransitionLabel transitionLabelXml : transitionXml.getLabels()) {
			if (!transitionLabelXml.isSetValue())
				continue;
			if (!transitionLabelXml.isSetKind())
				throw new UTASystemDeserializationEx("Label for transition " + transition.getId() + " does not specify a kind.");
			AbsUTALabel<?> label = null;
			switch (transitionLabelXml.getKind()) {
				case COMMENTS:
					UTACommentLabel commentLabel;
					label = (commentLabel = new UTACommentLabel());
					commentLabel.setContent(transitionLabelXml.getValue());
					labelContainer.setCommentLabel(commentLabel);
					break;
				case GUARD:
					UTAGuardLabel guardLabel;
					label = (guardLabel = new UTAGuardLabel());
					try {
						guardLabel.setContent(
								new UTAGuardParser().parseInput(transitionLabelXml.getValue())
						);
					} catch (ParseException ex) {
						throw new UTASystemDeserializationEx(
								"Failed to parse invariant condition for transition "
										+ transition.getId()
										+ " in " + template.getName() + " [" + ex.getMessage() + "].",
								ex
						);
					}
					break;
				case SELECT:
					UTASelectLabel selectLabel;
					label = (selectLabel = new UTASelectLabel());
					try {
						selectLabel.setContent(
								new UTASelectionParser().parseInput(transitionLabelXml.getValue())
						);
					} catch (ParseException ex) {
						throw new UTASystemDeserializationEx(
								"Failed to parse selection expression for transition "
										+ transition.getId()
										+ " in " + template.getName() + " [" + ex.getMessage() + "].",
								ex
						);
					}
					break;
				case ASSIGNMENT:
					UTAUpdatesLabel updatesLabel;
					label = (updatesLabel = new UTAUpdatesLabel());
					try {
						updatesLabel.setContent(
								new UTAUpdatesParser().parseInput(transitionLabelXml.getValue())
						);
					} catch (ParseException ex) {
						throw new UTASystemDeserializationEx(
								"Failed to parse assignments for transition "
										+ transition.getId()
										+ " in " + template.getName() + " [" + ex.getMessage() + "].",
								ex
						);
					}
					break;
				case SYNCHRONISATION:
					UTASynchronizationLabel synchronizationLabel;
					label = (synchronizationLabel = new UTASynchronizationLabel());
					try {
						synchronizationLabel.setContent(
								new UTASynchronizationParser().parseInput(transitionLabelXml.getValue())
						);
					} catch (ParseException ex) {
						throw new UTASystemDeserializationEx(
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
				throw new UTASystemDeserializationEx(
						"Transition [" + transition.getId() +"] label of kind '"
								+ transitionLabelXml.getKind().value()
								+ "' has no coordinates in template " + template.getName() + "."
				);
			label.setCoordinates(new GuiCoordinates(transitionLabelXml.getX(), transitionLabelXml.getY()));
		}

		transition.setLabelContainer(labelContainer);
	}

	private void injectTransitionData(UTATemplate template, UTATransition transition, XmlNodeTransition transitionXml) throws UTASystemDeserializationEx {

	}

	private void injectLocations(UTATemplate template, XmlNodeTemplate templateXml) throws UTASystemDeserializationEx {
		XmlNodeInitialLocation initLocXml;
		if (!templateXml.isSetInit() || !(initLocXml = templateXml.getInit()).isSetRef())
			throw new UTASystemDeserializationEx("Template " + template.getName() + " must have an initial location.");

		if (!templateXml.isSetLocations())
			throw new UTASystemDeserializationEx("Must define at least one location in template " + template.getName() + ".");

		UTALocation initialLocation = null;
		String initialLocationID = initLocXml.getRef();
		Map<String, UTALocation> locationMap = new HashMap<>();
		for (XmlNodeLocation locationXml : templateXml.getLocations()) {
			UTALocation location = new UTALocation();
			injectLocationData(template, location, locationXml);
			if (locationMap.put(location.getId(), location) != null) {
				throw new UTASystemDeserializationEx(
					"Location id " + location.getId() + " is not unique within template "+  template.getName() + "."
				);
			}
			if (initialLocationID.equals(location.getId())) {
				initialLocation = location;
			}
		}

		if (initialLocation == null)
			throw new UTASystemDeserializationEx(
				"Initial location " + initialLocationID + " in template " + template.getName() + " is undefined."
			);
		template.setInitialLocation(initialLocation);

		for (XmlNodeTransition transitionXml : templateXml.getTransitions()) {
			UTATransition transition = new UTATransition();
			injectTransitionData(template, transition, transitionXml);

			transitionXml.isSetSource(); // FIXME
			transitionXml.isSetTarget(); // FIXME

			UTALocation sourceLocation = locationMap.get(transitionXml.getSource().getRef());
			UTALocation targetLocation = locationMap.get(transitionXml.getTarget().getRef());
			template.getLocationGraph().addEdge(sourceLocation, targetLocation, transition);
		}
	}

	public UTATemplate parse(XmlNodeTemplate templateXml) throws UTASystemDeserializationEx
	{
		UTATemplate utaTemplate = new UTATemplate();
		injectName(utaTemplate, templateXml);
		injectParameters(utaTemplate, templateXml);
		injectLocalDeclarations(utaTemplate, templateXml);
		injectLocations(utaTemplate, templateXml);
		return utaTemplate;
	}
}
