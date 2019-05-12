package ee.taltech.cs.mbt.tdl.uppaal.uta_parser.language;

import ee.taltech.cs.mbt.tdl.commons.facades.antlr_facade.AbsAntlrParserFacade.ParseException;
import ee.taltech.cs.mbt.tdl.commons.facades.st_utils.generator.GenerationException;
import ee.taltech.cs.mbt.tdl.commons.parser.AbsAntlrParser;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_grammar.st_generator.SExpressionGenerator;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_grammar.st_generator.SExpressionGeneratorFactory;
import ee.taltech.cs.mbt.tdl.commons.test.sexpr.s_expression_model.SExpression;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.junit.XmlTestArgumentsSource;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.model.TestPlan;
import ee.taltech.cs.mbt.tdl.uppaal.uta_model.language.expression.generic.AbsExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class UtaLanguageParserTests {
	private final SExpressionGenerator exprGen = SExpressionGeneratorFactory
			.getInstance()
			.getExpressionGenerator();

	@DisplayName("Test whether UTA parser accepts syntactically correct assignment expressions.")
	@ParameterizedTest(name = "#[{index}] {1}: UTA:`{2}` -> SExpr:`{3}`.")
	@XmlTestArgumentsSource(path = "/language/AssignmentTests.xml")
	void testParsesSyntacticallyCorrectAssignments(
			TestPlan testPlan,
			String name,
			String input,
			String expectation
	) {
		AbsAntlrParser<List<AbsExpression>> assignmentsParser = UtaLanguageParserFactory.newInstance().assignmentsParser();
		// In the future, should consider supporting parallel test execution.
		testPlan.getInputTransformer().getConfigurableTransformers().get(0).setTransformFunction(str -> {
			List<AbsExpression> assignments = null;
			try {
				assignments = assignmentsParser.parseInput(input);
			} catch (ParseException ex) {
				fail("Unable to parse `" + input + "`.", ex);
			}
			return assignments;
		});

		SExpression actual = (SExpression) testPlan.getInputTransformer().transform(input);
		SExpression expected = (SExpression) testPlan.getOutputTransformer().transform(expectation);
		assertEquals(expected, actual, getMsgSupplier(name, expected, actual));
	}

	private Supplier<String> getMsgSupplier(String name, SExpression expected, SExpression actual) {
		return () -> {
			String expectedStr;
			try {
				expectedStr = exprGen.generate(expected);
			} catch (GenerationException ex) {
				expectedStr = "ERROR";
			}
			String actualStr;
			try {
				actualStr = exprGen.generate(actual);
			} catch (GenerationException e) {
				actualStr = "ERROR";
			}
			return "Test: " + name
					+ "\nExpected S-expression: `" + expectedStr
					+ "`.\nActual S-expression: `" + actualStr + "`.\n";
		};
	}
}
