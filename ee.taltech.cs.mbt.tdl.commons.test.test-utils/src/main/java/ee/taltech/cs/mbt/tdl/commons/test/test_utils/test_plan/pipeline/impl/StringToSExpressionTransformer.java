package ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.impl;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_parser.SExpressionParser;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;

import java.io.IOException;

public class StringToSExpressionTransformer implements ISimpleTransformer {
	@Override
	public Object transform(Object in) {
		try {
			return SExpressionParser.getInstance()
					.parseInput((String) in);
		} catch (ParseException ex) {
			throw new RuntimeException(ex);
		}
	}
}
