package ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.junit;

import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.TestPlanParser;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.model.TestPlan;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.io.InputStream;
import java.util.stream.Stream;

public class XmlTestArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<XmlTestArgumentsSource> {
	private String path;

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
		InputStream inputStream = extensionContext.getRequiredTestClass().getResourceAsStream(path);
		TestPlan testPlan = TestPlanParser.getInstance().parse(inputStream);

		return testPlan.getTestCases().stream()
				.map(testCase -> Arguments.of(
						testPlan,
						testCase.getName(),
						testCase.getProvidedInputString(),
						testCase.getExpectedOutputString())
				);
	}

	@Override
	public void accept(XmlTestArgumentsSource xmlTestArgumentsSource) {
		path = xmlTestArgumentsSource.path();
	}
}
