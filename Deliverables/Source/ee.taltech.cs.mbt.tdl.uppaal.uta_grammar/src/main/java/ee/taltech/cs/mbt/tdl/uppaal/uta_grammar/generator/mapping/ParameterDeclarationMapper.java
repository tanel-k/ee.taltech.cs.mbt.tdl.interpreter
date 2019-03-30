package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.mapping;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.ContextBuilder;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.parameter.ParameterDeclaration;

public class ParameterDeclarationMapper implements IContextMapper<ParameterDeclaration> {
	public static ParameterDeclarationMapper getInstance() {
		return INSTANCE;
	}

	private static final ParameterDeclarationMapper INSTANCE = new ParameterDeclarationMapper();

	private ParameterDeclarationMapper() { }

	@Override
	public ContextBuilder map(ParameterDeclaration declaration) {
		return ContextBuilder.newBuilder()
				.put("name", declaration.getIdentifier().getText())
				.put("type", TypeMapper.getInstance().map(declaration.getType()));
	}
}
