package ee.taltech.cs.mbt.tdl.expression.tdl_parser;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.ExpressionTree;
import ee.taltech.cs.mbt.tdl.expression.tdl_parser.antlr.TdlParserFacade;
import ee.taltech.cs.mbt.tdl.generic.antlr_facade.AbsAntlrParserFacade;
import ee.taltech.cs.mbt.tdl.generic.parser.AbsAntlrParser;

public class ExpressionParser extends AbsAntlrParser<ExpressionTree> {
	@Override
	public AbsAntlrParserFacade<ExpressionTree, ?, ?> getFacade() {
		return new TdlParserFacade();
	}
}
