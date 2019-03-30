package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.mapping;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.ContextBuilder;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;

public class TypeMapper implements IContextMapper<Type<?>> {
	public static TypeMapper getInstance() {
		return INSTANCE;
	}

	private static final TypeMapper INSTANCE = new TypeMapper();

	private TypeMapper() { }

	private void injectTypePrefix(ContextBuilder toBuilder, String name) {
		toBuilder.put(
				"prefix",
				ContextBuilder.newBuilder(name)
			);
	}

	@Override
	public ContextBuilder map(Type<?> type) {
		ContextBuilder builder = ContextBuilder.newBuilder();
		switch (type.getTypePrefix()) {
			case BROADCAST:
				injectTypePrefix(builder, "broadcast");
				break;
			case CONSTANT:
				injectTypePrefix(builder, "constant");
				break;
			case URGENT:
				injectTypePrefix(builder, "urgent");
				break;
			case META:
				injectTypePrefix(builder, "meta");
				break;
			case NONE:
			default:
				break;
		}
		builder.put("referenceType", type.isReferenceType());
		builder.put("arrayModifiers", ArraySizeModifierMapper.getInstance()
				.mapCollection(type.getArrayModifiers()));
		builder.put(
				"identifier",
				TypeIdentifierMapper.getInstance().map(type.getTypeIdentifier())
		);
		return builder;
	}
}
