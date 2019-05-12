package ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.junit;

import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.model.TestCase;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.model.TestPlan;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.ISimpleTransformer;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.SimpleTransformationPipeline;
import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.impl.ConfigurableTransformer;
import ee.taltech.cs.mbt.tdl.commons.utils.strings.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class TestPlanParser {
	private static final String STEP_TYPE_TRANSFORM = "transform";
	private static final String STEP_TYPE_CONFIGURED_TRANSFORM = "configuredTransform";

	private static final String ATTR_TRANSFORMER_CLASS = "transformerClass";
	private static final String ATTR_STEP_TYPE = "type";
	private static final String ATTR_TEST_CASE_NAME = "name";

	private static final String NODE_STEP = "Step";
	private static final String NODE_INPUT_PIPELINE = "InputPipeline";
	private static final String NODE_OUTPUT_PIPELINE = "OutputPipeline";
	private static final String NODE_PROVIDED_INPUT = "ProvidedInput";
	private static final String NODE_EXPECTED_OUTPUT = "ExpectedOutput";

	private static final String XPATH_CONFIGURATION_NODE = "/TestPlan/Configuration";
	private static final String XPATH_TEST_CASE_NODE = "/TestPlan/TestCases/TestCase";

	public static class TestPlanParseException extends Exception {
		public TestPlanParseException(Throwable t) {
			super(t);
		}
	}

	public static TestPlanParser getInstance() {
		return new TestPlanParser();
	}

	private TestPlanParser() { }

	private SimpleTransformationPipeline parsePipeline(Node root)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException
	{
		SimpleTransformationPipeline pipeline = new SimpleTransformationPipeline();
		List stepNodes = root.selectNodes(NODE_STEP);
		for (Object stepNodeObj : stepNodes) {
			Element stepNode = (Element) stepNodeObj;
			String stepType = stepNode.attributeValue(ATTR_STEP_TYPE);

			if (StringUtils.equalsIgnoreCase(stepType, STEP_TYPE_TRANSFORM)) {
				String transformerClass = stepNode.attributeValue(ATTR_TRANSFORMER_CLASS);
				Class<?> transformerCls = Class.forName(transformerClass);
				pipeline.addTransformer((ISimpleTransformer) transformerCls.newInstance());
			} else if (StringUtils.equalsIgnoreCase(stepType, STEP_TYPE_CONFIGURED_TRANSFORM)) {
				pipeline.addConfigurableTranformer(new ConfigurableTransformer());
			}
		}
		return pipeline;
	}

	public TestPlan parse(InputStream in) throws TestPlanParseException {
		try {
			SAXReader reader = new SAXReader();
			Document document = reader.read(in);

			Node root = document.getRootElement();
			Node configurationNode = root.selectSingleNode(XPATH_CONFIGURATION_NODE);

			Node inputPipelineNode = configurationNode.selectSingleNode(NODE_INPUT_PIPELINE);
			Node outputPipelineNode = configurationNode.selectSingleNode(NODE_OUTPUT_PIPELINE);

			SimpleTransformationPipeline inputPipeline = parsePipeline(inputPipelineNode);
			SimpleTransformationPipeline outputPipeline = parsePipeline(outputPipelineNode);

			List testCaseNodes = root.selectNodes(XPATH_TEST_CASE_NODE);
			TestPlan testPlan = new TestPlan(inputPipeline, outputPipeline);
			for (Object testCase : testCaseNodes) {
				Node testCaseNode = (Node) testCase;
				String name = ((Element) testCaseNode).attributeValue(ATTR_TEST_CASE_NAME);

				String providedInputAsString = testCaseNode.selectSingleNode(NODE_PROVIDED_INPUT).getText();
				String expectedOutputAsString = testCaseNode.selectSingleNode(NODE_EXPECTED_OUTPUT).getText();
				providedInputAsString = StringUtils.trimAndNormalizeWS(providedInputAsString);
				expectedOutputAsString = StringUtils.trimAndNormalizeWS(expectedOutputAsString);

				testPlan.addTestCase(new TestCase(name, providedInputAsString, expectedOutputAsString));
			}
			return testPlan;
		} catch (Throwable t) {
			throw new TestPlanParseException(t);
		}
	}
}
