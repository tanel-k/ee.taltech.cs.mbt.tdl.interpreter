package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.type;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.misc.ArrayModifierMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;

import java.util.Collection;

public class TypeMapper implements IContextMapper<Type> {
	public static TypeMapper getInstance() {
		return INSTANCE;
	}

	private static final TypeMapper INSTANCE = new TypeMapper();

	private TypeMapper() { }

	@Override
	public ContextBuilder map(Type inst) {
		ContextBuilder baseTypeCtx = BaseTypeMapper.getInstance()
				.map(inst.getBaseType());
		Collection<ContextBuilder> arrayModifierCtxs = ArrayModifierMapper.getInstance().map(inst.getArrayModifiers());
		return ContextBuilder.newBuilder()
				.put("baseType", baseTypeCtx)
				.put("referenceType", inst.isReferenceType())
				.put("arrayModifiers", arrayModifierCtxs);
	}
}
