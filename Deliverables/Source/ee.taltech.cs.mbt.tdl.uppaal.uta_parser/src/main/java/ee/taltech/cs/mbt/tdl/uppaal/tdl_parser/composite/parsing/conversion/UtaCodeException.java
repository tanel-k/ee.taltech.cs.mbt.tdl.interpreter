package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite.parsing.conversion;

public class UtaCodeException extends Exception {
	private String embeddedCode;

	public UtaCodeException(String msg, Throwable t) {
		super(msg, t);
	}

	public UtaCodeException(String msg, Throwable t, String embeddedCode) {
		super(msg, t);
		this.embeddedCode = embeddedCode;
	}

	public String getEmbeddedCode() {
		return embeddedCode;
	}

	public UtaCodeException setEmbeddedCode(String embeddedCode) {
		this.embeddedCode = embeddedCode;
		return this;
	}
}
