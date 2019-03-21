package ee.taltech.cs.mbt.tdl.uppaal.tdl_parser.composite;

public class UTASystemParseException extends Exception {
	public UTASystemParseException() { }

	public UTASystemParseException(Throwable t) { super(t); }

	public UTASystemParseException(String msg) { super(msg); }

	public UTASystemParseException(String msg, Throwable t) { super(msg, t); }
}
