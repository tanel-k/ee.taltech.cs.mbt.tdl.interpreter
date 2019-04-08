package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.template;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Selection;

import java.util.Set;

public class SelectionCtxExtractor implements IPicklerContextExtractor<Selection> {
	public static SelectionCtxExtractor getInstance() {
		return new SelectionCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private SelectionCtxExtractor() { }

	@Override
	public ContextBuilder extract(Selection selection) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
