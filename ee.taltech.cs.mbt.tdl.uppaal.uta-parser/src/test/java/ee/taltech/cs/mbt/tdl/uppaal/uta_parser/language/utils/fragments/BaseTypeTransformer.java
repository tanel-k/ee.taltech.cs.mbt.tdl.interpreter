package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionStringNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.BaseType;

public class BaseTypeTransformer implements ISimpleTransformer {
	@Override
	public Object transform(Object in) {
		BaseType baseType = (BaseType) in;
		String prefix;
		switch (baseType.getPrefix()) {
		case URGENT:
			prefix = "urgent";
			break;
		case META:
			prefix = "meta";
			break;
		case CONSTANT:
			prefix = "constant";
			break;
		case BROADCAST:
			prefix = "broadcast";
			break;
		case NONE:
		default:
			prefix = "-";
			break;
		}
		return new SExpressionSequenceNode()
				.addChild(new SExpressionStringNode().setString(prefix))
				.addChild((SExpressionSequenceNode) new TypeIdTransformer().transform(baseType.getTypeId()));
	}
}
