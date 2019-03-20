package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing;

import ee.taltech.cs.mbt.tdl.generic.parser.AbsParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.UTAExpressionParserFacade.UTAGuardParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

public class UTAGuardParser extends AbsParser<UTAGuardParserFacade, AbsExpression> {
	@Override
	protected UTAGuardParserFacade constructFacade() {
		return new UTAGuardParserFacade();
	}
}
