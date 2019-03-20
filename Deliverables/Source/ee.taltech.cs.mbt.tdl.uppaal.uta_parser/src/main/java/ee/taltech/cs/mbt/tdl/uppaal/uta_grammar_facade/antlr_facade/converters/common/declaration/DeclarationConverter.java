package ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.common.declaration;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParameterList;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParseTreeConverter.ParseTreeStructureException;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.common.identifier.IdentifierVariantConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.common.identifier.IdentifierVariantConverter.IdentifierData;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.common.identifier.ParameterIdentifierConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.common.identifier.ParameterIdentifierConverter.ParameterIdentifierData;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.common.parameters.ParameterListConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.common.statement.StatementConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar_facade.antlr_facade.converters.common.type.TypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.identifier.IdentifierName;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.ChannelPriorityDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.ChannelRefs;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.channel_priority.channel_reference.AbsChannelRef;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.function.AbsFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.function.ValueFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.function.VoidFunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.system.process.PartialTemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.system.process.ProcessVariableAssignment;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.type.TypeDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.type.container.TypeDeclarationList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable.VariableDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable.container.VariableDeclarationList;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.declaration.variable.initializer.AbsInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.statement.grouping.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.variable_declaration.ParameterDeclaration;
import org.antlr.v4.runtime.tree.ErrorNode;

import java.util.List;

public class DeclarationConverter extends UTALanguageBaseVisitor<AbsDeclarationStatement>
	implements IParseTreeConverter<AbsDeclarationStatement, DeclarationContext>
{
	@Override
	public AbsDeclarationStatement convert(DeclarationContext rootContext) throws ParseTreeStructureException {
		return rootContext.accept(this);
	}

	@Override
	public AbsDeclarationStatement visitErrorNode(ErrorNode node) {
		throw new ParseTreeStructureException(
			"Declaration subtree contains an error node (" + node.getText() + ")."
		);
	}

	@Override
	public AbsDeclarationStatement visitProcessVarPartialTemplateInstantiation(
		ProcessVarPartialTemplateInstantiationContext ctx)
	{
		IdentifierName newTemplateName = new IdentifierName();
		newTemplateName.setName(ctx.IDENTIFIER_NAME(0).getText());

		IdentifierName sourceTemplate = new IdentifierName();
		sourceTemplate.setName(ctx.IDENTIFIER_NAME(1).getText());

		PartialTemplateInstantiation partialTemplateInstantiation = new PartialTemplateInstantiation();
		partialTemplateInstantiation.setProcessName(newTemplateName);
		partialTemplateInstantiation.setTemplateName(sourceTemplate);

		partialTemplateInstantiation.getRemainingParameters().addAll(
			new ParameterListConverter().convert(ctx.parameterList())
		);

		ArgumentListContext argumentListCtx = ctx.argumentList();
		for (ExpressionContext expressionContext : argumentListCtx.expression()) {
			AbsExpression argExpr = new ExpressionConverter().convert(expressionContext);
			partialTemplateInstantiation.getArgumentList().add(argExpr);
		}

		return partialTemplateInstantiation;
	}

	@Override
	public AbsDeclarationStatement visitProcessVarFullTemplateInstantiation(
		ProcessVarFullTemplateInstantiationContext ctx)
	{
		IdentifierName processName = new IdentifierName();
		processName.setName(ctx.IDENTIFIER_NAME(0).getText());

		IdentifierName sourceTemplate = new IdentifierName();
		sourceTemplate.setName(ctx.IDENTIFIER_NAME(1).getText());

		ProcessVariableAssignment processVariableAssignment = new ProcessVariableAssignment();
		processVariableAssignment.setProcessName(processName);
		processVariableAssignment.setTemplateName(sourceTemplate);

		ArgumentListContext argumentListCtx = ctx.argumentList();
		for (ExpressionContext expressionContext : argumentListCtx.expression()) {
			AbsExpression argExpr = new ExpressionConverter().convert(expressionContext);
			processVariableAssignment.getArgumentList().add(argExpr);
		}

		return processVariableAssignment;
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
		Type<AbsTypeIdentifier> returnType = new TypeConverter().convert(ctx.type());
		if (ctx.blockOfStatements().statement() != null) {
			for (StatementContext statementCtx : ctx.blockOfStatements().statement()) {
				functionBody.getStatements().add(new StatementConverter().convert(statementCtx));
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
				functionBody.getStatements().add(new StatementConverter().convert(statementCtx));
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
			ParameterIdentifierData parameterIdentifierData = new ParameterIdentifierConverter()
				.convert(parameterCtx.parameterIdentifier());
			Type<AbsTypeIdentifier> parameterType = new TypeConverter()
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

		Type<AbsTypeIdentifier> type = new TypeConverter().convert(ctx.type());
		for (VariableInitializationContext varInitCtx : ctx.variableInitialization()) {
			IdentifierData identifierData = new IdentifierVariantConverter()
				.convert(varInitCtx.identifierNameVariant());
			Type<AbsTypeIdentifier> typeCpy = type.clone();
			typeCpy.getArrayModifiers().addAll(identifierData.getArrayModifiers());
			VariableDeclaration<AbsTypeIdentifier, AbsInitializer> variableDeclaration = new VariableDeclaration<>();
			variableDeclaration.setType(typeCpy);
			AbsInitializer initializer = varInitCtx.initializerExpression() != null
				? new InitializerExpressionConverter()
					.convert(varInitCtx.initializerExpression())
				: null;
			variableDeclaration.setInitializer(initializer);
			variableDeclarations.getDeclarations().add(variableDeclaration);
		}

		return variableDeclarations.getDeclarations().size() > 1
			? variableDeclarations
			: variableDeclarations.getDeclarations().iterator().next();
	}

	@Override
	public AbsDeclarationStatement visitTypeDeclaration(TypeDeclarationContext ctx) {
		TypeDeclarationList typeDeclarations = new TypeDeclarationList();

		Type<AbsTypeIdentifier> type = new TypeConverter().convert(ctx.type());
		for (IdentifierNameVariantContext identifierCtx : ctx.identifierNameVariant()) {
			IdentifierData identifierData = new IdentifierVariantConverter()
				.convert(identifierCtx);
			Type<AbsTypeIdentifier> typeCpy = type.clone();
			typeCpy.getArrayModifiers().addAll(identifierData.getArrayModifiers());
			TypeDeclaration<AbsTypeIdentifier> typeDeclaration = new TypeDeclaration<>();
			typeDeclaration.setIdentifierName(identifierData.getIdentifierName());
			typeDeclaration.setType(typeCpy);
			typeDeclarations.getDeclarations().add(typeDeclaration);
		}

		return typeDeclarations;
	}

	@Override
	public AbsDeclarationStatement visitChannelPriorityDeclaration(ChannelPriorityDeclarationContext ctx) {
		ChannelPrioritySpecExpressionContext prioritySpecCtx = ctx.channelPrioritySpecExpression();
		ChannelPriorityDeclaration channelPriorityDeclaration = new ChannelPriorityDeclaration();
		for (ChannelRefListContext refsCtx : prioritySpecCtx.channelRefList()) {
			ChannelRefs channelRefs = new ChannelRefs();
			for (ChannelRefExpressionContext channelRefCtx : refsCtx.channelRefExpression()) {
				AbsChannelRef channelRef = new ChannelRefExpressionConverter().convert(channelRefCtx);
				channelRefs.getChannelRefs().add(channelRef);
			}
			channelPriorityDeclaration.getPrioritySequence().add(channelRefs);
		}
		return channelPriorityDeclaration;
	}
}
