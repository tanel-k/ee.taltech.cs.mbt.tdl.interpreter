package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.declaration;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.expression.ArgumentSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.identifier.IdentifierDeclarationConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.identifier.IdentifierDeclarationConverter.IdentifierData;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.parameter.ParameterSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.statement.StatementSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.type.BaseTypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.type.TypeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ChannelPriorityDeclarationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ChannelPriorityGroupContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ChannelPrioritySequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ChannelReferenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.DeclarationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.DeclarationOfFunctionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.DeclarationSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.FunctionDeclarationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.IdentifierDeclarationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ParameterSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.StatementBlockContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.StatementSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.TemplateInstantiationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.TypeContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.TypeDeclarationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ValueFunctionDeclarationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.VariableDeclarationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.VariableInitializationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.VoidFunctionDeclarationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.AbsDeclarationStatement;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.FunctionDeclaration;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.TemplateInstantiation;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.ChannelPrioritySequence;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.ChannelReferenceGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.channel_priority.channel_reference.AbsChannelReference;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.type.TypeDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.VariableDeclarationGroup;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.declaration.variable.initializer.AbsVariableInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.identifier.Identifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.BaseSharingTypeMap;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.misc.array_size_modifier.AbsArrayModifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.statement.StatementBlock;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.type.BaseType;
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
	public AbsDeclarationStatement visitVariableDeclaration(VariableDeclarationContext ctx) {
		VariableDeclarationGroup declarationGroup = new VariableDeclarationGroup();
		BaseSharingTypeMap<Identifier> sharedTypeMap = declarationGroup.getBaseSharingTypeMap();

		BaseType baseType = BaseTypeConverter.getInstance().convert(ctx.type());
		sharedTypeMap.setBaseType(baseType);

		for (VariableInitializationContext varInitCtx : ctx.variableInitialization()) {
			IdentifierData identifierData = IdentifierDeclarationConverter.getInstance()
				.convert(varInitCtx.identifierDeclaration());
			Identifier identifier = identifierData.getIdentifier();
			Collection<AbsArrayModifier> arrayModifiers = identifierData.getArrayModifiers();

			sharedTypeMap.getOrCreateConcreteType(identifier);
			sharedTypeMap.getConcreteType(identifier).getArrayModifiers().addAll(arrayModifiers);

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
		BaseSharingTypeMap<Identifier> sharedTypeMap = typeDeclarationGroup.getBaseSharingTypeMap();

		BaseType baseType = BaseTypeConverter.getInstance().convert(ctx.type());
		sharedTypeMap.setBaseType(baseType);

		for (IdentifierDeclarationContext idDeclCtx : ctx.identifierDeclaration()) {
			IdentifierData identifierData = IdentifierDeclarationConverter.getInstance()
					.convert(idDeclCtx);
			Identifier identifier = identifierData.getIdentifier();
			Collection<AbsArrayModifier> arrayModifiers = identifierData.getArrayModifiers();

			sharedTypeMap.getOrCreateConcreteType(identifier);
			sharedTypeMap.getConcreteType(identifier).getArrayModifiers().addAll(arrayModifiers);
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
