package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.type;

import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.misc.BaseTypeExtensionMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.BaseTypeExtensionMap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field.AbsFieldDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field.FieldDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field.FieldDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IFieldDeclarationVisitor;

import java.util.Collection;

public class FieldDeclarationMapper implements IContextMapper<AbsFieldDeclaration>, IFieldDeclarationVisitor<ContextBuilder> {
	public static FieldDeclarationMapper getInstance() {
		return INSTANCE;
	}

	private static final FieldDeclarationMapper INSTANCE = new FieldDeclarationMapper();

	private FieldDeclarationMapper() { }

	@Override
	public ContextBuilder map(AbsFieldDeclaration inst) {
		return inst.accept(this);
	}

	@Override
	public ContextBuilder visitFieldDeclaration(FieldDeclaration decl) {
		ContextBuilder typeCtx = TypeMapper.getInstance().map(decl.getType());
		return ContextBuilder.newBuilder("singleDeclaration")
				.put("name", decl.getIdentifier().toString())
				.put("type", typeCtx);
	}

	@Override
	public ContextBuilder visitFieldDeclarationGroup(FieldDeclarationGroup decl) {
		BaseTypeExtensionMap typeMap = decl.getBaseTypeExtensionMap();

		Collection<ContextBuilder> typeCtxs = BaseTypeExtensionMapper.getInstance().map(typeMap.getTypeExtensions());
		ContextBuilder baseTypeCtxs = BaseTypeMapper.getInstance().map(typeMap.getBaseType());

		return ContextBuilder.newBuilder("multiDeclaration")
				.put("baseType", baseTypeCtxs)
				.put("extendedTypes", typeCtxs);
	}
}
