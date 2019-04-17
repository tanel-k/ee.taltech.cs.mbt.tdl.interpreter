package ee.taltech.cs.mbt.tdl.scenario.scenario_generator.scenario_wrapper;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;

public class RecognizerParameters<T extends AbsBooleanInternalNode> {
	private T node;
	private Integer treeIndex;
	private Identifier processName;

	public RecognizerParameters(T node) {
		this.node = node;
	}

	public T getNode() {
		return node;
	}

	public Integer getTreeIndex() {
		return treeIndex;
	}

	public RecognizerParameters<T> setTreeIndex(Integer treeIndex) {
		this.treeIndex = treeIndex;
		return this;
	}

	public Identifier getProcessName() {
		return processName;
	}

	public RecognizerParameters<T> setProcessName(Identifier processName) {
		this.processName = processName;
		return this;
	}
}
