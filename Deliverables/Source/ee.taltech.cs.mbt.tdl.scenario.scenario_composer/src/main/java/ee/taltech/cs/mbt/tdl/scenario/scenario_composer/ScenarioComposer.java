package ee.taltech.cs.mbt.tdl.scenario.scenario_composer;

import ee.taltech.cs.mbt.tdl.commons.utils.data_structures.DirectedMultigraph;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetQuantifierNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IDerivedTrapsetVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITrapsetQuantifierVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseTdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.TdlExpressionReducer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system.ScenarioCompositionParameters;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.scenario_system.ScenarioSystemComposer;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.specification.ScenarioSpecification;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.construction.BaseTrapsetsExtractor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.construction.DerivedTrapsetsExtractor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.derived.AbsoluteComplementTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.derived.LinkedPairTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.derived.RelativeComplementTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.BaseTrap;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trap.LinkedPairTrap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclarationGroup;
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

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
public class ScenarioComposer {
	public static ScenarioComposer newInstance(ScenarioSpecification specification) {
		return new ScenarioComposer(specification);
	}

	private static void removeTrapsetMarkers(UtaSystem system, Collection<BaseTrapset> baseTrapsets) {
		Map<Identifier, Boolean> cleanupFlags = new HashMap<>();
		List<AbsDeclarationStatement> globalDeclarations = system.getDeclarations();
		for (BaseTrapset trapset : baseTrapsets) {
			if (cleanupFlags.getOrDefault(trapset.getName(), Boolean.FALSE))
				continue;

			AbsDeclarationStatement trapsetArrayDeclaration = trapset.getDeclaration();
			if (trapsetArrayDeclaration instanceof VariableDeclarationGroup) {
				VariableDeclarationGroup group = (VariableDeclarationGroup) trapsetArrayDeclaration;
				group.removeItem(trapset.getName());

				if (group.getBaseTypeExtensionMap().isEmpty()) {
					globalDeclarations.remove(group);
				}
			} else {
				globalDeclarations.remove(trapsetArrayDeclaration);
			}

			for (Transition transition : trapset) {
				Collection<AbsExpression> transitionAssignments = transition.getLabels().getAssignmentsLabel().getContent();
				AssignmentExpression transitionAssignment = trapset.getMarkerAssignment(transition);
				transitionAssignments.remove(transitionAssignment);
			}

			cleanupFlags.put(trapset.getName(), Boolean.TRUE);
		}
	}

	private static List<AbsTrapsetQuantifierNode> extractTrapsetQuantifiers(TdlExpression expression) {
		List<AbsTrapsetQuantifierNode> trapsetQuantifiers = new LinkedList<>();
		expression.getRootNode().accept(new BaseBooleanNodeVisitor<Void>() {
			@Override
			public Void visitExistentialQuantification(ExistentialQuantificationNode operator) {
				trapsetQuantifiers.add(operator);
				return null;
			}

			@Override
			public Void visitUniversalQuantification(UniversalQuantificationNode operator) {
				trapsetQuantifiers.add(operator);
				return null;
			}
		});
		return trapsetQuantifiers;
	}

	private ScenarioSpecification specification;

	private ScenarioComposer(ScenarioSpecification specification) {
		this.specification = specification;
	}

	public UtaSystem compose() {
		TdlExpression tdlExpression = specification.getTdlExpression().deepClone();
		UtaSystem sutModel = specification.getSutModel().deepClone();

		Map<TrapsetNode, BaseTrapset> baseTrapsets = BaseTrapsetsExtractor
				.getInstance(sutModel, tdlExpression)
				.extract();

		Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> mapDerivedTrapsets = DerivedTrapsetsExtractor
				.getInstance(sutModel, tdlExpression, baseTrapsets).extract();

		int systemTransitionCount = sutModel.getTemplates().stream()
				.map(Template::getLocationGraph)
				.mapToInt(DirectedMultigraph::edgeCount)
				.sum();
		List<AbsTrapsetQuantifierNode> trapsetQuantifiers = extractTrapsetQuantifiers(tdlExpression);
		for (AbsTrapsetQuantifierNode trapsetQuantifier : trapsetQuantifiers) {
			AbsDerivedTrapsetNode trapsetDerivingNode = trapsetQuantifier.getChildContainer().getChild();
			AbsDerivedTrapset derivedTrapset = mapDerivedTrapsets.get(trapsetDerivingNode);

			Boolean replacementValue = trapsetQuantifier.accept(new ITrapsetQuantifierVisitor<Boolean>() {
				@Override
				public Boolean visitExistential(ExistentialQuantificationNode quantifier) {
					return visitAny(quantifier);
				}

				@Override
				public Boolean visitUniversal(UniversalQuantificationNode quantifier) {
					return visitAny(quantifier);
				}

				private Boolean visitAny(AbsTrapsetQuantifierNode quantifier) {
					/*
					 * Reduction rules:
					 * E({empty}) = False.
					 * U({empty}) = False.
					 * not(E({empty})) = True.
					 * not(E({empty})) = True.
					 *
					 * E(universal) = True.
					 * U(universal) = True.
					 * not(E(universal)) = False.
					 * not(U(universal)) = False.
					 */
					// Empty trapset:
					if (derivedTrapset.isEmpty())
						return quantifier.isNegated();
					// Trapset that covers the entire system (unconditionally):
					if (derivedTrapset.getUnconditionalTrapCount() == systemTransitionCount)
						return !quantifier.isNegated();
					return null;
				}
			});

			if (replacementValue != null) {
				BooleanValueWrapperNode wrapper = BooleanValueWrapperNode.of(replacementValue);
				tdlExpression.replaceDescendant(trapsetQuantifier, wrapper);
			}
		}

		TdlExpressionReducer.getInstance(tdlExpression).reduce();
		ScenarioCompositionParameters parameters = new ScenarioCompositionParameters()
				.setTdlExpression(tdlExpression)
				.setDerivedTrapsetMap(mapDerivedTrapsets);
		ScenarioSystemComposer.newInstance(sutModel, parameters).compose();

		removeTrapsetMarkers(sutModel, baseTrapsets.values());

		return sutModel;
	}
}
