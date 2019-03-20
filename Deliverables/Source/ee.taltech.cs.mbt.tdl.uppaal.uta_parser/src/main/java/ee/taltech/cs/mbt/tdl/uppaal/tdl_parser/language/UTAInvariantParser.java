package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language;

import ee.taltech.cs.mbt.tdl.generic.parser.AbsParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr.UTAExpressionParserFacade.UTAInvariantParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

public class UTAInvariantParser extends AbsParser<UTAInvariantParserFacade, AbsExpression> {
	@Override
	protected UTAInvariantParserFacade constructFacade() {
		return new UTAInvariantParserFacade();
	}
}
