package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator;

import ee.taltech.cs.mbt.tdl.commons.st_utils.generator.STRegistry;
import org.stringtemplate.v4.StringRenderer;

public class SystemPickleGeneratorFactory {
	private static final String TEMPLATE_GROUP_PATH = "template-source/PickledSystem.stg";
	private static final STRegistry ST_REGISTRY;

	static {
		ST_REGISTRY = STRegistry.fromGroupFilePath(TEMPLATE_GROUP_PATH);
		ST_REGISTRY.registerRenderer(String.class, new StringRenderer());
	}

	public static SystemPickleGenerator systemGenerator(String picklePackage, String pickleName) {
		return new SystemPickleGenerator(picklePackage, pickleName, ST_REGISTRY);
	}

	public static SystemFactoryClassNameGenerator factoryClassNameGenerator() {
		return new SystemFactoryClassNameGenerator(ST_REGISTRY);
	}
}
