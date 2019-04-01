package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.conversion;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.serialization.language.GenerationQueue;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.GlobalDeclarationsNode;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.ImportsNode;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.SystemNode;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.jaxb.UtaNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.UtaGeneratorFactory;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

public class UtaSystemConverter {
	public static UtaSystemConverter getInstance(UtaGeneratorFactory generatorFactory) {
		return new UtaSystemConverter(generatorFactory);
	}

	private UtaSystemConverter(UtaGeneratorFactory generatorFactory) {
		this.generatorFactory = generatorFactory;
	}

	private UtaGeneratorFactory generatorFactory;
	private GenerationQueue generationQueue = new GenerationQueue();

	private UtaGeneratorFactory getGeneratorFactory() {
		return generatorFactory;
	}

	public GenerationQueue getGenerationQueue() {
		return generationQueue;
	}

	public UtaNode convert(UtaSystem system) { // FIXME
		UtaNode utaNode = new UtaNode();

		system.getSystemDefinition();

		if (!system.getGlobalDeclarations().isEmpty())
			getGenerationQueue().enqueue(
					system.getGlobalDeclarations(),
					getGeneratorFactory().declarationGenerator(),
					s -> {
						GlobalDeclarationsNode node = new GlobalDeclarationsNode();
						node.setValue(s);
						utaNode.setDeclaration(node);
					}
			);

		if (!system.getTemplateMap().isEmpty()) {
			system.getTemplateMap();
		}

		

		GlobalDeclarationsNode globalDeclarationsNode = new GlobalDeclarationsNode();
		SystemNode systemNode = new SystemNode();

		return utaNode;
	}
}
