package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language;

import ee.taltech.cs.mbt.tdl.generic.parser.AbsParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.antlr.UTADeclarationsParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.declaration.AbsDeclarationStatement;

import java.util.List;

public class UTADeclarationsParser extends AbsParser<UTADeclarationsParserFacade, List<AbsDeclarationStatement>> {
	@Override
	protected UTADeclarationsParserFacade constructFacade() {
		return new UTADeclarationsParserFacade();
	}
}
