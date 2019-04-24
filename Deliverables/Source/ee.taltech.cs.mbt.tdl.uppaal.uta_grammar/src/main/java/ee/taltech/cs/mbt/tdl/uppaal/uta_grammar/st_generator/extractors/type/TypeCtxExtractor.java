package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.type;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.misc.ArrayModifierCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.Type;

import java.util.Collection;

public class TypeCtxExtractor implements IContextExtractor<Type> {
	public static TypeCtxExtractor getInstance() {
		return INSTANCE;
	}

	private static final TypeCtxExtractor INSTANCE = new TypeCtxExtractor();

	private TypeCtxExtractor() { }

	@Override
	public ContextBuilder extract(Type inst) {
		ContextBuilder baseTypeCtx = BaseTypeCtxExtractor.getInstance()
				.extract(inst.getBaseType());
		Collection<ContextBuilder> arrayModifierCtxs = ArrayModifierCtxExtractor.getInstance().extract(inst.getArrayModifiers());
		return ContextBuilder.newBuilder()
				.put("baseType", baseTypeCtx)
				.put("referenceType", inst.isReferenceType())
				.put("arrayModifiers", arrayModifierCtxs);
	}
}
