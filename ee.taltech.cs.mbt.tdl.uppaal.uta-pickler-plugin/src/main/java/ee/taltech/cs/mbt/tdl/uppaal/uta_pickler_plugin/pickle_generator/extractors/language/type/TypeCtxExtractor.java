package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.type;

import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.misc.ArrayModifierCtxExtractor;

import java.util.Collection;
import java.util.Set;

public class TypeCtxExtractor implements IPicklerContextExtractor<Type> {
	public static TypeCtxExtractor getInstance() {
		return new TypeCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet(
			Type.class
	);

	private TypeCtxExtractor() { }

	@Override
	public ContextBuilder extract(Type type) {
		ContextBuilder baseTypeCtx = BaseTypeCtxExtractor.getInstance()
				.extract(type.getBaseType(), requiredClasses);
		Collection<ContextBuilder> arrayModCtxs = ArrayModifierCtxExtractor.getInstance()
				.extract(type.getArrayModifiers(), requiredClasses);
		return ContextBuilder.newBuilder()
				.put("baseType", baseTypeCtx)
				.put("referenceType", type.isReferenceType())
				.put("arrayModifiers", arrayModCtxs);
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
