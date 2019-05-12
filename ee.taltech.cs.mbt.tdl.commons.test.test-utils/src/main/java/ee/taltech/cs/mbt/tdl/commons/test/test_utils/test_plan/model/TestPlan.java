package ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.model;

import ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.pipeline.SimpleTransformationPipeline;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestPlan {
	private final SimpleTransformationPipeline inputTransformer;
	private final SimpleTransformationPipeline outputTransformer;

	private List<TestCase> testCases = new LinkedList<>();

	public TestPlan(SimpleTransformationPipeline inputTransformer, SimpleTransformationPipeline outputTransformer) {
		this.inputTransformer = inputTransformer;
		this.outputTransformer = outputTransformer;
	}

	public SimpleTransformationPipeline getOutputTransformer() {
		return outputTransformer;
	}

	public SimpleTransformationPipeline getInputTransformer() {
		return inputTransformer;
	}

	public List<TestCase> getTestCases() {
		return Collections.unmodifiableList(testCases);
	}

	public void addTestCase(TestCase testCase) {
		testCases.add(testCase);
		testCase.setTestPlan(this);
	}
}
