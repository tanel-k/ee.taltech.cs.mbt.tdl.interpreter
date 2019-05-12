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
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.ITypeIdentifierVisitor;

public class TypeIdTransformer implements ISimpleTransformer {
	private class TransformerVisitor implements ITypeIdentifierVisitor<SExpressionSequenceNode> {
		@Override
		public SExpressionSequenceNode visitStructTypeIdentifier(StructTypeId id) {
			id.getFieldDeclarations();
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("struct"));
		}

		@Override
		public SExpressionSequenceNode visitScalarTypeIdentifier(ScalarTypeId id) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("scalar"))
					.addChild(new SExpressionSequenceNode()
							.addChild((SExpressionSequenceNode) new ExpressionTransformer().transform(id.getSizeExpression()))
					);
		}

		@Override
		public SExpressionSequenceNode visitBoundedIntegerTypeIdentifier(BoundedIntegerTypeId id) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("integer[,]"))
					.addChild(new SExpressionSequenceNode()
							.addChild((SExpressionSequenceNode) new ExpressionTransformer().transform(id.getMinimumBound()))
							.addChild((SExpressionSequenceNode) new ExpressionTransformer().transform(id.getMaximumBound()))
					);
		}

		@Override
		public SExpressionSequenceNode visitBooleanTypeIdentifier(BooleanTypeId id) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("boolean"));
		}

		@Override
		public SExpressionSequenceNode visitIntegerTypeIdentifier(IntegerTypeId id) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("integer"));
		}

		@Override
		public SExpressionSequenceNode visitChannelTypeIdentifier(ChannelTypeId id) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("channel"));
		}

		@Override
		public SExpressionSequenceNode visitClockTypeIdentifier(ClockTypeId id) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("clock"));
		}

		@Override
		public SExpressionSequenceNode visitCustomTypeIdentifier(CustomTypeId id) {
			return new SExpressionSequenceNode()
					.addChild(new SExpressionStringNode().setString("idType"))
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
