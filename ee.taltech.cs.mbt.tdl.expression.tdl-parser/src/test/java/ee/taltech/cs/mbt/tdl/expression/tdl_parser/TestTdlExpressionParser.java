package ee.taltech.cs.mbt.tdl.expression.tdl_parser;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.generator.GenerationException;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_grammar.st_generator.SExpressionGenerator;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_grammar.st_generator.SExpressionGeneratorFactory;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.SExpression;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.junit.XmlTestArgumentsSource;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.model.TestPlan;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("TDL parser tests.")
class TestTdlExpressionParser {
	private final SExpressionGenerator sExprGen = SExpressionGeneratorFactory
			.getInstance()
			.getExpressionGenerator();

	private TdlExpressionParser tdlParser;

	@BeforeEach
	void prepareForTest() {
		tdlParser = TdlExpressionParser
				.getInstance();
	}

	@DisplayName("Test whether TDL parser accepts syntactically correct expressions.")
	@ParameterizedTest(name = "#[{index}] {1}: TDL:`{2}` -> S-Expr:`{3}`.")
	@XmlTestArgumentsSource(path = "/TdlExpressionParserValidSyntaxTests.xml")
	void testParsesSyntacticallyCorrectExpressions(
			TestPlan testPlan,
			String name,
			String input,
			String expectation
	) {
		// In the future, should consider supporting parallel test execution.
		testPlan.getInputTransformer().getConfigurableTransformers().get(0).setTransformFunction(str -> {
			TdlExpression expr = null;
			try {
				expr = tdlParser.parseInput(input);
			} catch (ParseException ex) {
				fail("Unable to parse `" + input + "`.", ex);
			}
			return expr;
		});

		SExpression actual = (SExpression) testPlan.getInputTransformer().transform(input);
		SExpression expected = (SExpression) testPlan.getOutputTransformer().transform(expectation);
		assertEquals(expected, actual, getMsgSupplier(name, expected, actual));
	}

	private Supplier<String> getMsgSupplier(String name, SExpression expected, SExpression actual) {
		return () -> {
			String expectedStr;
			try {
				expectedStr = sExprGen.generate(expected);
			} catch (GenerationException ex) {
				expectedStr = "ERROR";
			}
			String actualStr;
			try {
				actualStr = sExprGen.generate(actual);
			} catch (GenerationException e) {
				actualStr = "ERROR";
			}
			return "Test: " + name
					+ "\nExpected S-expression: `" + expectedStr
					+ "`.\nActual S-expression: `" + actualStr + "`.\n";
		};
	}
}
