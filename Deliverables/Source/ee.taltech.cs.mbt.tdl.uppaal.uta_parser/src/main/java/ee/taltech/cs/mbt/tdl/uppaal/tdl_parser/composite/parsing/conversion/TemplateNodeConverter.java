package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.language.ParseOperationQueue;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.UtaLanguageParserFactory;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.UtaLocation.ELocationExitPolicy;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.UtaLocation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.UtaLocation.LocationName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.UtaLocationLabels;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.UtaTemplate;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.UtaTransition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.UtaTransition.TransitionNail;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.UtaTransitionLabels;

import java.util.HashMap;
import java.util.Map;

public class TemplateNodeConverter {
	public static TemplateNodeConverter newInstance(UtaNodeConverter parentConverter) {
		return new TemplateNodeConverter(parentConverter);
	}

	private UtaNodeConverter parentConverter;

	private TemplateNodeConverter(UtaNodeConverter parentConverter) {
		this.parentConverter = parentConverter;
	}

	private UtaNodeConverter getParentConverter() {
		return parentConverter;
	}

	private ParseOperationQueue getParseQueue() {
		return getParentConverter().getParseOperationQueue();
	}

	private UtaLanguageParserFactory getParserFactory() {
		return getParentConverter().getParserFactory();
	}

	private void injectParameters(UtaTemplate template, TemplateNode templateXml) {
		if (!templateXml.isSetParameter() || !templateXml.getParameter().isSetValue())
			return;

		getParseQueue().enqueue(
				templateXml.getParameter().getValue(),
				getParserFactory().parameterListParser(),
				template::setParameters
		);
	}

	private void injectLocalDeclarations(UtaTemplate utaTemplate, TemplateNode templateXml) {
		if (!templateXml.isSetDeclaration() || !templateXml.getDeclaration().isSetValue())
			return;

		getParseQueue().enqueue(
				templateXml.getDeclaration().getValue(),
				getParserFactory().declarationsParser(),
				utaTemplate::setLocalDeclarations
		);
	}

	private void injectLocationData(UtaLocation location, LocationNode locationXml) {
		location.setId(locationXml.getId());
		location.setCoordinates(new GuiCoordinates(locationXml.getX(), locationXml.getY()));

		location.setColor(UtaConversionUtils.parseColor(locationXml.getColor()));

		NameNode nameXml;
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

		injectLocationLabels(location, locationXml);
	}

	private void injectLocationLabels(UtaLocation location, LocationNode locationXml) {
		UtaLocationLabels labelContainer = new UtaLocationLabels();
		for (LocationLabelNode locationLabelXml : locationXml.getLabels()) {
			if (!locationLabelXml.isSetValue())
				continue;

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

				getParseQueue().enqueue(
						locationLabelXml.getValue(),
						getParserFactory().invariantParser(),
						invariantLabel::setContent
				);

				labelContainer.setInvariantLabel(invariantLabel);
				break;
			default:
				break;
			}

			label.setCoordinates(new GuiCoordinates(locationLabelXml.getX(), locationLabelXml.getY()));
		}

		location.setLabels(labelContainer);
	}

	private void injectTransitionLabels(UtaTransition transition, TransitionNode transitionXml) {
		UtaTransitionLabels labelContainer = new UtaTransitionLabels();
		for (TransitionLabelNode transitionLabelXml : transitionXml.getLabels()) {
			if (!transitionLabelXml.isSetValue())
				continue;

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

				getParseQueue().enqueue(
						transitionLabelXml.getValue(),
						getParserFactory().guardParser(),
						guardLabel::setContent
				);

				labelContainer.setGuardLabel(guardLabel);
				break;
			case SELECT:
				UtaSelectionLabel selectLabel;
				label = (selectLabel = new UtaSelectionLabel());

				getParseQueue().enqueue(
						transitionLabelXml.getValue(),
						getParserFactory().selectionParser(),
						selectLabel::setContent
				);

				labelContainer.setSelectLabel(selectLabel);
				break;
			case ASSIGNMENT:
				UtaAssignmentsLabel assignmentsLabel;
				label = (assignmentsLabel = new UtaAssignmentsLabel());

				getParseQueue().enqueue(
						transitionLabelXml.getValue(),
						getParserFactory().assignmentsParser(),
						assignmentsLabel::setContent
				);

				labelContainer.setAssignmentsLabel(assignmentsLabel);
				break;
			case SYNCHRONISATION:
				UtaSynchronizationLabel synchronizationLabel;
				label = (synchronizationLabel = new UtaSynchronizationLabel());

				getParseQueue().enqueue(
						transitionLabelXml.getValue(),
						getParserFactory().synchronizationParser(),
						synchronizationLabel::setContent
				);

				labelContainer.setSynchronizationLabel(synchronizationLabel);
			default:
				break;
			}

			label.setCoordinates(new GuiCoordinates(transitionLabelXml.getX(), transitionLabelXml.getY()));
		}

		transition.setLabels(labelContainer);
	}

	private void injectTransitionNails(UtaTransition transition, TransitionNode transitionXml) {
		for (TransitionNailNode nailXml : transitionXml.getNails()) {
			TransitionNail nail = new TransitionNail();
			nail.setCoordinates(new GuiCoordinates(nailXml.getX(), nailXml.getY()));
			transition.getNails().add(nail);
		}
	}

	private void injectTransitionData(UtaTransition transition, TransitionNode transitionXml) {
		injectTransitionLabels(transition, transitionXml);
		injectTransitionNails(transition, transitionXml);

		transition.setColor(UtaConversionUtils.parseColor(transitionXml.getColor()));
	}

	private void injectLocations(UtaTemplate template, TemplateNode templateXml) {
		InitialLocationNode initLocXml = templateXml.getInit();
		String initialLocationID = initLocXml.getRef();
		Map<String, UtaLocation> locationMap = new HashMap<>();
		UtaLocation initialLocation = null;

		for (LocationNode locationXml : templateXml.getLocations()) {
			UtaLocation location = new UtaLocation();
			injectLocationData(location, locationXml);
			locationMap.put(location.getId(), location);

			if (initialLocationID.equals(location.getId())) {
				initialLocation = location;
			}
		}

		template.setInitialLocation(initialLocation);
		for (TransitionNode transitionXml : templateXml.getTransitions()) {
			UtaTransition transition = new UtaTransition();
			injectTransitionData(transition, transitionXml);

			UtaLocation sourceLocation = locationMap.get(transitionXml.getSource().getRef());
			UtaLocation targetLocation = locationMap.get(transitionXml.getTarget().getRef());

			template.getLocationGraph().addEdge(sourceLocation, targetLocation, transition);
		}
	}

	public UtaTemplate parse(TemplateNode templateXml) {
		UtaTemplate utaTemplate = new UtaTemplate();
		utaTemplate.setName(templateXml.getName().getValue());

		injectParameters(utaTemplate, templateXml);
		injectLocalDeclarations(utaTemplate, templateXml);
		injectLocations(utaTemplate, templateXml);

		return utaTemplate;
	}
}
