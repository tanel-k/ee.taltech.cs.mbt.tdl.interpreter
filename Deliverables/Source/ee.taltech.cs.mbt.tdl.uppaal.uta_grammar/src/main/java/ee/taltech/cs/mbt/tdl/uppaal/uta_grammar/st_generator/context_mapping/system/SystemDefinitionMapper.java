package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.system;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.declaration.DeclarationMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.expression.ExpressionMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.system_line.ProcessReferenceGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.system_line.SystemLine;

import java.util.Collection;
import java.util.LinkedList;

public class SystemDefinitionMapper implements IContextMapper<SystemDefinition> {
	public static SystemDefinitionMapper getInstance() {
		return INSTANCE;
	}

	private static final SystemDefinitionMapper INSTANCE = new SystemDefinitionMapper();

	private SystemDefinitionMapper() { }

	@Override
	public ContextBuilder map(SystemDefinition inst) {
		Collection<ContextBuilder> declCtxs = DeclarationMapper.getInstance().map(inst.getDeclarations());
		Collection<ContextBuilder> progMeasureCtxs = ExpressionMapper.getInstance().map(inst.getProgressMeasureExpressions());

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
