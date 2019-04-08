package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.declaration;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.IContextMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.expression.ExpressionMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.parameter.ParameterMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.statement.StatementMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.type.BaseTypeMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.st_generator.context_mapping.type.TypeMapper;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.FunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.ChannelPrioritySequence;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.ChannelReferenceGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.type.TypeDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.BaseTypeExtensionMap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.BaseTypeExtensionMap.BaseTypeExtension;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IDeclarationVisitor;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DeclarationMapper implements IContextMapper<AbsDeclarationStatement>, IDeclarationVisitor<ContextBuilder> {
	public static DeclarationMapper getInstance() {
		return INSTANCE;
	}

	private static final DeclarationMapper INSTANCE = new DeclarationMapper();

	private DeclarationMapper() { }

	@Override
	public ContextBuilder map(AbsDeclarationStatement inst) {
		return inst.accept(this);
	}

	@Override
	public ContextBuilder visitChannelPriorityDeclaration(ChannelPrioritySequence decl) {
		Collection<ContextBuilder> groupContexts = new LinkedList<>();

		for (ChannelReferenceGroup referenceGroup : decl.getPrioritySequence()) {
			Collection<ContextBuilder> referenceCtxs = ChannelReferenceMapper.getInstance()
					.map(referenceGroup.getChannelReferences());
			ContextBuilder groupCtx = ContextBuilder.newBuilder()
					.put("channelReferences", referenceCtxs);
			groupContexts.add(groupCtx);
		}

		return ContextBuilder.newBuilder("channelPriorityDeclaration")
				.put("channelReferenceGroups", groupContexts);
	}

	@Override
	public ContextBuilder visitTemplateInstantiation(TemplateInstantiation decl) {
		Collection<ContextBuilder> argumentCtxs = ExpressionMapper.getInstance().map(decl.getArguments());
		Collection<ContextBuilder> parameterCtxs = ParameterMapper.getInstance().map(decl.getParameters());
		return ContextBuilder.newBuilder("templateInstantiation")
				.put("newTemplateName", decl.getNewTemplateName().toString())
				.put("sourceTemplateName", decl.getSourceTemplateName().toString())
				.put("arguments", argumentCtxs)
				.put("parameters", parameterCtxs);
	}

	@Override
	public ContextBuilder visitFunctionDeclaration(FunctionDeclaration decl) {
		ContextBuilder typeCtx = decl.getValueType() != null
				? BaseTypeMapper.getInstance().map(decl.getValueType())
				: null;
		Collection<ContextBuilder> parameterCtxs = ParameterMapper.getInstance().map(decl.getParameters());
		ContextBuilder statementBlockCtx = StatementMapper.getInstance().map(decl.getStatementBlock());
		return ContextBuilder.newBuilder("functionDeclaration")
				.put("valueType", typeCtx)
				.put("identifierValue", decl.getName().toString())
				.put("parameters", parameterCtxs)
				.put("statementBlock", statementBlockCtx);
	}

	@Override
	public ContextBuilder visitVariableDeclaration(VariableDeclaration decl) {
		ContextBuilder typeCtx = TypeMapper.getInstance().map(decl.getType());
		ContextBuilder initCtx = decl.getInitializer() != null
				? InitializerMapper.getInstance().map(decl.getInitializer())
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
		ContextBuilder baseTypeCtx = BaseTypeMapper.getInstance().map(typeMap.getBaseType());

		List<ContextBuilder> subDeclCtxs = new LinkedList<>();
		for (BaseTypeExtension subType : typeMap.getTypeExtensions()) {
			ContextBuilder subTypeCtx = TypeMapper.getInstance().map(subType)
					.put("identifierValue", subType.getIdentifier().toString())
					.put("initializer", decl.getInitializerMap().get(subType.getIdentifier()));
			subDeclCtxs.add(subTypeCtx);
		}

		return ContextBuilder.newBuilder("variableDeclaration")
				.put("multiVariableDeclaration", true)
				.put("baseType", baseTypeCtx)
				.put("subDeclarations", subDeclCtxs);
	}

	@Override
	public ContextBuilder visitTypeDeclaration(TypeDeclaration decl) {
		ContextBuilder typeCtx = TypeMapper.getInstance().map(decl.getType());
		return ContextBuilder.newBuilder("typeDeclaration")
				.put("singleTypeDeclaration", true)
				.put("type", typeCtx)
				.put("identifierValue", decl.getIdentifier().toString());
	}

	@Override
	public ContextBuilder visitTypeDeclarationGroup(TypeDeclarationGroup decl) {
		BaseTypeExtensionMap typeMap = decl.getBaseTypeExtensionMap();
		ContextBuilder baseTypeCtx = BaseTypeMapper.getInstance().map(typeMap.getBaseType());

		List<ContextBuilder> subDeclCtxs = new LinkedList<>();
		for (BaseTypeExtension subType : typeMap.getTypeExtensions()) {
			ContextBuilder subTypeCtx = TypeMapper.getInstance().map(subType)
					.put("identifierValue", subType.getIdentifier());
			subDeclCtxs.add(subTypeCtx);
		}

		return ContextBuilder.newBuilder("typeDeclaration")
				.put("multiTypeDeclaration", true)
				.put("baseType", baseTypeCtx)
				.put("subDeclarations", subDeclCtxs);
	}
}
