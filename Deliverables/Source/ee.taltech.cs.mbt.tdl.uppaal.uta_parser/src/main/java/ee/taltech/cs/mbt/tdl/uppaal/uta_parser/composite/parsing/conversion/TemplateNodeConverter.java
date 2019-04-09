package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.conversion;

import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.parsing.language.ParseQueue;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.UtaLanguageParserFactory;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.InitialLocationNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.LocationLabelNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.LocationNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.NameNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.TemplateNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.TransitionLabelNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.TransitionNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.CommentLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.GuardLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.InvariantLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.SelectionLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.SynchronizationLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location.ELocationExitPolicy;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location.LocationName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.LocationLabels;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.TransitionLabels;

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

	private ParseQueue getParseQueue() {
		return getParentConverter().getParseQueue();
	}

	private UtaLanguageParserFactory getParserFactory() {
		return getParentConverter().getParserFactory();
	}

	private void injectParameters(Template template, TemplateNode templateXml) {
		if (!templateXml.isSetParameter() || !templateXml.getParameter().isSetValue())
			return;

		getParseQueue().enqueue(
				templateXml.getParameter().getValue(),
				getParserFactory().parameterListParser(),
				template::setParameters
		);
	}

	private void injectLocalDeclarations(Template template, TemplateNode templateXml) {
		if (!templateXml.isSetDeclaration() || !templateXml.getDeclaration().isSetValue())
			return;

		getParseQueue().enqueue(
				templateXml.getDeclaration().getValue(),
				getParserFactory().declarationsParser(),
				template::setLocalDeclarations
		);
	}

	private void injectLocationData(Location location, LocationNode locationXml) {
		location.setId(locationXml.getId());
		location.setCoordinates(GuiCoordinates.of(locationXml.getX(), locationXml.getY()));

		location.setColor(ConversionUtils.parseColor(locationXml.getColor()));

		NameNode nameXml;
		if (locationXml.isSetName() && (nameXml = locationXml.getName()).isSetX() && nameXml.isSetY()) {
			LocationName locationName = new Location.LocationName();
			locationName.setName(nameXml.getValue());
			locationName.setCoordinates(GuiCoordinates.of(nameXml.getX(), nameXml.getY()));
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

	private void injectLocationLabels(Location location, LocationNode locationXml) {
		LocationLabels labelContainer = new LocationLabels();
		for (LocationLabelNode locationLabelXml : locationXml.getLabels()) {
			if (!locationLabelXml.isSetValue())
				continue;

			AbsUtaLabel<?> label = null;

			switch (locationLabelXml.getKind()) {
			case COMMENTS:
				CommentLabel commentLabel;
				label = (commentLabel = new CommentLabel());
				commentLabel.setContent(locationLabelXml.getValue());
				labelContainer.setCommentLabel(commentLabel);
				break;
			case INVARIANT:
				InvariantLabel invariantLabel;
				label = (invariantLabel = new InvariantLabel());

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

			label.setCoordinates(GuiCoordinates.of(locationLabelXml.getX(), locationLabelXml.getY()));
		}

		location.setLabels(labelContainer);
	}

	private void injectTransitionLabels(Transition transition, TransitionNode transitionXml) {
		TransitionLabels labelContainer = new TransitionLabels();
		for (TransitionLabelNode transitionLabelXml : transitionXml.getLabels()) {
			if (!transitionLabelXml.isSetValue())
				continue;

			AbsUtaLabel<?> label = null;

			switch (transitionLabelXml.getKind()) {
			case COMMENTS:
				CommentLabel commentLabel;

				label = (commentLabel = new CommentLabel());
				commentLabel.setContent(transitionLabelXml.getValue());
				labelContainer.setCommentLabel(commentLabel);

				break;
			case GUARD:
				GuardLabel guardLabel;
				label = (guardLabel = new GuardLabel());

				getParseQueue().enqueue(
						transitionLabelXml.getValue(),
						getParserFactory().guardParser(),
						guardLabel::setContent
				);

				labelContainer.setGuardLabel(guardLabel);
				break;
			case SELECT:
				SelectionLabel selectLabel;
				label = (selectLabel = new SelectionLabel());

				getParseQueue().enqueue(
						transitionLabelXml.getValue(),
						getParserFactory().selectionParser(),
						selectLabel::setContent
				);

				labelContainer.setSelectionLabel(selectLabel);
				break;
			case ASSIGNMENT:
				AssignmentsLabel assignmentsLabel;
				label = (assignmentsLabel = new AssignmentsLabel());

				getParseQueue().enqueue(
						transitionLabelXml.getValue(),
						getParserFactory().assignmentsParser(),
						assignmentsLabel::setContent
				);

				labelContainer.setAssignmentsLabel(assignmentsLabel);
				break;
			case SYNCHRONISATION:
				SynchronizationLabel synchronizationLabel;
				label = (synchronizationLabel = new SynchronizationLabel());

				getParseQueue().enqueue(
						transitionLabelXml.getValue(),
						getParserFactory().synchronizationParser(),
						synchronizationLabel::setContent
				);

				labelContainer.setSynchronizationLabel(synchronizationLabel);
			default:
				break;
			}

			label.setCoordinates(GuiCoordinates.of(transitionLabelXml.getX(), transitionLabelXml.getY()));
		}

		transition.setLabels(labelContainer);
	}

	private void injectTransitionNails(Transition transition, TransitionNode transitionXml) {
		transitionXml.getNails().stream()
				.map(n -> GuiCoordinates.of(n.getX(), n.getY()))
				.forEachOrdered(transition.getNails()::add);
	}

	private void injectTransitionData(Transition transition, TransitionNode transitionXml) {
		injectTransitionLabels(transition, transitionXml);
		injectTransitionNails(transition, transitionXml);

		transition.setColor(ConversionUtils.parseColor(transitionXml.getColor()));
	}

	private void injectLocations(Template template, TemplateNode templateXml) {
		InitialLocationNode initLocXml = templateXml.getInit();
		String initialLocationID = initLocXml.getRef();
		Map<String, Location> locationMap = new HashMap<>();
		Location initialLocation = null;

		for (LocationNode locationXml : templateXml.getLocations()) {
			Location location = new Location();
			injectLocationData(location, locationXml);
			locationMap.put(location.getId(), location);

			if (initialLocationID.equals(location.getId())) {
				initialLocation = location;
			}
		}

		template.setInitialLocation(initialLocation);
		for (TransitionNode transitionXml : templateXml.getTransitions()) {
			Transition transition = new Transition();
			injectTransitionData(transition, transitionXml);

			Location sourceLocation = locationMap.get(transitionXml.getSource().getRef());
			Location targetLocation = locationMap.get(transitionXml.getTarget().getRef());

			transition.setSource(sourceLocation);
			transition.setTarget(targetLocation);

			template.getLocationGraph().addEdge(sourceLocation, targetLocation, transition);
		}
	}

	public Template parse(TemplateNode templateXml) {
		Template template = new Template();
		template.setName(Identifier.of(templateXml.getName().getValue()));

		injectParameters(template, templateXml);
		injectLocalDeclarations(template, templateXml);
		injectLocations(template, templateXml);

		return template;
	}
}
