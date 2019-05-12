package ee.taltech.cs.mbt.tdl.expression.tdl_parser;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.commons.test_utils.junit.junit_utils.TestCase;
import ee.taltech.cs.mbt.tdl.commons.test_utils.junit.junit_utils.TestContext;
import ee.taltech.cs.mbt.tdl.commons.test_utils.junit.junit_utils.XmlTestArgumentsSource;
import ee.taltech.cs.mbt.tdl.commons.test_utils.sexpr.s_expression_parser.SExpressionParser;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestInstance(Lifecycle.PER_CLASS)
public class TdlExpressionParserTests {
	private TdlExpressionParser tdlParser;
	private SExpressionParser sParser;

	@BeforeAll
	public void init() {
		tdlParser = TdlExpressionParser.getInstance();
		sParser = SExpressionParser.getInstance();
	}

	@ParameterizedTest(name = "{2}: `{3}` -> `{4}`")
	@XmlTestArgumentsSource(path = "/TdlExpressionParserCorrectTests.xml")
	public void testParsesCorrectExpressions(
			TestContext testContext,
			TestCase testCase,
			String name,
			String inputString,
			String outputString
	) {
		TdlExpression tdlExpr = null;
		try {
			tdlExpr = tdlParser.parseInput(inputString);
		} catch (ParseException ex) {
			fail("Failed to parse `" + inputString + "`", ex);
		}
		Object actual = testContext.getInputMapper().map(tdlExpr);
		Object expected = testContext.getOutputMapper().map(outputString);
		assertEquals(expected, actual, "hello?");
	}
}
