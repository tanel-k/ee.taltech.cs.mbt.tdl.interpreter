package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.declaration;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.expression.ExpressionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.misc.BaseTypeExtensionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.parameter.ParameterCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.statement.StatementCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.type.BaseTypeCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.extractors.type.TypeCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.FunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.ChannelPrioritySequence;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.ChannelReferenceGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.type.TypeDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.VariableDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.initializer.AbsVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.BaseTypeExtensionMap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.BaseTypeExtensionMap.BaseTypeExtension;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.visitors.IDeclarationVisitor;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DeclarationCtxExtractor implements IContextExtractor<AbsDeclarationStatement>, IDeclarationVisitor<ContextBuilder> {
	public static DeclarationCtxExtractor getInstance() {
		return INSTANCE;
	}

	private static final DeclarationCtxExtractor INSTANCE = new DeclarationCtxExtractor();

	private DeclarationCtxExtractor() { }

	@Override
	public ContextBuilder extract(AbsDeclarationStatement inst) {
		return inst.accept(this);
	}

	@Override
	public ContextBuilder visitChannelPriorityDeclaration(ChannelPrioritySequence decl) {
		Collection<ContextBuilder> groupContexts = new LinkedList<>();

		for (ChannelReferenceGroup referenceGroup : decl.getPrioritySequence()) {
			Collection<ContextBuilder> referenceCtxs = ChannelReferenceCtxExtractor.getInstance()
					.extract(referenceGroup.getChannelReferences());
			ContextBuilder groupCtx = ContextBuilder.newBuilder()
					.put("channelReferences", referenceCtxs);
			groupContexts.add(groupCtx);
		}

		return ContextBuilder.newBuilder("channelPriorityDeclaration")
				.put("channelReferenceGroups", groupContexts);
	}

	@Override
	public ContextBuilder visitTemplateInstantiation(TemplateInstantiation decl) {
		Collection<ContextBuilder> argumentCtxs = ExpressionCtxExtractor.getInstance().extract(decl.getArguments());
		Collection<ContextBuilder> parameterCtxs = ParameterCtxExtractor.getInstance().extract(decl.getParameters());
		return ContextBuilder.newBuilder("templateInstantiation")
				.put("newTemplateName", decl.getNewTemplateName().toString())
				.put("sourceTemplateName", decl.getSourceTemplateName().toString())
				.put("arguments", argumentCtxs)
				.put("parameters", parameterCtxs);
	}

	@Override
	public ContextBuilder visitFunctionDeclaration(FunctionDeclaration decl) {
		ContextBuilder typeCtx = decl.getValueType() != null
				? BaseTypeCtxExtractor.getInstance().extract(decl.getValueType())
				: null;
		Collection<ContextBuilder> parameterCtxs = ParameterCtxExtractor.getInstance().extract(decl.getParameters());
		ContextBuilder statementBlockCtx = StatementCtxExtractor.getInstance().extract(decl.getStatementBlock());
		return ContextBuilder.newBuilder("functionDeclaration")
				.put("valueType", typeCtx)
				.put("identifierValue", decl.getName().toString())
				.put("parameters", parameterCtxs)
				.put("statementBlock", statementBlockCtx);
	}

	@Override
	public ContextBuilder visitVariableDeclaration(VariableDeclaration decl) {
		ContextBuilder typeCtx = TypeCtxExtractor.getInstance().extract(decl.getType());
		ContextBuilder initCtx = decl.getInitializer() != null
				? InitializerCtxExtractor.getInstance().extract(decl.getInitializer())
				: null;
		return ContextBuilder.newBuilder("variableDeclaration")
				.put("singleVariableDeclaration", true)
				.put("type", typeCtx)
				.put("identifierValue", decl.getIdentifier().toString())
				.put("initializer", initCtx);
	}

	@Override
	public ContextBuilder visitVariableDeclarationGroup(VariableDeclarationGroup decl) {
		BaseTypeExtensionMap typeMap = decl.getBaseTypeExtensionMap();
		ContextBuilder baseTypeCtx = BaseTypeCtxExtractor.getInstance().extract(typeMap.getBaseType());

		List<ContextBuilder> subDeclCtxs = new LinkedList<>();
		for (BaseTypeExtension subType : typeMap.collectionView()) {
			AbsVariableInitializer initializer = decl.getInitializerMap().get(subType.getIdentifier());
			ContextBuilder initCtx = initializer != null
					? InitializerCtxExtractor.getInstance().extract(initializer)
					: null;
			ContextBuilder subTypeCtx = BaseTypeExtensionCtxExtractor.getInstance().extract(subType)
					.put("initializer", initCtx);
			subDeclCtxs.add(subTypeCtx);
		}

		return ContextBuilder.newBuilder("variableDeclaration")
				.put("multiVariableDeclaration", true)
				.put("baseType", baseTypeCtx)
				.put("subDeclarations", subDeclCtxs);
	}

	@Override
	public ContextBuilder visitTypeDeclaration(TypeDeclaration decl) {
		ContextBuilder typeCtx = TypeCtxExtractor.getInstance().extract(decl.getType());
		return ContextBuilder.newBuilder("typeDeclaration")
				.put("singleTypeDeclaration", true)
				.put("type", typeCtx)
				.put("identifierValue", decl.getIdentifier().toString());
	}

	@Override
	public ContextBuilder visitTypeDeclarationGroup(TypeDeclarationGroup decl) {
		BaseTypeExtensionMap typeMap = decl.getBaseTypeExtensionMap();
		ContextBuilder baseTypeCtx = BaseTypeCtxExtractor.getInstance().extract(typeMap.getBaseType());

		List<ContextBuilder> subDeclCtxs = new LinkedList<>();
		for (BaseTypeExtension subType : typeMap.collectionView()) {
			ContextBuilder subTypeCtx = BaseTypeExtensionCtxExtractor.getInstance().extract(subType);
			subDeclCtxs.add(subTypeCtx);
		}

		return ContextBuilder.newBuilder("typeDeclaration")
				.put("multiTypeDeclaration", true)
				.put("baseType", baseTypeCtx)
				.put("subDeclarations", subDeclCtxs);
	}
}
