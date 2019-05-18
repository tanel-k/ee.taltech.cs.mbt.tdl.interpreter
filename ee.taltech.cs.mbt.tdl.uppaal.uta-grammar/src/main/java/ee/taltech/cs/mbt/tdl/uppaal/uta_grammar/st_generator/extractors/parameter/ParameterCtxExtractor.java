package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.parameter;

import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.type.TypeCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.parameter.ParameterDeclaration;

public class ParameterCtxExtractor implements IContextExtractor<ParameterDeclaration> {
	public static ParameterCtxExtractor getInstance() {
		return INSTANCE;
	}

	private static final ParameterCtxExtractor INSTANCE = new ParameterCtxExtractor();

	private ParameterCtxExtractor() { }

	@Override
	public ContextBuilder extract(ParameterDeclaration inst) {
		return ContextBuilder.newBuilder()
				.put("type", TypeCtxExtractor.getInstance().extract(inst.getType()))
				.put("name", inst.getIdentifier().toString());
	}
}
