package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.misc;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.BaseTypeExtensionMap.BaseTypeExtension;

public class BaseTypeExtensionMapper implements IContextMapper<BaseTypeExtension> {
	public static BaseTypeExtensionMapper getInstance() {
		return INSTANCE;
	}

	private static final BaseTypeExtensionMapper INSTANCE = new BaseTypeExtensionMapper();

	private BaseTypeExtensionMapper() { }

	@Override
	public ContextBuilder map(BaseTypeExtension inst) {
		return ContextBuilder.newBuilder()
				.put("identifierValue", inst.getIdentifier().toString())
				.put("referenceType", inst.isReferenceType())
				.put("arraySizeModifiers", ArrayModifierMapper.getInstance().map(inst.getArrayModifiers()));
	}
}
