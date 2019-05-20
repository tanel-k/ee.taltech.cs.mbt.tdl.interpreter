package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.composition;

import ee.taltech.cs.mbt.tdl.commons.utils.data_structures.DirectedMultigraph;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.base.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.AbsTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.AbsTrapsetEvaluation.TrapsetImplementationDetail;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.IEvaluatedTrapsetVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.impl.AbsoluteComplementTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.impl.LinkedPairsTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.impl.RelativeComplementTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.impl.WrappedTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.utils.UTAExpressionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.ArrayLookupExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.ConjunctionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.GroupedExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.LiteralConsts;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.impl.literal.NaturalNumberLiteral;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.SizeExpressionArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.template.Synchronization;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BaseTypeIdentifiers;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.gui.coordinate_utils.GuiCoordinateUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.labels.impl.AssignmentsLabel;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.transitions.Transition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.transitions.TransitionLabels;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;

class TrapsetInjector implements IEvaluatedTrapsetVisitor<Void> {
	private final UtaSystem targetSystem;
	private final Map<Template, Map<Transition, Collection<Synchronization>>> transitionSynchHooksMap;

	TrapsetInjector(UtaSystem sutModel, Map<Template, Map<Transition, Collection<Synchronization>>> transitionSynchHooksMap) {
		this.targetSystem = sutModel;
		this.transitionSynchHooksMap = transitionSynchHooksMap;
	}

	private AbsExpression newLinkedPairElementaryEgressTrap(
			int trapIdx,
			AbsExpression lookupExpression,
			TrapsetImplementationDetail detail,
			Map<TrapsetImplementationDetail, Identifier> mapFlagArrayNames
	) {
		return UTAExpressionUtils.ternary(
				lookupExpression,
				LiteralConsts.TRUE,
				new ArrayLookupExpression()
						.setLeftChild(IdentifierExpression.of(mapFlagArrayNames.get(detail)))
						.setRightChild(NaturalNumberLiteral.of(trapIdx))
		);
	}

	private AbsExpression newLinkedPairConditionalEgressTrap(
			int trapIdx,
			AbsExpression lookupExpression,
			AbsExpression trapCondition,
			TrapsetImplementationDetail detail,
			Map<TrapsetImplementationDetail, Identifier> mapFlagArrayNames
	) {
		return UTAExpressionUtils.ternary(
				lookupExpression,
				LiteralConsts.TRUE,
				UTAExpressionUtils.wrapInGroup(new ConjunctionExpression()
						.setLeftChild(new ArrayLookupExpression()
								.setLeftChild(IdentifierExpression.of(mapFlagArrayNames.get(detail)))
								.setRightChild(NaturalNumberLiteral.of(trapIdx)))
						.setRightChild(UTAExpressionUtils.wrapInGroup(trapCondition))
				)
		);
	}

	public void inject(AbsTrapsetEvaluation trapset) {
		trapset.accept(this);
	}

