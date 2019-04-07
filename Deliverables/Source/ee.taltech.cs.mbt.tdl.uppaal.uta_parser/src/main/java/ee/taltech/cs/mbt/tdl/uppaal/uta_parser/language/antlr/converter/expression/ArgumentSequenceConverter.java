package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.expression;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ArgumentSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ExpressionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;

import java.util.LinkedList;
import java.util.List;

public class ArgumentSequenceConverter extends UtaLanguageBaseVisitor<List<AbsExpression>>
		implements IParseTreeConverter<List<AbsExpression>, ArgumentSequenceContext> {
	public static ArgumentSequenceConverter getInstance() {
		return INSTANCE;
	}

	private static final ArgumentSequenceConverter INSTANCE = new ArgumentSequenceConverter();

	private ArgumentSequenceConverter() { }

	@Override
	public List<AbsExpression> convert(ArgumentSequenceContext ctx) {
		List<AbsExpression> arguments = new LinkedList<>();
		for (ExpressionContext exprCtx : ctx.expression())
			arguments.add(ExpressionConverter.getInstance().convert(exprCtx));
		return arguments;
	}
}
