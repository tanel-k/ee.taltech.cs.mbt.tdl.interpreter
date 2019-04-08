package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.declaration;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.expression.ExpressionMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer.AbsVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer.FlatVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer.StructuredVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IInitializerVisitor;

public class InitializerMapper implements IContextMapper<AbsVariableInitializer>, IInitializerVisitor<ContextBuilder> {
	public static InitializerMapper getInstance() {
		return INSTANCE;
	}

	public static final InitializerMapper INSTANCE = new InitializerMapper();

	private InitializerMapper() { }

	@Override
	public ContextBuilder map(AbsVariableInitializer inst) {
		return inst.accept(this);
	}

	@Override
	public ContextBuilder visitFlatInitializer(FlatVariableInitializer init) {
		ContextBuilder exprCtx = ExpressionMapper.getInstance().map(init.getExpression());
		return ContextBuilder.newBuilder("flatInitializer")
				.put("expression", exprCtx);
	}

	@Override
	public ContextBuilder visitStructuredInitializer(StructuredVariableInitializer init) {
		return ContextBuilder.newBuilder("structuredInitializer")
				.put("nestedInitializers", this.map(init.getInitializers()));
	}
}
