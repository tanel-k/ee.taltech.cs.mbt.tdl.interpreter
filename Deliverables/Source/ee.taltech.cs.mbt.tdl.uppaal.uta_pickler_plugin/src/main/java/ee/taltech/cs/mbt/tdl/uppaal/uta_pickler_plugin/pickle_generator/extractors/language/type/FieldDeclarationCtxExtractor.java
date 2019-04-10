package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.type;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.misc.BaseTypeExtensionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field.AbsFieldDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field.FieldDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field.FieldDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IFieldDeclarationVisitor;

import java.util.Collection;
import java.util.Set;

public class FieldDeclarationCtxExtractor implements IPicklerContextExtractor<AbsFieldDeclaration>,
		IFieldDeclarationVisitor<ContextBuilder> {
	public static FieldDeclarationCtxExtractor getInstance() {
		return new FieldDeclarationCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet(
			Identifier.class
	);

	private FieldDeclarationCtxExtractor() { }

	@Override
	public ContextBuilder extract(AbsFieldDeclaration decl) {
		requiredClasses.add(decl.getClass());
		return decl.accept(this);
	}

	@Override
	public ContextBuilder visitFieldDeclaration(FieldDeclaration decl) {
		ContextBuilder typeCtx = TypeCtxExtractor.getInstance()
				.extract(decl.getType(), requiredClasses);
		return ContextBuilder.newBuilder("singleFieldDeclaration")
				.put("type", typeCtx)
				.put("identifier", decl.getIdentifier().toString());
	}

	@Override
	public ContextBuilder visitFieldDeclarationGroup(FieldDeclarationGroup decl) {
		ContextBuilder baseTypeCtx = BaseTypeCtxExtractor.getInstance()
				.extract(decl.getBaseType(), requiredClasses);
		Collection<ContextBuilder> subDeclCtxs = BaseTypeExtensionCtxExtractor.getInstance()
				.extract(decl.getBaseTypeExtensionMap().getTypeExtensions(), requiredClasses);
		return ContextBuilder.newBuilder("groupOfFieldDeclarations")
				.put("baseType", baseTypeCtx)
				.put("subDeclarations", subDeclCtxs);
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
