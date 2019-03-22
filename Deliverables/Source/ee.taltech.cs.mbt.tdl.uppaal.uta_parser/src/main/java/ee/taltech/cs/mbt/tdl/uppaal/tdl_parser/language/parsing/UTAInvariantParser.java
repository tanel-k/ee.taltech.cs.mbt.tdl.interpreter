package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing;

import ee.taltech.cs.mbt.tdl.generic.parser.AbsParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.AbsExpressionParserFacade.AbsInvariantParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

public class UTAInvariantParser extends AbsParser<AbsInvariantParserFacade, AbsExpression> {
	@Override
	protected AbsInvariantParserFacade constructFacade() {
		return new AbsInvariantParserFacade();
	}
}
