package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing;

import ee.taltech.cs.mbt.tdl.generic.parser.AbsParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.UTADeclarationsParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.AbsDeclarationStatement;

import java.util.List;

public class UTADeclarationsParser extends AbsParser<UTADeclarationsParserFacade, List<AbsDeclarationStatement>> {
	@Override
	protected UTADeclarationsParserFacade constructFacade() {
		return new UTADeclarationsParserFacade();
	}
}
