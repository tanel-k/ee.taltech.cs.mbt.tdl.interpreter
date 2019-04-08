package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.declaration;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.FunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.ChannelPrioritySequence;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.type.TypeDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IDeclarationVisitor;

import java.util.Set;

public class DeclarationCtxExtractor implements IPicklerContextExtractor<AbsDeclarationStatement>,
		IDeclarationVisitor<ContextBuilder> {
	public static DeclarationCtxExtractor getInstance() {
		return new DeclarationCtxExtractor();
	}

	private Set<Class> requiredClasses = CollectionUtils.newSet();

	private DeclarationCtxExtractor() { }

	@Override
	public ContextBuilder extract(AbsDeclarationStatement decl) {
		return decl.accept(this);
	}

	@Override
	public ContextBuilder visitVariableDeclaration(VariableDeclaration decl) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitTypeDeclaration(TypeDeclaration decl) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitChannelPriorityDeclaration(ChannelPrioritySequence decl) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitTemplateInstantiation(TemplateInstantiation decl) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitFunctionDeclaration(FunctionDeclaration decl) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitVariableDeclarationGroup(VariableDeclarationGroup decl) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ContextBuilder visitTypeDeclarationGroup(TypeDeclarationGroup decl) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
