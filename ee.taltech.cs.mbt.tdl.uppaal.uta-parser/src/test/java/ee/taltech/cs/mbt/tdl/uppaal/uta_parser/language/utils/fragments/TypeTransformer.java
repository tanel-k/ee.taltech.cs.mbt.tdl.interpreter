package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionStringNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.Type;

public class TypeTransformer implements ISimpleTransformer {
	@Override
	public Object transform(Object in) {
		Type type = (Type) in;
		SExpressionSequenceNode arrayModifiers = new SExpressionSequenceNode();
		for (AbsArrayModifier arrayModifier : type.getArrayModifiers()) {
			arrayModifiers.addChild((SExpressionSequenceNode) new ArrayModifierTransformer().transform(arrayModifier));
		}
		return new SExpressionSequenceNode()
				.addChild(new SExpressionStringNode().setString("TYPE"))
				.addChild(new SExpressionStringNode().setString(type.isReferenceType() ? "&" : "-"))
				.addChild((SExpressionSequenceNode) new BaseTypeTransformer().transform(type.getBaseType()))
				.addChild(arrayModifiers);
	}
}