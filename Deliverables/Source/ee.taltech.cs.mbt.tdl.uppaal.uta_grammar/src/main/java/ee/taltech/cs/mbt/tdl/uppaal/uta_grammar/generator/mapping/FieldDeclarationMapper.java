package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.mapping;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.generator.ContextBuilder;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field.FieldDeclaration;

public class FieldDeclarationMapper implements IContextMapper<FieldDeclaration> {
	public static FieldDeclarationMapper getInstance() {
		return INSTANCE;
	}

	private static final FieldDeclarationMapper INSTANCE = new FieldDeclarationMapper();

	private FieldDeclarationMapper() { }

	@Override
	public ContextBuilder map(FieldDeclaration field) {
		Type<?> fieldType = field.getType();
		Identifier fieldIdentifier = field.getIdentifier();
		return ContextBuilder.newBuilder()
				.put("type", TypeMapper.getInstance().map(fieldType))
				.put("identifierValue", fieldIdentifier.getText())
				.put("arraySizeModifiers", ArraySizeModifierMapper.getInstance().mapCollection(fieldType.getArrayModifiers()));
	}
}
