package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.type;

import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.misc.BaseTypeExtensionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.BaseTypeExtensionMap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.field.AbsFieldDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.field.FieldDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.identifier.field.FieldDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IFieldDeclarationVisitor;

import java.util.Collection;

public class FieldDeclarationCtxExtractor implements IContextExtractor<AbsFieldDeclaration>, IFieldDeclarationVisitor<ContextBuilder> {
	public static FieldDeclarationCtxExtractor getInstance() {
		return INSTANCE;
	}

	private static final FieldDeclarationCtxExtractor INSTANCE = new FieldDeclarationCtxExtractor();

	private FieldDeclarationCtxExtractor() { }

	@Override
	public ContextBuilder extract(AbsFieldDeclaration inst) {
		return inst.accept(this);
	}

	@Override
	public ContextBuilder visitFieldDeclaration(FieldDeclaration decl) {
		ContextBuilder typeCtx = TypeCtxExtractor.getInstance().extract(decl.getType());
		return ContextBuilder.newBuilder("singleDeclaration")
				.put("name", decl.getIdentifier().toString())
				.put("type", typeCtx);
	}

	@Override
	public ContextBuilder visitFieldDeclarationGroup(FieldDeclarationGroup decl) {
		BaseTypeExtensionMap typeMap = decl.getBaseTypeExtensionMap();

		Collection<ContextBuilder> typeCtxs = BaseTypeExtensionCtxExtractor.getInstance().extract(typeMap.collectionView());
		ContextBuilder baseTypeCtxs = BaseTypeCtxExtractor.getInstance().extract(typeMap.getBaseType());

		return ContextBuilder.newBuilder("multiDeclaration")
				.put("baseType", baseTypeCtxs)
				.put("extendedTypes", typeCtxs);
	}
}
