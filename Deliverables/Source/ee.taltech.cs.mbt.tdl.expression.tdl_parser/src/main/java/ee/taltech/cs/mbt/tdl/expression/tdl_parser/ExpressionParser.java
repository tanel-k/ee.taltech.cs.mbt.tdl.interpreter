package ee.taltech.cs.mbt.tdl.expression.tdl_parser;

import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.concrete.ExpressionTree;
import ee.taltech.cs.mbt.tdl.expression.tdl_parser.antlr.TDLParserFacade;
import ee.taltech.cs.mbt.tdl.generic.parser.AbsParser;

public class ExpressionParser extends AbsParser<TDLParserFacade, ExpressionTree> {
	@Override
	protected TDLParserFacade constructFacade() {
		return new TDLParserFacade();
	}
}
