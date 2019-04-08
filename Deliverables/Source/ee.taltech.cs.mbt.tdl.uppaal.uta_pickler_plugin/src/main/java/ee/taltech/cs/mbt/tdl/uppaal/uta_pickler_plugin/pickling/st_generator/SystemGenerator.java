package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickling.st_generator;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.STRegistry;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickling.st_generator.extractors.SystemExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.util.Optional;

public class SystemGenerator extends AbsSTGenerator<UtaSystem> {
	SystemGenerator(STRegistry stRegistry) {
		super(stRegistry);
	}

	@Override
	protected IContextExtractor<UtaSystem> getContextExtractor() {
		return SystemExtractor.getInstance();
	}

	@Override
	protected String getTemplateName() {
		throw new UnsupportedOperationException();
	}

	@Override
	protected Optional<String> getIterableTemplateName() {
		return Optional.empty();
	}
}
