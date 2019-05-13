package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.utils.fragments;

import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionSequenceNode;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.nodes.SExpressionStringNode;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.AbsTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BaseTypeIdentifiers.BooleanTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BaseTypeIdentifiers.ChannelTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BaseTypeIdentifiers.ClockTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BaseTypeIdentifiers.IntegerTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BoundedIntegerTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.CustomTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.ScalarTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.StructTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.field.AbsFieldDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.ITypeIdentifierVisitor;

public class TypeIdTransformer implements ISimpleTransformer {
	private class TransformerVisitor implements ITypeIdentifierVisitor<SExpressionSequenceNode> {
		@Override
		public SExpressionSequenceNode visitStructTypeIdentifier(StructTypeId id) {
			SExpressionSequenceNode fieldDeclSeq = new SExpressionSequenceNode();
			for (AbsFieldDeclaration fieldDeclaration : id.getFieldDeclarations()) {
				fieldDeclSeq.addChild((SExpressionSequenceNode) new FieldDeclarationTransformer().transform(fieldDeclaration));
			}
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("STRUCT"))
					.addChild(
							new SExpressionSequenceNode()
									.addChild(fieldDeclSeq)
					);
		}

		@Override
		public SExpressionSequenceNode visitScalarTypeIdentifier(ScalarTypeId id) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("SCALAR"))
					.addChild(new SExpressionSequenceNode()
							.addChild((SExpressionSequenceNode) new ExpressionTransformer().transform(id.getSizeExpression()))
					);
		}

		@Override
		public SExpressionSequenceNode visitBoundedIntegerTypeIdentifier(BoundedIntegerTypeId id) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("BOUNDEDINT"))
					.addChild(new SExpressionSequenceNode()
							.addChild((SExpressionSequenceNode) new ExpressionTransformer().transform(id.getMinimumBound()))
							.addChild((SExpressionSequenceNode) new ExpressionTransformer().transform(id.getMaximumBound()))
					);
		}

		@Override
		public SExpressionSequenceNode visitBooleanTypeIdentifier(BooleanTypeId id) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("BOOLEAN"));
		}

		@Override
		public SExpressionSequenceNode visitIntegerTypeIdentifier(IntegerTypeId id) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("INT"));
		}

		@Override
		public SExpressionSequenceNode visitChannelTypeIdentifier(ChannelTypeId id) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("CHANNEL"));
		}

		@Override
		public SExpressionSequenceNode visitClockTypeIdentifier(ClockTypeId id) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("CLOCK"));
		}

		@Override
		public SExpressionSequenceNode visitCustomTypeIdentifier(CustomTypeId id) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("CUSTOM"))
					.addChild(new SExpressionSequenceNode()
							.addChild(new SExpressionStringNode().setString(id.getIdentifier().toString()))
					);
		}
	}

	@Override
	public Object transform(Object in) {
		AbsTypeId typeId = (AbsTypeId) in;
		return typeId.accept(new TransformerVisitor());
	}
}
