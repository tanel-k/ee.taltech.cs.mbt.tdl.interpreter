package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.SExpression;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionStringNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.parameter.ParameterDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments.ParameterTestTransformer;

import java.util.List;

public class ParameterListToSExprTestTransformer implements ISimpleTransformer {
	@Override
	public Object transform(Object in) {
		List<ParameterDeclaration> declarations = (List<ParameterDeclaration>) in;
		SExpressionSequenceNode sequenceNode = new SExpressionSequenceNode();
		for (ParameterDeclaration parameterDeclaration : declarations) {
			sequenceNode.addChild((SExpressionSequenceNode) new ParameterTestTransformer().transform(parameterDeclaration));
		}
		return new SExpression().setRoot(new SExpressionSequenceNode()
				.addChild(new SExpressionStringNode().setString("PARAMETERS"))
				.addChild(sequenceNode)
		);
	}
}
