package ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.declaration;

import ee.taltech.cs.mbt.tdl.commons.st_utils.context_mapping.ContextBuilder;
import ee.taltech.cs.mbt.tdl.commons.utils.collections.CollectionUtils;
import ee.taltech.cs.mbt.tdl.commons.utils.strings.StringUtils;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.IPicklerContextExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.expression.ExpressionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.misc.BaseTypeExtensionCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.parameter.ParameterCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.statement.StatementCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.type.BaseTypeCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_pickler_plugin.pickle_generator.extractors.language.type.TypeCtxExtractor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.FunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.ChannelPrioritySequence;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.ChannelReferenceGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.type.TypeDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer.AbsVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.BaseTypeExtensionMap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.BaseTypeExtensionMap.BaseTypeExtension;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.visitors.IDeclarationVisitor;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
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
		requiredClasses.add(decl.getClass());
		return decl.accept(this);
	}

	@Override
	public ContextBuilder visitVariableDeclaration(VariableDeclaration decl) {
		requiredClasses.add(Identifier.class);
		ContextBuilder typeCtx = TypeCtxExtractor.getInstance()
				.extract(decl.getType(), requiredClasses);
		String variableName = decl.getIdentifier().toString();
		ContextBuilder initializerCtx = decl.getInitializer() != null
				? InitializerCtxExtractor.getInstance().extract(decl.getInitializer(), requiredClasses)
				: null;
		return ContextBuilder.newBuilder("variableDeclaration")
				.put("singleVariableDeclaration", true)
				.put("name", variableName)
				.put("type", typeCtx)
				.put("variableName", variableName)
				.put("initializer", initializerCtx);
	}

	@Override
	public ContextBuilder visitTypeDeclaration(TypeDeclaration decl) {
		requiredClasses.add(Identifier.class);
		String typeName = decl.getIdentifier().toString();
		ContextBuilder typeCtx = TypeCtxExtractor.getInstance()
				.extract(decl.getType(), requiredClasses);
		return ContextBuilder.newBuilder("typeDeclaration")
				.put("singleTypeDeclaration", true)
				.put("name", typeName)
				.put("type", typeCtx)
				.put("typeName", typeName)
		;
	}

	@Override
	public ContextBuilder visitChannelPriorityDeclaration(ChannelPrioritySequence decl) {
		requiredClasses.add(ChannelReferenceGroup.class);
		Collection<ContextBuilder> groupContexts = new LinkedList<>();

		for (ChannelReferenceGroup referenceGroup : decl.getPrioritySequence()) {
			Collection<ContextBuilder> referenceCtxs = ChannelReferenceCtxExtractor.getInstance()
					.extract(referenceGroup.getChannelReferences(), requiredClasses);
			ContextBuilder groupCtx = ContextBuilder.newBuilder()
					.put("channelReferences", referenceCtxs);
			groupContexts.add(groupCtx);
		}

		// Name does not have to be unique:
		// "A channel priority declaration can be inserted anywhere in the global declarations section of a system (only one per system)."
		return ContextBuilder.newBuilder("channelPriorityDeclaration")
				.put("name", "channelPriorityDeclaration")
				.put("channelReferenceGroups", groupContexts);
	}

	@Override
	public ContextBuilder visitTemplateInstantiation(TemplateInstantiation decl) {
		requiredClasses.add(Identifier.class);
		String newTemplateName = decl.getNewTemplateName().toString();
		String sourceTemplateName = decl.getSourceTemplateName().toString();
		Collection<ContextBuilder> paramCtxs = ParameterCtxExtractor.getInstance()
				.extract(decl.getParameters(), requiredClasses);
		Collection<ContextBuilder> argCtxs = ExpressionCtxExtractor.getInstance()
				.extract(decl.getArguments(), requiredClasses);
		return ContextBuilder.newBuilder("templateInstantiation")
				.put("name", newTemplateName)
				.put("newTemplateName", newTemplateName)
				.put("sourceTemplateName", sourceTemplateName)
				.put("parameters", paramCtxs)
				.put("arguments", argCtxs);
	}

	@Override
	public ContextBuilder visitFunctionDeclaration(FunctionDeclaration decl) {
		requiredClasses.add(Identifier.class);
		ContextBuilder valueTypeCtx = decl.getValueType() != null
				? BaseTypeCtxExtractor.getInstance().extract(decl.getValueType(), requiredClasses)
				: null;
		String functionName = decl.getName().toString();
		Collection<ContextBuilder> paramCtxs = ParameterCtxExtractor.getInstance()
				.extract(decl.getParameters(), requiredClasses);
		ContextBuilder stmtCtx = StatementCtxExtractor.getInstance()
				.extract(decl.getStatementBlock(), requiredClasses);
		return ContextBuilder.newBuilder("functionDeclaration")
				.put("name", functionName)
				.put("functionName", functionName)
				.put("valueType", valueTypeCtx)
				.put("parameters", paramCtxs)
				.put("statementBlock", stmtCtx);
	}

	@Override
	public ContextBuilder visitVariableDeclarationGroup(VariableDeclarationGroup decl) {
		requiredClasses.add(Identifier.class);
		BaseTypeExtensionMap typeMap = decl.getBaseTypeExtensionMap();
		ContextBuilder typeCtx = BaseTypeCtxExtractor.getInstance()
				.extract(decl.getBaseType(), requiredClasses);

		String aggregatedName = "";
		List<ContextBuilder> subDeclCtxs = new LinkedList<>();
		for (BaseTypeExtension subType : typeMap.collectionView()) {
			String variableName = subType.getIdentifier().toString();
			AbsVariableInitializer initializer = decl.getInitializerMap()
					.get(subType.getIdentifier());
			ContextBuilder initCtx = initializer != null
					? InitializerCtxExtractor.getInstance().extract(initializer, requiredClasses)
					: null;
			ContextBuilder subTypeCtx = BaseTypeExtensionCtxExtractor.getInstance()
					.extract(subType, requiredClasses)
					.put("variableName", variableName)
					.put("initializer", initCtx);
			if (StringUtils.isEmpty(aggregatedName)) {
				aggregatedName = variableName;
			} else {
				aggregatedName += "_and_" + variableName;
			}
			subDeclCtxs.add(subTypeCtx);
		}

		return ContextBuilder.newBuilder("variableDeclaration")
				.put("multiVariableDeclaration", true)
				.put("name", aggregatedName)
				.put("baseType", typeCtx)
				.put("subDeclarations", subDeclCtxs);
	}

	@Override
	public ContextBuilder visitTypeDeclarationGroup(TypeDeclarationGroup decl) {
		requiredClasses.add(Identifier.class);
		BaseTypeExtensionMap typeMap = decl.getBaseTypeExtensionMap();
		ContextBuilder typeCtx = BaseTypeCtxExtractor.getInstance()
				.extract(typeMap.getBaseType(), requiredClasses);

		String aggregatedName = "";
		List<ContextBuilder> subDeclCtxs = new LinkedList<>();
		for (BaseTypeExtension subType : typeMap.collectionView()) {
			String typeName = subType.getIdentifier().toString();
			ContextBuilder subTypeCtx = BaseTypeExtensionCtxExtractor.getInstance()
					.extract(subType, requiredClasses);
			subDeclCtxs.add(subTypeCtx);
			if (StringUtils.isEmpty(aggregatedName)) {
				aggregatedName = typeName;
			} else {
				aggregatedName += "_and_" + typeName;
			}
		}

		return ContextBuilder.newBuilder("typeDeclaration")
				.put("multiTypeDeclaration", true)
				.put("name", aggregatedName)
				.put("baseType", typeCtx)
				.put("subDeclarations", subDeclCtxs);
	}

	@Override
	public Set<Class> getRequiredClasses() {
		return requiredClasses;
	}
}
