package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion.UtaCodeException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.UtaNodeMarshaller.UtaMarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.validation.ValidationResult;

public class UtaParseException extends Exception {
	public static UtaParseException wrap(ValidationResult validationResult) {
		return new UtaParseException().setStructureValidationResult(validationResult);
	}

	public static UtaParseException wrap(UtaMarshallingException ex) {
		return new UtaParseException(ex).setMarshallingException(ex);
	}

	public static UtaParseException wrap(UtaCodeException ex) {
		return new UtaParseException(ex).setUtaCodeException(ex);
	}

	private ValidationResult structureValidationResult;
	private UtaMarshallingException marshallingException;
	private UtaCodeException utaCodeException;

	private UtaParseException() { }
	private UtaParseException(Throwable t) {
		super(t);
	}

	public boolean hasMarshallingException() {
		return marshallingException != null;
	}

	public UtaMarshallingException getMarshallingException() {
		return marshallingException;
	}

	public UtaParseException setMarshallingException(UtaMarshallingException marshallingException) {
		this.marshallingException = marshallingException;
		return this;
	}

	public boolean hasEmbeddedCodeParseException() {
		return utaCodeException != null;
	}

	public UtaCodeException getUtaCodeException() {
		return utaCodeException;
	}

	public UtaParseException setUtaCodeException(UtaCodeException utaCodeException) {
		this.utaCodeException = utaCodeException;
		return this;
	}

	public boolean hasStructureException() {
		return structureValidationResult != null;
	}

	public ValidationResult getStructureValidationResult() {
		return structureValidationResult;
	}

	public UtaParseException setStructureValidationResult(ValidationResult structureValidationResult) {
		this.structureValidationResult = structureValidationResult;
		return this;
	}
}
