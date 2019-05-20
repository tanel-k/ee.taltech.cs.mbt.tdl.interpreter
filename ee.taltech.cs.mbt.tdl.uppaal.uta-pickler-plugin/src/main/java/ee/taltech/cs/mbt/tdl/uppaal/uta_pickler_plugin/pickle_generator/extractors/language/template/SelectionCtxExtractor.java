package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.template;

import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.template.Selection;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.type.BaseTypeCtxExtractor;

import java.util.Set;

public class SelectionCtxExtractor implements IPicklerContextExtractor<Selection> {
	public static SelectionCtxExtractor getInstance() {
		return new SelectionCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet(
			Selection.class,
			Identifier.class
	);

	private SelectionCtxExtractor() { }

	@Override
	public ContextBuilder extract(Selection selection) {
		ContextBuilder selectTypeCtx = BaseTypeCtxExtractor.getInstance()
				.extract(selection.getSelectType(), requiredClasses);
		return ContextBuilder.newBuilder()
				.put("selectType", selectTypeCtx)
				.put("variableName", selection.getVariableName().toString());
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
