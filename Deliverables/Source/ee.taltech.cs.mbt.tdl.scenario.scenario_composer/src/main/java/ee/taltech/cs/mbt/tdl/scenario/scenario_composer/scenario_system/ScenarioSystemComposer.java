package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system;

import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.commons.utils.data_structures.DirectedMultigraph;
import ee.taltech.cs.mbt.tdl.commons.utils.math.MathUtils;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_wrapper.ScenarioWrapperFactory;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_wrapper.ScenarioWrapperFactory.ScenarioWrapperConstructionContext;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.derived.AbsoluteComplementTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.derived.LinkedPairTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.derived.RelativeComplementTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.AbsDerivedTrapset.TrapsetImplementationDetail;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.IDerivedTrapsetVisitor;
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
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.coordinate_utils.GuiCoordinateLineFunction;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.coordinate_utils.GuiCoordinateUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.labels.impl.SynchronizationLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location.ELocationExitPolicy;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.TransitionLabels;

import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

/*
 * FIXME:
 * - Lots of interdependence;
 * - Potential undiscovered bugs;
 * - Lots of duplication;
 * - APIs are too complicated/non-existent;
 * - Needs some kind of one-off operation pattern;
 * - No Exception handling logic;
 * - && True issue;
 * - lots of new Interface() { interfaceDefinition }; - need to define an interface with a clear API;
 * - global variable reliance within object;
 * - bad naming habits;
 * - lots of duplications.
 */
public class ScenarioSystemComposer {

	public static ScenarioSystemComposer newInstance(ScenarioCompositionParameters parameters) {
		return new ScenarioSystemComposer(parameters);
	}

	private ScenarioWrapperFactory wrapperFactory;
	private ScenarioCompositionParameters parameters;

	public ScenarioSystemComposer(ScenarioCompositionParameters parameters) {
		this.parameters = parameters;
		this.wrapperFactory = ScenarioWrapperFactory.getInstance(parameters);
	}

	public void compose() {
		Map<Template, Map<Transition, Collection<Synchronization>>> transitionSynchHooksMap = new HashMap<>();
		UtaSystem wrapperSystem = wrapperFactory.newSystem();
		ScenarioWrapperConstructionContext wrapperContext = wrapperFactory.getConstructionContext();

		for (Synchronization globalTransitionSynch : wrapperContext.getGloballyApplicableTransitionSynchs()) {
			handleGlobalSynch(parameters.getSutModel(), globalTransitionSynch, transitionSynchHooksMap);
		}

		for (AbsDerivedTrapset systemTrapset : wrapperContext.getDerivedTrapsetMap().values()) {
			handleTrapset(systemTrapset, transitionSynchHooksMap);
		}

		insertOutputHooks(transitionSynchHooksMap);

		parameters.getSutModel().merge(wrapperSystem);
	}

	private void handleGlobalSynch(UtaSystem system, Synchronization globalSynch, Map<Template, Map<Transition, Collection<Synchronization>>> transitionSynchHooksMap) {
		system.getTemplates().stream().forEachOrdered(template -> {
				Map<Transition, Collection<Synchronization>> templateSynchMap = transitionSynchHooksMap.computeIfAbsent(template, k -> new HashMap<>());
				for (Transition transition : template.getLocationGraph().getEdges()) {
					Collection<Synchronization> transitionSynchs = templateSynchMap
							.computeIfAbsent(transition, k -> new LinkedList<>());
					transitionSynchs.add(globalSynch);
				}
		});
	}

	private static boolean isBetween(GuiCoordinates coords, GuiCoordinates start, GuiCoordinates end) { // FIXME: Not good enough.
		return MathUtils.inRange(coords.getX(), start.getX(), end.getX())
				|| MathUtils.inRange(coords.getY(), start.getY(), end.getY());
	}

	private static void appendNailsIfApplicable(Stack<LinkedList<GuiCoordinates>> nailStack, Transition transition) {
		if (!nailStack.isEmpty()) {
			System.out.println(transition.getSource().getCoordinates());
			List<GuiCoordinates> nails = nailStack.pop();
			System.out.println(nails);
			transition.getNails().addAll(nails);
			System.out.println(transition.getTarget().getCoordinates());
		}
	}

