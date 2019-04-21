package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.extraction;

import ee.taltech.cs.mbt.tdl.commons.utils.primitives.Flag;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.AbsoluteComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.LinkedPairNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.trapset_derivation.RelativeComplementNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.IDerivedTrapsetVisitor;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.visitors.impl.BaseTdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.extraction.derivation.AbsoluteComplementDeriver;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.extraction.derivation.LinkedPairDeriver;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.extraction.derivation.RelativeComplementDeriver;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DerivedTrapsetsExtractor {
	public static DerivedTrapsetsExtractor getInstance(
			UtaSystem system,
			TdlExpression expression,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		return new DerivedTrapsetsExtractor(system, expression, baseTrapsetMap);
	}

	private final Flag completionFlag = Flag.newInstance();

	private final UtaSystem system;
	private final TdlExpression expression;
	private final Map<TrapsetNode, BaseTrapset> baseTrapsetMap;
	private final Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> derivedTrapsetMap = new HashMap<>();

	private DerivedTrapsetsExtractor(UtaSystem system, TdlExpression expression, Map<TrapsetNode, BaseTrapset> baseTrapsetMap) {
		this.system = system;
		this.expression = expression;
		this.baseTrapsetMap = baseTrapsetMap;
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

	private void populateDerivedTrapsetMap() {
		for (AbsDerivedTrapsetNode<?> trapsetOperator : collectTrapsetOperators(expression)) {
			derivedTrapsetMap.put(trapsetOperator, trapsetOperator.accept(new IDerivedTrapsetVisitor<AbsDerivedTrapset>() {
				@Override
				public AbsDerivedTrapset visitAbsoluteComplement(AbsoluteComplementNode absoluteComplement) {
					return AbsoluteComplementDeriver
							.getInstance(system, absoluteComplement, baseTrapsetMap)
							.derive();
				}

				@Override
				public AbsDerivedTrapset visitLinkedPair(LinkedPairNode linkedPair) {
					return LinkedPairDeriver
							.getInstance(system, linkedPair, baseTrapsetMap)
							.derive();
				}

				@Override
				public AbsDerivedTrapset visitRelativeComplement(RelativeComplementNode relativeComplement) {
					return RelativeComplementDeriver
							.getInstance(system, relativeComplement, baseTrapsetMap)
							.derive();
				}
			}));
		}
	}

	public Map<AbsDerivedTrapsetNode, AbsDerivedTrapset> extract() {
		if (completionFlag.isSet())
			return derivedTrapsetMap;

		populateDerivedTrapsetMap();

		completionFlag.set();
		return derivedTrapsetMap;
	}
}
