package ee.taltech.cs.mbt.tdl.expression.tdl_grammar.st_generator;

import ee.taltech.cs.mbt.tdl.commons.facades.st_facade.generator.GenerationException;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.junit.XmlTestArgumentsSource;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.model.TestPlan;
import ee.taltech.cs.mbt.tdl.expression.tdl_model.expression_tree.structure.generic.TdlExpression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("TDL generator tests.")
public class TestTdlExpressionGenerator {
	private TdlExpressionGenerator exprGen;

	@BeforeEach
	void prepareForTest() {
		exprGen = TdlGeneratorFactory
				.getInstance()
				.expressionGenerator();
	}

	@DisplayName("Test whether TDL generator works correctly for structurally correct object structures.")
	@ParameterizedTest(name = "#[{index}] {1}: SExpr:`{2}` -> TDL:`{3}`.")
	@XmlTestArgumentsSource(path = "/TdlExpressionGeneratorValidStructureTests.xml")
	void testGeneratesStructurallyCorrectExpressions(
			TestPlan testPlan,
			String name,
			String input,
			String expectation
	) {
		testPlan.getInputTransformer().getConfigurableTransformers().get(0).setTransformFunction(
			expr -> {
				String exprStr = "";
				try {
					exprStr = exprGen.generate((TdlExpression) expr);
				} catch (GenerationException ex) {
					fail("Unable to generate TDL expression from `" + input + "`.", ex);
				}
				return exprStr;
			}
		);

		String actual = (String) testPlan.getInputTransformer().transform(input);
		String expected = (String) testPlan.getOutputTransformer().transform(expectation);
		assertEquals(expected, actual, getMsgSupplier(name, expected, actual));
	}

	private Supplier<String> getMsgSupplier(String name, String expectedStr, String actualStr) {
		return () -> "Test: " + name
				+ "\nExpected TDL expression: `" + expectedStr
				+ "`.\nActual TDL expression: `" + actualStr + "`.\n";
	}
}
