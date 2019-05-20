package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionStringNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.Type;

public class TypeTestTransformer implements ISimpleTransformer {
	@Override
	public Object transform(Object in) {
		Type type = (Type) in;
		SExpressionSequenceNode arrayModifiers = new SExpressionSequenceNode();
		for (AbsArrayModifier arrayModifier : type.getArrayModifiers()) {
			arrayModifiers.addChild((SExpressionSequenceNode) new ArrayModifierTestTransformer().transform(arrayModifier));
		}
		return new SExpressionSequenceNode()
				.addChild(new SExpressionStringNode().setString("TYPE"))
				.addChild(new SExpressionSequenceNode()
						.addChild(new SExpressionStringNode().setString(type.isReferenceType() ? "REF" : "NORM"))
						.addChild((SExpressionSequenceNode) new BaseTypeTestTransformer().transform(type.getBaseType()))
						.addChild(arrayModifiers)
				);
	}
}
