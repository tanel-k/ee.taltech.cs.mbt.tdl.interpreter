package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator;

import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.declaration.DeclarationCtxExtractor;
import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.generator.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.generator.STRegistry;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.AbsDeclarationStatement;

import java.util.Optional;

public class DeclarationGenerator extends AbsSTGenerator<AbsDeclarationStatement> {
	private static final String TEMPLATE_NAME = "declaration";
	private static final String ITERABLE_TEMPLATE_NAME = "declarations";

	DeclarationGenerator(STRegistry stRegistry) {
		super(stRegistry);
	}

	@Override
	protected IContextExtractor<AbsDeclarationStatement> getContextExtractor() {
		return DeclarationCtxExtractor.getInstance();
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
