package ee.taltech.cs.mbt.tdl.interpreter.interpreter_cli;

public enum EReturnStatus {
	SUCCESS(0),
	INVALID_ARGUMENTS(1),
	EXPRESSION_PARSING_FAILED(2),
	MODEL_PARSING_FAILED(3),
	SCENARIO_COMPOSITION_FAILED(4),
	SCENARIO_SERIALIZATION_FAILED(5),
	FILE_NOT_FOUND(6),
	UPPAAL_RUN_FAILURE(7),
	UNEXPECTED_ERROR(-1);

	private int value;

	EReturnStatus(int value) {
		this.value = value;
	}

	public int value() {
		return value;
	}
}