	private static LinkedList<LinkedList<GuiCoordinates>> getNailSegments(
			List<GuiCoordinates> nailPath,
			List<GuiCoordinates> interceptingPoints
	) {
		// Seems adequate for most cases; should probably figure out dpcy with input:
		final double errorTolerance = 5.0;

		List<GuiCoordinateLineFunction> lineFunctions = new LinkedList<>();
		GuiCoordinates prevNailCoordinates = null;
		for (GuiCoordinates nailCoordinates : nailPath) {
			if (prevNailCoordinates != null) {
				lineFunctions.add(GuiCoordinateLineFunction.of(prevNailCoordinates, nailCoordinates));
			}
			prevNailCoordinates = nailCoordinates;
		}

		LinkedList<LinkedList<GuiCoordinates>> nailSegments = new LinkedList<>();
		int nailPtIdx = 0;
		int interceptPtIdx = 0;

		LinkedList<GuiCoordinates> segment = new LinkedList<>();
		nailSegments.add(segment);

		for (; nailPtIdx < lineFunctions.size(); nailPtIdx++) {
			GuiCoordinateLineFunction segLineFn = lineFunctions.get(nailPtIdx);
			GuiCoordinates startPt = nailPath.get(nailPtIdx);
			GuiCoordinates endPt = nailPath.get(nailPtIdx + 1);

			GuiCoordinates interceptPt = interceptingPoints.get(interceptPtIdx);
			if (!segLineFn.checkIntercepts(interceptPt, errorTolerance)) {
				// ... - startPt - endPt - ... - interceptPt - ...
				if (segment.isEmpty()) {
					// endPt in last iter is startPt in this iter.
					// If segment is empty, startPt does not exist in segment (not added in last iter as endPt).
					segment.add(startPt);
				}
				segment.add(endPt);
				continue;
			}

			if (segment.isEmpty()) {
				// endPt in last iter is startPt in this iter.
				// If segment is empty, startPt does not exist in segment (not added in last iter as endPt).
				segment.add(startPt);
			} // else: startPt is already in segment.

			while (++interceptPtIdx < interceptingPoints.size()
				&& segLineFn.checkIntercepts(interceptingPoints.get(interceptPtIdx), errorTolerance)
			) {
				// Still on the same segment but this time we have no other pts btwn interceptors.
				// ... - startPt - origInterceptPt - interceptPt - ... - endPt -
				segment = new LinkedList<>();
				nailSegments.add(segment);
			}

			if (interceptPtIdx < interceptingPoints.size()) {
				// Prepare for next iteration.
				segment = new LinkedList<>();
				nailSegments.add(segment);
			} else {
				break;
			}
		}

		// Final segment prep:
		if (!segment.isEmpty()
				&& nailPtIdx < nailPath.size()
				&& segment.getLast().equals(nailPath.get(nailPtIdx))
		) {
			nailPtIdx++;
		}

		// Final segment:
		segment = new LinkedList<>();
		nailSegments.add(segment);
		for (; nailPtIdx < nailPath.size(); nailPtIdx++) {
			segment.add(nailPath.get(nailPtIdx));
		}

		// Just in case:
		CollectionUtils.fill(nailSegments, interceptingPoints.size() + 1, LinkedList::new);

		return nailSegments;
	}

