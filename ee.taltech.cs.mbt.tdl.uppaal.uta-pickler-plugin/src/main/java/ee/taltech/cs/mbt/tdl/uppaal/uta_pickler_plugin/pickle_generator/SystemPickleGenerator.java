package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator;

import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.generator.AbsSTGenerator;
import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.generator.STRegistry;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.UtaSystem;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.structure.SystemExtractor;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

public class SystemPickleGenerator extends AbsSTGenerator<UtaSystem> {
	private static final String TEMPLATE_NAME = "systemFactory";
	private static final SimpleDateFormat commentDateFmt = new SimpleDateFormat("dd/MMM/yyyy");

	private String picklePackage;
	private String pickleName;
	private SystemExtractor extractor = SystemExtractor.getInstance();

	SystemPickleGenerator(String picklePackage, String pickleName, STRegistry stRegistry) {
		super(stRegistry);
		this.picklePackage = picklePackage;
		this.pickleName = pickleName;
	}

	protected Collection<String> getImportStrings(SystemExtractor extractor) {
		return extractor.getRequiredClasses().stream()
			.map(Class::getCanonicalName)
			.sorted()
			.collect(Collectors.toList());
	}

	protected String getClassCommentLine() {
		return "Generated on " + commentDateFmt.format(new Date()) + " using the UTA pickler plugin.";
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
				.put("imports", getImportStrings(extractor))
				.put("classCommentLine", getClassCommentLine());
	}
}
