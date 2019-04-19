package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.construction;

import ee.taltech.cs.mbt.tdl.commons.utils.primitives.BooleanFlag;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IDerivedTrapsetVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseTdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.derived.AbsoluteComplementTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.derived.LinkedPairTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.derived.RelativeComplementTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.LinkedPairTrap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.AssignmentExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.ConjunctionExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.IdentifierExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.NegationExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.impl.literal.LiteralConsts;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.locations.Location;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.transitions.Transition;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DerivedTrapsetsExtractor {
	public static DerivedTrapsetsExtractor getInstance(UtaSystem system, TdlExpression expression, Map<TrapsetNode, BaseTrapset> baseTrapsetMap) {
		return new DerivedTrapsetsExtractor(system, expression, baseTrapsetMap);
	}

	private BooleanFlag completionFlag = BooleanFlag.newInstance();
	private UtaSystem system;
	private TdlExpression expression;
	private Map<TrapsetNode, BaseTrapset> baseTrapsetMap;
	private Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> derivedTrapsetMap = new HashMap<>();

	private DerivedTrapsetsExtractor(UtaSystem system, TdlExpression expression, Map<TrapsetNode, BaseTrapset> baseTrapsetMap) {
		this.system = system;
		this.expression = expression;
		this.baseTrapsetMap = baseTrapsetMap;
	}

	private void populateDerivedTrapsetMap() {
		for (AbsDerivedTrapsetNode<?> trapsetOperator : collectTrapsetOperators(expression)) {
			derivedTrapsetMap.put(trapsetOperator, trapsetOperator.accept(new IDerivedTrapsetVisitor<AbsDerivedTrapset>() {
				@Override
				public AbsDerivedTrapset visitAbsoluteComplement(AbsoluteComplementNode absoluteComplement) {
					BaseTrapset ts = baseTrapsetMap.get(absoluteComplement.getChildContainer().getChild());
					Identifier trapsetName = Identifier.of("AbsoluteComplementOf_" + ts.getName());
					AbsoluteComplementTrapset derivedTrapset = new AbsoluteComplementTrapset();
					derivedTrapset.setName(trapsetName);

					for (Template parentTemplate : system.getTemplates()) {
						for (Transition transition : parentTemplate.getLocationGraph().getEdges()) {
							if (ts.contains(transition)) {
								if (!ts.isConditional(transition))
									continue;
								AssignmentExpression markerExpr = (AssignmentExpression) new AssignmentExpression()
										.setLeftChild(IdentifierExpression.of(trapsetName))
										.setRightChild(new NegationExpression().setChild(ts.getMarkerCondition(transition)));
								derivedTrapset.addTrap(BaseTrap.of(parentTemplate, transition, markerExpr));
							} else {
								AssignmentExpression markerExpr = (AssignmentExpression) new AssignmentExpression()
										.setLeftChild(IdentifierExpression.of(trapsetName))
										.setRightChild(LiteralConsts.TRUE);
								derivedTrapset.addTrap(BaseTrap.of(parentTemplate, transition, markerExpr));
							}
						}
					}

					return derivedTrapset;
				}

				@Override
				public AbsDerivedTrapset visitLinkedPair(LinkedPairNode linkedPair) {
					BaseTrapset ingressTrapset = baseTrapsetMap.get(linkedPair.getChildContainer().getLeftChild());
					BaseTrapset egressTrapset = baseTrapsetMap.get(linkedPair.getChildContainer().getRightChild());

					Identifier trapsetName = Identifier.of(
							ingressTrapset.getName() + "_LinkedPair_" + egressTrapset.getName()
					);
					LinkedPairTrapset derivedTrapset = new LinkedPairTrapset();
					derivedTrapset.setName(trapsetName);

					for (Transition ingressTransition : ingressTrapset) {
						Template ingressParentTpl = ingressTrapset.getParentTemplate(ingressTransition);
						Location target = ingressParentTpl.getLocationGraph().getTargetVertex(ingressTransition);
						Set<Transition> egressTransitions = ingressParentTpl.getLocationGraph().getEdgesFrom(target);
						for (Transition egressTransition : egressTransitions) {
							if (!egressTrapset.contains(egressTransition))
								continue;
							AssignmentExpression markerExpr = (AssignmentExpression) new AssignmentExpression()
									.setLeftChild(IdentifierExpression.of(trapsetName))
									.setRightChild(egressTrapset.getMarkerCondition(egressTransition));
							derivedTrapset.addTrap(LinkedPairTrap.of(
									ingressTrapset, ingressTransition, ingressParentTpl, egressTransition, markerExpr
							));
						}
					}

					return derivedTrapset;
				}

				@Override
				public AbsDerivedTrapset visitRelativeComplement(RelativeComplementNode relativeComplement) {
					BaseTrapset includedTrapset = baseTrapsetMap.get(relativeComplement.getChildContainer().getLeftChild());
					BaseTrapset excludedTrapset = baseTrapsetMap.get(relativeComplement.getChildContainer().getRightChild());

					Identifier trapsetName = Identifier.of(includedTrapset.getName() + "_RelativeComplement_" + excludedTrapset.getName());
					RelativeComplementTrapset derivedTrapset = new RelativeComplementTrapset();
					derivedTrapset.setName(trapsetName);

					for (Transition includedTransition : includedTrapset) {
						Template parentTemplate = includedTrapset.getParentTemplate(includedTransition);
						AbsExpression conditionExpr = includedTrapset.getMarkerCondition(includedTransition);
						if (excludedTrapset.contains(includedTransition)) {
							if (!excludedTrapset.isConditional(includedTransition))
								continue;

							conditionExpr = new ConjunctionExpression()
									.setLeftChild(conditionExpr)
									.setRightChild(
											new NegationExpression()
													.setChild(excludedTrapset.getMarkerCondition(includedTransition))
									);
						}

						AssignmentExpression markerExpr = (AssignmentExpression) new AssignmentExpression()
								.setLeftChild(IdentifierExpression.of(trapsetName))
								.setRightChild(conditionExpr);
						derivedTrapset.addTrap(BaseTrap.of(parentTemplate, includedTransition, markerExpr));
					}

					return derivedTrapset;
				}
			}));
		}
	}

	private List<AbsDerivedTrapsetNode> collectTrapsetOperators(TdlExpression expression) {
		List<AbsDerivedTrapsetNode> trapsetOperators = new LinkedList<>();
		expression.getRootNode().accept(new BaseTdlExpressionVisitor<Void>() {
			@Override
			public Void visitAbsoluteComplement(AbsoluteComplementNode node) {
				trapsetOperators.add(node);
				return null;
			}

			@Override
			public Void visitRelativeComplement(RelativeComplementNode node) {
				trapsetOperators.add(node);
				return null;
			}

			@Override
			public Void visitLinkedPair(LinkedPairNode node) {
				trapsetOperators.add(node);
				return null;
			}
		});
		return trapsetOperators;
	}

	public Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> extract() {
		if (completionFlag.isSet())
			return derivedTrapsetMap;
		populateDerivedTrapsetMap();
		completionFlag.set();
		return derivedTrapsetMap;
	}
}
