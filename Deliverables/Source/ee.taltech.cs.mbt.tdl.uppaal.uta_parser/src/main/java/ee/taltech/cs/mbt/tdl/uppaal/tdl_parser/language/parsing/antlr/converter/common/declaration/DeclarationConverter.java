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
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.ChannelPrioritySequence;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.ChannelReferenceGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.AbsChannelReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.function.AbsFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.function.ValueFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.function.VoidFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.type.container.TypeDeclarationList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.container.VariableDeclarationList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer.AbsVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.AbsTypeId;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.parameter.ParameterDeclaration;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class DeclarationConverter extends UtaLanguageBaseVisitor<AbsDeclarationStatement>
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
		Identifier newTemplateName = new Identifier();
		newTemplateName.setName(templateNames.get(0).getText());

		Identifier sourceTemplateName = new Identifier();
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
		ValueFunctionDeclaration<AbsTypeId> valueFunctionDeclaration = new ValueFunctionDeclaration<>();

		StatementBlock functionBody = new StatementBlock();
		Type<AbsTypeId> returnType = TypeConverter.getInstance().convert(ctx.type());
		if (ctx.blockOfStatements().statement() != null) {
			for (StatementContext statementCtx : ctx.blockOfStatements().statement()) {
				functionBody.getStatements().add(StatementConverter.getInstance().convert(statementCtx));
			}
		}

		if (ctx.parameterList() != null) {
			populateParameters(valueFunctionDeclaration, ctx.parameterList().parameter());
		}

		Identifier functionName = new Identifier();
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

		Identifier functionName = new Identifier();
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
			ParameterDeclaration<AbsTypeId> parameterDeclaration = new ParameterDeclaration<>();
			ParameterIdentifierData parameterIdentifierData = ParameterIdentifierConverter.getInstance()
				.convert(parameterCtx.parameterIdentifier());
			Type<AbsTypeId> parameterType = TypeConverter.getInstance()
				.convert(parameterCtx.type());
			parameterType.setReferenceType(parameterIdentifierData.isByReference());
			parameterType.getArrayModifiers().addAll(parameterIdentifierData.getArrayModifiers());
			parameterDeclaration.setIdentifier(parameterIdentifierData.getIdentifier());
			parameterDeclaration.setType(parameterType);
			functionDeclaration.getParameterDeclarations().add(parameterDeclaration);
		}
	}

	@Override
	public AbsDeclarationStatement visitVariableDeclaration(VariableDeclarationContext ctx) {
		VariableDeclarationList variableDeclarations = new VariableDeclarationList();

		Type<AbsTypeId> type = TypeConverter.getInstance().convert(ctx.type());
		for (VariableInitializationContext varInitCtx : ctx.variableInitialization()) {
			IdentifierData identifierData = IdentifierVariantConverter.getInstance()
				.convert(varInitCtx.identifierNameVariant());
			Type<AbsTypeId> typeCpy = type.clone();
			typeCpy.getArrayModifiers().addAll(identifierData.getArrayModifiers());
			VariableDeclaration<AbsTypeId, AbsVariableInitializer> variableDeclaration = new VariableDeclaration<>();
			variableDeclaration.setType(typeCpy);
			variableDeclaration.setIdentifier(identifierData.getIdentifier());
			AbsVariableInitializer initializer = varInitCtx.initializerExpression() != null
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

		Type<AbsTypeId> type = TypeConverter.getInstance().convert(ctx.type());
		for (IdentifierNameVariantContext identifierCtx : ctx.identifierNameVariant()) {
			IdentifierData identifierData = IdentifierVariantConverter.getInstance()
				.convert(identifierCtx);
			Type<AbsTypeId> typeCpy = type.clone();
			typeCpy.getArrayModifiers().addAll(identifierData.getArrayModifiers());
			TypeDeclaration<AbsTypeId> typeDeclaration = new TypeDeclaration<>();
			typeDeclaration.setIdentifier(identifierData.getIdentifier());
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
		ChannelPrioritySequence channelPrioritySequence = new ChannelPrioritySequence();
		for (ChannelRefListContext refsCtx : prioritySpecCtx.channelRefList()) {
			ChannelReferenceGroup channelRefList = new ChannelReferenceGroup();
			for (ChannelRefExpressionContext channelRefCtx : refsCtx.channelRefExpression()) {
				AbsChannelReference channelRef = ChannelRefExpressionConverter.getInstance().convert(channelRefCtx);
				channelRefList.getChannelReferences().add(channelRef);
			}
			channelPrioritySequence.getPrioritySequence().add(channelRefList);
		}
		return channelPrioritySequence;
	}
}
