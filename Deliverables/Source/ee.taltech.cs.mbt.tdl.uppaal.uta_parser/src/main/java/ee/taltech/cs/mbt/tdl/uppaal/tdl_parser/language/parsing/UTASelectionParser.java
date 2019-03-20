package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing;

import ee.taltech.cs.mbt.tdl.generic.parser.AbsParser;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.language.parsing.antlr.UTASelectionParserFacade;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.base.type.type_identifier.AbsTypeIdentifier;
import ee.taltech.cs.mbt.tdl.uppaal.uta_system_model.language.system.selection.Selection;

import java.util.List;

public class UTASelectionParser extends AbsParser<UTASelectionParserFacade, List<Selection<AbsTypeIdentifier>>> {
	@Override
	protected UTASelectionParserFacade constructFacade() {
		return new UTASelectionParserFacade();
	}
}
