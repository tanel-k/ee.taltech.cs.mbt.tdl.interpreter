package ee.taltech.cs.mbt.tdl.interpreter.interpreter_core;

import java.io.ByteArrayInputStream;

public class Test {
	public static void main(String... args) {
		Interpreter.getInstance().interpret(
				Test.class.getResourceAsStream("/src/main/resources/SampleSystem.xml"),
				new ByteArrayInputStream(
						"E(TS1; TS2)".getBytes()
				),
				System.out
		);
	}
}
