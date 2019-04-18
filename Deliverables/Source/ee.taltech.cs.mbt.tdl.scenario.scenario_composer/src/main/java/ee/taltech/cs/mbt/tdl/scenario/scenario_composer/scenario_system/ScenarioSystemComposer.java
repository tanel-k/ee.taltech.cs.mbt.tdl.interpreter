package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system;

import ee.taltech.cs.mbt.tdl.commons.utils.data_structures.DirectedMultigraph;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_wrapper.ScenarioWrapperFactory;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_wrapper.ScenarioWrapperFactory.ScenarioWrapperConstructionContext;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.derived.AbsoluteComplementTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.derived.LinkedPairTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.derived.RelativeComplementTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.generic.AbsDerivedTrapset.TrapsetImplementationDetail;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.generic.IDerivedTrapsetVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.ArrayLookupExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Synchronization;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.Color;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.SynchronizationLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location.ELocationExitPolicy;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.TransitionLabels;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * FIXME:
 * - Quantifier templates;
 * - Adapter template logic;
 * - Adding update expressions to edges in SUT;
 * - Adding synch edges to SUT (for both trapsets and adapters).
 */
public class ScenarioSystemComposer {
	public static ScenarioSystemComposer newInstance(UtaSystem baseSystem, ScenarioCompositionParameters parameters) {
		return new ScenarioSystemComposer(baseSystem, parameters);
	}

	private UtaSystem baseSystem;
	private ScenarioCompositionParameters parameters;
	private ScenarioWrapperFactory wrapperFactory;
	private Set<Transition> excludedTransitions = new LinkedHashSet<>();

	public ScenarioSystemComposer(UtaSystem baseSystem, ScenarioCompositionParameters parameters) {
		this.parameters = parameters;
		this.baseSystem = baseSystem;
		this.wrapperFactory = ScenarioWrapperFactory.getInstance(parameters);
	}

	private Map<Template, Map<Transition, Collection<Synchronization>>> synchMap = new HashMap<>();

	public void compose() {
		UtaSystem wrapperSystem = wrapperFactory.newSystem();
		ScenarioWrapperConstructionContext wrapperContext = wrapperFactory.getConstructionContext();

		for (Synchronization globalTransitionSynch : wrapperContext.getGloballyApplicableTransitionSynchs()) {
			applyGlobalSynch(globalTransitionSynch);
		}

		for (AbsDerivedTrapset derivedTrapset : wrapperContext.getDerivedTrapsetMap().values()) {
			applyTrapset(derivedTrapset);
		}

		applyOutputSynchronizations();
		// TODO: modify transitions in baseSystem.
		baseSystem.merge(wrapperSystem);
	}

	private void applyGlobalSynch(Synchronization globalTransitionSynch) {
		baseSystem.getTemplates().stream().forEachOrdered(template -> {
				Map<Transition, Collection<Synchronization>> templateSynchMap = synchMap.computeIfAbsent(template, k -> new HashMap<>());
				for (Transition transition : template.getLocationGraph().getEdges()) {
					Collection<Synchronization> transitionSynchs = templateSynchMap
							.computeIfAbsent(transition, k -> new LinkedList<>());
					transitionSynchs.add(globalTransitionSynch);
				}
		});
	}

	private void applyOutputSynchronizations() {
		for (Entry<Template, Map<Transition, Collection<Synchronization>>> templateSynchEntry : synchMap.entrySet()) {
			Template template = templateSynchEntry.getKey();
			DirectedMultigraph<Location, Transition> graph = template.getLocationGraph();
			Map<Transition, Collection<Synchronization>> mapTransitionSynchs = templateSynchEntry.getValue();
			// FIXME.
			for (Entry<Transition, Collection<Synchronization>> transitionSynchEntry : mapTransitionSynchs.entrySet()) {
				Transition transition = transitionSynchEntry.getKey();
				Collection<Synchronization> applicableSynchs = transitionSynchEntry.getValue();

				List<GuiCoordinates> outputCoordinates = GuiCoordinates.evenlyDistributedCoordinatesBetween(
						graph.getSourceVertex(transition).getCoordinates(),
						graph.getTargetVertex(transition).getCoordinates(),
						applicableSynchs.size()
				);

				Integer outputCount = applicableSynchs.size();
				Integer outputTransitionIndex = 0;
				Location prevOutputLocation = null;
				Transition prevOutputTransition = null;
				SynchronizationLabel prevSyncLabel = null;
				Location origSourceLocation = graph.getSourceVertex(transition);
				Location origTargetLocation = graph.getTargetVertex(transition);

				for (Synchronization synchronization : applicableSynchs) {
					Location outputLocation = new Location()
							.setId(String.valueOf(Math.random() * 100)) // TODO!
							.setColor(Color.ORANGE)
							.setExitPolicy(ELocationExitPolicy.COMMITTED)
							.setCoordinates(outputCoordinates.get(outputTransitionIndex));

					SynchronizationLabel syncLabel;
					Transition outputTransition = new Transition()
							.setSource(outputLocation)
							.setColor(Color.ORANGE)
							.setLabels(new TransitionLabels()
									.setSynchronizationLabel(syncLabel = (SynchronizationLabel) new SynchronizationLabel()
											.setContent(synchronization)));

					if (outputTransitionIndex == 0) {
						graph.removeEdge(transition);
						// FIXME: Adjust transition label position.
						transition.setTarget(outputLocation);
						syncLabel.setCoordinates(GuiCoordinates.middleCoordinates(
								origSourceLocation.getCoordinates(),
								outputLocation.getCoordinates()
						));
						graph.addEdge(origSourceLocation, outputLocation, transition);
					}

					if (outputTransitionIndex == outputCount - 1) {
						if (prevOutputTransition == null) {
							outputTransition.setTarget(origTargetLocation);
							syncLabel.setCoordinates(GuiCoordinates.middleCoordinates(
									outputLocation.getCoordinates(),
									origTargetLocation.getCoordinates()
							));
							graph.addEdge(outputLocation, origTargetLocation, outputTransition);
						} else {
							prevOutputTransition.setTarget(outputLocation);
							outputTransition.setSource(outputLocation);
							outputTransition.setTarget(origTargetLocation);
							prevSyncLabel.setCoordinates(GuiCoordinates.middleCoordinates(
									prevOutputLocation.getCoordinates(),
									outputLocation.getCoordinates()
							));
							graph.addEdge(prevOutputLocation, outputLocation, prevOutputTransition);
							syncLabel.setCoordinates(GuiCoordinates.middleCoordinates(
									outputLocation.getCoordinates(),
									origTargetLocation.getCoordinates()
							));
							graph.addEdge(outputLocation, origTargetLocation, outputTransition);
						}
					} else if (outputTransitionIndex > 0) {
						prevOutputTransition.setTarget(outputLocation);
						prevSyncLabel.setCoordinates(GuiCoordinates.middleCoordinates(
								prevOutputLocation.getCoordinates(),
								outputLocation.getCoordinates()
						));
						graph.addEdge(prevOutputLocation, outputLocation, prevOutputTransition);
						outputTransition.setSource(prevOutputLocation);
					}

					prevSyncLabel = syncLabel;
					prevOutputLocation = outputLocation;
					prevOutputTransition = outputTransition;
					outputTransitionIndex++;
				}
			}
		}
	}

