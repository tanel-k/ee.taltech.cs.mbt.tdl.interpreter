package ee.taltech.cs.mbt.tdl.commons.test_utils.junit.junit_utils;

import ee.taltech.cs.mbt.tdl.commons.utils.strings.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Stream;

public class XmlTestArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<XmlTestArgumentsSource> {
	private String path;

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
		InputStream inputStream = extensionContext.getRequiredTestClass().getResourceAsStream(path);
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);

		Node root = document.getRootElement();
		Node configurationNode = root.selectSingleNode("/TestPlan/Configuration");

		String inputMapperClass = configurationNode.selectSingleNode("InputMapperClass").getText();
		String outputMapperClass = configurationNode.selectSingleNode("OutputMapperClass").getText();

		Class<?> inputMapperCls = Class.forName(inputMapperClass);
		Class<?> outputMapperCls = Class.forName(outputMapperClass);

		Mapper inputMapper = (Mapper) inputMapperCls.newInstance();
		Mapper outputMapper = (Mapper) outputMapperCls.newInstance();

		List testCaseNodes = root.selectNodes("/TestPlan/TestCases/TestCase");
		TestContext testContext = new TestContext(inputMapper, outputMapper);
		for (Object testCase : testCaseNodes) {
			Node testCaseNode = (Node) testCase;
			String name = ((Element) testCaseNode).attributeValue("name");

			String providedInputAsString = testCaseNode.selectSingleNode("ProvidedInput").getText();
			String expectedOutputAsString = testCaseNode.selectSingleNode("ExpectedOutput").getText();
			providedInputAsString = StringUtils.trimAndNormalizeWS(providedInputAsString);
			expectedOutputAsString = StringUtils.trimAndNormalizeWS(expectedOutputAsString);

			testContext.addTestCase(new TestCase(name, providedInputAsString, expectedOutputAsString));
		}

		return testContext.getTestCases().stream()
				.map(testCase -> Arguments.of(
						testContext,
						testCase,
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
