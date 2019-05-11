package ee.taltech.cs.mbt.tdl.commons.sexpr.s_expression_parser;

public class SanityTest {
	private static final String[] testInputs = {
			"",
			"(\"whassaaap\")",
			"(\"blah\" . ())"
	};

	public static void main(String... args) {
		System.out.println("hello!");
		for (String str : testInputs) {
			try {
				SExpressionParser.getInstance().parseInput(str);
				System.out.println("OK!");
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}
}
