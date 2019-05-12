package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.SExpression;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments.ExpressionTransformer;

import java.util.List;

public class AssignmentsToSExprTransformer implements ISimpleTransformer {
	@Override
	public Object transform(Object in) {
		List<AbsExpression> assignments = (List<AbsExpression>) in;
		SExpressionSequenceNode sequenceNode = new SExpressionSequenceNode();
		for (AbsExpression expression : assignments) {
			sequenceNode.addChild((SExpressionSequenceNode) new ExpressionTransformer().transform(expression));
		}
		return new SExpression().setRoot(sequenceNode);
	}
}
