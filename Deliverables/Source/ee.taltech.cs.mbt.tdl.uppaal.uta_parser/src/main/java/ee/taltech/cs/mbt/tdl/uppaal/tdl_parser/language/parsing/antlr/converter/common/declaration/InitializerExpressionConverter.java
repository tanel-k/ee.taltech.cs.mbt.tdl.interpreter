package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.declaration;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.FlatInitializerContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.InitializerExpressionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.StructuredInitializerContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.initializer.AbsInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.initializer.FlatInitializer;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.variable.initializer.StructuredInitializer;

public class InitializerExpressionConverter extends UtaLanguageBaseVisitor<AbsInitializer>
	implements IParseTreeConverter<AbsInitializer, InitializerExpressionContext>
{
	public static InitializerExpressionConverter getInstance() {
		return INSTANCE;
	}

	private static final InitializerExpressionConverter INSTANCE = new InitializerExpressionConverter();

	private InitializerExpressionConverter() { }

	@Override
	public AbsInitializer convert(InitializerExpressionContext rootContext) {
		return rootContext.accept(this);
	}

	@Override
	public AbsInitializer visitFlatInitializer(FlatInitializerContext ctx) {
		FlatInitializer flatInitializer = new FlatInitializer();
		flatInitializer.setExpression(
			ExpressionConverter.getInstance().convert(ctx.expression())
		);
		return flatInitializer;
	}

	@Override
	public AbsInitializer visitStructuredInitializer(StructuredInitializerContext ctx) {
		StructuredInitializer structuredInitializer = new StructuredInitializer();
		for (InitializerExpressionContext initExprCtx : ctx.initializerExpression()) {
			structuredInitializer.getInitializers().add(
				initExprCtx.accept(this)
			);
		}
		return structuredInitializer;
	}
}