	private void applyTrapset(AbsDerivedTrapset trapset) {
		trapset.accept(new IDerivedTrapsetVisitor<Void>() {
			@Override
			public Void visitAbsoluteComplement(AbsoluteComplementTrapset trapset) {
				for (Transition transition : trapset) {
					TransitionLabels labels = transition.getLabels();
					Template parentTemplate = trapset.getParentTemplate(transition);
					DirectedMultigraph<Location, Transition> graph = parentTemplate.getLocationGraph();

					Location origSourceLocation = graph.getSourceVertex(transition);
					Location origTargetLocation = graph.getTargetVertex(transition);

					if (labels.getAssignmentsLabel() == null) {
						AssignmentsLabel label = AssignmentsLabel.of(new LinkedList<>())
								.setCoordinates(GuiCoordinates.middleCoordinates(
										origSourceLocation.getCoordinates(),
										origTargetLocation.getCoordinates()
								));
						labels.setAssignmentsLabel(label);
					}

					Map<Transition, Collection<Synchronization>> templateSynchMap = synchMap
							.computeIfAbsent(parentTemplate, k -> new HashMap<>());
					Collection<Synchronization> transitionSynchs = templateSynchMap
							.computeIfAbsent(transition, k -> new LinkedList<>());

					Collection<AbsExpression> transitionAssignments = labels.getAssignmentsLabel().getContent();
					for (TrapsetImplementationDetail detail : trapset.getTrapsetImplementationDetails()) {
						AbsExpression lookupExpression = new ArrayLookupExpression()
								.setLeftChild(IdentifierExpression.of(detail.getArrayName()))
								.setRightChild(NaturalNumberLiteral.of(detail.getIndexCounter().next()));

						AssignmentExpression assignmentExpression = trapset.getMarkerAssignment(transition).deepClone();
						assignmentExpression.setLeftChild(lookupExpression);

						transitionAssignments.add(assignmentExpression);
						transitionSynchs.add(detail.getActivatingSynchronization());
					}
				}

				return null;
			}

			@Override
			public Void visitLinkedPair(LinkedPairTrapset trapset) {
				// TODO: IngressFlag logic.
				return null;
			}

			@Override
			public Void visitRelativeComplement(RelativeComplementTrapset trapset) {
				// TODO: Duplication!
				for (Transition transition : trapset) {
					TransitionLabels labels = transition.getLabels();
					Template parentTemplate = trapset.getParentTemplate(transition);
					DirectedMultigraph<Location, Transition> graph = parentTemplate.getLocationGraph();

					Location origSourceLocation = graph.getSourceVertex(transition);
					Location origTargetLocation = graph.getTargetVertex(transition);

					if (labels.getAssignmentsLabel() == null) {
						AssignmentsLabel label = AssignmentsLabel.of(new LinkedList<>())
								.setCoordinates(GuiCoordinates.middleCoordinates(
										origSourceLocation.getCoordinates(),
										origTargetLocation.getCoordinates()
								));
						labels.setAssignmentsLabel(label);
					}

					Map<Transition, Collection<Synchronization>> templateSynchMap = synchMap
							.computeIfAbsent(parentTemplate, k -> new HashMap<>());
					Collection<Synchronization> transitionSynchs = templateSynchMap
							.computeIfAbsent(transition, k -> new LinkedList<>());

					Collection<AbsExpression> transitionAssignments = labels.getAssignmentsLabel().getContent();
					for (TrapsetImplementationDetail detail : trapset.getTrapsetImplementationDetails()) {
						AbsExpression lookupExpression = new ArrayLookupExpression()
								.setLeftChild(IdentifierExpression.of(detail.getArrayName()))
								.setRightChild(NaturalNumberLiteral.of(detail.getIndexCounter().next()));

						AssignmentExpression assignmentExpression = trapset.getMarkerAssignment(transition).deepClone();
						assignmentExpression.setLeftChild(lookupExpression);
						transitionAssignments.add(assignmentExpression);
						transitionSynchs.add(detail.getActivatingSynchronization());
					}
				}

				return null;
			}
		});
	}
}
