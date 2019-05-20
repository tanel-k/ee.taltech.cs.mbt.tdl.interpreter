package ee.taltech.cs.mbt.tdl.commons.test.test_utils.test_plan.model;

public class TestCase {
	private final String name;
	private final String providedInputString;
	private final String expectedOutputString;
	private TestPlan testPlan;

	public TestCase(String name, String providedInputString, String expectedOutputString) {
		this.name = name;
		this.providedInputString = providedInputString;
		this.expectedOutputString = expectedOutputString;
	}

	public String getName() {
		return name;
	}

	public String getProvidedInputString() {
		return providedInputString;
	}

	public String getExpectedOutputString() {
		return expectedOutputString;
	}

	public TestPlan getTestPlan() {
		return testPlan;
	}

	void setTestPlan(TestPlan parent) {
		this.testPlan = parent;
	}
}
