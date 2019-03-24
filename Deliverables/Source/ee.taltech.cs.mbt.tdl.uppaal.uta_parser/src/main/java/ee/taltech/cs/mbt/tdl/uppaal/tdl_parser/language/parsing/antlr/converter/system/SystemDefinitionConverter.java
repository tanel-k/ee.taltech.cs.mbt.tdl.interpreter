package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.declaration.DeclarationConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.*;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.SystemDefinition;

public class SystemDefinitionConverter extends UtaLanguageBaseVisitor<SystemDefinition>
	implements IParseTreeConverter<SystemDefinition, UtaSystemDefinitionContext>
{
	public static SystemDefinitionConverter getInstance() {
		return INSTANCE;
	}

	private static final SystemDefinitionConverter INSTANCE = new SystemDefinitionConverter();

	private SystemDefinitionConverter() { }

	@Override
	public SystemDefinition convert(UtaSystemDefinitionContext rootContext) {
		SystemDefinition systemDefinition = new SystemDefinition();
		injectSystemDeclarations(systemDefinition, rootContext.systemDeclarationSequence());
		injectSystemLine(systemDefinition, rootContext.systemLine());
		injectProgressMeasure(systemDefinition, rootContext.progressMeasureDeclaration());
		return systemDefinition;
	}

	private void injectSystemDeclarations(SystemDefinition systemDefinition, SystemDeclarationSequenceContext declCtx) {
		if (declCtx == null)
			return;
		for (SystemDeclarationStatementContext stmtCtx : declCtx.systemDeclarationStatement()) {
			DeclarationContext declarationCtx = stmtCtx.declaration();
			systemDefinition.getDeclarations().add(
				DeclarationConverter.getInstance().convert(declarationCtx)
			);
		}
	}

	private void injectSystemLine(SystemDefinition systemDefinition, SystemLineContext systemLineCtx) {
		if (systemLineCtx == null)
			return;
		systemDefinition.setSystemLine(
			SystemLineConverter.getInstance().convert(systemLineCtx)
		);
	}

	private void injectProgressMeasure(SystemDefinition systemDefinition, ProgressMeasureDeclarationContext measureDeclCtx) {
		if (measureDeclCtx == null)
			return;
		for (ExpressionContext exprCtx : measureDeclCtx.expression()) {
			systemDefinition.getProgressMeasureExpressions().add(
				ExpressionConverter.getInstance().convert(exprCtx)
			);
		}
	}
}
