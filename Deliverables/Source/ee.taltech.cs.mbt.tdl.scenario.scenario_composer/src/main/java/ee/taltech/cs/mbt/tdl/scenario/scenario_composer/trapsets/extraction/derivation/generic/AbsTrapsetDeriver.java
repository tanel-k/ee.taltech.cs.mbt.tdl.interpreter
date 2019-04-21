package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.extraction.derivation.generic;

import ee.taltech.cs.mbt.tdl.commons.utils.primitives.Flag;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.leaf.trapset.TrapsetNode;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.BaseTrapset;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.trapsets.model.generic.AbsDerivedTrapset;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.util.Collections;
import java.util.Map;

public abstract class AbsTrapsetDeriver<T extends AbsDerivedTrapsetNode> {
	private Flag completionFlag = Flag.newInstance();

	private AbsDerivedTrapset derivedTrapset;
	private final UtaSystem system;
	private final T trapsetDerivingNode;
	private final Map<TrapsetNode, BaseTrapset> baseTrapsetMap;

	protected AbsTrapsetDeriver(
			UtaSystem system,
			T trapsetDerivingNode,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	) {
		this.system = system;
		this.trapsetDerivingNode = trapsetDerivingNode;
		this.baseTrapsetMap = Collections.unmodifiableMap(baseTrapsetMap);
	}

	protected abstract AbsDerivedTrapset derive(
			UtaSystem system,
			T trapsetDerivingNode,
			Map<TrapsetNode, BaseTrapset> baseTrapsetMap
	);

	protected UtaSystem getSystem() {
		return system;
	}

	public AbsDerivedTrapset derive() {
		if (completionFlag.isSet())
			return derivedTrapset;

		derivedTrapset = derive(system, trapsetDerivingNode, baseTrapsetMap);

		completionFlag.set();
		return derivedTrapset;
	}
}
