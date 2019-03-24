package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.system.transition;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.ExpressionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UtaLanguageParser.UtaTransitionUpdateListContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

import java.util.LinkedList;
import java.util.List;

public class AssignmentsConverter extends UtaLanguageBaseVisitor<List<AbsExpression>>
		implements IParseTreeConverter<List<AbsExpression>, UtaTransitionUpdateListContext>
{
	public static AssignmentsConverter getInstance() {
		return INSTANCE;
	}

	private static final AssignmentsConverter INSTANCE = new AssignmentsConverter();

	private AssignmentsConverter() { }

	@Override
	public List<AbsExpression> convert(UtaTransitionUpdateListContext rootContext) {
		List<AbsExpression> updateExpressions = new LinkedList<>();
		for (ExpressionContext exprCtx : rootContext.expression()) {
			updateExpressions.add(ExpressionConverter.getInstance().convert(exprCtx));
		}
		return updateExpressions;
	}
}

