package ee.taltech.cs.mbt.tdl.commons.test_utils.junit.junit_utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestContext {
	private final Mapper outputMapper;
	private final Mapper inputMapper;
	private List<TestCase> testCases = new LinkedList<>();

	public TestContext(Mapper inputMapper, Mapper outputMapper) {
		this.inputMapper = inputMapper;
		this.outputMapper = outputMapper;
	}

	public Mapper getOutputMapper() {
		return outputMapper;
	}

	public Mapper getInputMapper() {
		return inputMapper;
	}

	public List<TestCase> getTestCases() {
		return Collections.unmodifiableList(testCases);
	}

	public void addTestCase(TestCase testCase) {
		testCases.add(testCase);
		testCase.setTestContext(this);
	}
}
