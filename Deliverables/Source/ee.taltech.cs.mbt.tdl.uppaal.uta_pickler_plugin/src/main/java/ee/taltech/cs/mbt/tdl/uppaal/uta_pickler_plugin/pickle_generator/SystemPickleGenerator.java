package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.STRegistry;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.SystemExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public class SystemPickleGenerator extends AbsSTGenerator<UtaSystem> {
	private static final String TEMPLATE_NAME = "systemPickle";

	private String picklePackage;
	private String pickleName;
	private SystemExtractor extractor = SystemExtractor.getInstance();

	SystemPickleGenerator(String picklePackage, String pickleName, STRegistry stRegistry) {
		super(stRegistry);
		this.picklePackage = picklePackage;
		this.pickleName = pickleName;
	}

	protected Collection<String> getImportStrings(SystemExtractor extractor) {
		Set<Class> classes = extractor.getRequiredClasses();
		// FIXME: SORT ALPHABETICALLY
		// FIXME: TO FULLY QUALIFIED CLASS NAMES
		throw new UnsupportedOperationException();
	}

	@Override
	protected IContextExtractor<UtaSystem> getContextExtractor() {
		return extractor;
	}

	@Override
	protected String getTemplateName() {
		return TEMPLATE_NAME;
	}

	@Override
	protected Optional<String> getIterableTemplateName() {
		return Optional.empty();
	}

	@Override
	protected ContextBuilder extractContext(UtaSystem inst) {
		return super.extractContext(inst)
				.put("package", picklePackage)
				.put("name", pickleName)
				.put("imports", getImportStrings(extractor));
	}
}
