package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.declaration.DeclarationConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.SystemDefinition;

public class SystemDefinitionConverter extends UTALanguageBaseVisitor<SystemDefinition>
	implements IParseTreeConverter<SystemDefinition, UtaSystemDefinitionContext>
{
	@Override
	public SystemDefinition convert(UtaSystemDefinitionContext rootContext) {
		SystemDefinition systemDefinition = new SystemDefinition();
		injectSystemDeclarations(systemDefinition, rootContext.systemDeclarationSequence());
		injectSystemLine(systemDefinition, rootContext.systemLine());
		injectProgressMeasure(systemDefinition, rootContext.progressMeasureDeclaration());
		return systemDefinition;
	}

	private void injectSystemDeclarations(
		SystemDefinition systemDefinition,
		SystemDeclarationSequenceContext systemDeclCtx)
	{
		if (systemDeclCtx == null)
			return;
		for (SystemDeclarationStatementContext stmtCtx : systemDeclCtx.systemDeclarationStatement()) {
			DeclarationContext declarationCtx = stmtCtx.declaration();
			systemDefinition.getDeclarations().add(
				new DeclarationConverter().convert(declarationCtx)
			);
		}
	}

	private void injectSystemLine(
		SystemDefinition systemDefinition,
		SystemLineContext systemLineCtx)
	{
		if (systemLineCtx == null)
			return;
		systemDefinition.setSystemLine(
			new SystemLineConverter().convert(systemLineCtx)
		);
	}

	private void injectProgressMeasure(
		SystemDefinition systemDefinition,
		ProgressMeasureDeclarationContext progressMeasureDeclarationContext)
	{
		if (progressMeasureDeclarationContext == null)
			return;
		for (ExpressionContext exprCtx : progressMeasureDeclarationContext.expression()) {
			systemDefinition.getProgressMeasureExpressions().add(
				new ExpressionConverter().convert(exprCtx)
			);
		}
	}
}
