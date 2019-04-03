package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.parameter;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.type.TypeMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.parameter.ParameterDeclaration;

public class ParameterMapper implements IContextMapper<ParameterDeclaration> {
	public static ParameterMapper getInstance() {
		return INSTANCE;
	}

	private static final ParameterMapper INSTANCE = new ParameterMapper();

	private ParameterMapper() { }

	@Override
	public ContextBuilder map(ParameterDeclaration inst) {
		return ContextBuilder.newBuilder()
				.put("type", TypeMapper.getInstance().map(inst.getType()))
				.put("name", inst.getIdentifier().toString());
	}
}
