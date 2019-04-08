package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.type;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field.AbsFieldDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field.FieldDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.field.FieldDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IFieldDeclarationVisitor;

import java.util.Set;

public class FieldDeclarationCtxExtractor implements IPicklerContextExtractor<AbsFieldDeclaration>,
		IFieldDeclarationVisitor<ContextBuilder> {
	public static FieldDeclarationCtxExtractor getInstance() {
		return new FieldDeclarationCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private FieldDeclarationCtxExtractor() { }

	@Override
	public ContextBuilder extract(AbsFieldDeclaration decl) {
		return decl.accept(this);
	}

	@Override
	public ContextBuilder visitFieldDeclaration(FieldDeclaration decl) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitFieldDeclarationGroup(FieldDeclarationGroup decl) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