	private static void insertOutputHooks(Map<Template, Map<Transition, Collection<Synchronization>>> transitionSynchHooksMap) {
		Map<Template, Integer> maxLocationIdMap = new HashMap<>();

		for (Entry<Template, Map<Transition, Collection<Synchronization>>> templateSynchEntry : transitionSynchHooksMap.entrySet()) {
			Template template = templateSynchEntry.getKey();
			DirectedMultigraph<Location, Transition> graph = template.getLocationGraph();
			Map<Transition, Collection<Synchronization>> mapTransitionSynchs = templateSynchEntry.getValue();

			Integer maxLocationId = maxLocationIdMap.computeIfAbsent(
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

				// Need one location and transition per synchronization transition (hook).
				// Calculate coordinates for locations:
				Stack<LinkedList<GuiCoordinates>> nailStack = new Stack<>();
				List<GuiCoordinates> hookLocationCoords;
				if (transition.getNails().isEmpty()) {
					hookLocationCoords = GuiCoordinateUtils.evenlyDistributedCoordinatesBetween(
							initSourceLocation.getCoordinates(),
							initTargetLocation.getCoordinates(),
							hookSynchs.size()
					);
				} else {
					LinkedList<GuiCoordinates> transitionPath = CollectionUtils.collectionBuilder(new LinkedList<GuiCoordinates>())
							.add(initSourceLocation.getCoordinates())
							.addAll(transition.getNails())
							.add(initTargetLocation.getCoordinates())
							.build();

					hookLocationCoords = GuiCoordinateUtils.evenlyDistributedCoordinatesOnPath(transitionPath, hookSynchs.size());

					transitionPath.removeFirst();
					transitionPath.removeLast();

					LinkedList<LinkedList<GuiCoordinates>> nailSegments = getNailSegments(transitionPath, hookLocationCoords);
					while (!nailSegments.isEmpty()) {
						nailStack.add(nailSegments.pollLast());
					}
					transition.getNails().clear();
				}

				Integer hookLocationIdx = hookSynchs.size();
				Integer hookTransitionIdx = 0;
				Location prevHookLocation = null;
				Transition prevHookTransition = null;
				SynchronizationLabel prevHookSyncLabel = null;

				for (Synchronization hookSync : hookSynchs) {
					Location hookLocation = new Location()
							.setId(Location.composeIdString(++maxLocationId))
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
						hookSyncLabel.setCoordinates(GuiCoordinateUtils.midpointCoordinates(
								initSourceLocation.getCoordinates(),
								hookLocation.getCoordinates()
						));
						graph.addEdge(initSourceLocation, hookLocation, transition);
						appendNailsIfApplicable(nailStack, transition);
					}

					if (hookTransitionIdx == hookLocationIdx - 1) {
						if (prevHookTransition == null) {
							hookTransition.setTarget(initTargetLocation);
							hookSyncLabel.setCoordinates(GuiCoordinateUtils.midpointCoordinates(
									hookLocation.getCoordinates(),
									initTargetLocation.getCoordinates()
							));
							graph.addEdge(hookLocation, initTargetLocation, hookTransition);
							appendNailsIfApplicable(nailStack, hookTransition);
						} else {
							prevHookTransition.setTarget(hookLocation);
							prevHookSyncLabel.setCoordinates(GuiCoordinateUtils.midpointCoordinates(
									prevHookLocation.getCoordinates(),
									hookLocation.getCoordinates()
							));
							graph.addEdge(prevHookLocation, hookLocation, prevHookTransition);
							appendNailsIfApplicable(nailStack, prevHookTransition);

							hookSyncLabel.setCoordinates(GuiCoordinateUtils.midpointCoordinates(
									hookLocation.getCoordinates(),
									initTargetLocation.getCoordinates()
							));
							hookTransition.setSource(hookLocation);
							hookTransition.setTarget(initTargetLocation);
							graph.addEdge(hookLocation, initTargetLocation, hookTransition);
							appendNailsIfApplicable(nailStack, hookTransition);
						}
					} else if (hookTransitionIdx > 0) {
						prevHookTransition.setTarget(hookLocation);
						prevHookSyncLabel.setCoordinates(GuiCoordinateUtils.midpointCoordinates(
								prevHookLocation.getCoordinates(),
								hookLocation.getCoordinates()
						));
						graph.addEdge(prevHookLocation, hookLocation, prevHookTransition);
						appendNailsIfApplicable(nailStack, prevHookTransition);
					}

					prevHookSyncLabel = hookSyncLabel;
					prevHookLocation = hookLocation;
					prevHookTransition = hookTransition;
					hookTransitionIdx++;
				}
			}

			maxLocationIdMap.put(template, maxLocationId);
		}
	}

	// FIXME: Duplication.
	private void handleTrapset(AbsDerivedTrapset systemTrapset, Map<Template, Map<Transition, Collection<Synchronization>>> transitionSynchHooksMap) {
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
					parameters.getSutModel().getDeclarations().add(declaration);
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
								.setCoordinates(GuiCoordinateUtils.midpointCoordinates(
										initSourceLocation.getCoordinates(),
										initTargetLocation.getCoordinates()
								));
						labels.setAssignmentsLabel(label);
					}

					Map<Transition, Collection<Synchronization>> templateSynchMap = transitionSynchHooksMap
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
											.setCoordinates(GuiCoordinateUtils.midpointCoordinates(
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
											.setCoordinates(GuiCoordinateUtils.midpointCoordinates(
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
						if (LiteralConsts.TRUE.equals(assignmentExpression.getRightChild())) {
							assignmentExpression.setRightChild(new ArrayLookupExpression()
									.setLeftChild(IdentifierExpression.of(
											mapFlagArrayNames.get(detail)
									))
									.setRightChild(
											NaturalNumberLiteral.of(trapIdx)
									)
							);
						} else {
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
						}

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
				return visitCommonDerivedTrapset(trapset);
			}

			@Override
			public Void visitRelativeComplement(RelativeComplementTrapset trapset) {
				return visitCommonDerivedTrapset(trapset);
			}

			private Void visitCommonDerivedTrapset(AbsDerivedTrapset<?> trapset) {
				for (Transition transition : trapset) {
					TransitionLabels labels = transition.getLabels();
					Template parentTemplate = trapset.getParentTemplate(transition);
					DirectedMultigraph<Location, Transition> templateGraph = parentTemplate.getLocationGraph();

					Location initSourceLocation = templateGraph.getSourceVertex(transition);
					Location initTargetLocation = templateGraph.getTargetVertex(transition);

					if (labels.getAssignmentsLabel() == null) {
						AssignmentsLabel label = AssignmentsLabel.of(new LinkedList<>())
								.setCoordinates(GuiCoordinateUtils.midpointCoordinates(
										initSourceLocation.getCoordinates(),
										initTargetLocation.getCoordinates()
								));
						labels.setAssignmentsLabel(label);
					}

					Map<Transition, Collection<Synchronization>> templateSynchMap = transitionSynchHooksMap
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
