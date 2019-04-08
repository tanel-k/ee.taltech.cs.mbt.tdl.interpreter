package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.STRegistry;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.SystemExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.util.Optional;

public class PickleGenerator extends AbsSTGenerator<UtaSystem> {
	private String picklePackage;
	private String pickleClassName;

	PickleGenerator(String picklePackage, String pickleClassName, STRegistry stRegistry) {
		super(stRegistry);
		this.picklePackage = picklePackage;
		this.pickleClassName = pickleClassName;
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

	@Override
	protected ContextBuilder extractContext(UtaSystem inst) {
		return super.extractContext(inst)
				.put("picklePackage", picklePackage)
				.put("pickleClassName", pickleClassName);
	}
}
