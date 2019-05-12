package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionStringNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.template.Selection;

public class SelectionTransformer implements ISimpleTransformer {
	@Override
	public Object transform(Object in) {
		Selection selection = (Selection) in;
		return new SExpressionSequenceNode()
				.addChild(new SExpressionStringNode().setString(selection.getVariableName().toString()))
				.addChild((SExpressionSequenceNode) new BaseTypeTransformer().transform(selection.getSelectType()));
	}
}
