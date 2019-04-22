package ee.taltech.cs.mbt.tdl.interpreter.interpreter_core;

import java.io.ByteArrayInputStream;

public class Test {
	public static void main(String... args) {
		// A(TS2;TS4) ~> E(TS2;TS3): U(TS2;TS4) ~> E(TS2;TS3)
		// #(E(TS2;TS4) ~> A(TS2;TS3)) >= 2: #[>=2](E(TS2;TS4) ~> U(TS2;TS3))
		TdlInterpreter.getInstance().interpret(
				Test.class.getResourceAsStream("/SampleSystem.xml"),
				new ByteArrayInputStream(
						"#[>=2](E(TS2;TS4) ~> U(TS2;TS3))".getBytes()
				),
				System.out
		);
	}
}
