package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.declaration;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.expression.ArgumentSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.identifier.IdentifierDeclarationConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.identifier.IdentifierDeclarationConverter.IdentifierData;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.parameter.ParameterSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.statement.StatementSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.type.BaseTypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.FunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.ChannelPrioritySequence;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.ChannelReferenceGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.channel_priority.channel_reference.AbsChannelReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.type.TypeDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.VariableDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.declaration.variable.initializer.AbsVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.BaseTypeExtensionMap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.misc.array_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.statement.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.type.BaseType;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Collection;

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
		TemplateInstantiation templateInstantiation = new TemplateInstantiation()
				.setNewTemplateName(Identifier.of(ctx.IDENTIFIER_NAME(0).getText()))
				.setSourceTemplateName(Identifier.of(ctx.IDENTIFIER_NAME(1).getText()));

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
			function.setValueType(BaseTypeConverter.getInstance().convert(typeCtx));
		}

		Identifier functionName = Identifier.of(nameCtx.getText());
		function.setName(functionName);

		StatementBlock functionBody = new StatementBlock();
		if (stmtCtx != null) {
			DeclarationSequenceContext declSeqCtx = stmtCtx.declarationSequence();
			StatementSequenceContext stmtSeqCtx = stmtCtx.statementSequence();

			if (declSeqCtx != null) {
				functionBody.getDeclarations()
						.addAll(DeclarationSequenceConverter.getInstance().convert(declSeqCtx));
			}

			if (stmtSeqCtx != null) {
				functionBody.getStatements()
						.addAll(StatementSequenceConverter.getInstance().convert(stmtSeqCtx));
			}
		}
		function.setStatementBlock(functionBody);

		if (paramCtx != null) {
			function.getParameters().addAll(
					ParameterSequenceConverter.getInstance().convert(paramCtx)
			);
		}

		return function;
	}

	@Override
	public AbsDeclarationStatement visitVariableDeclaration(VariableDeclarationContext ctx) {
		VariableDeclarationGroup declarationGroup = new VariableDeclarationGroup();
		BaseTypeExtensionMap sharedTypeMap = declarationGroup.getBaseTypeExtensionMap();

		BaseType baseType = BaseTypeConverter.getInstance().convert(ctx.type());
		sharedTypeMap.setBaseType(baseType);

		for (VariableInitializationContext varInitCtx : ctx.variableInitialization()) {
			IdentifierData identifierData = IdentifierDeclarationConverter.getInstance()
				.convert(varInitCtx.identifierDeclaration());
			Identifier identifier = identifierData.getIdentifier();
			Collection<AbsArrayModifier> arrayModifiers = identifierData.getArrayModifiers();

			sharedTypeMap.getOrCreateType(identifier);
			sharedTypeMap.getType(identifier).getArrayModifiers().addAll(arrayModifiers);

			AbsVariableInitializer initializer = varInitCtx.initializerExpression() != null
				? InitializerExpressionConverter.getInstance()
					.convert(varInitCtx.initializerExpression())
				: null;

			declarationGroup.getInitializerMap().put(identifier, initializer);
		}

		return declarationGroup.reduceToOnlyEntryIfApplicable();
	}

	@Override
	public AbsDeclarationStatement visitTypeDeclaration(TypeDeclarationContext ctx) {
		TypeDeclarationGroup typeDeclarationGroup = new TypeDeclarationGroup();
		BaseTypeExtensionMap sharedTypeMap = typeDeclarationGroup.getBaseTypeExtensionMap();

		BaseType baseType = BaseTypeConverter.getInstance().convert(ctx.type());
		sharedTypeMap.setBaseType(baseType);

		for (IdentifierDeclarationContext idDeclCtx : ctx.identifierDeclaration()) {
			IdentifierData identifierData = IdentifierDeclarationConverter.getInstance()
					.convert(idDeclCtx);
			Identifier identifier = identifierData.getIdentifier();
			Collection<AbsArrayModifier> arrayModifiers = identifierData.getArrayModifiers();

			sharedTypeMap.getOrCreateType(identifier);
			sharedTypeMap.getType(identifier).getArrayModifiers().addAll(arrayModifiers);
		}

		return typeDeclarationGroup.reduceToOnlyEntryIfApplicable();
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
