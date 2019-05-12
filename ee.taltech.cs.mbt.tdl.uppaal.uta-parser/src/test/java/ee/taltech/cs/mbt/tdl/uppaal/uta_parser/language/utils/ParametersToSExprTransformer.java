package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments.ParameterTransformer;

import java.util.List;

public class ParametersToSExprTransformer implements ISimpleTransformer {
	@Override
	public Object transform(Object in) {
		List<ParameterDeclaration> declarations = (List<ParameterDeclaration>) in;
		SExpressionSequenceNode sequenceNode = new SExpressionSequenceNode();
		for (ParameterDeclaration parameterDeclaration : declarations) {
			sequenceNode.addChild((SExpressionSequenceNode) new ParameterTransformer().transform(parameterDeclaration));
		}
		return sequenceNode;
	}
}
