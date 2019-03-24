package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion;

public class EmbeddedCodeParseException extends Exception {
	private String embeddedCode;

	public EmbeddedCodeParseException(String msg, Throwable t) {
		super(msg, t);
	}

	public EmbeddedCodeParseException(String msg, Throwable t, String embeddedCode) {
		super(msg, t);
		this.embeddedCode = embeddedCode;
	}

	public String getEmbeddedCode() {
		return embeddedCode;
	}

	public EmbeddedCodeParseException setEmbeddedCode(String embeddedCode) {
		this.embeddedCode = embeddedCode;
		return this;
	}
}
