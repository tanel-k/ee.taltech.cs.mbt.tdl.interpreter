package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.type;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;

public class BaseTypeMapper implements IContextMapper<BaseType> {
	public static BaseTypeMapper getInstance() {
		return INSTANCE;
	}

	private static final BaseTypeMapper INSTANCE = new BaseTypeMapper();

	private BaseTypeMapper() { }

	@Override
	public ContextBuilder map(BaseType inst) {
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
		ContextBuilder typeIdCtx = TypeIdentifierMapper.getInstance().map(inst.getTypeId());
		return ContextBuilder.newBuilder()
				.put("prefix", prefixKey.isEmpty()
						? null
						: ContextBuilder.newBuilder("prefixKey"))
				.put("typeId", typeIdCtx);
	}
}
