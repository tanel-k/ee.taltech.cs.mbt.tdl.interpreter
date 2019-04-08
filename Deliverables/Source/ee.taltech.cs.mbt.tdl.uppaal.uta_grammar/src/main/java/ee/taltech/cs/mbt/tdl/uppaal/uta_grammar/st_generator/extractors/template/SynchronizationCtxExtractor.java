package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.template;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.expression.ExpressionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Synchronization;

public class SynchronizationCtxExtractor implements IContextExtractor<Synchronization> {
	public static SynchronizationCtxExtractor getInstance() {
		return INSTANCE;
	}

	private static final SynchronizationCtxExtractor INSTANCE = new SynchronizationCtxExtractor();

	private SynchronizationCtxExtractor() { }

	@Override
	public ContextBuilder extract(Synchronization inst) {
		ContextBuilder exprCtx = ExpressionCtxExtractor.getInstance().extract(inst.getExpression());
		return ContextBuilder.newBuilder()
				.put("expression", exprCtx)
				.put("activeSync", inst.isActiveSync());
	}
}
