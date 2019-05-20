package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition;

import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.commons.utils.data_structures.DirectedMultigraph;
import ee.taltech.cs.mbt.tdl.commons.utils.objects.ObjectIdentityMap;
import ee.taltech.cs.mbt.tdl.commons.utils.primitives.Flag;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition.recognizer_tree.RecognizerTreeModelConstructionContext;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition.recognizer_tree.RecognizerTreeModelFactory;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.AbsTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.template.Synchronization;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.gui.Color;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.gui.GuiCoordinates;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.gui.coordinate_utils.GuiCoordinateUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl.SynchronizationLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.locations.Location.ELocationExitPolicy;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.transitions.Transition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.transitions.TransitionLabels;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ScenarioSystemComposer {
	public static ScenarioSystemComposer newInstance(ScenarioCompositionParameters parameters) {
		return new ScenarioSystemComposer(parameters);
	}

	private Flag completionFlag = Flag.newInstance();

	private RecognizerTreeModelFactory recognizerWrapperFactory;
	private ScenarioCompositionParameters parameters;

// The following procedure is deprecated, we'll it around for potential future use:
//	@Deprecated
//	private static void processGloballyApplicableTransitionSynch(
//			UtaSystem system,
//			Synchronization globalSynch,
//			Map<Template, Map<Transition, Collection<Synchronization>>> transitionSynchHooksMap
//	) {
//		system.getTemplates().stream().forEachOrdered(template -> {
//			Map<Transition, Collection<Synchronization>> templateSynchMap = transitionSynchHooksMap.computeIfAbsent(template, k -> new HashMap<>());
//			for (Transition transition : template.getLocationGraph().getEdges()) {
//				Collection<Synchronization> transitionSynchs = templateSynchMap
//						.computeIfAbsent(transition, k -> new LinkedList<>());
//				transitionSynchs.add(globalSynch);
//			}
//		});
//	}

	private static void appendNailsIfApplicable(LinkedList<LinkedList<GuiCoordinates>> nailSegments, Transition transition) {
		if (!nailSegments.isEmpty()) {
			transition.getNails().addAll(nailSegments.pollFirst());
		}
	}

	private static LinkedList<LinkedList<GuiCoordinates>> getNailSegments(
			List<GuiCoordinates> fullTransitionPath, List<GuiCoordinates> hookLocationCoords
	) {
		LinkedList<LinkedList<GuiCoordinates>> segments = GuiCoordinateUtils.segmentPath(
				fullTransitionPath, hookLocationCoords
		);

		// Get rid of origin location coordinates (first coordinate in first segment):
		for (LinkedList<GuiCoordinates> segment : segments) {
			if (!segment.isEmpty()) {
				segment.removeFirst();
				break;
			}
		}

		// Get rid of target location coordinates (last coordinate in last segment):
		for (int i = segments.size() - 1; i >= 0; i--) {
			if (!segments.get(i).isEmpty()) {
				segments.get(i).removeLast();
				break;
			}
		}

		return segments;
	}

	private static void injectSynchronizationHooks(
			Map<Template, Map<Transition, Collection<Synchronization>>> transitionSynchHooksMap
	) {
		Map<Template, Integer> maxLocationIdMap = new HashMap<>();

		for (Entry<Template, Map<Transition, Collection<Synchronization>>> templateSynchEntry : transitionSynchHooksMap.entrySet()) {
			Template template = templateSynchEntry.getKey();
			DirectedMultigraph<Location, Transition> graph = template.getLocationGraph();
			Map<Transition, Collection<Synchronization>> mapTransitionSynchs = templateSynchEntry.getValue();

			// Ensure new locations have ids that do not conflict with existing locations:
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
				// Calculate coordinates for hook locations:
				LinkedList<LinkedList<GuiCoordinates>> nailSegments = new LinkedList<>();
				List<GuiCoordinates> hookLocationCoords;
				if (transition.getNails().isEmpty()) {
					// If we're dealing with a straight line that has no nails in between:
					hookLocationCoords = GuiCoordinateUtils.evenlyDistributedCoordinatesBetween(
							initSourceLocation.getCoordinates(),
							initTargetLocation.getCoordinates(),
							hookSynchs.size()
					);
				} else {
					// Try to preserve nails on the transition:
					LinkedList<GuiCoordinates> transitionPath = CollectionUtils.collectionBuilder(new LinkedList<GuiCoordinates>())
							.add(initSourceLocation.getCoordinates())
							.addAll(transition.getNails())
							.add(initTargetLocation.getCoordinates())
							.build();
					hookLocationCoords = GuiCoordinateUtils.evenlyDistributedCoordinatesOnPath(
							transitionPath, hookSynchs.size()
					);
					nailSegments = getNailSegments(
							transitionPath, hookLocationCoords
					);
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
						appendNailsIfApplicable(nailSegments, transition);
					}

					if (hookTransitionIdx == hookLocationIdx - 1) {
						if (prevHookTransition == null) {
							hookTransition.setTarget(initTargetLocation);
							hookSyncLabel.setCoordinates(GuiCoordinateUtils.midpointCoordinates(
									hookLocation.getCoordinates(),
									initTargetLocation.getCoordinates()
							));
							graph.addEdge(hookLocation, initTargetLocation, hookTransition);
							appendNailsIfApplicable(nailSegments, hookTransition);
						} else {
							prevHookTransition.setTarget(hookLocation);
							prevHookSyncLabel.setCoordinates(GuiCoordinateUtils.midpointCoordinates(
									prevHookLocation.getCoordinates(),
									hookLocation.getCoordinates()
							));
							graph.addEdge(prevHookLocation, hookLocation, prevHookTransition);
							appendNailsIfApplicable(nailSegments, prevHookTransition);

							hookSyncLabel.setCoordinates(GuiCoordinateUtils.midpointCoordinates(
									hookLocation.getCoordinates(),
									initTargetLocation.getCoordinates()
							));
							hookTransition.setSource(hookLocation);
							hookTransition.setTarget(initTargetLocation);
							graph.addEdge(hookLocation, initTargetLocation, hookTransition);
							appendNailsIfApplicable(nailSegments, hookTransition);
						}
					} else if (hookTransitionIdx > 0) {
						prevHookTransition.setTarget(hookLocation);
						prevHookSyncLabel.setCoordinates(GuiCoordinateUtils.midpointCoordinates(
								prevHookLocation.getCoordinates(),
								hookLocation.getCoordinates()
						));
						graph.addEdge(prevHookLocation, hookLocation, prevHookTransition);
						appendNailsIfApplicable(nailSegments, prevHookTransition);
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

	public ScenarioSystemComposer(ScenarioCompositionParameters parameters) {
		this.parameters = parameters;
		this.recognizerWrapperFactory = RecognizerTreeModelFactory.getInstance(parameters);
	}

	public void compose() {
		if (completionFlag.isSet())
			return;

		// Construct scenario wrapper (recognizer structure):
		UtaSystem recognizerStructureModel = recognizerWrapperFactory.constructSystem();
		RecognizerTreeModelConstructionContext recognizerModelCtx = recognizerWrapperFactory.getConstructionContext();

		Map<Template, Map<Transition, Collection<Synchronization>>> transitionSynchHooksMap = new ObjectIdentityMap<>();
		// The following code has been deprecated but we should keep it here in case we need it.
		// Globally applicable transition synchronizations should be added to every transition in the system.
		// They represent conditions that hold on every system transition.
		// for (Synchronization globalTransitionSynch : wrapperContext.getGloballyApplicableTransitionSynchs()) {
		//	processGloballyApplicableTransitionSynch(parameters.getSutModel(), globalTransitionSynch, transitionSynchHooksMap);
		//}

		// Apply derived trapset labels to applicable transitions in the system:
		TrapsetInjector trapsetInjector = new TrapsetInjector(parameters.getSutModel(), transitionSynchHooksMap);
		for (AbsTrapsetEvaluation trapset : recognizerModelCtx.getTrapsetEvaluationMap().values()) {
			trapsetInjector.inject(trapset);
		}

		injectSynchronizationHooks(transitionSynchHooksMap);

		// Merge scenario wrapper into modified SUT model to form the final scenario model:
		parameters.getSutModel().merge(recognizerStructureModel);

		completionFlag.set();
	}
}
