package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.reducers;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.GroupNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.generic.AbsReducer;

public class GroupNormalizingReducer extends AbsReducer<GroupNode> {
	public static GroupNormalizingReducer getInstance() {
		return INSTANCE;
	}

	private static final GroupNormalizingReducer INSTANCE = new GroupNormalizingReducer();

	private GroupNormalizingReducer() { }

	@Override
	public AbsBooleanInternalNode reduce(TdlExpression expression, GroupNode group) {
		// ( X ) reduces to X.
		AbsBooleanInternalNode<?, ?> groupedNode = group.getChildContainer().getChild();
		expression.replaceDescendant(group, groupedNode);
		groupedNode.setNegated(groupedNode.isNegated() ^ group.isNegated());
		return groupedNode;
	}
}
