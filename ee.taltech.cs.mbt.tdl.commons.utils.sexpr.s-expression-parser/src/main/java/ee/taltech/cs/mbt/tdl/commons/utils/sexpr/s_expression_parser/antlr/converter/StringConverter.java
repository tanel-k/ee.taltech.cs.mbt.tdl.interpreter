package ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_parser.antlr.converter;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_grammar.SExpressionStringUtils;
import ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.DelimitedStringContext;
import ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.NonDelimitedStringContext;
import ee.taltech.cs.mbt.tdl.commons.utils.sexpr.s_expression_grammar.antlr_parser.SExpressionLanguageParser.StringContext;

public class StringConverter extends SExpressionLanguageBaseVisitor<String>
		implements IParseTreeConverter<String, StringContext> {
	private static final StringConverter INSTANCE = new StringConverter();

	public static StringConverter getInstance() {
		return INSTANCE;
	}

	private StringConverter() { }

	@Override
	public String convert(StringContext ctx) {
		return ctx.accept(this);
	}

	@Override
	public String visitDelimitedString(DelimitedStringContext ctx) {
		String delimited = ctx.DELIMITED_STRING().getText();
		return SExpressionStringUtils.unescape(
				SExpressionStringUtils.undelimit(delimited)
		);
	}

	@Override
	public String visitNonDelimitedString(NonDelimitedStringContext ctx) {
		return SExpressionStringUtils.unescape(ctx.NON_DELIMITED_STRING().toString());
	}
}
