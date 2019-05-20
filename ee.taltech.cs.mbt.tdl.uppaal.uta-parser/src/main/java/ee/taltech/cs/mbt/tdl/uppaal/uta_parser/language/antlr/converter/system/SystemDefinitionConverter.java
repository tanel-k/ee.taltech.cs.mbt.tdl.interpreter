package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.system;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.DeclarationSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ExpressionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ProgressMeasureDeclarationContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SystemDefinitionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.SystemLineContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.system.SystemDefinition;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.declaration.DeclarationSequenceConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.expression.ExpressionConverter;

public class SystemDefinitionConverter extends UtaLanguageBaseVisitor<SystemDefinition>
		implements IParseTreeConverter<SystemDefinition, SystemDefinitionContext> {
	public static SystemDefinitionConverter getInstance() {
		return INSTANCE;
	}

	private static final SystemDefinitionConverter INSTANCE = new SystemDefinitionConverter();

	private SystemDefinitionConverter() { }

	@Override
	public SystemDefinition convert(SystemDefinitionContext rootContext) {
		SystemDefinition systemDefinition = new SystemDefinition();
		injectSystemDeclarations(systemDefinition, rootContext.declarationSequence());
		injectSystemLine(systemDefinition, rootContext.systemLine());
		injectProgressMeasure(systemDefinition, rootContext.progressMeasureDeclaration());
		return systemDefinition;
	}

	private void injectSystemDeclarations(SystemDefinition systemDefinition, DeclarationSequenceContext ctx) {
		if (ctx == null)
			return;

		systemDefinition.getDeclarations().addAll(DeclarationSequenceConverter.getInstance().convert(ctx));
	}

	private void injectSystemLine(SystemDefinition systemDefinition, SystemLineContext ctx) {
		if (ctx == null)
			return;

		systemDefinition.setSystemLine(
			SystemLineConverter.getInstance().convert(ctx)
		);
	}

	private void injectProgressMeasure(SystemDefinition systemDefinition, ProgressMeasureDeclarationContext ctx) {
		if (ctx == null)
			return;

		for (ExpressionContext exprCtx : ctx.expression()) {
			systemDefinition.getProgressMeasureExpressions().add(
				ExpressionConverter.getInstance().convert(exprCtx)
			);
		}
	}
}
