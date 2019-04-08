package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.type;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
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
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitScalarTypeIdentifier(ScalarTypeId id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitCustomTypeIdentifier(CustomTypeId id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitBoundedIntegerTypeIdentifier(BoundedIntegerTypeId id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitBooleanTypeIdentifier(BooleanTypeId id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitIntegerTypeIdentifier(IntegerTypeId id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitChannelTypeIdentifier(ChannelTypeId id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitClockTypeIdentifier(ClockTypeId id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
