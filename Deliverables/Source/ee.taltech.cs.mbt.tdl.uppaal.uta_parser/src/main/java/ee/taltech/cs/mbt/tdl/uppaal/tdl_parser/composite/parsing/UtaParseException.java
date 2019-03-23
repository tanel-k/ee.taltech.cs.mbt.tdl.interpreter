package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing;

import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion.NtaEmbeddedCodeParseException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.structure.NtaMarshaller.NtaMarshallingException;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.validation.ValidationError;
import ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.validation.ValidationResult;

import java.util.Iterator;

public class UtaParseException extends Exception {
	public static UtaParseException wrap(ValidationResult validationResult) {
		return new UtaParseException().setStructureValidationResult(validationResult);
	}

	public static UtaParseException wrap(NtaMarshallingException ex) {
		return new UtaParseException(ex).setMarshallingException(ex);
	}

	public static UtaParseException wrap(NtaEmbeddedCodeParseException ex) {
		return new UtaParseException(ex).setEmbeddedCodeParseException(ex);
	}

	private ValidationResult structureValidationResult;
	private NtaMarshallingException marshallingException;
	private NtaEmbeddedCodeParseException embeddedCodeParseException;

	private UtaParseException() { }
	private UtaParseException(Throwable t) {
		super(t);
	}

	public boolean hasMarshallingException() {
		return marshallingException != null;
	}

	public NtaMarshallingException getMarshallingException() {
		return marshallingException;
	}

	public UtaParseException setMarshallingException(NtaMarshallingException marshallingException) {
		this.marshallingException = marshallingException;
		return this;
	}

	public boolean hasEmbeddedCodeParseException() {
		return embeddedCodeParseException != null;
	}

	public NtaEmbeddedCodeParseException getEmbeddedCodeParseException() {
		return embeddedCodeParseException;
	}

	public UtaParseException setEmbeddedCodeParseException(NtaEmbeddedCodeParseException embeddedCodeParseException) {
		this.embeddedCodeParseException = embeddedCodeParseException;
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
