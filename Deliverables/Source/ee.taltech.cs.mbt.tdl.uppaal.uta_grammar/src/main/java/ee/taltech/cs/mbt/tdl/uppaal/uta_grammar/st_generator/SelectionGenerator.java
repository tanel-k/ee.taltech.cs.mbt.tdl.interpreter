package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.template.SelectionMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.st.STRegistry;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Selection;

import java.util.Optional;

public class SelectionGenerator extends AbsSTGenerator<Selection> {
	private static final String TEMPLATE_NAME = "selection";
	private static final String ITERABLE_TEMPLATE_NAME = "selections";

	SelectionGenerator(STRegistry stRegistry) {
		super(stRegistry);
	}

	@Override
	protected IContextMapper<Selection> getContextMapper() {
		return SelectionMapper.getInstance();
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
