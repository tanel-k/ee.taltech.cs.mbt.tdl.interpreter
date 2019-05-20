package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator;

import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.template.SelectionCtxExtractor;
import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.generator.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.generator.STRegistry;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.template.Selection;

import java.util.Optional;

public class SelectionGenerator extends AbsSTGenerator<Selection> {
	private static final String TEMPLATE_NAME = "selection";
	private static final String ITERABLE_TEMPLATE_NAME = "selections";

	SelectionGenerator(STRegistry stRegistry) {
		super(stRegistry);
	}

	@Override
	protected IContextExtractor<Selection> getContextExtractor() {
		return SelectionCtxExtractor.getInstance();
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
