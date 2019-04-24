package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.extraction.evaluation.generic;

import ee.taltech.cs.mbt.tdl.commons.utils.primitives.Flag;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetExpressionNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.generic.AbsEvaluatedTrapset;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;

import java.util.Collections;
import java.util.Map;

public abstract class AbsTrapsetExpressionEvaluator<T extends AbsTrapsetExpressionNode> {
	private Flag completionFlag = Flag.newInstance();

	private AbsEvaluatedTrapset resultTrapset;
	private final UtaSystem system;
	private final T trapsetDerivingNode;
	private final Map<TrapsetNode, BaseTrapset> baseTrapsetMap;

	protected AbsTrapsetExpressionEvaluator(
			UtaSystem system,
			T trapsetDerivingNode,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		this.system = system;
		this.trapsetDerivingNode = trapsetDerivingNode;
		this.baseTrapsetMap = Collections.unmodifiableMap(baseTrapsetMap);
	}

	protected abstract AbsEvaluatedTrapset evaluate(
			UtaSystem system,
			T trapsetDerivingNode,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	);

	protected UtaSystem getSystem() {
		return system;
	}

	public AbsEvaluatedTrapset evaluate() {
		if (completionFlag.isSet())
			return resultTrapset;

		resultTrapset = evaluate(system, trapsetDerivingNode, baseTrapsetMap);

		completionFlag.set();
		return resultTrapset;
	}
}
