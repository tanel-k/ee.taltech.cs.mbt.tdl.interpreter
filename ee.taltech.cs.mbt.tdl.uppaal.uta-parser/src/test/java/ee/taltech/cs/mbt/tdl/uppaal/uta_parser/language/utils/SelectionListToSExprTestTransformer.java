package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.SExpression;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionStringNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.template.Selection;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments.SelectionTestTransformer;

import java.util.List;

public class SelectionListToSExprTestTransformer implements ISimpleTransformer {
	@Override
	public Object transform(Object in) {
		List<Selection> selections = (List<Selection>) in;
		SExpressionSequenceNode sequenceNode = new SExpressionSequenceNode();
		for (Selection selection : selections) {
			sequenceNode.addChild((SExpressionSequenceNode) new SelectionTestTransformer().transform(selection));
		}
		return new SExpression().setRoot(new SExpressionSequenceNode()
				.addChild(new SExpressionStringNode().setString("SELECTION"))
				.addChild(sequenceNode)
		);
	}
}
