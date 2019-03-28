package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.declaration;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.expression.ArgumentSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.identifier.IdentifierDeclarationConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.identifier.IdentifierDeclarationConverter.IdentifierData;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.parameter.ParameterListConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.parameter.ParameterSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.statement.StatementSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.type.TypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.FunctionDeclaration;
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
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.Type;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.identifier.AbsTypeId;
import org.antlr.v4.runtime.tree.TerminalNode;

public class DeclarationConverter extends UtaLanguageBaseVisitor<AbsDeclarationStatement>
		implements IParseTreeConverter<AbsDeclarationStatement, DeclarationContext> {
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
	public AbsDeclarationStatement visitTemplateInstantiation(TemplateInstantiationContext ctx) {
		TemplateInstantiation templateInstantiation = new TemplateInstantiation();

		Identifier newName = new Identifier();
		newName.setText(ctx.IDENTIFIER_NAME(0).getText());

		Identifier sourceName = new Identifier();
		sourceName.setText(ctx.IDENTIFIER_NAME(1).getText());

		templateInstantiation.setNewTemplateName(newName);
		templateInstantiation.setSourceTemplateName(sourceName);

		if (ctx.argumentSequence() != null) {
			templateInstantiation.getArguments().addAll(
					ArgumentSequenceConverter.getInstance().convert(ctx.argumentSequence())
			);
		}

		if (ctx.parameterSequence() != null) {
			templateInstantiation.getParameters().addAll(
					ParameterSequenceConverter.getInstance().convert(ctx.parameterSequence())
			);
		}

		return templateInstantiation;
	}

	@Override
	public AbsDeclarationStatement visitFunctionDeclaration(FunctionDeclarationContext ctx) {
		DeclarationOfFunctionContext nestedCtx = ctx.declarationOfFunction();
		return nestedCtx.accept(this);
	}

	@Override
	public AbsDeclarationStatement visitValueFunctionDeclaration(ValueFunctionDeclarationContext ctx) {
		return newFunctionInstance(ctx.type(), ctx.IDENTIFIER_NAME(), ctx.parameterSequence(), ctx.statementBlock());
	}

	@Override
	public AbsDeclarationStatement visitVoidFunctionDeclaration(VoidFunctionDeclarationContext ctx) {
		return newFunctionInstance(null, ctx.IDENTIFIER_NAME(), ctx.parameterSequence(), ctx.statementBlock());
	}

	private AbsDeclarationStatement newFunctionInstance(
		TypeContext typeCtx,
		TerminalNode nameCtx,
		ParameterSequenceContext paramCtx,
		StatementBlockContext stmtCtx
	) {
		FunctionDeclaration function = new FunctionDeclaration();

		if (typeCtx != null) {
			function.setValueType(TypeConverter.getInstance().convert(typeCtx));
		}

		Identifier functionName = new Identifier();
		functionName.setText(nameCtx.getText());
		function.setName(functionName);

		StatementBlock functionBody = new StatementBlock();
		if (stmtCtx != null) {
			DeclarationSequenceContext declSeqCtx = stmtCtx.declarationSequence();
			StatementSequenceContext stmtSeqCtx = stmtCtx.statementSequence();

			functionBody.getDeclarations().addAll(DeclarationSequenceConverter.getInstance().convert(declSeqCtx));
			functionBody.getStatements().addAll(StatementSequenceConverter.getInstance().convert(stmtSeqCtx));
		}

		if (paramCtx != null) {
			function.getParameterDeclarations().addAll(
					ParameterSequenceConverter.getInstance().convert(paramCtx)
			);
		}

		return function;
	}

	@Override
	public AbsDeclarationStatement visitVariableDeclaration(VariableDeclarationContext ctx) { // FIXME!
		VariableDeclarationList variableDeclarations = new VariableDeclarationList();

		// Add a wrapper to the model?
		for (VariableInitializationContext varInitCtx : ctx.variableInitialization()) {
			IdentifierData identifierData = IdentifierDeclarationConverter.getInstance()
				.convert(varInitCtx.identifierNameVariant());
			Type<AbsTypeId> typeCpy = TypeConverter.getInstance().convert(ctx.type());
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
	public AbsDeclarationStatement visitTypeDeclaration(TypeDeclarationContext ctx) { // FIXME!
		TypeDeclarationList typeDeclarations = new TypeDeclarationList();

		// Add a wrapper to the model?
		Type<AbsTypeId> type = TypeConverter.getInstance().convert(ctx.type());
		for (IdentifierNameVariantContext identifierCtx : ctx.identifierNameVariant()) {
			IdentifierData identifierData = IdentifierDeclarationConverter.getInstance()
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
		ChannelPrioritySequenceContext seqCtx = ctx.channelPrioritySequence();
		ChannelPrioritySequence channelPrioritySequence = new ChannelPrioritySequence();

		for (ChannelPriorityGroupContext groupCtx : seqCtx.channelPriorityGroup()) {
			ChannelReferenceGroup channelRefList = new ChannelReferenceGroup();
			for (ChannelReferenceContext refCtx : groupCtx.channelReference()) {
				AbsChannelReference channelRef = ChannelReferenceConverter.getInstance().convert(refCtx);
				channelRefList.getChannelReferences().add(channelRef);
			}
			channelPrioritySequence.getPrioritySequence().add(channelRefList);
		}

		return channelPrioritySequence;
	}
}
