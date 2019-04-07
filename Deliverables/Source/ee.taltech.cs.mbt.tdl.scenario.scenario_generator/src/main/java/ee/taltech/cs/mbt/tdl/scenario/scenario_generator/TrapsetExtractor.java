package ee.taltech.cs.mbt.tdl.scenario.scenario_generator;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpressionVisitor;
import ee.taltech.cs.mbt.tdl.scenario.scenario_model.Trapset;

import java.util.Collection;

public class TrapsetExtractor implements TdlExpressionVisitor {
	public Collection<Trapset> extract(ScenarioSpecification spec) {
		spec.getScenarioExpression().getRootNode();
		throw new UnsupportedOperationException();
	}
}
