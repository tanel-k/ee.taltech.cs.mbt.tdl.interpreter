package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionStringNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.field.AbsFieldDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.field.FieldDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.field.FieldDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IFieldDeclarationVisitor;

public class FieldDeclarationTestTransformer implements ISimpleTransformer {
	private class TransformerVisitor implements IFieldDeclarationVisitor<SExpressionSequenceNode> {
		@Override
		public SExpressionSequenceNode visitFieldDeclaration(FieldDeclaration decl) {
			return new SExpressionSequenceNode()
					.addChild((SExpressionSequenceNode) new TypeTestTransformer().transform(decl.getType()))
					.addChild(new SExpressionStringNode().setString(decl.getIdentifier().toString()));
		}

		@Override
		public SExpressionSequenceNode visitFieldDeclarationGroup(FieldDeclarationGroup decl) {
			return (SExpressionSequenceNode) new BaseTypeExtensionTestTransformer().transform(decl);
		}
	}

	@Override
	public Object transform(Object in) {
		AbsFieldDeclaration fieldDeclaration = (AbsFieldDeclaration) in;
		return new SExpressionSequenceNode()
				.addChild(new SExpressionStringNode().setString("FIELD"))
				.addChild(new SExpressionSequenceNode()
						.addChild(fieldDeclaration.accept(new TransformerVisitor()))
				);
	}
}
