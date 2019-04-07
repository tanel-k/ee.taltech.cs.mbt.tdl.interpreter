package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.template;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language.antlr.converter.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ExpressionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ExpressionSequenceContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language_model.expression.generic.AbsExpression;

import java.util.LinkedList;
import java.util.List;

public class AssignmentsConverter extends UtaLanguageBaseVisitor<List<AbsExpression>>
		implements IParseTreeConverter<List<AbsExpression>, ExpressionSequenceContext> {
	public static AssignmentsConverter getInstance() {
		return INSTANCE;
	}

	private static final AssignmentsConverter INSTANCE = new AssignmentsConverter();

	private AssignmentsConverter() { }

	@Override
	public List<AbsExpression> convert(ExpressionSequenceContext ctx) {
		List<AbsExpression> assignments = new LinkedList<>();

		for (ExpressionContext exprCtx : ctx.expression()) {
			assignments.add(ExpressionConverter.getInstance().convert(exprCtx));
		}

		return assignments;
	}
}

