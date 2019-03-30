package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.mapping;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.ContextBuilder;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.AbsTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers.BooleanTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers.ChannelTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers.ClockTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BaseTypeIdentifiers.IntegerTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.BoundedIntegerTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.CustomTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.ScalarTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.StructTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.ITypeIdentifierVisitor;

public class TypeIdentifierMapper implements IContextMapper<AbsTypeId>, ITypeIdentifierVisitor<ContextBuilder> {
	public static IContextMapper<AbsTypeId> getInstance() {
		return INSTANCE;
	}

	private static final TypeIdentifierMapper INSTANCE = new TypeIdentifierMapper();

	private TypeIdentifierMapper() { }

	@Override
	public ContextBuilder map(AbsTypeId typeId) {
		return typeId.accept(this);
	}

	@Override
	public ContextBuilder visitStructTypeIdentifier(StructTypeId id) {
		return ContextBuilder.newBuilder("struct")
				.put("fieldDeclarations", FieldDeclarationMapper.getInstance().mapCollection(id.getFieldDeclarations()));
	}

	@Override
	public ContextBuilder visitScalarTypeIdentifier(ScalarTypeId id) {
		return ContextBuilder.newBuilder("scalar")
				.put("expression", ExpressionMapper.getInstance().map(id.getSizeExpression()));
	}

	@Override
	public ContextBuilder visitCustomTypeIdentifier(CustomTypeId id) {
		return ContextBuilder.newBuilder("customType")
				.put("identifierValue", id.getIdentifier().getText());
	}

	@Override
	public ContextBuilder visitBoundedIntegerTypeIdentifier(BoundedIntegerTypeId id) {
		return ContextBuilder.newBuilder("boundedInteger")
				.put("minExpression", ExpressionMapper.getInstance().map(id.getMinimumBound()))
				.put("maxExpression", ExpressionMapper.getInstance().map(id.getMaximumBound()));
	}

	@Override
	public ContextBuilder visitBooleanTypeIdentifier(BooleanTypeId id) {
		return ContextBuilder.newBuilder("boolean");
	}

	@Override
	public ContextBuilder visitIntegerTypeIdentifier(IntegerTypeId id) {
		return ContextBuilder.newBuilder("integer");
	}

	@Override
	public ContextBuilder visitChannelTypeIdentifier(ChannelTypeId id) {
		return ContextBuilder.newBuilder("channel");
	}

	@Override
	public ContextBuilder visitClockTypeIdentifier(ClockTypeId id) {
		return ContextBuilder.newBuilder("clock");
	}
}
