package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.system;

import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.declaration.DeclarationCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.expression.ExpressionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.system.system_line.ProcessReferenceGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.system.system_line.SystemLine;

import java.util.Collection;
import java.util.LinkedList;

public class SystemDefinitionCtxExtractor implements IContextExtractor<SystemDefinition> {
	public static SystemDefinitionCtxExtractor getInstance() {
		return INSTANCE;
	}

	private static final SystemDefinitionCtxExtractor INSTANCE = new SystemDefinitionCtxExtractor();

	private SystemDefinitionCtxExtractor() { }

	@Override
	public ContextBuilder extract(SystemDefinition inst) {
		Collection<ContextBuilder> declCtxs = DeclarationCtxExtractor.getInstance().extract(inst.getDeclarations());
		Collection<ContextBuilder> progMeasureCtxs = ExpressionCtxExtractor.getInstance().extract(inst.getProgressMeasureExpressions());

		SystemLine systemLine = inst.getSystemLine();
		Collection<ContextBuilder> referenceGroups = new LinkedList<>();
		if (systemLine != null) {
			for (ProcessReferenceGroup refGrp : systemLine.getProcessPrioritySequence()) {
				Collection<String> processRefs = new LinkedList<>();
				for (Identifier reference : refGrp.getProcessIdentifiers()) {
					processRefs.add(reference.toString());
				}
				referenceGroups.add(
						ContextBuilder.newBuilder().put("processReferences", processRefs)
				);
			}
		}
		ContextBuilder systemLineCtx = referenceGroups.isEmpty()
				? null
				: ContextBuilder.newBuilder().put("processReferenceGroups", referenceGroups);

		return ContextBuilder.newBuilder()
				.put("systemLine", systemLineCtx)
				.put("declarations", declCtxs.isEmpty() ? null : declCtxs)
				.put("progressMeasures", progMeasureCtxs.isEmpty() ? null : progMeasureCtxs);
	}
}
