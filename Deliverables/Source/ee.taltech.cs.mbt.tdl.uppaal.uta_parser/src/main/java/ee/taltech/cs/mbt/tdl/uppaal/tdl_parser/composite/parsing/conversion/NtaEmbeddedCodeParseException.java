package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion;

public class NtaEmbeddedCodeParseException extends Exception {
	private String embeddedCode;

	public NtaEmbeddedCodeParseException(String msg, Throwable t) {
		super(msg, t);
	}

	public NtaEmbeddedCodeParseException(String msg, Throwable t, String embeddedCode) {
		super(msg, t);
		this.embeddedCode = embeddedCode;
	}

	public String getEmbeddedCode() {
		return embeddedCode;
	}

	public NtaEmbeddedCodeParseException setEmbeddedCode(String embeddedCode) {
		this.embeddedCode = embeddedCode;
		return this;
	}
}
