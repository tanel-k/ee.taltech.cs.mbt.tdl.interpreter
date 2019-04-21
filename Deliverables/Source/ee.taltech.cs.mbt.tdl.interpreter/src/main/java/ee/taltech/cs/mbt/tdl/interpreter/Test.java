package ee.taltech.cs.mbt.tdl.interpreter;

import java.io.ByteArrayInputStream;

public class Test {
	public static void main(String... args) {
		Interpreter.getInstance().interpret(
				Test.class.getResourceAsStream("/SampleSystem.xml"),
				new ByteArrayInputStream(
						"#[>=2](E(TS2; TS4) ~> U(TS2; TS3))".getBytes()
				),
				System.out
		);
	}
}
