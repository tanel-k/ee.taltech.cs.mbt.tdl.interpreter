package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.conversion;

import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.composite.serialization.language.GenerationQueue;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.GlobalDeclarationsNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.SystemDefinitionNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.structure.jaxb.UtaNode;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.UtaGeneratorFactory;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.UtaSystem;

public class UtaSystemConverter {
	public static UtaSystemConverter getInstance(UtaGeneratorFactory generatorFactory, GenerationQueue generationQueue) {
		return new UtaSystemConverter(generatorFactory, generationQueue);
	}

	private TemplateConverter templateConverter;
	private UtaGeneratorFactory generatorFactory;
	private GenerationQueue generationQueue;

	private UtaSystemConverter(UtaGeneratorFactory generatorFactory, GenerationQueue generationQueue) {
		this.generatorFactory = generatorFactory;
		this.generationQueue = generationQueue;
		this.templateConverter = TemplateConverter.getInstance(this);
	}

	public UtaGeneratorFactory getGeneratorFactory() {
		return generatorFactory;
	}

	public GenerationQueue getGenerationQueue() {
		return generationQueue;
	}

	private void injectSystemDefinition(UtaSystem system, UtaNode utaNode) {
		if (system.getSystemDefinition() == null)
			return;

		SystemDefinitionNode systemDefinitionNode = new SystemDefinitionNode();
		getGenerationQueue().enqueue(
				system.getSystemDefinition(),
				getGeneratorFactory().systemDefinitionGenerator(),
				systemDefinitionNode::setValue
		);
		utaNode.setSystem(systemDefinitionNode);
	}

	private void injectGlobalDeclarations(UtaSystem system, UtaNode utaNode) {
		if (system.getGlobalDeclarations().isEmpty())
			return;

		GlobalDeclarationsNode globalDeclarationsNode = new GlobalDeclarationsNode();
		getGenerationQueue().enqueue(
				system.getGlobalDeclarations(),
				getGeneratorFactory().declarationGenerator(),
				globalDeclarationsNode::setValue
		);
		utaNode.setDeclaration(globalDeclarationsNode);
	}

	private void injectTemplates(UtaSystem system, UtaNode utaNode) {
		if (system.getTemplateMap().isEmpty())
			return;
		system.getTemplateMap().values().stream()
				.map(templateConverter::convert)
				.forEach(utaNode.getTemplates()::add);
	}

	public UtaNode convert(UtaSystem system) {
		UtaNode utaNode = new UtaNode();

		injectSystemDefinition(system, utaNode);
		injectGlobalDeclarations(system, utaNode);
		injectTemplates(system, utaNode);

		return utaNode;
	}
}
