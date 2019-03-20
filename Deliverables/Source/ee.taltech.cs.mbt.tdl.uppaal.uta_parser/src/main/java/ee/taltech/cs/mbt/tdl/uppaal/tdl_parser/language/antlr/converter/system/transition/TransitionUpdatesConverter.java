package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr.converter.system.transition;

import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade.ParseTreeStructureException;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.converter.IParseTreeConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageBaseVisitor;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.ExpressionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.UtaTransitionUpdateListContext;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

import java.util.LinkedList;
import java.util.List;

public class TransitionUpdatesConverter extends UTALanguageBaseVisitor<List<AbsExpression>>
		implements IParseTreeConverter<List<AbsExpression>, UtaTransitionUpdateListContext> {
	@Override
	public List<AbsExpression> convert(UtaTransitionUpdateListContext rootContext) throws ParseTreeStructureException {
		List<AbsExpression> updateExpressions = new LinkedList<>();
		for (ExpressionContext exprCtx : rootContext.expression()) {
			updateExpressions.add(new ExpressionConverter().convert(exprCtx));
		}
		return updateExpressions;
	}
}

