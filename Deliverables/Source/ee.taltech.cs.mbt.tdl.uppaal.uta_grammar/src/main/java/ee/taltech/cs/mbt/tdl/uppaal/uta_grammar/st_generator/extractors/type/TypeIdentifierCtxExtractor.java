package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.type;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.expression.ExpressionCtxExtractor;
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

public class TypeIdentifierCtxExtractor implements IContextExtractor<AbsTypeId>, ITypeIdentifierVisitor<ContextBuilder> {
	public static TypeIdentifierCtxExtractor getInstance() {
		return INSTANCE;
	}

	private static final TypeIdentifierCtxExtractor INSTANCE = new TypeIdentifierCtxExtractor();

	private TypeIdentifierCtxExtractor() { }

	@Override
	public ContextBuilder extract(AbsTypeId typeId) {
		ContextBuilder builder = typeId.accept(this);
		return typeId.accept(this);
	}

	@Override
	public ContextBuilder visitStructTypeIdentifier(StructTypeId id) {
		Collection<ContextBuilder> fieldCtxs = FieldDeclarationCtxExtractor.getInstance().extract(id.getFieldDeclarations());
		return ContextBuilder.newBuilder("struct")
				.put("fieldDeclarations", fieldCtxs);
	}

	@Override
	public ContextBuilder visitScalarTypeIdentifier(ScalarTypeId id) {
		ContextBuilder sizeCtx = ExpressionCtxExtractor.getInstance()
				.extract(id.getSizeExpression());
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
		ContextBuilder minExprCtx = ExpressionCtxExtractor.getInstance().extract(id.getMinimumBound());
		ContextBuilder maxExprCtx = ExpressionCtxExtractor.getInstance().extract(id.getMaximumBound());
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
