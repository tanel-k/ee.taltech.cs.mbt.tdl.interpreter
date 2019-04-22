package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction;

import ee.taltech.cs.mbt.tdl.commons.utils.data_structures.DirectedMultigraph;
import ee.taltech.cs.mbt.tdl.commons.utils.primitives.Flag;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetQuantifierNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.BooleanValueWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.ExistentialQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_quantifier.UniversalQuantificationNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseBooleanNodeVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.generic.AbsEvaluatedTrapset;
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
			Map<AbsTrapsetExpressionNode, AbsEvaluatedTrapset> trapsetEvaluationMap
	) {
		return new TrapsetQuantifierEvaluator(system, expression, trapsetEvaluationMap);
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

	private Flag completionFlag = Flag.newInstance();

	private UtaSystem system;
	private TdlExpression expression;
	private Map<AbsTrapsetExpressionNode, AbsEvaluatedTrapset> trapsetEvaluationMap;

	private TrapsetQuantifierEvaluator(
			UtaSystem system,
			TdlExpression expression,
			Map<AbsTrapsetExpressionNode, AbsEvaluatedTrapset> trapsetEvaluationMap
	) {
		this.system = system;
		this.expression = expression;
		this.trapsetEvaluationMap = Collections.unmodifiableMap(trapsetEvaluationMap);
	}

	private void evaluateTrapsetQuantifiers() {
		final int systemTransitionCount = getSystemTransitionCount(system);
		for (AbsTrapsetQuantifierNode trapsetQuantifier : extractTrapsetQuantifiers(expression)) {
			AbsTrapsetExpressionNode trapsetExpression = trapsetQuantifier.getChildContainer().getChild();
			AbsEvaluatedTrapset trapset = trapsetEvaluationMap.get(trapsetExpression);
			/*
			 * Reduction rules:
			 * E(universal) = True.
			 * U(universal) = True.
			 * not(E(universal)) = False.
			 * not(U(universal)) = False.
			 *
			 * Note that trapsets cannot be empty as that would result in Uppaal syntax errors.
			 */
			if (trapset.getUnconditionalTrapCount() == systemTransitionCount) {
				BooleanValueWrapperNode wrapper = BooleanValueWrapperNode.of(!trapsetQuantifier.isNegated());
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
