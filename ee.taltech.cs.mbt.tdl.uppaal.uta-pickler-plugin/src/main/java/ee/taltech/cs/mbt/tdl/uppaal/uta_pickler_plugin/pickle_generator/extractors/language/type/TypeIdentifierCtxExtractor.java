package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.type;

import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.AbsTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BaseTypeIdentifiers;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BaseTypeIdentifiers.BooleanTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BaseTypeIdentifiers.ChannelTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BaseTypeIdentifiers.ClockTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BaseTypeIdentifiers.IntegerTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.BoundedIntegerTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.CustomTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.ScalarTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.StructTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.ITypeIdentifierVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.expression.ExpressionCtxExtractor;

import java.util.Collection;
import java.util.Set;

public class TypeIdentifierCtxExtractor implements IPicklerContextExtractor<AbsTypeId>,
		ITypeIdentifierVisitor<ContextBuilder> {
	public static TypeIdentifierCtxExtractor getInstance() {
		return new TypeIdentifierCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private TypeIdentifierCtxExtractor() { }

	@Override
	public ContextBuilder extract(AbsTypeId id) {
		return id.accept(this);
	}

	@Override
	public ContextBuilder visitStructTypeIdentifier(StructTypeId id) {
		requiredClasses.add(id.getClass());
		Collection<ContextBuilder> fieldDeclCtxs = FieldDeclarationCtxExtractor.getInstance()
				.extract(id.getFieldDeclarations(), requiredClasses);
		return ContextBuilder.newBuilder("struct")
				.put("fieldDeclarations", fieldDeclCtxs);
	}

	@Override
	public ContextBuilder visitScalarTypeIdentifier(ScalarTypeId id) {
		requiredClasses.add(id.getClass());
		ContextBuilder exprCtx = ExpressionCtxExtractor.getInstance()
				.extract(id.getSizeExpression(), requiredClasses);
		return ContextBuilder.newBuilder("scalar")
				.put("expression", exprCtx);
	}

	@Override
	public ContextBuilder visitCustomTypeIdentifier(CustomTypeId id) {
		CollectionUtils.addAll(requiredClasses, id.getClass(), Identifier.class);
		requiredClasses.add(Identifier.class);
		return ContextBuilder.newBuilder("customType")
				.put("identifier", id.getIdentifier().toString());
	}

	@Override
	public ContextBuilder visitBoundedIntegerTypeIdentifier(BoundedIntegerTypeId id) {
		requiredClasses.add(BoundedIntegerTypeId.class);
		ContextBuilder minExprCtx = ExpressionCtxExtractor.getInstance()
				.extract(id.getMinimumBound(), requiredClasses);
		ContextBuilder maxExprCtx = ExpressionCtxExtractor.getInstance()
				.extract(id.getMaximumBound(), requiredClasses);
		return ContextBuilder.newBuilder("boundedInt")
				.put("minExpression", minExprCtx)
				.put("maxExpression", maxExprCtx);
	}

	@Override
	public ContextBuilder visitBooleanTypeIdentifier(BooleanTypeId id) {
		requiredClasses.add(BaseTypeIdentifiers.class);
		return ContextBuilder.newBuilder("bool");
	}

	@Override
	public ContextBuilder visitIntegerTypeIdentifier(IntegerTypeId id) {
		requiredClasses.add(BaseTypeIdentifiers.class);
		return ContextBuilder.newBuilder("int");
	}

	@Override
	public ContextBuilder visitChannelTypeIdentifier(ChannelTypeId id) {
		requiredClasses.add(BaseTypeIdentifiers.class);
		return ContextBuilder.newBuilder("chan");
	}

	@Override
	public ContextBuilder visitClockTypeIdentifier(ClockTypeId id) {
		requiredClasses.add(BaseTypeIdentifiers.class);
		return ContextBuilder.newBuilder("clock");
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
