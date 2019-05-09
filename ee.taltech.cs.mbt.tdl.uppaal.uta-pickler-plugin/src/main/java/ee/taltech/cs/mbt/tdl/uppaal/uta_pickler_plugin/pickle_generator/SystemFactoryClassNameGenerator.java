package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.STRegistry;

import java.util.Optional;

public class SystemFactoryClassNameGenerator extends AbsSTGenerator<String> {
	private static final String TEMPLATE_NAME = "systemFactoryClassName";

	SystemFactoryClassNameGenerator(STRegistry stRegistry) {
		super(stRegistry);
	}

	@Override
	protected IContextExtractor<String> getContextExtractor() {
		return new IContextExtractor<String>() {
			@Override
			public ContextBuilder extract(String str) {
				return ContextBuilder.newBuilder().put("name", str);
			}
		};
	}

	@Override
	protected String getTemplateName() {
		return TEMPLATE_NAME;
	}

	@Override
	protected Optional<String> getIterableTemplateName() {
		return Optional.empty();
	}
}
