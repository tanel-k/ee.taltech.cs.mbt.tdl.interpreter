package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.SExpression;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.template.Selection;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments.SelectionTransformer;

import java.util.List;

public class SelectionListToSExprTransformer implements ISimpleTransformer {
	@Override
	public Object transform(Object in) {
		List<Selection> selections = (List<Selection>) in;
		SExpressionSequenceNode sequenceNode = new SExpressionSequenceNode();
		for (Selection selection : selections) {
			sequenceNode.addChild((SExpressionSequenceNode) new SelectionTransformer().transform(selection));
		}
		return new SExpression().setRoot(sequenceNode);
	}
}
