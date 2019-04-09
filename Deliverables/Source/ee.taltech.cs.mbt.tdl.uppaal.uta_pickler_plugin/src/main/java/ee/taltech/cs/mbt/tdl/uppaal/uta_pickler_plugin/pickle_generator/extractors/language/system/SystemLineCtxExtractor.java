package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.system;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.system_line.ProcessReferenceGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.system.system_line.SystemLine;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;

public class SystemLineCtxExtractor implements IPicklerContextExtractor<SystemLine> {
	public static SystemLineCtxExtractor getInstance() {
		return new SystemLineCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet(
			SystemLine.class,
			Identifier.class,
			ProcessReferenceGroup.class
	);

	@Override
	public ContextBuilder extract(SystemLine systemLine) {
		Collection<ContextBuilder> referenceGroupCtxs = new LinkedList<>();
		for (ProcessReferenceGroup refGrp : systemLine.getProcessPrioritySequence()) {
			Collection<String> processRefs = new LinkedList<>();
			refGrp.getProcessIdentifiers().stream()
					.map(Object::toString)
					.forEachOrdered(processRefs::add);
			referenceGroupCtxs.add(
					ContextBuilder.newBuilder().put("identifiers", processRefs)
			);
		}
		return ContextBuilder.newBuilder()
				.put("processReferenceGroups", referenceGroupCtxs);
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
