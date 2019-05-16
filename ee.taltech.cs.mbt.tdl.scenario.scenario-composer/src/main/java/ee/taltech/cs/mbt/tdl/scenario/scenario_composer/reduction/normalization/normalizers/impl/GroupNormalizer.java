package ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.normalizers.impl;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsBooleanInternalNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.logical.GroupNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.scenario.scenario_composer.reduction.normalization.normalizers.AbsNormalizer;

public class GroupNormalizer extends AbsNormalizer<GroupNode> {
	public static GroupNormalizer getInstance() {
		return INSTANCE;
	}

	private static final GroupNormalizer INSTANCE = new GroupNormalizer();

	private GroupNormalizer() { }

	@Override
	public AbsBooleanInternalNode normalize(TdlExpression expression, GroupNode group) {
		// ( X ) reduces to X.
		AbsBooleanInternalNode<?, ?> groupedNode = group.getChildContainer().getChild();
		expression.replaceDescendant(group, groupedNode);
		groupedNode.setNegated(groupedNode.isNegated() ^ group.isNegated());
		return groupedNode;
	}
}
