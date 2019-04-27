package ee.taltech.cs.mbt.tdl.user_interface.user_interface_cli;

public enum EReturnStatus {
	SUCCESS(0),
	INVALID_ARGUMENTS(1),
	EXPRESSION_PARSING_FAILED(2),
	MODEL_PARSING_FAILED(3),
	SCENARIO_COMPOSITION_FAILED(4),
	SCENARIO_SERIALIZATION_FAILED(5),
	FILE_NOT_FOUND(6),
	FILE_WRITE_ERROR(7),
	UPPAAL_RUN_FAILURE(8),
	UNEXPECTED_ERROR(-1);

	private int value;

	EReturnStatus(int value) {
		this.value = value;
	}

	public int value() {
		return value;
	}
}
