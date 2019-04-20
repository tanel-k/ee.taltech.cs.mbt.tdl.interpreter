package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction;

import ee.taltech.cs.mbt.tdl.commons.utils.data_structures.DirectedMultigraph;
import ee.taltech.cs.mbt.tdl.commons.utils.primitives.BooleanFlag;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetQuantifierNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.structural_model.templates.Template;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TrapsetQuantifierEvaluator {
	public static TrapsetQuantifierEvaluator getInstance(
			UtaSystem system,
			TdlExpression expression,
			Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> derivedTrapsetMap
	) {
		return new TrapsetQuantifierEvaluator(system, expression, derivedTrapsetMap);
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

	private static int getSystemTransitionCount(UtaSystem system) {
		return system.getTemplates().stream()
				.map(Template::getLocationGraph)
				.mapToInt(DirectedMultigraph::edgeCount)
				.sum();
	}

	private BooleanFlag completionFlag = BooleanFlag.newInstance();

	private UtaSystem system;
	private TdlExpression expression;
	private Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> derivedTrapsetMap;

	private TrapsetQuantifierEvaluator(
			UtaSystem system,
			TdlExpression expression,
			Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> derivedTrapsetMap
	) {
		this.system = system;
		this.expression = expression;
		this.derivedTrapsetMap = Collections.unmodifiableMap(derivedTrapsetMap);
	}

	private void evaluateTrapsetQuantifiers() {
		final int systemTransitionCount = getSystemTransitionCount(system);
		for (AbsTrapsetQuantifierNode trapsetQuantifier : extractTrapsetQuantifiers(expression)) {
			AbsDerivedTrapsetNode trapsetDerivingNode = trapsetQuantifier.getChildContainer().getChild();
			AbsDerivedTrapset derivedTrapset = derivedTrapsetMap.get(trapsetDerivingNode);
			/*
			 * Reduction rules:
			 * E({}) = False.
			 * U({}) = False.
			 * not(E({})) = True.
			 * not(E({})) = True.
			 *
			 * E(universal) = True.
			 * U(universal) = True.
			 * not(E(universal)) = False.
			 * not(U(universal)) = False.
			 */
			Boolean replacementValue = null;
			if (derivedTrapset.isEmpty()) {
				replacementValue = trapsetQuantifier.isNegated();
			} else if (derivedTrapset.getUnconditionalTrapCount() == systemTransitionCount) {
				replacementValue = !trapsetQuantifier.isNegated();
			}

			if (replacementValue != null) {
				BooleanValueWrapperNode wrapper = BooleanValueWrapperNode.of(replacementValue);
				expression.replaceDescendant(trapsetQuantifier, wrapper);
			}
		}
	}

	public void evaluate() {
		if (completionFlag.isSet())
			return;

		evaluateTrapsetQuantifiers();

		completionFlag.set();
	}
}
