package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.type;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;

public class BaseTypeCtxExtractor implements IContextExtractor<BaseType> {
	public static BaseTypeCtxExtractor getInstance() {
		return INSTANCE;
	}

	private static final BaseTypeCtxExtractor INSTANCE = new BaseTypeCtxExtractor();

	private BaseTypeCtxExtractor() { }

	@Override
	public ContextBuilder extract(BaseType inst) {
		String prefixKey = "";
		switch (inst.getPrefix()) {
		case BROADCAST:
			prefixKey = "broadcast";
			break;
		case CONSTANT:
			prefixKey = "constant";
			break;
		case URGENT:
			prefixKey = "urgent";
			break;
		case META:
			prefixKey = "meta";
			break;
		case NONE:
		default:
			break;
		}
		ContextBuilder typeIdCtx = TypeIdentifierCtxExtractor.getInstance().extract(inst.getTypeId());
		return ContextBuilder.newBuilder()
				.put("prefix", prefixKey.isEmpty()
						? null
						: ContextBuilder.newBuilder(prefixKey))
				.put("typeId", typeIdCtx);
	}
}
