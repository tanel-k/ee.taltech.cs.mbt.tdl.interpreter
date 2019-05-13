package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionStringNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.parameter.ParameterDeclaration;

public class ParameterTransformer implements ISimpleTransformer {
	@Override
	public Object transform(Object in) {
		ParameterDeclaration parameterDeclaration = (ParameterDeclaration) in;
		return new SExpressionSequenceNode()
				.addChild(new SExpressionStringNode().setString("PARAM"))
				.addChild(new SExpressionSequenceNode()
						.addChild(new SExpressionStringNode().setString(parameterDeclaration.getIdentifier().toString()))
						.addChild((SExpressionSequenceNode) new TypeTransformer().transform(parameterDeclaration.getType()))
				);
	}
}
