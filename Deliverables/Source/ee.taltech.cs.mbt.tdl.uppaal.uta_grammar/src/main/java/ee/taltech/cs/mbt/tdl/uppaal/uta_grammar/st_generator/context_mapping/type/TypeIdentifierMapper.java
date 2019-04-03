package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.type;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.expression.ExpressionMapper;
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

import java.util.Collection;

public class TypeIdentifierMapper implements IContextMapper<AbsTypeId>, ITypeIdentifierVisitor<ContextBuilder> {
	public static TypeIdentifierMapper getInstance() {
		return INSTANCE;
	}

	private static final TypeIdentifierMapper INSTANCE = new TypeIdentifierMapper();

	private TypeIdentifierMapper() { }

	@Override
	public ContextBuilder map(AbsTypeId typeId) {
		ContextBuilder builder = typeId.accept(this);
		return typeId.accept(this);
	}

	@Override
	public ContextBuilder visitStructTypeIdentifier(StructTypeId id) {
		Collection<ContextBuilder> fieldCtxs = FieldDeclarationMapper.getInstance().map(id.getFieldDeclarations());
		return ContextBuilder.newBuilder("struct")
				.put("fieldDeclarations", fieldCtxs);
	}

	@Override
	public ContextBuilder visitScalarTypeIdentifier(ScalarTypeId id) {
		ContextBuilder sizeCtx = ExpressionMapper.getInstance()
				.map(id.getSizeExpression());
		return ContextBuilder.newBuilder("scalar")
				.put("expression", sizeCtx);
	}

	@Override
	public ContextBuilder visitCustomTypeIdentifier(CustomTypeId id) {
		return ContextBuilder.newBuilder("customType")
				.put("identifierValue", id.getIdentifier().toString());
	}

	@Override
	public ContextBuilder visitBoundedIntegerTypeIdentifier(BoundedIntegerTypeId id) {
		ContextBuilder minExprCtx = ExpressionMapper.getInstance().map(id.getMinimumBound());
		ContextBuilder maxExprCtx = ExpressionMapper.getInstance().map(id.getMaximumBound());
		return ContextBuilder.newBuilder("boundedInt")
				.put("minExpression", minExprCtx)
				.put("maxExpression", maxExprCtx);
	}

	@Override
	public ContextBuilder visitBooleanTypeIdentifier(BooleanTypeId id) {
		return ContextBuilder.newBuilder("boolean");
	}

	@Override
	public ContextBuilder visitIntegerTypeIdentifier(IntegerTypeId id) {
		return ContextBuilder.newBuilder("int");
	}

	@Override
	public ContextBuilder visitChannelTypeIdentifier(ChannelTypeId id) {
		return ContextBuilder.newBuilder("chan");
	}

	@Override
	public ContextBuilder visitClockTypeIdentifier(ClockTypeId id) {
		return ContextBuilder.newBuilder("clock");
	}
}
