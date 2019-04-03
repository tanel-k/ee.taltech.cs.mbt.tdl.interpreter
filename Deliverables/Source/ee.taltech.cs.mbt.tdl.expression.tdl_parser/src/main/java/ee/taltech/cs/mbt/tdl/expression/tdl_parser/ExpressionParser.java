package ee.taltech.cs.mbt.tdl.expression.tdl_parser;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.AbsAntlrParserFacade;
import ee.taltech.cs.mbt.tdl.commons.parser.AbsAntlrParser;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.ExpressionTree;
import ee.taltech.cs.mbt.tdl.expression.tdl_parser.antlr.TdlParserFacade;

public class ExpressionParser extends AbsAntlrParser<ExpressionTree> {
	@Override
	public AbsAntlrParserFacade<ExpressionTree, ?, ?> getFacade() {
		return new TdlParserFacade();
	}
}
