package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.misc;

import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.BaseTypeExtensionMap.BaseTypeExtension;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;

import java.util.Collection;
import java.util.Set;

public class BaseTypeExtensionCtxExtractor implements IPicklerContextExtractor<BaseTypeExtension> {
	public static BaseTypeExtensionCtxExtractor getInstance() {
		return new BaseTypeExtensionCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet(
			Identifier.class
	);

	private BaseTypeExtensionCtxExtractor() { }

	@Override
	public ContextBuilder extract(BaseTypeExtension baseTypeExt) {
		Collection<ContextBuilder> arrayModCtxs = ArrayModifierCtxExtractor.getInstance()
				.extract(baseTypeExt.getArrayModifiers(), requiredClasses);
		return ContextBuilder.newBuilder()
				.put("identifier", baseTypeExt.getIdentifier().toString())
				.put("arrayModifiers", arrayModCtxs)
				.put("referenceType", baseTypeExt.isReferenceType());
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
