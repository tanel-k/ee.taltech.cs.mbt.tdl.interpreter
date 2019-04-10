package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.type;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.ETypePrefix;

import java.util.Set;

public class BaseTypeCtxExtractor implements IPicklerContextExtractor<BaseType> {
	public static BaseTypeCtxExtractor getInstance() {
		return new BaseTypeCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet(
			BaseType.class,
			ETypePrefix.class
	);

	private BaseTypeCtxExtractor() { }

	@Override
	public ContextBuilder extract(BaseType baseType) {
		ETypePrefix typePrefix = baseType.getPrefix();
		ContextBuilder typeIdCtx = TypeIdentifierCtxExtractor.getInstance()
				.extract(baseType.getTypeId(), requiredClasses);
		return ContextBuilder.newBuilder()
				.put("prefix", ContextBuilder.newBuilder()
						.put("urgent", typePrefix == ETypePrefix.URGENT)
						.put("meta", typePrefix == ETypePrefix.META)
						.put("constant", typePrefix == ETypePrefix.CONSTANT)
						.put("broadcast", typePrefix == ETypePrefix.BROADCAST)
				)
				.put("typeId", typeIdCtx);
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
