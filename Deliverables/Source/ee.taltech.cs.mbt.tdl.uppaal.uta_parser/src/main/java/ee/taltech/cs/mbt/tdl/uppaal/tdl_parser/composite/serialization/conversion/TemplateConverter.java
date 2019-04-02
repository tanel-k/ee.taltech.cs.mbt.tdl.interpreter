package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.conversion;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.language.GenerationQueue;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.InitialLocationNode;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.LocalDeclarationsNode;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.LocationLabelNode;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.LocationNode;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.MarkerNode;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.ParametersNode;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.TemplateNode;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.TransitionLabelNode;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.TransitionNode;
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
		return null; // TODO
	}

	private void injectLocationData(LocationNode locationNode, Location location) {
		locationNode.setId(location.getId());
		locationNode.setName(
				ConversionUtils.nameNodeFor(location.getName())
		);

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

		// TODO:
		location.getLabels();
	}

	private TransitionLabelNode createTransitionLabel(AbsUtaLabel<?> label) {
		TransitionLabelNode labelNode = new TransitionLabelNode();
		if (label instanceof AssignmentsLabel) {
			// TODO
		} else if (label instanceof CommentLabel) {
			// TODO
		} else if (label instanceof GuardLabel) {
			// TODO
		} else if (label instanceof InvariantLabel) {
			// TODO
		} else if (label instanceof SelectionLabel) {
			// TODO
		} else if (label instanceof SynchronizationLabel) {
			// TODO
		} else {
			return null;
		}
		return labelNode;
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
		// TODO
		transition.getNails();
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
