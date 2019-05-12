package ee.taltech.cs.mbt.tdl.expression.tdl_parser;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.commons.test_utils.junit.junit_utils.Mapper;
import ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_parser.SExpressionParser;

public class StringToSExprMapper implements Mapper {
	@Override
	public Object map(Object in) {
		if (!(in instanceof String))
			throw new IllegalArgumentException(
					"Expected String, received " + in.getClass().getSimpleName() + "."
			);
		try {
			return SExpressionParser.getInstance()
					.parseInput((String) in);
		} catch (ParseException ex) {
			throw new RuntimeException(ex);
		}
	}
}
