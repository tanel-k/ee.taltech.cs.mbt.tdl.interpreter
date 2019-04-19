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
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.ArrayLookupExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.ConjunctionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.LiteralConsts;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_modifier.SizeExpressionArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Synchronization;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class ScenarioSystemComposer {
	public static ScenarioSystemComposer newInstance(UtaSystem baseSystem, ScenarioCompositionParameters parameters) {
		return new ScenarioSystemComposer(baseSystem, parameters);
	}

	private UtaSystem system;
	private ScenarioWrapperFactory wrapperFactory;

	public ScenarioSystemComposer(UtaSystem system, ScenarioCompositionParameters parameters) {
		this.system = system;
		this.wrapperFactory = ScenarioWrapperFactory.getInstance(parameters);
	}

	public void compose() {
		Map<Template, Map<Transition, Collection<Synchronization>>> hookMap = new HashMap<>();
		UtaSystem wrapperSystem = wrapperFactory.newSystem();
		ScenarioWrapperConstructionContext wrapperContext = wrapperFactory.getConstructionContext();

		for (Synchronization globalTransitionSynch : wrapperContext.getGloballyApplicableTransitionSynchs()) {
			handleGlobalSynch(system, globalTransitionSynch, hookMap);
		}

		for (AbsDerivedTrapset systemTrapset : wrapperContext.getDerivedTrapsetMap().values()) {
			handleTrapset(systemTrapset, hookMap);
		}

		insertOutputHooks(hookMap);

		system.merge(wrapperSystem);
	}

	private void handleGlobalSynch(UtaSystem system, Synchronization globalSynch, Map<Template, Map<Transition, Collection<Synchronization>>> hookMap) {
		system.getTemplates().stream().forEachOrdered(template -> {
				Map<Transition, Collection<Synchronization>> templateSynchMap = hookMap.computeIfAbsent(template, k -> new HashMap<>());
				for (Transition transition : template.getLocationGraph().getEdges()) {
					Collection<Synchronization> transitionSynchs = templateSynchMap
							.computeIfAbsent(transition, k -> new LinkedList<>());
					transitionSynchs.add(globalSynch);
				}
		});
	}

	private static void insertOutputHooks(Map<Template, Map<Transition, Collection<Synchronization>>> hookMap) {
		Map<Template, Integer> maxLocationIdMap = new HashMap<>();

		for (Entry<Template, Map<Transition, Collection<Synchronization>>> templateSynchEntry : hookMap.entrySet()) {
			Template template = templateSynchEntry.getKey();
			DirectedMultigraph<Location, Transition> graph = template.getLocationGraph();
			Map<Transition, Collection<Synchronization>> mapTransitionSynchs = templateSynchEntry.getValue();

			Integer maxId = maxLocationIdMap.computeIfAbsent(
					template, t -> t.getLocationGraph().getVertices().stream()
							.map(Location::getId)
							.mapToInt(Location::parseIdString)
							.max()
							.orElse(0)
			);
			for (Entry<Transition, Collection<Synchronization>> transitionSynchEntry : mapTransitionSynchs.entrySet()) {
				Transition transition = transitionSynchEntry.getKey();
				Location initSourceLocation = graph.getSourceVertex(transition);
				Location initTargetLocation = graph.getTargetVertex(transition);

				Collection<Synchronization> hookSynchs = transitionSynchEntry.getValue();

				List<GuiCoordinates> hookLocationCoords = GuiCoordinates.evenlyDistributedCoordinatesBetween(
						initSourceLocation.getCoordinates(),
						initTargetLocation.getCoordinates(),
						hookSynchs.size()
				);

				Integer hookLocationIdx = hookSynchs.size();
				Integer hookTransitionIdx = 0;
				Location prevHookLocation = null;
				Transition prevHookTransition = null;
				SynchronizationLabel prevHookSyncLabel = null;

				for (Synchronization hookSync : hookSynchs) {
					Location hookLocation = new Location()
							.setId(Location.composeIdString(++maxId))
							.setColor(Color.ORANGE)
							.setExitPolicy(ELocationExitPolicy.COMMITTED)
							.setCoordinates(hookLocationCoords.get(hookTransitionIdx));

					SynchronizationLabel hookSyncLabel;
					Transition hookTransition = new Transition()
							.setSource(hookLocation)
							.setColor(Color.ORANGE)
							.setLabels(new TransitionLabels()
									.setSynchronizationLabel(hookSyncLabel = (SynchronizationLabel) new SynchronizationLabel()
											.setContent(hookSync)));

					if (hookTransitionIdx == 0) {
						graph.removeEdge(transition);
						transition.setTarget(hookLocation);
						hookSyncLabel.setCoordinates(GuiCoordinates.middleCoordinates(
								initSourceLocation.getCoordinates(),
								hookLocation.getCoordinates()
						));
						graph.addEdge(initSourceLocation, hookLocation, transition);
					}

					if (hookTransitionIdx == hookLocationIdx - 1) {
						if (prevHookTransition == null) {
							hookTransition.setTarget(initTargetLocation);
							hookSyncLabel.setCoordinates(GuiCoordinates.middleCoordinates(
									hookLocation.getCoordinates(),
									initTargetLocation.getCoordinates()
							));
							graph.addEdge(hookLocation, initTargetLocation, hookTransition);
						} else {
							prevHookTransition.setTarget(hookLocation);
							prevHookSyncLabel.setCoordinates(GuiCoordinates.middleCoordinates(
									prevHookLocation.getCoordinates(),
									hookLocation.getCoordinates()
							));
							graph.addEdge(prevHookLocation, hookLocation, prevHookTransition);

							hookSyncLabel.setCoordinates(GuiCoordinates.middleCoordinates(
									hookLocation.getCoordinates(),
									initTargetLocation.getCoordinates()
							));
							hookTransition.setSource(hookLocation);
							hookTransition.setTarget(initTargetLocation);
							graph.addEdge(hookLocation, initTargetLocation, hookTransition);
						}
					} else if (hookTransitionIdx > 0) {
						prevHookTransition.setTarget(hookLocation);
						prevHookSyncLabel.setCoordinates(GuiCoordinates.middleCoordinates(
								prevHookLocation.getCoordinates(),
								hookLocation.getCoordinates()
						));
						graph.addEdge(prevHookLocation, hookLocation, prevHookTransition);
					}

					prevHookSyncLabel = hookSyncLabel;
					prevHookLocation = hookLocation;
					prevHookTransition = hookTransition;
					hookTransitionIdx++;
				}
			}

			maxLocationIdMap.put(template, maxId);
		}
	}

	private void handleTrapset(AbsDerivedTrapset systemTrapset, Map<Template, Map<Transition, Collection<Synchronization>>> hookMap) {
		systemTrapset.accept(new IDerivedTrapsetVisitor<Void>() {
			@Override
			public Void visitLinkedPair(LinkedPairTrapset trapset) {
				Map<TrapsetImplementationDetail, Identifier> mapFlagArrayNames = new HashMap<>();

				for (TrapsetImplementationDetail detail : trapset.getTrapsetImplementationDetails()) {
					Identifier flagArrayName = Identifier.of(detail.getArrayName() + "_Flags");
					VariableDeclaration declaration = new VariableDeclaration()
							.setIdentifier(flagArrayName)
							.setType(new Type()
									.setBaseType(new BaseType()
											.setTypeId(BaseTypeIdentifiers.BOOLEAN)
									)
									.addArrayModifier(new SizeExpressionArrayModifier()
											.setSizeSpecifier(
													NaturalNumberLiteral.of(trapset.getTrapCount())
											)
									)
							);
					mapFlagArrayNames.put(detail, flagArrayName);
					system.getDeclarations().add(declaration);
				}

				int trapIdx = 0;
				for (Transition trappedEgressTransition : trapset) {
					TransitionLabels labels = trappedEgressTransition.getLabels();
					Template parentTemplate = trapset.getParentTemplate(trappedEgressTransition);
					DirectedMultigraph<Location, Transition> templateGraph = parentTemplate.getLocationGraph();

					Location initSourceLocation = templateGraph.getSourceVertex(trappedEgressTransition);
					Location initTargetLocation = templateGraph.getTargetVertex(trappedEgressTransition);

					if (labels.getAssignmentsLabel() == null) {
						AssignmentsLabel label = AssignmentsLabel.of(new LinkedList<>())
								.setCoordinates(GuiCoordinates.middleCoordinates(
										initSourceLocation.getCoordinates(),
										initTargetLocation.getCoordinates()
								));
						labels.setAssignmentsLabel(label);
					}

					Map<Transition, Collection<Synchronization>> templateSynchMap = hookMap
							.computeIfAbsent(parentTemplate, k -> new HashMap<>());
					Collection<Synchronization> transitionSynchs = templateSynchMap
							.computeIfAbsent(trappedEgressTransition, k -> new LinkedList<>());

					Collection<AbsExpression> transitionAssignments = labels.getAssignmentsLabel().getContent();
					for (TrapsetImplementationDetail detail : trapset.getTrapsetImplementationDetails()) {
						Transition ingressTransition = trapset.getIngressTransition(trappedEgressTransition);
						if (ingressTransition.getLabels() == null)
							ingressTransition.setLabels(new TransitionLabels());

						if (ingressTransition.getLabels().getAssignmentsLabel() == null) {
							ingressTransition.getLabels().setAssignmentsLabel(
									AssignmentsLabel.of(new LinkedList<>())
											.setCoordinates(GuiCoordinates.middleCoordinates(
													ingressTransition.getSource().getCoordinates(),
													ingressTransition.getTarget().getCoordinates()
											))
							);
						}

						ingressTransition.getLabels().getAssignmentsLabel().getContent().add(
								new AssignmentExpression()
										.setLeftChild(new ArrayLookupExpression()
												.setLeftChild(IdentifierExpression.of(
														mapFlagArrayNames.get(detail)
												))
												.setRightChild(
														NaturalNumberLiteral.of(trapIdx)
												))
										.setRightChild(LiteralConsts.TRUE)
						);

						Location ingressTargetLocation = templateGraph.getTargetVertex(ingressTransition);
						for (Transition egressTransition : templateGraph.getEdgesFrom(ingressTargetLocation)) {
							if (egressTransition != trappedEgressTransition) {
								if (egressTransition.getLabels() == null)
									egressTransition.setLabels(new TransitionLabels());

								if (egressTransition.getLabels().getAssignmentsLabel() == null) {
									egressTransition.getLabels().setAssignmentsLabel(AssignmentsLabel.of(new LinkedList<>())
											.setCoordinates(GuiCoordinates.middleCoordinates(
													egressTransition.getSource().getCoordinates(),
													egressTransition.getTarget().getCoordinates()
											))
									);
								}

								egressTransition.getLabels().getAssignmentsLabel().getContent().add(
										new AssignmentExpression()
												.setLeftChild(new ArrayLookupExpression()
														.setLeftChild(IdentifierExpression.of(
																mapFlagArrayNames.get(detail)
														))
														.setRightChild(
																NaturalNumberLiteral.of(trapIdx)
														))
												.setRightChild(LiteralConsts.FALSE)
								);
							}
						}

						AbsExpression lookupExpression = new ArrayLookupExpression()
								.setLeftChild(IdentifierExpression.of(detail.getArrayName()))
								.setRightChild(NaturalNumberLiteral.of(detail.getIndexCounter().next()));

						AssignmentExpression assignmentExpression = trapset
								.getMarkerAssignment(trappedEgressTransition).deepClone();
						assignmentExpression.setLeftChild(lookupExpression);
						assignmentExpression.setRightChild(new ConjunctionExpression()
								.setLeftChild(new ArrayLookupExpression()
										.setLeftChild(IdentifierExpression.of(
												mapFlagArrayNames.get(detail)
										))
										.setRightChild(
												NaturalNumberLiteral.of(trapIdx)
										)
								)
								.setRightChild(assignmentExpression.getRightChild())
						);

						transitionAssignments.add(assignmentExpression);
						transitionAssignments.add(new AssignmentExpression()
								.setLeftChild(new ArrayLookupExpression()
										.setLeftChild(IdentifierExpression.of(
												mapFlagArrayNames.get(detail)
										))
										.setRightChild(
												NaturalNumberLiteral.of(trapIdx)
										))
								.setRightChild(LiteralConsts.FALSE));
						transitionSynchs.add(detail.getActivatingSynchronization());
					}

					trapIdx++;
				}

				return null;
			}

			@Override
			public Void visitAbsoluteComplement(AbsoluteComplementTrapset trapset) {
				return visitAny(trapset);
			}

			@Override
			public Void visitRelativeComplement(RelativeComplementTrapset trapset) {
				return visitAny(trapset);
			}

			private Void visitAny(AbsDerivedTrapset<?> trapset) {
				for (Transition transition : trapset) {
					TransitionLabels labels = transition.getLabels();
					Template parentTemplate = trapset.getParentTemplate(transition);
					DirectedMultigraph<Location, Transition> templateGraph = parentTemplate.getLocationGraph();

					Location initSourceLocation = templateGraph.getSourceVertex(transition);
					Location initTargetLocation = templateGraph.getTargetVertex(transition);

					if (labels.getAssignmentsLabel() == null) {
						AssignmentsLabel label = AssignmentsLabel.of(new LinkedList<>())
								.setCoordinates(GuiCoordinates.middleCoordinates(
										initSourceLocation.getCoordinates(),
										initTargetLocation.getCoordinates()
								));
						labels.setAssignmentsLabel(label);
					}

					Map<Transition, Collection<Synchronization>> templateSynchMap = hookMap
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
