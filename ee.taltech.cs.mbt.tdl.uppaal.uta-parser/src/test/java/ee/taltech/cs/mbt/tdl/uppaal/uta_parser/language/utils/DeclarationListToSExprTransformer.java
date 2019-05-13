package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.SExpression;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments.DeclarationTransformer;

import java.util.List;

public class DeclarationListToSExprTransformer implements ISimpleTransformer {
	@Override
	public Object transform(Object in) {
		List<AbsDeclarationStatement> declarations = (List<AbsDeclarationStatement>) in;
		SExpressionSequenceNode sequenceNode = new SExpressionSequenceNode();
		for (AbsDeclarationStatement declarationStatement : declarations) {
			sequenceNode.addChild((SExpressionSequenceNode) new DeclarationTransformer().transform(declarationStatement));
		}
		return new SExpression().setRoot(sequenceNode);
	}
}
