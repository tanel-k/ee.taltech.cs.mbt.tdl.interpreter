package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.evaluation;

import ee.taltech.cs.mbt.tdl.commons.utils.primitives.Flag;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.LinkedPairsNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_expression.TrapsetWrapperNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.ITrapsetExpressionVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseTdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.evaluation.impl.AbsoluteComplementEvaluator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.evaluation.impl.LinkedPairsEvaluator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.evaluation.impl.RelativeComplementEvaluator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.evaluation.impl.TrapsetWrapperEvaluator;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.base.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapset.model.trapset.evaluated.AbsTrapsetEvaluation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TrapsetsEvaluator {
	public static TrapsetsEvaluator getInstance(
			UtaSystem system,
			TdlExpression expression,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		return new TrapsetsEvaluator(system, expression, baseTrapsetMap);
	}

	private final Flag completionFlag = Flag.newInstance();

	private final UtaSystem system;
	private final TdlExpression expression;
	private final Map<TrapsetNode, BaseTrapset> baseTrapsetMap;
	private final Map<AbsTrapsetExpressionNode, AbsTrapsetEvaluation> trapsetEvaluationMap = new HashMap<>();

	private TrapsetsEvaluator(UtaSystem system, TdlExpression expression, Map<TrapsetNode, BaseTrapset> baseTrapsetMap) {
		this.system = system;
		this.expression = expression;
		this.baseTrapsetMap = baseTrapsetMap;
	}

	private List<AbsTrapsetExpressionNode> collectTrapsetOperators(TdlExpression expression) {
		List<AbsTrapsetExpressionNode> trapsetOperators = new LinkedList<>();
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
			public Void visitLinkedPairs(LinkedPairsNode node) {
				trapsetOperators.add(node);
				return null;
			}

			@Override
			public Void visitTrapsetWrapper(TrapsetWrapperNode node) {
				trapsetOperators.add(node);
				return null;
			}
		});
		return trapsetOperators;
	}

	private void populateDerivedTrapsetMap() {
		for (AbsTrapsetExpressionNode<?> trapsetOperator : collectTrapsetOperators(expression)) {
			trapsetEvaluationMap.put(trapsetOperator, trapsetOperator.accept(new ITrapsetExpressionVisitor<AbsTrapsetEvaluation>() {
				@Override
				public AbsTrapsetEvaluation visitAbsoluteComplement(AbsoluteComplementNode absoluteComplement) {
					return AbsoluteComplementEvaluator
							.getInstance(system, absoluteComplement, baseTrapsetMap)
							.evaluate();
				}

				@Override
				public AbsTrapsetEvaluation visitLinkedPairs(LinkedPairsNode linkedPairs) {
					return LinkedPairsEvaluator
							.getInstance(system, linkedPairs, baseTrapsetMap)
							.evaluate();
				}

				@Override
				public AbsTrapsetEvaluation visitRelativeComplement(RelativeComplementNode relativeComplement) {
					return RelativeComplementEvaluator
							.getInstance(system, relativeComplement, baseTrapsetMap)
							.evaluate();
				}

				@Override
				public AbsTrapsetEvaluation visitTrapsetWrapper(TrapsetWrapperNode trapsetWrapper) {
					return TrapsetWrapperEvaluator
							.getInstance(system, trapsetWrapper, baseTrapsetMap)
							.evaluate();
				}
			}));
		}
	}

	public Map<AbsTrapsetExpressionNode, AbsTrapsetEvaluation> evaluate() {
		if (completionFlag.isSet())
			return trapsetEvaluationMap;

		populateDerivedTrapsetMap();

		completionFlag.set();
		return trapsetEvaluationMap;
	}
}