	@Override
	public Void visitLinkedPairs(LinkedPairsTrapsetEvaluation trapset) {
		Map<TrapsetImplementationDetail, Identifier> mapFlagArrayNames = new HashMap<>();

		/*
		 * Declare ingress flag Boolean arrays.
		 * These flags are used to determine whether the system has moved onto a trapped egress transition from
		 * a transition that belongs in the ingress trapset.
		 */
		int trapCount = trapset.getTrapCount();
		for (TrapsetImplementationDetail detail : trapset.getTrapsetImplementationDetails()) {
			Identifier flagArrayName = Identifier.of(detail.getFlagArrayName() + "_IngressFlags");
			VariableDeclaration declaration = new VariableDeclaration()
					.setIdentifier(flagArrayName)
					.setType(new Type()
							.setBaseType(new BaseType()
									.setTypeId(BaseTypeIdentifiers.BOOLEAN)
							)
							.addArrayModifier(new SizeExpressionArrayModifier()
									.setSizeSpecifier(
											NaturalNumberLiteral.of(trapCount)
									)
							)
					);
			mapFlagArrayNames.put(detail, flagArrayName);
			targetSystem.getDeclarations().add(declaration);
		}

		// Add label to each trapped egress transition:
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
			Vector<Transition> ingressTransitionVector = trapset.getIngressTransitionVector(trappedEgressTransition);
			Vector<BaseTrapset> ingressTrapsetVector = trapset.getIngressTrapsetVector(trappedEgressTransition);

			for (TrapsetImplementationDetail detail : trapset.getTrapsetImplementationDetails()) {
				for (int i = 0; i < ingressTransitionVector.size(); i++) {
					Transition ingressTransition = ingressTransitionVector.get(i);
					BaseTrapset ingressTrapset = ingressTrapsetVector.get(i);

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

					// The ingress transition needs to set the appropriate ingress flag to True (flag = true).
					ingressTransition.getLabels().getAssignmentsLabel().getContent().add(
							new AssignmentExpression()
									.setLeftChild(new ArrayLookupExpression()
											.setLeftChild(IdentifierExpression.of(
													mapFlagArrayNames.get(detail)
											))
											.setRightChild(
													NaturalNumberLiteral.of(trapIdx)
											))
									.setRightChild(
											ingressTrapset.getMarkerCondition(ingressTransition).deepClone()
									)
					);

					// Unrelated transitions departing from the target of the ingress transition should reset the ingress flag:
					Location ingressTargetLocation = templateGraph.getTargetVertex(ingressTransition);
					for (Transition egressTransition : templateGraph.getEdgesFrom(ingressTargetLocation)) {
						if (egressTransition == ingressTransition) // Loop corner case.
							continue;
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

					// The egress transition needs to use the value of the flag (trap = flag).
					AbsExpression lookupExpression = new ArrayLookupExpression()
							.setLeftChild(IdentifierExpression.of(detail.getFlagArrayName()))
							.setRightChild(NaturalNumberLiteral.of(detail.getIndexCounter().next()));

					AssignmentExpression assignmentExpression = trapset
							.getMarkerAssignment(trappedEgressTransition).deepClone();
					assignmentExpression.setLeftChild(lookupExpression);
					// Create assignment label for egress transition:
					if (LiteralConsts.TRUE.equals(assignmentExpression.getRightChild())) {
						// Simple:
						assignmentExpression.setRightChild(
								newLinkedPairElementaryEgressTrap(trapIdx, lookupExpression, detail, mapFlagArrayNames)
						);
					} else {
						assignmentExpression.setRightChild(newLinkedPairConditionalEgressTrap(
								trapIdx, lookupExpression, assignmentExpression.getRightChild(), detail, mapFlagArrayNames
						));
					}

					transitionAssignments.add(assignmentExpression);
					// Flag reset label (flag = false):
					transitionAssignments.add(new AssignmentExpression()
							.setLeftChild(new ArrayLookupExpression()
									.setLeftChild(IdentifierExpression.of(
											mapFlagArrayNames.get(detail)
									))
									.setRightChild(
											NaturalNumberLiteral.of(trapIdx)
									))
							.setRightChild(LiteralConsts.FALSE));

					// Prevent adding the activating synchronization more than once:
					trapIdx++;
				}

				transitionSynchs.add(detail.getActivatingSynchronization());
			}
		}

		return null;
	}

	@Override
	public Void visitRelativeComplement(RelativeComplementTrapsetEvaluation trapset) {
		return visitCommonTrapsetEvaluation(trapset);
	}

	@Override
	public Void visitAbsoluteComplement(AbsoluteComplementTrapsetEvaluation trapset) {
		return visitCommonTrapsetEvaluation(trapset);
	}

	@Override
	public Void visitWrapped(WrappedTrapsetEvaluation trapset) {
		return visitCommonTrapsetEvaluation(trapset);
	}

	private Void visitCommonTrapsetEvaluation(AbsTrapsetEvaluation<?> trapset) {
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
						.setLeftChild(IdentifierExpression.of(detail.getFlagArrayName()))
						.setRightChild(NaturalNumberLiteral.of(detail.getIndexCounter().next()));

				AssignmentExpression trapAssignment = trapset.getMarkerAssignment(transition).deepClone();
				trapAssignment.setLeftChild(lookupExpression); // TS[index] = ...
				if (trapset.isConditional(transition)) {
					// Ensure trap visitations aren't reset:
					AbsExpression condExpression = trapAssignment.getRightChild();
					trapAssignment.setRightChild(UTAExpressionUtils.ternary(
							lookupExpression.deepClone(),
							LiteralConsts.TRUE,
							UTAExpressionUtils.wrapInGroup(condExpression)
					));
				}

				transitionAssignments.add(trapAssignment);
				transitionSynchs.add(detail.getActivatingSynchronization());
			}
		}

		return null;
	}

}
