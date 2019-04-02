package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite;

import ee.taltech.cs.mbt.tdl.common_utils.validation.ValidationError;
import ee.taltech.cs.mbt.tdl.common_utils.validation.ValidationResult;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.stream.Collectors;

public class InvalidSystemStructureException extends Exception {
	private List<String> errorMessages;

	public InvalidSystemStructureException(String msg, ValidationResult<?> validationResult) {
		super(msg);

		this.errorMessages = validationResult.getContextsWithErrors().values().stream()
				.flatMap(r -> r.getErrors().stream())
				.map(ValidationError::getErrorMessage)
				.collect(Collectors.toList());
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	@Override
	public String toString() {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		pw.println("System contains structural errors:");

		int i = 0;
		for (String errorMessage : getErrorMessages())
			pw.println("#" + (++i) + ": " + errorMessage);

		return sw.toString();
	}
}
