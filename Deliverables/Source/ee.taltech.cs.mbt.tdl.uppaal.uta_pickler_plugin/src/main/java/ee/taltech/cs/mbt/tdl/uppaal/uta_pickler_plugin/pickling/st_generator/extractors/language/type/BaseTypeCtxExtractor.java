package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickling.st_generator.extractors.language.type;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickling.st_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;

import java.util.Set;

public class BaseTypeCtxExtractor implements IPicklerContextExtractor<BaseType> {
	public static BaseTypeCtxExtractor getInstance() {
		return new BaseTypeCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private BaseTypeCtxExtractor() { }

	@Override
	public ContextBuilder extract(BaseType baseType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
