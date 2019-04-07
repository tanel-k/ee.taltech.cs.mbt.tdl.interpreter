package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.conversion;

import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.language.GenerationQueue;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.UtaGeneratorFactory;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AbsUtaLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.CommentLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.GuardLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.InvariantLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.SelectionLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.SynchronizationLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition.Nail;

import java.util.Objects;

public class TemplateConverter {
	public static TemplateConverter getInstance(UtaSystemConverter parentConverter) {
		return new TemplateConverter(parentConverter);
	}

	private UtaSystemConverter parentConverter;

	private TemplateConverter(UtaSystemConverter parentConverter) {
		this.parentConverter = parentConverter;
	}

	private UtaSystemConverter getParentConverter() {
		return parentConverter;
	}

	private GenerationQueue getGenerationQueue() {
		return getParentConverter().getGenerationQueue();
	}

	private UtaGeneratorFactory getGeneratorFactory() {
		return getParentConverter().getGeneratorFactory();
	}

	private LocationLabelNode createLocationLabel(AbsUtaLabel<?> label) {
		LocationLabelNode labelNode = new LocationLabelNode();
		if (label instanceof InvariantLabel) {
			labelNode.setKind(ELocationLabelKindAttr.INVARIANT);
			getGenerationQueue().enqueue(
					((InvariantLabel) label).getContent(),
					getGeneratorFactory().expressionGenerator(),
					labelNode::setValue
			);
		} else if (label instanceof CommentLabel) {
			labelNode.setKind(ELocationLabelKindAttr.COMMENTS);
			labelNode.setValue(((CommentLabel) label).getContent());
		} else {
			return null;
		}
		labelNode.setX(label.getCoordinates().getX());
		labelNode.setY(label.getCoordinates().getY());
		return labelNode;
	}

	private void injectLocationData(LocationNode locationNode, Location location) {
		locationNode.setId(location.getId());
		if (location.getName() != null) {
			locationNode.setName(
					ConversionUtils.nameNodeFor(location.getName())
			);
		}

		switch (location.getExitPolicy()) {
		case URGENT:
			locationNode.setUrgent(new MarkerNode());
			break;
		case COMMITTED:
			locationNode.setCommitted(new MarkerNode());
			break;
		default:
			break;
		}

		locationNode.setColor(
				ConversionUtils.serializeColor(location.getColor())
		);
		locationNode.setX(location.getCoordinates().getX());
		locationNode.setY(location.getCoordinates().getY());

		location.getLabels().asCollection().stream()
				.map(this::createLocationLabel)
				.filter(Objects::nonNull)
				.forEach(locationNode.getLabels()::add);
	}

	private TransitionLabelNode createTransitionLabel(AbsUtaLabel<?> label) {
		TransitionLabelNode labelNode = new TransitionLabelNode();
		if (label instanceof AssignmentsLabel) {
			labelNode.setKind(EAttrTransitionLabelKindAttr.ASSIGNMENT);
			getGenerationQueue().enqueue(
					((AssignmentsLabel) label).getContent(),
					getGeneratorFactory().expressionGenerator(),
					labelNode::setValue
			);
		} else if (label instanceof CommentLabel) {
			labelNode.setKind(EAttrTransitionLabelKindAttr.COMMENTS);
			labelNode.setValue(((CommentLabel) label).getContent());
		} else if (label instanceof GuardLabel) {
			labelNode.setKind(EAttrTransitionLabelKindAttr.GUARD);
			getGenerationQueue().enqueue(
					((GuardLabel) label).getContent(),
					getGeneratorFactory().expressionGenerator(),
					labelNode::setValue
			);
		} else if (label instanceof SelectionLabel) {
			labelNode.setKind(EAttrTransitionLabelKindAttr.SELECT);
			getGenerationQueue().enqueue(
					((SelectionLabel) label).getContent(),
					getGeneratorFactory().selectionGenerator(),
					labelNode::setValue
			);
		} else if (label instanceof SynchronizationLabel) {
			labelNode.setKind(EAttrTransitionLabelKindAttr.SYNCHRONISATION);
			getGenerationQueue().enqueue(
					((SynchronizationLabel) label).getContent(),
					getGeneratorFactory().synchronizationGenerator(),
					labelNode::setValue
			);
		} else {
			return null;
		}
		labelNode.setX(label.getCoordinates().getX());
		labelNode.setY(label.getCoordinates().getY());
		return labelNode;
	}

	private TransitionNailNode createTransitionNail(Nail nail) {
		TransitionNailNode transitionNailNode = new TransitionNailNode();
		transitionNailNode.setX(nail.getCoordinates().getX());
		transitionNailNode.setY(nail.getCoordinates().getY());
		return transitionNailNode;
	}

	private void injectTransitionData(TransitionNode transitionNode, Transition transition) {
		Location source = transition.getSource();
		Location target = transition.getTarget();

		transitionNode.setColor(
				ConversionUtils.serializeColor(transition.getColor())
		);
		transitionNode.setSource(
				ConversionUtils.idReferenceFor(source.getId())
		);
		transitionNode.setTarget(
				ConversionUtils.idReferenceFor(target.getId())
		);

		transition.getLabels().asCollection().stream()
				.map(this::createTransitionLabel)
				.filter(Objects::nonNull)
				.forEach(transitionNode.getLabels()::add);
		transition.getNails().stream()
				.map(this::createTransitionNail)
				.forEach(transitionNode.getNails()::add);
	}

	private void injectLocations(TemplateNode templateNode, Template template) {
		InitialLocationNode initNode = new InitialLocationNode();
		initNode.setRef(template.getInitialLocation().getId());
		templateNode.setInit(initNode);

		for (Location location : template.getLocationGraph().getVertices()) {
			LocationNode locationNode = new LocationNode();
			injectLocationData(locationNode, location);
			templateNode.getLocations().add(locationNode);
		}

		for (Transition transition : template.getLocationGraph().getEdges()) {
			TransitionNode transitionNode = new TransitionNode();
			injectTransitionData(transitionNode, transition);
			templateNode.getTransitions().add(transitionNode);
		}
	}

	private void injectLocalDeclarations(TemplateNode templateNode, Template template) {
		if (template.getLocalDeclarations().isEmpty())
			return;

		LocalDeclarationsNode localDeclarationsNode = new LocalDeclarationsNode();
		getGenerationQueue().enqueue(
				template.getLocalDeclarations(),
				getGeneratorFactory().declarationGenerator(),
				localDeclarationsNode::setValue
		);
		templateNode.setDeclaration(localDeclarationsNode);
	}

	private void injectParameters(TemplateNode templateNode, Template template) {
		if (template.getParameters().isEmpty())
			return;

		ParametersNode parametersNode = new ParametersNode();
		getGenerationQueue().enqueue(
				template.getParameters(),
				getGeneratorFactory().parameterGenerator(),
				parametersNode::setValue
		);
		templateNode.setParameter(parametersNode);
	}

	public TemplateNode convert(Template template) {
		TemplateNode templateNode = new TemplateNode();
		templateNode.setName(ConversionUtils.nameNodeFor(template.getName()));

		injectParameters(templateNode, template);
		injectLocalDeclarations(templateNode, template);
		injectLocations(templateNode, template);

		return templateNode;
	}
}
