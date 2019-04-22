package ee.taltech.cs.mbt.tdl.interpreter.interpreter_cli;

public enum EReturnStatus {
	SUCCESS(0),
	INVALID_ARGUMENTS(1),
	EXPRESSION_PARSING_FAILED(2),
	MODEL_PARSING_FAILED(3),
	SCENARIO_COMPOSITION_FAILED(4),
	SCENARIO_SERIALIZATION_FAILED(5),
	UNEXPECTED_ERROR(-1);

	private int intValue;

	EReturnStatus(int intValue) {
		this.intValue = intValue;
	}

	public int intValue() {
		return intValue;
	}
}
