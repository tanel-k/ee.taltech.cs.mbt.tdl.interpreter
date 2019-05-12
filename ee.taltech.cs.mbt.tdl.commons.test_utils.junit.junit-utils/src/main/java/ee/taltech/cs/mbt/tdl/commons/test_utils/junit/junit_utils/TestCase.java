package ee.taltech.cs.mbt.tdl.commons.test_utils.junit.junit_utils;

public class TestCase {
	private final String name;
	private final String providedInputString;
	private final String expectedOutputString;
	private TestContext testContext;

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

	public TestContext getTestContext() {
		return testContext;
	}

	void setTestContext(TestContext parent) {
		this.testContext = parent;
	}
}
