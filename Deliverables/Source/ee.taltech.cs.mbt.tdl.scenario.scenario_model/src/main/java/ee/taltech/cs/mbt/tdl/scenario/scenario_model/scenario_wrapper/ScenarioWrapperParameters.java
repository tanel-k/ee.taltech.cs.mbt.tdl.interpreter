package ee.taltech.cs.mbt.tdl.scenario.scenario_model.scenario_wrapper;

import ee.taltech.cs.mbt.tdl.commons.utils.objects.ObjectIdentityMap;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsDerivedTrapsetNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.internal.generic.AbsTrapsetQuantifierNode;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.node.AbsExpressionNode;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.trapset.generic.AbsTrapset;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ScenarioWrapperParameters {
	private ObjectIdentityMap<AbsExpressionNode, Integer> treeIndexMap = new ObjectIdentityMap<>();
	private Map<AbsDerivedTrapsetNode, AbsTrapset> trapsetMap = new LinkedHashMap<>();
	private TdlExpression expression;

	public Map<AbsDerivedTrapsetNode, AbsTrapset> getDerivedTrapsetMap() {
		return trapsetMap;
	}

	public ObjectIdentityMap<AbsExpressionNode, Integer> getTreeIndexMap() {
		return treeIndexMap;
	}

	public TdlExpression getExpression() {
		return expression;
	}

	public void setExpression(TdlExpression expression) {
		this.expression = expression;
	}
}
