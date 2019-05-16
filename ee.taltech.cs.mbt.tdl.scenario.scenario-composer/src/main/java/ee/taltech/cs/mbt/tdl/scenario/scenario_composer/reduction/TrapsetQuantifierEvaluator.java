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
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.AbsTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.structure.templates.Template;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TrapsetQuantifierEvaluator {
	public static TrapsetQuantifierEvaluator getInstance(
			UtaSystem system,
			TdlExpression expression,
			Map<AbsTrapsetExpressionNode, AbsTrapsetEvaluation> trapsetEvaluationMap
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

	/**
	 * @return the total number of transitions in the system.<br/>
	 * Could be used to test if a trapset unconditionally covers the entire system.
	 */
	@SuppressWarnings("unused")
	private static int getSystemTransitionCount(UtaSystem system) {
		return system.getTemplates().stream()
				.map(Template::getLocationGraph)
				.mapToInt(DirectedMultigraph::edgeCount)
				.sum();
	}

	private Flag completionFlag = Flag.newInstance();

	/**
	 * @see #getSystemTransitionCount(UtaSystem)
	 */
	@SuppressWarnings("unused")
	private UtaSystem system;
	private TdlExpression expression;
	private Map<AbsTrapsetExpressionNode, AbsTrapsetEvaluation> trapsetEvaluationMap;

	private TrapsetQuantifierEvaluator(
			UtaSystem system,
			TdlExpression expression,
			Map<AbsTrapsetExpressionNode, AbsTrapsetEvaluation> trapsetEvaluationMap
	) {
		this.system = system;
		this.expression = expression;
		this.trapsetEvaluationMap = Collections.unmodifiableMap(trapsetEvaluationMap);
	}

	private void evaluateTrapsetQuantifiers() {
		for (AbsTrapsetQuantifierNode trapsetQuantifier : extractTrapsetQuantifiers(expression)) {
			AbsTrapsetExpressionNode trapsetExpression = trapsetQuantifier.getChildContainer().getChild();
			AbsTrapsetEvaluation trapset = trapsetEvaluationMap.get(trapsetExpression);

			// Only quantifiers over empty trapsets can be reduced at this time.
			// Technically we could also reduce E(ALL) -> to some True node that requires at least one transition to be taken.
			// We'll skip this for now as we would have to differentiate between multiple types of 'True'.
			if (trapset.getTrapCount() == 0) {
				// E({}) = False:
				// Because E({}) is the same as 'exists tr in {} such that assignment(tr) = true' (by definition of empty set).

				// A({}) = True:
				// Because A({}) is the same as 'for all tr : tr in {} -> assignment(tr) = true' (by def of implication).
				BooleanValueWrapperNode wrapper;
				if (trapsetQuantifier instanceof UniversalQuantificationNode) {
					wrapper = BooleanValueWrapperNode.of(!trapsetQuantifier.isNegated());
				} else {
					wrapper = BooleanValueWrapperNode.of(trapsetQuantifier.isNegated());
				}
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
