package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.misc;

import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.BaseTypeExtensionMap.BaseTypeExtension;

public class BaseTypeExtensionCtxExtractor implements IContextExtractor<BaseTypeExtension> {
	public static BaseTypeExtensionCtxExtractor getInstance() {
		return INSTANCE;
	}

	private static final BaseTypeExtensionCtxExtractor INSTANCE = new BaseTypeExtensionCtxExtractor();

	private BaseTypeExtensionCtxExtractor() { }

	@Override
	public ContextBuilder extract(BaseTypeExtension inst) {
		return ContextBuilder.newBuilder()
				.put("identifierValue", inst.getIdentifier().toString())
				.put("referenceType", inst.isReferenceType())
				.put("arrayModifiers", ArrayModifierCtxExtractor.getInstance().extract(inst.getArrayModifiers()));
	}
}
