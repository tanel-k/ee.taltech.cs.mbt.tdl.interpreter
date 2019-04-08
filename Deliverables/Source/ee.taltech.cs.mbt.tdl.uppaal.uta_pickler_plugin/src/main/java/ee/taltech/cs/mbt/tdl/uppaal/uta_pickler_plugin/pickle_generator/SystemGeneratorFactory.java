package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator;

import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.STRegistry;

public class SystemGeneratorFactory {
	private static final String TEMPLATE_GROUP_PATH = "template-source/PickledSystem.stg";
	private static final STRegistry ST_REGISTRY = STRegistry.fromGroupFilePath(TEMPLATE_GROUP_PATH);

	public static SystemGenerator systemGenerator() {
		return new SystemGenerator(ST_REGISTRY);
	}
}
