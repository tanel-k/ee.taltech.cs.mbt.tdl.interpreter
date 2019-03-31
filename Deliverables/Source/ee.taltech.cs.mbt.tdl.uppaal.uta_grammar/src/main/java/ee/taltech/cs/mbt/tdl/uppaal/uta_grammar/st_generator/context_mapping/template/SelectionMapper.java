package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.template;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.type.BaseTypeMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.template.Selection;

public class SelectionMapper implements IContextMapper<Selection> {
	public static SelectionMapper getInstance() {
		return INSTANCE;
	}

	private static final SelectionMapper INSTANCE = new SelectionMapper();

	private SelectionMapper() { }

	@Override
	public ContextBuilder map(Selection inst) {
		ContextBuilder baseTypeCtx = BaseTypeMapper.getInstance().map(inst.getSelectType());
		return ContextBuilder.newBuilder()
				.put("baseType", baseTypeCtx)
				.put("variableName", inst.getVariableName().toString());
	}
}
