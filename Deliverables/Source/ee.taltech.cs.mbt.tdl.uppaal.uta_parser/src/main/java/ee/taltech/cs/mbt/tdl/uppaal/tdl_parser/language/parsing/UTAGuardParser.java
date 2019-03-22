package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing;

import ee.taltech.cs.mbt.tdl.generic.parser.AbsParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.AbsExpressionParserFacade.AbsGuardParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

public class UTAGuardParser extends AbsParser<AbsGuardParserFacade, AbsExpression> {
	@Override
	protected AbsGuardParserFacade constructFacade() {
		return new AbsGuardParserFacade();
	}
}
