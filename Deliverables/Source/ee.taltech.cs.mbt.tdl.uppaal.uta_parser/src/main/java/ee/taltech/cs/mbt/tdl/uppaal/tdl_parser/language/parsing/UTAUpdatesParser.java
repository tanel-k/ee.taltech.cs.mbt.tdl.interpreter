package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing;

import ee.taltech.cs.mbt.tdl.generic.parser.AbsParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.UTAUpdatesParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.expression.generic.AbsExpression;

import java.util.List;

public class UTAUpdatesParser extends AbsParser<UTAUpdatesParserFacade, List<AbsExpression>> {
	@Override
	protected UTAUpdatesParserFacade constructFacade() {
		return new UTAUpdatesParserFacade();
	}
}
