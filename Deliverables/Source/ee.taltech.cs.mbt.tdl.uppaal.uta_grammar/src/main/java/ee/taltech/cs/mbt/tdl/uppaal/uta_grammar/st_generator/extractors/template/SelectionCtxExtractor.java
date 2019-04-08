package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.template;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.type.BaseTypeCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Selection;

public class SelectionCtxExtractor implements IContextExtractor<Selection> {
	public static SelectionCtxExtractor getInstance() {
		return INSTANCE;
	}

	private static final SelectionCtxExtractor INSTANCE = new SelectionCtxExtractor();

	private SelectionCtxExtractor() { }

	@Override
	public ContextBuilder extract(Selection inst) {
		ContextBuilder baseTypeCtx = BaseTypeCtxExtractor.getInstance().extract(inst.getSelectType());
		return ContextBuilder.newBuilder()
				.put("baseType", baseTypeCtx)
				.put("variableName", inst.getVariableName().toString());
	}
}
