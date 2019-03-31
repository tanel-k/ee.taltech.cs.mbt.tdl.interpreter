package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.declaration.DeclarationMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.STRegistry;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;

import java.util.Optional;

public class DeclarationGenerator extends AbsSTGenerator<AbsDeclarationStatement> {
	private static final String TEMPLATE_NAME = "declaration";
	private static final String ITERABLE_TEMPLATE_NAME = "declarations";

	DeclarationGenerator(STRegistry stRegistry) {
		super(stRegistry);
	}

	@Override
	protected IContextMapper<AbsDeclarationStatement> getContextMapper() {
		return DeclarationMapper.getInstance();
	}

	@Override
	protected String getTemplateName() {
		return TEMPLATE_NAME;
	}

	@Override
	protected Optional<String> getIterableTemplateName() {
		return Optional.of(ITERABLE_TEMPLATE_NAME);
	}
}
