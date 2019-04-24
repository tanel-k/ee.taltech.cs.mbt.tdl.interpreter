package ee.taltech.cs.mbt.tdl.expression.tdl_parser;

import ee.taltech.cs.mbt.tdl.commons.antlr_facade.AbsAntlrParserFacade;
import ee.taltech.cs.mbt.tdl.commons.parser.AbsAntlrParser;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import ee.taltech.cs.mbt.tdl.expression.tdl_parser.antlr.TdlParserFacade;

public class TdlExpressionParser extends AbsAntlrParser<TdlExpression> {
	public static TdlExpressionParser getInstance() {
		return new TdlExpressionParser();
	}

	private TdlExpressionParser() { }

	@Override
	public AbsAntlrParserFacade<TdlExpression, ?, ?, ?> getFacade() {
		return new TdlParserFacade();
	}
}
