package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.declaration;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.identifier.IdentifierVariantConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.identifier.IdentifierVariantConverter.IdentifierData;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.identifier.ParameterIdentifierConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.identifier.ParameterIdentifierConverter.ParameterIdentifierData;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.parameters.ParameterListConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.statement.StatementConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.type.TypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.ChannelPriorityDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.ChannelRefList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.channel_priority.channel_reference.AbsChannelRef;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.function.AbsFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.function.ValueFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.function.VoidFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.system.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.type.container.TypeDeclarationList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.container.VariableDeclarationList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.initializer.AbsInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.grouping.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.variable_declaration.ParameterDeclaration;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class DeclarationConverter extends UTALanguageBaseVisitor<AbsDeclarationStatement>
	implements IParseTreeConverter<AbsDeclarationStatement, DeclarationContext>
{
	public static DeclarationConverter getInstance() {
		return INSTANCE;
	}

	private static final DeclarationConverter INSTANCE = new DeclarationConverter();

	private DeclarationConverter() { }

	@Override
	public AbsDeclarationStatement convert(DeclarationContext rootContext) {
		return rootContext.accept(this);
	}

	@Override
	public AbsDeclarationStatement visitPartialTemplateInstantiation(PartialTemplateInstantiationContext ctx)
	{
		TemplateInstantiation templateInstantiation = new TemplateInstantiation();
		injectTemplateInstNames(templateInstantiation, ctx.IDENTIFIER_NAME());
		injectTemplateInstArgs(templateInstantiation, ctx.argumentList());
		templateInstantiation.getParameters().addAll(
			ParameterListConverter.getInstance().convert(ctx.parameterList())
		);
		return templateInstantiation;
	}

	@Override
	public AbsDeclarationStatement visitFullTemplateInstantiation(FullTemplateInstantiationContext ctx)
	{
		TemplateInstantiation templateInstantiation = new TemplateInstantiation();
		injectTemplateInstNames(templateInstantiation, ctx.IDENTIFIER_NAME());
		injectTemplateInstArgs(templateInstantiation, ctx.argumentList());
		return templateInstantiation;
	}

	private void injectTemplateInstNames(TemplateInstantiation templateInstantiation, List<TerminalNode> templateNames) {
		IdentifierName newTemplateName = new IdentifierName();
		newTemplateName.setName(templateNames.get(0).getText());

		IdentifierName sourceTemplateName = new IdentifierName();
		sourceTemplateName.setName(templateNames.get(1).getText());

		templateInstantiation.setNewTemplateName(newTemplateName);
		templateInstantiation.setOriginalTemplateName(sourceTemplateName);
	}

	private void injectTemplateInstArgs(TemplateInstantiation templateInstantiation, ArgumentListContext argumentListContext) {
		if (argumentListContext == null)
			return;
		for (ExpressionContext expressionContext : argumentListContext.expression()) {
			AbsExpression argExpr = ExpressionConverter.getInstance().convert(expressionContext);
			templateInstantiation.getArguments().add(argExpr);
		}
	}

	@Override
	public AbsDeclarationStatement visitFunctionDeclaration(FunctionDeclarationContext ctx) {
		DeclarationOfFunctionContext nestedCtx = ctx.declarationOfFunction();
		return nestedCtx.accept(this);
	}

	@Override
	public AbsDeclarationStatement visitDeclarationOfValueFunction(DeclarationOfValueFunctionContext ctx) {
		ValueFunctionDeclaration<AbsTypeIdentifier> valueFunctionDeclaration = new ValueFunctionDeclaration<>();

		StatementBlock functionBody = new StatementBlock();
		Type<AbsTypeIdentifier> returnType = TypeConverter.getInstance().convert(ctx.type());
		if (ctx.blockOfStatements().statement() != null) {
			for (StatementContext statementCtx : ctx.blockOfStatements().statement()) {
				functionBody.getStatements().add(StatementConverter.getInstance().convert(statementCtx));
			}
		}

		if (ctx.parameterList() != null) {
			populateParameters(valueFunctionDeclaration, ctx.parameterList().parameter());
		}

		IdentifierName functionName = new IdentifierName();
		functionName.setName(ctx.IDENTIFIER_NAME().getText());

		valueFunctionDeclaration.setReturnType(returnType);
		valueFunctionDeclaration.setBody(functionBody);
		valueFunctionDeclaration.setName(functionName);

		return valueFunctionDeclaration;
	}

	@Override
	public AbsDeclarationStatement visitDeclarationOfVoidFunction(DeclarationOfVoidFunctionContext ctx) {
		VoidFunctionDeclaration valueFunctionDeclaration = new VoidFunctionDeclaration();

		StatementBlock functionBody = new StatementBlock();
		if (ctx.blockOfStatements().statement() != null) {
			for (StatementContext statementCtx : ctx.blockOfStatements().statement()) {
				functionBody.getStatements().add(StatementConverter.getInstance().convert(statementCtx));
			}
		}

		if (ctx.parameterList() != null) {
			populateParameters(valueFunctionDeclaration, ctx.parameterList().parameter());
		}

		IdentifierName functionName = new IdentifierName();
		functionName.setName(ctx.IDENTIFIER_NAME().getText());

		valueFunctionDeclaration.setBody(functionBody);
		valueFunctionDeclaration.setName(functionName);

		return valueFunctionDeclaration;
	}

	private void populateParameters(
		AbsFunctionDeclaration functionDeclaration,
		List<ParameterContext> parameterCtxs)
	{
		for (ParameterContext parameterCtx : parameterCtxs) {
			ParameterDeclaration<AbsTypeIdentifier> parameterDeclaration = new ParameterDeclaration<>();
			ParameterIdentifierData parameterIdentifierData = ParameterIdentifierConverter.getInstance()
				.convert(parameterCtx.parameterIdentifier());
			Type<AbsTypeIdentifier> parameterType = TypeConverter.getInstance()
				.convert(parameterCtx.type());
			parameterType.setReferenceType(parameterIdentifierData.isByReference());
			parameterType.getArrayModifiers().addAll(parameterIdentifierData.getArrayModifiers());
			parameterDeclaration.setIdentifierName(parameterIdentifierData.getIdentifierName());
			parameterDeclaration.setType(parameterType);
			functionDeclaration.getParameterDeclarations().add(parameterDeclaration);
		}
	}

	@Override
	public AbsDeclarationStatement visitVariableDeclaration(VariableDeclarationContext ctx) {
		VariableDeclarationList variableDeclarations = new VariableDeclarationList();

		Type<AbsTypeIdentifier> type = TypeConverter.getInstance().convert(ctx.type());
		for (VariableInitializationContext varInitCtx : ctx.variableInitialization()) {
			IdentifierData identifierData = IdentifierVariantConverter.getInstance()
				.convert(varInitCtx.identifierNameVariant());
			Type<AbsTypeIdentifier> typeCpy = type.clone();
			typeCpy.getArrayModifiers().addAll(identifierData.getArrayModifiers());
			VariableDeclaration<AbsTypeIdentifier, AbsInitializer> variableDeclaration = new VariableDeclaration<>();
			variableDeclaration.setType(typeCpy);
			variableDeclaration.setIdentifierName(identifierData.getIdentifierName());
			AbsInitializer initializer = varInitCtx.initializerExpression() != null
				? InitializerExpressionConverter.getInstance()
					.convert(varInitCtx.initializerExpression())
				: null;
			variableDeclaration.setInitializer(initializer);
			variableDeclarations.getDeclarations().add(variableDeclaration);
		}

		AbsDeclarationStatement result = variableDeclarations;
		if (variableDeclarations.getDeclarations().size() == 1)
			result = variableDeclarations.getDeclarations().get(0);

		return result;
	}

	@Override
	public AbsDeclarationStatement visitTypeDeclaration(TypeDeclarationContext ctx) {
		TypeDeclarationList typeDeclarations = new TypeDeclarationList();

		Type<AbsTypeIdentifier> type = TypeConverter.getInstance().convert(ctx.type());
		for (IdentifierNameVariantContext identifierCtx : ctx.identifierNameVariant()) {
			IdentifierData identifierData = IdentifierVariantConverter.getInstance()
				.convert(identifierCtx);
			Type<AbsTypeIdentifier> typeCpy = type.clone();
			typeCpy.getArrayModifiers().addAll(identifierData.getArrayModifiers());
			TypeDeclaration<AbsTypeIdentifier> typeDeclaration = new TypeDeclaration<>();
			typeDeclaration.setIdentifierName(identifierData.getIdentifierName());
			typeDeclaration.setType(typeCpy);
			typeDeclarations.getDeclarations().add(typeDeclaration);
		}

		if (typeDeclarations.getDeclarations().size() == 1)
			return typeDeclarations.getDeclarations().get(0);

		return typeDeclarations;
	}

	@Override
	public AbsDeclarationStatement visitChannelPriorityDeclaration(ChannelPriorityDeclarationContext ctx) {
		ChannelPrioritySpecExpressionContext prioritySpecCtx = ctx.channelPrioritySpecExpression();
		ChannelPriorityDeclaration channelPriorityDeclaration = new ChannelPriorityDeclaration();
		for (ChannelRefListContext refsCtx : prioritySpecCtx.channelRefList()) {
			ChannelRefList channelRefList = new ChannelRefList();
			for (ChannelRefExpressionContext channelRefCtx : refsCtx.channelRefExpression()) {
				AbsChannelRef channelRef = ChannelRefExpressionConverter.getInstance().convert(channelRefCtx);
				channelRefList.getChannelRefs().add(channelRef);
			}
			channelPriorityDeclaration.getPrioritySequence().add(channelRefList);
		}
		return channelPriorityDeclaration;
	}
}
