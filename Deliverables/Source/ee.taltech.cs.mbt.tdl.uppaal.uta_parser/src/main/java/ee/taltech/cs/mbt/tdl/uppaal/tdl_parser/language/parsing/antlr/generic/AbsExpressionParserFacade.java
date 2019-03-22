package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.generic;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.converter.common.expression.ExpressionConverter;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.AbsUtaAntlrParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_grammar.antlr_parser.UTALanguageParser.ExpressionContext;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

public abstract class AbsExpressionParserFacade extends AbsUtaAntlrParserFacade<AbsExpression, ExpressionContext> {
	@Override
	protected ExpressionConverter getConverter() {
		return new ExpressionConverter();
	}
}
