package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.template;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.expression.ExpressionMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Synchronization;

public class SynchronizationMapper implements IContextMapper<Synchronization> {
	public static SynchronizationMapper getInstance() {
		return INSTANCE;
	}

	private static final SynchronizationMapper INSTANCE = new SynchronizationMapper();

	private SynchronizationMapper() { }

	@Override
	public ContextBuilder map(Synchronization inst) {
		ContextBuilder exprCtx = ExpressionMapper.getInstance().map(inst.getExpression());
		return ContextBuilder.newBuilder()
				.put("expression", exprCtx)
				.put("activeSync", inst.isActiveSync());
	}
}
